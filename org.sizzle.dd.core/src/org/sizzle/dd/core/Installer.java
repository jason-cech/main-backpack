/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core;

import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;
import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.dd.core.properties.AbilityScoreProperty;
import org.sizzle.dd.core.properties.AgeProperty;
import org.sizzle.dd.core.properties.ArmorClassProperty;
import org.sizzle.dd.core.properties.ClassProperty;
import org.sizzle.dd.core.properties.ExperienceProperty;
import org.sizzle.dd.core.properties.FortitudeProperty;
import org.sizzle.dd.core.properties.HealthProperty;
import org.sizzle.dd.core.properties.HeightProperty;
import org.sizzle.dd.core.properties.LevelProperty;
import org.sizzle.dd.core.properties.NameProperty;
import org.sizzle.dd.core.properties.PlayerNameProperty;
import org.sizzle.dd.core.properties.ReflexProperty;
import org.sizzle.dd.core.properties.WeightProperty;
import org.sizzle.dd.core.properties.WillProperty;
import org.sizzle.dd.core.skills.AcrobatSkill;

public class Installer extends ModuleInstall {

	@Override
	public void restored() {
		// Find the Avatar that is registered as a Service
		Avatar avatar = Lookup.getDefault().lookup(Avatar.class);
		
		// Start wiring up the avatar's known D&D Core properties and modifiers
		// Add the core information properties
		PlayerNameProperty avatarPlayerNameProperty = new PlayerNameProperty();
		avatarPlayerNameProperty.setValue("Jason");
		avatar.addProperty(avatarPlayerNameProperty);

		ClassProperty avatarClassProperty = new ClassProperty();
		avatarClassProperty.setValue(null);
		avatar.addProperty(avatarClassProperty);
		
		HealthProperty avatarHealthProperty = new HealthProperty();
		avatar.addProperty(avatarHealthProperty);
		
		NameProperty avatarNameProperty = new NameProperty();
		avatarNameProperty.setValue("My Name");
		avatar.addProperty(avatarNameProperty);

		AgeProperty avatarAgeProperty = new AgeProperty();
		avatarAgeProperty.setValue(142F);
		avatar.addProperty(avatarAgeProperty);

		HeightProperty avatarHeightProperty = new HeightProperty();
		avatarHeightProperty.setValue("6\' 9\"");
		avatar.addProperty(avatarHeightProperty);

		WeightProperty avatarWeightProperty = new WeightProperty();
		avatarWeightProperty.setValue(170.0);
		avatar.addProperty(avatarWeightProperty);

		LevelProperty avatarLevelProperty = new LevelProperty();
		ExperienceProperty avatarExperienceProperty = new ExperienceProperty();

		avatarExperienceProperty.addObserver(avatarLevelProperty);
		avatarExperienceProperty.setValue(0);
		avatar.addProperty(avatarLevelProperty);
		avatar.addProperty(avatarExperienceProperty);
		
		// Add the 6 core ability score properties
		if (!avatar.hasProperty(AbilityScoreProperty.SLUG.STRENGTH_SCORE))			avatar.addProperty(new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.STRENGTH_SCORE));
		if (!avatar.hasProperty(AbilityScoreProperty.SLUG.CONSTITUTION_SCORE))	avatar.addProperty(new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.CONSTITUTION_SCORE));
		if (!avatar.hasProperty(AbilityScoreProperty.SLUG.DEXTERITY_SCORE))			avatar.addProperty(new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.DEXTERITY_SCORE));
		if (!avatar.hasProperty(AbilityScoreProperty.SLUG.INTELLIGENCE_SCORE))	avatar.addProperty(new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.INTELLIGENCE_SCORE));
		if (!avatar.hasProperty(AbilityScoreProperty.SLUG.WISDOM_SCORE))				avatar.addProperty(new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.WISDOM_SCORE));
		if (!avatar.hasProperty(AbilityScoreProperty.SLUG.CHARISMA_SCORE))			avatar.addProperty(new AbilityScoreProperty(avatar, AbilityScoreProperty.SLUG.CHARISMA_SCORE));
		
		// Add the 6 core ability modifier properties
		if (!avatar.hasProperty(AbilityModifierProperty.SLUG.STRENGTH_MODIFIER))avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.STRENGTH_MODIFIER));
		if (!avatar.hasProperty(AbilityModifierProperty.SLUG.CONSTITUTION_MODIFIER))avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.CONSTITUTION_MODIFIER));
		if (!avatar.hasProperty(AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER))avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER));
		if (!avatar.hasProperty(AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER))avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER));
		if (!avatar.hasProperty(AbilityModifierProperty.SLUG.WISDOM_MODIFIER))avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.WISDOM_MODIFIER));
		if (!avatar.hasProperty(AbilityModifierProperty.SLUG.CHARISMA_MODIFIER))avatar.addProperty(new AbilityModifierProperty(avatar, AbilityModifierProperty.SLUG.CHARISMA_MODIFIER));

		// Add the 4 core defense properties
		if (!avatar.hasProperty(ArmorClassProperty.SLUG))avatar.addProperty(new ArmorClassProperty(avatar));
		if (!avatar.hasProperty(FortitudeProperty.SLUG))avatar.addProperty(new FortitudeProperty(avatar));
		if (!avatar.hasProperty(ReflexProperty.SLUG))avatar.addProperty(new ReflexProperty(avatar));
		if (!avatar.hasProperty(WillProperty.SLUG))avatar.addProperty(new WillProperty(avatar));
		
		// Add the x core skill properties
		if (!avatar.hasProperty(AcrobatSkill.SLUG))avatar.addProperty(new AcrobatSkill(avatar, AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER));
	}
}
