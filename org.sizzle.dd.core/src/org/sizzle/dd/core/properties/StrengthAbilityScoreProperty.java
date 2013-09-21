/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.IAvatar;

/**
 *
 * @author Jason
 */
public class StrengthAbilityScoreProperty extends AbilityScoreProperty {

	public StrengthAbilityScoreProperty(IAvatar avatar) {
		super(avatar, AbilityScoreProperty.SLUG.STRENGTH_SCORE);
	}
	
}
