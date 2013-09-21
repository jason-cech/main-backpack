/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.dd.core.properties.CharismaAbilityScoreProperty;

/**
 *
 * @author Jason
 */
public class CharismaAbilityModifierProperty extends AbilityModifierProperty {
	
	public CharismaAbilityModifierProperty(Avatar avatar) {
		super(avatar, AbilityModifierProperty.SLUG.CHARISMA_MODIFIER);
	}

	@Override
	protected void init() {
		CharismaAbilityScoreProperty charismaAbilityModifierProperty = this.avatar.find(CharismaAbilityScoreProperty.class);
		charismaAbilityModifierProperty.addObserver(this);
	}
	
}
