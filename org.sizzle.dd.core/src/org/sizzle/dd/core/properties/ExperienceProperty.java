package org.sizzle.dd.core.properties;

import java.util.ArrayList;
import java.util.List;
import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class ExperienceProperty extends AbstractProperty<Integer>{
    private List<Integer> xpEntries = new ArrayList<Integer>(0);
    
    public ExperienceProperty() {
        super("avatar_experience");
    }

    @Override
    protected Integer calculate() {
        Integer xpTotal = 0;
        for (Integer xpEntry : xpEntries) {
            xpTotal += xpEntry;
        }
        return xpTotal;
    }
    
    public void adjust(Integer amount) {
        xpEntries.add(amount);
    }
}
