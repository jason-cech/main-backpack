package org.sizzle.dd.core.importer;

import org.sizzle.dd.core.Avatar;
import org.w3c.dom.Document;

/**
 *
 * @author Jason
 */
public interface AvatarImporter {

	void extract(Avatar avatar, Document document);
}
