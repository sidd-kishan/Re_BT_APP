/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzbs
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbs;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class zzaw
implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();

    zzaw(zzbs zzbs2) {
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        runnable = this.zza.newThread(runnable);
        ((Thread)runnable).setName("ScionFrontendApi");
        return runnable;
    }
}
