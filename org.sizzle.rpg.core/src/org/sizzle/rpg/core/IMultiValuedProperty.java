/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.rpg.core;

/**
 *
 * @author Jason
 * @param <T>
 */
public interface IMultiValuedProperty<T> extends IProperty<T>{
	boolean contains(T value);
}
