package sw.swtraining.registry.trader.client.rules;

import so.kernel.core.KernelEvent;
import so.kernel.core.Rule;

public class R_OnVerify extends Rule {
    public R_OnVerify(){}
    @Override
    protected void apply(KernelEvent e){
        System.out.println("Rule executed on verify Operation/event - Triggered by framework");
    }
}
