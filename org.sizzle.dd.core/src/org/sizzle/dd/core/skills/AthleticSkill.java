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
public class AthleticSkill extends CoreSkillProperty {
	public static String SLUG = "athletics";

	public AthleticSkill(Avatar avatar, String STRENGTH_MODIFIER) {
		super(SLUG, avatar, STRENGTH_MODIFIER);
	}
}
