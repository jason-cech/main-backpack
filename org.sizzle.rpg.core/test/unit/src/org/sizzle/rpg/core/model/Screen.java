package org.sizzle.rpg.core.model;

/**
 *
 * @author Jason
 */
public class Screen {

    public Screen() {
        D20Avatar me = new D20Avatar() {

            @Override
            public boolean isWearingHeavyArmor() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isInFullDefense() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void firePropertyChanged() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        String myName = me.findValueOf(NameProperty.class);
    }
}
