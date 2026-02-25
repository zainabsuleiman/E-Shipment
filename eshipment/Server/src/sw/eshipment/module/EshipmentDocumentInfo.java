/*
 * EshipmentDocumentInfo.java
 *
 * Created on Feb 25, 2026 2:58:15 PM
 */

package sw.eshipment.module;


import so.kernel.server.DocumentModuleInfo;
import so.kernel.server.Server;



/**
 *
 */
public class EshipmentDocumentInfo extends DocumentModuleInfo {
    
    /** Creates a new instance of EshipmentDocumentInfo */
    public EshipmentDocumentInfo() {
        super();
    }
    
    protected void init() {
        String url = Server.getString("module.sw.eshipment.gcf.url");
        String usr = Server.getString("module.sw.eshipment.gcf.user");
        String passwd = Server.getString("module.sw.eshipment.gcf.password");
        
        String iedTable = Server.getString("module.sw.eshipment.gcf.tables.ied");
        String historyTable = Server.getString("module.sw.eshipment.gcf.tables.history");
        String locksTable = Server.getString("module.sw.eshipment.gcf.tables.locks");
        String trackTable = Server.getString("module.sw.eshipment.gcf.tables.track");
        
        setIED(url, usr, passwd, iedTable);
        setHistory(url, usr, passwd, historyTable);
        setLocks(url, usr, passwd, locksTable);
        setTrack(url, usr, passwd, trackTable);
        
        
    }
    
}
