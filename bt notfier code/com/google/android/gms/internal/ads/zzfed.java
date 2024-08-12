/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfdx
 *  com.google.android.gms.internal.ads.zzfec
 *  com.google.android.gms.internal.ads.zzfej
 *  com.google.android.gms.internal.ads.zzfek
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfdx;
import com.google.android.gms.internal.ads.zzfec;
import com.google.android.gms.internal.ads.zzfej;
import com.google.android.gms.internal.ads.zzfek;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.Collections;
import java.util.concurrent.Callable;

public final class zzfed {
    public static final <O> zzfej<O> zza(zzfsm<O> zzfsm2, Object object, zzfek zzfek2) {
        return new zzfej(zzfek2, object, null, zzfek.zza(), Collections.emptyList(), zzfsm2, null);
    }

    public static final <O> zzfej<O> zzb(Callable<O> callable, Object object, zzfek zzfek2) {
        return zzfed.zzc(callable, zzfek.zzb((zzfek)zzfek2), object, zzfek2);
    }

    public static final <O> zzfej<O> zzc(Callable<O> callable, zzfsn zzfsn2, Object object, zzfek zzfek2) {
        return new zzfej(zzfek2, object, null, zzfek.zza(), Collections.emptyList(), zzfsn2.zzb(callable), null);
    }

    public static final zzfej zzd(zzfdx zzfdx2, zzfsn zzfsn2, Object object, zzfek zzfek2) {
        return zzfed.zzc(new zzfec(zzfdx2), zzfsn2, object, zzfek2);
    }
}
