package org.sizzle.dd.core.skills;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.modifier.SkillKeyAbilityModifier;
import org.sizzle.dd.core.properties.AbilityModifierProperty;
import org.sizzle.dd.core.properties.CoreProperty;
import org.sizzle.dd.core.properties.LevelProperty;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class AcrobatSkill extends CoreProperty<Integer> {
	public static String SLUG = "acrobat";

	public AcrobatSkill(Avatar avatar, String abilityModifierSlug) {
		super(SLUG);
		this.avatar = avatar;
		this.avatar.find(abilityModifierSlug, AbilityModifierProperty.class).addObserver(this);
		this.addModifier(new SkillKeyAbilityModifier(AbilityModifierProperty.SLUG.DEXTERITY_MODIFIER));
	}
	
	@Override
	protected Integer calculate() {
		Integer score = 0;
		
		Integer halfLevel = avatar.findValueOf(LevelProperty.class) / 2;
		score += halfLevel;
		
		for (IModifier<Integer> modifier : getModifiers()) {
			if (modifier.isEnabled(avatar))
				score += modifier.getValue(avatar);
		}
		
		return score;
	}
	
}
