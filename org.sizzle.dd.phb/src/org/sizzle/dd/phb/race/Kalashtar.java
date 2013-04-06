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
    
    public Kalashtar() { super("Kalashtar"); }

    @Override
    public void blarg(Avatar avatar) {
        avatar.<Integer>find(AbilityScoreProperty.SLUG.INTELLIGENCE_SCORE).addModifier(new RacialAbilityBonus(Kalashtar.class, 2));
        avatar.<Integer>find(AbilityScoreProperty.SLUG.CHARISMA_SCORE).addModifier(new RacialAbilityBonus(Kalashtar.class, 2));
    }
    
}
