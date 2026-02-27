package sw.eshipment;

import so.kernel.Global;
import so.kernel.core.FinderInfo;

import java.util.Arrays;

/**
 * Finder class for E-Shipment matching TC_ShipmentGen mappings.
 */
public final class F_Shipment extends FinderInfo implements C_Shipment {

    public static final F_Shipment finder = new F_Shipment();

    @Override
    protected void define_FinderModel() {

        // ===================================
        // SEARCH FIELDS (Matching TC add() calls)
        // ===================================
        addFinder_SearchFld(ds("HDR").de(REF_NBR), lng("Reference Nbr"), Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);
        addFinder_SearchFld(ds("HDR").de(TIN),     lng("Trader TIN"),    Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);
        addFinder_SearchFld(ds("RTE").de(WH_FROM), lng("Source Whse"),   Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);
        addFinder_SearchFld(ds("HDR").de(PLT_NBR), lng("Truck Plate"),   Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);
        addFinder_SearchFld(ds("HDR").de(SEL_NBR), lng("Seal Number"),   Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);
        addFinder_SearchFld(de(STS),               lng("Status"),        Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);

        // ===================================
        // VIEW FIELDS (Result Grid Columns)
        // ===================================
        addFinder_ViewFld(ds("HDR").de(REF_NBR), lng("Reference"));
        addFinder_ViewFld(ds("HDR").de(TIN),     lng("Trader TIN"));
        addFinder_ViewFld(ds("RTE").de(WH_FROM), lng("From"));
        addFinder_ViewFld(ds("RTE").de(WH_TO),   lng("To"));
        addFinder_ViewFld(ds("HDR").de(PLT_NBR), lng("Plate No"));
        addFinder_ViewFld(ds("HDR").de(SEL_NBR), lng("Seal No"));
        addFinder_ViewFld(ds("RTE").de(DEP_DT),  lng("Departure"), "DateTime");
        addFinder_ViewFld(de(STS),               lng("Status"));

        // Use local helper to match your preferred style
        setDefaultSort(getList(ds("HDR").de(REF_NBR)), UP);

        this.setMaximizable(true);
        this.setStatusSearching(true);
    }

    /**
     * Local helper to support the getList syntax from your examples.
     */
    private String getList(Object... elements) {
        return Arrays.asList(elements).toString();
    }

    private static String lng(String property) {
        return so.i18n.IntlObj.createMessage("{sw.eshipment}", property);
    }
    
}