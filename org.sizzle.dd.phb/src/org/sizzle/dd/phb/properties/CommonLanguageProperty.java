/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.phb.properties;

import org.sizzle.dd.core.properties.CoreProperty;

/**
 *
 * @author Jason
 */
public class CommonLanguageProperty extends CoreProperty<String> implements ILanguageProperty {
	public static final String SLUG = "language-common";

	@Override
	protected String calculate() {
		return "Common";
	}
	
}
