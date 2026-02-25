package sw.eshipment.client;

import so.kernel.client.KVisualDocument;
import so.kernel.client.Zoomable;

/**
 * Visual Document for E-Transfer Note (eshpment).
 * Main entry point for the Client-Side UI.
 */
public class VD_Shipment extends KVisualDocument implements Zoomable {

    private static final long serialVersionUID = 1L;

    public VD_Shipment() {
        super();
        // Set the document display name for the window title
        setName("E-Transfer Note Document");
    }

    @Override
    protected void initializeForms() {
        // Initialize the main Shipment Visual Form
        VF_Shipment vf_shipment = new VF_Shipment();

        // Register the form within the visual document container
        addForm(vf_shipment);
    }

}