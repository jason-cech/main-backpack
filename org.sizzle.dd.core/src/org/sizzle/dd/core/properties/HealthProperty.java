package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.modifier.FirstLevelHitPointsModifier;
import org.sizzle.dd.core.modifier.PerLevelHitPointModifier;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class HealthProperty extends CoreProperty<Integer> {

	@Override
	protected Integer calculate() {
		Integer health = 0;
		IModifier<Integer> firstLevelHealth = this.defaultLookup.lookup(FirstLevelHitPointsModifier.class);
		IModifier<Integer> healthPerLevel = this.defaultLookup.lookup(PerLevelHitPointModifier.class);
		
		Integer avatarLevel = avatar.findValueOf(LevelProperty.class);
		
		health += firstLevelHealth.getValue(avatar);
		for (int level = 1; level < avatarLevel; level++) {
			health += healthPerLevel.getValue(avatar);
		}
		return health;
	}
	
}
