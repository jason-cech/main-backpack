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
public class DexterityAbilityModifierProperty extends AbilityModifierProperty {
	
	public DexterityAbilityModifierProperty(Avatar avatar) {
		super(avatar, AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER);
	}

	@Override
	protected void init() {
		DexterityAbilityScoreProperty dexterityAbilityScoreProperty = this.avatar.find(DexterityAbilityScoreProperty.class);
		dexterityAbilityScoreProperty.addObserver(this);
	}
	
}
