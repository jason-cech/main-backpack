/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core;

import org.sizzle.dd.core.properties.CharismaAbilityModifierProperty;
import org.sizzle.dd.core.properties.WisdomAbilityScoreProperty;
import org.sizzle.dd.core.properties.IntelligenceAbilityScoreProperty;
import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;
import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.dd.core.properties.AgeProperty;
import org.sizzle.dd.core.properties.ArmorClassProperty;
import org.sizzle.dd.core.properties.CharismaAbilityScoreProperty;
import org.sizzle.dd.core.properties.ClassProperty;
import org.sizzle.dd.core.properties.ConstitutionAbilityModifierProperty;
import org.sizzle.dd.core.properties.ConstitutionAbilityScoreProperty;
import org.sizzle.dd.core.properties.DexterityAbilityModifierProperty;
import org.sizzle.dd.core.properties.DexterityAbilityScoreProperty;
import org.sizzle.dd.core.properties.ExperienceProperty;
import org.sizzle.dd.core.properties.FortitudeProperty;
import org.sizzle.dd.core.properties.HealthProperty;
import org.sizzle.dd.core.properties.HeightProperty;
import org.sizzle.dd.core.properties.IntelligenceAbilityModifierProperty;
import org.sizzle.dd.core.properties.LevelProperty;
import org.sizzle.dd.core.properties.NameProperty;
import org.sizzle.dd.core.properties.PlayerNameProperty;
import org.sizzle.dd.core.properties.ReflexProperty;
import org.sizzle.dd.core.properties.StrengthAbilityModifierProperty;
import org.sizzle.dd.core.properties.StrengthAbilityScoreProperty;
import org.sizzle.dd.core.properties.WeightProperty;
import org.sizzle.dd.core.properties.WillProperty;
import org.sizzle.dd.core.properties.WisdomAbilityModifierProperty;
import org.sizzle.dd.core.skills.AcrobatSkill;
import org.sizzle.dd.core.skills.ArcanaSkill;
import org.sizzle.dd.core.skills.AthleticSkill;
import org.sizzle.dd.core.skills.BluffSkill;
import org.sizzle.dd.core.skills.DiplomacySkill;
import org.sizzle.dd.core.skills.DungeoneeringSkill;
import org.sizzle.dd.core.skills.EnduranceSkill;
import org.sizzle.dd.core.skills.HealSkill;
import org.sizzle.dd.core.skills.HistorySkill;
import org.sizzle.dd.core.skills.InsightSkill;
import org.sizzle.dd.core.skills.IntimidateSkill;
import org.sizzle.dd.core.skills.NatureSkill;
import org.sizzle.dd.core.skills.PerceptionSkill;
import org.sizzle.dd.core.skills.ReligionSkill;
import org.sizzle.dd.core.skills.StealthSkill;
import org.sizzle.dd.core.skills.StreetwiseSkill;
import org.sizzle.dd.core.skills.ThieverySkill;

public class Installer extends ModuleInstall {

