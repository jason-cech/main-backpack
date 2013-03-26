package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class AbilityModifierProperty extends AbstractProperty<Integer> {

    public AbilityModifierProperty(String slug) {
        super(slug);
    }
    
    @Override
    protected Integer calculate() {
        Integer modifier = 0, score = avatar.findValueOf(SLUG.replace("modifier", "score"));
        modifier = score / 2 - 5;
        return modifier;
    }
    
}
