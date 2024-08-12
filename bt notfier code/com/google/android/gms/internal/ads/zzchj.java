/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchh
 *  com.google.android.gms.internal.ads.zzchi
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchh;
import com.google.android.gms.internal.ads.zzchi;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzchj {
    public static void zza(zzfsm<?> zzfsm2, String string) {
        zzfsd.zzp(zzfsm2, (zzfrz)new zzchh(string), (Executor)zzchg.zzf);
    }

    public static void zzb(zzfsm<?> zzfsm2, String string) {
        zzfsd.zzp(zzfsm2, (zzfrz)new zzchi("ActiveViewListener.callActiveViewJs"), (Executor)zzchg.zzf);
    }
}
