package org.sizzle.rpg.core;

import org.openide.util.Lookup;

/**
 *
 * @author Jason
 */
public class ModifierFilteredProperty<T> extends AbstractProperty<T> {
	private final AbstractProperty<T> modifierFilteredProperty;

	public ModifierFilteredProperty(AbstractProperty<T> modifierFilteredProperty) {
		this.modifierFilteredProperty = modifierFilteredProperty;
	}
	@Override
	public T getValue() {
		
		return super.getValue(); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected T calculate() {
		return modifierFilteredProperty.calculate();
	}

	@Override
	public Lookup getLookup() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
