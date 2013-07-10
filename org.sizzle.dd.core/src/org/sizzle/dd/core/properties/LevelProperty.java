package org.sizzle.dd.core.properties;

/**
 *
 * @author Jason
 */
public class LevelProperty extends CoreProperty<Integer> {

	public static final String SLUG = "avatar_level";
	int[] levels = new int[]{0, 999, 2249, 3749, 5499, 7499, 9999};

	public LevelProperty() {
		super("avatar_level");
	}

	@Override
	protected Integer calculate() {
		Integer xp = avatar.<Integer>findValueOf("avatar_experience");
		int level = 0;
		while (xp > levels[level]) {
			level++;
		}
		return level;
	}
}
