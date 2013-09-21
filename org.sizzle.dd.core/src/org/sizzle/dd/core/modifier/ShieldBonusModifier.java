/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.modifier;

import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.IGrantor;

/**
 *
 * @author Jason
 */
public class ShieldBonusModifier extends BonusModifier<Integer, ShieldBonusModifierType> {

	public ShieldBonusModifier() {
		super(ShieldBonusModifierType.class);
	}

	@Override
	public Integer getValue(IAvatar avatar) {
		return 1;
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
