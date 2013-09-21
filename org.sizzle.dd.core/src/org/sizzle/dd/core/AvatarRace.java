package org.sizzle.dd.core;

import org.sizzle.rpg.core.IGrantor;

/**
 *
 * @author Jason
 */
public abstract class AvatarRace implements IGrantor {

	public final String name;

	protected AvatarRace(String name) {
		this.name = name;
	}

	public abstract void configure(Avatar avatar);

	public abstract void deconfigure(Avatar avatar);

	protected String getRaceName() { return name; }
}
