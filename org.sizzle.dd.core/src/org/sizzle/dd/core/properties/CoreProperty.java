package org.sizzle.dd.core.properties;

import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public abstract class CoreProperty<T> extends AbstractProperty<T> {
    protected Lookup defaultLookup = new AbstractLookup(content);
    
    protected CoreProperty(String...aliases) {
        super(aliases);
    }
    
    @Override
    public Lookup getLookup() {
        return defaultLookup;
    }
    
}
