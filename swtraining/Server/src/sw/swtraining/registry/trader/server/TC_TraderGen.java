package sw.swtraining.registry.trader.server;
import so.kernel.server.*;
import java.sql.Types;
import static sw.swtraining.registry.trader.C_TraderReg.*;
public class TC_TraderGen extends GCFTableConnector {
	public TC_TraderGen(GCFServerBinder serverBinder, ConnectionManager
			connectionManager) {
		super(serverBinder, connectionManager,
				Server.getString(S_TraderReg.TRD_GEN_TAB));
		// Set instance ID (unique document identifier)
		serverBinder.setInstanceIdField(this, INSTANCE_ID, INSTANCE_ID);
		// ===================================
		// Trader Information (ds(TRD))
		// ===================================
		add(ds(TRD).de(NAM), "TRD_NAM", Types.VARCHAR);
		add(ds(TRD).de(TIN), "TRD_TIN", Types.CHAR);
		add(ds(TRD).de(TYP), "TRD_TYP", Types.CHAR);
		add(ds(TRD).de(REG_DAT), "TRD_REG_DAT", Types.DATE);
		add(ds(TRD).de(ACT), "TRD_ACT", Types.CHAR);
// ===================================
		// Address (ds(ADR))
		// ===================================
		add(ds(ADR).de(STR), "ADR_STR", Types.VARCHAR);
		add(ds(ADR).de(CTY), "ADR_CTY", Types.VARCHAR);
		setParticipateInSearch(true); // to make sure transactions are searchable
		// Adding sub-document table-connector
		// In this basic example, we won't deal with sub-documents
		//addSubTableConnector(new TC_TraderLicence(this, connectionManager));
	}

	}