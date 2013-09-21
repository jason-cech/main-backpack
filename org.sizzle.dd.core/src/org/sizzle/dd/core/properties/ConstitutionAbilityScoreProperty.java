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
public class ConstitutionAbilityScoreProperty extends AbilityScoreProperty {
	public static final String SLUG = "constitution_score";
	public ConstitutionAbilityScoreProperty(Avatar avatar) {
		super(avatar, SLUG);
	}
}
