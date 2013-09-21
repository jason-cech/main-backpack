package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class PlayerNameProperty extends CoreProperty<String> {

	public static final String SLUG = "player_name";

	public PlayerNameProperty(Avatar avatar) {
		super(avatar, SLUG);
	}

	@Override
	protected String calculate() {
		return "[No-Player-Name]";
	}
}
