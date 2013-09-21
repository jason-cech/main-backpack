/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.rpg.core;

import java.util.Collection;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 * @param <T>
 */
public interface ICalculated<T> {
	
	T calculate();

	Collection<IModifier<T>> getModifiers();

	void addModifier(IModifier<T> modifier);

	void removeModifier(IModifier<T> modifier);
}
