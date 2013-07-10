package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class NameProperty extends CoreProperty<String> {

	public static final String SLUG = "avatar_name";

	public NameProperty() {
		super(SLUG);
	}

	@Override
	protected String calculate() {
		return "[No-Name]";
	}
}
