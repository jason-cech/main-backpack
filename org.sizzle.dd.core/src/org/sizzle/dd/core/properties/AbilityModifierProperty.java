package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public abstract class AbilityModifierProperty extends CoreProperty<Integer> {

	protected AbilityModifierProperty(IAvatar avatar, String slug) {
		super(avatar, slug);
	}

	protected abstract void init();


	@Override
	public void setAvatar(IAvatar avatar) {
		super.setAvatar(avatar); //To change body of generated methods, choose Tools | Templates.
		init();
	}
	
	@Override
	protected Integer calculate() {
		Integer modifier = 0;
		
//		for (IModifier mod : this.getLookup().lookupAll(IModifier.class)) {
//			if (mod.isEnabled(avatar)) {
//				modifier += mod.getValue(avatar);
//			}
//		}
		
		for (IModifier<Integer> mod : modifiers) {
			if (mod.isEnabled(avatar)) {
				modifier += mod.getValue(avatar);
			}
		}
		return modifier;
	}

	public static final class SLUG {

		public static final String STRENGTH_MODIFIER = "strength_modifier";
		public static final String CONSTITUTION_MODIFIER = "constitution_modifier";
		public static final String DEXTERITY_MODIFIER = "dexterity_modifier";
		public static final String INTELLIGENCE_MODIFIER = "intelligence_modifier";
		public static final String WISDOM_MODIFIER = "wisdom_modifier";
		public static final String CHARISMA_MODIFIER = "charisma_modifier";
	}
}
