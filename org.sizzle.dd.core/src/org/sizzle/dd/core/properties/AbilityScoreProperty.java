package org.sizzle.dd.core.properties;

import java.util.ArrayList;
import java.util.Collection;
import org.sizzle.rpg.core.AbstractProperty;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class AbilityScoreProperty extends AbstractProperty<Integer> {

    public Collection<IModifier<Integer>> modifiers = new ArrayList<IModifier<Integer>>(0);
    public AbilityScoreProperty(String slug) {
        super(slug);
    }
    
    @Override
    protected Integer calculate() {
        Integer score = 0;
        
        // Possible known modifiers
        // - Initial Score (rolled, bought, assigned, etc)
        // - Level Increase
        // - Race Bonus
        // - 
        for (IModifier<Integer> modifier : modifiers) {
            if (modifier.isEnabled(avatar)) {
                score += modifier.getValue();
            }
        }
        
        // must return value 1 or more
        return score<1
                ?1
                :score;
    }

    @Override
    public Collection<IModifier<Integer>> getModifiers() {
        return this.modifiers;
    }
}
