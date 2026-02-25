package sw.swtraining.registry.trader;
import so.kernel.core.Operation;
import so.kernel.core.Operation;
import so.kernel.core.events.EventConstants;
public interface C_TraderReg {
	// ===================================
	// DOCUMENT STATUSES
	// ===================================
	String ST_SUBMITTED = "Submitted";
	String ST_REJECTED = "Rejected";
	String ST_REGISTERED = "Registered";
	// ===================================
	// OPERATION NAMES (for DPP matching)
	// ===================================
	String OP_UPDATE = "Update";
	String OP_SUBMIT = "Submit";
	String OP_REJECT = "Reject";
	String OP_REGISTER = "Register";
	String OP_VIEW = Operation.VIEW_OPERATION_NAME;
	//
	// OPERATION IDs (unique integers for each operation)
	// ===================================
	int OI_UPDATE = Operation.INTERNAL_OPERATIONS_MAX + 2;
	int OI_SUBMIT = Operation.INTERNAL_OPERATIONS_MAX + 4;
	int OI_REJECT = Operation.INTERNAL_OPERATIONS_MAX + 6;
	int OI_REGISTER = Operation.INTERNAL_OPERATIONS_MAX + 8;
	// ===================================
	// OPERATION CLASS (groups of related operations)
	// ===================================
	String OC_NEW = "New Registration";
	String OC_VERIFY = "Trader Verification";
	// ===================================
	// DATA CONSTANTS
	// ===================================
	String INSTANCE_ID = "INSTANCE_ID";
	String TRD = "TRD"; // Trader information
	String REM = "REM";
	String ADR = "ADR"; // Address
	String BNK = "BNK"; // Banking
	String CON = "CON"; // Contacts (SubDataSet)
	String LIC = "LIC"; // Licenses (SubDataSet)
	String REG = "REG"; // Registration number (Key)
	String NAM = "NAM"; // Trader name
	String TIN = "TIN"; // Tax Identification Number
	String TYP = "TYP"; // type (IMP/EXP/AGT/BRK)
	String STS = "STS"; // Status
	String REG_DAT = "REG_DAT"; // Registration date
	String ACT = "ACT"; // Active flag
	String STR = "STR"; // Street address
	String CTY = "CTY"; // City
	String COU = "COU"; // Country code
	String SEQ = "SEQ"; // Sequence number
	String EML = "EML"; // Email address
	String TEL = "TEL"; // Telephone number
	String PRM = "PRM"; // Primary contact flag
	String EXP = "EXP"; // Expiry date
	String ISS = "ISS";
	String NBR = "NBR";
	String AUT = "AUT";
	int ADD_TAXPAYER_LICENCE = EventConstants.EXTERNAL_EVENTS_MAX + 5;
	int AUTO_REGISTER_TAXPAYER = EventConstants.EXTERNAL_EVENTS_MAX + 10;
}

