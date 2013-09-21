package org.sizzle.dd.core.properties;

import java.util.ArrayList;
import java.util.List;
import org.sizzle.dd.core.Avatar;

/**
 *
 * @author Jason
 */
public class ExperienceProperty extends CoreProperty<Integer> {

	public static final String SLUG = "avatar_experience";
	private List<Integer> xpEntries = new ArrayList<>(0);

	public ExperienceProperty(Avatar avatar) {
		super(avatar, SLUG);
	}

	@Override
	protected Integer calculate() {
		Integer xpTotal = 0;
		for (Integer xpEntry : xpEntries) {
			xpTotal += xpEntry;
		}
		return xpTotal;
	}

	public void adjust(Integer amount) {
		xpEntries.add(amount);
	}
}
