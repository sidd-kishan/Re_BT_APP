/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzfny
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfpw
 *  com.google.android.gms.internal.ads.zzjn
 *  com.google.android.gms.internal.ads.zzjt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzfny;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzjt;
import java.util.Comparator;

public final class zzjr
implements Comparable<zzjr> {
    public final boolean zza;
    private final boolean zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final boolean zzi;

    public zzjr(zzafv zzafv2, zzjn zzjn2, int n, String string) {
        boolean bl;
        block5: {
            block4: {
                int n2;
                boolean bl2;
                block3: {
                    bl2 = false;
                    this.zzb = zzjt.zzf((int)n, (boolean)false);
                    n = zzafv2.zzd;
                    n2 = zzjn2.zzC;
                    bl = 1 == (n & 1);
                    this.zzc = bl;
                    bl = (n & 2) != 0;
                    this.zzd = bl;
                    zzfoj zzfoj2 = zzjn2.zzt.isEmpty() ? zzfoj.zzj((Object)"") : zzjn2.zzt;
                    for (n = 0; n < zzfoj2.size(); ++n) {
                        String string2 = (String)zzfoj2.get(n);
                        bl = zzjn2.zzv;
                        int n3 = zzjt.zzh((zzafv)zzafv2, (String)string2, (boolean)false);
                        if (n3 <= 0) continue;
                        n2 = n;
                        n = n3;
                        break block3;
                    }
                    n2 = Integer.MAX_VALUE;
                    n = 0;
                }
                this.zze = n2;
                this.zzf = n;
                n = zzafv2.zze;
                n = zzjn2.zzu;
                this.zzg = Integer.bitCount(0);
                n = zzafv2.zze;
                this.zzi = false;
                bl = zzjt.zzg((String)string) == null;
                this.zzh = zzjt.zzh((zzafv)zzafv2, (String)string, (boolean)bl);
                if (this.zzf > 0 || zzjn2.zzt.isEmpty() && this.zzg > 0 || this.zzc) break block4;
                bl = bl2;
                if (!this.zzd) break block5;
                bl = bl2;
                if (this.zzh <= 0) break block5;
            }
            bl = true;
        }
        this.zza = bl;
    }

    public final int zza(zzjr zzjr2) {
        zzfny zzfny2 = zzfny.zzj().zzd(this.zzb, zzjr2.zzb).zza((Object)this.zze, (Object)zzjr2.zze, (Comparator)zzfpw.zzb().zza()).zzb(this.zzf, zzjr2.zzf).zzb(this.zzg, zzjr2.zzg).zzd(this.zzc, zzjr2.zzc);
        boolean bl = this.zzd;
        boolean bl2 = zzjr2.zzd;
        zzfpw zzfpw2 = this.zzf == 0 ? zzfpw.zzb() : zzfpw.zzb().zza();
        zzfny2 = zzfny2.zza((Object)bl, (Object)bl2, (Comparator)zzfpw2).zzb(this.zzh, zzjr2.zzh);
        zzfpw2 = zzfny2;
        if (this.zzg != 0) return zzfpw2.zze();
        bl2 = zzjr2.zzi;
        zzfpw2 = zzfny2.zzc(false, false);
        return zzfpw2.zze();
    }
}
