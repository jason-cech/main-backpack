/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.AbilityScoreProperty;

/**
 *
 * @author Jason
 */
public class WisdomAbilityScoreProperty extends AbilityScoreProperty {
	
	public WisdomAbilityScoreProperty(Avatar avatar) {
		super(avatar, AbilityScoreProperty.SLUG.WISDOM_SCORE);
	}
}
