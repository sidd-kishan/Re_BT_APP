/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.util.SparseArray
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzann
 *  com.google.android.gms.internal.ads.zzanx
 *  com.google.android.gms.internal.ads.zzapg
 *  com.google.android.gms.internal.ads.zzapo
 *  com.google.android.gms.internal.ads.zzapp
 *  com.google.android.gms.internal.ads.zzapv
 *  com.google.android.gms.internal.ads.zzapx
 *  com.google.android.gms.internal.ads.zzase
 *  com.google.android.gms.internal.ads.zzasf
 *  com.google.android.gms.internal.ads.zzasg
 *  com.google.android.gms.internal.ads.zzasi
 *  com.google.android.gms.internal.ads.zzasj
 *  com.google.android.gms.internal.ads.zzask
 *  com.google.android.gms.internal.ads.zzasm
 *  com.google.android.gms.internal.ads.zzaso
 *  com.google.android.gms.internal.ads.zzasp
 *  com.google.android.gms.internal.ads.zzasq
 *  com.google.android.gms.internal.ads.zzasz
 *  com.google.android.gms.internal.ads.zzata
 *  com.google.android.gms.internal.ads.zzatb
 *  com.google.android.gms.internal.ads.zzate
 *  com.google.android.gms.internal.ads.zzatf
 *  com.google.android.gms.internal.ads.zzatg
 *  com.google.android.gms.internal.ads.zzatk
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzauc
 *  com.google.android.gms.internal.ads.zzauj
 *  com.google.android.gms.internal.ads.zzaul
 *  com.google.android.gms.internal.ads.zzaun
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzaur
 *  com.google.android.gms.internal.ads.zzauu
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzann;
import com.google.android.gms.internal.ads.zzanx;
import com.google.android.gms.internal.ads.zzapg;
import com.google.android.gms.internal.ads.zzapo;
import com.google.android.gms.internal.ads.zzapp;
import com.google.android.gms.internal.ads.zzapv;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzase;
import com.google.android.gms.internal.ads.zzasf;
import com.google.android.gms.internal.ads.zzasg;
import com.google.android.gms.internal.ads.zzasi;
import com.google.android.gms.internal.ads.zzasj;
import com.google.android.gms.internal.ads.zzask;
import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzaso;
import com.google.android.gms.internal.ads.zzasp;
import com.google.android.gms.internal.ads.zzasq;
import com.google.android.gms.internal.ads.zzasz;
import com.google.android.gms.internal.ads.zzata;
import com.google.android.gms.internal.ads.zzatb;
import com.google.android.gms.internal.ads.zzate;
import com.google.android.gms.internal.ads.zzatf;
import com.google.android.gms.internal.ads.zzatg;
import com.google.android.gms.internal.ads.zzatk;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzauc;
import com.google.android.gms.internal.ads.zzauj;
import com.google.android.gms.internal.ads.zzaul;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzaur;
import com.google.android.gms.internal.ads.zzauu;
import java.io.IOException;

