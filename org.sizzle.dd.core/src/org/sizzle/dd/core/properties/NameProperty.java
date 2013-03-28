package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class NameProperty extends CoreProperty<String> {

    public NameProperty() {
        super("avatar_name");
    }
    
    @Override
    protected String calculate() {
        return "[No-Name]";
    }
    
}
