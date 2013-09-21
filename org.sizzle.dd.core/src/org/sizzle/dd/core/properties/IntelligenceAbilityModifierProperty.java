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
public class IntelligenceAbilityModifierProperty extends AbilityModifierProperty {
	
	public IntelligenceAbilityModifierProperty(Avatar avatar) {
		super(avatar, AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER);
	}

	@Override
	protected void init() {
		IntelligenceAbilityScoreProperty intelligenceAbilityScoreProperty = this.avatar.find(IntelligenceAbilityScoreProperty.class);
		intelligenceAbilityScoreProperty.addObserver(this);
	}
	
}
