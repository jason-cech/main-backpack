package org.sizzle.rpg.core.importer;

import org.sizzle.rpg.core.IAvatar;
import org.w3c.dom.Document;

/**
 *
 * @author Jason
 */
public abstract class AvatarImporter {

    public abstract void process(IAvatar avatar, Document document);
}
