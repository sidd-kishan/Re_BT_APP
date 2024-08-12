/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzsr
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zztd
 *  com.google.android.gms.internal.ads.zztp
 *  com.google.android.gms.internal.ads.zztv
 *  com.google.android.gms.internal.ads.zztw
 *  com.google.android.gms.internal.ads.zztx
 *  com.google.android.gms.internal.ads.zzty
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzsr;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zztd;
import com.google.android.gms.internal.ads.zztp;
import com.google.android.gms.internal.ads.zztv;
import com.google.android.gms.internal.ads.zztw;
import com.google.android.gms.internal.ads.zztx;
import com.google.android.gms.internal.ads.zzty;
import com.google.android.gms.internal.ads.zzun;
import java.io.IOException;

public final class zztz
implements zznu {
    public static final zzoa zza = zztx.zza;
    private final zzamn zzb;
    private final SparseArray<zzty> zzc;
    private final zzamf zzd;
    private final zztw zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private long zzi;
    private zztv zzj;
    private zznx zzk;
    private boolean zzl;

    public zztz() {
        zzamn zzamn2 = new zzamn(0L);
        this.zzb = zzamn2;
        this.zzd = new zzamf(4096);
        this.zzc = new SparseArray();
        this.zze = new zztw();
    }

    public final boolean zza(zznv zznv2) throws IOException {
        byte[] byArray = new byte[14];
        zznv2 = (zznp)zznv2;
        zznv2.zzh(byArray, 0, 14, false);
        if (((byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF) != 442) {
            return false;
        }
        if ((byArray[4] & 0xC4) != 68) {
            return false;
        }
        if ((byArray[6] & 4) != 4) {
            return false;
        }
        if ((byArray[8] & 4) != 4) {
            return false;
        }
        if ((byArray[9] & 1) != 1) {
            return false;
        }
        if ((byArray[12] & 3) != 3) {
            return false;
        }
        zznv2.zzj(byArray[13] & 7, false);
        zznv2.zzh(byArray, 0, 3, false);
        if (((byArray[0] & 0xFF) << 16 | (byArray[1] & 0xFF) << 8 | byArray[2] & 0xFF) != 1) return false;
        return true;
    }

    public final void zzb(zznx zznx2) {
        this.zzk = zznx2;
    }

    public final int zzc(zznv zznv2, zzoq object) throws IOException {
        zztv zztv2;
        int n;
        block20: {
            long l;
            long l2;
            block21: {
                zztv zztv3;
                block25: {
                    block23: {
                        block24: {
                            block22: {
                                zzakt.zze((Object)this.zzk);
                                l2 = zznv2.zzo();
                                if (l2 != -1L) {
                                    if (!this.zze.zza()) return this.zze.zzc(zznv2, object);
                                }
                                if (!this.zzl) {
                                    this.zzl = true;
                                    if (this.zze.zzd() != -9223372036854775807L) {
                                        this.zzj = zztv3 = new zztv(this.zze.zzb(), this.zze.zzd(), l2);
                                        this.zzk.zzD(zztv3.zza());
                                    } else {
                                        this.zzk.zzD((zzot)new zzos(this.zze.zzd(), 0L));
                                    }
                                }
                                if ((zztv3 = this.zzj) != null) {
                                    if (zztv3.zzc()) return this.zzj.zzd(zznv2, object);
                                }
                                zznv2.zzl();
                                l2 = l2 != -1L ? (l2 -= zznv2.zzm()) : -1L;
                                if (l2 != -1L) {
                                    if (l2 < 4L) return -1;
                                }
                                if (!zznv2.zzh(this.zzd.zzi(), 0, 4, true)) {
                                    return -1;
                                }
                                this.zzd.zzh(0);
                                n = this.zzd.zzv();
                                if (n == 441) {
                                    return -1;
                                }
                                if (n == 442) {
                                    object = this.zzd.zzi();
                                    zznv2 = (zznp)zznv2;
                                    zznv2.zzh((byte[])object, 0, 10, false);
                                    this.zzd.zzh(9);
                                    zznv2.zzd((this.zzd.zzn() & 7) + 14, false);
                                    return 0;
                                }
                                if (n == 443) {
                                    object = this.zzd.zzi();
                                    zznv2 = (zznp)zznv2;
                                    zznv2.zzh((byte[])object, 0, 2, false);
                                    this.zzd.zzh(0);
                                    zznv2.zzd(this.zzd.zzo() + 6, false);
                                    return 0;
                                }
                                if (n >> 8 != 1) {
                                    ((zznp)zznv2).zzd(1, false);
                                    return 0;
                                }
                                zztv2 = zztv3 = (zzty)this.zzc.get(n &= 0xFF);
                                if (this.zzf) break block20;
                                object = zztv3;
                                if (zztv3 != null) break block21;
                                zztv2 = null;
                                if (n != 189) break block22;
                                object = new zzsr(null);
                                this.zzg = true;
                                this.zzi = zznv2.zzn();
                                break block23;
                            }
                            if ((n & 0xE0) != 192) break block24;
                            object = new zztp(null);
                            this.zzg = true;
                            this.zzi = zznv2.zzn();
                            break block23;
                        }
                        if ((n & 0xF0) != 224) break block25;
                        object = new zztd(null);
                        this.zzh = true;
                        this.zzi = zznv2.zzn();
                    }
                    zztv2 = object;
                }
                object = zztv3;
                if (zztv2 != null) {
                    object = new zzun(Integer.MIN_VALUE, n, 256);
                    zztv2.zzb(this.zzk, (zzun)object);
                    object = new zzty((zztb)zztv2, this.zzb);
                    this.zzc.put(n, object);
                }
            }
            boolean bl = this.zzg;
            l2 = l = 0x100000L;
            if (bl) {
                l2 = l;
                if (this.zzh) {
                    l2 = this.zzi + 8192L;
                }
            }
            zztv2 = object;
            if (zznv2.zzn() > l2) {
                this.zzf = true;
                this.zzk.zzC();
                zztv2 = object;
            }
        }
        object = this.zzd.zzi();
        zznv2 = (zznp)zznv2;
        zznv2.zzh((byte[])object, 0, 2, false);
        this.zzd.zzh(0);
        n = this.zzd.zzo() + 6;
        if (zztv2 == null) {
            zznv2.zzd(n, false);
        } else {
            this.zzd.zza(n);
            zznv2.zza(this.zzd.zzi(), 0, n, false);
            this.zzd.zzh(6);
            zztv2.zzb(this.zzd);
            zznv2 = this.zzd;
            zznv2.zzf(zznv2.zzj());
        }
        return 0;
    }

    public final void zzd(long l, long l2) {
        int n;
        if (this.zzb.zzc() == -9223372036854775807L || (l = this.zzb.zza()) != -9223372036854775807L && l != 0L && l != l2) {
            this.zzb.zzd(l2);
        }
        zztv zztv2 = this.zzj;
        int n2 = n = 0;
        if (zztv2 != null) {
            zztv2.zzb(l2);
            n2 = n;
        }
        while (n2 < this.zzc.size()) {
            ((zzty)this.zzc.valueAt(n2)).zza();
            ++n2;
        }
    }
}
