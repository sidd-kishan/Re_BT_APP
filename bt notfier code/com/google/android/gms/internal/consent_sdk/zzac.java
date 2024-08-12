/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzaj
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 *  com.google.android.gms.internal.consent_sdk.zze
 *  com.google.android.gms.internal.consent_sdk.zzz
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzaj;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zze;
import com.google.android.gms.internal.consent_sdk.zzz;

public final class zzac
implements zzcp<zzz> {
    private final zzct<zze> zza;
    private final zzct<zzaj> zzb;
    private final zzct<zzal> zzc;

    public zzac(zzct<zze> zzct2, zzct<zzaj> zzct3, zzct<zzal> zzct4) {
        this.zza = zzct2;
        this.zzb = zzct3;
        this.zzc = zzct4;
    }

    public final /* synthetic */ Object zza() {
        return new zzz((zze)this.zza.zza(), (zzaj)this.zzb.zza(), (zzal)this.zzc.zza());
    }
}
