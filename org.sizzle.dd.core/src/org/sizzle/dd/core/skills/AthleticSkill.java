/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.StrengthAbilityModifierProperty;

/**
 *
 * @author Jason
 */
public class AthleticSkill extends CoreSkillProperty<StrengthAbilityModifierProperty> {
	public static String SLUG = "athletics";

	public AthleticSkill(Avatar avatar) {
		super(SLUG, avatar, StrengthAbilityModifierProperty.class);
	}
}
