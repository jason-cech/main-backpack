/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class FortitudeProperty extends CoreProperty<Integer> {
	public static final String SLUG = "fortitude";
	
	public FortitudeProperty() {
		super(SLUG);
	}

	@Override
	protected Integer calculate() {
		Integer score = 0;
		
		return score;
	}
	
}
