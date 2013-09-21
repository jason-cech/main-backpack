/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.properties.types.VisionType;
import org.sizzle.rpg.core.IGrantor;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class VisionProperty extends MultiValuedCoreProperty<VisionType> {
	public static final String SLUG = "vision";

	public VisionProperty(IGrantor grantor) {
		super(grantor, SLUG);
	}

	@Override
	protected VisionType calculate() {
		int calculatedValue = -1;
		
		for (IModifier<VisionType> modifier : modifiers) {
			if (-1 == calculatedValue)
				calculatedValue = modifier.getValue(avatar).getBit();
			else
				calculatedValue = modifier.isEnabled(avatar) ? (calculatedValue & modifier.getValue(avatar).getBit()) : calculatedValue;
		}
		return null;// TODO: figure out a way of handling calculate on a multivalued property
	}

	@Override
	public boolean contains(VisionType value) {
		int calculatedValue = -1;
		
		for (IModifier<VisionType> modifier : modifiers) {
			if (-1 == calculatedValue)
				calculatedValue = modifier.getValue(avatar).getBit();
			else
				calculatedValue = modifier.isEnabled(avatar) ? (calculatedValue & modifier.getValue(avatar).getBit()) : calculatedValue;
		}
		
		return false;// FIXME: calculatedValue ^ value.getBit();
	}
	
}
