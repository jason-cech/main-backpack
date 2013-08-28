package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.AvatarRace;
import org.sizzle.rpg.core.IAvatar;

/**
 *
 * @author Jason
 */
public class RaceProperty extends CoreProperty<AvatarRace> {

	private AvatarRace race;

	public RaceProperty(AvatarRace race) {
		this.race = race;
	}

	@Override
	protected AvatarRace calculate() {
		return race;
	}

	@Override
	public void setAvatar(IAvatar avatar) {
		if (Avatar.class.isInstance(avatar)) {
			if (null != getValue()) {
				getValue().deconfigure(Avatar.class.cast(avatar));
			}
			super.setValue(value);
			value.configure(Avatar.class.cast(avatar));
		}
	}
}
