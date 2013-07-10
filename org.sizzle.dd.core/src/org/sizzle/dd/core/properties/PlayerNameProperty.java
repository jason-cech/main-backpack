package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class PlayerNameProperty extends CoreProperty<String> {

	public static final String SLUG = "player_name";

	public PlayerNameProperty() {
		super(SLUG);
	}

	@Override
	protected String calculate() {
		return "[No-Player-Name]";
	}
}
