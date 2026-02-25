/*
 * SwtrainingModule.java
 *
 * Created on Feb 18, 2026 3:04:25 PM
 */

package sw.swtraining.module;

import so.kernel.core.modules.ModuleInstall;
import so.kernel.server.DocumentModulesManager;

/**
 *
 */
public class SwtrainingModule extends ModuleInstall {
    
    /** Creates a new instance of SwtrainingModule */
    public SwtrainingModule() {
    }
    
    /** Called when an already-installed module is restored (at System startup
     * time). Should perform whatever initializations are required. The module
     * can load resource about the module. The class loader is a module class
     * loader.
     *
     */
    public void restored() {
        DocumentModulesManager.registerModule(new SwtrainingDocumentInfo());
    }
    
}
