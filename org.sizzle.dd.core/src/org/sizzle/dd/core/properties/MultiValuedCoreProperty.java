/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import java.util.ArrayList;
import java.util.Collection;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.sizzle.rpg.core.IGrantor;
import org.sizzle.rpg.core.MultiValuedAbstractProperty;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public abstract class MultiValuedCoreProperty<T> extends MultiValuedAbstractProperty<T> {
    protected Lookup defaultLookup = new AbstractLookup(content);
    public Collection<IModifier<T>> modifiers = new ArrayList<>(0);

	/**
	 *
	 * @param grantor
	 * @param aliases
	 */
	protected MultiValuedCoreProperty(IGrantor grantor, String...aliases) {
        super(grantor, aliases);
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
