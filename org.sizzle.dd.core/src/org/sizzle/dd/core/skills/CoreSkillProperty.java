/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.modifier.SkillKeyAbilityModifier;
import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.dd.core.properties.CoreProperty;
import org.sizzle.dd.core.properties.LevelProperty;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public abstract class CoreSkillProperty extends CoreProperty<Integer> {

	protected CoreSkillProperty(String SKILL_SLUG, Avatar avatar, String ABILITY_MODIFIER_SLUG) {
		super(avatar, SKILL_SLUG);
		this.avatar = avatar;
		this.avatar.find(ABILITY_MODIFIER_SLUG, AbilityModifierProperty.class).addObserver(this);
		this.addModifier(new SkillKeyAbilityModifier(ABILITY_MODIFIER_SLUG));
	}
	
	@Override
	protected Integer calculate() {
		Integer score = 0;
		
		Integer halfLevel = avatar.findValueOf(LevelProperty.class) / 2;
		score += halfLevel;
		
		for (IModifier<Integer> modifier : getModifiers()) {
			if (modifier.isEnabled(avatar))
				score += modifier.getValue(avatar);
		}
		
		return score;
	}
	
}
