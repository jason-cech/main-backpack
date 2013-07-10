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
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.Lookups;
import org.sizzle.dd.core.importer.FourtEditionAvatarImporter;
import org.sizzle.rpg.core.AbstractAvatar;
import org.sizzle.rpg.core.importer.AvatarImporter;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

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
        
        String dirPath = dnd4eFileChooser.getDirectory();
        String filePath = dnd4eFileChooser.getFile();
        Path dnd4ePath = Paths.get(dirPath, filePath);
        dnd4ePath.endsWith(".dnd4e");
        FileSystem fileSystem = dnd4ePath.getFileSystem();
        boolean absolute = dnd4ePath.isAbsolute();
        File dnd4eFile = dnd4ePath.toFile();
        
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(dnd4eFile);
            //XML
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        if (document!=null) {
            FourtEditionAvatarImporter baseImporter = Lookup.getDefault().lookup(FourtEditionAvatarImporter.class);
            // Required
            baseImporter.process(avatar, document);
            
            // Lookup any importers from other extension modules.  Say, PHB2 or Adventure's Vault
            Collection<? extends AvatarImporter> bonusImporters = Lookups.exclude(Lookup.getDefault(), FourtEditionAvatarImporter.class).lookupAll(AvatarImporter.class);
            for (AvatarImporter bonusImporter : bonusImporters) {
                bonusImporter.process(avatar, document);
            }
        }
    }
}
