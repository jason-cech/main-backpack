package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class GenderProperty extends CoreProperty<String> {

	public static final String SLUG = "avatar_gender";

	public GenderProperty(Avatar avatar) {
		super(avatar, SLUG);
	}

	@Override
	protected String calculate() {
		return "[No-Gender]";
	}

}
