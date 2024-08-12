/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzmv
 *  com.google.android.gms.internal.ads.zzmx
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzmv;
import com.google.android.gms.internal.ads.zzmx;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zzun;
import java.util.Collections;

public final class zzto
implements zztb {
    private final String zza;
    private final zzamf zzb;
    private final zzame zzc;
    private zzox zzd;
    private String zze;
    private zzafv zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private long zzq;
    private int zzr;
    private long zzs;
    private int zzt;
    private String zzu;

    public zzto(String object) {
        this.zza = object;
        object = new zzamf(1024);
        this.zzb = object;
        object = object.zzi();
        this.zzc = new zzame((byte[])object, ((Object)object).length);
        this.zzk = -9223372036854775807L;
    }

    private final int zzf(zzame zzame2) throws zzaha {
        int n = zzame2.zzb();
        zzmv zzmv2 = zzmx.zzb((zzame)zzame2, (boolean)true);
        this.zzu = zzmv2.zzc;
        this.zzr = zzmv2.zza;
        this.zzt = zzmv2.zzb;
        return n - zzame2.zzb();
    }

    private static long zzg(zzame zzame2) {
        return zzame2.zzh((zzame2.zzh(2) + 1) * 8);
    }

    public final void zza() {
        this.zzg = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = false;
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzun2.zza();
        this.zzd = zznx2.zzB(zzun2.zzb(), 1);
        this.zze = zzun2.zzc();
    }

    public final void zzc(long l, int n) {
        if (l == -9223372036854775807L) return;
        this.zzk = l;
    }

    public final void zzd(zzamf zzamf2) throws zzaha {
        zzakt.zze((Object)this.zzd);
        while (zzamf2.zzd() > 0) {
            block30: {
                int n;
                block31: {
                    Object object;
                    zzame zzame2;
                    block32: {
                        block35: {
                            int n2;
                            block34: {
                                block33: {
                                    boolean bl;
                                    n = this.zzg;
                                    if (n == 0) break block30;
                                    if (n == 1) break block31;
                                    if (n == 2) break block32;
                                    n = Math.min(zzamf2.zzd(), this.zzi - this.zzh);
                                    zzamf2.zzm(this.zzc.zza, this.zzh, n);
                                    this.zzh = n = this.zzh + n;
                                    if (n != this.zzi) continue;
                                    this.zzc.zzd(0);
                                    zzame2 = this.zzc;
                                    if (zzame2.zzg()) break block33;
                                    this.zzl = true;
                                    n = zzame2.zzh(1);
                                    if (n == 1) {
                                        n2 = zzame2.zzh(1);
                                        n = 1;
                                    } else {
                                        n2 = 0;
                                    }
                                    this.zzm = n2;
                                    if (n2 != 0) throw zzaha.zzb(null, null);
                                    n2 = n;
                                    if (n == 1) {
                                        zzto.zzg(zzame2);
                                        n2 = 1;
                                    }
                                    if (!zzame2.zzg()) throw zzaha.zzb(null, null);
                                    this.zzn = zzame2.zzh(6);
                                    int n3 = zzame2.zzh(4);
                                    n = zzame2.zzh(3);
                                    if (n3 != 0) throw zzaha.zzb(null, null);
                                    if (n != 0) throw zzaha.zzb(null, null);
                                    if (n2 == 0) {
                                        n3 = zzame2.zzc();
                                        n = this.zzf(zzame2);
                                        zzame2.zzd(n3);
                                        byte[] byArray = new byte[(n + 7) / 8];
                                        zzame2.zzi(byArray, 0, n);
                                        object = new zzaft();
                                        object.zzD(this.zze);
                                        object.zzN("audio/mp4a-latm");
                                        object.zzK(this.zzu);
                                        object.zzaa(this.zzt);
                                        object.zzab(this.zzr);
                                        object.zzP(Collections.singletonList(byArray));
                                        object.zzG(this.zza);
                                        object = object.zzah();
                                        if (!object.equals((Object)this.zzf)) {
                                            this.zzf = (zzafv)object;
                                            this.zzs = 1024000000L / (long)object.zzz;
                                            this.zzd.zzs((zzafv)object);
                                        }
                                    } else {
                                        zzame2.zzf((int)zzto.zzg(zzame2) - this.zzf(zzame2));
                                    }
                                    this.zzo = n = zzame2.zzh(3);
                                    if (n != 0) {
                                        if (n != 1) {
                                            if (n != 3 && n != 4 && n != 5) {
                                                if (n != 6) {
                                                    if (n != 7) throw new IllegalStateException();
                                                }
                                                zzame2.zzf(1);
                                            } else {
                                                zzame2.zzf(6);
                                            }
                                        } else {
                                            zzame2.zzf(9);
                                        }
                                    } else {
                                        zzame2.zzf(8);
                                    }
                                    this.zzp = bl = zzame2.zzg();
                                    this.zzq = 0L;
                                    if (bl) {
                                        if (n2 != 1) {
                                            do {
                                                bl = zzame2.zzg();
                                                this.zzq = (this.zzq << 8) + (long)zzame2.zzh(8);
                                            } while (bl);
                                        } else {
                                            this.zzq = zzto.zzg(zzame2);
                                        }
                                    }
                                    if (zzame2.zzg()) {
                                        zzame2.zzf(8);
                                    }
                                    break block34;
                                }
                                if (!this.zzl) break block35;
                            }
                            if (this.zzm != 0) throw zzaha.zzb(null, null);
                            if (this.zzn != 0) throw zzaha.zzb(null, null);
                            if (this.zzo != 0) throw zzaha.zzb(null, null);
                            n = 0;
                            do {
                                n2 = zzame2.zzh(8);
                                n += n2;
                            } while (n2 == 255);
                            n2 = zzame2.zzc();
                            if ((n2 & 7) == 0) {
                                this.zzb.zzh(n2 >> 3);
                            } else {
                                zzame2.zzi(this.zzb.zzi(), 0, n * 8);
                                this.zzb.zzh(0);
                            }
                            zzov.zzb((zzox)this.zzd, (zzamf)this.zzb, (int)n);
                            long l = this.zzk;
                            if (l != -9223372036854775807L) {
                                this.zzd.zzv(l, 1, n, 0, null);
                                this.zzk += this.zzs;
                            }
                            if (this.zzp) {
                                zzame2.zzf((int)this.zzq);
                            }
                        }
                        this.zzg = 0;
                        continue;
                    }
                    this.zzi = n = (this.zzj & 0xFFFFFF1F) << 8 | zzamf2.zzn();
                    if (n > this.zzb.zzi().length) {
                        n = this.zzi;
                        this.zzb.zza(n);
                        zzame2 = this.zzc;
                        object = this.zzb.zzi();
                        zzame2.zza(object, ((byte[])object).length);
                    }
                    this.zzh = 0;
                    this.zzg = 3;
                    continue;
                }
                n = zzamf2.zzn();
                if ((n & 0xE0) == 224) {
                    this.zzj = n;
                    this.zzg = 2;
                    continue;
                }
                if (n == 86) continue;
                this.zzg = 0;
                continue;
            }
            if (zzamf2.zzn() != 86) continue;
            this.zzg = 1;
        }
    }

    public final void zze() {
    }
}
