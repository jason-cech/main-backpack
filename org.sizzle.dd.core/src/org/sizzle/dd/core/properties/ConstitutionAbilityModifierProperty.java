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
public class ConstitutionAbilityModifierProperty extends AbilityModifierProperty {
	
	public ConstitutionAbilityModifierProperty(Avatar avatar) {
		super(avatar, AbilityModifierProperty.SLUG.CONSTITUTION_MODIFIER);
	}

	@Override
	protected void init() {
		ConstitutionAbilityScoreProperty constitutionAbilityScoreProperty = this.avatar.find(ConstitutionAbilityScoreProperty.class);
		constitutionAbilityScoreProperty.addObserver(this);
	}
}
