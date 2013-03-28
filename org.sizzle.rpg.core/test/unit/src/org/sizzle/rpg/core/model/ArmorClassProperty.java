package org.sizzle.rpg.core.model;

import org.sizzle.rpg.core.IAvatar;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import org.openide.util.Lookup;
import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class ArmorClassProperty extends AbstractProperty<Integer>{
    private List<IModifier<Integer>> modifiers = new Vector<IModifier<Integer>>(0);
    public ArmorClassProperty() {
        super("armor_class");
        modifiers.add(new FullDefense());
        modifiers.add(new IModifier<Integer>() {

            @Override
            public Integer getValue() {
                return 4;
            }

            @Override
            public boolean isEnabled(IAvatar avatar) {
                return D20Avatar.class.cast(avatar).isWearing(ArmorSlot.class);
            }
        });
    }

    @Override
    protected Integer calculate() {
        Integer ac = 0;
        
        //Add 10 for level one base AC
        ac += 10;
        // Plus half the avatar's current level
        ac += avatar.<Integer>findValueOf("avatar_level") / 2;
        
        if (!D20Avatar.class.cast(avatar).isWearingHeavyArmor()) {
            ac += avatar.<Integer>findValueOf("dexterity_mod");
        }
        
        // Include any modifiers
        for (IModifier<Integer> modifier : getModifiers()) {
            if (modifier.isEnabled(avatar)) {
                ac += modifier.getValue();
            }
        }
        
        return ac;
    }

    @Override
    public Collection<IModifier<Integer>> getModifiers() {
        return this.modifiers;
    }

    @Override
    public Lookup getLookup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
