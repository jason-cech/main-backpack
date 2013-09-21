package org.sizzle.rpg.core;

import java.util.Collection;
import org.openide.util.Lookup;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @param <T>
 * @author Jason Cech
 */
public interface IProperty<T> extends IGrantor, IGrantee, Lookup.Provider {
	
	T getValue();

	boolean isUserSet();

	boolean hasAlias(String alias);

	Class<T> getType();

	void setAvatar(IAvatar avatar);

	Collection<IModifier<T>> getModifiers();

	void addModifier(IModifier<T> modifier);

	void removeModifier(IModifier<T> modifier);

	void firePropertyChange(T oldValue, T newValue);
}
