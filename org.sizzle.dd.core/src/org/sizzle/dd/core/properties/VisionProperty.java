/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class VisionProperty extends CoreProperty<String> {
	public static final String SLUG = "vision";

	@Override
	protected String calculate() {
		return value;
	}
	
}
