package org.sizzle.dd.core.properties;

import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class LevelProperty extends CoreProperty<Integer> {

	public static final String SLUG = "avatar_level";
	int[] levels = new int[]{0, 999, 2249, 3749, 5499, 7499, 9999};

	public LevelProperty(Avatar avatar) {
		super(avatar, SLUG);
	}

	@Override
	protected Integer calculate() {
		Integer xp = avatar.<Integer>findValueOf("avatar_experience");
		int level = 0;
		while (level < levels.length && xp > levels[level]) {
			level++;
		}
		return level;
	}
}
