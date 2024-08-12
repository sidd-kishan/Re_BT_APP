/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzafw
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzalt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzey
 *  com.google.android.gms.internal.ads.zzfa
 *  com.google.android.gms.internal.ads.zzfe
 *  com.google.android.gms.internal.ads.zzff
 *  com.google.android.gms.internal.ads.zzfg
 *  com.google.android.gms.internal.ads.zzfi
 *  com.google.android.gms.internal.ads.zzin
 *  com.google.android.gms.internal.ads.zzio
 *  com.google.android.gms.internal.ads.zziq
 *  com.google.android.gms.internal.ads.zzir
 *  com.google.android.gms.internal.ads.zzis
 *  com.google.android.gms.internal.ads.zzja
 *  com.google.android.gms.internal.ads.zzko
 *  com.google.android.gms.internal.ads.zzn
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzow
 *  com.google.android.gms.internal.ads.zzox
 */
package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzafw;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzey;
import com.google.android.gms.internal.ads.zzfa;
import com.google.android.gms.internal.ads.zzfe;
import com.google.android.gms.internal.ads.zzff;
import com.google.android.gms.internal.ads.zzfg;
import com.google.android.gms.internal.ads.zzfi;
import com.google.android.gms.internal.ads.zzin;
import com.google.android.gms.internal.ads.zzio;
import com.google.android.gms.internal.ads.zziq;
import com.google.android.gms.internal.ads.zzir;
import com.google.android.gms.internal.ads.zzis;
import com.google.android.gms.internal.ads.zzja;
import com.google.android.gms.internal.ads.zzko;
import com.google.android.gms.internal.ads.zzn;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzow;
import com.google.android.gms.internal.ads.zzox;
import java.io.IOException;

