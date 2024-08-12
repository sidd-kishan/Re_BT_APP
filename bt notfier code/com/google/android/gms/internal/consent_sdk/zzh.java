/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzcp
 *  com.google.android.gms.internal.consent_sdk.zzct
 *  com.google.android.gms.internal.consent_sdk.zze
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzcp;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zze;
import java.util.concurrent.Executor;

public final class zzh
implements zzcp<zze> {
    private final zzct<Executor> zza;

    public zzh(zzct<Executor> zzct2) {
        this.zza = zzct2;
    }

    public final /* synthetic */ Object zza() {
        return new zze((Executor)this.zza.zza());
    }
}
