package org.sizzle.rpg.core;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public abstract class AbstractProperty<T> implements IProperty<T> {
    protected IAvatar avatar;
    public Set<String> aliases = new HashSet<String>();
    public final String SLUG;
    public T value;
    
    public AbstractProperty(String SLUG) {
        this.aliases.add(SLUG);
        this.SLUG = SLUG;
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
    public String getSlug() {
        return SLUG;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<T> getType() {
        return (Class<T>) value.getClass();
    }
    
    public void setValue(T value) { this.value = value; }
    public void unsetValue() {
        value = null;
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
    
    public void addModifier(IModifier<T> modifier) {
        getModifiers().add(modifier);
    }
    
    public void removeModifier(IModifier<T> modifier) {
        getModifiers().remove(modifier);
    }
    
    @Override
    public boolean hasAlias(String alias) {
        return this.aliases.contains(alias);
    }
}
