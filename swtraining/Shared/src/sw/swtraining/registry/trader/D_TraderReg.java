package sw.swtraining.registry.trader;

import java.sql.Types;

import so.kernel.core.DataSet;
import so.kernel.core.KDocument;

public class D_TraderReg extends KDocument implements C_TraderReg{

	public D_TraderReg() {
		super("Trader e-document");
	}
	
	@Override
	public void define_DataModel() {
		
		key("INSTANCEID");
		
		DataSet trd = seg(TRD);
		
		trd.add(NAM);
		trd.add("TIN");
		trd.add("TYP");
		trd.add(REG_DAT);
		trd.add(ACT);

		add(STS);
		
		DataSet adr = seg("ADR");
		
		adr.add("CTY");
		adr.add("STR");
	}
	
}
