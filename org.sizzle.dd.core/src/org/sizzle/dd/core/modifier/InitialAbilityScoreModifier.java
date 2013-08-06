package org.sizzle.dd.core.modifier;

import org.sizzle.rpg.core.IAvatar;

/**
 *
 * @author Jason
 */
public class InitialAbilityScoreModifier extends BonusModifier<Integer, UntypedBonusModifierType> {

	private final Integer val;

	public InitialAbilityScoreModifier(Integer value) {
		super(UntypedBonusModifierType.class);
		this.val = value;
	}

	@Override
	public Integer getValue(IAvatar avatar) {
		return val;
	}

	@Override
	public boolean isEnabled(IAvatar avatar) {
		return true;
	}
}
