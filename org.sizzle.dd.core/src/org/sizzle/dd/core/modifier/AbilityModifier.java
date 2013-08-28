/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.modifier;

import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class AbilityModifier implements IModifier<Integer> {
	private final String SLUG;
	
	public AbilityModifier(String slug) {
		this.SLUG = slug;
	}
	
	@Override
	public Integer getValue(IAvatar avatar) {
		return avatar.find(SLUG, AbilityModifierProperty.class).getValue();
	}

	@Override
	public boolean isEnabled(IAvatar avatar) {
		return avatar.hasProperty(SLUG);
	}
	
}
