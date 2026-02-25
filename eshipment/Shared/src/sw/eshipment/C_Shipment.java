package sw.eshipment;

import so.kernel.core.Operation;

/**
 * Interface for Shipment Registry (eshpment) operations and constants.
 * Updated to reflect Warehouse-to-Warehouse bi-directional workflow.
 */
public interface C_Shipment {
    // ===================================
    // DOCUMENT STATUSES (Workflow Stages)
    // ===================================
    String ST_SUBMITTED  = "Submitted";   // Initiation
    String ST_IN_TRANSIT = "In Transit";  // Dispatch (Gate-Out)
    String ST_RECEIVED   = "Received";    // Receipt (Gate-In)
    String ST_CANCELLED  = "Cancelled";

    // ===================================
    // OPERATION NAMES
    // ===================================
    String OP_SUBMIT   = "Submit";
    String OP_DISPATCH = "Dispatch"; // Gate-Out
    String OP_RECEIVE  = "Receive";  // Gate-In
    String OP_CANCEL   = "Cancel";
    String OP_VIEW     = Operation.VIEW_OPERATION_NAME;

    // ===================================
    // OPERATION CLASSES (UI Groups)
    // ===================================
    String OC_NEW      = "New Shipment";
    String OC_TRACKING = "Tracking";
    String OC_DELIVERY = "Delivery Confirmation";

    // ===================================
    // OPERATION IDs (Unique Integers)
    // ===================================
    int OI_SUBMIT   = Operation.INTERNAL_OPERATIONS_MAX + 10;
    int OI_DISPATCH = Operation.INTERNAL_OPERATIONS_MAX + 12;
    int OI_RECEIVE  = Operation.INTERNAL_OPERATIONS_MAX + 14;
    int OI_CANCEL   = Operation.INTERNAL_OPERATIONS_MAX + 16;

    // ===================================
    // DATA CONSTANTS (DataModel Keys)
    // ===================================
    String TRF_ID  = "TRF_ID";  // System Transfer ID
    String REF_NBR = "REF_NBR"; // Human-readable Reference
    String TIN     = "TIN";     // Trader Tax ID
    String STS     = "STS";     // Document Status field

    // Route Details
    String WH_FROM = "WH_FROM"; // Source Warehouse
    String WH_TO   = "WH_TO";   // Destination Warehouse
    String DEP_DT  = "DEP_DT";  // Departure Date/Time
    String ARV_DT  = "ARV_DT";  // Arrival Date/Time

    // Transport Details
    String PLT_NBR = "PLT_NBR"; // Truck Plate Number
    String DRV_NAM = "DRV_NAM"; // Driver Name
    String SEL_NBR = "SEL_NBR"; // Physical Seal Number

    // Cargo Details (Segment CRG)
    String CRG     = "CRG";     // Cargo SubDataSet name
    String HS_COD  = "HS_COD";  // Harmonized System Code
    String PKG_CNT = "PKG_CNT"; // Package Count/Quantity
}