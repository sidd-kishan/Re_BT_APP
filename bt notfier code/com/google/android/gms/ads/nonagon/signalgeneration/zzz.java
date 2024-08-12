/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzx
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzy
 *  com.google.android.gms.internal.ads.zzazj
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.nonagon.signalgeneration.zzx;
import com.google.android.gms.ads.nonagon.signalgeneration.zzy;
import com.google.android.gms.internal.ads.zzazj;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class zzz {
    private final String zza;

    /* synthetic */ zzz(zzx zzx2, zzy zzy2) {
        this.zza = zzx.zza((zzx)zzx2);
    }

    public final Set<String> zza() {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add(this.zza.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzb() {
        return this.zza.toLowerCase(Locale.ROOT);
    }

    public final zzazj zzc() {
        int n;
        block6: {
            String string = this.zza;
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 1951953708: {
                    if (!string.equals("BANNER")) break;
                    n = 0;
                    break block6;
                }
                case 543046670: {
                    if (!string.equals("REWARDED")) break;
                    n = 3;
                    break block6;
                }
                case -1372958932: {
                    if (!string.equals("INTERSTITIAL")) break;
                    n = 1;
                    break block6;
                }
                case -1999289321: {
                    if (!string.equals("NATIVE")) break;
                    n = 2;
                    break block6;
                }
            }
            n = -1;
        }
        if (n == 0) return zzazj.zzb;
        if (n == 1) return zzazj.zzd;
        if (n == 2) return zzazj.zzg;
        if (n == 3) return zzazj.zzh;
        return zzazj.zza;
    }
}
