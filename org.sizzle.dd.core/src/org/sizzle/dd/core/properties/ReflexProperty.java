/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.openide.util.Exceptions;
import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.modifier.AbilityModifier;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class ReflexProperty extends CoreProperty<Integer> {
	public static final String SLUG = "reflex";
	
	public ReflexProperty(Avatar avatar) {
		super(avatar, SLUG);
		this.avatar.find(LevelProperty.class).addObserver(this);
		this.avatar.find(AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER, AbilityModifierProperty.class).addObserver(this);
		this.avatar.find(AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER, AbilityModifierProperty.class).addObserver(this);
	}

	@Override
	protected Integer calculate() {
		Integer score = 0;
		
		// Calculate the default ability modifier to use
		AbilityModifier abilityModifier = this.getLookup().lookup(AbilityModifier.class);
		if (null == abilityModifier) {
			AbilityModifierProperty dexterityModifierProperty = avatar.find(AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER, AbilityModifierProperty.class);
			AbilityModifierProperty intelligenceModifierProperty = avatar.find(AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER, AbilityModifierProperty.class);
			abilityModifier = dexterityModifierProperty.getValue().compareTo(intelligenceModifierProperty.getValue())>0 
							? new AbilityModifier(AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER) 
							: new AbilityModifier(AbilityModifierProperty.SLUG.INTELLIGENCE_MODIFIER);
		}
		
		score += avatar.findValueOf(LevelProperty.class) / 2;
		score += abilityModifier.isEnabled(avatar) ? abilityModifier.getValue(avatar) : 0;
		
		// Add in the other modifiers
		for (IModifier<?> modifier : this.getLookup().lookupAll(IModifier.class)) {
			if (modifier.getClass().isAssignableFrom(AbilityModifier.class))
				continue;
			
			// else add if enabled
			if (modifier.isEnabled(avatar)) {
				Object modifierValue = modifier.getValue(avatar);
				try {
					score += Integer.class.cast(modifierValue);
				} catch (ClassCastException cce) {
					Exceptions.printStackTrace(cce);
				}
			}
		}
		return score;
	}
	
}
