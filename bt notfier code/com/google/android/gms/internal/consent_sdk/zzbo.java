/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.os.Handler
 *  com.google.android.gms.internal.consent_sdk.zzaj
 *  com.google.android.gms.internal.consent_sdk.zzat
 *  com.google.android.gms.internal.consent_sdk.zzbh
 *  com.google.android.gms.internal.consent_sdk.zzbj
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 *  com.google.android.gms.internal.consent_sdk.zze
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import com.google.android.gms.internal.consent_sdk.zzaj;
import com.google.android.gms.internal.consent_sdk.zzat;
import com.google.android.gms.internal.consent_sdk.zzbh;
import com.google.android.gms.internal.consent_sdk.zzbj;
import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zze;
import java.util.concurrent.Executor;

public final class zzbo
implements zzcp<zzbj> {
    private final zzct<Application> zza;
    private final zzct<zzbh> zzb;
    private final zzct<Handler> zzc;
    private final zzct<Executor> zzd;
    private final zzct<zze> zze;
    private final zzct<zzaj> zzf;
    private final zzct<zzat> zzg;

    public zzbo(zzct<Application> zzct2, zzct<zzbh> zzct3, zzct<Handler> zzct4, zzct<Executor> zzct5, zzct<zze> zzct6, zzct<zzaj> zzct7, zzct<zzat> zzct8) {
        this.zza = zzct2;
        this.zzb = zzct3;
        this.zzc = zzct4;
        this.zzd = zzct5;
        this.zze = zzct6;
        this.zzf = zzct7;
        this.zzg = zzct8;
    }

    public final /* synthetic */ Object zza() {
        return new zzbj((Application)this.zza.zza(), (zzbh)this.zzb.zza(), (Handler)this.zzc.zza(), (Executor)this.zzd.zza(), (zze)this.zze.zza(), (zzaj)this.zzf.zza(), (zzat)this.zzg.zza());
    }
}
