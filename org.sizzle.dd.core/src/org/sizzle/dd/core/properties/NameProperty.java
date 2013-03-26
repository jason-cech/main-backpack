package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class NameProperty extends AbstractProperty<String> {

    public NameProperty() {
        super("avatar_name");
    }
    
    @Override
    protected String calculate() {
        return "[No-Name]";
    }
    
}
