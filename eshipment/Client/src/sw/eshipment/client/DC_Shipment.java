package sw.eshipment.client;

import so.kernel.client.ClientDocument;
import so.kernel.core.Document;
import so.kernel.core.KernelEventConstants;
import sw.eshipment.C_Shipment;
import sw.eshipment.D_Shipment;
//import sw.eshipment.client.rules.*;

/**
 * Client Document Controller for E-Transfer Note (eshpment).
 * Manages client-side validation and event rules.
 */
public class DC_Shipment extends ClientDocument implements C_Shipment {

    /**
     * Registers rules that act directly on the Data Model (D_Shipment).
     * These rules run during document verification/saving.
     */
    protected void initRules(D_Shipment doc) {
//        // Business Rule: Check if Source Warehouse != Destination Warehouse
//        doc.addRule(new R_CheckRoute(), KernelEventConstants.DOCUMENT_VERIFY);
//
//        // Business Rule: Ensure Seal Number is provided before Dispatch
//        doc.addRule(new R_OnVerify(), KernelEventConstants.DOCUMENT_VERIFY);
    }

    /**
     * Registers rules that interact with the Visual Document (VD_Shipment).
     * Used for UI-specific behaviors like showing/hiding fields dynamically.
     */

    protected void initRules(Document doc, VD_Shipment vd) {
        // Example: Add a rule to refresh the UI when status changes
        // doc.addRule(new R_RefreshUI(vd), KernelEventConstants.DATA_CHANGED);
    }
}