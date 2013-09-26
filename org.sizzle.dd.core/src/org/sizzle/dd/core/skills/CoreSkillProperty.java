/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.skills;

import java.util.logging.Logger;
import org.openide.util.Exceptions;
import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.modifier.SkillKeyAbilityModifier;
import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.dd.core.properties.CoreProperty;
import org.sizzle.dd.core.properties.LevelProperty;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 * @param <T>
 */
public abstract class CoreSkillProperty<T extends AbilityModifierProperty> extends CoreProperty<Integer> {

	private final Class<T> abilityModifierPropertyClass;

	protected CoreSkillProperty(String SKILL_SLUG, Avatar avatar, Class<T> abilityModifierPropertyClass) {
		super(avatar, SKILL_SLUG);
		this.abilityModifierPropertyClass = abilityModifierPropertyClass;
	}

	@Override
	protected Integer calculate() {
		Integer score = 0;

		Integer halfLevel = avatar.findValueOf(LevelProperty.class) / 2;
		score += halfLevel;

		for (IModifier<Integer> modifier : getModifiers()) {
			if (modifier.isEnabled(avatar)) {
				score += modifier.getValue(avatar);
			}
		}

		return score;
	}

	@Override
	public void setAvatar(IAvatar avatar) {
		super.setAvatar(avatar); //To change body of generated methods, choose Tools | Templates.
		T abilityModifierProperty = this.avatar.find(abilityModifierPropertyClass);
		if (null == abilityModifierProperty) {
			Logger.getLogger(this.getClass().getName()).severe(String.format("Unable to find ability modifier for skill '%s'", this.aliases.toArray()[0]));
		} else {
			abilityModifierProperty.addObserver(this);
		}
		this.addModifier(new SkillKeyAbilityModifier(abilityModifierPropertyClass));
	}

}
