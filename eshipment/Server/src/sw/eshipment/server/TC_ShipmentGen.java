package sw.eshipment.server;

import so.kernel.server.ConnectionManager;
import so.kernel.server.GCFServerBinder;
import so.kernel.server.GCFTableConnector;
import so.kernel.server.Server;
import sw.eshipment.C_Shipment;

import java.sql.Types;

public class TC_ShipmentGen extends GCFTableConnector implements C_Shipment {

    public TC_ShipmentGen(GCFServerBinder serverBinder, ConnectionManager connectionManager) {
        // Maps to the table name defined in the Server Binder (S_ShipmentReg)
        super(serverBinder, connectionManager, Server.getString(S_Shipment.SHP_GEN_TAB));

        // Set instance ID (Link between Kernel Workflow and DB Row)
        serverBinder.setInstanceIdField(this, "INSTANCEID", "INSTANCEID");

        // ===================================
        // A. Header Information (ds("HDR"))
        // ===================================
        add(ds("HDR").de(REF_NBR), "SHP_REF_NBR", Types.VARCHAR);
        add(ds("HDR").de(TIN),     "SHP_TRD_TIN", Types.VARCHAR);
        add(ds("HDR").de(PLT_NBR), "SHP_PLT_NBR", Types.VARCHAR);
        add(ds("HDR").de(DRV_NAM), "SHP_DRV_NAM", Types.VARCHAR);
        add(ds("HDR").de(SEL_NBR), "SHP_SEL_NBR", Types.VARCHAR);

        // ===================================
        // B. Route Information (ds("RTE"))
        // ===================================
        add(ds("RTE").de(WH_FROM), "SHP_WH_SOURCE", Types.VARCHAR);
        add(ds("RTE").de(WH_TO),   "SHP_WH_TARGET", Types.VARCHAR);
        add(ds("RTE").de(DEP_DT),  "SHP_DEP_DATE",   Types.TIMESTAMP);
        add(ds("RTE").de(ARV_DT),  "SHP_ARV_DATE",   Types.TIMESTAMP);

        // ===================================
        // Global Fields
        // ===================================
        add(de(STS), "SHP_STATUS", Types.VARCHAR);

        // Ensure this table is indexed/queried during Finder searches
        setParticipateInSearch(true);

        // Note: For Cargo (SubDataSet CRG), a separate TC_ShipmentItems
        // would be added here using addSubTableConnector if stored in a child table.
    }
}

