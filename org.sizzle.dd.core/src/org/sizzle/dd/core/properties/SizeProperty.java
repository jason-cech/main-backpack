package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class SizeProperty extends CoreProperty<String> {
	public static final String SLUG = "size";
	
	public SizeProperty(Avatar avatar) {
		super(avatar, SLUG);
	}

	@Override
	protected String calculate() {
		return value;
	}
	
}
