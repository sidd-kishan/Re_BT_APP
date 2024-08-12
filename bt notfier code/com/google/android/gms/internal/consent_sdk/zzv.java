/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.os.Handler
 *  com.google.android.gms.internal.consent_sdk.zzab
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzaz
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 *  com.google.android.gms.internal.consent_sdk.zze
 *  com.google.android.gms.internal.consent_sdk.zzn
 *  com.google.android.gms.internal.consent_sdk.zzp
 *  com.google.android.gms.internal.consent_sdk.zzz
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import com.google.android.gms.internal.consent_sdk.zzab;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzaz;
import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zze;
import com.google.android.gms.internal.consent_sdk.zzn;
import com.google.android.gms.internal.consent_sdk.zzp;
import com.google.android.gms.internal.consent_sdk.zzz;
import java.util.concurrent.Executor;

public final class zzv
implements zzcp<zzp> {
    private final zzct<Application> zza;
    private final zzct<zzab> zzb;
    private final zzct<Handler> zzc;
    private final zzct<Executor> zzd;
    private final zzct<zzal> zze;
    private final zzct<zzaz> zzf;
    private final zzct<zzn> zzg;
    private final zzct<zzz> zzh;
    private final zzct<zze> zzi;

    public zzv(zzct<Application> zzct2, zzct<zzab> zzct3, zzct<Handler> zzct4, zzct<Executor> zzct5, zzct<zzal> zzct6, zzct<zzaz> zzct7, zzct<zzn> zzct8, zzct<zzz> zzct9, zzct<zze> zzct10) {
        this.zza = zzct2;
        this.zzb = zzct3;
        this.zzc = zzct4;
        this.zzd = zzct5;
        this.zze = zzct6;
        this.zzf = zzct7;
        this.zzg = zzct8;
        this.zzh = zzct9;
        this.zzi = zzct10;
    }

    public final /* synthetic */ Object zza() {
        Application application = (Application)this.zza.zza();
        zzab zzab2 = (zzab)this.zzb.zza();
        Handler handler = (Handler)this.zzc.zza();
        Executor executor = (Executor)this.zzd.zza();
        zzal zzal2 = (zzal)this.zze.zza();
        zzaz zzaz2 = (zzaz)this.zzf.zza();
        Object object = this.zzg.zza();
        Object object2 = this.zzh.zza();
        zze zze2 = (zze)this.zzi.zza();
        return new zzp(application, zzab2, handler, executor, zzal2, zzaz2, (zzn)object, (zzz)object2, zze2);
    }
}
