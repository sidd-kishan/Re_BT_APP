/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  com.google.android.gms.internal.consent_sdk.zzb
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import com.google.android.gms.internal.consent_sdk.zzb;
import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;

public final class zzd
implements zzcp<zzb> {
    private final zzct<Application> zza;

    public zzd(zzct<Application> zzct2) {
        this.zza = zzct2;
    }

    public final /* synthetic */ Object zza() {
        return new zzb((Application)this.zza.zza());
    }
}
