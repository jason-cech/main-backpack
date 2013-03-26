package org.sizzle.dd.core;

import org.openide.util.lookup.ServiceProvider;
import org.sizzle.dd.core.modifier.InitialAbilityScoreModifier;
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
        this.addProperty(new AbilityScoreProperty("strength_score"));
        this.addProperty(new AbilityModifierProperty("strength_modifier"));
        this.addProperty(new AbilityScoreProperty("constitution_score"));
        this.addProperty(new AbilityModifierProperty("constitution_modifier"));
        this.addProperty(new AbilityScoreProperty("dexterity_score"));
        this.addProperty(new AbilityModifierProperty("dexterity_modifier"));
        this.addProperty(new AbilityScoreProperty("intelligence_score"));
        this.addProperty(new AbilityModifierProperty("intelligence_modifier"));
        this.addProperty(new AbilityScoreProperty("wisdom_score"));
        this.addProperty(new AbilityModifierProperty("wisdom_modifier"));
        this.addProperty(new AbilityScoreProperty("charisma_score"));
        this.addProperty(new AbilityModifierProperty("charisma_modifier"));
        
        this.<Integer>find("strength_score").getModifiers().add(new InitialAbilityScoreModifier(11));
    }
}
