package org.sizzle.dd.core;

/**
 *
 * @author Jason
 */
public interface AvatarClass {
	abstract void configure(Avatar avatar);
	abstract void deconfigure(Avatar avatar);
	abstract String[] getKeyAbilities();
	String getClassName();
}
