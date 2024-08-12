/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.consent_sdk.zzc
 *  com.google.android.ump.ConsentInformation
 *  com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener
 *  com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener
 */
package com.google.android.ump;

import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzc;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.UserMessagingPlatform;

public final class UserMessagingPlatform {
    private UserMessagingPlatform() {
    }

    public static ConsentInformation getConsentInformation(Context context) {
        return zzc.zza((Context)context).zza();
    }

    public static void loadConsentForm(Context context, OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzc.zza((Context)context).zzb().zza(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener);
    }
}
