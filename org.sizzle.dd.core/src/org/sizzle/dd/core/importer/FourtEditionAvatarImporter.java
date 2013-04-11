package org.sizzle.dd.core.importer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.AvatarRace;
import org.sizzle.dd.core.modifier.AbilityScoreLevelIncreaseModifier;
import org.sizzle.dd.core.modifier.InitialAbilityScoreModifier;
import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.dd.core.properties.AbilityScoreProperty;
import org.sizzle.dd.core.properties.AgeProperty;
import org.sizzle.dd.core.properties.ExperienceProperty;
import org.sizzle.dd.core.properties.HeightProperty;
import org.sizzle.dd.core.properties.LevelProperty;
import org.sizzle.dd.core.properties.NameProperty;
import org.sizzle.dd.core.properties.PlayerNameProperty;
import org.sizzle.dd.core.properties.RaceProperty;
import org.sizzle.dd.core.properties.WeightProperty;
import org.sizzle.rpg.core.AbstractAvatar;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.importer.AvatarImporter;
import org.sizzle.rpg.core.model.IModifier;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jason
 */
@ServiceProvider(service = AvatarImporter.class)
public class FourtEditionAvatarImporter extends AvatarImporter {

    @Override
    public void process(IAvatar avatar, Document document) {

        // clear all properties
        avatar.removeAllProperties();
        //clearAbilities(Avatar.class.cast(avatar));
        
//        RaceProperty raceProperty = avatar.find(RaceProperty.class);
//        if(raceProperty!=null)
//            avatar.removeProperty(raceProperty);
        
        setDetails(Avatar.class.cast(avatar), document);
        setAbilityScores(Avatar.class.cast(avatar), document);
        // add ability modifiers
        avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.STRENGTH_MODIFIER));
        avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.CONSTITUTION_MODIFIER));
        avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER));
        avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER));
        avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.WISDOM_MODIFIER));
        avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.CHARISMA_MODIFIER));
        
        setRace(Avatar.class.cast(avatar), document);
        
        Collection<? extends AvatarUserInterfaceConfigurer> avatarUIConfigurers = Lookup.getDefault().lookupAll(AvatarUserInterfaceConfigurer.class);
        if (Avatar.class.isInstance(avatar))
            for (AvatarUserInterfaceConfigurer avatarUIConfigurer : avatarUIConfigurers) {
                avatarUIConfigurer.configure(Avatar.class.cast(avatar));
            }
        
    }
    
    private void setDetails(Avatar avatar, Document doc) {
        NameProperty avatarNameProperty = new NameProperty();
        avatarNameProperty.setValue("My Name");
        avatar.addProperty(avatarNameProperty);
        
        PlayerNameProperty avatarPlayerNameProperty = new PlayerNameProperty();
        avatarPlayerNameProperty.setValue("Jason");
        avatar.addProperty(avatarPlayerNameProperty);
        
        AgeProperty avatarAgeProperty = new AgeProperty();
        avatarAgeProperty.setValue(142F);
        avatar.addProperty(avatarAgeProperty);
        
        HeightProperty avatarHeightProperty = new HeightProperty();
        avatarHeightProperty.setValue("6\' 9\"");
        avatar.addProperty(avatarHeightProperty);
        
        WeightProperty avatarWeightProperty = new WeightProperty();
        avatarWeightProperty.setValue(170);
        avatar.addProperty(avatarWeightProperty);
        
        LevelProperty avatarLevelProperty = new LevelProperty();
        ExperienceProperty avatarExperienceProperty = new ExperienceProperty();
        
        avatarExperienceProperty.addObserver(avatarLevelProperty);
        avatar.addProperty(avatarLevelProperty);
        
        Node experienceNode = doc.getElementsByTagName("Experience").item(0);
        if (null!=experienceNode) {
            String experienceContent = experienceNode.getTextContent();
            Integer experience;
            if (!experienceContent.trim().isEmpty()) {
                try {
                    experience = Integer.parseInt(experienceContent.trim());
                    avatarExperienceProperty.setValue(experience);
                } catch (NumberFormatException numberFormatException) {
                    throw numberFormatException;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void clearAbilities(AbstractAvatar avatar) {
        for (AbilityScoreProperty score : avatar.getLookup().lookupAll(AbilityScoreProperty.class)) {
            score.unsetValue();
            for (IModifier<?> mod : score.getLookup().lookupAll(IModifier.class)) {
                score.removeModifier((IModifier<Integer>) mod);
            }
        }
        for (AbilityModifierProperty modifier : avatar.getLookup().lookupAll(AbilityModifierProperty.class)) {
            modifier.unsetValue();
            for (IModifier<?> mod : modifier.getLookup().lookupAll(IModifier.class)) {
                modifier.removeModifier((IModifier<Integer>) mod);
            }
        }
    }

    private void setAbilityScores(AbstractAvatar avatar, Document doc) {
        AbilityScoreProperty str = AbilityScoreProperty.class.cast(avatar.<Integer>find(AbilityScoreProperty.SLUG.STRENGTH_SCORE));
        if (null==str) {
            str = new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.STRENGTH_SCORE, "Strength");
            avatar.addProperty(str);
        }
        str.addModifier(new InitialAbilityScoreModifier(Integer.parseInt(doc.getElementsByTagName("Strength").item(0).getAttributes().getNamedItem("score").getNodeValue())));
        
        AbilityScoreProperty conScoreProperty = AbilityScoreProperty.class.cast(avatar.<Integer>find(AbilityScoreProperty.SLUG.CONSTITUTION_SCORE));
        if (null==conScoreProperty) {
            conScoreProperty = new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.CONSTITUTION_SCORE, "Constitution");
            avatar.addProperty(conScoreProperty);
        }
        conScoreProperty.addModifier(new InitialAbilityScoreModifier(Integer.parseInt(doc.getElementsByTagName("Constitution").item(0).getAttributes().getNamedItem("score").getNodeValue())));
        
        AbilityScoreProperty dexScoreProperty = AbilityScoreProperty.class.cast(avatar.<Integer>find(AbilityScoreProperty.SLUG.DEXTERITY_SCORE));
        if (null==dexScoreProperty) {
            dexScoreProperty = new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.DEXTERITY_SCORE, "Dexterity");
            avatar.addProperty(dexScoreProperty);
        }
        dexScoreProperty.addModifier(new InitialAbilityScoreModifier(Integer.parseInt(doc.getElementsByTagName("Dexterity").item(0).getAttributes().getNamedItem("score").getNodeValue())));
        
        AbilityScoreProperty intScoreProperty = AbilityScoreProperty.class.cast(avatar.<Integer>find(AbilityScoreProperty.SLUG.INTELLIGENCE_SCORE));
        if (null==intScoreProperty) {
            intScoreProperty = new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.INTELLIGENCE_SCORE, "Intelligence");
            avatar.addProperty(intScoreProperty);
        }
        intScoreProperty.addModifier(new InitialAbilityScoreModifier(Integer.parseInt(doc.getElementsByTagName("Intelligence").item(0).getAttributes().getNamedItem("score").getNodeValue())));
        
        AbilityScoreProperty wisScoreProperty = AbilityScoreProperty.class.cast(avatar.<Integer>find(AbilityScoreProperty.SLUG.WISDOM_SCORE));
        if (null==wisScoreProperty) {
            wisScoreProperty = new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.WISDOM_SCORE, "Wisdom");
            avatar.addProperty(wisScoreProperty);
        }
        wisScoreProperty.addModifier(new InitialAbilityScoreModifier(Integer.parseInt(doc.getElementsByTagName("Wisdom").item(0).getAttributes().getNamedItem("score").getNodeValue())));
        
        AbilityScoreProperty chaScoreProperty = AbilityScoreProperty.class.cast(avatar.<Integer>find(AbilityScoreProperty.SLUG.CHARISMA_SCORE));
        if (null==chaScoreProperty) {
            chaScoreProperty = new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.CHARISMA_SCORE, "Charisma");
            avatar.addProperty(chaScoreProperty);
        }
        chaScoreProperty.addModifier(new InitialAbilityScoreModifier(Integer.parseInt(doc.getElementsByTagName("Charisma").item(0).getAttributes().getNamedItem("score").getNodeValue())));
        
        NodeList ruleNodes, levelNodes = doc.getElementsByTagName("Level");
        List<String> abilityIncreaseNodes = new ArrayList<>(0);
        Node node;
        for (int i = 0; i < levelNodes.getLength(); i++) {
            node = levelNodes.item(i);
            ruleNodes = Element.class.cast(node).getElementsByTagName("RulesElement");
            for (int j = 0; j < ruleNodes.getLength(); j++) {
                node = ruleNodes.item(j);
                Element e = Element.class.cast(node);
                if (e.hasAttribute("type") && e.getAttribute("type").matches("Ability Increase.*")) {
                    abilityIncreaseNodes.add(e.getAttribute("name"));
                }
            }
        }
