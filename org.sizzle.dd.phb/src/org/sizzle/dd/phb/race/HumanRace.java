package org.sizzle.dd.phb.race;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.AvatarRace;
import org.sizzle.dd.core.properties.AbilityScoreProperty;
import org.sizzle.dd.core.properties.FortitudeProperty;
import org.sizzle.dd.core.properties.RaceProperty;
import org.sizzle.dd.core.properties.ReflexProperty;
import org.sizzle.dd.core.properties.SizeProperty;
import org.sizzle.dd.core.properties.SpeedProperty;
import org.sizzle.dd.core.properties.VisionProperty;
import org.sizzle.dd.core.properties.WillProperty;
import org.sizzle.dd.phb.modifier.RacialAbilityBonus;
import org.sizzle.dd.phb.modifier.RacialDefenseModifier;
import org.sizzle.dd.phb.properties.CommonLanguageProperty;
import org.sizzle.rpg.core.IAvatar;
import org.sizzle.rpg.core.model.IModifier;

/**
 *
 * @author Jason
 */
public class HumanRace extends AvatarRace {
	public static final String HUMAN_RACE_NAME = "Human";

	public HumanRace() {
		super(HUMAN_RACE_NAME);
	}
	
	@Override
	public void configure(Avatar avatar) {
		// allow user to choose one ability
		String chosenAbilitySlug = "";
		// add racial ability score modifier
		if (!"".equalsIgnoreCase(chosenAbilitySlug) && avatar.hasProperty(chosenAbilitySlug))
			avatar.find(chosenAbilitySlug, AbilityScoreProperty.class).addModifier(new RacialAbilityBonus(HumanRace.class, 2));
		
		// set size to medium
		if (!avatar.hasProperty(SizeProperty.SLUG)) avatar.addProperty(new SizeProperty());
		avatar.find(SizeProperty.class).setValue("Medium");
		
		// set vision to normal
		if (!avatar.hasProperty(VisionProperty.SLUG)) avatar.addProperty(new VisionProperty());
		avatar.find(VisionProperty.class).setValue("Normal");
		
		// add racial speed modifier
		if (!avatar.hasProperty(SpeedProperty.SLUG)) avatar.addProperty(new SpeedProperty());
		avatar.find(SpeedProperty.class).addModifier(new RacialSpeedModifier());
		
		// add Common language
		avatar.addProperty(new CommonLanguageProperty());
		// allow user to choose one other language
		//avatar.addProperty(new _______LaunguageProperty());
		
		// add racial defense modifier to fortitude, reflex, and will
		if (avatar.hasProperty(FortitudeProperty.SLUG)) avatar.find(FortitudeProperty.class).addModifier(new RacialDefenseModifier(HumanRace.class, 1));
		if (avatar.hasProperty(ReflexProperty.SLUG)) avatar.find(ReflexProperty.class).addModifier(new RacialDefenseModifier(HumanRace.class, 1));
		if (avatar.hasProperty(WillProperty.SLUG)) avatar.find(WillProperty.class).addModifier(new RacialDefenseModifier(HumanRace.class, 1));
		
		// grant bonus one extra at-will power from class
		// grant bonus one extra available feat at level 1
		// grant bonus one additional skill from class skill list is trained
	}

	@Override
	public void deconfigure(Avatar avatar) {
		
		// TODO: Resolve possible problem of more than one item (class, race, feat, house-rule) granting a property or modifier
		// TODO: Example HumanRace(GRANT:Language[Common])   LanguageFeat(GRANT:Language[Common])
		// remove race granted languages
		
		// remove vision property
		avatar.removeProperty(avatar.find(VisionProperty.class));
		
		// remove speed modifier
		SpeedProperty speedProperty = avatar.find(SpeedProperty.class);
		speedProperty.removeModifier(speedProperty.getLookup().lookup(RacialSpeedModifier.class));
		
		// remove size property
		avatar.removeProperty(avatar.find(SizeProperty.class));
		
		// remove racial ability bonuses
		for (AbilityScoreProperty abilityScoreProperty : avatar.getLookup().lookupAll(AbilityScoreProperty.class)) {
			RacialAbilityBonus racialAbilityBonus = abilityScoreProperty.getLookup().lookup(RacialAbilityBonus.class);
			if (null != racialAbilityBonus)
				abilityScoreProperty.removeModifier(racialAbilityBonus);
		}
	}
	
	//<editor-fold defaultstate="collapsed" desc="Human Racial Modifiers">
	public class RacialSpeedModifier implements IModifier<Integer> {
		
		@Override
		public Integer getValue(IAvatar avatar) {
			return 6;
		}
		
		@Override
		public boolean isEnabled(IAvatar avatar) {
			// if race is human
			return HumanRace.class.isInstance(avatar.findValueOf(RaceProperty.class));
		}
	}
	
	
	//</editor-fold>
	
}
