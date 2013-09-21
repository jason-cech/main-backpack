package org.sizzle.dd.core.feats;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.CoreProperty;

/**
 *
 * @author Jason
 */
public abstract class FeatProperty extends CoreProperty<IFeat> implements IFeat {
	
	protected FeatProperty(Avatar avatar, String...aliases) {
		super(avatar, aliases);
	}
	
	@Override
	public IFeat calculate() {
		return this;
	}
}
