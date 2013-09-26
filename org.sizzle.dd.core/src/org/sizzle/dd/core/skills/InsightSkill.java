/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.WisdomAbilityModifierProperty;

/**
 *
 * @author Jason
 */
public class InsightSkill extends CoreSkillProperty<WisdomAbilityModifierProperty> {
	public static String SLUG = "insight";

	public InsightSkill(Avatar avatar) {
		super(SLUG, avatar, WisdomAbilityModifierProperty.class);
	}
}
