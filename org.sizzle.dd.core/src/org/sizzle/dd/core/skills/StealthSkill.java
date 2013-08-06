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
public class StealthSkill extends CoreSkillProperty {
	public static String SLUG = "stealth";
	
	public StealthSkill(Avatar avatar, String abilityModifierSlug) {
		super(SLUG, avatar, abilityModifierSlug);
	}
	
}
