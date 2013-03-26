package org.sizzle.rpg.core.model;

/**
 *
 * @author Jason Cech
 */
public abstract class BasicInfo {
	private final String name;

	public BasicInfo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
