package sw.swtraining.registry.trader.client;
import so.kernel.client.elf.*;
import so.kernel.core.client.facets.VisualFacetJComboBox;
import so.swing.IconResourcer;
import so.swing.KComboBox;
import sw.swtraining.registry.trader.C_TraderReg;
import static sw.swtraining.registry.trader.C_TraderReg.*;
import java.awt.Color;
public class VP_TraderReg extends ElfVisualPage implements C_TraderReg {
    // ===================================
    // FIELD DECLARATIONS
    // Naming: Fxx_Name where xx indicates field type
    // ===================================
    // Trader Information
    transient private ElfField Flb_Reg = elfFieldPool.getElfField(); // Label

    transient private ElfField Ftx_Nam = elfFieldPool.getElfField(); // Text field
    transient private ElfField Ftx_Tin = elfFieldPool.getElfField(); // Text field
    transient private KComboBox Fcx_Typ = new KComboBox();
    transient private ElfField Flb_Sts = elfFieldPool.getElfField(); // Label

    transient private ElfField Fdt_RegDat = elfFieldPool.getElfField(); // Date field
    transient private ElfField Fck_Act = elfFieldPool.getElfField(); // Checkbox
    // Address
    transient private ElfField Ftx_Str = elfFieldPool.getElfField(); // Text field
    transient private ElfField Ftx_Cty = elfFieldPool.getElfField(); // Text field
    // Remarks
//    transient private ElfField Fmm_Rem = elfFieldPool.getElfField(); // Memo field
    public VP_TraderReg() {
        super();
        this.initVisualPage();
        this.initVisualControlsI18n();
    }
    public void initVisualPage() {
        setSize(1000, 600);
        setBackgroundImage(IconResourcer.getIcon("img/Bg_Book.jpg"), TILE);
        setDefaultJTextFieldColor(new Color(0, 0, 51, 255), new Color(235, 233, 237,
                255), true);
        setDefaultKTitleStripeColor(Color.WHITE, new Color(187, 1, 1, 255), true);
    }
    // ===================================
    // initVisualControls() - Layout UI components
    // add(x, y, width, height, component, tooltip)
    // ===================================
    public void initVisualControls() {
        // Title bar
        //addTitleStripeAndFlag(0, 0, 925, 25, lng("Trader Registration"));
        addTitleStripe(0, 0, 925, 25, lng("Trader Registration"));
        // 

        // Trader Information Panel
        // 

        addTitledBorder(10, 35, 450, 200, lng("Trader Information"));
        // Row 1: Registration Number (read-only)
        add(20, 55, 100, 18, lng("Reg. Reference"));
        add(130, 55, 150, 20, Flb_Reg, lng("Registration Number"));
        // Row 2: Trader Name
        add(20, 80, 100, 18, lng("Name"));
        add(130, 80, 310, 20, Ftx_Nam, lng("Trader Name"));
        // Row 3: TIN
        add(20, 105, 100, 18, lng("Tax ID (TIN)"));
        add(130, 105, 150, 20, Ftx_Tin, lng("Tax Identification Number"));
        // Row 4: Trader Type
        add(20, 130, 100, 18, lng("Type"));
        add(130, 130, 80, 22, Fcx_Typ, lng("Trader Type"));
        // Row 5: Status (read-only)
        add(20, 155, 100, 18, lng("Status"));
        add(130, 155, 100, 20, Flb_Sts, lng("Registration Status"));
        // Row 6: Registration Date & Active
        add(20, 180, 100, 18, lng("Reg. Date"));
        add(130, 180, 100, 20, Fdt_RegDat, lng("Registration Date"));
        add(250, 180, 80, 20, Fck_Act, lng("Active"));
        // 

        // Address Panel
        // 

        addTitledBorder(470, 35, 445, 200, lng("Address"));
        add(480, 55, 80, 18, lng("Street"));
        add(570, 55, 330, 20, Ftx_Str, lng("Street Address"));
        // City
        add(480, 80, 80, 18, lng("City"));
        add(570, 80, 200, 20, Ftx_Cty, lng("City"));
        // 

        // Remarks Panel
        // 

        addTitledBorder(10, 245, 905, 100, lng("Remarks"));
//        add(20, 265, 885, 70, Fmm_Rem, lng("Additional Remarks"));
    }
    // ===================================
    // initFacets() - Bind UI components to document data
    // ===================================
    @Override
    public void initFacets() {
        //D_Tar doc = (D_Tar) getDocument();
        // 

        // Trader Information
        

        // Registration number - display only (system-assigned)
        //addFacetLabel(Flb_Reg, ds(TRD).de(REG));
        // Trader name - required, max 100 characters
        addFacetText(Ftx_Nam, ds(TRD).de(NAM), "X100");
        // TIN - exactly 10 digits
        addFacetText(Ftx_Tin, ds(TRD).de(TIN), "X10");
        // Trader type - dropdown with fixed options
        VisualFacetJComboBox cbx_Typ = new VisualFacetJComboBox(ds(TRD).de(TYP),
                Fcx_Typ,
                new String[] { "", "IMP", "EXP", "BRK" }, new String[] { null,
                "Importer", "Exporter", "Broker" });
        addVisualFacet(cbx_Typ);
        // Status - display only
        addFacetLabel(Flb_Sts, de(STS));
        // Registration date
        addFacetDate(Fdt_RegDat, ds(TRD).de(REG_DAT), "Date");
        // Active flag
        addFacetCheckBox(Fck_Act, ds(TRD).de(ACT));
      
        // Address
       
        addFacetText(Ftx_Str, ds(ADR).de(STR), "X200");
        addFacetText(Ftx_Cty, ds(ADR).de(CTY), "X100");
        // 

        // 

        // Remarks
        // 

        // Memo field: 500 chars max, 4 visible rows, 60 chars width
//        addFacetMemo(Fmm_Rem, ds(TRD).de(REM), "X500*4*60");
    }
    // ===================================
    // initRules() - Field behavior and state
    // ===================================
    @Override
    public void initRules() {
        // Read-only fields (system-assigned)
        Flb_Reg.setEnabled(false);
        Flb_Sts.setEnabled(false);
        Fdt_RegDat.setEnabled(false);
        // Editable fields
        Ftx_Nam.setEnabled(true);
        Ftx_Tin.setEnabled(true);
        Fcx_Typ.setEnabled(true);
        Fck_Act.setEnabled(true);
        // Address fields
        Ftx_Str.setEnabled(true);
        Ftx_Cty.setEnabled(true);
        // Remarks
//        Fmm_Rem.setEnabled(true);
    }
    // ===================================
    // Internationalization helper
    // ===================================
    private static String lng(String property) {
        return so.i18n.IntlObj.createMessage("{sw.swtraining}", property);
    }
}
