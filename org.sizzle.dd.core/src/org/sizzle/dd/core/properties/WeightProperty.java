package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class WeightProperty extends AbstractProperty<Number> {
    
    public WeightProperty() {
        super("avatar_weight");
    }

    @Override
    protected Number calculate() {
        return 1;
    }
    
}
