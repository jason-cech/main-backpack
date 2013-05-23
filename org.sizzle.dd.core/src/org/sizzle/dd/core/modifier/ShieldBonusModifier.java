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
public class ShieldBonusModifier implements IModifier<Integer> {

	@Override
	public Integer getValue() {
		return 1;
	}

	@Override
	public boolean isEnabled(IAvatar avatar) {
		return true;
	}
	
}