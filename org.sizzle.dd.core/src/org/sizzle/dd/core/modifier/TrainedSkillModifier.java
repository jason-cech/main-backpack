package org.sizzle.dd.core.modifier;

import org.sizzle.rpg.core.IAvatar;

/**
 *
 * @author Jason
 */
public class TrainedSkillModifier extends BonusModifier<Integer, UntypedBonusModifierType> {
	
	public TrainedSkillModifier() {
		super(UntypedBonusModifierType.class);
	}

	@Override
	public Integer getValue(IAvatar avatar) {
		return 5;
	}

	@Override
	public boolean isEnabled(IAvatar avatar) {
		return true;
	}
	
}
