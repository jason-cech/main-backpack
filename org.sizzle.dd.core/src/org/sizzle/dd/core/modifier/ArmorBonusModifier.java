/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.modifier;

import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class ArmorBonusModifier implements IModifier<Integer> {

	@Override
	public Integer getValue() {
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
	
}
