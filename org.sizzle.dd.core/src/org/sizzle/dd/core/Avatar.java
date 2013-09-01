package org.sizzle.dd.core;

//import org.openide.util.Lookup;
//import org.openide.util.lookup.AbstractLookup;
//import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.ServiceProvider;
import org.sizzle.rpg.core.AbstractAvatar;

/**
 *
 * @author Jason
 */
@ServiceProvider(service = AbstractAvatar.class)
public class Avatar extends AbstractAvatar {
//	protected InstanceContent featContent = new InstanceContent();
//	protected Lookup featLookup = new AbstractLookup(featContent);
	
	@SuppressWarnings("unchecked")
	public Avatar() {
	}
}
