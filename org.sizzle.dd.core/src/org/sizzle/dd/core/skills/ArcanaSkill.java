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
public class ArcanaSkill extends CoreSkillProperty {
	public static final String SLUG = "arcana";

	public ArcanaSkill(Avatar avatar, String INTELLIGENCE_MODIFIER) {
		super(SLUG, avatar, INTELLIGENCE_MODIFIER);
	}
}
