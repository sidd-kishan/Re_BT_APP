/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzb
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 *  com.google.android.gms.internal.consent_sdk.zzn
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzb;
import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zzn;

public final class zzq
implements zzcp<zzn> {
    private final zzct<Application> zza;
    private final zzct<zzb> zzb;
    private final zzct<zzal> zzc;

    public zzq(zzct<Application> zzct2, zzct<zzb> zzct3, zzct<zzal> zzct4) {
        this.zza = zzct2;
        this.zzb = zzct3;
        this.zzc = zzct4;
    }

    public final /* synthetic */ Object zza() {
        Application application = (Application)this.zza.zza();
        Object object = this.zzb.zza();
        zzal zzal2 = (zzal)this.zzc.zza();
        return new zzn(application, (zzb)object, zzal2);
    }
}
