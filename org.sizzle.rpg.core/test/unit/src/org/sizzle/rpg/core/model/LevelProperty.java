package org.sizzle.rpg.core.model;

import org.openide.util.Lookup;
import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class LevelProperty extends AbstractProperty<Integer>{
    int[] levels = new int[] { 0, 999, 2249, 3749, 5499, 7499, 9999 };
    public LevelProperty() {
        super("avatar_level");
    }

    @Override
    protected Integer calculate() {
        Integer xp = avatar.<Integer>findValueOf("avatar_experience");
        int level = 0;
        while(xp>levels[level]) {
            level++;
        }
        return level;
    }

    @Override
    public Lookup getLookup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
