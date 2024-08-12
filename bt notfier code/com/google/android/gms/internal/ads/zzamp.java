/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

final class zzamp
implements ThreadFactory {
    private final String zza;

    zzamp(String string) {
        this.zza = "ExoPlayer:Loader:ProgressiveMediaPeriod";
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zza);
    }
}
