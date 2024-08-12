/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;

final class zzu
implements Runnable {
    private final ConsentInformation.OnConsentInfoUpdateSuccessListener zza;

    private zzu(ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        this.zza = onConsentInfoUpdateSuccessListener;
    }

    static Runnable zza(ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        return new zzu(onConsentInfoUpdateSuccessListener);
    }

    @Override
    public final void run() {
        this.zza.onConsentInfoUpdateSuccess();
    }
}
