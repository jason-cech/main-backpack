package org.sizzle.rpg.core;

import org.openide.util.Lookup;

/**
 *
 * @author Jason Cech
 */
public interface IAvatar extends IGrantor, Lookup.Provider {

    <C extends IProperty<T>, T> C find(Class<C> propertyClass);
    <T> IProperty<T> find(String slug);
		<C extends IProperty<T>, T> C find(String slug, Class<C> propertyClass);
    <C extends IProperty<T>, T> T findValueOf(Class<C> propertyClass);
    <T> T findValueOf(String slug);
    
    <T> void addProperty(IProperty<T> property);
    void addProperties(IProperty<?>...properties);
		<C extends IProperty<T>, T> boolean hasProperty(Class<C> propertyClass);
    boolean hasProperty(String slug);
    <T> void removeProperty(IProperty<T> property);
    void removeAllProperties(Class<? extends IProperty<?>> propertyClass);
    void removeAllProperties();
    
    boolean hasState(Class<? extends IState> stateClass);
    
    void firePropertyChanged();
}
