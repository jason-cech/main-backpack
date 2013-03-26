package org.sizzle.rpg.core;

import java.util.Collection;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @param <T>
 * @author Jason Cech
 */
public interface IProperty<T> {

    T getValue();
    boolean isUserSet();

    boolean hasAlias(String alias); 
    String getSlug();

    Class<T> getType();
    
    void setAvatar(IAvatar avatar);
    
    Collection<IModifier<T>> getModifiers();
    
}
