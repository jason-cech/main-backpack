/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.modifier.AbilityModifier;

/**
 *
 * @author Jason
 */
public class ConstitutionAbilityModifierProperty extends AbilityModifierProperty {
	
	public ConstitutionAbilityModifierProperty(Avatar avatar) {
		super(avatar, AbilityModifierProperty.SLUG.CONSTITUTION_MODIFIER);
	}

	@Override
	protected final void init() {
		this.addModifier(new AbilityModifier<>(ConstitutionAbilityScoreProperty.class));
		
		ConstitutionAbilityScoreProperty constitutionAbilityScoreProperty = this.avatar.find(ConstitutionAbilityScoreProperty.class);
		constitutionAbilityScoreProperty.addObserver(this);
	}
}
