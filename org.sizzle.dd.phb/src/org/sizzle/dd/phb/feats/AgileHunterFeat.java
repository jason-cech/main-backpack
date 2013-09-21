/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.phb.feats;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.feats.FeatProperty;
import org.sizzle.dd.core.properties.AbilityScoreProperty;
import org.sizzle.dd.core.properties.ClassProperty;
import org.sizzle.dd.phb.RangerClass;

/**
 *
 * @author Jason
 */
public class AgileHunterFeat extends FeatProperty {
	protected static final String AGILE_HUNTER_FEAT_NAME = "Agile Hunter";
	
	public AgileHunterFeat(Avatar avatar) {
		super(avatar, AGILE_HUNTER_FEAT_NAME);
	}

	// <editor-fold desc=" IFeat Implementation ">
	@Override
	public String getName() {
		return AGILE_HUNTER_FEAT_NAME;
	}

	@Override
	public boolean canBeAppliedTo(Avatar avatar) {
		
		// Race must be human
		ClassProperty classProperty = avatar.find(ClassProperty.class);
		boolean isRanger = false;
		if (null != classProperty 
						&& null != classProperty.getValue())
			isRanger = classProperty.getValue().getClassName().equals(RangerClass.RANGER_CLASS_NAME);
		
		// Dexterity Score must be 15 or greater
		boolean isDexterityScoreHighEnough = false;
		if (null != avatar.find(AbilityScoreProperty.SLUG.DEXTERITY_SCORE, AbilityScoreProperty.class))
			isDexterityScoreHighEnough = avatar.<Integer>findValueOf(AbilityScoreProperty.SLUG.DEXTERITY_SCORE) >= 15;
		
		// Have [Hunter's Quarry] class feature
		boolean hasHuntersQuarry = false;
		// TODO: Query avatar if Hunter's Quarry is present
		
		return isRanger && isDexterityScoreHighEnough && hasHuntersQuarry;
	}

	@Override
	public void applyTo(Avatar avatar) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void removeFrom(Avatar avatar) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	// </editor-fold>
}
