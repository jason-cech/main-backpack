/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.CharismaAbilityModifierProperty;

/**
 *
 * @author Jason
 */
public class BluffSkill extends CoreSkillProperty<CharismaAbilityModifierProperty> {
	public static String SLUG = "bluff";

	public BluffSkill(Avatar avatar) {
		super(SLUG, avatar, CharismaAbilityModifierProperty.class);
	}
}
