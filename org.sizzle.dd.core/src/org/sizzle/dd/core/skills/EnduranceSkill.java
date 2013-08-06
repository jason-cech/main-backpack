/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class EnduranceSkill extends CoreSkillProperty {
	public static String SLUG = "endurance";

	public EnduranceSkill(Avatar avatar, String CONSTITUTION_MODIFIER) {
		super(SLUG, avatar, CONSTITUTION_MODIFIER);
	}
}
