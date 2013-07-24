package org.sizzle.dd.core.modifier;

import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public abstract class FirstLevelHitPointsModifier implements IModifier<Integer> {

	@Override
	public boolean isEnabled(IAvatar avatar) {
		return true;
	}
	
}
