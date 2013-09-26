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
public class WisdomAbilityModifierProperty extends AbilityModifierProperty {
	
	public WisdomAbilityModifierProperty(Avatar avatar) {
		super(avatar, AbilityModifierProperty.SLUG.WISDOM_MODIFIER);
	}

	@Override
	protected final void init() {
		this.addModifier(new AbilityModifier<>(WisdomAbilityScoreProperty.class));
		
		WisdomAbilityScoreProperty wisdomAbilityScoreProperty = this.avatar.find(WisdomAbilityScoreProperty.class);
		wisdomAbilityScoreProperty.addObserver(this);
	}
	
}
