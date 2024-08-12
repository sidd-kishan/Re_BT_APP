/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzakn
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzpt
 *  com.google.android.gms.internal.ads.zzpv
 *  com.google.android.gms.internal.ads.zzpx
 *  com.google.android.gms.internal.ads.zzpy
 *  com.google.android.gms.internal.ads.zzrp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzakn;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzpt;
import com.google.android.gms.internal.ads.zzpv;
import com.google.android.gms.internal.ads.zzpx;
import com.google.android.gms.internal.ads.zzpy;
import com.google.android.gms.internal.ads.zzrp;
import java.io.IOException;

public final class zzps
implements zznu {
    private final zzamf zza = new zzamf(6);
    private zznx zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private long zzf = -1L;
    private zzakn zzg;
    private zznv zzh;
    private zzpv zzi;
    private zzrp zzj;

    private final int zze(zznv zznv2) throws IOException {
        this.zza.zza(2);
        byte[] byArray = this.zza.zzi();
        ((zznp)zznv2).zzh(byArray, 0, 2, false);
        return this.zza.zzo();
    }

    private final void zzf() {
        this.zzg(new zzaiu[0]);
        zznx zznx2 = this.zzb;
        if (zznx2 == null) throw null;
        zznx2.zzC();
        this.zzb.zzD((zzot)new zzos(-9223372036854775807L, 0L));
        this.zzc = 6;
    }

    private final void zzg(zzaiu ... zzaiuArray) {
        zznx zznx2 = this.zzb;
        if (zznx2 == null) throw null;
        zzox zzox2 = zznx2.zzB(1024, 4);
        zznx2 = new zzaft();
        zznx2.zzM("image/jpeg");
        zznx2.zzL(new zzaiv(zzaiuArray));
        zzox2.zzs(zznx2.zzah());
    }

    public final boolean zza(zznv zznv2) throws IOException {
        int n;
        if (this.zze(zznv2) != 65496) {
            return false;
        }
        this.zzd = n = this.zze(zznv2);
        int n2 = n;
        if (n == 65504) {
            this.zza.zza(2);
            byte[] byArray = this.zza.zzi();
            zznp zznp2 = (zznp)zznv2;
            zznp2.zzh(byArray, 0, 2, false);
            zznp2.zzj(this.zza.zzo() - 2, false);
            this.zzd = n2 = this.zze(zznv2);
        }
        if (n2 != 65505) return false;
        zznv2 = (zznp)zznv2;
        zznv2.zzj(2, false);
        this.zza.zza(6);
        zznv2.zzh(this.zza.zzi(), 0, 6, false);
        if (this.zza.zzt() != 1165519206L) return false;
        if (this.zza.zzo() != 0) return false;
        return true;
    }

    public final void zzb(zznx zznx2) {
        this.zzb = zznx2;
    }

    public final int zzc(zznv object, zzoq object2) throws IOException {
        block26: {
            block28: {
                long l;
                long l2;
                long l3;
                long l4;
                long l5;
                long l6;
                int n;
                block31: {
                    block24: {
                        block25: {
                            block30: {
                                Object var22_4;
                                block29: {
                                    block27: {
                                        n = this.zzc;
                                        if (n == 0) break block24;
                                        if (n == 1) {
                                            this.zza.zza(2);
                                            object2 = this.zza.zzi();
                                            ((zznp)object).zza((byte[])object2, 0, 2, false);
                                            this.zze = this.zza.zzo() - 2;
                                            this.zzc = 2;
                                            return 0;
                                        }
                                        var22_4 = null;
                                        if (n != 2) {
                                            long l7;
                                            if (n != 4) {
                                                if (n != 5) {
                                                    if (n != 6) throw new IllegalStateException();
                                                    return -1;
                                                }
                                                if (this.zzi == null || object != this.zzh) {
                                                    this.zzh = object;
                                                    this.zzi = new zzpv(object, this.zzf);
                                                }
                                                if ((object = this.zzj) == null) throw null;
                                                n = object.zzc((zznv)this.zzi, object2);
                                                if (n != 1) return n;
                                                object2.zza += this.zzf;
                                                return n;
                                            }
                                            long l8 = object.zzn();
                                            if (l8 != (l7 = this.zzf)) {
                                                object2.zza = l7;
                                                return 1;
                                            }
                                            if (!object.zzh(this.zza.zzi(), 0, 1, true)) {
                                                this.zzf();
                                            } else {
                                                object.zzl();
                                                if (this.zzj == null) {
                                                    this.zzj = new zzrp(0);
                                                }
                                                object = new zzpv(object, this.zzf);
                                                this.zzi = object;
                                                if (this.zzj.zza(object)) {
                                                    object2 = this.zzj;
                                                    l8 = this.zzf;
                                                    object = this.zzb;
                                                    if (object == null) throw null;
                                                    object2.zzb((zznx)new zzpx(l8, (zznx)object));
                                                    object = this.zzg;
                                                    if (object == null) throw null;
                                                    this.zzg(new zzaiu[]{object});
                                                    this.zzc = 5;
                                                } else {
                                                    this.zzf();
                                                }
                                            }
                                            return 0;
                                        }
                                        if (this.zzd != 65505) break block25;
                                        zzamf zzamf2 = new zzamf(this.zze);
                                        object2 = zzamf2.zzi();
                                        n = this.zze;
                                        ((zznp)object).zza((byte[])object2, 0, n, false);
                                        if (this.zzg != null || !"http://ns.adobe.com/xap/1.0/".equals(zzamf2.zzG('\u0000')) || (object2 = zzamf2.zzG('\u0000')) == null) break block26;
                                        l6 = object.zzo();
                                        if (l6 != -1L) break block27;
                                        object = var22_4;
                                        break block28;
                                    }
                                    object = zzpy.zza((String)object2);
                                    if (object != null) break block29;
                                    object = var22_4;
                                    break block28;
                                }
                                if (object.zzb.size() >= 2) break block30;
                                object = var22_4;
                                break block28;
                            }
                            l5 = -1L;
                            l2 = l4 = (l3 = -1L);
                            n = 0;
                            l = l4;
                            l4 = l6;
                            break block31;
                        }
                        n = this.zze;
                        ((zznp)object).zzd(n, false);
                        break block26;
                    }
                    this.zza.zza(2);
                    object2 = this.zza.zzi();
                    ((zznp)object).zza((byte[])object2, 0, 2, false);
                    this.zzd = n = this.zza.zzo();
                    if (n == 65498) {
                        if (this.zzf != -1L) {
                            this.zzc = 4;
                        } else {
                            this.zzf();
                        }
                    } else {
                        if (n >= 65488) {
                            if (n <= 65497) return 0;
                        }
                        if (n == 65281) return 0;
                        this.zzc = 1;
                    }
                    return 0;
                }
                for (int i = object.zzb.size() - 1; i >= 0; --i) {
                    long l9;
                    object2 = (zzpt)object.zzb.get(i);
                    int n2 = n | "video/mp4".equals(object2.zza);
                    if (i == 0) {
                        l6 = l4 - object2.zzd;
                        l9 = 0L;
                    } else {
                        l9 = l4 - object2.zzc;
                        l6 = l4;
                    }
                    l4 = l9;
                    n = n2;
                    long l10 = l;
                    l9 = l2;
                    if (n2 != 0) {
                        n = n2;
                        l10 = l;
                        l9 = l2;
                        if (l4 != l6) {
                            l9 = l6 - l4;
                            l10 = l4;
                            n = 0;
                        }
                    }
                    if (i == 0) {
                        l3 = l6;
                    }
                    if (i == 0) {
                        l5 = l4;
                    }
                    l = l10;
                    l2 = l9;
                }
                object = l != -1L && l2 != -1L && l5 != -1L && l3 != -1L ? new zzakn(l5, l3, object.zza, l, l2) : null;
            }
            this.zzg = object;
            if (object != null) {
                this.zzf = object.zzd;
            }
        }
        this.zzc = 0;
        return 0;
    }

    public final void zzd(long l, long l2) {
        if (l == 0L) {
            this.zzc = 0;
            this.zzj = null;
            return;
        }
        if (this.zzc != 5) return;
        zzrp zzrp2 = this.zzj;
        if (zzrp2 == null) throw null;
        zzrp2.zzd(l, l2);
    }
}
