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
public class NatureSkill extends CoreSkillProperty {
	public static String SLUG = "nature";
	
	public NatureSkill(Avatar avatar, String abilityModifierSlug) {
		super(SLUG, avatar, abilityModifierSlug);
	}
	
}
