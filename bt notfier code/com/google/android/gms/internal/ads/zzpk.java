/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzajc
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfll
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzob
 *  com.google.android.gms.internal.ads.zzoc
 *  com.google.android.gms.internal.ads.zzod
 *  com.google.android.gms.internal.ads.zzoe
 *  com.google.android.gms.internal.ads.zzof
 *  com.google.android.gms.internal.ads.zzoh
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzpc
 *  com.google.android.gms.internal.ads.zzpi
 *  com.google.android.gms.internal.ads.zzpj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzajc;
import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzob;
import com.google.android.gms.internal.ads.zzoc;
import com.google.android.gms.internal.ads.zzod;
import com.google.android.gms.internal.ads.zzoe;
import com.google.android.gms.internal.ads.zzof;
import com.google.android.gms.internal.ads.zzoh;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzpc;
import com.google.android.gms.internal.ads.zzpi;
import com.google.android.gms.internal.ads.zzpj;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public final class zzpk
implements zznu {
    public static final zzoa zza = zzpj.zza;
    private final byte[] zzb = new byte[42];
    private final zzamf zzc = new zzamf(new byte[32768], 0);
    private final zzob zzd = new zzob();
    private zznx zze;
    private zzox zzf;
    private int zzg = 0;
    private zzaiv zzh;
    private zzoh zzi;
    private int zzj;
    private int zzk;
    private zzpi zzl;
    private int zzm;
    private long zzn;

    public zzpk() {
        this(0);
    }

    public zzpk(int n) {
    }

    private final long zze(zzamf zzamf2, boolean bl) {
        int n;
        if (this.zzi == null) throw null;
        for (n = zzamf2.zzg(); n <= zzamf2.zze() - 16; ++n) {
            zzamf2.zzh(n);
            if (!zzoc.zza((zzamf)zzamf2, (zzoh)this.zzi, (int)this.zzk, (zzob)this.zzd)) continue;
            zzamf2.zzh(n);
            return this.zzd.zza;
        }
        if (!bl) {
            zzamf2.zzh(n);
        } else {
            while (n <= zzamf2.zze() - this.zzj) {
                zzamf2.zzh(n);
                try {
                    bl = zzoc.zza((zzamf)zzamf2, (zzoh)this.zzi, (int)this.zzk, (zzob)this.zzd);
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    bl = false;
                }
                if (zzamf2.zzg() <= zzamf2.zze() && bl) {
                    zzamf2.zzh(n);
                    return this.zzd.zza;
                }
                ++n;
            }
            zzamf2.zzh(zzamf2.zze());
        }
        return -1L;
    }

    private final void zzf() {
        long l = this.zzn;
        zzoh zzoh2 = this.zzi;
        int n = zzamq.zza;
        l = l * 1000000L / (long)zzoh2.zze;
        this.zzf.zzv(l, 1, this.zzm, 0, null);
    }

    public final boolean zza(zznv zznv2) throws IOException {
        zzoe.zza((zznv)zznv2, (boolean)false);
        zzamf zzamf2 = new zzamf(4);
        byte[] byArray = zzamf2.zzi();
        ((zznp)zznv2).zzh(byArray, 0, 4, false);
        if (zzamf2.zzt() != 1716281667L) return false;
        return true;
    }

    public final void zzb(zznx zznx2) {
        this.zze = zznx2;
        this.zzf = zznx2.zzB(0, 1);
        zznx2.zzC();
    }

    public final int zzc(zznv zznv2, zzoq object) throws IOException {
        Object object2;
        int n;
        boolean bl;
        int n2;
        block20: {
            block21: {
                block23: {
                    int n3;
                    block27: {
                        block25: {
                            block26: {
                                block24: {
                                    block22: {
                                        n2 = this.zzg;
                                        bl = true;
                                        n = 0;
                                        if (n2 == 0) {
                                            zznv2.zzl();
                                            long l = zznv2.zzm();
                                            object = zzoe.zza((zznv)zznv2, (boolean)true);
                                            long l2 = zznv2.zzm();
                                            ((zznp)zznv2).zzd((int)(l2 - l), false);
                                            this.zzh = object;
                                            this.zzg = 1;
                                            return 0;
                                        }
                                        if (n2 == 1) {
                                            object = this.zzb;
                                            ((zznp)zznv2).zzh((byte[])object, 0, 42, false);
                                            zznv2.zzl();
                                            this.zzg = 2;
                                            return 0;
                                        }
                                        if (n2 == 2) {
                                            object = new zzamf(4);
                                            byte[] byArray = object.zzi();
                                            ((zznp)zznv2).zza(byArray, 0, 4, false);
                                            if (object.zzt() != 1716281667L) throw zzaha.zzb((String)"Failed to read FLAC stream marker.", null);
                                            this.zzg = 3;
                                            return 0;
                                        }
                                        if (n2 == 3) break block20;
                                        if (n2 == 4) break block21;
                                        if (this.zzf == null) throw null;
                                        if (this.zzi == null) throw null;
                                        zzpi zzpi2 = this.zzl;
                                        if (zzpi2 == null || !zzpi2.zzc()) break block22;
                                        n = this.zzl.zzd(zznv2, object);
                                        break block23;
                                    }
                                    if (this.zzn != -1L) break block24;
                                    this.zzn = zzoc.zzb((zznv)zznv2, (zzoh)this.zzi);
                                    break block23;
                                }
                                n2 = this.zzc.zze();
                                if (n2 >= 32768) break block25;
                                n3 = zznv2.zzg(this.zzc.zzi(), n2, 32768 - n2);
                                if (n3 != -1) {
                                    bl = false;
                                }
                                if (bl) break block26;
                                this.zzc.zzf(n2 + n3);
                                break block27;
                            }
                            if (this.zzc.zzd() != 0) break block27;
                            this.zzf();
                            n = -1;
                            break block23;
                        }
                        bl = false;
                    }
                    n2 = this.zzc.zzg();
                    n3 = this.zzm;
                    int n4 = this.zzj;
                    if (n3 < n4) {
                        zznv2 = this.zzc;
                        zznv2.zzk(Math.min(n4 - n3, zznv2.zzd()));
                    }
                    long l = this.zze(this.zzc, bl);
                    n3 = this.zzc.zzg() - n2;
                    this.zzc.zzh(n2);
                    zzov.zzb((zzox)this.zzf, (zzamf)this.zzc, (int)n3);
                    this.zzm += n3;
                    if (l != -1L) {
                        this.zzf();
                        this.zzm = 0;
                        this.zzn = l;
                    }
                    if (this.zzc.zzd() >= 16) return n;
                    n = this.zzc.zzd();
                    System.arraycopy(this.zzc.zzi(), this.zzc.zzg(), this.zzc.zzi(), 0, n);
                    this.zzc.zzh(0);
                    this.zzc.zzf(n);
                    return 0;
                }
                return n;
            }
            zznv2.zzl();
            zzamf zzamf2 = new zzamf(2);
            object = zzamf2.zzi();
            ((zznp)zznv2).zzh((byte[])object, 0, 2, false);
            n = zzamf2.zzo();
            if (n >> 2 != 16382) {
                zznv2.zzl();
                throw zzaha.zzb((String)"First frame does not start with sync code.", null);
            }
            zznv2.zzl();
            this.zzk = n;
            object = this.zze;
            n = zzamq.zza;
            long l = zznv2.zzn();
            long l3 = zznv2.zzo();
            zznv2 = this.zzi;
            if (zznv2 == null) throw null;
            if (zznv2.zzk != null) {
                zznv2 = new zzof((zzoh)zznv2, l);
            } else if (l3 != -1L && zznv2.zzj > 0L) {
                zznv2 = new zzpi((zzoh)zznv2, this.zzk, l, l3);
                this.zzl = zznv2;
                zznv2 = zznv2.zza();
            } else {
                zznv2 = new zzos(zznv2.zza(), 0L);
            }
            object.zzD((zzot)zznv2);
            this.zzg = 5;
            return 0;
        }
        object = new zzod(this.zzi);
        do {
            zznv2.zzl();
            zzame zzame2 = new zzame(new byte[4], 4);
            Object object3 = zzame2.zza;
            object2 = (zznp)zznv2;
            object2.zzh(object3, 0, 4, false);
            bl = zzame2.zzg();
            n = zzame2.zzh(7);
            n2 = zzame2.zzh(24) + 4;
            if (n == 0) {
                object3 = new byte[38];
                object2.zza(object3, 0, 38, false);
                object.zza = new zzoh(object3, 4);
            } else {
                object3 = object.zza;
                if (object3 == null) throw new IllegalArgumentException();
                if (n == 3) {
                    zzame2 = new zzamf(n2);
                    object2.zza(zzame2.zzi(), 0, n2, false);
                    object.zza = object3.zze(zzoe.zzb((zzamf)zzame2));
                } else if (n == 4) {
                    zzame2 = new zzamf(n2);
                    object2.zza(zzame2.zzi(), 0, n2, false);
                    zzame2.zzk(4);
                    object.zza = object3.zzf(Arrays.asList(zzpc.zzb((zzamf)zzame2, (boolean)false, (boolean)false).zzb));
                } else if (n == 6) {
                    zzame2 = new zzamf(n2);
                    object2.zza(zzame2.zzi(), 0, n2, false);
                    zzame2.zzk(4);
                    n2 = zzame2.zzv();
                    object2 = zzame2.zzE(zzame2.zzv(), zzfll.zza);
                    String string = zzame2.zzE(zzame2.zzv(), zzfll.zzc);
                    int n5 = zzame2.zzv();
                    int n6 = zzame2.zzv();
                    int n7 = zzame2.zzv();
                    int n8 = zzame2.zzv();
                    n = zzame2.zzv();
                    byte[] byArray = new byte[n];
                    zzame2.zzm(byArray, 0, n);
                    object.zza = object3.zzg(Collections.singletonList(new zzajc(n2, (String)object2, string, n5, n6, n7, n8, byArray)));
                } else {
                    object2.zzd(n2, false);
                }
            }
            object2 = object.zza;
            n = zzamq.zza;
            this.zzi = object2;
        } while (!bl);
        if (object2 == null) throw null;
        this.zzj = Math.max(object2.zzc, 6);
        this.zzf.zzs(this.zzi.zzc(this.zzb, this.zzh));
        this.zzg = 4;
        return 0;
    }

    public final void zzd(long l, long l2) {
        long l3 = 0L;
        if (l == 0L) {
            this.zzg = 0;
        } else {
            zzpi zzpi2 = this.zzl;
            if (zzpi2 != null) {
                zzpi2.zzb(l2);
            }
        }
        l = l2 == 0L ? l3 : -1L;
        this.zzn = l;
        this.zzm = 0;
        this.zzc.zza(0);
    }
}
