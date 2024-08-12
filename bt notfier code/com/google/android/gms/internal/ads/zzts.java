/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zzun
 *  com.google.android.gms.internal.ads.zzuo
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zzun;
import com.google.android.gms.internal.ads.zzuo;

public final class zzts
implements zzuo {
    private final zztb zza;
    private final zzame zzb;
    private int zzc;
    private int zzd;
    private zzamn zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzts(zztb zztb2) {
        this.zza = zztb2;
        this.zzb = new zzame(new byte[10], 10);
        this.zzc = 0;
    }

    private final void zzd(int n) {
        this.zzc = n;
        this.zzd = 0;
    }

    private final boolean zze(zzamf zzamf2, byte[] byArray, int n) {
        int n2 = Math.min(zzamf2.zzd(), n - this.zzd);
        if (n2 <= 0) {
            return true;
        }
        if (byArray == null) {
            zzamf2.zzk(n2);
        } else {
            zzamf2.zzm(byArray, this.zzd, n2);
        }
        this.zzd = n2 = this.zzd + n2;
        if (n2 != n) return false;
        return true;
    }

    public final void zza(zzamn zzamn2, zznx zznx2, zzun zzun2) {
        this.zze = zzamn2;
        this.zza.zzb(zznx2, zzun2);
    }

    public final void zzb() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zza();
    }

    public final void zzc(zzamf zzamf2, int n) throws zzaha {
        StringBuilder stringBuilder;
        int n2;
        zzakt.zze((Object)this.zze);
        int n3 = -1;
        if ((n & 1) != 0) {
            n2 = this.zzc;
            if (n2 != 0 && n2 != 1) {
                if (n2 != 2) {
                    n2 = this.zzj;
                    if (n2 != -1) {
                        stringBuilder = new StringBuilder(59);
                        stringBuilder.append("Unexpected start indicator: expected ");
                        stringBuilder.append(n2);
                        stringBuilder.append(" more bytes");
                        Log.w((String)"PesReader", (String)stringBuilder.toString());
                    }
                    this.zza.zze();
                } else {
                    Log.w((String)"PesReader", (String)"Unexpected start indicator reading extended header");
                }
            }
            this.zzd(1);
        }
        n2 = n;
        n = n3;
        while (zzamf2.zzd() > 0) {
            int n4 = this.zzc;
            if (n4 != 0) {
                n3 = 0;
                if (n4 != 1) {
                    if (n4 != 2) {
                        int n5 = zzamf2.zzd();
                        n4 = this.zzj;
                        if (n4 != n) {
                            n3 = n5 - n4;
                        }
                        n4 = n5;
                        if (n3 > 0) {
                            n4 = n5 - n3;
                            zzamf2.zzf(zzamf2.zzg() + n4);
                        }
                        this.zza.zzd(zzamf2);
                        n5 = this.zzj;
                        n3 = n;
                        if (n5 != n) {
                            this.zzj = n4 = n5 - n4;
                            n3 = n;
                            if (n4 == 0) {
                                this.zza.zze();
                                this.zzd(1);
                                n3 = n;
                            }
                        }
                    } else {
                        n4 = Math.min(10, this.zzi);
                        n3 = n;
                        if (this.zze(zzamf2, this.zzb.zza, n4)) {
                            n3 = n;
                            if (this.zze(zzamf2, null, this.zzi)) {
                                long l;
                                this.zzb.zzd(0);
                                if (this.zzf) {
                                    this.zzb.zzf(4);
                                    n3 = this.zzb.zzh(3);
                                    this.zzb.zzf(1);
                                    n = this.zzb.zzh(15);
                                    this.zzb.zzf(1);
                                    long l2 = n3;
                                    long l3 = n << 15;
                                    l = this.zzb.zzh(15);
                                    this.zzb.zzf(1);
                                    if (!this.zzh && this.zzg) {
                                        this.zzb.zzf(4);
                                        n3 = this.zzb.zzh(3);
                                        this.zzb.zzf(1);
                                        n = this.zzb.zzh(15);
                                        this.zzb.zzf(1);
                                        n4 = this.zzb.zzh(15);
                                        this.zzb.zzf(1);
                                        this.zze.zze((long)n3 << 30 | (long)(n << 15) | (long)n4);
                                        this.zzh = true;
                                    }
                                    l = this.zze.zze(l3 | l2 << 30 | l);
                                } else {
                                    l = -9223372036854775807L;
                                }
                                n = true != this.zzk ? 0 : 4;
                                this.zza.zzc(l, n2 |= n);
                                this.zzd(3);
                                n = -1;
                                continue;
                            }
                        }
                    }
                } else {
                    if (this.zze(zzamf2, this.zzb.zza, 9)) {
                        stringBuilder = this.zzb;
                        n = 0;
                        stringBuilder.zzd(0);
                        n3 = this.zzb.zzh(24);
                        if (n3 != 1) {
                            stringBuilder = new StringBuilder(41);
                            stringBuilder.append("Unexpected start code prefix: ");
                            stringBuilder.append(n3);
                            Log.w((String)"PesReader", (String)stringBuilder.toString());
                            this.zzj = -1;
                        } else {
                            this.zzb.zzf(8);
                            n3 = this.zzb.zzh(16);
                            this.zzb.zzf(5);
                            this.zzk = this.zzb.zzg();
                            this.zzb.zzf(2);
                            this.zzf = this.zzb.zzg();
                            this.zzg = this.zzb.zzg();
                            this.zzb.zzf(6);
                            this.zzi = n = this.zzb.zzh(8);
                            if (n3 == 0) {
                                this.zzj = -1;
                            } else {
                                this.zzj = n = n3 - 3 - n;
                                if (n < 0) {
                                    stringBuilder = new StringBuilder(47);
                                    stringBuilder.append("Found negative packet payload size: ");
                                    stringBuilder.append(n);
                                    Log.w((String)"PesReader", (String)stringBuilder.toString());
                                    this.zzj = -1;
                                }
                            }
                            n = 2;
                        }
                        n3 = -1;
                        this.zzd(n);
                        n = n3;
                        continue;
                    }
                    n3 = -1;
                }
                n = n3;
                continue;
            }
            zzamf2.zzk(zzamf2.zzd());
        }
    }
}
