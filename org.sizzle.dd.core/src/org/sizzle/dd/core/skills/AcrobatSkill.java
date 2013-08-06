package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class AcrobatSkill extends CoreSkillProperty {
	public static String SLUG = "acrobat";

	public AcrobatSkill(Avatar avatar, String abilityModifierSlug) {
		super(SLUG, avatar, abilityModifierSlug);
	}
}
