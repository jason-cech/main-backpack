package org.sizzle.dd.core.importer;

import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.properties.AbilityScoreProperty;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jason
 */
public class BaseAbilityImporter implements AvatarImporter {

	@Override
	public void extract(Avatar avatar, Document document) {
		Node initialAbilityScoreBlockNodeNode = document.getElementsByTagName("AbilityScores").item(0);
		NodeList initialAbilityScoreNodeList = initialAbilityScoreBlockNodeNode.getChildNodes();
		
		
	}
	
}
