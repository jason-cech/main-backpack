package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class PlayerNameProperty extends CoreProperty<String> {
    
    public PlayerNameProperty() {
        super("player_name");
    }

    @Override
    protected String calculate() {
        return "[No-Player-Name]";
    }
}
