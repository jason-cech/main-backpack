package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class AgeProperty extends AbstractProperty<Float> {
    
    public AgeProperty() {
        super("avatar_age");
    }

    @Override
    protected Float calculate() {
        return Float.NaN;
    }
    
}
