package org.sizzle.dd.phb.feats;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.feats.FeatProperty;
import org.sizzle.dd.core.modifier.BonusModifier;
import org.sizzle.dd.core.modifier.FeatBonusModifierType;
import org.sizzle.dd.core.properties.FortitudeProperty;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.IGrantor;

/**
 *
 * @author Jason
 */
public class GreatFortitudeFeat extends FeatProperty {
	protected final static String GREAT_FORTITUDE_FEAT_NAME = "Great Fortitude";

	public GreatFortitudeFeat(Avatar avatar) {
		super(avatar, GREAT_FORTITUDE_FEAT_NAME);
	}
	
	@Override
	public String getName() {
		return GREAT_FORTITUDE_FEAT_NAME;
	}

	@Override
	public boolean canBeAppliedTo(Avatar avatar) {
		return true;
	}
	
	public static GreatFortitudeFeat apply(Avatar avatar) {
		GreatFortitudeFeat gff = new GreatFortitudeFeat(avatar);
		avatar.addProperty(gff);
		gff.applyTo(avatar);
		return gff;
	}

	@Override
	public void applyTo(Avatar avatar) {
		FortitudeProperty fortitudeProperty = avatar.find(FortitudeProperty.class);
		fortitudeProperty.addModifier(featFortitudeDefenseModifier);
	}

	@Override
	public void removeFrom(Avatar avatar) {
		FortitudeProperty fortitudeProperty = avatar.find(FortitudeProperty.class);
		fortitudeProperty.removeModifier(featFortitudeDefenseModifier);
	}
	
	protected final BonusModifier<Integer, FeatBonusModifierType> featFortitudeDefenseModifier = new BonusModifier<Integer, FeatBonusModifierType>(FeatBonusModifierType.class) {
			private final Integer modifierValue = 2;
			
			@Override
			public Integer getValue(IAvatar avatar) {
				return modifierValue;
			}
			
			@Override
			public boolean isEnabled(IAvatar avatar) {
				return avatar.findValueOf(GreatFortitudeFeat.class)
								.canBeAppliedTo(Avatar.class.cast(avatar));
			}

		@Override
		public IGrantor grantedBy() {
			return grantor;
		}
		};
}
