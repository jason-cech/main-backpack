/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.IGrantor;

/**
 *
 * @author Jason
 * @param <T>
 */
public abstract class CorePowerProperty<T> extends CoreProperty<T>{

	protected CorePowerProperty(IGrantor grantor, String... aliases) {
		super(grantor, aliases);
	}
	
	abstract int getPowerLevel();
	abstract String getPowerName();
	abstract String getFlavorText();
	
	/**
	 * Free, Minor, Move, Standard, Immediate Reaction, Immediate Interrupt
	 * @return 
	 */
	abstract Object getActionType();
	
	/**
	 * At-Will, Encounter, Daily
	 * @return 
	 */
	abstract Object getActionSize();
	abstract Object getPowerScope();
	abstract String getRequirementText();
	abstract boolean hasRequirement();
	abstract boolean isRequirementMet();
	abstract String getPowerTargetText();
	abstract String getAttackText();
	abstract String getHitText();
	abstract String getMissText();
	abstract int getUsageCount();
	abstract int isSpent();
}
