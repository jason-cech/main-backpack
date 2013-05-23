/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.modifier.ArmorBonusModifier;
import org.sizzle.dd.core.modifier.BaseDefenseModifier;
import org.sizzle.dd.core.modifier.ShieldBonusModifier;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class ArmorClassProperty extends CoreProperty<Integer> {
	public static final String SLUG = "armor_class";
	public static final IModifier<Integer> BASE_ARMOR_CLASS = new BaseDefenseModifier();
	
	public ArmorClassProperty() {
		super(SLUG);
		modifiers.add(BASE_ARMOR_CLASS);
		modifiers.add(new ArmorBonusModifier());
		modifiers.add(new ShieldBonusModifier());
	}

	@Override
	protected Integer calculate() {
		Integer score = 0;
		score += avatar.findValueOf(LevelProperty.class) / 2;
		for (IModifier<Integer> modifier : modifiers) {
			if (modifier.isEnabled(avatar)) score += modifier.getValue();
		}
		return score;
	}
	
}
