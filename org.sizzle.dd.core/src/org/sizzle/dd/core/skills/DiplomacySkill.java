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
public class DiplomacySkill extends CoreSkillProperty {
	public static String SLUG = "diplomacy";

	public DiplomacySkill(Avatar avatar, String CHARISMA_MODIFIER) {
		super(SLUG, avatar, CHARISMA_MODIFIER);
	}
}
