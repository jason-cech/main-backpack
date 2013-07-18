package org.sizzle.dd.core.properties;


/**
 *
 * @author Jason
 */
public class WeightProperty extends CoreProperty<Double> {
    
    public WeightProperty() {
        super("avatar_weight");
    }

    @Override
    protected Double calculate() {
        return 1.0;
    }
    
}
