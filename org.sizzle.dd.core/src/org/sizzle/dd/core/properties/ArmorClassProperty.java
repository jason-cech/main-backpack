/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.modifier.ArmorBonusModifier;
import org.sizzle.dd.core.modifier.BaseDefenseModifier;
import org.sizzle.dd.core.modifier.ShieldBonusModifier;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class ArmorClassProperty extends CoreProperty<Integer> {
	public static final String SLUG = "armor_class";
	public static final IModifier<Integer> BASE_ARMOR_CLASS = new BaseDefenseModifier();
	
	public ArmorClassProperty(Avatar avatar) {
		super(avatar, SLUG);
		this.avatar = avatar;
		modifiers.add(BASE_ARMOR_CLASS);
		modifiers.add(new ArmorBonusModifier());
		modifiers.add(new ShieldBonusModifier());
		
		if (!this.avatar.hasProperty(LevelProperty.class)) {
			this.avatar.addProperty(new LevelProperty(avatar));
		}
		this.avatar.find(LevelProperty.class).addObserver(this);
	}

	@Override
	protected Integer calculate() {
		Integer score = 0;
		score += avatar.findValueOf(LevelProperty.class) / 2;
		for (IModifier<Integer> modifier : modifiers) {
			if (modifier.isEnabled(avatar)) score += modifier.getValue(avatar);
		}
		return score;
	}

	@Override
	public void setAvatar(IAvatar avatar) {
		super.setAvatar(avatar); //To change body of generated methods, choose Tools | Templates.
		avatar.find(LevelProperty.class).addObserver(this);
	}
	
}
