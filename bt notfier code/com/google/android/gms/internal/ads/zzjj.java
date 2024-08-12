/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfny
 *  com.google.android.gms.internal.ads.zzfpw
 *  com.google.android.gms.internal.ads.zzjn
 *  com.google.android.gms.internal.ads.zzjt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfny;
import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzjt;
import java.util.Comparator;

public final class zzjj
implements Comparable<zzjj> {
    public final boolean zza;
    private final String zzb;
    private final zzjn zzc;
    private final boolean zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final boolean zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final int zzn;

    public zzjj(zzafv zzafv2, zzjn zzjn2, int n) {
        Object object;
        int n2;
        int n3;
        int n4;
        block8: {
            block7: {
                this.zzc = zzjn2;
                this.zzb = zzjt.zzg((String)zzafv2.zzc);
                n4 = 0;
                this.zzd = zzjt.zzf((int)n, (boolean)false);
                n = 0;
                while (true) {
                    n3 = zzjn2.zzo.size();
                    n2 = Integer.MAX_VALUE;
                    if (n >= n3) break;
                    n3 = zzjt.zzh((zzafv)zzafv2, (String)((String)zzjn2.zzo.get(n)), (boolean)false);
                    if (n3 <= 0) {
                        ++n;
                        continue;
                    }
                    break block7;
                    break;
                }
                n = Integer.MAX_VALUE;
                n3 = 0;
            }
            this.zzf = n;
            this.zze = n3;
            n = zzafv2.zze;
            n = zzjn2.zzp;
            this.zzg = Integer.bitCount(0);
            boolean bl = 1 == (zzafv2.zzd & 1);
            this.zzj = bl;
            this.zzk = zzafv2.zzy;
            this.zzl = zzafv2.zzz;
            this.zzm = zzafv2.zzh;
            if (zzafv2.zzh != -1) {
                n = zzjn2.zzr;
            }
            if (zzafv2.zzy != -1) {
                n = zzjn2.zzq;
            }
            this.zza = true;
            object = zzamq.zzY();
            for (n = 0; n < ((String[])object).length; ++n) {
                int n5 = zzjt.zzh((zzafv)zzafv2, (String)object[n], (boolean)false);
                if (n5 <= 0) continue;
                n3 = n;
                n = n5;
                break block8;
            }
            n3 = Integer.MAX_VALUE;
            n = 0;
        }
        this.zzh = n3;
        this.zzi = n;
        n = n4;
        while (true) {
            n3 = n2;
            if (n >= zzjn2.zzs.size()) break;
            object = zzafv2.zzl;
            if (object != null && ((String)object).equals(zzjn2.zzs.get(n))) {
                n3 = n;
                break;
            }
            ++n;
        }
        this.zzn = n3;
    }

    public final int zza(zzjj zzjj2) {
        zzfpw zzfpw2 = this.zzd ? zzjt.zza() : zzjt.zza().zza();
        zzfny zzfny2 = zzfny.zzj().zzd(this.zzd, zzjj2.zzd).zza((Object)this.zzf, (Object)zzjj2.zzf, (Comparator)zzfpw.zzb().zza()).zzb(this.zze, zzjj2.zze).zzb(this.zzg, zzjj2.zzg);
        boolean bl = zzjj2.zza;
        zzfny2 = zzfny2.zzd(true, true).zza((Object)this.zzn, (Object)zzjj2.zzn, (Comparator)zzfpw.zzb().zza());
        int n = this.zzm;
        int n2 = zzjj2.zzm;
        bl = this.zzc.zzw;
        zzfny2 = zzfny2.zza((Object)n, (Object)n2, (Comparator)zzjt.zzb()).zzd(this.zzj, zzjj2.zzj).zza((Object)this.zzh, (Object)zzjj2.zzh, (Comparator)zzfpw.zzb().zza()).zzb(this.zzi, zzjj2.zzi).zza((Object)this.zzk, (Object)zzjj2.zzk, (Comparator)zzfpw2).zza((Object)this.zzl, (Object)zzjj2.zzl, (Comparator)zzfpw2);
        n2 = this.zzm;
        n = zzjj2.zzm;
        if (zzamq.zzc((Object)this.zzb, (Object)zzjj2.zzb)) return zzfny2.zza((Object)n2, (Object)n, (Comparator)zzfpw2).zze();
        zzfpw2 = zzjt.zzb();
        return zzfny2.zza((Object)n2, (Object)n, (Comparator)zzfpw2).zze();
    }
}
