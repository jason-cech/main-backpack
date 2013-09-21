package org.sizzle.dd.phb.feats;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.feats.IFeat;
import org.sizzle.dd.core.modifier.BonusModifier;
import org.sizzle.dd.core.modifier.UntypedBonusModifierType;
import org.sizzle.dd.core.properties.RaceProperty;
import org.sizzle.dd.phb.race.HumanRace;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.IGrantor;

/**
 *
 * @author Jason
 */
public class ActionSurgeFeat implements IFeat {
	protected static final String FEAT_NAME = "Action Surge";
	
	@Override
	public String getName() {
		return FEAT_NAME;
	}

	@Override
	public boolean canBeAppliedTo(Avatar avatar) {
		// Race must be human
		RaceProperty raceProperty = avatar.find(RaceProperty.class);
		boolean isHuman = false;
		if (null != raceProperty 
						&& null != raceProperty.getValue())
			isHuman = raceProperty.getValue().name.equals(HumanRace.HUMAN_RACE_NAME);
		
		return isHuman;
	}

	@Override
	public void applyTo(Avatar avatar) {
		// TODO: define a way to grant feats to avatars
	}

	@Override
	public void removeFrom(Avatar avatar) {
		// TODO: define a way to revoke feats from avatars
	}
	
	public class AttackRollModifier extends BonusModifier<Integer, UntypedBonusModifierType> {
		
		public AttackRollModifier() { super(UntypedBonusModifierType.class); }

		@Override
		public Integer getValue(IAvatar avatar) {
			return 3;
		}

		@Override
		public boolean isEnabled(IAvatar avatar) {
			// Does avatar have this feat?
			boolean isFeatGrantedToAvatar = false;
			// Was an action point used?
			boolean isActionPointUsed = false;
			
			return isFeatGrantedToAvatar && isActionPointUsed;
		}

		@Override
		public IGrantor grantedBy() {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
		
	}
}
