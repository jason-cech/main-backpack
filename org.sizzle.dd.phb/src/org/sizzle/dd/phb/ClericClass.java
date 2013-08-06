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
import org.sizzle.dd.phb.modifier.RacialAbilityBonus;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
@ServiceProvider(service = AvatarClass.class)
public class ClericClass implements AvatarClass {
	public static final IModifier<Integer> FORTITUDE_DEFENSE_BONUS = new IModifier<Integer>() {

			@Override
			public Integer getValue(IAvatar avatar) {
				return 2;
			}

			@Override
			public boolean isEnabled(IAvatar avatar) {
				return avatar.find(ClassProperty.class).getValue().getClass().isAssignableFrom(ClericClass.class);
			}
		};
	public static final FirstLevelHitPointsModifier FIRST_LEVEL_HIT_POINTS_MODIFIER = new FirstLevelHitPointsModifier() {

		@Override
		public Integer getValue(IAvatar avatar) {
			AbilityScoreProperty constitutionScoreProperty = avatar.find(AbilityScoreProperty.SLUG.CONSTITUTION_SCORE, AbilityScoreProperty.class);
			InitialAbilityScoreModifier initialConstitutionScoreModifier = constitutionScoreProperty.getLookup().lookup(InitialAbilityScoreModifier.class);
			RacialAbilityBonus racialAbilityBonus = constitutionScoreProperty.getLookup().lookup(RacialAbilityBonus.class);
			
			Integer initialConstitutionScore = 0, racialAbilityBonusScore = 0;
			if (null != initialConstitutionScoreModifier && initialConstitutionScoreModifier.isEnabled(avatar))
				initialConstitutionScore = initialConstitutionScoreModifier.getValue(avatar);
			if (null != racialAbilityBonus && racialAbilityBonus.isEnabled(avatar))
				racialAbilityBonusScore = racialAbilityBonus.getValue(avatar);
			
			return 12 + initialConstitutionScore + racialAbilityBonusScore;
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
	};
	
	
	@Override
	public void configure(Avatar avatar) {
		// Bonus to Defense
		avatar.find(FortitudeProperty.class).addModifier(FORTITUDE_DEFENSE_BONUS);
		avatar.find(HealthProperty.class).addModifier(FIRST_LEVEL_HIT_POINTS_MODIFIER);
		avatar.find(AbilityScoreProperty.SLUG.CONSTITUTION_SCORE, AbilityScoreProperty.class).addObserver(avatar.find(HealthProperty.class));
	}

	@Override
	public void deconfigure(Avatar avatar) {
		avatar.find(AbilityScoreProperty.SLUG.CONSTITUTION_SCORE, AbilityScoreProperty.class).deleteObserver(avatar.find(HealthProperty.class));
		avatar.find(FortitudeProperty.class).removeModifier(FORTITUDE_DEFENSE_BONUS);
		avatar.find(HealthProperty.class).removeModifier(FIRST_LEVEL_HIT_POINTS_MODIFIER);
	}

	@Override
	public String getClassName() {
		return "Cleric";
	}
	
}
