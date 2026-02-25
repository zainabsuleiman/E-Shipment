package sw.swtraining.registry.trader.server;

import so.kernel.core.KernelEvent;
import so.kernel.server.ServerBinder;
import so.kernel.server.ServerRule;

public class SR_AutoRegister extends ServerRule {
    public SR_AutoRegister(ServerBinder s){
        super(s);
    }
    @Override
    protected void apply(KernelEvent e){

    }
}
