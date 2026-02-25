package sw.eshipment.server;

import so.kernel.core.Operation;
import so.kernel.core.OperationClass;
import so.kernel.core.Operations;
import so.kernel.core.events.EventConstants;
import so.kernel.server.ConnectionManager;
import so.kernel.server.DPP;
import so.kernel.server.GCFServerBinder;
import so.kernel.server.OperationFactory;
import sw.eshipment.C_Shipment;

/**
 * Server Binder for E-Transfer Note (eshpment).
 * Coordinates workflow, operations, and database connectivity.
 */
public class S_Shipment extends GCFServerBinder implements C_Shipment {

    // Connection constants - Used for lookups in the registry or properties file
    public static final String DB_URL_PROPERTY = S_Shipment.class.getName() + "#SHP_DataBaseURL";
    public static final String DB_USR_PROPERTY = S_Shipment.class.getName() + "#SHP_DataBaseUser";
    public static final String DB_PWD_PROPERTY = S_Shipment.class.getName() + "#SHP_DataBasePassword";

    // Table name constant
    public static final String SHP_GEN_TAB = S_Shipment.class.getName() + "#SHP_GEN_TAB";

    @Override
    protected DPP createDPP() {
        // Define the E-Transfer Processing Path (The Handshake)
        DPP dpp = new DPP();

        // Flow transitions: [Start State] -> [Operation] -> [End State]
        dpp.add(null,           OP_SUBMIT,   ST_SUBMITTED);  // Initial Creation
        dpp.add(ST_SUBMITTED,   OP_DISPATCH, ST_IN_TRANSIT); // Gate-Out
        dpp.add(ST_IN_TRANSIT,  OP_RECEIVE,  ST_RECEIVED);   // Gate-In
        dpp.add(ST_SUBMITTED,   OP_CANCEL,   ST_CANCELLED);

        // View-only permissions for each stage
        dpp.add(ST_SUBMITTED,   OP_VIEW, ST_SUBMITTED);
        dpp.add(ST_IN_TRANSIT,  OP_VIEW, ST_IN_TRANSIT);
        dpp.add(ST_RECEIVED,    OP_VIEW, ST_RECEIVED);
        dpp.add(ST_CANCELLED,   OP_VIEW, ST_CANCELLED);

        return dpp;
    }

    @Override
    public void defineBinder() {
        // Initialize the Table Connector (Mapping e-doc to DB)
        TC_ShipmentGen tcShipmentGen = new TC_ShipmentGen(this, this.getConnectionManager(0));
        addServerRule(tcShipmentGen);

        // Apply the workflow logic
        setDPP(createDPP());
    }

    @Override
    protected Operations createValidOperations() {
        // Base operations (Find/View)
        setDefaultOperationFlag(VIEW | FIND);
        Operations ops = super.createValidOperations();

        // 1. INITIATION: Create the transfer request
        OperationClass oc_new = new OperationClass(OC_NEW, "img/Btn_New.gif");
        oc_new.setKnownIED(false);
        oc_new.setInLibrary(true);

        Operation op_Submit = OperationFactory.makeCreateOperation(OI_SUBMIT, OP_SUBMIT);
        oc_new.add(op_Submit);
        ops.add(oc_new);

        // 2. DISPATCH: The "Gate-Out" event at Warehouse A
        OperationClass oc_track = new OperationClass(OC_TRACKING, "img/Btn_Dispatch.gif");
        oc_track.setRequireLock(true);
        oc_track.setKnownIED(true);
        oc_track.setInLibrary(false);
        oc_track.addEventID(EventConstants.UPDATE_REQUESTED);

        Operation op_Dispatch = OperationFactory.makeUpdateOperation(OI_DISPATCH, OP_DISPATCH);
        Operation op_Cancel   = OperationFactory.makeUpdateOperation(OI_CANCEL,   OP_CANCEL);

        oc_track.add(op_Dispatch);
        oc_track.add(op_Cancel);
        ops.add(oc_track);

        // 3. RECEIPT: The "Gate-In" event at Warehouse B
        OperationClass oc_delivery = new OperationClass(OC_DELIVERY, "img/Btn_Receive.gif");
        oc_delivery.setRequireLock(true);
        oc_delivery.setKnownIED(true);
        oc_delivery.setInLibrary(false);
        oc_delivery.addEventID(EventConstants.UPDATE_REQUESTED);

        Operation op_Receive = OperationFactory.makeUpdateOperation(OI_RECEIVE, OP_RECEIVE);
        oc_delivery.add(op_Receive);
        ops.add(oc_delivery);

        return ops;
    }

    @Override
    public void initializeDatabase() {
        // Establish connection to the storage layer
        ConnectionManager manager = createConnectionManager(DB_URL_PROPERTY, DB_USR_PROPERTY, DB_PWD_PROPERTY);
        if (manager == null) {
            System.err.println("E-Shipment Database Connection Failure!");
        }
    }
}