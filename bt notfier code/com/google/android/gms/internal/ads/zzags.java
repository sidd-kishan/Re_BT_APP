/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzagp
 *  com.google.android.gms.internal.ads.zzagq
 *  com.google.android.gms.internal.ads.zzagr
 *  com.google.android.gms.internal.ads.zzagz
 *  com.google.android.gms.internal.ads.zzahd
 *  com.google.android.gms.internal.ads.zzahw
 *  com.google.android.gms.internal.ads.zzain
 *  com.google.android.gms.internal.ads.zzaip
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzcy
 *  com.google.android.gms.internal.ads.zzfog
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzjz
 *  com.google.android.gms.internal.ads.zzka
 *  com.google.android.gms.internal.ads.zzko
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzagp;
import com.google.android.gms.internal.ads.zzagq;
import com.google.android.gms.internal.ads.zzagr;
import com.google.android.gms.internal.ads.zzagz;
import com.google.android.gms.internal.ads.zzahd;
import com.google.android.gms.internal.ads.zzahw;
import com.google.android.gms.internal.ads.zzain;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzcy;
import com.google.android.gms.internal.ads.zzfog;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzjz;
import com.google.android.gms.internal.ads.zzka;
import com.google.android.gms.internal.ads.zzko;
import java.util.List;

final class zzags {
    private final zzain zza;
    private final zzaip zzb;
    private final zzcy zzc;
    private final Handler zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzagp zzh;
    private zzagp zzi;
    private zzagp zzj;
    private int zzk;
    private Object zzl;
    private long zzm;

    public zzags(zzcy zzcy2, Handler handler) {
        this.zzc = zzcy2;
        this.zzd = handler;
        this.zza = new zzain();
        this.zzb = new zzaip();
    }

    private final boolean zzA(zzaiq zzaiq2, zzhf zzhf2, boolean bl) {
        int n = zzaiq2.zzi(zzhf2.zza);
        if (zzaiq2.zzf((int)zzaiq2.zzh((int)n, (zzain)this.zza, (boolean)false).zzc, (zzaip)this.zzb, (long)0L).zzh) return false;
        if (zzaiq2.zzu(n, this.zza, this.zzb, this.zzf, this.zzg) != -1) return false;
        if (!bl) return false;
        return true;
    }

    private final long zzB(zzaiq zzaiq2, Object object, int n) {
        zzaiq2.zzy(object, this.zza);
        this.zza.zzb(n);
        this.zza.zzk(n);
        return 0L;
    }

    private static final boolean zzC(zzhf zzhf2) {
        if (zzhf2.zzb()) return false;
        if (zzhf2.zze != -1) return false;
        return true;
    }

    private final void zzs() {
        Object object;
        zzfog zzfog2 = zzfoj.zzu();
        for (object = this.zzh; object != null; object = object.zzo()) {
            zzfog2.zze((Object)object.zzf.zza);
        }
        object = this.zzi;
        object = object == null ? null : object.zzf.zza;
        this.zzd.post((Runnable)new zzagr(this, zzfog2, (zzhf)object));
    }

    private static zzhf zzt(zzaiq zzaiq2, Object object, long l, long l2, zzain zzain2) {
        zzaiq2.zzy(object, zzain2);
        int n = zzain2.zze(l);
        if (n != -1) return new zzhf(object, n, zzain2.zzc(n), l2);
        return new zzhf(object, l2, zzain2.zzf(l));
    }

    private final boolean zzu(zzaiq zzaiq2) {
        zzagp zzagp2 = this.zzh;
        if (zzagp2 == null) {
            return true;
        }
        int n = zzaiq2.zzi(zzagp2.zzb);
        while (true) {
            n = zzaiq2.zzu(n, this.zza, this.zzb, this.zzf, this.zzg);
            while (zzagp2.zzo() != null && !zzagp2.zzf.zzg) {
                zzagp2 = zzagp2.zzo();
            }
            zzagp zzagp3 = zzagp2.zzo();
            if (n == -1 || zzagp3 == null || zzaiq2.zzi(zzagp3.zzb) != n) break;
            zzagp2 = zzagp3;
        }
        boolean bl = this.zzl(zzagp2);
        zzagp2.zzf = this.zzo(zzaiq2, zzagp2.zzf);
        if (bl) return false;
        return true;
    }

