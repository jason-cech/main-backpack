/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.phb;

import org.openide.util.lookup.ServiceProvider;
import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.AvatarClass;
import org.sizzle.dd.core.modifier.FirstLevelHitPointsModifier;
import org.sizzle.dd.core.modifier.InitialAbilityScoreModifier;
import org.sizzle.dd.core.modifier.PerLevelHitPointModifier;
import org.sizzle.dd.core.properties.AbilityScoreProperty;
import org.sizzle.dd.core.properties.ClassProperty;
import org.sizzle.dd.core.properties.FortitudeProperty;
import org.sizzle.dd.core.properties.HealthProperty;
import org.sizzle.dd.core.properties.ReflexProperty;
import org.sizzle.dd.phb.modifier.RacialAbilityBonus;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.IGrantor;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
@ServiceProvider(service = AvatarClass.class)
public class RangerClass implements AvatarClass {

	public static final IModifier<Integer> FORTITUDE_DEFENSE_BONUS = new IModifier<Integer>() {
		@Override
		public Integer getValue(IAvatar avatar) {
			return 1;
		}

		@Override
		public boolean isEnabled(IAvatar avatar) {
			return avatar.find(ClassProperty.class).getValue().getClass().isAssignableFrom(RangerClass.class);
		}

		@Override
		public IGrantor grantedBy() {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
	};
	public static final IModifier<Integer> REFLEX_DEFENSE_BONUS = new IModifier<Integer>() {
		@Override
		public Integer getValue(IAvatar avatar) {
			return 1;
		}

		@Override
		public boolean isEnabled(IAvatar avatar) {
			return avatar.find(ClassProperty.class).getValue().getClass().isAssignableFrom(RangerClass.class);
		}

		@Override
		public IGrantor grantedBy() {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
	};
	public static final FirstLevelHitPointsModifier FIRST_LEVEL_HIT_POINTS_MODIFIER = new FirstLevelHitPointsModifier() {
		@Override
		public Integer getValue(IAvatar avatar) {
			AbilityScoreProperty constitutionScoreProperty = avatar.find(AbilityScoreProperty.SLUG.CONSTITUTION_SCORE, AbilityScoreProperty.class);
			InitialAbilityScoreModifier initialConstitutionScoreModifier = constitutionScoreProperty.getLookup().lookup(InitialAbilityScoreModifier.class);
			RacialAbilityBonus racialAbilityBonus = constitutionScoreProperty.getLookup().lookup(RacialAbilityBonus.class);

			Integer initialConstitutionScore = 0, racialAbilityBonusScore = 0;
			if (null != initialConstitutionScoreModifier && initialConstitutionScoreModifier.isEnabled(avatar)) {
				initialConstitutionScore = initialConstitutionScoreModifier.getValue(avatar);
			}
			if (null != racialAbilityBonus && racialAbilityBonus.isEnabled(avatar)) {
				racialAbilityBonusScore = racialAbilityBonus.getValue(avatar);
			}

			return 12 + initialConstitutionScore + racialAbilityBonusScore;
		}

		@Override
		public IGrantor grantedBy() {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
	};
	public static final PerLevelHitPointModifier PER_LEVEL_HIT_POINT_MODIFIER = new PerLevelHitPointModifier() {
		@Override
		public Integer getValue(IAvatar avatar) {
			return 5;
		}

		@Override
		public boolean isEnabled(IAvatar avatar) {
			return true;
		}

		@Override
		public IGrantor grantedBy() {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
	};
	public static final String RANGER_CLASS_NAME = "Ranger";

	@Override
	public void configure(Avatar avatar) {
		// Add class granted defense modifiers
		avatar.find(FortitudeProperty.class).addModifier(FORTITUDE_DEFENSE_BONUS);
		avatar.find(ReflexProperty.class).addModifier(REFLEX_DEFENSE_BONUS);
		
		// Add class granted health modifiers
		avatar.find(HealthProperty.class).addModifier(FIRST_LEVEL_HIT_POINTS_MODIFIER);
		
		// Add class granted armor proficiencies
		//if (!avatar.hasProperty(ClothArmorProficiencyProperty.class)) avatar.addProperty(new ClothArmorProficiencyProperty());
		//if (!avatar.hasProperty(LeatherArmorProficiencyProperty.class)) avatar.addProperty(new LeatherArmorProficiencyProperty());
		//if (!avatar.hasProperty(HideArmorProficiencyProperty.class)) avatar.addProperty(new HideArmorProficiencyProperty());
		
		// Add class granted weapon proficiencies
		//if (!avatar.hasProperty(SimpleMeleeWeaponProficiencyProperty.class)) avatar.addProperty(new SimpleMeleeWeaponProficiencyProperty());
		//if (!avatar.hasProperty(MilitaryMeleeWeaponProficiencyProperty.class)) avatar.addProperty(new MilitaryMeleeWeaponProficiencyProperty());
		//if (!avatar.hasProperty(SimpleRangedWeaponProficiencyProperty.class)) avatar.addProperty(new SimpleRangedWeaponProficiencyProperty());
		//if (!avatar.hasProperty(MilitaryRangedWeaponProficiencyProperty.class)) avatar.addProperty(new MilitaryRangedWeaponProficiencyProperty());
	}

	@Override
	public void deconfigure(Avatar avatar) {
		// Remove class granted health modifiers
		avatar.find(HealthProperty.class).removeModifier(FIRST_LEVEL_HIT_POINTS_MODIFIER);
		
		// Remove class granted defense modifiers
		avatar.find(ReflexProperty.class).removeModifier(REFLEX_DEFENSE_BONUS);
		avatar.find(FortitudeProperty.class).removeModifier(FORTITUDE_DEFENSE_BONUS);
		
		// Remove class granted weapon proficiencies
		//if (avatar.hasProperty(ClothArmorProficiencyProperty.class)) avatar.removeProperty(new ClothArmorProficiencyProperty());
		//if (avatar.hasProperty(LeatherArmorProficiencyProperty.class)) avatar.removeProperty(new LeatherArmorProficiencyProperty());
		//if (avatar.hasProperty(HideArmorProficiencyProperty.class)) avatar.removeProperty(new HideArmorProficiencyProperty());
		
		// Remove class granted weapon proficiencies
		//if (avatar.hasProperty(SimpleMeleeWeaponProficiencyProperty.class)) avatar.removeProperty(new SimpleMeleeWeaponProficiencyProperty());
		//if (avatar.hasProperty(MilitaryMeleeWeaponProficiencyProperty.class)) avatar.removeProperty(new MilitaryMeleeWeaponProficiencyProperty());
		//if (avatar.hasProperty(SimpleRangedWeaponProficiencyProperty.class)) avatar.removeProperty(new SimpleRangedWeaponProficiencyProperty());
		//if (avatar.hasProperty(MilitaryRangedWeaponProficiencyProperty.class)) avatar.removeProperty(new MilitaryRangedWeaponProficiencyProperty());
	}

	@Override
	public String getClassName() {
		return RANGER_CLASS_NAME;
	}

	@Override
	public String[] getKeyAbilities() {
		return new String[] { "strength", "dexterity", "wisdom" };
	}
}
