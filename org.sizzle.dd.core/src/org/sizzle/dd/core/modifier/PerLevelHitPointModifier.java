package org.sizzle.dd.core.modifier;

/**
 *
 * @author Jason
 */
public abstract class PerLevelHitPointModifier extends BonusModifier<Integer, UntypedBonusModifierType> {
	public PerLevelHitPointModifier() {
		super(UntypedBonusModifierType.class);
	}
}
