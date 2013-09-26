/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.DexterityAbilityModifierProperty;

/**
 *
 * @author Jason
 */
public class ThieverySkill extends CoreSkillProperty<DexterityAbilityModifierProperty> {
	public static String SLUG = "thievery";
	
	public ThieverySkill(Avatar avatar) {
		super(SLUG, avatar, DexterityAbilityModifierProperty.class);
	}
}
