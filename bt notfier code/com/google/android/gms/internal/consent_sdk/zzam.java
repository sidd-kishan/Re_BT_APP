/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  com.google.android.gms.internal.consent_sdk.zzaj
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import com.google.android.gms.internal.consent_sdk.zzaj;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;
import java.util.concurrent.Executor;

public final class zzam
implements zzcp<zzaj> {
    private final zzct<Application> zza;
    private final zzct<zzal> zzb;
    private final zzct<Executor> zzc;

    public zzam(zzct<Application> zzct2, zzct<zzal> zzct3, zzct<Executor> zzct4) {
        this.zza = zzct2;
        this.zzb = zzct3;
        this.zzc = zzct4;
    }

    public final /* synthetic */ Object zza() {
        return new zzaj((Application)this.zza.zza(), (zzal)this.zzb.zza(), (Executor)this.zzc.zza());
    }
}
