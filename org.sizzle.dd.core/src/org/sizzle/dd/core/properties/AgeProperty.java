package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class AgeProperty extends CoreProperty<Float> {

	public static final String SLUG = "avatar_age";

	public AgeProperty(Avatar avatar) {
		super(avatar, SLUG);
	}

	@Override
	protected Float calculate() {
		return Float.NaN;
	}

}
