package org.sizzle.dd.core.feats;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public interface IFeat {
	public String getName();
	
	/**
	 * Method to determine all prerequisites for obtaining the feat
	 * @param avatar
	 * @return 
	 */
	public boolean canBeAppliedTo(Avatar avatar);
	public void applyTo(Avatar avatar);
	public void removeFrom(Avatar avatar);
}
