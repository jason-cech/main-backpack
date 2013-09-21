package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.modifier.FirstLevelHitPointsModifier;
import org.sizzle.dd.core.modifier.PerLevelHitPointModifier;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class HealthProperty extends CoreProperty<Integer> {
	public static final String SLUG = "health_points";
	
	public HealthProperty(Avatar avatar) {
		super(avatar, SLUG);
	}

	@Override
	protected Integer calculate() {
		Integer health = 0;
		IModifier<Integer> firstLevelHealth = this.defaultLookup.lookup(FirstLevelHitPointsModifier.class);
		IModifier<Integer> healthPerLevel = this.defaultLookup.lookup(PerLevelHitPointModifier.class);
		
		Integer avatarLevel = avatar.findValueOf(LevelProperty.class);
		
		if (null != firstLevelHealth && firstLevelHealth.isEnabled(avatar))
			health += firstLevelHealth.getValue(avatar);
		
		for (int level = 1; level < avatarLevel; level++) {
			if (null != healthPerLevel && healthPerLevel.isEnabled(avatar))
				health += healthPerLevel.getValue(avatar);
		}
		return health;
	}
	
}
