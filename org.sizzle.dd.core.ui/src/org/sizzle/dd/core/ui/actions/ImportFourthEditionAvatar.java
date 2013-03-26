/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sizzle.dd.core.ui.actions;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;
import org.sizzle.rpg.core.AbstractAvatar;

@ActionID(
        category = "File",
        id = "org.sizzle.dd.core.ui.actions.ImportFourthEditionAvatar")
@ActionRegistration(
        iconBase = "org/sizzle/dd/core/ui/actions/document-import.png",
        displayName = "#CTL_ImportFourthEditionAvatar")
@ActionReference(path = "Menu/File/Import", position = 0, separatorAfter = 50)
@Messages("CTL_ImportFourthEditionAvatar=Import 4th Edition Character")
public final class ImportFourthEditionAvatar implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        FileDialog dnd4eFileChooser = new FileDialog((Frame)null);
        
        dnd4eFileChooser.setFilenameFilter(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".dnd4e");
            }
        });
        dnd4eFileChooser.setMode(FileDialog.LOAD);
        dnd4eFileChooser.setMultipleMode(false);
        
        AbstractAvatar avatar = Lookup.getDefault().lookup(AbstractAvatar.class);
        
        dnd4eFileChooser.setVisible(true);
        // TODO implement action body
        
        String filePath = dnd4eFileChooser.getFile();
        File dnd4eFile = new File(filePath);
        
        //XML
    }
}
