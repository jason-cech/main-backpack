package org.sizzle.dd.core.modifier;

import org.sizzle.rpg.core.IAvatar;

/**
 *
 * @author Jason
 */
public abstract class FirstLevelHitPointsModifier extends BonusModifier<Integer, UntypedBonusModifierType> {

	public FirstLevelHitPointsModifier() {
		super(UntypedBonusModifierType.class);
	}
	
	@Override
	public boolean isEnabled(IAvatar avatar) {
		return true;
	}
	
}
