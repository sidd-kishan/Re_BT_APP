/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzat
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzat;

final class zzaw
implements Runnable {
    private final zzat zza;

    zzaw(zzat zzat2) {
        this.zza = zzat2;
    }

    @Override
    public final void run() {
        this.zza.zzc();
    }
}
