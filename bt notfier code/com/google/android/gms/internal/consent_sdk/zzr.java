/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzp
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzp;
import com.google.android.ump.ConsentInformation;

final class zzr
implements Runnable {
    private final zzp zza;
    private final ConsentInformation.OnConsentInfoUpdateSuccessListener zzb;

    zzr(zzp zzp2, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        this.zza = zzp2;
        this.zzb = onConsentInfoUpdateSuccessListener;
    }

    @Override
    public final void run() {
        this.zza.zza(this.zzb);
    }
}
