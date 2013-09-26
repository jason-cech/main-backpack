/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.IntelligenceAbilityModifierProperty;

/**
 *
 * @author Jason
 */
public class ReligionSkill extends CoreSkillProperty<IntelligenceAbilityModifierProperty> {
	public static String SLUG = "religion";
	
	public ReligionSkill(Avatar avatar) {
		super(SLUG, avatar, IntelligenceAbilityModifierProperty.class);
	}
	
}
