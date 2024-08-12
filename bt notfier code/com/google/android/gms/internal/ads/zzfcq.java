/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzfby
 *  com.google.android.gms.internal.ads.zzfcc
 *  com.google.android.gms.internal.ads.zzfcd
 *  com.google.android.gms.internal.ads.zzfcg
 *  com.google.android.gms.internal.ads.zzfcj
 *  com.google.android.gms.internal.ads.zzfcp
 *  com.google.android.gms.internal.ads.zzfcw
 *  com.google.android.gms.internal.ads.zzfcy
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzfby;
import com.google.android.gms.internal.ads.zzfcc;
import com.google.android.gms.internal.ads.zzfcd;
import com.google.android.gms.internal.ads.zzfcg;
import com.google.android.gms.internal.ads.zzfcj;
import com.google.android.gms.internal.ads.zzfcp;
import com.google.android.gms.internal.ads.zzfcw;
import com.google.android.gms.internal.ads.zzfcy;
import java.util.HashMap;

public final class zzfcq {
    private final HashMap<zzfcg, zzfcp<?, ?>> zza = new HashMap();

    public final <R extends zzdal<AdT>, AdT extends zzcxg> zzfcp<R, AdT> zza(zzfcg zzfcg2, Context context, zzfby zzfby2, zzfcw<R, AdT> zzfcw2) {
        zzfcp<?, ?> zzfcp2 = this.zza.get(zzfcg2);
        if (zzfcp2 != null) return zzfcp2;
        context = new zzfcd(zzfcj.zza((zzfcg)zzfcg2, (Context)context));
        context = new zzfcp((zzfcc)context, new zzfcy((zzfcc)context, zzfby2, zzfcw2));
        this.zza.put(zzfcg2, (zzfcp<?, ?>)context);
        return context;
    }
}
