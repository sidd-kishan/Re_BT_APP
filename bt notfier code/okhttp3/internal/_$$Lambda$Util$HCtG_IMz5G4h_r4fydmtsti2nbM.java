/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.internal.Util
 */
package okhttp3.internal;

import java.util.concurrent.ThreadFactory;
import okhttp3.internal.Util;

public final class _$$Lambda$Util$HCtG_IMz5G4h_r4fydmtsti2nbM
implements ThreadFactory {
    private final String f$0;
    private final boolean f$1;

    public /* synthetic */ _$$Lambda$Util$HCtG_IMz5G4h_r4fydmtsti2nbM(String string, boolean bl) {
        this.f$0 = string;
        this.f$1 = bl;
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        return Util.lambda$HCtG_IMz5G4h_r4fydmtsti2nbM((String)this.f$0, (boolean)this.f$1, (Runnable)runnable);
    }
}