	@Override
	public void restored() {
		// Find the Avatar that is registered as a Service
		Avatar avatar = Lookup.getDefault().lookup(Avatar.class);
		
		// Start wiring up the avatar's known D&D Core properties and modifiers
		// Add the core information properties
		PlayerNameProperty avatarPlayerNameProperty = new PlayerNameProperty(avatar);
		avatarPlayerNameProperty.setValue("Jason");
		avatar.addProperty(avatarPlayerNameProperty);

		ClassProperty avatarClassProperty = new ClassProperty(avatar);
		avatarClassProperty.setValue(null);
		avatar.addProperty(avatarClassProperty);
		
		HealthProperty avatarHealthProperty = new HealthProperty(avatar);
		avatar.addProperty(avatarHealthProperty);
		
		NameProperty avatarNameProperty = new NameProperty(avatar);
		avatarNameProperty.setValue("My Name");
		avatar.addProperty(avatarNameProperty);

		AgeProperty avatarAgeProperty = new AgeProperty(avatar);
		avatarAgeProperty.setValue(142F);
		avatar.addProperty(avatarAgeProperty);

		HeightProperty avatarHeightProperty = new HeightProperty(avatar);
		avatarHeightProperty.setValue("6\' 9\"");
		avatar.addProperty(avatarHeightProperty);

		WeightProperty avatarWeightProperty = new WeightProperty(avatar);
		avatarWeightProperty.setValue(170.0);
		avatar.addProperty(avatarWeightProperty);

		LevelProperty avatarLevelProperty = new LevelProperty(avatar);
		ExperienceProperty avatarExperienceProperty = new ExperienceProperty(avatar);

		avatarExperienceProperty.addObserver(avatarLevelProperty);
		avatarExperienceProperty.setValue(0);
		avatar.addProperty(avatarLevelProperty);
		avatar.addProperty(avatarExperienceProperty);
		
		// Add the 6 core ability score properties
		if (!avatar.hasProperty(StrengthAbilityScoreProperty.class))			avatar.addProperty(new StrengthAbilityScoreProperty(avatar));
		if (!avatar.hasProperty(ConstitutionAbilityScoreProperty.class))	avatar.addProperty(new ConstitutionAbilityScoreProperty(avatar));
		if (!avatar.hasProperty(DexterityAbilityScoreProperty.class))			avatar.addProperty(new DexterityAbilityScoreProperty(avatar));
		if (!avatar.hasProperty(IntelligenceAbilityScoreProperty.class))	avatar.addProperty(new IntelligenceAbilityScoreProperty(avatar));
		if (!avatar.hasProperty(WisdomAbilityScoreProperty.class))				avatar.addProperty(new WisdomAbilityScoreProperty(avatar));
		if (!avatar.hasProperty(ConstitutionAbilityScoreProperty.class))	avatar.addProperty(new CharismaAbilityScoreProperty(avatar));
		
		// Add the 6 core ability modifier properties
		if (!avatar.hasProperty(StrengthAbilityModifierProperty.class))			avatar.addProperty(new StrengthAbilityModifierProperty(avatar));
		if (!avatar.hasProperty(ConstitutionAbilityModifierProperty.class))	avatar.addProperty(new ConstitutionAbilityModifierProperty(avatar));
		if (!avatar.hasProperty(DexterityAbilityModifierProperty.class))		avatar.addProperty(new DexterityAbilityModifierProperty(avatar));
		if (!avatar.hasProperty(IntelligenceAbilityModifierProperty.class))	avatar.addProperty(new IntelligenceAbilityModifierProperty(avatar));
		if (!avatar.hasProperty(WisdomAbilityModifierProperty.class))				avatar.addProperty(new WisdomAbilityModifierProperty(avatar));
		if (!avatar.hasProperty(CharismaAbilityModifierProperty.class))			avatar.addProperty(new CharismaAbilityModifierProperty(avatar));

		// Add the 4 core defense properties
		if (!avatar.hasProperty(ArmorClassProperty.SLUG))avatar.addProperty(new ArmorClassProperty(avatar));
		if (!avatar.hasProperty(FortitudeProperty.SLUG))avatar.addProperty(new FortitudeProperty(avatar));
		if (!avatar.hasProperty(ReflexProperty.SLUG))avatar.addProperty(new ReflexProperty(avatar));
		if (!avatar.hasProperty(WillProperty.SLUG))avatar.addProperty(new WillProperty(avatar));
		
		// Add the 17 core skill properties
		if (!avatar.hasProperty(AcrobatSkill.SLUG))avatar.addProperty(new AcrobatSkill(avatar, AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER));
		if (!avatar.hasProperty(ArcanaSkill.SLUG))avatar.addProperty(new ArcanaSkill(avatar, AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER));
		if (!avatar.hasProperty(AthleticSkill.SLUG))avatar.addProperty(new AthleticSkill(avatar, AbilityModifierProperty.SLUG.STRENGTH_MODIFIER));
		if (!avatar.hasProperty(BluffSkill.SLUG))avatar.addProperty(new BluffSkill(avatar, AbilityModifierProperty.SLUG.CHARISMA_MODIFIER));
		if (!avatar.hasProperty(DiplomacySkill.SLUG))avatar.addProperty(new DiplomacySkill(avatar, AbilityModifierProperty.SLUG.CHARISMA_MODIFIER));
		if (!avatar.hasProperty(DungeoneeringSkill.SLUG))avatar.addProperty(new DungeoneeringSkill(avatar, AbilityModifierProperty.SLUG.WISDOM_MODIFIER));
		if (!avatar.hasProperty(EnduranceSkill.SLUG))avatar.addProperty(new EnduranceSkill(avatar, AbilityModifierProperty.SLUG.CONSTITUTION_MODIFIER));
		if (!avatar.hasProperty(HealSkill.SLUG))avatar.addProperty(new HealSkill(avatar, AbilityModifierProperty.SLUG.WISDOM_MODIFIER));
		if (!avatar.hasProperty(HistorySkill.SLUG))avatar.addProperty(new HistorySkill(avatar, AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER));
		if (!avatar.hasProperty(InsightSkill.SLUG))avatar.addProperty(new InsightSkill(avatar, AbilityModifierProperty.SLUG.WISDOM_MODIFIER));
		if (!avatar.hasProperty(IntimidateSkill.SLUG))avatar.addProperty(new IntimidateSkill(avatar, AbilityModifierProperty.SLUG.CHARISMA_MODIFIER));
		if (!avatar.hasProperty(NatureSkill.SLUG))avatar.addProperty(new NatureSkill(avatar, AbilityModifierProperty.SLUG.WISDOM_MODIFIER));
		if (!avatar.hasProperty(PerceptionSkill.SLUG))avatar.addProperty(new PerceptionSkill(avatar, AbilityModifierProperty.SLUG.WISDOM_MODIFIER));
		if (!avatar.hasProperty(ReligionSkill.SLUG))avatar.addProperty(new ReligionSkill(avatar, AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER));
		if (!avatar.hasProperty(StealthSkill.SLUG))avatar.addProperty(new StealthSkill(avatar, AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER));
		if (!avatar.hasProperty(StreetwiseSkill.SLUG))avatar.addProperty(new StreetwiseSkill(avatar, AbilityModifierProperty.SLUG.CHARISMA_MODIFIER));
		if (!avatar.hasProperty(ThieverySkill.SLUG))avatar.addProperty(new ThieverySkill(avatar, AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER));
	}
}