    private final zzagq zzv(zzaiq zzaiq2, zzagp zzagp2, long l) {
        long l2;
        zzagq zzagq2 = zzagp2.zzf;
        long l3 = zzagp2.zza() + zzagq2.zze - l;
        if (zzagq2.zzg) {
            long l4;
            int n = zzaiq2.zzi(zzagq2.zza.zza);
            Object object = this.zza;
            zzaip zzaip2 = this.zzb;
            int n2 = this.zzf;
            boolean bl = this.zzg;
            long l5 = 0L;
            if ((n = zzaiq2.zzu(n, object, zzaip2, n2, bl)) == -1) {
                return null;
            }
            n2 = zzaiq2.zzh((int)n, (zzain)this.zza, (boolean)true).zzc;
            object = this.zza.zzb;
            l = zzagq2.zza.zzd;
            if (zzaiq2.zzf((int)n2, (zzaip)this.zzb, (long)0L).zzn == n) {
                zzagq2 = zzaiq2.zzw(this.zzb, this.zza, n2, -9223372036854775807L, Math.max(0L, l3));
                if (zzagq2 == null) {
                    return null;
                }
                object = zzagq2.first;
                l4 = (Long)zzagq2.second;
                if ((zzagp2 = zzagp2.zzo()) != null && zzagp2.zzb.equals(object)) {
                    l = zzagp2.zzf.zza.zzd;
                } else {
                    l = this.zze;
                    this.zze = 1L + l;
                }
                l5 = -9223372036854775807L;
                zzagp2 = object;
            } else {
                l4 = 0L;
                zzagp2 = object;
            }
            return this.zzw(zzaiq2, zzags.zzt(zzaiq2, zzagp2, l4, l, this.zza), l5, l4);
        }
        zzagp2 = zzagq2.zza;
        zzaiq2.zzy(zzagp2.zza, this.zza);
        if (!zzagp2.zzb()) {
            int n = this.zza.zzc(zzagp2.zze);
            if (n != this.zza.zzg(zzagp2.zze)) return this.zzx(zzaiq2, zzagp2.zza, zzagp2.zze, n, zzagq2.zze, zzagp2.zzd);
            this.zzB(zzaiq2, zzagp2.zza, zzagp2.zze);
            return this.zzy(zzaiq2, zzagp2.zza, 0L, zzagq2.zze, zzagp2.zzd);
        }
        int n = zzagp2.zzb;
        if (this.zza.zzg(n) == -1) {
            return null;
        }
        int n3 = this.zza.zzd(n, zzagp2.zzc);
        if (n3 < 0) {
            return this.zzx(zzaiq2, zzagp2.zza, n, n3, zzagq2.zzc, zzagp2.zzd);
        }
        l = l2 = zzagq2.zzc;
        if (l2 == -9223372036854775807L) {
            zzaip zzaip3 = this.zzb;
            zzain zzain2 = this.zza;
            if ((zzaip3 = zzaiq2.zzw(zzaip3, zzain2, zzain2.zzc, -9223372036854775807L, Math.max(0L, l3))) == null) {
                return null;
            }
            l = (Long)zzaip3.second;
        }
        this.zzB(zzaiq2, zzagp2.zza, zzagp2.zzb);
        return this.zzy(zzaiq2, zzagp2.zza, Math.max(0L, l), zzagq2.zzc, zzagp2.zzd);
    }

    private final zzagq zzw(zzaiq zzaiq2, zzhf zzhf2, long l, long l2) {
        zzaiq2.zzy(zzhf2.zza, this.zza);
        if (!zzhf2.zzb()) return this.zzy(zzaiq2, zzhf2.zza, l2, l, zzhf2.zzd);
        return this.zzx(zzaiq2, zzhf2.zza, zzhf2.zzb, zzhf2.zzc, l, zzhf2.zzd);
    }

