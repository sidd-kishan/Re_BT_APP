/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzns
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzns;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zzun;

public final class zzsz
implements zztb {
    private final zzamf zza = new zzamf(new byte[18]);
    private final String zzb;
    private String zzc;
    private zzox zzd;
    private int zze = 0;
    private int zzf;
    private int zzg;
    private long zzh;
    private zzafv zzi;
    private int zzj;
    private long zzk = -9223372036854775807L;

    public zzsz(String string) {
        this.zzb = string;
    }

    public final void zza() {
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzk = -9223372036854775807L;
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzun2.zza();
        this.zzc = zzun2.zzc();
        this.zzd = zznx2.zzB(zzun2.zzb(), 1);
    }

    public final void zzc(long l, int n) {
        if (l == -9223372036854775807L) return;
        this.zzk = l;
    }

    public final void zzd(zzamf zzamf2) {
        zzakt.zze((Object)this.zzd);
        block0: while (zzamf2.zzd() > 0) {
            Object object;
            int n;
            int n2;
            block6: {
                block18: {
                    block16: {
                        byte[] byArray;
                        block13: {
                            block17: {
                                block14: {
                                    block15: {
                                        block12: {
                                            block10: {
                                                block7: {
                                                    block11: {
                                                        block8: {
                                                            block9: {
                                                                n2 = this.zze;
                                                                if (n2 == 0) break block6;
                                                                if (n2 != 1) {
                                                                    n2 = Math.min(zzamf2.zzd(), this.zzj - this.zzf);
                                                                    zzov.zzb((zzox)this.zzd, (zzamf)zzamf2, (int)n2);
                                                                    this.zzf = n = this.zzf + n2;
                                                                    n2 = this.zzj;
                                                                    if (n != n2) continue;
                                                                    long l = this.zzk;
                                                                    if (l != -9223372036854775807L) {
                                                                        this.zzd.zzv(l, 1, n2, 0, null);
                                                                        this.zzk += this.zzh;
                                                                    }
                                                                    this.zze = 0;
                                                                    continue;
                                                                }
                                                                object = this.zza.zzi();
                                                                n2 = Math.min(zzamf2.zzd(), 18 - this.zzf);
                                                                zzamf2.zzm(object, this.zzf, n2);
                                                                this.zzf = n2 = this.zzf + n2;
                                                                if (n2 != 18) continue;
                                                                byArray = this.zza.zzi();
                                                                if (this.zzi == null) {
                                                                    object = zzns.zza((byte[])byArray, (String)this.zzc, (String)this.zzb, null);
                                                                    this.zzi = (zzafv)object;
                                                                    this.zzd.zzs((zzafv)object);
                                                                }
                                                                n2 = zzns.zza;
                                                                n2 = byArray[0];
                                                                if (n2 == -2) break block7;
                                                                if (n2 == -1) break block8;
                                                                if (n2 == 31) break block9;
                                                                n = (byArray[5] & 3) << 12 | (byArray[6] & 0xFF) << 4;
                                                                n2 = byArray[7];
                                                                break block10;
                                                            }
                                                            n2 = byArray[6];
                                                            n = byArray[7];
                                                            n2 = (byArray[8] & 0x3C) >> 2 | ((3 & n2) << 12 | (n & 0xFF) << 4);
                                                            break block11;
                                                        }
                                                        n2 = (byArray[7] & 3) << 12 | (byArray[6] & 0xFF) << 4 | (byArray[9] & 0x3C) >> 2;
                                                    }
                                                    n = 1;
                                                    break block12;
                                                }
                                                n = (byArray[4] & 3) << 12 | (byArray[7] & 0xFF) << 4;
                                                n2 = byArray[6];
                                            }
                                            n2 = (n | (n2 & 0xF0) >> 4) + 1;
                                            n = 0;
                                        }
                                        int n3 = ++n2;
                                        if (n != 0) {
                                            n3 = n2 * 16 / 14;
                                        }
                                        this.zzj = n3;
                                        n2 = byArray[0];
                                        if (n2 == -2) break block13;
                                        if (n2 == -1) break block14;
                                        if (n2 == 31) break block15;
                                        n2 = (byArray[4] & 1) << 6;
                                        n = byArray[5];
                                        break block16;
                                    }
                                    n2 = (byArray[5] & 7) << 4;
                                    n = byArray[6];
                                    break block17;
                                }
                                n2 = (byArray[4] & 7) << 4;
                                n = byArray[7];
                            }
                            n &= 0x3C;
                            break block18;
                        }
                        n2 = (byArray[5] & 1) << 6;
                        n = byArray[4];
                    }
                    n &= 0xFC;
                }
                this.zzh = (int)((long)(((n >> 2 | n2) + 1) * 32) * 1000000L / (long)this.zzi.zzz);
                this.zza.zzh(0);
                zzov.zzb((zzox)this.zzd, (zzamf)this.zza, (int)18);
                this.zze = 2;
                continue;
            }
            do {
                if (zzamf2.zzd() <= 0) continue block0;
                this.zzg = n2 = this.zzg << 8;
                this.zzg = n = n2 | zzamf2.zzn();
                n2 = zzns.zza;
            } while (n != 2147385345 && n != -25230976 && n != 536864768 && n != -14745368);
            object = this.zza.zzi();
            n2 = this.zzg;
            object[0] = (byte)(n2 >> 24 & 0xFF);
            object[1] = (byte)(n2 >> 16 & 0xFF);
            object[2] = (byte)(n2 >> 8 & 0xFF);
            object[3] = (byte)(n2 & 0xFF);
            this.zzf = 4;
            this.zzg = 0;
            this.zze = 1;
        }
    }

    public final void zze() {
    }
}
