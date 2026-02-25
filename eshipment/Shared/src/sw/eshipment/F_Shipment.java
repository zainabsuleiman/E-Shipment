package sw.eshipment;

import so.kernel.Global;
import so.kernel.core.FinderInfo;

public class F_Shipment extends FinderInfo implements C_Shipment {
    public static final F_Shipment finder = new F_Shipment();

    protected void define_FinderModel() {
        // Search Filters
        addFinder_SearchFld(ds("HDR").de(REF_NBR), lng("Reference Nbr"), Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);
        addFinder_SearchFld(ds("RTE").de(WH_FROM), lng("Source Warehouse"), Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);
        addFinder_SearchFld(ds("HDR").de(PLT_NBR), lng("Truck Plate"), Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);
        addFinder_SearchFld(de(STS), lng("Status"), Global.STRING_TYPE, so.kernel.core.types.StringType.ANY);

        // View Columns
        addFinder_ViewFld(ds("HDR").de(REF_NBR), lng("Reference"));
        addFinder_ViewFld(ds("HDR").de(TIN), lng("Trader TIN"));
        addFinder_ViewFld(ds("RTE").de(WH_FROM), lng("From"));
        addFinder_ViewFld(ds("RTE").de(WH_TO), lng("To"));
        addFinder_ViewFld(ds("HDR").de(PLT_NBR), lng("Plate No"));
        addFinder_ViewFld(de(STS), lng("Status"));

        setStatusSearching(true);
        this.setMaximizable(true);
    }

    public static String lng(String property) {
        return so.i18n.IntlObj.createMessage("sw.swtraining", property);
    }
}

