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
public class WillProperty extends CoreProperty<Integer> {
	public static final String SLUG = "will";
	
	public WillProperty(Avatar avatar) {
		super(avatar, SLUG);
		this.avatar.find(LevelProperty.class).addObserver(this);
		this.avatar.find(AbilityModifierProperty.SLUG.WISDOM_MODIFIER, AbilityModifierProperty.class).addObserver(this);
		this.avatar.find(AbilityModifierProperty.SLUG.CHARISMA_MODIFIER, AbilityModifierProperty.class).addObserver(this);
	}

	@Override
	protected Integer calculate() {
		Integer score = 0;
		
		// Calculate the default ability modifier to use
		AbilityModifier abilityModifier = this.getLookup().lookup(AbilityModifier.class);
		if (null == abilityModifier) {
			AbilityModifierProperty wisdomModifierProperty = avatar.find(AbilityModifierProperty.SLUG.WISDOM_MODIFIER, AbilityModifierProperty.class);
			AbilityModifierProperty charismaModifierProperty = avatar.find(AbilityModifierProperty.SLUG.CHARISMA_MODIFIER, AbilityModifierProperty.class);
			abilityModifier = wisdomModifierProperty.getValue().compareTo(charismaModifierProperty.getValue())>0 
							? new AbilityModifier(AbilityModifierProperty.SLUG.WISDOM_MODIFIER) 
							: new AbilityModifier(AbilityModifierProperty.SLUG.CHARISMA_MODIFIER);
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
