package org.sizzle.rpg.core.model;

import org.sizzle.rpg.core.IAvatar;

/**
 *
 * @author Jason
 */
public interface IModifier<T> {
    T getValue(IAvatar avatar);
    boolean isEnabled(IAvatar avatar);
}
