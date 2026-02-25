package sw.swtraining.registry.trader.server;
import so.kernel.core.Operations;
import so.kernel.core.events.EventConstants;
import so.kernel.server.ConnectionManager;
import so.kernel.server.DPP;
import so.kernel.server.GCFServerBinder;
import sw.swtraining.registry.trader.C_TraderReg;

import so.kernel.core.Operation;
import so.kernel.core.OperationClass;
import so.kernel.core.Operations;
import so.kernel.server.DPP;
import so.kernel.server.OperationFactory;
public class S_TraderReg extends GCFServerBinder implements C_TraderReg {
	// Connection constants
	public static final String DB_URL_PROPERTY = S_TraderReg.class.getName() +
			"#TRD_DataBaseURL";
	public static final String DB_USR_PROPERTY = S_TraderReg.class.getName() +
			"#TRD_DataBaseUser";
	public static final String DB_PWD_PROPERTY = S_TraderReg.class.getName() +
			"#TRD_DataBasePassword";
	// Table name constants
	public static final String TRD_GEN_TAB = S_TraderReg.class.getName() +
			"#TRD_GEN_TAB";
	public static final String TRD_LIC_TAB = S_TraderReg.class.getName()+
			"#TRD_LIC_TAB";protected DPP createDPP() {
		// define our e-document processing path
		DPP dpp = new DPP();
		dpp.add(null, OP_SUBMIT, ST_SUBMITTED);
		dpp.add(ST_SUBMITTED, OP_REJECT, ST_REJECTED);
		dpp.add(ST_SUBMITTED, OP_REGISTER, ST_REGISTERED);
		dpp.add(ST_REJECTED, OP_UPDATE, ST_SUBMITTED);
		// View all of non-null operations
		dpp.add(ST_SUBMITTED, OP_VIEW, ST_SUBMITTED);
		dpp.add(ST_REJECTED, OP_VIEW, ST_REJECTED);
		dpp.add(ST_REGISTERED, OP_VIEW, ST_REGISTERED);
		return dpp;
	}
	public void defineBinder() {
		// set main Table Connector
		TC_TraderGen tcTraderGen = new TC_TraderGen(this,
				this.getConnectionManager(0));
		addServerRule(tcTraderGen);
		// addTableConnector(tcTraderGen);
		// set our DPP
		setDPP(createDPP());
	}
	protected Operations createValidOperations() {
		// create operations to be performed on our e-document
		setDefaultOperationFlag(VIEW | FIND);
		Operations ops = super.createValidOperations();
		// add operations
		// 2 operation classes
		// NEW | VERIFICATION
		// NEW -> Submit
		OperationClass oc_new = new OperationClass(OC_NEW, "img/Btn_New.gif");
		oc_new.setKnownIED(false);
		oc_new.setInLibrary(true);
		Operation op_Submit = OperationFactory.makeCreateOperation(OI_SUBMIT,
				OP_SUBMIT);
		oc_new.add(op_Submit);
		ops.add(oc_new);
		// VERIFICATION -> Reject | Register
		OperationClass oc_verify = new OperationClass(OC_VERIFY, "img/Btn_New.gif");
		oc_verify.setRequireLock(true);
		oc_verify.setKnownIED(true);
		oc_verify.setInLibrary(false);
		oc_verify.addEventID(EventConstants.UPDATE_REQUESTED);
		oc_verify.setStartEvent(EventConstants.UPDATE_REQUESTED);
		Operation op_Reject = OperationFactory.makeUpdateOperation(OI_REJECT,
				OP_REJECT);
		Operation op_Register = OperationFactory.makeUpdateOperation(OI_REGISTER,
				OP_REGISTER);
		oc_verify.add(op_Register);
		oc_verify.add(op_Reject);
		ops.add(oc_verify);
		Operation op_Update = OperationFactory.makeUpdateOperation(OI_UPDATE,
				OP_UPDATE);
		op_Update.setRequireLock(true);
		op_Update.setKnownIED(true);
		op_Update.setInLibrary(false);
		op_Update.addEventID(EventConstants.UPDATE_REQUESTED);
		op_Update.setStartEvent(EventConstants.UPDATE_REQUESTED);
		ops.add(op_Update);
		return ops;
	}
	public void initializeDatabase() {
		ConnectionManager manager = createConnectionManager(DB_URL_PROPERTY,
				DB_USR_PROPERTY, DB_PWD_PROPERTY);
		if (manager == null) {
			System.err.println("Database Connection Failure!");
		}
	}
}
