package org.sizzle.dd.core;

import org.openide.util.lookup.ServiceProvider;
import org.sizzle.dd.core.properties.LevelProperty;
import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.dd.core.properties.AbilityScoreProperty;
import org.sizzle.dd.core.properties.AgeProperty;
import org.sizzle.dd.core.properties.ExperienceProperty;
import org.sizzle.dd.core.properties.GenderProperty;
import org.sizzle.dd.core.properties.HeightProperty;
import org.sizzle.dd.core.properties.NameProperty;
import org.sizzle.dd.core.properties.PlayerNameProperty;
import org.sizzle.dd.core.properties.WeightProperty;
import org.sizzle.rpg.core.AbstractAvatar;

/**
 *
 * @author Jason
 */
@ServiceProvider(service = AbstractAvatar.class)
public class Avatar extends AbstractAvatar {

    @SuppressWarnings("unchecked")
    public Avatar() {
        // Add basic information
        this.addProperties(
                new PlayerNameProperty()
                ,new NameProperty()
                ,new GenderProperty());
        this.addProperties(
                new ExperienceProperty()
                ,new LevelProperty());
        this.addProperties(new HeightProperty());
        this.addProperties(new WeightProperty());
        this.addProperties(new AgeProperty());
        
        // Add ability set
        AbilityScoreProperty strScore = new AbilityScoreProperty(AbilityScoreProperty.SLUG.STRENGTH_SCORE);
        AbilityScoreProperty conScore = new AbilityScoreProperty(AbilityScoreProperty.SLUG.CONSTITUTION_SCORE);
        AbilityScoreProperty dexScore = new AbilityScoreProperty(AbilityScoreProperty.SLUG.DEXTERITY_SCORE);
        AbilityScoreProperty intScore = new AbilityScoreProperty(AbilityScoreProperty.SLUG.INTELLIGENCE_SCORE);
        AbilityScoreProperty wisScore = new AbilityScoreProperty(AbilityScoreProperty.SLUG.WISDOM_SCORE);
        AbilityScoreProperty chaScore = new AbilityScoreProperty(AbilityScoreProperty.SLUG.CHARISMA_SCORE);
        strScore.aliases.add("Strength");
        conScore.aliases.add("Constitution");
        dexScore.aliases.add("Dexterity");
        intScore.aliases.add("Intelligence");
        wisScore.aliases.add("Wisdom");
        chaScore.aliases.add("Charisma");
        
        AbilityModifierProperty strModifier = new AbilityModifierProperty(AbilityModifierProperty.SLUG.STRENGTH_MODIFIER);
        AbilityModifierProperty conModifier = new AbilityModifierProperty(AbilityModifierProperty.SLUG.CONSTITUTION_MODIFIER);
        AbilityModifierProperty dexModifier = new AbilityModifierProperty(AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER);
        AbilityModifierProperty intModifier = new AbilityModifierProperty(AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER);
        AbilityModifierProperty wisModifier = new AbilityModifierProperty(AbilityModifierProperty.SLUG.WISDOM_MODIFIER);
        AbilityModifierProperty chaModifier = new AbilityModifierProperty(AbilityModifierProperty.SLUG.CHARISMA_MODIFIER);
        
        strScore.addObserver(strModifier);
        strScore.addObserver(strModifier);
        conScore.addObserver(conModifier);
        dexScore.addObserver(dexModifier);
        intScore.addObserver(intModifier);
        wisScore.addObserver(wisModifier);
        chaScore.addObserver(chaModifier);
        
        this.addProperties(strScore, conScore, dexScore, intScore, wisScore, chaScore);
        this.addProperties(strModifier, conModifier, dexModifier, intModifier, wisModifier, chaModifier);
        
    }
}
