/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.ump.ConsentDebugSettings$Builder
 *  com.google.android.ump.zza
 */
package com.google.android.ump;

import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.zza;

/*
 * Exception performing whole class analysis ignored.
 */
public class ConsentDebugSettings {
    private final boolean zza;
    private final int zzb;

    private ConsentDebugSettings(boolean bl, Builder builder) {
        this.zza = bl;
        this.zzb = Builder.zza((Builder)builder);
    }

    /* synthetic */ ConsentDebugSettings(boolean bl, Builder builder, zza zza2) {
        this(bl, builder);
    }

    public int getDebugGeography() {
        return this.zzb;
    }

    public boolean isTestDevice() {
        return this.zza;
    }
}
