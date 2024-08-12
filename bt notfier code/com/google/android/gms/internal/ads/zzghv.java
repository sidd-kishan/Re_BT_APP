/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzghw
 *  com.google.android.gms.internal.ads.zzghy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzghw;
import com.google.android.gms.internal.ads.zzghy;
import java.util.ArrayDeque;
import java.util.Arrays;

final class zzghv {
    private final ArrayDeque<zzgex> zza = new ArrayDeque();

    private zzghv() {
    }

    /* synthetic */ zzghv(zzghw zzghw2) {
    }

    static /* synthetic */ zzgex zza(zzghv zzghv2, zzgex zzgex2, zzgex zzgex3) {
        zzghv2.zzb(zzgex2);
        zzghv2.zzb(zzgex3);
        zzgex2 = zzghv2.zza.pop();
        while (!zzghv2.zza.isEmpty()) {
            zzgex2 = new zzghy(zzghv2.zza.pop(), zzgex2, null);
        }
        return zzgex2;
    }

    private final void zzb(zzgex object) {
        if (object.zzg()) {
            int n = zzghv.zzc(object.zzc());
            int n2 = zzghy.zzG((int)(n + 1));
            if (!this.zza.isEmpty() && this.zza.peek().zzc() < n2) {
                n = zzghy.zzG((int)n);
                zzgex zzgex2 = this.zza.pop();
                while (!this.zza.isEmpty() && this.zza.peek().zzc() < n) {
                    zzgex2 = new zzghy(this.zza.pop(), zzgex2, null);
                }
                object = new zzghy(zzgex2, object, null);
                while (!this.zza.isEmpty()) {
                    n = zzghy.zzG((int)(zzghv.zzc(object.zzc()) + 1));
                    if (this.zza.peek().zzc() >= n) break;
                    object = new zzghy(this.zza.pop(), object, null);
                }
                this.zza.push((zzgex)object);
                return;
            }
            this.zza.push((zzgex)object);
            return;
        }
        if (object instanceof zzghy) {
            object = (zzghy)object;
            this.zzb(zzghy.zzd((zzghy)object));
            this.zzb(zzghy.zzh((zzghy)object));
            return;
        }
        object = String.valueOf(object.getClass());
        String.valueOf(object).length();
        object = new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(object)));
        throw object;
    }

    private static final int zzc(int n) {
        int n2;
        n = n2 = Arrays.binarySearch(zzghy.zza, n);
        if (n2 >= 0) return n;
        n = -(n2 + 1) - 1;
        return n;
    }
}
