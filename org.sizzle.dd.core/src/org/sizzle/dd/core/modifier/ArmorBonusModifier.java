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
public class ArmorBonusModifier extends BonusModifier<Integer, ArmorBonusModifierType> {

	public ArmorBonusModifier() {
		super(ArmorBonusModifierType.class);
	}

	@Override
	public Integer getValue(IAvatar avatar) {
		// query the avatar's worn equipment for chest piece
		// get the value of it
		return 1;
	}

	@Override
	public boolean isEnabled(IAvatar avatar) {
		// query the avatar's worn equipment for chest piece
		// if he is wearing any return true, else false
		return true;
	}

	@Override
	public IGrantor grantedBy() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
