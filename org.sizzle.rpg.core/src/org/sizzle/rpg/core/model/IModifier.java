package org.sizzle.rpg.core.model;

import org.sizzle.rpg.core.IAvatar;

/**
 *
 * @author Jason
 */
public interface IModifier<T> {
    T getValue();
    boolean isEnabled(IAvatar avatar);
}
