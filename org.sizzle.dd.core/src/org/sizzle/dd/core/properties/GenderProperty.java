package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class GenderProperty extends CoreProperty<String> {
    
    public GenderProperty() {
        super("avatar_gender");
    }

    @Override
    protected String calculate() {
        return "[No-Gender]";
    }
    
}
