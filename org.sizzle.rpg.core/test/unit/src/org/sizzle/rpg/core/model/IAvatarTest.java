package org.sizzle.rpg.core.model;

import org.sizzle.rpg.core.IProperty;
import org.sizzle.rpg.core.IAvatar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openide.util.Lookup;
import org.sizzle.rpg.core.AbstractProperty;

/**
 *
 * @author Jason
 */
public class IAvatarTest {
    private D20Avatar me;
    
    public IAvatarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        me = new D20Avatar() {

            @Override
            public boolean isWearingHeavyArmor() {
                return false;
            }

            @Override
            public boolean isInFullDefense() {
                return false;
            }

            @Override
            public void firePropertyChanged() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class IAvatar.
     */
    @Test
    public void testFind_NoName() {
        System.out.println("find");
        Class<? extends IProperty<String>> x = NameProperty.class;
        IAvatar instance = me;
        String expResult = "[Name]";
        String result = instance.findValueOf(x);
        assertEquals(expResult, result);
    }

    @Test
    public void testFind_SuppliedName() {
        System.out.println("find");
        Class<? extends IProperty<String>> x = NameProperty.class;
        IAvatar instance = new D20AvatarImpl();
        instance.find(NameProperty.class).setValue("Scooby");
        String expResult = "Scooby";
        String result = instance.findValueOf(x);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFind_SimpleSum() {
        AbstractProperty<Integer> propA = new AbstractProperty<Integer>("a") {
            @Override
            protected Integer calculate() {
                return 1;
            }

            @Override
            public boolean hasAlias(String alias) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Lookup getLookup() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        AbstractProperty<Integer> propB = new AbstractProperty<Integer>("b") {
            @Override
            protected Integer calculate() {
                return 2;
            }

            @Override
            public boolean hasAlias(String alias) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Lookup getLookup() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        AbstractProperty<Integer> propC = new AbstractProperty<Integer>("c") {
            @Override
            protected Integer calculate() {
                return avatar.<Integer>find("a").getValue() + avatar.<Integer>find("b").getValue();
            }

            @Override
            public boolean hasAlias(String alias) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Lookup getLookup() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        me.addProperties(propA, propB, propC);
        
        Integer expResult = 3;
        Integer result = me.<Integer>findValueOf("c");
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFind_ArmorClassSum() {
        AbstractProperty<Integer> experience = new AbstractProperty<Integer>("avatar_experience") {
            @Override
            protected Integer calculate() {
                return 9998;
            }

            @Override
            public boolean hasAlias(String alias) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Lookup getLookup() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        AbstractProperty<Integer> dexMod = new AbstractProperty<Integer>("dexterity_mod") {
            @Override
            protected Integer calculate() {
                return 12;
            }

            @Override
            public boolean hasAlias(String alias) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Lookup getLookup() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        me.addState(FullDefense.class);
        me.addState(FullDefense.class);
        me.addProperties(experience, new LevelProperty(), dexMod, new ArmorClassProperty());
        me.removeState(FullDefense.class);
        me.removeState(FullDefense.class);
        
        me.addState(FullDefense.class);
        Integer expResult = 26;
        Integer result = me.<Integer>findValueOf("armor_class");
        
        assertEquals(expResult, result);
    }
    
    private class D20AvatarImpl extends D20Avatar {

        public D20AvatarImpl() {
        }

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
    }
}