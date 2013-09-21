/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class StrengthAbilityModifierProperty extends AbilityModifierProperty {

	public StrengthAbilityModifierProperty(Avatar avatar) {
		super(avatar, AbilityModifierProperty.SLUG.STRENGTH_MODIFIER);
	}

	@Override
	protected void init() {
		StrengthAbilityScoreProperty scoreProperty = this.avatar.find(StrengthAbilityScoreProperty.class);
		scoreProperty.addObserver(this);
	}
}
