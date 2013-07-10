package org.sizzle.rpg.characterproject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectFactory2;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Jason
 */
@ServiceProvider(service = ProjectFactory.class)
public class CharacterProjectFactory implements ProjectFactory2 {

	public static final String PROJECT_FILE = "%1$s.rpg";
	@StaticResource()
	public static final String PROJECT_ICON_FILENAME = "org/sizzle/rpg/characterproject/user.png";
	public static final Icon PROJECT_ICON = new ImageIcon(PROJECT_ICON_FILENAME);

	@Override
	public boolean isProject(FileObject projectDirectory) {
		FileObject[] children = projectDirectory.getChildren();
		List<FileObject> childrenList = Arrays.asList(children);
		ListIterator<FileObject> listIterator = childrenList.listIterator();
		while (listIterator.hasNext()) {
			if (listIterator.next().getNameExt().equalsIgnoreCase(String.format(PROJECT_FILE, projectDirectory.getName()))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Project loadProject(FileObject projectDirectory, ProjectState state) throws IOException {
		return isProject(projectDirectory) ? new CharacterProject(projectDirectory, state) : null;
	}

	@Override
	public void saveProject(Project project) throws IOException, ClassCastException {
	}

	@Override
	public ProjectManager.Result isProject2(FileObject projectDirectory) {
		FileObject[] children = projectDirectory.getChildren();
		List<FileObject> childrenList = Arrays.asList(children);
		ListIterator<FileObject> listIterator = childrenList.listIterator();
		while (listIterator.hasNext()) {
			if (listIterator.next().getNameExt().equalsIgnoreCase(String.format(PROJECT_FILE, projectDirectory.getName()))) {
				return new ProjectManager.Result(PROJECT_ICON);
			}
		}
		return null;
	}
}
