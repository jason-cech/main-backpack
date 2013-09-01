/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.phb;

import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;
import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.phb.feats.GreatFortitudeFeat;

public class Installer extends ModuleInstall {

	@Override
	public void restored() {
		Avatar avatar = Lookup.getDefault().lookup(Avatar.class);
		
		GreatFortitudeFeat.apply(avatar);
	}

}
