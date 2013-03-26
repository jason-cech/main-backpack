package org.sizzle.rpg.core;

/**
 *
 * @author Jason Cech
 */
public interface IAvatar {

    <C extends IProperty<T>, T> C find(Class<C> propertyClass);
    <T> IProperty<T> find(String slug);
    <C extends IProperty<T>, T> T findValueOf(Class<C> propertyClass);
    <T> T findValueOf(String slug);
    
    <T> void addProperty(IProperty<T> property);
    <T> void addProperties(IProperty<T>...properties);
    <T> void removeProperty(IProperty<T> property);
    <T> void removeAllProperties(Class<? extends IProperty<T>> propertyClass);
    
    boolean hasState(Class<? extends IState> stateClass);
}
