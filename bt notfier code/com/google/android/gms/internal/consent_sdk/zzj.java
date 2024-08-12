/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzaz
 *  com.google.android.gms.internal.consent_sdk.zzp
 *  com.google.android.ump.ConsentInformation
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener
 *  com.google.android.ump.ConsentRequestParameters
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzaz;
import com.google.android.gms.internal.consent_sdk.zzp;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;

public final class zzj
implements ConsentInformation {
    private final zzal zza;
    private final zzp zzb;
    private final zzaz zzc;

    public zzj(zzal zzal2, zzp zzp2, zzaz zzaz2) {
        this.zza = zzal2;
        this.zzb = zzp2;
        this.zzc = zzaz2;
    }

    public final int getConsentStatus() {
        return this.zza.zza();
    }

    public final int getConsentType() {
        return this.zza.zzb();
    }

    public final boolean isConsentFormAvailable() {
        return this.zzc.zza();
    }

    public final void requestConsentInfoUpdate(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zzb.zza(activity, consentRequestParameters, onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener);
    }

    public final void reset() {
        this.zzc.zza(null);
        this.zza.zzf();
    }
}
