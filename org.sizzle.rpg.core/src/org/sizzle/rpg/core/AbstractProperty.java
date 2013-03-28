package org.sizzle.rpg.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.openide.util.lookup.InstanceContent;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public abstract class AbstractProperty<T> implements IProperty<T> {
    protected InstanceContent content = new InstanceContent();
    protected IAvatar avatar;
    public Set<String> aliases = new HashSet<>(0);
    public T value;
    protected Collection<PropertyChangeListener> listeners = new ArrayList<>(0);
    
    public AbstractProperty(String...aliases) {
        this.aliases.addAll(Arrays.asList(aliases));
    }
    
    @Override
    public T getValue() {
        if(value!=null)
            return value;
        else
            return calculate();
    }
    
    @Override
    public boolean isUserSet() {
        return value!=null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<T> getType() {
        return (Class<T>) value.getClass();
    }
    
    public void setValue(T value) {
        T oldValue = this.value;
        this.value = value;
        firePropertyChange(oldValue, getValue());
    }
    public void unsetValue() {
        T oldValue = this.value;
        value = null;
        firePropertyChange(oldValue, getValue());
    }
    
    protected abstract T calculate();

    @Override
    public void setAvatar(IAvatar avatar) {
        this.avatar = avatar;
    }
    
    @Override
    public Collection<IModifier<T>> getModifiers() {
        return Collections.emptyList();
    }
    
    @Override
    public void addModifier(IModifier<T> modifier) {
        T oldValue = getValue();
        getModifiers().add(modifier);
        firePropertyChange(oldValue, getValue());
    }
    
    @Override
    public void removeModifier(IModifier<T> modifier) {
        T oldValue = getValue();
        getModifiers().remove(modifier);
        firePropertyChange(oldValue, getValue());
    }
    
    @Override
    public boolean hasAlias(String alias) {
        return this.aliases.contains(alias);
    }

    //<editor-fold defaultstate="collapsed" desc="Value Listeners">
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.listeners.add(listener);
    }
    
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.listeners.remove(listener);
    }
    //</editor-fold>

    @Override
    public void firePropertyChange(T oldValue, T newValue) {
        for (PropertyChangeListener listener : this.listeners) {
            listener.propertyChange(new PropertyChangeEvent(this, this.aliases.iterator().next(), oldValue, newValue));
        }
    }
}
