package org.sizzle.dd.core.properties;

import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class PlayerNameProperty extends AbstractProperty<String> {
    
    public PlayerNameProperty() {
        super("player_name");
    }

    @Override
    protected String calculate() {
        return "[No-Player-Name]";
    }
}
