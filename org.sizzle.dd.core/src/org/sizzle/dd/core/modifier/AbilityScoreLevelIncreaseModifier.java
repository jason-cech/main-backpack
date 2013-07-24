package org.sizzle.dd.core.modifier;

import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class AbilityScoreLevelIncreaseModifier implements IModifier<Integer> {

    @Override
    public Integer getValue(IAvatar avatar) {
        return 1;
    }

    @Override
    public boolean isEnabled(IAvatar avatar) {
        return true;
    }
    
}
