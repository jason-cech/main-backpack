/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.modifier;

import java.util.logging.Logger;
import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.IGrantor;

/**
 *
 * @author Jason
 */
public class SkillKeyAbilityModifier extends BonusModifier<Integer, UntypedBonusModifierType> {

	private final Class<? extends AbilityModifierProperty> abilityModifierPropertyClass;

	public SkillKeyAbilityModifier(Class<? extends AbilityModifierProperty> abilityModifierPropertyClass) {
		super(UntypedBonusModifierType.class);
		this.abilityModifierPropertyClass = abilityModifierPropertyClass;
	}

	@Override
	public Integer getValue(IAvatar avatar) {
		AbilityModifierProperty abilityModifierProperty = avatar.find(abilityModifierPropertyClass);
		if (null == abilityModifierProperty) {
			Logger.getLogger(SkillKeyAbilityModifier.class.getName()).severe("Property not found!");
			return -1;
		} else
			return abilityModifierProperty.getValue();
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
