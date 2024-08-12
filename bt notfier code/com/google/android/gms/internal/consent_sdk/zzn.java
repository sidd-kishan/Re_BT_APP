/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzb
 *  com.google.android.gms.internal.consent_sdk.zzbn
 *  com.google.android.gms.internal.consent_sdk.zzk
 *  com.google.android.gms.internal.consent_sdk.zzl
 *  com.google.android.ump.ConsentDebugSettings
 *  com.google.android.ump.ConsentDebugSettings$Builder
 *  com.google.android.ump.ConsentRequestParameters
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzb;
import com.google.android.gms.internal.consent_sdk.zzbn;
import com.google.android.gms.internal.consent_sdk.zzk;
import com.google.android.gms.internal.consent_sdk.zzl;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;

final class zzn {
    private final Application zza;
    private final zzb zzb;
    private final zzal zzc;

    zzn(Application application, zzb zzb2, zzal zzal2) {
        this.zza = application;
        this.zzb = zzb2;
        this.zzc = zzal2;
    }

    static /* synthetic */ Application zza(zzn zzn2) {
        return zzn2.zza;
    }

    static /* synthetic */ zzal zzb(zzn zzn2) {
        return zzn2.zzc;
    }

    static /* synthetic */ zzb zzc(zzn zzn2) {
        return zzn2.zzb;
    }

    final zzbn zza(Activity activity, ConsentRequestParameters consentRequestParameters) throws zzk {
        ConsentDebugSettings consentDebugSettings;
        ConsentDebugSettings consentDebugSettings2 = consentDebugSettings = consentRequestParameters.getConsentDebugSettings();
        if (consentDebugSettings != null) return zzl.zza((zzl)new zzl(this, activity, consentDebugSettings2, consentRequestParameters, null));
        consentDebugSettings2 = new ConsentDebugSettings.Builder((Context)this.zza).build();
        return zzl.zza((zzl)new zzl(this, activity, consentDebugSettings2, consentRequestParameters, null));
    }
}
