/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.Call
 *  okhttp3.EventListener
 *  okhttp3.EventListener$Factory
 *  okhttp3.internal.Util
 */
package okhttp3.internal;

import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.Util;

public final class _$$Lambda$Util$OvjneDlA_Jy5aDflPUCwJHwCMTY
implements EventListener.Factory {
    private final EventListener f$0;

    public /* synthetic */ _$$Lambda$Util$OvjneDlA_Jy5aDflPUCwJHwCMTY(EventListener eventListener) {
        this.f$0 = eventListener;
    }

    public final EventListener create(Call call) {
        return Util.lambda$OvjneDlA_Jy5aDflPUCwJHwCMTY((EventListener)this.f$0, (Call)call);
    }
}
