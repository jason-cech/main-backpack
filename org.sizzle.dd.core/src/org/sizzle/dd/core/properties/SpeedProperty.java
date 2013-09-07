package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class SpeedProperty extends CoreProperty<Integer> {
	public static final String SLUG = "speed";

	@Override
	protected Integer calculate() {
		Integer speed = 0;
		
		for (IModifier<Integer> iModifier : this.modifiers) {
			speed += iModifier.isEnabled(avatar) ? iModifier.getValue(avatar) : 0;
		}
		
		return speed;
	}
	
}
