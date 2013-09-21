/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.modifier;

import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.IGrantor;

/**
 *
 * @author Jason
 */
public class SkillKeyAbilityModifier extends BonusModifier<Integer, UntypedBonusModifierType> {

	private final String abilityModifierSlug;

	public SkillKeyAbilityModifier(String abilityModifierSlug) {
		super(UntypedBonusModifierType.class);
		this.abilityModifierSlug = abilityModifierSlug;
	}

	@Override
	public Integer getValue(IAvatar avatar) {
		return avatar
						.find(abilityModifierSlug, AbilityModifierProperty.class)
						.getValue();
	}

	@Override
	public boolean isEnabled(IAvatar avatar) {
		return true;
	}

	@Override
	public IGrantor grantedBy() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
