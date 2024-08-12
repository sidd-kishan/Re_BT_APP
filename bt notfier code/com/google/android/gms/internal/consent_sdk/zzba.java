/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  com.google.android.gms.internal.consent_sdk.zzab
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzat
 *  com.google.android.gms.internal.consent_sdk.zzbb
 *  com.google.android.gms.internal.consent_sdk.zzbe
 *  com.google.android.gms.internal.consent_sdk.zzbh
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import com.google.android.gms.internal.consent_sdk.zzab;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzat;
import com.google.android.gms.internal.consent_sdk.zzbb;
import com.google.android.gms.internal.consent_sdk.zzbe;
import com.google.android.gms.internal.consent_sdk.zzbh;
import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;

public final class zzba
implements zzcp<zzat> {
    private final zzct<Application> zza;
    private final zzct<zzab> zzb;
    private final zzct<zzbh> zzc;
    private final zzct<zzal> zzd;
    private final zzct<zzbb> zze;
    private final zzct<zzbe> zzf;

    public zzba(zzct<Application> zzct2, zzct<zzab> zzct3, zzct<zzbh> zzct4, zzct<zzal> zzct5, zzct<zzbb> zzct6, zzct<zzbe> zzct7) {
        this.zza = zzct2;
        this.zzb = zzct3;
        this.zzc = zzct4;
        this.zzd = zzct5;
        this.zze = zzct6;
        this.zzf = zzct7;
    }

    public final /* synthetic */ Object zza() {
        return new zzat((Application)this.zza.zza(), (zzab)this.zzb.zza(), (zzbh)this.zzc.zza(), (zzal)this.zzd.zza(), (zzbb)this.zze.zza(), this.zzf);
    }
}
