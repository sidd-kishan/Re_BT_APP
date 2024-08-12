/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzmv
 *  com.google.android.gms.internal.ads.zzmx
 *  com.google.android.gms.internal.ads.zznt
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzmv;
import com.google.android.gms.internal.ads.zzmx;
import com.google.android.gms.internal.ads.zznt;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zzun;
import java.util.Arrays;
import java.util.Collections;

public final class zzsx
implements zztb {
    private static final byte[] zza = new byte[]{73, 68, 51};
    private final boolean zzb;
    private final zzame zzc = new zzame(new byte[7], 7);
    private final zzamf zzd = new zzamf(Arrays.copyOf(zza, 10));
    private final String zze;
    private String zzf;
    private zzox zzg;
    private zzox zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;
    private int zzs;
    private long zzt;
    private zzox zzu;
    private long zzv;

    public zzsx(boolean bl, String string) {
        this.zzi();
        this.zzn = -1;
        this.zzo = -1;
        this.zzr = -9223372036854775807L;
        this.zzt = -9223372036854775807L;
        this.zzb = bl;
        this.zze = string;
    }

    public static boolean zzf(int n) {
        if ((n & 0xFFF6) != 65520) return false;
        return true;
    }

    private final void zzg() {
        this.zzm = false;
        this.zzi();
    }

    private final boolean zzh(zzamf zzamf2, byte[] byArray, int n) {
        int n2 = Math.min(zzamf2.zzd(), n - this.zzj);
        zzamf2.zzm(byArray, this.zzj, n2);
        this.zzj = n2 = this.zzj + n2;
        if (n2 != n) return false;
        return true;
    }

    private final void zzi() {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 256;
    }

    private final void zzj(zzox zzox2, long l, int n, int n2) {
        this.zzi = 4;
        this.zzj = n;
        this.zzu = zzox2;
        this.zzv = l;
        this.zzs = n2;
    }

    private final void zzk() {
        this.zzi = 3;
        this.zzj = 0;
    }

    private static final boolean zzl(byte by, byte by2) {
        return zzsx.zzf(by2 & 0xFF | 0xFF00);
    }

    private static final boolean zzm(zzamf zzamf2, byte[] byArray, int n) {
        if (zzamf2.zzd() < n) {
            return false;
        }
        zzamf2.zzm(byArray, 0, n);
        return true;
    }

    public final void zza() {
        this.zzt = -9223372036854775807L;
        this.zzg();
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzox zzox2;
        zzun2.zza();
        this.zzf = zzun2.zzc();
        this.zzg = zzox2 = zznx2.zzB(zzun2.zzb(), 1);
        this.zzu = zzox2;
        if (this.zzb) {
            zzun2.zza();
            zznx2 = zznx2.zzB(zzun2.zzb(), 5);
            this.zzh = zznx2;
            zzox2 = new zzaft();
            zzox2.zzD(zzun2.zzc());
            zzox2.zzN("application/id3");
            zznx2.zzs(zzox2.zzah());
            return;
        }
        this.zzh = new zznt();
    }

    public final void zzc(long l, int n) {
        if (l == -9223372036854775807L) return;
        this.zzt = l;
    }

    public final void zzd(zzamf zzamf2) throws zzaha {
        if (this.zzg == null) throw null;
        int n = zzamq.zza;
        block0: while (zzamf2.zzd() > 0) {
            byte[] byArray;
            int n2;
            Object object;
            int n3;
            n = this.zzi;
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            n = Math.min(zzamf2.zzd(), this.zzs - this.zzj);
                            this.zzu.zzy(zzamf2, n);
                            this.zzj = n = this.zzj + n;
                            n3 = this.zzs;
                            if (n != n3) continue;
                            long l = this.zzt;
                            if (l != -9223372036854775807L) {
                                this.zzu.zzv(l, 1, n3, 0, null);
                                this.zzt += this.zzv;
                            }
                            this.zzi();
                            continue;
                        }
                        n = true != this.zzl ? 5 : 7;
                        if (!this.zzh(zzamf2, this.zzc.zza, n)) continue;
                        this.zzc.zzd(0);
                        if (!this.zzq) {
                            n = this.zzc.zzh(2) + 1;
                            if (n != 2) {
                                object = new StringBuilder(61);
                                ((StringBuilder)object).append("Detected audio object type: ");
                                ((StringBuilder)object).append(n);
                                ((StringBuilder)object).append(", but assuming AAC LC.");
                                Log.w((String)"AdtsReader", (String)((StringBuilder)object).toString());
                            }
                            this.zzc.zzf(5);
                            n3 = this.zzc.zzh(3);
                            n = this.zzo;
                            n2 = zzmx.zza;
                            byArray = new byte[]{(byte)(n >> 1 & 7 | 0x10), (byte)(n3 << 3 & 0x78 | n << 7 & 0x80)};
                            object = zzmx.zza((byte[])byArray);
                            zzaft zzaft2 = new zzaft();
                            zzaft2.zzD(this.zzf);
                            zzaft2.zzN("audio/mp4a-latm");
                            zzaft2.zzK(((zzmv)object).zzc);
                            zzaft2.zzaa(((zzmv)object).zzb);
                            zzaft2.zzab(((zzmv)object).zza);
                            zzaft2.zzP(Collections.singletonList(byArray));
                            zzaft2.zzG(this.zze);
                            object = zzaft2.zzah();
                            this.zzr = 1024000000L / (long)((zzafv)object).zzz;
                            this.zzg.zzs((zzafv)object);
                            this.zzq = true;
                        } else {
                            this.zzc.zzf(10);
                        }
                        this.zzc.zzf(4);
                        n = n3 = this.zzc.zzh(13) - 7;
                        if (this.zzl) {
                            n = n3 - 2;
                        }
                        this.zzj(this.zzg, this.zzr, 0, n);
                        continue;
                    }
                    if (!this.zzh(zzamf2, this.zzd.zzi(), 10)) continue;
                    this.zzh.zzy(this.zzd, 10);
                    this.zzd.zzh(6);
                    this.zzj(this.zzh, 0L, 10, 10 + this.zzd.zzA());
                    continue;
                }
                if (zzamf2.zzd() == 0) continue;
                this.zzc.zza[0] = zzamf2.zzi()[zzamf2.zzg()];
                this.zzc.zzd(2);
                n = this.zzc.zzh(4);
                n3 = this.zzo;
                if (n3 != -1 && n != n3) {
                    this.zzg();
                    continue;
                }
                if (!this.zzm) {
                    this.zzm = true;
                    this.zzn = this.zzp;
                    this.zzo = n;
                }
                this.zzk();
                continue;
            }
            byArray = zzamf2.zzi();
            n = zzamf2.zzg();
            n2 = zzamf2.zze();
            while (n < n2) {
                block27: {
                    block28: {
                        block23: {
                            block24: {
                                block25: {
                                    block26: {
                                        int n4;
                                        block20: {
                                            block21: {
                                                int n5;
                                                int n6;
                                                block22: {
                                                    n3 = n + 1;
                                                    n = byArray[n] & 0xFF;
                                                    if (this.zzk != 512 || !zzsx.zzl((byte)-1, (byte)n)) break block20;
                                                    if (this.zzm) break block21;
                                                    n6 = n3 - 2;
                                                    zzamf2.zzh(n6 + 1);
                                                    if (!zzsx.zzm(zzamf2, this.zzc.zza, 1)) break block20;
                                                    this.zzc.zzd(4);
                                                    n5 = this.zzc.zzh(1);
                                                    n4 = this.zzn;
                                                    if (n4 != -1 && n5 != n4) break block20;
                                                    if (this.zzo == -1) break block22;
                                                    if (!zzsx.zzm(zzamf2, this.zzc.zza, 1)) break block21;
                                                    this.zzc.zzd(2);
                                                    if (this.zzc.zzh(4) != this.zzo) break block20;
                                                    zzamf2.zzh(n6 + 2);
                                                }
                                                if (!zzsx.zzm(zzamf2, this.zzc.zza, 4)) break block21;
                                                this.zzc.zzd(14);
                                                Object object2 = this.zzc.zzh(13);
                                                if (object2 < 7) break block20;
                                                object = zzamf2.zzi();
                                                n4 = zzamf2.zze();
                                                if ((n6 += object2) < n4 && !((object2 = (Object)object[n6]) == -1 ? ++n6 == n4 || zzsx.zzl((byte)-1, (byte)object[n6]) && (object[n6] & 8) >> 3 == n5 : object2 == 73 && ((n5 = n6 + 1) == n4 || object[n5] == 68 && ((n5 = n6 + 2) == n4 || object[n5] == 51)))) break block20;
                                            }
                                            this.zzp = (n & 8) >> 3;
                                            boolean bl = 1 == (n & 1 ^ 1);
                                            this.zzl = bl;
                                            if (!this.zzm) {
                                                this.zzi = 1;
                                                this.zzj = 0;
                                            } else {
                                                this.zzk();
                                            }
                                            zzamf2.zzh(n3);
                                            continue block0;
                                        }
                                        if ((n = (n4 = this.zzk) | n) == 329) break block23;
                                        if (n == 511) break block24;
                                        if (n == 836) break block25;
                                        if (n == 1075) break block26;
                                        if (n4 != 256) {
                                            this.zzk = 256;
                                            n = n3 - 1;
                                            continue;
                                        }
                                        break block27;
                                    }
                                    this.zzi = 2;
                                    this.zzj = 3;
                                    this.zzs = 0;
                                    this.zzd.zzh(0);
                                    zzamf2.zzh(n3);
                                    continue block0;
                                }
                                n = 1024;
                                break block28;
                            }
                            n = 512;
                            break block28;
                        }
                        n = 768;
                    }
                    this.zzk = n;
                }
                n = n3;
            }
            zzamf2.zzh(n);
        }
    }

    public final void zze() {
    }
}
