/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.rpg.core.model;

import org.sizzle.rpg.core.IGrantor;

/**
 *
 * @author Jason
 */
public abstract class AbstractModifier<T> implements IModifier<T> {
	private final IGrantor grantor;
	protected AbstractModifier(IGrantor grantor) {
		this.grantor = grantor;
	}

	@Override
	public IGrantor grantedBy() {
		return grantor;
	}
	
}
