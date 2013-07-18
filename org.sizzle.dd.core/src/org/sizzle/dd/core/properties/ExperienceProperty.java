package org.sizzle.dd.core.properties;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jason
 */
public class ExperienceProperty extends CoreProperty<Integer> {

	public static final String SLUG = "avatar_experience";
	private List<Integer> xpEntries = new ArrayList<>(0);

	public ExperienceProperty() {
		super(SLUG);
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
