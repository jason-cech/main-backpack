package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class GenderProperty extends AbstractProperty<String> {
    
    public GenderProperty() {
        super("avatar_gender");
    }

    @Override
    protected String calculate() {
        return "[No-Gender]";
    }
    
}
