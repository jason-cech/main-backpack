/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class ReflexProperty extends CoreProperty<Integer> {
	public static final String SLUG = "reflex";
	
	public ReflexProperty(Avatar avatar) { super(SLUG); }

	@Override
	protected Integer calculate() {
		Integer score = 0;
		
		return score;
	}
	
}
