/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.appset.AppSet
 *  com.google.android.gms.appset.AppSetIdClient
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzeno
 *  com.google.android.gms.internal.ads.zzenq
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzflc
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzeno;
import com.google.android.gms.internal.ads.zzenq;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzflc;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

public final class zzenp
implements zzery<zzenq> {
    private final AppSetIdClient zza;

    zzenp(Context context) {
        this.zza = AppSet.getClient((Context)context);
    }

    public final zzfsm<zzenq> zza() {
        zzbjd zzbjd2 = zzbjl.zzbO;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return zzfsd.zza((Object)new zzenq(null, -1));
        return zzfsd.zzj((zzfsm)zzflc.zza((Task)this.zza.getAppSetIdInfo()), (zzfln)zzeno.zza, (Executor)zzchg.zzf);
    }
}
