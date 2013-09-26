package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.DexterityAbilityModifierProperty;

/**
 *
 * @author Jason
 */
public class AcrobatSkill extends CoreSkillProperty<DexterityAbilityModifierProperty> {
	public static String SLUG = "acrobat";

	public AcrobatSkill(Avatar avatar) {
		super(SLUG, avatar, DexterityAbilityModifierProperty.class);
	}
}