    private final zzagq zzx(zzaiq zzaiq2, Object object, int n, int n2, long l, long l2) {
        long l3;
        object = new zzhf(object, n, n2, l2);
        long l4 = zzaiq2.zzy(((zzhf)object).zza, this.zza).zzh(((zzhf)object).zzb, ((zzhf)object).zzc);
        if (n2 == this.zza.zzc(n)) {
            this.zza.zzi();
        }
        this.zza.zzj(((zzhf)object).zzb);
        l2 = l3 = 0L;
        if (l4 == -9223372036854775807L) return new zzagq((zzhf)object, l2, l, -9223372036854775807L, l4, false, false, false, false);
        l2 = l3;
        if (l4 > 0L) return new zzagq((zzhf)object, l2, l, -9223372036854775807L, l4, false, false, false, false);
        l2 = Math.max(0L, -1L + l4);
        return new zzagq((zzhf)object, l2, l, -9223372036854775807L, l4, false, false, false, false);
    }

    private final zzagq zzy(zzaiq zzaiq2, Object object, long l, long l2, long l3) {
        long l4 = l;
        zzaiq2.zzy(object, this.zza);
        int n = this.zza.zzf(l4);
        object = new zzhf(object, l3, n);
        boolean bl = zzags.zzC((zzhf)object);
        boolean bl2 = this.zzz(zzaiq2, (zzhf)object);
        boolean bl3 = this.zzA(zzaiq2, (zzhf)object, bl);
        if (n != -1) {
            this.zza.zzj(n);
        }
        if (n != -1) {
            this.zza.zzb(n);
            l = 0L;
        } else {
            l = -9223372036854775807L;
        }
        l3 = l != -9223372036854775807L ? l : this.zza.zzd;
        long l5 = l4;
        if (l3 == -9223372036854775807L) return new zzagq((zzhf)object, l5, l2, l, l3, false, bl, bl2, bl3);
        l5 = l4;
        if (l4 < l3) return new zzagq((zzhf)object, l5, l2, l, l3, false, bl, bl2, bl3);
        l5 = Math.max(0L, -1L + l3);
        return new zzagq((zzhf)object, l5, l2, l, l3, false, bl, bl2, bl3);
    }

    private final boolean zzz(zzaiq zzaiq2, zzhf zzhf2) {
        if (!zzags.zzC(zzhf2)) {
            return false;
        }
        int n = zzaiq2.zzy((Object)zzhf2.zza, (zzain)this.zza).zzc;
        int n2 = zzaiq2.zzi(zzhf2.zza);
        if (zzaiq2.zzf((int)n, (zzaip)this.zzb, (long)0L).zzo != n2) return false;
        return true;
    }

    public final boolean zza(zzaiq zzaiq2, int n) {
        this.zzf = n;
        return this.zzu(zzaiq2);
    }

    public final boolean zzb(zzaiq zzaiq2, boolean bl) {
        this.zzg = bl;
        return this.zzu(zzaiq2);
    }

    public final boolean zzc(zzhe zzhe2) {
        zzagp zzagp2 = this.zzj;
        if (zzagp2 == null) return false;
        if (zzagp2.zza != zzhe2) return false;
        return true;
    }

    public final void zzd(long l) {
        zzagp zzagp2 = this.zzj;
        if (zzagp2 == null) return;
        zzagp2.zzh(l);
    }