public final class zzit
implements zzox {
    private zzafv zzA;
    private boolean zzB;
    private boolean zzC;
    private zzfg zzD;
    private final zzin zza;
    private final zziq zzb;
    private final zzja<zzir> zzc;
    private final zzff zzd;
    private final zzfa zze;
    private final Looper zzf;
    private zzis zzg;
    private zzafv zzh;
    private int zzi;
    private int[] zzj;
    private long[] zzk;
    private int[] zzl;
    private int[] zzm;
    private long[] zzn;
    private zzow[] zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private long zzt;
    private long zzu;
    private long zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private zzafv zzz;

    protected zzit(zzko zzko2, Looper looper, zzff zzff2, zzfa zzfa2, byte[] byArray) {
        this.zzf = looper;
        this.zzd = zzff2;
        this.zze = zzfa2;
        this.zza = new zzin(zzko2, null);
        this.zzb = new zziq();
        this.zzi = 1000;
        this.zzj = new int[1000];
        this.zzk = new long[1000];
        this.zzn = new long[1000];
        this.zzm = new int[1000];
        this.zzl = new int[1000];
        this.zzo = new zzow[1000];
        this.zzc = new zzja(zzio.zza);
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = Long.MIN_VALUE;
        this.zzy = true;
        this.zzx = true;
    }

    private final int zzA(zzafw zzafw2, zzaf zzaf2, boolean bl, boolean bl2, zziq zziq2) {
        synchronized (this) {
            zzaf2.zzc = false;
            if (!this.zzG()) {
                if (!bl2 && !this.zzw) {
                    zzaf2 = this.zzA;
                    if (zzaf2 == null) return -3;
                    if (!bl) {
                        if (zzaf2 == this.zzh) return -3;
                    }
                    this.zzH((zzafv)zzaf2, zzafw2);
                    return -5;
                }
                zzaf2.zzf(4);
                return -4;
            }
            zzafv zzafv2 = ((zzir)this.zzc.zza((int)(this.zzq + this.zzs))).zza;
            if (!bl && zzafv2 == this.zzh) {
                long l;
                int n = this.zzL(this.zzs);
                if (!this.zzI(n)) {
                    zzaf2.zzc = true;
                    return -3;
                }
                zzaf2.zzf(this.zzm[n]);
                zzaf2.zzd = l = this.zzn[n];
                if (l < this.zzt) {
                    zzaf2.zzg(Integer.MIN_VALUE);
                }
                zziq2.zza = this.zzl[n];
                zziq2.zzb = this.zzk[n];
                zziq2.zzc = this.zzo[n];
                return -4;
            }
            this.zzH(zzafv2, zzafw2);
            return -5;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final boolean zzB(zzafv zzafv2) {
        synchronized (this) {
            this.zzy = false;
            boolean bl = zzamq.zzc((Object)zzafv2, (Object)this.zzA);
            if (bl) {
                return false;
            }
            this.zzA = !this.zzc.zzf() && ((zzir)this.zzc.zzc()).zza.equals((Object)zzafv2) ? ((zzir)this.zzc.zzc()).zza : zzafv2;
            zzafv2 = this.zzA;
            this.zzB = zzalt.zzc((String)zzafv2.zzl, (String)zzafv2.zzi);
            this.zzC = false;
            return true;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final long zzC(long l, boolean bl, boolean bl2) {
        synchronized (this) {
            int n = this.zzp;
            if (n == 0) return -1L;
            long[] lArray = this.zzn;
            int n2 = this.zzr;
            if (l < lArray[n2]) {
                return -1L;
            }
            int n3 = n;
            if (bl2) {
                int n4 = this.zzs;
                n3 = n;
                if (n4 != n) {
                    n3 = n4 + 1;
                }
            }
            if ((n3 = this.zzJ(n2, n3, l, false)) != -1) return this.zzK(n3);
            return -1L;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    private final long zzD() {
        synchronized (this) {
            int n = this.zzp;
            if (n != 0) return this.zzK(n);
            return -1L;
        }
    }

    private final void zzE() {
        if (this.zzD == null) return;
        this.zzD = null;
        this.zzh = null;
    }

    private final void zzF(long l, int n, long l2, int n2, zzow object) {
        synchronized (this) {
            zzow[] zzowArray;
            Object object2;
            Object object3;
            boolean bl;
            int n3 = this.zzp;
            if (n3 > 0) {
                bl = this.zzk[n3 = this.zzL(n3 - 1)] + (long)this.zzl[n3] <= l2;
                zzakt.zza((boolean)bl);
            }
            bl = (0x20000000 & n) != 0;
            this.zzw = bl;
            this.zzv = Math.max(this.zzv, l);
            n3 = this.zzL(this.zzp);
            this.zzn[n3] = l;
            this.zzk[n3] = l2;
            this.zzl[n3] = n2;
            this.zzm[n3] = n;
            this.zzo[n3] = object;
            this.zzj[n3] = 0;
            if (this.zzc.zzf() || !((zzir)this.zzc.zzc()).zza.equals((Object)this.zzA)) {
                object = zzfe.zzb;
                object3 = this.zzc;
                n = this.zzq;
                n2 = this.zzp;
                object2 = this.zzA;
                if (object2 == null) throw null;
                zzowArray = new zzir(object2, (zzfe)object, null);
                object3.zzb(n + n2, (Object)zzowArray);
            }
            this.zzp = n = this.zzp + 1;
            n2 = this.zzi;
            if (n != n2) return;
            n = n2 + 1000;
            object2 = new int[n];
            long[] lArray = new long[n];
            long[] lArray2 = new long[n];
            object3 = new int[n];
            object = new int[n];
            zzowArray = new zzow[n];
            n3 = this.zzr;
            System.arraycopy(this.zzk, n3, lArray, 0, n2 -= n3);
            System.arraycopy(this.zzn, this.zzr, lArray2, 0, n2);
            System.arraycopy(this.zzm, this.zzr, object3, 0, n2);
            System.arraycopy(this.zzl, this.zzr, object, 0, n2);
            System.arraycopy(this.zzo, this.zzr, zzowArray, 0, n2);
            System.arraycopy(this.zzj, this.zzr, object2, 0, n2);
            n3 = this.zzr;
            System.arraycopy(this.zzk, 0, lArray, n2, n3);
            System.arraycopy(this.zzn, 0, lArray2, n2, n3);
            System.arraycopy(this.zzm, 0, object3, n2, n3);
            System.arraycopy(this.zzl, 0, object, n2, n3);
            System.arraycopy(this.zzo, 0, zzowArray, n2, n3);
            System.arraycopy(this.zzj, 0, object2, n2, n3);
            this.zzk = lArray;
            this.zzn = lArray2;
            this.zzm = (int[])object3;
            this.zzl = (int[])object;
            this.zzo = zzowArray;
            this.zzj = (int[])object2;
            this.zzr = 0;
            this.zzi = n;
            return;
        }
    }

    private final boolean zzG() {
        if (this.zzs == this.zzp) return false;
        return true;
    }

    private final void zzH(zzafv object, zzafw zzafw2) {
        zzafv zzafv2 = this.zzh;
        Object var4_4 = null;
        zzn zzn2 = zzafv2 == null ? null : zzafv2.zzo;
        this.zzh = object;
        zzn zzn3 = object.zzo;
        zzafw2.zza = object.zzb(this.zzd.zza(object));
        zzafw2.zzb = this.zzD;
        if (zzafv2 != null) {
            if (zzamq.zzc((Object)zzn2, (Object)zzn3)) return;
        }
        object = object.zzo == null ? var4_4 : new zzfg(new zzey((Throwable)new zzfi(1), 6001));
        this.zzD = object;
        zzafw2.zzb = object;
    }

    private final boolean zzI(int n) {
        zzfg zzfg2 = this.zzD;
        boolean bl = false;
        if (zzfg2 != null) {
            if ((this.zzm[n] & 0x40000000) == 0) return false;
        } else {
            bl = true;
        }
        return bl;
    }

    private final int zzJ(int n, int n2, long l, boolean bl) {
        int n3 = -1;
        int n4 = 0;
        int n5 = n;
        n = n4;
        while (true) {
            n4 = n3;
            if (n >= n2) return n4;
            long l2 = this.zzn[n5];
            n4 = n3;
            if (l2 > l) return n4;
            if (!bl || (this.zzm[n5] & 1) != 0) {
                if (l2 == l) {
                    n4 = n;
                    return n4;
                }
                n3 = n;
            }
            n5 = n4 = n5 + 1;
            if (n4 == this.zzi) {
                n5 = 0;
            }
            ++n;
        }
    }

    private final long zzK(int n) {
        int n2;
        int n3;
        int n4;
        long l;
        long l2 = this.zzu;
        long l3 = Long.MIN_VALUE;
        if (n == 0) {
            l = l3;
        } else {
            n4 = this.zzL(n - 1);
            n3 = 0;
            while (true) {
                l = l3;
                if (n3 >= n) break;
                l3 = Math.max(l3, this.zzn[n4]);
                if ((this.zzm[n4] & 1) != 0) {
                    l = l3;
                    break;
                }
                n4 = n2 = n4 - 1;
                if (n2 == -1) {
                    n4 = this.zzi - 1;
                }
                ++n3;
            }
        }
        this.zzu = Math.max(l2, l);
        this.zzp -= n;
        this.zzq = n4 = this.zzq + n;
        this.zzr = n3 = this.zzr + n;
        n2 = this.zzi;
        if (n3 >= n2) {
            this.zzr = n3 - n2;
        }
        this.zzs = n = this.zzs - n;
        if (n < 0) {
            this.zzs = 0;
        }
        this.zzc.zzd(n4);
        if (this.zzp != 0) return this.zzk[this.zzr];
        n = n4 = this.zzr;
        if (n4 != 0) return this.zzk[--n] + (long)this.zzl[n];
        n = this.zzi;
        return this.zzk[--n] + (long)this.zzl[n];
    }

    private final int zzL(int n) {
        int n2 = this.zzr + n;
        if (n2 >= (n = this.zzi)) return n2 - n;
        return n2;
    }

    static final /* synthetic */ void zzw(zzir zzir2) {
        zzir2 = zzir2.zzb;
    }

    private final void zzz() {
        synchronized (this) {
            this.zzs = 0;
            this.zza.zzb();
            return;
        }
    }

    public final void zza() {
        this.zzb(true);
        this.zzE();
    }

    public final void zzb(boolean bl) {
        this.zza.zza();
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzx = true;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = Long.MIN_VALUE;
        this.zzw = false;
        this.zzc.zze();
        if (!bl) return;
        this.zzz = null;
        this.zzA = null;
        this.zzy = true;
    }

    public final void zzc(long l) {
        this.zzt = l;
    }

    public final int zzd() {
        return this.zzq + this.zzp;
    }

    public final void zze() {
        this.zzq();
        this.zzE();
    }

    public final void zzf() throws IOException {
        zzfg zzfg2 = this.zzD;
        if (zzfg2 != null) throw zzfg2.zza();
    }

    public final int zzg() {
        return this.zzq + this.zzs;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final zzafv zzh() {
        synchronized (this) {
            boolean bl = this.zzy;
            if (!bl) return this.zzA;
            return null;
        }
    }

    public final long zzi() {
        synchronized (this) {
            long l = this.zzv;
            return l;
        }
    }

    public final boolean zzj() {
        synchronized (this) {
            boolean bl = this.zzw;
            return bl;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final boolean zzk(boolean bl) {
        synchronized (this) {
            boolean bl2 = this.zzG();
            boolean bl3 = true;
            if (!bl2) {
                bl2 = bl3;
                if (bl) return bl2;
                bl2 = bl3;
                if (this.zzw) return bl2;
                zzafv zzafv2 = this.zzA;
                if (zzafv2 == null) return false;
                zzafv zzafv3 = this.zzh;
                if (zzafv2 == zzafv3) return false;
                return bl3;
            }
            {
                zzafv zzafv4 = ((zzir)this.zzc.zza((int)(this.zzq + this.zzs))).zza;
                zzafv zzafv5 = this.zzh;
                if (zzafv4 == zzafv5) return this.zzI(this.zzL(this.zzs));
            }
            return true;
        }
    }

    public final int zzl(zzafw zzafw2, zzaf zzaf2, int n, boolean bl) {
        int n2;
        block2: {
            block5: {
                block3: {
                    block4: {
                        int n3;
                        boolean bl2 = (n & 2) != 0;
                        n2 = n3 = this.zzA(zzafw2, zzaf2, bl2, bl, this.zzb);
                        if (n3 != -4) return n2;
                        if (zzaf2.zzc()) break block2;
                        n2 = n & 1;
                        if ((n & 4) != 0) break block3;
                        if (n2 == 0) break block4;
                        this.zza.zzd(zzaf2, this.zzb);
                        break block2;
                    }
                    this.zza.zzc(zzaf2, this.zzb);
                    break block5;
                }
                if (n2 != 0) break block2;
            }
            ++this.zzs;
            return -4;
        }
        n2 = -4;
        return n2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zzm(long l, boolean bl) {
        synchronized (this) {
            this.zzz();
            int n = this.zzL(this.zzs);
            if (!this.zzG()) return false;
            if (l < this.zzn[n]) return false;
            if (l > this.zzv) {
                if (!bl) return false;
            }
            if ((n = this.zzJ(n, this.zzp - this.zzs, l, true)) == -1) {
                return false;
            }
            this.zzt = l;
            this.zzs += n;
            return true;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final int zzn(long l, boolean bl) {
        synchronized (this) {
            block5: {
                int n = this.zzL(this.zzs);
                if (!this.zzG()) return 0;
                if (l < this.zzn[n]) break block5;
                if (l > this.zzv && bl) {
                    n = this.zzp;
                    int n2 = this.zzs;
                    return n - n2;
                }
                {
                    n = this.zzJ(n, this.zzp - this.zzs, l, true);
                    // MONITOREXIT @DISABLED, blocks:[1, 2] lbl16 : MonitorExitStatement: MONITOREXIT : this
                    if (n != -1) return n;
                    return 0;
                }
            }
            return 0;
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void zzo(int var1_1) {
        synchronized (this) {
            var2_3 = var3_2 = false;
            if (var1_1 < 0) ** GOTO lbl8
            var2_3 = var3_2;
            try {
                if (this.zzs + var1_1 <= this.zzp) {
                    var2_3 = true;
                }
lbl8:
                // 4 sources

                zzakt.zza((boolean)var2_3);
                this.zzs += var1_1;
                return;
            }
            catch (Throwable var4_4) {}
            throw var4_4;
        }
    }

    public final void zzp(long l, boolean bl, boolean bl2) {
        this.zza.zze(this.zzC(l, false, bl2));
    }

    public final void zzq() {
        this.zza.zze(this.zzD());
    }

    public final void zzr(zzis zzis2) {
        this.zzg = zzis2;
    }

    public final void zzs(zzafv zzafv2) {
        this.zzz = zzafv2;
        boolean bl = this.zzB(zzafv2);
        zzis zzis2 = this.zzg;
        if (zzis2 == null) return;
        if (!bl) return;
        zzis2.zzF(zzafv2);
    }

    public final int zzt(zzah zzah2, int n, boolean bl, int n2) throws IOException {
        return this.zza.zzg(zzah2, n, bl);
    }

    public final void zzu(zzamf zzamf2, int n, int n2) {
        this.zza.zzh(zzamf2, n);
    }

    public final void zzv(long l, int n, int n2, int n3, zzow zzow2) {
        int n4 = n & 1;
        if (this.zzx) {
            if (n4 == 0) {
                return;
            }
            this.zzx = false;
        }
        int n5 = n;
        if (this.zzB) {
            if (l < this.zzt) {
                return;
            }
            n5 = n;
            if (n4 == 0) {
                if (!this.zzC) {
                    String string = String.valueOf(this.zzA);
                    String.valueOf(string).length();
                    Log.w((String)"SampleQueue", (String)"Overriding unexpected non-sync sample for format: ".concat(String.valueOf(string)));
                    this.zzC = true;
                }
                n5 = n | 1;
            }
        }
        this.zzF(l, n5, this.zza.zzf() - (long)n2 - (long)n3, n2, zzow2);
    }

    public final int zzx(zzah zzah2, int n, boolean bl) throws IOException {
        return zzov.zza((zzox)this, (zzah)zzah2, (int)n, (boolean)true);
    }

    public final void zzy(zzamf zzamf2, int n) {
        zzov.zzb((zzox)this, (zzamf)zzamf2, (int)n);
    }
}
