package org.sizzle.dd.core.properties;

import java.util.ArrayList;
import java.util.Collection;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.sizzle.rpg.core.AbstractProperty;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public abstract class CoreProperty<T> extends AbstractProperty<T> {
    protected Lookup defaultLookup = new AbstractLookup(content);
    public Collection<IModifier<T>> modifiers = new ArrayList<>(0);
    
    protected CoreProperty(String...aliases) {
        super(aliases);
    }
    
    @Override
    public Lookup getLookup() {
        return defaultLookup;
    }

    @Override
    public Collection<IModifier<T>> getModifiers() {
        return this.modifiers;
    }
    
}
