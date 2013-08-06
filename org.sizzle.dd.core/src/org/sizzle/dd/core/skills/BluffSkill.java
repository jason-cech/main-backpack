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
public class BluffSkill extends CoreSkillProperty {
	public static String SLUG = "bluff";

	public BluffSkill(Avatar avatar, String CHARISMA_MODIFIER) {
		super(SLUG, avatar, CHARISMA_MODIFIER);
	}
}
