/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzcg
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzcg;
import java.util.concurrent.ThreadFactory;

final class zzcf
implements ThreadFactory {
    private final zzcg zza;
    private final String zzb;

    zzcf(zzcg zzcg2, String string) {
        this.zza = zzcg2;
        this.zzb = string;
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        return this.zza.zza(this.zzb, runnable);
    }
}
