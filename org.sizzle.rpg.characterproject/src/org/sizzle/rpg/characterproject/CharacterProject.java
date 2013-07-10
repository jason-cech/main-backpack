package org.sizzle.rpg.characterproject;

import java.awt.Image;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.ProjectState;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;

/**
 *
 * @author Jason
 */
public class CharacterProject implements Project {

	private final FileObject projectDirectory;
	private final ProjectState state;
	private Lookup lookup;

	public CharacterProject(FileObject projectDirectory, ProjectState state) {
		this.projectDirectory = projectDirectory;
		this.state = state;
	}

	@Override
	public FileObject getProjectDirectory() {
		return projectDirectory;
	}

	@Override
	public Lookup getLookup() {
		if (null == lookup) {
			lookup = Lookups.fixed(
							new CharacterProjectInformation(),
							new CharacterProjectLogicalView(this));
		}
		return lookup;
	}

	private final class CharacterProjectInformation implements ProjectInformation {
		public final String PROJECT_ICON_FILENAME = "E:\\Images\\Fugue\\icons\\user.png";
		public final Icon PROJECT_ICON = new ImageIcon(PROJECT_ICON_FILENAME);

		@Override
		public String getName() {
			return getProjectDirectory().getName();
		}

		@Override
		public String getDisplayName() {
			return getName();
		}

		@Override
		public Icon getIcon() {
			return PROJECT_ICON;
		}

		@Override
		public Project getProject() {
			return CharacterProject.this;
		}

		@Override
		public void addPropertyChangeListener(PropertyChangeListener listener) {
			//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		public void removePropertyChangeListener(PropertyChangeListener listener) {
			//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
	}

	class CharacterProjectLogicalView implements LogicalViewProvider {

		@StaticResource()
		public static final String CHARACTER_ICON_PATH = "org/sizzle/rpg/characterproject/user.png";
		private final CharacterProject characterProject;
		
		public CharacterProjectLogicalView(CharacterProject characterProject) {
			this.characterProject = characterProject;
		}
		
		@Override
		public Node createLogicalView() {
			FileObject projectDirectory = characterProject.getProjectDirectory();
			try {
				DataFolder projectFolder = DataFolder.findFolder(projectDirectory);
				Node projectFolderNode = projectFolder.getNodeDelegate();
				return new CharacterProjectNode(projectFolderNode, characterProject);
			} catch (Exception e) {
				return new AbstractNode(Children.LEAF);
			}
		}
		
		private final class CharacterProjectNode extends FilterNode {
			final CharacterProject project;
			public CharacterProjectNode(Node node, CharacterProject project) {
				super(node, new FilterNode.Children(node),new ProxyLookup(new Lookup[]{Lookups.singleton(project),node.getLookup()}));
				this.project = project;
			}

			@Override
			public Action[] getActions(boolean context) {
				return new Action[]{
					CommonProjectActions.closeProjectAction()
				};
			}

			@Override
			public String getDisplayName() {
				return project.getProjectDirectory().getName();
			}

			@Override
			public Image getIcon(int type) {
				return ImageUtilities.loadImage(CHARACTER_ICON_PATH);
			}

			@Override
			public Image getOpenedIcon(int type) {
				return getIcon(type);
			}
			
		}

		@Override
		public Node findPath(Node root, Object target) {
			return null;
		}
		
	}
}
