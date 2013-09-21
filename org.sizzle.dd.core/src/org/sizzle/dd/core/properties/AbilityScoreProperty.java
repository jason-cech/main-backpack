package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public abstract class AbilityScoreProperty extends CoreProperty<Integer> {
    public AbilityScoreProperty(IAvatar avatar, String...slugs) {
        super(avatar, slugs);
        this.avatar = avatar;
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
                score += modifier.getValue(avatar);
            }
        }
        
        // must return value 1 or more
        return score<1
                ?1
                :score;
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
