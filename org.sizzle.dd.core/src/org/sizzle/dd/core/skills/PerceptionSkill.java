/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.WisdomAbilityModifierProperty;

/**
 *
 * @author Jason
 */
public class PerceptionSkill extends CoreSkillProperty<WisdomAbilityModifierProperty> {
	public static String SLUG = "preception";
	
	public PerceptionSkill(Avatar avatar) {
		super(SLUG, avatar, WisdomAbilityModifierProperty.class);
	}
	
}
