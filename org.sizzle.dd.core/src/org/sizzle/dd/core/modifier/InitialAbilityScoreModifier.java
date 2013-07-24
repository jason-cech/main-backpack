package org.sizzle.dd.core.modifier;

import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class InitialAbilityScoreModifier implements IModifier<Integer> {
    private final Integer val;
    
    public InitialAbilityScoreModifier(Integer value) {
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
