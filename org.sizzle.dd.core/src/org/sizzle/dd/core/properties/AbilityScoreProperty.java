package org.sizzle.dd.core.properties;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.sizzle.rpg.core.AbstractProperty;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class AbilityScoreProperty extends AbstractProperty<Integer> {
    protected final AbstractLookup modifierLookup;
    public Collection<IModifier<Integer>> modifiers = new ArrayList<>(0);
    public AbilityScoreProperty(String...slugs) {
        super(slugs);
        modifierLookup = new AbstractLookup(content);
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

    @Override
    public Lookup getLookup() {
        return modifierLookup;
    }
    
    public static final class SLUG {
        public final static String STRENGTH_SCORE = "strength_score";
        public static final String CONSTITUTION_SCORE = "constitution_score";
        public static final String DEXTERITY_SCORE = "dexterity_score";
        public static final String INTELLIGENCE_SCORE = "intelligence_score";
        public static final String WISDOM_SCORE = "wisdom_score";
        public static final String CHARISMA_SCORE = "charisma_score";
    }
}
