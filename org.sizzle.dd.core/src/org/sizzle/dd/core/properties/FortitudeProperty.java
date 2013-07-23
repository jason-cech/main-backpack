/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class FortitudeProperty extends CoreProperty<Integer> {
	public static final String SLUG = "fortitude";
	
	public FortitudeProperty(Avatar avatar) {
		super(SLUG);
		this.avatar = avatar;
		this.avatar.find(LevelProperty.class).addObserver(this);
	}

	@Override
	protected Integer calculate() {
		Integer score = 0;
		score += avatar.findValueOf(LevelProperty.class) / 2;
		for (IModifier<Integer> modifier : modifiers) {
			if (modifier.isEnabled(avatar)) {
				score += modifier.getValue();
			}
		}
		return score;
	}

	@Override
	public void setAvatar(IAvatar avatar) {
		super.setAvatar(avatar); //To change body of generated methods, choose Tools | Templates.
		this.avatar.find(LevelProperty.class).addObserver(this);
	}
	
}
