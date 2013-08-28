package org.sizzle.dd.core;

/**
 *
 * @author Jason
 */
public abstract class AvatarRace {

	public final String name;

	protected AvatarRace(String name) {
		this.name = name;
	}

	public abstract void configure(Avatar avatar);

	public abstract void deconfigure(Avatar avatar);

	protected String getRaceName() { return name; }
}
