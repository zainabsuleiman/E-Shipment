package sw.swtraining.registry.trader.client;

import so.kernel.client.VisualForm;
import sw.swtraining.registry.trader.C_TraderReg;

public class VF_TraderReg  extends VisualForm implements C_TraderReg {


    //constructor
    public  VF_TraderReg(){

    }
    @Override
    protected void initializePages() {
        VP_TraderReg vp_traderReg = new VP_TraderReg();
        addPage(vp_traderReg);
    }
}
