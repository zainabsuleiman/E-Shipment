package sw.swtraining.registry.trader.client;
import so.kernel.client.KVisualDocument;
import so.kernel.client.Zoomable;
import sw.swtraining.registry.trader.C_TraderReg;
/**
 * Visual Document - Top-level container for Trader Registration UI.
 * Contains one or more Visual Forms.
 */
public class VD_TraderReg extends KVisualDocument implements C_TraderReg, Zoomable {
    private static final long serialVersionUID = 1L;

    public VD_TraderReg() {
        super();
        setTitle("Trader Registration");
    }

    @Override

    protected void initializeForms() {
        VF_TraderReg vf_TraderReg = new VF_TraderReg();
        vf_TraderReg = new VF_TraderReg();
        addForm(vf_TraderReg);
    }

}
