/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.consent_sdk.zzbe
 *  com.google.android.gms.internal.consent_sdk.zzbh
 *  com.google.android.gms.internal.consent_sdk.zzbj
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 */
package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import com.google.android.gms.internal.consent_sdk.zzbe;
import com.google.android.gms.internal.consent_sdk.zzbh;
import com.google.android.gms.internal.consent_sdk.zzbj;
import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;

public final class zzbi
implements zzcp<zzbe> {
    private final zzct<zzbh> zza;
    private final zzct<Handler> zzb;
    private final zzct<zzbj> zzc;

    public zzbi(zzct<zzbh> zzct2, zzct<Handler> zzct3, zzct<zzbj> zzct4) {
        this.zza = zzct2;
        this.zzb = zzct3;
        this.zzc = zzct4;
    }

    public final /* synthetic */ Object zza() {
        return new zzbe((zzbh)this.zza.zza(), (Handler)this.zzb.zza(), (zzbj)this.zzc.zza());
    }
}
