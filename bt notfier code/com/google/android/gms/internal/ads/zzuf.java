/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzup
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzup;
import java.io.IOException;

final class zzuf {
    private final zzamn zza = new zzamn(0L);
    private final zzamf zzb = new zzamf();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;

    zzuf(int n) {
    }

    private final int zze(zznv zznv2) {
        zzamf zzamf2 = this.zzb;
        byte[] byArray = zzamq.zzf;
        int n = byArray.length;
        zzamf2.zzb(byArray, 0);
        this.zzc = true;
        zznv2.zzl();
        return 0;
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final int zzb(zznv zznv2, zzoq object, int n) throws IOException {
        block13: {
            long l;
            int n2;
            long l2;
            int n3;
            block12: {
                block10: {
                    int n4;
                    long l3;
                    int n5;
                    block9: {
                        block11: {
                            block8: {
                                n3 = 0;
                                n5 = 0;
                                if (n <= 0) {
                                    this.zze(zznv2);
                                    return 0;
                                }
                                boolean bl = this.zze;
                                l2 = -9223372036854775807L;
                                if (bl) break block8;
                                l3 = zznv2.zzo();
                                n4 = (int)Math.min(112800L, l3);
                                if (zznv2.zzn() == (l3 -= (long)n4)) break block9;
                                object.zza = l3;
                                n = 1;
                                break block10;
                            }
                            if (this.zzg == -9223372036854775807L) {
                                this.zze(zznv2);
                                return 0;
                            }
                            if (this.zzd) break block11;
                            n2 = (int)Math.min(112800L, zznv2.zzo());
                            if (zznv2.zzn() == 0L) break block12;
                            object.zza = 0L;
                            n = 1;
                            break block13;
                        }
                        l2 = this.zzf;
                        if (l2 == -9223372036854775807L) {
                            this.zze(zznv2);
                            return 0;
                        }
                        l2 = this.zza.zze(l2);
                        this.zzh = l2 = this.zza.zze(this.zzg) - l2;
                        if (l2 < 0L) {
                            object = new StringBuilder(65);
                            object.append("Invalid duration: ");
                            object.append(l2);
                            object.append(". Using TIME_UNSET instead.");
                            Log.w((String)"TsDurationReader", (String)object.toString());
                            this.zzh = -9223372036854775807L;
                        }
                        this.zze(zznv2);
                        return 0;
                    }
                    this.zzb.zza(n4);
                    zznv2.zzl();
                    object = this.zzb.zzi();
                    ((zznp)zznv2).zzh((byte[])object, 0, n4, false);
                    zznv2 = this.zzb;
                    int n6 = zznv2.zzg();
                    int n7 = zznv2.zze();
                    n3 = n7 - 188;
                    block0: while (true) {
                        l3 = l2;
                        if (n3 < n6) break;
                        object = zznv2.zzi();
                        n4 = 0;
                        for (int i = -4; i <= 4; ++i) {
                            int n8 = i * 188 + n3;
                            if (n8 >= n6 && n8 < n7 && object[n8] == 71) {
                                n4 = n8 = n4 + 1;
                                if (n8 != 5) continue;
                                l3 = zzup.zzb((zzamf)zznv2, (int)n3, (int)n);
                                if (l3 == -9223372036854775807L) break;
                                break block0;
                            }
                            n4 = 0;
                        }
                        --n3;
                    }
                    this.zzg = l3;
                    this.zze = true;
                    n = n5;
                }
                return n;
            }
            this.zzb.zza(n2);
            zznv2.zzl();
            object = this.zzb.zzi();
            ((zznp)zznv2).zzh((byte[])object, 0, n2, false);
            zznv2 = this.zzb;
            n2 = zznv2.zzg();
            int n9 = zznv2.zze();
            while (true) {
                l = l2;
                if (n2 >= n9 || zznv2.zzi()[n2] == 71 && (l = zzup.zzb((zzamf)zznv2, (int)n2, (int)n)) != -9223372036854775807L) break;
                ++n2;
            }
            this.zzf = l;
            this.zzd = true;
            n = n3;
        }
        return n;
    }

    public final long zzc() {
        return this.zzh;
    }

    public final zzamn zzd() {
        return this.zza;
    }
}
