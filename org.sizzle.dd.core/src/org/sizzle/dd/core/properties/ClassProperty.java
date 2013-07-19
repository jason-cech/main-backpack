package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.AvatarClass;

/**
 *
 * @author Jason
 */
public class ClassProperty extends CoreProperty<AvatarClass> {

	@Override
	protected AvatarClass calculate() {
		return value;
	}

	@Override
	public void setValue(AvatarClass value) {
		super.setValue(value);
		
	}
	
}
