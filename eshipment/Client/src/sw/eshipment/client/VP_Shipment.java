package sw.eshipment.client;

import java.awt.Color;
import so.kernel.client.elf.ElfField;
import so.kernel.client.elf.ElfVisualPage;
import so.swing.IconResourcer;
import sw.eshipment.C_Shipment;

/**
 * Visual Page for E-Transfer Note (eshpment).
 * Organized by Header, Route, and Transport details per the business plan.
 */
public class VP_Shipment extends ElfVisualPage implements C_Shipment {

    // ===================================
    // FIELD DECLARATIONS
    // ===================================
    // Header Info
    transient private ElfField Ftx_RefNbr = elfFieldPool.getElfField();
    transient private ElfField Ftx_Tin    = elfFieldPool.getElfField();
    transient private ElfField Flb_Sts    = elfFieldPool.getElfField(); // Status Label

    // Route Details
    transient private ElfField Ftx_WhFrom = elfFieldPool.getElfField();
    transient private ElfField Ftx_WhTo   = elfFieldPool.getElfField();
    transient private ElfField Fdt_DepDt  = elfFieldPool.getElfField(); // Departure
    transient private ElfField Fdt_ArvDt  = elfFieldPool.getElfField(); // Arrival

    // Transport Details
    transient private ElfField Ftx_PltNbr = elfFieldPool.getElfField();
    transient private ElfField Ftx_DrvNam = elfFieldPool.getElfField();
    transient private ElfField Ftx_SelNbr = elfFieldPool.getElfField();

    public VP_Shipment() {
        super();
        this.initVisualPage();
        this.initVisualControlsI18n();
    }

    public void initVisualPage() {
        setSize(1000, 600);
        setBackgroundImage(IconResourcer.getIcon("img/Bg_Book.jpg"), TILE);
        setDefaultJTextFieldColor(new Color(0, 0, 51, 255), new Color(235, 233, 237, 255), true);
        setDefaultKTitleStripeColor(Color.WHITE, new Color(0, 102, 204, 255), true); // Blue for Logistics
    }


    public void initVisualControls() {
        // Main Title
        addTitleStripe(0, 0, 925, 25, lng("E-Transfer Note (Warehouse Movement)"));

        // -----
        // A. Header Panel (Who & What)
        // -----
        addTitledBorder(10, 35, 450, 130, lng("General Information"));
        add(20, 55, 120, 18, lng("Reference Nbr"));
        add(150, 55, 150, 20, Ftx_RefNbr, lng("Manual Reference"));

        add(20, 80, 120, 18, lng("Trader TIN"));
        add(150, 80, 150, 20, Ftx_Tin, lng("Taxpayer ID"));

        add(20, 105, 120, 18, lng("Current Status"));
        add(150, 105, 150, 20, Flb_Sts, lng("Workflow Status"));

        // -----
        // B. Route Panel (The Handshake)
        // -----
        addTitledBorder(470, 35, 445, 130, lng("Route Details"));
        add(480, 55, 100, 18, lng("From Warehouse"));
        add(590, 55, 150, 20, Ftx_WhFrom, lng("Source Warehouse Code"));

        add(480, 80, 100, 18, lng("To Warehouse"));
        add(590, 80, 150, 20, Ftx_WhTo, lng("Destination Warehouse Code"));

        add(480, 105, 100, 18, lng("Est. Arrival"));
        add(590, 105, 150, 20, Fdt_ArvDt, lng("Expected Arrival Time"));

        // -----
        // C. Transport & Cargo Panel
        // -----
        addTitledBorder(10, 175, 905, 120, lng("Transport & Security"));
        // Row 1
        add(20, 200, 100, 18, lng("Plate Number"));
        add(130, 200, 150, 20, Ftx_PltNbr, lng("Truck Plate"));

        add(320, 200, 100, 18, lng("Driver Name"));
        add(430, 200, 200, 20, Ftx_DrvNam, lng("Full Name of Driver"));

        // Row 2
        add(20, 230, 100, 18, lng("Seal Number"));
        add(130, 230, 150, 20, Ftx_SelNbr, lng("Security Seal ID"));

        add(320, 230, 100, 18, lng("Departure Time"));
        add(430, 230, 150, 20, Fdt_DepDt, lng("Actual Gate-Out Time"));
    }

    @Override
    public void initFacets() {
        // --- A. Header Segment (Inside "HDR") ---
        // These must use ds("HDR") because in D_Shipment you used seg("HDR")
        addFacetText(Ftx_RefNbr, ds("HDR").de(REF_NBR), "X30");
        addFacetText(Ftx_Tin,    ds("HDR").de(TIN),     "X15");
        addFacetText(Ftx_PltNbr, ds("HDR").de(PLT_NBR), "X15");
        addFacetText(Ftx_DrvNam, ds("HDR").de(DRV_NAM), "X100");
        addFacetText(Ftx_SelNbr, ds("HDR").de(SEL_NBR), "X20");

        // --- B. Route Segment (Inside "RTE") ---
        // These must use ds("RTE") because in D_Shipment you used seg("RTE")
        addFacetText(Ftx_WhFrom, ds("RTE").de(WH_FROM), "X10");
        addFacetText(Ftx_WhTo,   ds("RTE").de(WH_TO),   "X10");
        addFacetDate(Fdt_ArvDt,  ds("RTE").de(ARV_DT),  "Date");
        addFacetDate(Fdt_DepDt,  ds("RTE").de(DEP_DT),  "Date");

        // --- Global Root ---
        // STS is correct as de(STS) because you used add(STS) at the root of D_Shipment
        addFacetLabel(Flb_Sts, de(STS));
    }

    @Override
    public void initRules() {
        // Status is always read-only
        Flb_Sts.setEnabled(false);

        // Logic for Gate-In/Gate-Out could be added here to lock fields
        // based on the document status.
        Ftx_WhFrom.setEnabled(true);
        Ftx_WhTo.setEnabled(true);
        Ftx_PltNbr.setEnabled(true);
    }

    private static String lng(String property) {
        return so.i18n.IntlObj.createMessage("{sw.eshipment}", property);
    }
}