package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class WeightProperty extends CoreProperty<Double> {

	public static final String SLUG = "avatar_weight";

	public WeightProperty(Avatar avatar) {
		super(avatar, SLUG);
	}

	@Override
	protected Double calculate() {
		return 1.0;
	}

}
