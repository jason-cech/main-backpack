package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class HeightProperty extends CoreProperty<String> {
	public static final String SLUG = "avatar_height";
	
    public HeightProperty(Avatar avatar) {
        super(avatar, SLUG);
    }
    
    @Override
    protected String calculate() {
        return "[No-Height]";
    }
    
}
