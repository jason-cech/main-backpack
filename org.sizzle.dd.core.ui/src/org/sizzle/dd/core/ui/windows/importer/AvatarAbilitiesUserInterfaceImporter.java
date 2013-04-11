package org.sizzle.dd.core.ui.windows.importer;

import org.openide.util.lookup.ServiceProvider;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.sizzle.dd.core.Avatar;
import org.sizzle.dd.core.importer.AvatarUserInterfaceConfigurer;
import org.sizzle.dd.core.ui.windows.AbilitiesTopComponent;

/**
 *
 * @author Jason
 */
@ServiceProvider(service = AvatarUserInterfaceConfigurer.class)
public class AvatarAbilitiesUserInterfaceImporter implements AvatarUserInterfaceConfigurer {

    @Override
    public void configure(Avatar t) {
        Mode editorMode = WindowManager.getDefault().findMode("editor");
        TopComponent[] findTopComponent = WindowManager.getDefault().getOpenedTopComponents(editorMode);
        for (TopComponent topComponent : findTopComponent) {
            if (topComponent.getClass().isAssignableFrom(AbilitiesTopComponent.class)) {
                AbilitiesTopComponent.class.cast(topComponent).configure(t);
            }
        }
    }
    
}
