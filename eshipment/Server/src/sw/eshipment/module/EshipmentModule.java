/*
 * EshipmentModule.java
 *
 * Created on Feb 25, 2026 2:58:15 PM
 */

package sw.eshipment.module;

import so.kernel.core.modules.ModuleInstall;
import so.kernel.server.DocumentModulesManager;

/**
 *
 */
public class EshipmentModule extends ModuleInstall {
    
    /** Creates a new instance of EshipmentModule */
    public EshipmentModule() {
    }
    
    /** Called when an already-installed module is restored (at System startup
     * time). Should perform whatever initializations are required. The module
     * can load resource about the module. The class loader is a module class
     * loader.
     *
     */
    public void restored() {
        DocumentModulesManager.registerModule(new EshipmentDocumentInfo());
    }
    
}
