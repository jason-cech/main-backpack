package org.sizzle.dd.core.properties;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Jason
 */
public class AbilityModifierProperty extends CoreProperty<Integer> implements PropertyChangeListener {

    public AbilityModifierProperty(String slug) {
        super(slug);
    }
    
    @Override
    protected Integer calculate() {
        String usedAlias = null;
        for (String alias : this.aliases) {
            if (alias.endsWith("modifier")) {
                usedAlias = alias;
                break;
            }
        }
        
        if (null!=usedAlias) {
            Integer modifier = 0, score = avatar.findValueOf(usedAlias.replace("modifier", "score"));
            modifier = score / 2 - 5;
            return modifier;
        }
        return 0;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.unsetValue();
    }
    
    public static final class SLUG {
        public static final String STRENGTH_MODIFIER = "strength_modifier";
        public static final String CONSTITUTION_MODIFIER = "constitution_modifier";
        public static final String DEXTERITY_MODIFIER = "dexterity_modifier";
        public static final String INTELLIGENCE_MODIFIER = "intelligence_modifier";
        public static final String WISDOM_MODIFIER = "wisdom_modifier";
        public static final String CHARISMA_MODIFIER = "charisma_modifier";
    }
}
