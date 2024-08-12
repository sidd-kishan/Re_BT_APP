/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcge
 *  com.google.android.gms.internal.ads.zzenk
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcge;
import com.google.android.gms.internal.ads.zzenk;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzenm
implements zzery<zzerx<Bundle>> {
    private final Executor zza;
    private final zzcge zzb;

    zzenm(Executor executor, zzcge zzcge2) {
        this.zza = executor;
        this.zzb = zzcge2;
    }

    public final zzfsm<zzerx<Bundle>> zza() {
        zzbjd zzbjd2 = zzbjl.zzbN;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return zzfsd.zzj((zzfsm)this.zzb.zzr(), (zzfln)zzenk.zza, (Executor)this.zza);
        return zzfsd.zza(null);
    }
}
