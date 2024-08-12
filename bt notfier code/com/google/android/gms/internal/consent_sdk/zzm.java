/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzaz
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 *  com.google.android.gms.internal.consent_sdk.zzj
 *  com.google.android.gms.internal.consent_sdk.zzp
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzaz;
import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zzj;
import com.google.android.gms.internal.consent_sdk.zzp;

public final class zzm
implements zzcp<zzj> {
    private final zzct<zzal> zza;
    private final zzct<zzp> zzb;
    private final zzct<zzaz> zzc;

    public zzm(zzct<zzal> zzct2, zzct<zzp> zzct3, zzct<zzaz> zzct4) {
        this.zza = zzct2;
        this.zzb = zzct3;
        this.zzc = zzct4;
    }

    public final /* synthetic */ Object zza() {
        zzal zzal2 = (zzal)this.zza.zza();
        Object object = this.zzb.zza();
        zzaz zzaz2 = (zzaz)this.zzc.zza();
        return new zzj(zzal2, (zzp)object, zzaz2);
    }
}
