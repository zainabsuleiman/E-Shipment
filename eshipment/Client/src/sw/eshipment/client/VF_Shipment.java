package sw.eshipment.client;

import so.kernel.client.VisualForm;
import sw.eshipment.C_Shipment;

/**
 * Visual Form for E-Transfer Note (eshpment).
 * Acts as the main container for the Shipment UI pages.
 */
public class VF_Shipment extends VisualForm implements C_Shipment {

    private static final long serialVersionUID = 1L;

    // Visual Pages
    private VP_Shipment vp_shipment;

    public VF_Shipment() {
        super();
        // Sets the internal form name for the kernel
        setName("E-Transfer Note");
    }

    @Override
    protected void initializePages() {
        // Initialize the Main Shipment information page
        vp_shipment = new VP_Shipment();

        // Add the page to the form container
        addPage(vp_shipment);

        // Note: If you add a Cargo Grid page later,
        // you would initialize and add it here as well.
    }

    /**
     * Internationalization helper for Form-level labels.
     */
    private static String lng(String property) {
        return so.i18n.IntlObj.createMessage("{sw.eshipment}", property);
    }
}