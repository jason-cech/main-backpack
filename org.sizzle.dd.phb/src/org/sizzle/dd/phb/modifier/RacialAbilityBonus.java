/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.phb.modifier;

import org.sizzle.dd.core.AvatarRace;
import org.sizzle.dd.core.properties.RaceProperty;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.IGrantor;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class RacialAbilityBonus implements IModifier<Integer> {

	private final Class<? extends AvatarRace> raceClass;
	private final Integer bonus;

	public RacialAbilityBonus(Class<? extends AvatarRace> raceClass, Integer bonus) {
		this.raceClass = raceClass;
		this.bonus = bonus;
	}

	@Override
	public Integer getValue(IAvatar avatar) {
		return bonus;
	}

	@Override
	public boolean isEnabled(IAvatar avatar) {
		RaceProperty avatarRace = avatar.find(RaceProperty.class);
		if (avatarRace != null && avatarRace.getValue() != null) {
			return raceClass.isInstance(avatarRace.getValue());
		}
		return false;
	}

	@Override
	public IGrantor grantedBy() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