final class zzasl
implements zzasp,
zzapp,
zzauj,
zzasz {
    private long zzA;
    private long zzB;
    private long zzC;
    private int zzD;
    private boolean zzE;
    private boolean zzF;
    private final zzauc zzG;
    private final Uri zza;
    private final zzatz zzb;
    private final int zzc;
    private final Handler zzd;
    private final zzasm zze;
    private final zzasq zzf;
    private final long zzg;
    private final zzaun zzh;
    private final zzasj zzi;
    private final zzaur zzj;
    private final Runnable zzk;
    private final Runnable zzl;
    private final Handler zzm;
    private final SparseArray<zzata> zzn;
    private zzaso zzo;
    private zzapv zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private int zzu;
    private zzatg zzv;
    private long zzw;
    private boolean[] zzx;
    private boolean[] zzy;
    private boolean zzz;

    public zzasl(Uri uri, zzatz zzatz2, zzapo[] zzapoArray, int n, Handler handler, zzasm zzasm2, zzasq zzasq2, zzauc zzauc2, String string, int n2, byte[] byArray) {
        this.zza = uri;
        this.zzb = zzatz2;
        this.zzc = n;
        this.zzd = handler;
        this.zze = zzasm2;
        this.zzf = zzasq2;
        this.zzG = zzauc2;
        this.zzg = n2;
        this.zzh = new zzaun("Loader:ExtractorMediaPeriod");
        this.zzi = new zzasj(zzapoArray, (zzapp)this);
        this.zzj = new zzaur();
        this.zzk = new zzase(this);
        this.zzl = new zzasf(this);
        this.zzm = new Handler();
        this.zzC = -9223372036854775807L;
        this.zzn = new SparseArray();
        this.zzA = -1L;
    }

    private final void zzC(zzasi zzasi2) {
        if (this.zzA != -1L) return;
        this.zzA = zzasi.zza((zzasi)zzasi2);
    }

    private final void zzD() {
        int n;
        zzasi zzasi2 = new zzasi(this, this.zza, this.zzb, this.zzi, this.zzj);
        if (this.zzr) {
            zzaup.zzd((boolean)this.zzG());
            long l = this.zzw;
            if (l != -9223372036854775807L && this.zzC >= l) {
                this.zzE = true;
                this.zzC = -9223372036854775807L;
                return;
            }
            zzasi2.zzb(this.zzp.zzc(this.zzC), this.zzC);
            this.zzC = -9223372036854775807L;
        }
        this.zzD = this.zzE();
        int n2 = n = this.zzc;
        if (n == -1) {
            zzapv zzapv2;
            n2 = this.zzr && this.zzA == -1L && ((zzapv2 = this.zzp) == null || zzapv2.zzb() == -9223372036854775807L) ? 6 : 3;
        }
        this.zzh.zze((zzaul)zzasi2, (zzauj)this, n2);
    }

    private final int zzE() {
        int n = this.zzn.size();
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            n3 += ((zzata)this.zzn.valueAt(n2)).zzf();
            ++n2;
        }
        return n3;
    }

    private final long zzF() {
        int n = this.zzn.size();
        long l = Long.MIN_VALUE;
        int n2 = 0;
        while (n2 < n) {
            l = Math.max(l, ((zzata)this.zzn.valueAt(n2)).zzj());
            ++n2;
        }
        return l;
    }

    private final boolean zzG() {
        if (this.zzC == -9223372036854775807L) return false;
        return true;
    }

    static /* synthetic */ zzasm zzd(zzasl zzasl2) {
        return zzasl2.zze;
    }

    static /* synthetic */ long zze(zzasl zzasl2) {
        return zzasl2.zzg;
    }

    static /* synthetic */ Runnable zzf(zzasl zzasl2) {
        return zzasl2.zzl;
    }

    static /* synthetic */ Handler zzg(zzasl zzasl2) {
        return zzasl2.zzm;
    }

    static /* synthetic */ SparseArray zzh(zzasl zzasl2) {
        return zzasl2.zzn;
    }

    static /* synthetic */ zzaso zzi(zzasl zzasl2) {
        return zzasl2.zzo;
    }

    static /* synthetic */ boolean zzj(zzasl zzasl2) {
        return zzasl2.zzF;
    }

    static /* synthetic */ void zzx(zzasl zzasl2) {
        int n;
        if (zzasl2.zzF) return;
        if (zzasl2.zzr) return;
        if (zzasl2.zzp == null) return;
        if (!zzasl2.zzq) return;
        int n2 = zzasl2.zzn.size();
        for (n = 0; n < n2; ++n) {
            if (((zzata)zzasl2.zzn.valueAt(n)).zzi() == null) return;
        }
        zzasl2.zzj.zzb();
        zzatf[] zzatfArray = new zzatf[n2];
        zzasl2.zzy = new boolean[n2];
        zzasl2.zzx = new boolean[n2];
        zzasl2.zzw = zzasl2.zzp.zzb();
        n = 0;
        while (true) {
            boolean bl = true;
            if (n >= n2) break;
            Object object = ((zzata)zzasl2.zzn.valueAt(n)).zzi();
            zzatfArray[n] = new zzatf(new zzanm[]{object});
            object = object.zzf;
            boolean bl2 = bl;
            if (!zzauu.zzb((String)object)) {
                bl2 = zzauu.zza((String)object) ? bl : false;
            }
            zzasl2.zzy[n] = bl2;
            zzasl2.zzz = bl2 | zzasl2.zzz;
            ++n;
        }
        zzasl2.zzv = new zzatg(zzatfArray);
        zzasl2.zzr = true;
        zzasl2.zzf.zzi((zzanx)new zzate(zzasl2.zzw, zzasl2.zzp.zza()), null);
        zzasl2.zzo.zzj((zzasp)zzasl2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final long zzB(zzatk[] var1_1, boolean[] var2_2, zzatb[] var3_3, boolean[] var4_4, long var5_5) {
        block12: {
            block13: {
                block11: {
                    zzaup.zzd((boolean)this.zzr);
                    var10_6 = 0;
                    for (var7_7 = 0; var7_7 < var1_1.length; ++var7_7) {
                        var14_9 = var3_3[var7_7];
                        if (var14_9 == null || var1_1[var7_7] != null && var2_2 /* !! */ [var7_7]) continue;
                        var8_8 = zzask.zza((zzask)((zzask)var14_9));
                        zzaup.zzd((boolean)this.zzx[var8_8]);
                        --this.zzu;
                        this.zzx[var8_8] = false;
                        ((zzata)this.zzn.valueAt(var8_8)).zzg();
                        var3_3[var7_7] = null;
                    }
                    var7_7 = 0;
                    for (var8_8 = 0; var8_8 < var1_1.length; ++var8_8) {
                        var9_10 = var7_7;
                        if (var3_3[var8_8] == null) {
                            var2_2 /* !! */  = (boolean[])var1_1[var8_8];
                            var9_10 = var7_7;
                            if (var2_2 /* !! */  != null) {
                                var2_2 /* !! */ .zzb();
                                var11_11 = var2_2 /* !! */ .zzd(0) == 0;
                                zzaup.zzd((boolean)var11_11);
                                var7_7 = this.zzv.zzb(var2_2 /* !! */ .zza());
                                zzaup.zzd((boolean)(this.zzx[var7_7] ^ true));
                                ++this.zzu;
                                this.zzx[var7_7] = true;
                                var3_3[var8_8] = new zzask(this, var7_7);
                                var4_4[var8_8] = true;
                                var9_10 = 1;
                            }
                        }
                        var7_7 = var9_10;
                    }
                    if (!this.zzs) {
                        var9_10 = this.zzn.size();
                        for (var8_8 = 0; var8_8 < var9_10; ++var8_8) {
                            if (this.zzx[var8_8]) continue;
                            ((zzata)this.zzn.valueAt(var8_8)).zzg();
                        }
                    }
                    if (this.zzu != 0) break block11;
                    this.zzt = false;
                    var12_12 = var5_5;
                    if (this.zzh.zzf()) {
                        this.zzh.zzg();
                        var12_12 = var5_5;
                    }
                    break block12;
                }
                if (!this.zzs) break block13;
                var12_12 = var5_5;
                if (var7_7 == 0) break block12;
                ** GOTO lbl-1000
            }
            if (var5_5 == 0L) {
                var12_12 = var5_5;
            } else lbl-1000:
            // 2 sources

            {
                var5_5 = this.zzr(var5_5);
                var7_7 = var10_6;
                while (true) {
                    var12_12 = var5_5;
                    if (var7_7 >= var3_3.length) break;
                    if (var3_3[var7_7] != null) {
                        var4_4[var7_7] = true;
                    }
                    ++var7_7;
                }
            }
        }
        this.zzs = true;
        return var12_12;
    }

    public final long zza() {
        if (this.zzu != 0) return this.zzq();
        return Long.MIN_VALUE;
    }

    public final boolean zzb(long l) {
        if (this.zzE) return false;
        if (this.zzr) {
            if (this.zzu == 0) return false;
        }
        boolean bl = this.zzj.zza();
        if (this.zzh.zzf()) return bl;
        this.zzD();
        bl = true;
        return bl;
    }

    public final zzapx zzbf(int n, int n2) {
        zzata zzata2;
        zzata zzata3 = zzata2 = (zzata)this.zzn.get(n);
        if (zzata2 != null) return zzata3;
        zzata3 = new zzata(this.zzG, null);
        zzata3.zzn((zzasz)this);
        this.zzn.put(n, (Object)zzata3);
        return zzata3;
    }

    public final void zzbg() {
        this.zzq = true;
        this.zzm.post(this.zzk);
    }

    public final void zzc(zzapv zzapv2) {
        this.zzp = zzapv2;
        this.zzm.post(this.zzk);
    }

    public final void zzk() {
        zzasj zzasj2 = this.zzi;
        this.zzh.zzh((Runnable)new zzasg(this, zzasj2));
        this.zzm.removeCallbacksAndMessages(null);
        this.zzF = true;
    }

    public final void zzl(zzaso zzaso2, long l) {
        this.zzo = zzaso2;
        this.zzj.zza();
        this.zzD();
    }

    public final void zzm() throws IOException {
        this.zzh.zzi(Integer.MIN_VALUE);
    }

    public final zzatg zzn() {
        return this.zzv;
    }

    public final void zzo(long l) {
    }

    public final long zzp() {
        if (!this.zzt) return -9223372036854775807L;
        this.zzt = false;
        return this.zzB;
    }

    public final long zzq() {
        long l;
        if (this.zzE) {
            return Long.MIN_VALUE;
        }
        if (this.zzG()) {
            return this.zzC;
        }
        if (this.zzz) {
            int n = this.zzn.size();
            long l2 = Long.MAX_VALUE;
            int n2 = 0;
            while (true) {
                l = l2;
                if (n2 < n) {
                    l = l2;
                    if (this.zzy[n2]) {
                        l = Math.min(l2, ((zzata)this.zzn.valueAt(n2)).zzj());
                    }
                    ++n2;
                    l2 = l;
                    continue;
                }
                break;
            }
        } else {
            l = this.zzF();
        }
        if (l != Long.MIN_VALUE) return l;
        return this.zzB;
    }

    public final long zzr(long l) {
        block7: {
            if (!this.zzp.zza()) {
                l = 0L;
            }
            this.zzB = l;
            int n = this.zzn.size();
            boolean bl = true ^ this.zzG();
            int n2 = 0;
            while (bl) {
                if (n2 < n) {
                    if (this.zzx[n2]) {
                        bl = ((zzata)this.zzn.valueAt(n2)).zzl(l, false);
                    }
                    ++n2;
                    continue;
                }
                break block7;
            }
            this.zzC = l;
            this.zzE = false;
            if (this.zzh.zzf()) {
                this.zzh.zzg();
            } else {
                for (n2 = 0; n2 < n; ++n2) {
                    ((zzata)this.zzn.valueAt(n2)).zze(this.zzx[n2]);
                }
            }
        }
        this.zzt = false;
        return l;
    }

    final boolean zzs(int n) {
        boolean bl = this.zzE;
        boolean bl2 = false;
        if (!bl) {
            if (this.zzG()) return bl2;
            if (!((zzata)this.zzn.valueAt(n)).zzh()) return false;
        }
        bl2 = true;
        return bl2;
    }

    final void zzt() throws IOException {
        this.zzh.zzi(Integer.MIN_VALUE);
    }

    final int zzu(int n, zzann zzann2, zzapg zzapg2, boolean bl) {
        if (this.zzt) return -3;
        if (!this.zzG()) return ((zzata)this.zzn.valueAt(n)).zzm(zzann2, zzapg2, bl, this.zzE, this.zzB);
        return -3;
    }

    final void zzv(int n, long l) {
        zzata zzata2 = (zzata)this.zzn.valueAt(n);
        if (this.zzE && l > zzata2.zzj()) {
            zzata2.zzk();
            return;
        }
        zzata2.zzl(l, true);
    }

    public final void zzw(zzanm zzanm2) {
        this.zzm.post(this.zzk);
    }
}
