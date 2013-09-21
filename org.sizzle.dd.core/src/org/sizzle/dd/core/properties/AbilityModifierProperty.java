package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public abstract class AbilityModifierProperty extends CoreProperty<Integer> {

    protected AbilityModifierProperty(IAvatar avatar, String slug) {
        super(avatar, slug);
        this.avatar = avatar;
    }
		
		protected abstract void init();
    
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
            Integer modifier, score = avatar.findValueOf(usedAlias.replace("modifier", "score"));
            modifier = score / 2 - 5;
            
            for (IModifier<Integer> mod : modifiers) {
                if (mod.isEnabled(avatar)) {
                    modifier += mod.getValue(avatar);
                }
            }
            return modifier;
        }
        return 0;
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
