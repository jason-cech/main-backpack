package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class SizeProperty extends CoreProperty<String> {
	public static final String SLUG = "size";

	@Override
	protected String calculate() {
		return value;
	}
	
}
