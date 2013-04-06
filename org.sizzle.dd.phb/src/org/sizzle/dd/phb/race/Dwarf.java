/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Dwarf extends AvatarRace {

    public Dwarf() {
        super("Dwarf");
    }
    
    @Override
    public void blarg(Avatar avatar) {
        avatar.<Integer>find(AbilityScoreProperty.SLUG.CONSTITUTION_SCORE).addModifier(new RacialAbilityBonus(Dwarf.class, 2));
        avatar.<Integer>find(AbilityScoreProperty.SLUG.WISDOM_SCORE).addModifier(new RacialAbilityBonus(Dwarf.class, 2));
    }

}
