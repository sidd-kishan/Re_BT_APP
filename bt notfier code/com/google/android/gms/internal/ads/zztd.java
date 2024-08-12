/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zztc
 *  com.google.android.gms.internal.ads.zztq
 *  com.google.android.gms.internal.ads.zzun
 *  com.google.android.gms.internal.ads.zzuq
 */
package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zztc;
import com.google.android.gms.internal.ads.zztq;
import com.google.android.gms.internal.ads.zzun;
import com.google.android.gms.internal.ads.zzuq;
import java.util.Arrays;
import java.util.Collections;

public final class zztd
implements zztb {
    private static final double[] zzc = new double[]{23.976023976023978, 24.0, 25.0, 29.97002997002997, 30.0, 50.0, 59.94005994005994, 60.0};
    private String zza;
    private zzox zzb;
    private final zzuq zzd;
    private final zzamf zze;
    private final zztq zzf;
    private final boolean[] zzg;
    private final zztc zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;

    public zztd() {
        this(null);
    }

    zztd(zzuq zzuq2) {
        this.zzd = zzuq2;
        this.zzg = new boolean[4];
        this.zzh = new zztc(128);
        if (zzuq2 != null) {
            this.zzf = new zztq(178, 128);
            zzuq2 = new zzamf();
        } else {
            zzuq2 = null;
            this.zzf = null;
        }
        this.zze = zzuq2;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }

    public final void zza() {
        zzalw.zze((boolean[])this.zzg);
        this.zzh.zza();
        zztq zztq2 = this.zzf;
        if (zztq2 != null) {
            zztq2.zza();
        }
        this.zzi = 0L;
        this.zzj = false;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzun2.zza();
        this.zza = zzun2.zzc();
        this.zzb = zznx2.zzB(zzun2.zzb(), 2);
        zzuq zzuq2 = this.zzd;
        if (zzuq2 == null) return;
        zzuq2.zza(zznx2, zzun2);
    }

    public final void zzc(long l, int n) {
        this.zzm = l;
    }

    public final void zzd(zzamf zzamf2) {
        zzakt.zze((Object)this.zzb);
        int n = zzamf2.zzg();
        int n2 = zzamf2.zze();
        byte[] byArray = zzamf2.zzi();
        this.zzi += (long)zzamf2.zzd();
        zzov.zzb((zzox)this.zzb, (zzamf)zzamf2, (int)zzamf2.zzd());
        while (true) {
            long l;
            zztq zztq2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            block18: {
                float f;
                int n8;
                int n9;
                byte[] byArray2;
                String string;
                block22: {
                    block23: {
                        block19: {
                            block20: {
                                block21: {
                                    if ((n7 = zzalw.zzd((byte[])byArray, (int)n, (int)n2, (boolean[])this.zzg)) == n2) {
                                        if (!this.zzk) {
                                            this.zzh.zzc(byArray, n, n2);
                                        }
                                        if ((zzamf2 = this.zzf) == null) return;
                                        zzamf2.zzd(byArray, n, n2);
                                        return;
                                    }
                                    n6 = n7 + 3;
                                    n5 = zzamf2.zzi()[n6] & 0xFF;
                                    n4 = n7 - n;
                                    if (this.zzk) break block18;
                                    if (n4 > 0) {
                                        this.zzh.zzc(byArray, n, n7);
                                    }
                                    if (!this.zzh.zzb(n5, n3 = n4 < 0 ? -n4 : 0)) break block18;
                                    zztq2 = this.zzh;
                                    string = this.zza;
                                    if (string == null) throw null;
                                    byArray2 = Arrays.copyOf(zztq2.zzc, zztq2.zza);
                                    n9 = byArray2[4];
                                    n3 = byArray2[5] & 0xFF;
                                    n9 = (n9 & 0xFF) << 4 | n3 >> 4;
                                    n8 = (n3 & 0xF) << 8 | byArray2[6] & 0xFF;
                                    n3 = (byArray2[7] & 0xF0) >> 4;
                                    if (n3 == 2) break block19;
                                    if (n3 == 3) break block20;
                                    if (n3 == 4) break block21;
                                    f = 1.0f;
                                    break block22;
                                }
                                f = n8 * 121;
                                n3 = n9 * 100;
                                break block23;
                            }
                            f = n8 * 16;
                            n3 = n9 * 9;
                            break block23;
                        }
                        f = n8 * 4;
                        n3 = n9 * 3;
                    }
                    f /= (float)n3;
                }
                zzaft zzaft2 = new zzaft();
                zzaft2.zzD(string);
                zzaft2.zzN("video/mpeg2");
                zzaft2.zzS(n9);
                zzaft2.zzT(n8);
                zzaft2.zzW(f);
                zzaft2.zzP(Collections.singletonList(byArray2));
                zzaft2 = zzaft2.zzah();
                n3 = (byArray2[7] & 0xF) - 1;
                l = 0L;
                if (n3 >= 0 && n3 < 8) {
                    double d = zzc[n3];
                    n9 = byArray2[zztq2.zzb + 9];
                    n3 = (n9 & 0x60) >> 5;
                    if (n3 != (n9 &= 0x1F)) {
                        double d2 = n3;
                        Double.isNaN(d2);
                        double d3 = n9 + 1;
                        Double.isNaN(d3);
                        d *= (d2 + 1.0) / d3;
                    }
                    l = (long)(1000000.0 / d);
                }
                zztq2 = Pair.create((Object)zzaft2, (Object)l);
                this.zzb.zzs((zzafv)zztq2.first);
                this.zzl = (Long)zztq2.second;
                this.zzk = true;
            }
            zztq2 = this.zzf;
            n3 = n5;
            if (zztq2 != null) {
                if (n4 > 0) {
                    zztq2.zzd(byArray, n, n7);
                    n3 = 0;
                } else {
                    n3 = -n4;
                }
                if (this.zzf.zze(n3)) {
                    zztq2 = this.zzf;
                    n3 = zzalw.zza((byte[])zztq2.zza, (int)zztq2.zzb);
                    zztq2 = this.zze;
                    n = zzamq.zza;
                    zztq2.zzb(this.zzf.zza, n3);
                    this.zzd.zzb(this.zzo, this.zze);
                }
                n3 = n5;
                if (n5 == 178) {
                    if (zzamf2.zzi()[n7 + 2] == 1) {
                        this.zzf.zzc(178);
                    }
                    n3 = 178;
                }
            }
            if (n3 != 0 && n3 != 179) {
                if (n3 == 184) {
                    this.zzp = true;
                }
            } else {
                n5 = n2 - n7;
                if (this.zzq && this.zzk && (l = this.zzo) != -9223372036854775807L) {
                    n = this.zzp ? 1 : 0;
                    long l2 = this.zzi;
                    long l3 = this.zzn;
                    this.zzb.zzv(l, n, (int)(l2 - l3) - n5, n5, null);
                }
                if (!this.zzj || this.zzq) {
                    this.zzn = this.zzi - (long)n5;
                    l = this.zzm;
                    if (l == -9223372036854775807L) {
                        l = this.zzo;
                        l = l != -9223372036854775807L ? (l += this.zzl) : -9223372036854775807L;
                    }
                    this.zzo = l;
                    this.zzp = false;
                    this.zzm = -9223372036854775807L;
                    this.zzj = true;
                }
                boolean bl = n3 == 0;
                this.zzq = bl;
            }
            n = n6;
        }
    }

    public final void zze() {
    }
}
