package org.sizzle.rpg.core.model;

import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.IState;

/**
 *
 * @author Jason
 */
public class FullDefense implements IModifier<Integer>, IState {
    
    @Override
    public Integer getValue(IAvatar avatar) {
        return 1;
    }

    @Override
    public boolean isEnabled(IAvatar avatar) {
        return avatar.hasState(FullDefense.class);
    }

    @Override
    public boolean isStackable() {
        return false;
    }
    
}
