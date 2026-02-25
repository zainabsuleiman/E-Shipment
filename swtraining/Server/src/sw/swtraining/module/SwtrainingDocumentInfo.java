/*
 * SwtrainingDocumentInfo.java
 *
 * Created on Feb 18, 2026 3:04:25 PM
 */

package sw.swtraining.module;


import so.kernel.server.DocumentModuleInfo;
import so.kernel.server.Server;



/**
 *
 */
public class SwtrainingDocumentInfo extends DocumentModuleInfo {
    
    /** Creates a new instance of SwtrainingDocumentInfo */
    public SwtrainingDocumentInfo() {
        super();
    }
    
    protected void init() {
        String url = Server.getString("module.sw.swtraining.gcf.url");
        String usr = Server.getString("module.sw.swtraining.gcf.user");
        String passwd = Server.getString("module.sw.swtraining.gcf.password");
        
        String iedTable = Server.getString("module.sw.swtraining.gcf.tables.ied");
        String historyTable = Server.getString("module.sw.swtraining.gcf.tables.history");
        String locksTable = Server.getString("module.sw.swtraining.gcf.tables.locks");
        String trackTable = Server.getString("module.sw.swtraining.gcf.tables.track");
        
        setIED(url, usr, passwd, iedTable);
        setHistory(url, usr, passwd, historyTable);
        setLocks(url, usr, passwd, locksTable);
        setTrack(url, usr, passwd, trackTable);
        
        
    }
    
}
