/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  com.google.android.gms.internal.consent_sdk.zzaf
 *  com.google.android.gms.internal.consent_sdk.zzag
 *  com.google.android.gms.internal.consent_sdk.zzc
 *  com.google.android.gms.internal.consent_sdk.zzc$zza
 *  com.google.android.gms.internal.consent_sdk.zzcu
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import com.google.android.gms.internal.consent_sdk.zzaf;
import com.google.android.gms.internal.consent_sdk.zzag;
import com.google.android.gms.internal.consent_sdk.zzc;
import com.google.android.gms.internal.consent_sdk.zzcu;

final class zzai
implements zzc.zza {
    private Application zza;

    private zzai() {
    }

    /* synthetic */ zzai(zzaf zzaf2) {
        this();
    }

    public final /* synthetic */ zzc.zza zza(Application application) {
        this.zza = (Application)zzcu.zza((Object)application);
        return this;
    }

    public final zzc zza() {
        zzcu.zza((Object)this.zza, Application.class);
        return new zzag(this.zza, null);
    }
}
