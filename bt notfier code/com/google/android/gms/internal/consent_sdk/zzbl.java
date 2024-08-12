/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzbj
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzbj;

final class zzbl
implements Runnable {
    private final zzbj zza;

    zzbl(zzbj zzbj2) {
        this.zza = zzbj2;
    }

    @Override
    public final void run() {
        this.zza.zzb();
    }
}
