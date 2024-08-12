/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznj
 *  com.google.android.gms.internal.ads.zznk
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzup
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznj;
import com.google.android.gms.internal.ads.zznk;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzup;
import java.io.IOException;

final class zzud
implements zznk {
    private final zzamn zza;
    private final zzamf zzb;
    private final int zzc;

    public zzud(int n, zzamn zzamn2, int n2) {
        this.zzc = n;
        this.zza = zzamn2;
        this.zzb = new zzamf();
    }

    public final zznj zza(zznv zznv2, long l) throws IOException {
        block4: {
            int n;
            long l2 = zznv2.zzn();
            int n2 = (int)Math.min(112800L, zznv2.zzo() - l2);
            this.zzb.zza(n2);
            byte[] byArray = this.zzb.zzi();
            ((zznp)zznv2).zzh(byArray, 0, n2, false);
            zznv2 = this.zzb;
            int n3 = zznv2.zze();
            long l3 = -1L;
            long l4 = -1L;
            long l5 = -9223372036854775807L;
            while (zznv2.zzd() >= 188 && (n2 = (n = zzup.zza((byte[])zznv2.zzi(), (int)zznv2.zzg(), (int)n3)) + 188) <= n3) {
                long l6;
                long l7;
                block5: {
                    block8: {
                        block7: {
                            block6: {
                                l3 = zzup.zzb((zzamf)zznv2, (int)n, (int)this.zzc);
                                l7 = l4;
                                l6 = l5;
                                if (l3 == -9223372036854775807L) break block5;
                                l6 = this.zza.zze(l3);
                                if (l6 <= l) break block6;
                                if (l5 == -9223372036854775807L) {
                                    zznv2 = zznj.zzd((long)l6, (long)l2);
                                    break block4;
                                }
                                l = l2 + l4;
                                break block7;
                            }
                            if (100000L + l6 <= l) break block8;
                            l = l2 + (long)n;
                        }
                        zznv2 = zznj.zzf((long)l);
                        break block4;
                    }
                    l7 = n;
                }
                zznv2.zzh(n2);
                l3 = n2;
                l4 = l7;
                l5 = l6;
            }
            zznv2 = l5 != -9223372036854775807L ? zznj.zze((long)l5, (long)(l2 + l3)) : zznj.zza;
        }
        return zznv2;
    }

    public final void zzb() {
        zzamf zzamf2 = this.zzb;
        byte[] byArray = zzamq.zzf;
        int n = byArray.length;
        zzamf2.zzb(byArray, 0);
    }
}
