package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.AvatarClass;

/**
 *
 * @author Jason
 */
public class ClassProperty extends CoreProperty<AvatarClass> {
	public static final String SLUG = "class";
	
	public ClassProperty(Avatar avatar) {
		super(avatar, SLUG);
	}

	@Override
	protected AvatarClass calculate() {
		return value;
	}

	@Override
	public void setValue(AvatarClass value) {
		if (Avatar.class.isInstance(avatar)) {
			if (null!=getValue())
				getValue().deconfigure(Avatar.class.cast(avatar));
			super.setValue(value);
			value.configure(Avatar.class.cast(avatar));
		}
	}
	
}
