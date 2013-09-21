package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class NameProperty extends CoreProperty<String> {

	public static final String SLUG = "avatar_name";

	public NameProperty(Avatar avatar) {
		super(avatar, SLUG);
	}

	@Override
	protected String calculate() {
		return "[No-Name]";
	}
}
