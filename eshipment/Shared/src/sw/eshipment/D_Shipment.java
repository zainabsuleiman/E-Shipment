package sw.eshipment;

import so.kernel.core.DataSet;
import so.kernel.core.KDocument;



public class D_Shipment extends KDocument implements C_Shipment {

    public D_Shipment() {
        super("E-Transfer Note");
    }

    @Override
    public void define_DataModel() {
        key("INSTANCEID");

        // A. The Header (Who & When)
        DataSet hdr = seg("HDR");
        hdr.add(REF_NBR);
        hdr.add(TIN);
        hdr.add(PLT_NBR);
        hdr.add(DRV_NAM);
        hdr.add(SEL_NBR);

        // B. The Route (From & To)
        DataSet rte = seg("RTE");
        rte.add(WH_FROM);
        rte.add(WH_TO);
        rte.add(DEP_DT);
        rte.add(ARV_DT);

        // C. The Cargo (What - Multi-line SubDataSet)
        DataSet crg = seg(CRG);
        crg.add(HS_COD);
        crg.add(PKG_CNT);

        // Global Status
        add(STS);
    }
}



