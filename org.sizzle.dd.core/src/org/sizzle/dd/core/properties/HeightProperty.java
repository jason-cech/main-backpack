package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class HeightProperty extends CoreProperty<String> {
    
    public HeightProperty() {
        super("avatar_height");
    }
    
    @Override
    protected String calculate() {
        return "[No-Height]";
    }
    
}
