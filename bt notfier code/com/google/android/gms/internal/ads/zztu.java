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
 *  com.google.android.gms.internal.ads.zztt
 *  com.google.android.gms.internal.ads.zztv
 *  com.google.android.gms.internal.ads.zztw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznj;
import com.google.android.gms.internal.ads.zznk;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zztt;
import com.google.android.gms.internal.ads.zztv;
import com.google.android.gms.internal.ads.zztw;
import java.io.IOException;

final class zztu
implements zznk {
    private final zzamn zza;
    private final zzamf zzb;

    /* synthetic */ zztu(zzamn zzamn2, zztt zztt2) {
        this.zza = zzamn2;
        this.zzb = new zzamf();
    }

    public final zznj zza(zznv zznv2, long l) throws IOException {
        long l2 = zznv2.zzn();
        int n = (int)Math.min(20000L, zznv2.zzo() - l2);
        this.zzb.zza(n);
        byte[] byArray = this.zzb.zzi();
        ((zznp)zznv2).zzh(byArray, 0, n, false);
        zznv2 = this.zzb;
        int n2 = -1;
        long l3 = -9223372036854775807L;
        int n3 = -1;
        while (true) {
            long l4;
            block12: {
                block15: {
                    block8: {
                        block4: {
                            block16: {
                                block14: {
                                    block13: {
                                        block11: {
                                            block5: {
                                                block10: {
                                                    block9: {
                                                        block6: {
                                                            block7: {
                                                                if (zznv2.zzd() < 4) break block4;
                                                                if (zztv.zzh((byte[])zznv2.zzi(), (int)zznv2.zzg()) != 442) {
                                                                    zznv2.zzk(1);
                                                                    continue;
                                                                }
                                                                zznv2.zzk(4);
                                                                long l5 = zztw.zze((zzamf)zznv2);
                                                                n = n3;
                                                                l4 = l3;
                                                                if (l5 == -9223372036854775807L) break block5;
                                                                l4 = this.zza.zze(l5);
                                                                if (l4 <= l) break block6;
                                                                if (l3 != -9223372036854775807L) break block7;
                                                                zznv2 = zznj.zzd((long)l4, (long)l2);
                                                                break block8;
                                                            }
                                                            l = n3;
                                                            break block9;
                                                        }
                                                        if (100000L + l4 <= l) break block10;
                                                        l = zznv2.zzg();
                                                    }
                                                    zznv2 = zznj.zzf((long)(l2 + l));
                                                    break block8;
                                                }
                                                n = zznv2.zzg();
                                            }
                                            n3 = zznv2.zze();
                                            if (zznv2.zzd() >= 10) break block11;
                                            zznv2.zzh(n3);
                                            break block12;
                                        }
                                        zznv2.zzk(9);
                                        n2 = zznv2.zzn() & 7;
                                        if (zznv2.zzd() >= n2) break block13;
                                        zznv2.zzh(n3);
                                        break block12;
                                    }
                                    zznv2.zzk(n2);
                                    if (zznv2.zzd() >= 4) break block14;
                                    zznv2.zzh(n3);
                                    break block12;
                                }
                                if (zztv.zzh((byte[])zznv2.zzi(), (int)zznv2.zzg()) != 443) break block15;
                                zznv2.zzk(4);
                                n2 = zznv2.zzo();
                                if (zznv2.zzd() >= n2) break block16;
                                zznv2.zzh(n3);
                                break block12;
                            }
                            zznv2.zzk(n2);
                            break block15;
                        }
                        zznv2 = l3 != -9223372036854775807L ? zznj.zze((long)l3, (long)(l2 + (long)n2)) : zznj.zza;
                    }
                    return zznv2;
                }
                while (zznv2.zzd() >= 4 && (n2 = zztv.zzh((byte[])zznv2.zzi(), (int)zznv2.zzg())) != 442 && n2 != 441 && n2 >>> 8 == 1) {
                    zznv2.zzk(4);
                    if (zznv2.zzd() < 2) {
                        zznv2.zzh(n3);
                        break;
                    }
                    n2 = zznv2.zzo();
                    zznv2.zzh(Math.min(zznv2.zze(), zznv2.zzg() + n2));
                }
            }
            n2 = zznv2.zzg();
            n3 = n;
            l3 = l4;
        }
    }

    public final void zzb() {
        zzamf zzamf2 = this.zzb;
        byte[] byArray = zzamq.zzf;
        int n = byArray.length;
        zzamf2.zzb(byArray, 0);
    }
}
