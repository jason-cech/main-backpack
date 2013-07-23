package org.sizzle.dd.phb;

import org.openide.util.lookup.ServiceProvider;
import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.AvatarClass;
import org.sizzle.dd.core.properties.ClassProperty;
import org.sizzle.dd.core.properties.FortitudeProperty;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
@ServiceProvider(service = AvatarClass.class)
public class ClericClass implements AvatarClass {
	public static final IModifier<Integer> FORTITUDE_DEFENSE_BONUS = new IModifier<Integer>() {

			@Override
			public Integer getValue() {
				return 2;
			}

			@Override
			public boolean isEnabled(IAvatar avatar) {
				return avatar.find(ClassProperty.class).getValue().getClass().isAssignableFrom(ClericClass.class);
			}
		};
	
	@Override
	public void configure(Avatar avatar) {
		// Bonus to Defense
		avatar.find(FortitudeProperty.class).addModifier(FORTITUDE_DEFENSE_BONUS);
	}

	@Override
	public void deconfigure(Avatar avatar) {
		avatar.find(FortitudeProperty.class).removeModifier(FORTITUDE_DEFENSE_BONUS);
	}

	@Override
	public String getClassName() {
		return "Cleric";
	}
	
}
