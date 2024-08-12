/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzon
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzou
 *  com.google.android.gms.internal.ads.zzqs
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzon;
import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzou;
import com.google.android.gms.internal.ads.zzqs;

final class zzqt
implements zzqs {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;

    private zzqt(long[] lArray, long[] lArray2, long l, long l2) {
        this.zza = lArray;
        this.zzb = lArray2;
        this.zzc = l;
        this.zzd = l2;
    }

    public static zzqt zza(long l, long l2, zzon object, zzamf object2) {
        object2.zzk(10);
        int n = object2.zzv();
        if (n <= 0) {
            return null;
        }
        int n2 = object.zzd;
        long l3 = n;
        n = n2 >= 32000 ? 1152 : 576;
        long l4 = zzamq.zzH((long)l3, (long)((long)n * 1000000L), (long)n2);
        int n3 = object2.zzo();
        n2 = object2.zzo();
        int n4 = object2.zzo();
        object2.zzk(2);
        l3 = l2 + (long)object.zzc;
        object = new long[n3];
        long[] lArray = new long[n3];
        int n5 = 0;
        while (true) {
            if (n5 >= n3) {
                if (l == -1L) return new zzqt((long[])object, lArray, l4, l2);
                if (l == l2) return new zzqt((long[])object, lArray, l4, l2);
                object2 = new StringBuilder(67);
                ((StringBuilder)object2).append("VBRI data size mismatch: ");
                ((StringBuilder)object2).append(l);
                ((StringBuilder)object2).append(", ");
                ((StringBuilder)object2).append(l2);
                Log.w((String)"VbriSeeker", (String)((StringBuilder)object2).toString());
                return new zzqt((long[])object, lArray, l4, l2);
            }
            object[n5] = (zzon)((long)n5 * l4 / (long)n3);
            lArray[n5] = Math.max(l2, l3);
            if (n4 != 1) {
                if (n4 != 2) {
                    if (n4 != 3) {
                        if (n4 != 4) {
                            return null;
                        }
                        n = object2.zzB();
                    } else {
                        n = object2.zzr();
                    }
                } else {
                    n = object2.zzo();
                }
            } else {
                n = object2.zzn();
            }
            l2 += (long)(n * n2);
            ++n5;
        }
    }

    public final long zzb(long l) {
        return this.zza[zzamq.zzD((long[])this.zzb, (long)l, (boolean)true, (boolean)true)];
    }

    public final long zzc() {
        return this.zzd;
    }

    public final boolean zze() {
        return true;
    }

    public final zzor zzf(long l) {
        int n = zzamq.zzD((long[])this.zza, (long)l, (boolean)true, (boolean)true);
        zzou zzou2 = new zzou(this.zza[n], this.zzb[n]);
        if (zzou2.zzb >= l) return new zzor(zzou2, zzou2);
        long[] lArray = this.zza;
        if (n != lArray.length - 1) return new zzor(zzou2, new zzou(lArray[++n], this.zzb[n]));
        return new zzor(zzou2, zzou2);
    }

    public final long zzg() {
        return this.zzc;
    }
}
