/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzann
 *  com.google.android.gms.internal.ads.zzape
 *  com.google.android.gms.internal.ads.zzapg
 *  com.google.android.gms.internal.ads.zzapn
 *  com.google.android.gms.internal.ads.zzapw
 *  com.google.android.gms.internal.ads.zzapx
 *  com.google.android.gms.internal.ads.zzasw
 *  com.google.android.gms.internal.ads.zzasx
 *  com.google.android.gms.internal.ads.zzasy
 *  com.google.android.gms.internal.ads.zzasz
 *  com.google.android.gms.internal.ads.zzatw
 *  com.google.android.gms.internal.ads.zzauc
 *  com.google.android.gms.internal.ads.zzaux
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzann;
import com.google.android.gms.internal.ads.zzape;
import com.google.android.gms.internal.ads.zzapg;
import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzasw;
import com.google.android.gms.internal.ads.zzasx;
import com.google.android.gms.internal.ads.zzasy;
import com.google.android.gms.internal.ads.zzasz;
import com.google.android.gms.internal.ads.zzatw;
import com.google.android.gms.internal.ads.zzauc;
import com.google.android.gms.internal.ads.zzaux;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzata
implements zzapx {
    private final zzasx zza;
    private final zzasw zzb;
    private final zzaux zzc;
    private final AtomicInteger zzd;
    private zzasy zze;
    private zzasy zzf;
    private zzanm zzg;
    private zzanm zzh;
    private long zzi;
    private int zzj;
    private zzasz zzk;
    private final zzauc zzl;

    public zzata(zzauc zzauc2, byte[] byArray) {
        this.zzl = zzauc2;
        this.zza = new zzasx();
        this.zzb = new zzasw();
        this.zzc = new zzaux(32);
        this.zzd = new AtomicInteger();
        this.zzj = 65536;
        zzauc2 = new zzasy(0L, 65536);
        this.zze = zzauc2;
        this.zzf = zzauc2;
    }

    private final void zzo(long l, byte[] byArray, int n) {
        this.zzp(l);
        int n2 = 0;
        while (n2 < n) {
            int n3 = (int)(l - this.zze.zza);
            int n4 = Math.min(n - n2, 65536 - n3);
            zzatw zzatw2 = this.zze.zzd;
            System.arraycopy(zzatw2.zza, n3, byArray, n2, n4);
            long l2 = l + (long)n4;
            n2 = n3 = n2 + n4;
            l = l2;
            if (l2 != this.zze.zzb) continue;
            this.zzl.zzd(zzatw2);
            zzatw2 = this.zze;
            zzatw2.zzd = null;
            this.zze = zzatw2.zze;
            n2 = n3;
            l = l2;
        }
    }

    private final void zzp(long l) {
        while (true) {
            zzasy zzasy2 = this.zze;
            if (l < zzasy2.zzb) return;
            this.zzl.zzd(zzasy2.zzd);
            zzasy2 = this.zze;
            zzasy2.zzd = null;
            this.zze = zzasy2.zze;
        }
    }

    private final boolean zzq() {
        return this.zzd.compareAndSet(0, 1);
    }

    private final void zzr() {
        if (this.zzd.compareAndSet(1, 0)) return;
        this.zzs();
    }

    private final void zzs() {
        this.zza.zza();
        zzasy zzasy2 = this.zze;
        if (zzasy2.zzc) {
            zzatw[] zzatwArray = this.zzf;
            int n = zzatwArray.zzc + (int)(zzatwArray.zza - zzasy2.zza) / 65536;
            zzatwArray = new zzatw[n];
            for (int i = 0; i < n; ++i) {
                zzatwArray[i] = zzasy2.zzd;
                zzasy2.zzd = null;
                zzasy2 = zzasy2.zze;
            }
            this.zzl.zze(zzatwArray);
        }
        this.zze = zzasy2 = new zzasy(0L, 65536);
        this.zzf = zzasy2;
        this.zzi = 0L;
        this.zzj = 65536;
        this.zzl.zzf();
    }

    private final int zzt(int n) {
        if (this.zzj != 65536) return Math.min(n, 65536 - this.zzj);
        this.zzj = 0;
        zzasy zzasy2 = this.zzf;
        if (zzasy2.zzc) {
            this.zzf = zzasy2.zze;
        }
        zzasy2 = this.zzf;
        zzatw zzatw2 = this.zzl.zzc();
        zzasy zzasy3 = new zzasy(this.zzf.zzb, 65536);
        zzasy2.zzd = zzatw2;
        zzasy2.zze = zzasy3;
        zzasy2.zzc = true;
        return Math.min(n, 65536 - this.zzj);
    }

    public final void zza(zzanm zzanm2) {
        zzanm zzanm3 = zzanm2 == null ? null : zzanm2;
        boolean bl = this.zza.zzj(zzanm3);
        this.zzh = zzanm2;
        zzanm2 = this.zzk;
        if (zzanm2 == null) return;
        if (!bl) return;
        zzanm2.zzw(zzanm3);
    }

    public final void zzb(zzaux zzaux2, int n) {
        if (!this.zzq()) {
            zzaux2.zzj(n);
            return;
        }
        while (true) {
            if (n <= 0) {
                this.zzr();
                return;
            }
            int n2 = this.zzt(n);
            zzaux2.zzk(this.zzf.zzd.zza, this.zzj, n2);
            this.zzj += n2;
            this.zzi += (long)n2;
            n -= n2;
        }
    }

    public final void zzc(long l, int n, int n2, int n3, zzapw zzapw2) {
        if (!this.zzq()) {
            this.zza.zzl(l);
            return;
        }
        try {
            long l2 = this.zzi;
            long l3 = n2;
            this.zza.zzk(l, n, l2 - l3, n2, zzapw2);
            return;
        }
        finally {
            this.zzr();
        }
    }

    public final int zzd(zzapn object, int n, boolean bl) throws IOException, InterruptedException {
        if (!this.zzq()) {
            if ((n = object.zzc(n)) == -1) throw new EOFException();
            return n;
        }
        try {
            n = this.zzt(n);
            n = object.zza(this.zzf.zzd.zza, this.zzj, n);
            if (n != -1) {
                this.zzj += n;
                this.zzi += (long)n;
                return n;
            }
            object = new EOFException();
            throw object;
        }
        finally {
            this.zzr();
        }
    }

    public final void zze(boolean bl) {
        AtomicInteger atomicInteger = this.zzd;
        int n = true != bl ? 2 : 0;
        n = atomicInteger.getAndSet(n);
        this.zzs();
        this.zza.zzb();
        if (n != 2) return;
        this.zzg = null;
    }

    public final int zzf() {
        return this.zza.zzc();
    }

    public final void zzg() {
        if (this.zzd.getAndSet(2) != 0) return;
        this.zzs();
    }

    public final boolean zzh() {
        return this.zza.zzd();
    }

    public final zzanm zzi() {
        return this.zza.zze();
    }

    public final long zzj() {
        return this.zza.zzf();
    }

    public final void zzk() {
        long l = this.zza.zzh();
        if (l == -1L) return;
        this.zzp(l);
    }

    public final boolean zzl(long l, boolean bl) {
        if ((l = this.zza.zzi(l, bl)) == -1L) {
            return false;
        }
        this.zzp(l);
        return true;
    }

    public final int zzm(zzann object, zzapg zzapg2, boolean bl, boolean bl2, long l) {
        long l2;
        Object object2;
        int n;
        Object object3;
        Object object4;
        block20: {
            Object object5;
            zzasw zzasw2;
            block24: {
                block23: {
                    block22: {
                        block21: {
                            object4 = this.zza.zzg(object, zzapg2, bl, bl2, this.zzg, this.zzb);
                            if (object4 == -5) {
                                this.zzg = object.zza;
                                return -5;
                            }
                            if (object4 != -4) {
                                return -3;
                            }
                            if (zzapg2.zzc()) return -4;
                            if (zzapg2.zzc < l) {
                                zzapg2.zzf(Integer.MIN_VALUE);
                            }
                            if (!zzapg2.zzi()) break block20;
                            zzasw2 = this.zzb;
                            l = zzasw2.zzb;
                            this.zzc.zza(1);
                            this.zzo(l, this.zzc.zza, 1);
                            ++l;
                            object = this.zzc.zza;
                            object3 = 0;
                            object4 = object[0];
                            n = object4 & 0x80;
                            object4 &= 0x7F;
                            object = zzapg2.zza;
                            if (object.zza == null) {
                                object.zza = new byte[16];
                            }
                            this.zzo(l, object.zza, (int)object4);
                            l += (long)object4;
                            if (n != 0) {
                                this.zzc.zza(2);
                                this.zzo(l, this.zzc.zza, 2);
                                l += 2L;
                                object4 = this.zzc.zzm();
                            } else {
                                object4 = 1;
                            }
                            object5 = zzapg2.zza;
                            object2 = object5.zzd;
                            if (object2 == null) break block21;
                            object = object2;
                            if (((zzasw)object2).length >= object4) break block22;
                        }
                        object = new int[object4];
                    }
                    if ((object5 = (Object)object5.zze) == null) break block23;
                    object2 = object5;
                    if (((zzape)object5).length >= object4) break block24;
                }
                object2 = new int[object4];
            }
            if (n != 0) {
                n = object4 * 6;
                this.zzc.zza(n);
                this.zzo(l, this.zzc.zza, n);
                l2 = l + (long)n;
                this.zzc.zzi(0);
                while (true) {
                    l = l2;
                    if (object3 < object4) {
                        object[object3] = (zzann)this.zzc.zzm();
                        object2[object3] = (zzasw)this.zzc.zzu();
                        ++object3;
                        continue;
                    }
                    break;
                }
            } else {
                object[0] = (zzann)false;
                object2[0] = (zzasw)(zzasw2.zza - (int)(l - zzasw2.zzb));
            }
            zzapw zzapw2 = zzasw2.zzd;
            object5 = zzapg2.zza;
            byte[] byArray = zzapw2.zzb;
            byte[] byArray2 = object5.zza;
            object3 = zzapw2.zza;
            object5.zza(object4, (int[])object, (int[])object2, byArray, byArray2, 1);
            l2 = zzasw2.zzb;
            object4 = (int)(l - l2);
            zzasw2.zzb = l2 + (long)object4;
            zzasw2.zza -= object4;
        }
        zzapg2.zzh(this.zzb.zza);
        object2 = this.zzb;
        l = object2.zzb;
        object = zzapg2.zzb;
        object4 = object2.zza;
        this.zzp(l);
        while (true) {
            if (object4 <= 0) {
                this.zzp(this.zzb.zzc);
                return -4;
            }
            n = (int)(l - this.zze.zza);
            object3 = Math.min(object4, 65536 - n);
            zzapg2 = this.zze.zzd;
            object.put(zzapg2.zza, n, (int)object3);
            l2 = l + (long)object3;
            object4 = object3 = object4 - object3;
            l = l2;
            if (l2 != this.zze.zzb) continue;
            this.zzl.zzd((zzatw)zzapg2);
            zzapg2 = this.zze;
            zzapg2.zzd = null;
            this.zze = zzapg2.zze;
            object4 = object3;
            l = l2;
        }
    }

    public final void zzn(zzasz zzasz2) {
        this.zzk = zzasz2;
    }
}
