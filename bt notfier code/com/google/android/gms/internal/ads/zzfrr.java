/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final class zzfrr
extends Enum<zzfrr>
implements Executor {
    public static final /* enum */ zzfrr zza;
    private static final zzfrr[] zzb;

    static {
        zzfrr zzfrr2;
        zza = zzfrr2 = new zzfrr();
        zzb = new zzfrr[]{zzfrr2};
    }

    public static zzfrr[] values() {
        return (zzfrr[])zzb.clone();
    }

    @Override
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
