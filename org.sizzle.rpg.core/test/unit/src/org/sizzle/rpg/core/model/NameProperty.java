package org.sizzle.rpg.core.model;

import org.openide.util.Lookup;
import org.sizzle.rpg.core.AbstractProperty;
import org.sizzle.rpg.core.IGrantor;

/**
 *
 * @author Jason
 */
public class NameProperty extends AbstractProperty<String>{
    
    public NameProperty(IGrantor grantor) { super(grantor, "avatar_name"); }
    public NameProperty(IGrantor grantor, String name) { super(grantor, "avatar_name"); setValue(name);}

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
