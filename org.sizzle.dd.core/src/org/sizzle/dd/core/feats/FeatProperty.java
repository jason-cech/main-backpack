package org.sizzle.dd.core.feats;

import org.sizzle.dd.core.properties.CoreProperty;

/**
 *
 * @author Jason
 */
public abstract class FeatProperty extends CoreProperty<IFeat> implements IFeat {
	
	@Override
	public IFeat calculate() {
		return this;
	}
}
