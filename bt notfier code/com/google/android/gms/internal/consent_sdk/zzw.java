/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzk
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzk;
import com.google.android.ump.ConsentInformation;

final class zzw
implements Runnable {
    private final ConsentInformation.OnConsentInfoUpdateFailureListener zza;
    private final zzk zzb;

    zzw(ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener, zzk zzk2) {
        this.zza = onConsentInfoUpdateFailureListener;
        this.zzb = zzk2;
    }

    @Override
    public final void run() {
        this.zza.onConsentInfoUpdateFailure(this.zzb.zza());
    }
}
