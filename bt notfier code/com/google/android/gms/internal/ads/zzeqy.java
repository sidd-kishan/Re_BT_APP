/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzbxq
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdtf
 *  com.google.android.gms.internal.ads.zzejz
 *  com.google.android.gms.internal.ads.zzeke
 *  com.google.android.gms.internal.ads.zzekh
 *  com.google.android.gms.internal.ads.zzeki
 *  com.google.android.gms.internal.ads.zzeqs
 *  com.google.android.gms.internal.ads.zzeqz
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfrj
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzbxq;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdtf;
import com.google.android.gms.internal.ads.zzejz;
import com.google.android.gms.internal.ads.zzeke;
import com.google.android.gms.internal.ads.zzekh;
import com.google.android.gms.internal.ads.zzeki;
import com.google.android.gms.internal.ads.zzeqs;
import com.google.android.gms.internal.ads.zzeqz;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

public final class zzeqy
implements zzery<zzeqz> {
    final String zza;
    private final zzfsn zzb;
    private final ScheduledExecutorService zzc;
    private final zzeke zzd;
    private final Context zze;
    private final zzfar zzf;
    private final zzejz zzg;
    private final zzdtf zzh;

    public zzeqy(zzfsn zzfsn2, ScheduledExecutorService scheduledExecutorService, String string, zzeke zzeke2, Context context, zzfar zzfar2, zzejz zzejz2, zzdtf zzdtf2) {
        this.zzb = zzfsn2;
        this.zzc = scheduledExecutorService;
        this.zza = string;
        this.zzd = zzeke2;
        this.zze = context;
        this.zzf = zzfar2;
        this.zzg = zzejz2;
        this.zzh = zzdtf2;
    }

    private final zzfsm<JSONObject> zze(String string, List<Bundle> list, Bundle bundle, boolean bl, boolean bl2) throws RemoteException {
        zzbxn zzbxn2;
        zzchl zzchl2 = new zzchl();
        if (bl2) {
            this.zzg.zza(string);
            zzbxn2 = this.zzg.zzb(string);
        } else {
            try {
                zzbxn2 = this.zzh.zzc(string);
            }
            catch (RemoteException remoteException) {
                com.google.android.gms.ads.internal.util.zze.zzg((String)"Couldn't create RTB adapter : ", (Throwable)remoteException);
                zzbxn2 = null;
            }
        }
        if (zzbxn2 == null) throw null;
        string = new zzekh(string, zzbxn2, zzchl2);
        if (bl) {
            zzbxn2.zze(ObjectWrapper.wrap((Object)this.zze), this.zza, bundle, list.get(0), this.zzf.zze, (zzbxq)string);
        } else {
            string.zzb();
        }
        return zzchl2;
    }

    public final zzfsm<zzeqz> zza() {
        return zzfsd.zze((zzfrj)new zzeqs(this), (Executor)this.zzb);
    }

    final /* synthetic */ zzfsm zzb(String string, zzeki zzeki2, Bundle bundle) throws Exception {
        return this.zze(string, Collections.singletonList(zzeki2.zzd), bundle, zzeki2.zzb, zzeki2.zzc);
    }

    final /* synthetic */ zzfsm zzc(String string, List list, Bundle bundle) throws Exception {
        return this.zze(string, list, bundle, true, true);
    }
}
