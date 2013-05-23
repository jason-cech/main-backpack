package org.sizzle.rpg.core.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.sizzle.rpg.core.IProperty;
import org.sizzle.rpg.core.IAvatar;
import org.openide.util.Lookup;
import org.openide.util.Lookup.Item;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.sizzle.rpg.core.IState;

/**
 *
 * @author Jason
 */
public abstract class D20Avatar implements IAvatar {

    @Override
    public Lookup getLookup() {
        return propertyLookup;
    }
    private InstanceContent content = new InstanceContent();
    protected Lookup propertyLookup = new AbstractLookup(content);
    private InstanceContent wearingContent = new InstanceContent();
    protected Lookup wearingLookup = new AbstractLookup(wearingContent);
    private InstanceContent stateContent = new InstanceContent();
    protected Lookup stateLookup = new AbstractLookup(stateContent);
    
    public D20Avatar() {
        content.add(new NameProperty());
    }
    
    public String getName() { return findValueOf(NameProperty.class); }
    
    @Override
    public <C extends IProperty<T>, T> C find(Class<C> propertyClass) {
        C property = propertyLookup.lookup(propertyClass);
        return property;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> IProperty<T> find(String slug) {
        for (IProperty<?> property : propertyLookup.lookupAll(IProperty.class)) {
            if (property.hasAlias(slug)) {
                return (IProperty<T>) property;
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public <C extends IProperty<T>, T> T findValueOf(Class<C> propertyClass) {
        IProperty<T> property = find(propertyClass);
        T value = property.getValue();
        return value;
    }

    @Override
    public <T> T findValueOf(String slug) {
        return this.<T>find(slug).getValue();
    }
    
    @Override
    public boolean hasState(Class<? extends IState> classState) {
        return null != stateLookup.lookup(classState.getClass());
    }
    
    public void addState(Class<? extends IState> state) {
        try {
            if(!hasState(state) || state.newInstance().isStackable())
            stateContent.add(state);
        } catch (InstantiationException ex) {
            Logger.getLogger(D20Avatar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(D20Avatar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeState(Class<? extends IState> state) {
        try {
            do {
                if (hasState(state))
                    stateContent.remove(state);
            } while(hasState(state) && state.newInstance().isStackable());
        } catch (InstantiationException ex) {
            Logger.getLogger(D20Avatar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(D20Avatar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public <T> void addProperty(IProperty<T> property) {
        property.setAvatar(this);
        this.content.add(property);
    }
    
//        public <T> void addProperties(IProperty<T>...properties) {
//        for (IProperty<T> property : properties) {
//            addProperty(property);
//        }
//    }
    
    @Override
    public <T> void removeProperty(IProperty<T> property) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        @SuppressWarnings("unchecked")
        Class<IProperty<T>> type = (Class<IProperty<T>>) property.getType();
        String id = "[id]";
        Lookup.Template<IProperty<T>> templatedProperty = new Lookup.Template<IProperty<T>>(type, id, property);
        Item<IProperty<T>> item = this.propertyLookup.lookupItem(templatedProperty);
        this.content.remove(item.getInstance());
    }

//    @Override
//    public <T> void removeAllProperties(Class<? extends IProperty<T>> propertyClass) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    /**
     *
     * @param wearableClass
     * @return
     */
    public boolean isWearing(Class<? extends IWearable> wearableClass) {
        IWearable wearable = wearingLookup.lookup(wearableClass);
        return wearable!=null;
    }
    
    public abstract boolean isWearingHeavyArmor();
    public abstract boolean isInFullDefense();
}
