package org.sizzle.dd.phb.race;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.AvatarRace;

/**
 *
 * @author Jason
 */
public class HumanRace extends AvatarRace {
	public static final String HUMAN_RACE_NAME = "Human";

	public HumanRace() {
		super(HUMAN_RACE_NAME);
	}
	
	@Override
	public void configure(Avatar avatar) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void deconfigure(Avatar avatar) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