    public final boolean zze() {
        boolean bl;
        zzagp zzagp2 = this.zzj;
        boolean bl2 = bl = true;
        if (zzagp2 == null) return bl2;
        if (!zzagp2.zzf.zzi && zzagp2.zzd() && this.zzj.zzf.zze != -9223372036854775807L) {
            if (this.zzk >= 100) return false;
            bl2 = bl;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    public final zzagq zzf(long l, zzahd zzahd2) {
        zzagp zzagp2 = this.zzj;
        zzahd2 = zzagp2 == null ? this.zzw(zzahd2.zza, zzahd2.zzb, zzahd2.zzc, zzahd2.zzs) : this.zzv(zzahd2.zza, zzagp2, l);
        return zzahd2;
    }

    public final zzagp zzg() {
        return this.zzj;
    }

    public final zzagp zzh() {
        return this.zzh;
    }

    public final zzagp zzi() {
        return this.zzi;
    }

    public final zzagp zzj() {
        boolean bl;
        zzagp zzagp2 = this.zzi;
        boolean bl2 = bl = false;
        if (zzagp2 != null) {
            bl2 = bl;
            if (zzagp2.zzo() != null) {
                bl2 = true;
            }
        }
        zzakt.zzd((boolean)bl2);
        this.zzi = this.zzi.zzo();
        this.zzs();
        return this.zzi;
    }

    public final zzagp zzk() {
        int n;
        zzagp zzagp2 = this.zzh;
        if (zzagp2 == null) {
            return null;
        }
        if (zzagp2 == this.zzi) {
            this.zzi = zzagp2.zzo();
        }
        this.zzh.zzm();
        this.zzk = n = this.zzk - 1;
        if (n == 0) {
            this.zzj = null;
            zzagp2 = this.zzh;
            this.zzl = zzagp2.zzb;
            this.zzm = zzagp2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzo();
        this.zzs();
        return this.zzh;
    }

    public final boolean zzl(zzagp zzagp2) {
        boolean bl = false;
        boolean bl2 = zzagp2 != null;
        zzakt.zzd((boolean)bl2);
        if (zzagp2.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzagp2;
        bl2 = bl;
        while (true) {
            if (zzagp2.zzo() == null) {
                this.zzj.zzn(null);
                this.zzs();
                return bl2;
            }
            if ((zzagp2 = zzagp2.zzo()) == this.zzi) {
                this.zzi = this.zzh;
                bl2 = true;
            }
            zzagp2.zzm();
            --this.zzk;
        }
    }

    public final void zzm() {
        if (this.zzk == 0) {
            return;
        }
        zzagp zzagp2 = this.zzh;
        zzakt.zze((Object)zzagp2);
        this.zzl = zzagp2.zzb;
        this.zzm = zzagp2.zzf.zza.zzd;
        while (true) {
            if (zzagp2 == null) {
                this.zzh = null;
                this.zzj = null;
                this.zzi = null;
                this.zzk = 0;
                this.zzs();
                return;
            }
            zzagp2.zzm();
            zzagp2 = zzagp2.zzo();
        }
    }

    /*
     * Unable to fully structure code
     */
    public final boolean zzn(zzaiq var1_1, long var2_2, long var4_3) {
        block6: {
            var12_4 = this.zzh;
            var13_5 = null;
            while (var12_4 != null) {
                block7: {
                    var15_9 = var12_4.zzf;
                    if (var13_5 == null) {
                        var13_5 = this.zzo(var1_1, var15_9);
                    } else {
                        var14_8 = this.zzv(var1_1, (zzagp)var13_5, var2_2);
                        if (var14_8 == null) {
                            if (this.zzl((zzagp)var13_5) != false) return false;
                            return true;
                        }
                        if (var15_9.zzb != var14_8.zzb || !var15_9.zza.equals((Object)var14_8.zza)) break block6;
                        var13_5 = var14_8;
                    }
                    var12_4.zzf = var13_5.zzb(var15_9.zzc);
                    var8_6 = var15_9.zze;
                    var10_7 = var13_5.zze;
                    if (var8_6 == -9223372036854775807L || var8_6 == var10_7) break block7;
                    var12_4.zzr();
                    var2_2 = var13_5.zze;
                    var2_2 = var2_2 == -9223372036854775807L ? 0x7FFFFFFFFFFFFFFFL : (var2_2 += var12_4.zza());
                    if (var12_4 != this.zzi) ** GOTO lbl-1000
                    var7_10 = var12_4.zzf.zzf;
                    if (var4_3 == -9223372036854775808L || var4_3 >= var2_2) {
                        var6_11 = true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var6_11 = false;
                    }
                    if (this.zzl(var12_4) != false) return false;
                    if (var6_11 != false) return false;
                    return true;
                }
                var14_8 = var12_4.zzo();
                var13_5 = var12_4;
                var12_4 = var14_8;
            }
            return true;
        }
        if (this.zzl((zzagp)var13_5) != false) return false;
        return true;
    }

    public final zzagq zzo(zzaiq zzaiq2, zzagq zzagq2) {
        long l;
        int n;
        zzhf zzhf2 = zzagq2.zza;
        boolean bl = zzags.zzC(zzhf2);
        boolean bl2 = this.zzz(zzaiq2, zzhf2);
        boolean bl3 = this.zzA(zzaiq2, zzhf2, bl);
        zzaiq2.zzy(zzagq2.zza.zza, this.zza);
        if (!zzhf2.zzb() && (n = zzhf2.zze) != -1) {
            this.zza.zzb(n);
            l = 0L;
        } else {
            l = -9223372036854775807L;
        }
        long l2 = zzhf2.zzb() ? this.zza.zzh(zzhf2.zzb, zzhf2.zzc) : (l != -9223372036854775807L ? l : this.zza.zzd);
        if (zzhf2.zzb()) {
            this.zza.zzj(zzhf2.zzb);
        } else {
            n = zzhf2.zze;
            if (n == -1) return new zzagq(zzhf2, zzagq2.zzb, zzagq2.zzc, l, l2, false, bl, bl2, bl3);
            this.zza.zzj(n);
        }
        return new zzagq(zzhf2, zzagq2.zzb, zzagq2.zzc, l, l2, false, bl, bl2, bl3);
    }

    public final zzhf zzp(zzaiq zzaiq2, Object object, long l) {
        long l2;
        block4: {
            int n;
            int n2 = zzaiq2.zzy((Object)object, (zzain)this.zza).zzc;
            Object object2 = this.zzl;
            if (object2 != null && (n = zzaiq2.zzi(object2)) != -1 && zzaiq2.zzh((int)n, (zzain)this.zza, (boolean)false).zzc == n2) {
                l2 = this.zzm;
            } else {
                for (object2 = this.zzh; object2 != null; object2 = object2.zzo()) {
                    if (!((zzagp)object2).zzb.equals(object)) continue;
                    l2 = ((zzagp)object2).zzf.zza.zzd;
                    break block4;
                }
                for (object2 = this.zzh; object2 != null; object2 = object2.zzo()) {
                    n = zzaiq2.zzi(((zzagp)object2).zzb);
                    if (n == -1 || zzaiq2.zzh((int)n, (zzain)this.zza, (boolean)false).zzc != n2) continue;
                    l2 = ((zzagp)object2).zzf.zza.zzd;
                    break block4;
                }
                long l3 = this.zze;
                this.zze = 1L + l3;
                l2 = l3;
                if (this.zzh != null) return zzags.zzt(zzaiq2, object, l, l2, this.zza);
                this.zzl = object;
                this.zzm = l3;
                l2 = l3;
            }
        }
        return zzags.zzt(zzaiq2, object, l, l2, this.zza);
    }

    final /* synthetic */ void zzq(zzfog zzfog2, zzhf zzhf2) {
        this.zzc.zze((List)zzfog2.zzf(), zzhf2);
    }

    public final zzagp zzr(zzahw[] zzagp2, zzjz zzjz2, zzko zzko2, zzagz zzagz2, zzagq zzagq2, zzka zzka2) {
        long l;
        zzagp zzagp3 = this.zzj;
        if (zzagp3 == null) {
            if (!zzagq2.zza.zzb() || (l = zzagq2.zzc) == -9223372036854775807L) {
                l = 0L;
            }
        } else {
            l = zzagp3.zza() + this.zzj.zzf.zze - zzagq2.zzb;
        }
        zzagp2 = new zzagp((zzahw[])zzagp2, l, zzjz2, zzko2, zzagz2, zzagq2, zzka2, null);
        zzjz2 = this.zzj;
        if (zzjz2 != null) {
            zzjz2.zzn(zzagp2);
        } else {
            this.zzh = zzagp2;
            this.zzi = zzagp2;
        }
        this.zzl = null;
        this.zzj = zzagp2;
        ++this.zzk;
        this.zzs();
        return zzagp2;
    }
}
