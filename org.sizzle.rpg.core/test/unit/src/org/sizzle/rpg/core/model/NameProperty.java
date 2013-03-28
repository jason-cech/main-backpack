package org.sizzle.rpg.core.model;

import org.openide.util.Lookup;
import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class NameProperty extends AbstractProperty<String>{
    
    public NameProperty() { super("avatar_name"); }
    public NameProperty(String name) { super("avatar_name"); setValue(name);}

    @Override
    protected String calculate() {
        return "[Name]";
    }

    @Override
    public boolean hasAlias(String alias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lookup getLookup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
