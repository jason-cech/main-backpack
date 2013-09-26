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
public class IntelligenceAbilityModifierProperty extends AbilityModifierProperty {
	
	public IntelligenceAbilityModifierProperty(Avatar avatar) {
		super(avatar, AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER);
	}

	@Override
	protected final void init() {
		this.addModifier(new AbilityModifier<>(IntelligenceAbilityScoreProperty.class));
		
		IntelligenceAbilityScoreProperty intelligenceAbilityScoreProperty = this.avatar.find(IntelligenceAbilityScoreProperty.class);
		intelligenceAbilityScoreProperty.addObserver(this);
	}
	
}
