/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzggv
 *  com.google.android.gms.internal.ads.zzggw
 *  com.google.android.gms.internal.ads.zzgiy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzggv;
import com.google.android.gms.internal.ads.zzggw;
import com.google.android.gms.internal.ads.zzgiy;
import java.util.Collection;
import java.util.List;

final class zzggu
extends zzggw {
    private zzggu() {
        super(null);
    }

    /* synthetic */ zzggu(zzggv zzggv2) {
        super(null);
    }

    final <L> List<L> zza(Object object, long l) {
        zzggj zzggj2;
        zzggj zzggj3 = zzggj2 = (zzggj)zzgiy.zzn((Object)object, (long)l);
        if (zzggj2.zza()) return zzggj3;
        int n = zzggj2.size();
        n = n == 0 ? 10 : (n += n);
        zzggj3 = zzggj2.zze(n);
        zzgiy.zzo((Object)object, (long)l, (Object)zzggj3);
        return zzggj3;
    }

    final void zzb(Object object, long l) {
        ((zzggj)zzgiy.zzn((Object)object, (long)l)).zzb();
    }

    final <E> void zzc(Object object, Object object2, long l) {
        zzggj zzggj2 = (zzggj)zzgiy.zzn((Object)object, (long)l);
        zzggj zzggj3 = (zzggj)zzgiy.zzn((Object)object2, (long)l);
        int n = zzggj2.size();
        int n2 = zzggj3.size();
        object2 = zzggj2;
        if (n > 0) {
            object2 = zzggj2;
            if (n2 > 0) {
                object2 = zzggj2;
                if (!zzggj2.zza()) {
                    object2 = zzggj2.zze(n2 + n);
                }
                object2.addAll((Collection)zzggj3);
            }
        }
        if (n <= 0) {
            object2 = zzggj3;
        }
        zzgiy.zzo((Object)object, (long)l, (Object)object2);
    }
}
