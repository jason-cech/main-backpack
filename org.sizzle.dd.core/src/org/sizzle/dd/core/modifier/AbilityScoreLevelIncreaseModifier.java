package org.sizzle.dd.core.modifier;

import org.sizzle.rpg.core.IAvatar;

/**
 *
 * @author Jason
 */
public class AbilityScoreLevelIncreaseModifier extends BonusModifier<Integer, UntypedBonusModifierType> {//implements IModifier<Integer> {
	
	public AbilityScoreLevelIncreaseModifier() {
		super(UntypedBonusModifierType.class);
	}

    @Override
    public Integer getValue(IAvatar avatar) {
        return 1;
    }

    @Override
    public boolean isEnabled(IAvatar avatar) {
        return true;
    }
    
}