//
        for(String abilityIncreaseNode : abilityIncreaseNodes)
            avatar.<Integer>find(abilityIncreaseNode).addModifier(new AbilityScoreLevelIncreaseModifier());
    }

    private void setRace(Avatar avatar, Document doc) {
        // Query the Rules elements
        NodeList ruleElementList = doc.getElementsByTagName("RulesElement");
        Node ruleElement;
        HashSet<String> raceNodes = new HashSet<>(0);
        for (int i = 0; i < ruleElementList.getLength(); i++) {
            ruleElement = ruleElementList.item(i);
            if(ruleElement.hasAttributes()) {
                Node nameNode = ruleElement.getAttributes().getNamedItem("name");
                Node typeNode = ruleElement.getAttributes().getNamedItem("type");
                if (nameNode!=null 
                        && !nameNode.getNodeValue().isEmpty() 
                        && typeNode != null 
                        && typeNode.getNodeValue().matches("Race")
                        && !raceNodes.contains(nameNode.getNodeValue())) {
                    raceNodes.add(nameNode.getNodeValue());
                }
            }
        }
        // Find race in global lookup
        Lookup.Result<AvatarRace> loadedRaceResults = Lookup.getDefault().lookupResult(AvatarRace.class);
        for (String race : raceNodes) {
            boolean raceFound = false;
            for (AvatarRace item : loadedRaceResults.allInstances()) {
                if (item.name.contentEquals(race)) {
                    raceFound = true;
                    avatar.addProperty(new RaceProperty(item));
                }
            }
            if (!raceFound) {
                System.err.println("Race Not Loaded From Import: " + race);
            }
        }
    }
}
