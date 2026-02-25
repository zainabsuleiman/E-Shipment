package sw.swtraining.registry.trader.client.rules;

import so.kernel.core.KernelEvent;
import so.kernel.core.Rule;
import sw.swtraining.registry.trader.D_TraderReg;

import static sw.swtraining.registry.trader.C_TraderReg.NAM;
import static sw.swtraining.registry.trader.C_TraderReg.TRD;

public class R_GetName extends Rule {
    private D_TraderReg doc;
    public R_GetName(D_TraderReg doc){
        this.doc = doc;
    }

    // apply
    protected  void apply(KernelEvent e){
        String taxPayerName = this.doc.ds(TRD).de(NAM).getContentString();

    }
}
