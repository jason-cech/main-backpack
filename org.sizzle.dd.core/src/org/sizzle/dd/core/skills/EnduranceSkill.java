/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.ConstitutionAbilityModifierProperty;

/**
 *
 * @author Jason
 */
public class EnduranceSkill extends CoreSkillProperty<ConstitutionAbilityModifierProperty> {
	public static String SLUG = "endurance";

	public EnduranceSkill(Avatar avatar) {
		super(SLUG, avatar, ConstitutionAbilityModifierProperty.class);
	}
}
