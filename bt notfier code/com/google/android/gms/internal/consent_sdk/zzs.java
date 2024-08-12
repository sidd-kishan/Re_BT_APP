/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.google.android.gms.internal.consent_sdk.zzp
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener
 *  com.google.android.ump.ConsentRequestParameters
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import com.google.android.gms.internal.consent_sdk.zzp;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;

final class zzs
implements Runnable {
    private final zzp zza;
    private final Activity zzb;
    private final ConsentRequestParameters zzc;
    private final ConsentInformation.OnConsentInfoUpdateSuccessListener zzd;
    private final ConsentInformation.OnConsentInfoUpdateFailureListener zze;

    zzs(zzp zzp2, Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zza = zzp2;
        this.zzb = activity;
        this.zzc = consentRequestParameters;
        this.zzd = onConsentInfoUpdateSuccessListener;
        this.zze = onConsentInfoUpdateFailureListener;
    }

    @Override
    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
