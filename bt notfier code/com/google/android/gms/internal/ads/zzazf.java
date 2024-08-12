/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzamu
 *  com.google.android.gms.internal.ads.zzazc
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgv
 *  com.google.android.gms.internal.ads.zzcgw
 *  com.google.android.gms.internal.ads.zzcgx
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzamu;
import com.google.android.gms.internal.ads.zzazc;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzcgw;
import com.google.android.gms.internal.ads.zzcgx;

public final class zzazf {
    zzamu zza;
    boolean zzb;

    public zzazf() {
    }

    public zzazf(Context context) {
        zzbjl.zza((Context)context);
        zzbjd zzbjd2 = zzbjl.zzdo;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        try {
            this.zza = (zzamu)zzcgx.zza((Context)context, (String)"com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", (zzcgv)zzazc.zza);
            ObjectWrapper.wrap((Object)context);
            this.zza.zze(ObjectWrapper.wrap((Object)context), "GMA_SDK");
            this.zzb = true;
            return;
        }
        catch (RemoteException | zzcgw | NullPointerException throwable) {
            zzcgt.zzd((String)"Cannot dynamite load clearcut");
        }
    }
}
