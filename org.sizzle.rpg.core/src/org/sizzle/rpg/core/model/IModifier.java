package org.sizzle.rpg.core.model;

import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.IGrantee;

/**
 *
 * @author Jason
 * @param <T>
 */
public interface IModifier<T> extends IGrantee {
    T getValue(IAvatar avatar);
    boolean isEnabled(IAvatar avatar);
}
