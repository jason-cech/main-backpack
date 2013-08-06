/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.modifier;

import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public abstract class BonusModifier<T, Type extends BonusModifierType> implements IModifier<T>{
	public final Class<Type> BONUS_TYPE;
	
	protected BonusModifier(Class<Type> BONUS_TYPE) {
		this.BONUS_TYPE = BONUS_TYPE;
	}
}
