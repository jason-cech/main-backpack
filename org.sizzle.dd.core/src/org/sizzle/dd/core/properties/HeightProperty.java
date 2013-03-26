package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class HeightProperty extends AbstractProperty<String> {
    
    public HeightProperty() {
        super("avatar_height");
    }
    
    @Override
    protected String calculate() {
        return "[No-Height]";
    }
    
}
