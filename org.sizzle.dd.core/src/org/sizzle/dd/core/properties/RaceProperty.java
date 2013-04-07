package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.AvatarRace;
import org.sizzle.rpg.core.IAvatar;

/**
 *
 * @author Jason
 */
public class RaceProperty extends CoreProperty<AvatarRace>{
    private AvatarRace race;
    
    public RaceProperty(AvatarRace race) {
        this.race = race;
    }

    @Override
    protected AvatarRace calculate() {
        return race;
    }

    @Override
    public void setAvatar(IAvatar avatar) {
        System.out.println("HERE!!");
        super.setAvatar(avatar); //To change body of generated methods, choose Tools | Templates.
        race.blarg(Avatar.class.cast(avatar));
    }
    
}
