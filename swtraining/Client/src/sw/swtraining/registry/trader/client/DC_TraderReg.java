package sw.swtraining.registry.trader.client;
import so.kernel.client.ClientDocument;
import so.kernel.core.Document;
import so.kernel.core.KernelEventConstants;
import sw.swtraining.registry.trader.C_TraderReg;
import sw.swtraining.registry.trader.D_TraderReg;
import sw.swtraining.registry.trader.client.rules.R_OnVerify;
//import sw.swtraining.registry.trader.client.rules.*;
/**
 * Document Client - Registers client-side rules for events.
 * Rules handle validation, UI updates, and custom actions.
 */
public class DC_TraderReg extends ClientDocument implements C_TraderReg {
    /**
     * Register rules that don't need Visual Document reference.
     * Called during document initialization.
     */
    protected void initRules(Document doc) {
        // Validation before commit
        //doc.addRule(new R_ValidateTIN(), KernelEventConstants.FINAL_ACTION_REQUESTED);
        // Set defaults when document initializes
        //doc.addRule(new R_SetDefaults(), KernelEventConstants.DOCUMENT_INIT)
    }
    /**
     * Register rules that need Visual Document reference.
     *
     * @param doc The document
     * @param vd The Visual Document (for UI access)
     */
    protected void initRules(D_TraderReg doc) {
        doc.addRule( new R_OnVerify(),KernelEventConstants.DOCUMENT_VERIFY);
        // Handle operation completion
        //doc.addRule(new R_OperationDone(vd), KernelEventConstants.OPERATION_DONE);
        // Custom events (defined in C_TraderReg)
        //doc.addRule(new R_AddLicence(vd, doc), DO_ADD_LICENCE);
        //doc.addRule(new R_DeleteLicence(vd, doc), DO_DELETE_LICENCE);
    }
}
