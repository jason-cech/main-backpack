package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class AgeProperty extends CoreProperty<Float> {
    
    public AgeProperty() {
        super("avatar_age");
    }

    @Override
    protected Float calculate() {
        return Float.NaN;
    }
    
}
