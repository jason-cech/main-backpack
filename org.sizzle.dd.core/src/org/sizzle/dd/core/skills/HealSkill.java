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
public class HealSkill extends CoreSkillProperty {
	public static String SLUG = "heal";

	public HealSkill(Avatar avatar, String WISDOM_MODIFIER) {
		super(SLUG, avatar, WISDOM_MODIFIER);
	}
}