package org.sizzle.dd.phb.race;

import org.openide.util.lookup.ServiceProvider;
import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.AvatarRace;
import org.sizzle.dd.core.properties.AbilityScoreProperty;
import org.sizzle.dd.phb.modifier.RacialAbilityBonus;

/**
 *
 * @author Jason
 */
@ServiceProvider(service = AvatarRace.class)
public class Kalashtar extends AvatarRace {

	public Kalashtar() {
		super("Kalashtar");
	}

	@Override
	public void configure(Avatar avatar) {
	}

	@Override
	public void deconfigure(Avatar avatar) {
		avatar.find(AbilityScoreProperty.SLUG.INTELLIGENCE_SCORE, AbilityScoreProperty.class).removeModifier(new RacialAbilityBonus(Kalashtar.class, 2));
		avatar.find(AbilityScoreProperty.SLUG.CHARISMA_SCORE, AbilityScoreProperty.class).removeModifier(new RacialAbilityBonus(Kalashtar.class, 2));
	}
}
