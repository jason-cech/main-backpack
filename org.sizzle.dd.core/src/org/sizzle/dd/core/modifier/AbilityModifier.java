/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.modifier;

import org.sizzle.dd.core.properties.AbilityScoreProperty;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.IGrantor;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 * @param <T>
 */
public class AbilityModifier<T extends AbilityScoreProperty> implements IModifier<Integer> {
	private final Class<T> ABILITY_SCORE_PROPERTY_CLASS;
	
	public AbilityModifier(Class<T> abilityScorePropertyClass) {
		this.ABILITY_SCORE_PROPERTY_CLASS = abilityScorePropertyClass;
	}
	
	@Override
	public Integer getValue(IAvatar avatar) {
		return avatar.find(ABILITY_SCORE_PROPERTY_CLASS).getValue() / 2 - 5;
	}

	@Override
	public boolean isEnabled(IAvatar avatar) {
		return avatar.hasProperty(ABILITY_SCORE_PROPERTY_CLASS);
	}

	@Override
	public IGrantor grantedBy() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
