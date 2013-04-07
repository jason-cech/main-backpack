package org.sizzle.dd.core.properties;


/**
 *
 * @author Jason
 */
public class WeightProperty extends CoreProperty<Number> {
    
    public WeightProperty() {
        super("avatar_weight");
    }

    @Override
    protected Number calculate() {
        return 1;
    }
    
}
