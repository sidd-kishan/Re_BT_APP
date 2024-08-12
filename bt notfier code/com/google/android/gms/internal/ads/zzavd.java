/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

final class zzavd
implements ThreadFactory {
    final String zza;

    zzavd(String string) {
        this.zza = "Loader:ExtractorMediaPeriod";
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zza);
    }
}
