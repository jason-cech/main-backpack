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
public class HistorySkill extends CoreSkillProperty {
	public static String SLUG = "history";

	public HistorySkill(Avatar avatar, String INTELLIGENCE_MODIFIER) {
		super(SLUG, avatar, INTELLIGENCE_MODIFIER);
	}
}
