/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzadz
 *  com.google.android.gms.internal.ads.zzaeb
 *  com.google.android.gms.internal.ads.zzaec
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzaff
 *  com.google.android.gms.internal.ads.zzafh
 *  com.google.android.gms.internal.ads.zzafi
 *  com.google.android.gms.internal.ads.zzafl
 *  com.google.android.gms.internal.ads.zzafm
 *  com.google.android.gms.internal.ads.zzafn
 *  com.google.android.gms.internal.ads.zzafo
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzafy
 *  com.google.android.gms.internal.ads.zzagh
 *  com.google.android.gms.internal.ads.zzagp
 *  com.google.android.gms.internal.ads.zzagq
 *  com.google.android.gms.internal.ads.zzags
 *  com.google.android.gms.internal.ads.zzagx
 *  com.google.android.gms.internal.ads.zzagy
 *  com.google.android.gms.internal.ads.zzagz
 *  com.google.android.gms.internal.ads.zzahd
 *  com.google.android.gms.internal.ads.zzahf
 *  com.google.android.gms.internal.ads.zzahq
 *  com.google.android.gms.internal.ads.zzahs
 *  com.google.android.gms.internal.ads.zzahv
 *  com.google.android.gms.internal.ads.zzahw
 *  com.google.android.gms.internal.ads.zzahx
 *  com.google.android.gms.internal.ads.zzahz
 *  com.google.android.gms.internal.ads.zzain
 *  com.google.android.gms.internal.ads.zzaip
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzaks
 *  com.google.android.gms.internal.ads.zzaku
 *  com.google.android.gms.internal.ads.zzalg
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzcy
 *  com.google.android.gms.internal.ads.zzfmj
 *  com.google.android.gms.internal.ads.zzfog
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzhd
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzix
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzjy
 *  com.google.android.gms.internal.ads.zzjz
 *  com.google.android.gms.internal.ads.zzka
 *  com.google.android.gms.internal.ads.zzki
 *  com.google.android.gms.internal.ads.zzo
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzadz;
import com.google.android.gms.internal.ads.zzaeb;
import com.google.android.gms.internal.ads.zzaec;
import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzaff;
import com.google.android.gms.internal.ads.zzafh;
import com.google.android.gms.internal.ads.zzafi;
import com.google.android.gms.internal.ads.zzafl;
import com.google.android.gms.internal.ads.zzafm;
import com.google.android.gms.internal.ads.zzafn;
import com.google.android.gms.internal.ads.zzafo;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzafy;
import com.google.android.gms.internal.ads.zzagh;
import com.google.android.gms.internal.ads.zzagp;
import com.google.android.gms.internal.ads.zzagq;
import com.google.android.gms.internal.ads.zzags;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzagy;
import com.google.android.gms.internal.ads.zzagz;
import com.google.android.gms.internal.ads.zzahd;
import com.google.android.gms.internal.ads.zzahf;
import com.google.android.gms.internal.ads.zzahq;
import com.google.android.gms.internal.ads.zzahs;
import com.google.android.gms.internal.ads.zzahv;
import com.google.android.gms.internal.ads.zzahw;
import com.google.android.gms.internal.ads.zzahx;
import com.google.android.gms.internal.ads.zzahz;
import com.google.android.gms.internal.ads.zzain;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzaks;
import com.google.android.gms.internal.ads.zzaku;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzcy;
import com.google.android.gms.internal.ads.zzfmj;
import com.google.android.gms.internal.ads.zzfog;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzhd;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzix;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzjy;
import com.google.android.gms.internal.ads.zzjz;
import com.google.android.gms.internal.ads.zzka;
import com.google.android.gms.internal.ads.zzki;
import com.google.android.gms.internal.ads.zzo;
import com.google.android.gms.internal.ads.zzs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

final class zzafp
implements Handler.Callback,
zzhd,
zzjy,
zzagy,
zzaeb,
zzahq {
    private boolean zzA;
    private int zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private int zzG;
    private zzafo zzH;
    private long zzI;
    private int zzJ;
    private boolean zzK;
    private zzaeg zzL;
    private final zzadz zzM;
    private final zzahv[] zza;
    private final Set<zzahv> zzb;
    private final zzahw[] zzc;
    private final zzjz zzd;
    private final zzka zze;
    private final zzafy zzf;
    private final zzki zzg;
    private final zzalg zzh;
    private final HandlerThread zzi;
    private final Looper zzj;
    private final zzaip zzk;
    private final zzain zzl;
    private final long zzm;
    private final zzaec zzn;
    private final ArrayList<zzafl> zzo;
    private final zzaku zzp;
    private final zzafn zzq;
    private final zzags zzr;
    private final zzagz zzs;
    private zzahz zzt;
    private zzahd zzu;
    private zzafm zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    public zzafp(zzahv[] handler, zzjz zzjz2, zzka zzka2, zzafy zzafy2, zzki zzki2, int n, boolean bl, zzcy zzcy2, zzahz zzahz2, zzadz zzadz2, long l, boolean bl2, Looper looper, zzaku zzaku2, zzafn zzafn2, byte[] byArray) {
        this.zzq = zzafn2;
        this.zza = handler;
        this.zzd = zzjz2;
        this.zze = zzka2;
        this.zzf = zzafy2;
        this.zzg = zzki2;
        n = 0;
        this.zzB = 0;
        this.zzC = false;
        this.zzt = zzahz2;
        this.zzM = zzadz2;
        this.zzx = false;
        this.zzp = zzaku2;
        this.zzm = zzafy2.zzd();
        zzafy2.zze();
        zzka2 = zzahd.zza((zzka)zzka2);
        this.zzu = zzka2;
        this.zzv = new zzafm((zzahd)zzka2);
        this.zzc = new zzahw[2];
        while (true) {
            if (n >= 2) {
                this.zzn = new zzaec((zzaeb)this, zzaku2);
                this.zzo = new ArrayList();
                this.zzb = Collections.newSetFromMap(new IdentityHashMap());
                this.zzk = new zzaip();
                this.zzl = new zzain();
                zzjz2.zzk((zzjy)this, zzki2);
                this.zzK = true;
                handler = new Handler(looper);
                this.zzr = new zzags(zzcy2, handler);
                this.zzs = new zzagz((zzagy)this, zzcy2, handler);
                handler = new HandlerThread("ExoPlayer:Playback", -16);
                this.zzi = handler;
                handler.start();
                handler = this.zzi.getLooper();
                this.zzj = handler;
                this.zzh = zzaku2.zza((Looper)handler, (Handler.Callback)this);
                return;
            }
            handler[n].zzae(n);
            this.zzc[n] = handler[n].zzad();
            ++n;
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void zzA() throws zzaeg {
        block7: {
            block8: {
                block9: {
                    block6: {
                        var14_1 = this.zzr.zzh();
                        if (var14_1 == null) {
                            return;
                        }
                        var6_2 = var14_1.zzd != false ? var14_1.zza.zzg() : -9223372036854775807L;
                        if (var6_2 == -9223372036854775807L) break block6;
                        this.zzG(var6_2);
                        if (var6_2 != this.zzu.zzs) {
                            var14_1 = this.zzu;
                            this.zzu = this.zzV(var14_1.zzb, var6_2, var14_1.zzc, var6_2, true, 5);
                        }
                        break block7;
                    }
                    var15_3 = this.zzn;
                    var5_4 = var14_1 != this.zzr.zzi();
                    this.zzI = var10_5 = var15_3.zzf(var5_4);
                    var12_6 = var14_1.zza();
                    var8_7 = this.zzu.zzs;
                    if (this.zzo.isEmpty() || this.zzu.zzb.zzb()) break block8;
                    var6_2 = var8_7;
                    if (this.zzK) {
                        var6_2 = var8_7 - 1L;
                        this.zzK = false;
                    }
                    var14_1 = this.zzu;
                    var4_8 = var14_1.zza.zzi(var14_1.zzb.zza);
                    var3_9 = Math.min(this.zzJ, this.zzo.size());
                    var8_7 = var6_2;
                    var2_10 = var3_9;
                    if (var3_9 <= 0) break block9;
                    var14_1 = this.zzo.get(var3_9 - 1);
                    var2_10 = var3_9;
                    ** GOTO lbl35
                }
                block0: while (true) {
                    var14_1 = null;
                    var6_2 = var8_7;
                    while (var14_1 != null && (var4_8 < 0 || var4_8 == 0 && var6_2 < 0L)) {
                        var3_9 = var2_10 - 1;
                        var8_7 = var6_2;
                        var2_10 = var3_9;
                        if (var3_9 <= 0) continue block0;
                        var14_1 = this.zzo.get(var3_9 - 1);
                        var2_10 = var3_9;
                    }
                    break;
                }
                if (var2_10 < this.zzo.size()) {
                    var14_1 = this.zzo.get(var2_10);
                }
                this.zzJ = var2_10;
            }
            this.zzu.zzs = var10_5 - var12_6;
        }
        var14_1 = this.zzr.zzg();
        this.zzu.zzq = var14_1.zze();
        this.zzu.zzr = this.zzZ();
        var14_1 = this.zzu;
        if (var14_1.zzl == false) return;
        if (var14_1.zze != 3) return;
        if (this.zzC(var14_1.zza, var14_1.zzb) == false) return;
        var14_1 = this.zzu;
        if (var14_1.zzn.zzb != 1.0f) return;
        var1_11 = this.zzM.zzd(this.zzB(var14_1.zza, var14_1.zzb.zza, var14_1.zzs), this.zzZ());
        if (this.zzn.zzA().zzb == var1_11) return;
        this.zzn.zzz(new zzahf(var1_11, this.zzu.zzn.zzc));
        this.zzR(this.zzu.zzn, this.zzn.zzA().zzb, false, false);
    }

    private final long zzB(zzaiq zzaiq2, Object object, long l) {
        zzaiq2.zzf(zzaiq2.zzy((Object)object, (zzain)this.zzl).zzc, this.zzk, 0L);
        zzaiq2 = this.zzk;
        if (zzaiq2.zze == -9223372036854775807L) return -9223372036854775807L;
        if (!zzaiq2.zzb()) return -9223372036854775807L;
        zzaiq2 = this.zzk;
        if (zzaiq2.zzh) return zzadx.zzb((long)(zzamq.zzab((long)zzaiq2.zzf) - this.zzk.zze)) - l;
        return -9223372036854775807L;
    }

    private final boolean zzC(zzaiq zzaiq2, zzhf zzhf2) {
        if (zzhf2.zzb()) return false;
        if (zzaiq2.zzt()) {
            return false;
        }
        zzaiq2.zzf(zzaiq2.zzy((Object)zzhf2.zza, (zzain)this.zzl).zzc, this.zzk, 0L);
        if (!this.zzk.zzb()) return false;
        zzaiq2 = this.zzk;
        if (!zzaiq2.zzh) return false;
        if (zzaiq2.zze == -9223372036854775807L) return false;
        return true;
    }

    private final void zzD(long l, long l2) {
        this.zzh.zzh(2);
        this.zzh.zzg(2, l + l2);
    }

    private final long zzE(zzhf zzhf2, long l, boolean bl) throws zzaeg {
        boolean bl2 = this.zzr.zzh() != this.zzr.zzi();
        return this.zzF(zzhf2, l, bl2, bl);
    }

    private final long zzF(zzhf zzahvArray, long l, boolean bl, boolean bl2) throws zzaeg {
        zzagp zzagp2;
        zzagp zzagp3;
        this.zzz();
        this.zzz = false;
        if (bl2 || this.zzu.zze == 3) {
            this.zzu(2);
        }
        for (zzagp3 = zzagp2 = this.zzr.zzh(); zzagp3 != null && !zzahvArray.equals((Object)zzagp3.zzf.zza); zzagp3 = zzagp3.zzo()) {
        }
        if (bl || zzagp2 != zzagp3 || zzagp3 != null && zzagp3.zza() + l < 0L) {
            zzahvArray = this.zza;
            for (int i = 0; i < 2; ++i) {
                this.zzL(zzahvArray[i]);
            }
            if (zzagp3 != null) {
                while (this.zzr.zzh() != zzagp3) {
                    this.zzr.zzk();
                }
                this.zzr.zzl(zzagp3);
                zzagp3.zzb(0L);
                this.zzW();
            }
        }
        if (zzagp3 != null) {
            long l2;
            this.zzr.zzl(zzagp3);
            if (!zzagp3.zzd) {
                zzagp3.zzf = zzagp3.zzf.zza(l);
                l2 = l;
            } else {
                l2 = l;
                if (zzagp3.zze) {
                    l2 = zzagp3.zza.zzi(l);
                    zzagp3.zza.zze(l2 - this.zzm, false);
                }
            }
            this.zzG(l2);
            this.zzS();
            l = l2;
        } else {
            this.zzr.zzm();
            this.zzG(l);
        }
        this.zzY(false);
        this.zzh.zzf(2);
        return l;
    }

    private final void zzG(long l) throws zzaeg {
        zzagp zzagp2 = this.zzr.zzh();
        if (zzagp2 != null) {
            l += zzagp2.zza();
        }
        this.zzI = l;
        this.zzn.zzc(l);
        zzahv[] zzahvArray = this.zza;
        for (int i = 0; i < 2; ++i) {
            zzagp2 = zzahvArray[i];
            if (!zzafp.zzaf((zzahv)zzagp2)) continue;
            zzagp2.zzap(this.zzI);
        }
        zzagp2 = this.zzr.zzh();
        while (zzagp2 != null) {
            for (zzahv zzahv2 : zzagp2.zzq().zzd) {
            }
            zzagp2 = zzagp2.zzo();
        }
    }

    private final void zzH(boolean bl, boolean bl2) {
        bl = bl || !this.zzD;
        this.zzI(bl, false, true, false);
        this.zzv.zzb(bl2 ? 1 : 0);
        this.zzf.zzb();
        this.zzu(1);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void zzI(boolean var1_1, boolean var2_2, boolean var3_3, boolean var4_4) {
        this.zzh.zzh(2);
        var12_5 = null;
        this.zzL = null;
        this.zzz = false;
        this.zzn.zzb();
        this.zzI = 0L;
        var13_6 = this.zza;
        for (var5_8 = 0; var5_8 < 2; ++var5_8) {
            var11_9 = var13_6[var5_8];
            try {
                this.zzL((zzahv)var11_9);
                continue;
            }
            catch (RuntimeException var11_10) {
            }
            catch (zzaeg var11_11) {
                // empty catch block
            }
            zzaln.zzb((String)"ExoPlayerImplInternal", (String)"Disable failed.", (Throwable)var11_9);
        }
        if (var1_1) {
            var11_9 = this.zza;
            for (var5_8 = 0; var5_8 < 2; ++var5_8) {
                var13_6 = var11_9[var5_8];
                if (!this.zzb.remove(var13_6)) continue;
                try {
                    var13_6.zzas();
                    continue;
                }
                catch (RuntimeException var13_7) {
                    zzaln.zzb((String)"ExoPlayerImplInternal", (String)"Reset failed.", (Throwable)var13_7);
                }
            }
        }
        this.zzG = 0;
        var13_6 = this.zzu;
        var11_9 = var13_6.zzb;
        var9_12 = var13_6.zzs;
        var7_13 = !this.zzu.zzb.zzb() && !zzafp.zzad(this.zzu, this.zzl) ? this.zzu.zzs : this.zzu.zzc;
        if (!var2_2) ** GOTO lbl45
        this.zzH = null;
        var13_6 = this.zzJ(this.zzu.zza);
        var11_9 = (zzhf)var13_6.first;
        var9_12 = (Long)var13_6.second;
        if (!var11_9.equals((Object)this.zzu.zzb)) {
            var5_8 = 1;
            var7_13 = -9223372036854775807L;
        } else {
            var7_13 = -9223372036854775807L;
lbl45:
            // 2 sources

            var5_8 = 0;
        }
        this.zzr.zzm();
        this.zzA = false;
        var13_6 = this.zzu;
        var16_14 = var13_6.zza;
        var6_15 = var13_6.zze;
        if (!var4_4) {
            var12_5 = var13_6.zzf;
        }
        var13_6 = var5_8 != 0 ? com.google.android.gms.internal.ads.zzs.zza : var13_6.zzh;
        var14_16 = var5_8 != 0 ? this.zze : this.zzu.zzi;
        var15_17 /* !! */  = var5_8 != 0 ? zzfoj.zzi() : this.zzu.zzj;
        var17_18 = this.zzu;
        this.zzu = new zzahd(var16_14, var11_9, var7_13, var9_12, var6_15, var12_5, false, (zzs)var13_6, var14_16, (List)var15_17 /* !! */ , var11_9, var17_18.zzl, var17_18.zzm, var17_18.zzn, var9_12, 0L, var9_12, this.zzF, false);
        if (var3_3 == false) return;
        this.zzs.zzg();
    }

    private final Pair<zzhf, Long> zzJ(zzaiq zzaiq2) {
        boolean bl = zzaiq2.zzt();
        long l = 0L;
        if (bl) {
            return Pair.create((Object)zzahd.zzb(), (Object)0L);
        }
        int n = zzaiq2.zze(this.zzC);
        Pair pair = zzaiq2.zzv(this.zzk, this.zzl, n, -9223372036854775807L);
        zzhf zzhf2 = this.zzr.zzp(zzaiq2, pair.first, 0L);
        long l2 = (Long)pair.second;
        if (!zzhf2.zzb()) return Pair.create((Object)zzhf2, (Object)l2);
        zzaiq2.zzy(zzhf2.zza, this.zzl);
        l2 = l;
        if (zzhf2.zzc != this.zzl.zzc(zzhf2.zzb)) return Pair.create((Object)zzhf2, (Object)l2);
        this.zzl.zzi();
        l2 = l;
        return Pair.create((Object)zzhf2, (Object)l2);
    }

    private final void zzK(zzaiq zzaiq2, zzaiq object) {
        int n;
        if (zzaiq2.zzt()) {
            if (object.zzt()) return;
        }
        if ((n = this.zzo.size() - 1) < 0) {
            Collections.sort(this.zzo);
            return;
        }
        zzaiq2 = this.zzo.get(n);
        object = zzaiq2.zzb;
        object = zzaiq2.zza;
        zzadx.zzb((long)-9223372036854775807L);
        zzaiq2 = zzaiq2.zza;
        throw null;
    }

    private final void zzL(zzahv zzahv2) throws zzaeg {
        if (!zzafp.zzaf(zzahv2)) {
            return;
        }
        this.zzn.zze(zzahv2);
        zzafp.zzah(zzahv2);
        zzahv2.zzar();
        --this.zzG;
    }

    private final boolean zzM() {
        boolean bl;
        zzagp zzagp2 = this.zzr.zzh();
        long l = zzagp2.zzf.zze;
        boolean bl2 = zzagp2.zzd;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        if (l != -9223372036854775807L && this.zzu.zzs >= l) {
            if (!this.zzac()) return true;
            bl3 = bl;
        } else {
            bl3 = true;
        }
        return bl3;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void zzN(zzaiq var1_1, boolean var2_2) throws zzaeg {
        block57: {
            block58: {
                var27_3 = this.zzu;
                var31_4 = this.zzH;
                var26_5 /* !! */  = this.zzr;
                var3_6 = this.zzB;
                var7_7 = this.zzC;
                var29_8 = this.zzk;
                var28_9 = this.zzl;
                var8_10 = var1_1.zzt();
                var4_11 = 1;
                if (var8_10) {
                    var25_12 = zzahd.zzb();
                    var10_13 = -9223372036854775807L;
                    var7_7 = false;
                    var3_6 = 0;
                    var12_14 = 0L;
                } else {
                    var25_12 = var27_3.zzb;
                    var24_15 /* !! */  = var25_12.zza;
                    var8_10 = zzafp.zzad(var27_3, var28_9);
                    var10_13 = !var27_3.zzb.zzb() && !var8_10 ? var27_3.zzs : var27_3.zzc;
                    if (var31_4 != null) {
                        var30_20 /* !! */  = zzafp.zzae(var1_1, var31_4, true, var3_6, var7_7, var29_8, var28_9);
                        if (var30_20 /* !! */  == null) {
                            var5_21 = var1_1.zze(var7_7);
                            var12_14 = var10_13;
                            var3_6 = 1;
                            var7_7 = false;
                            var4_11 = 0;
                        } else {
                            if (var31_4.zzc == -9223372036854775807L) {
                                var3_6 = var1_1.zzy((Object)var30_20 /* !! */ .first, (zzain)var28_9).zzc;
                                var12_14 = var10_13;
                                var4_11 = 0;
                            } else {
                                var24_15 /* !! */  = var30_20 /* !! */ .first;
                                var12_14 = (Long)var30_20 /* !! */ .second;
                                var4_11 = 1;
                                var3_6 = -1;
                            }
                            var7_7 = var27_3.zze == 4;
                            var6_22 = 0;
                            var5_21 = var3_6;
                            var3_6 = var6_22;
                        }
                    } else if (var27_3.zza.zzt()) {
                        var3_6 = var1_1.zze(var7_7);
lbl46:
                        // 2 sources

                        while (true) {
                            var5_21 = var3_6;
lbl48:
                            // 2 sources

                            while (true) {
                                var12_14 = var10_13;
                                var7_7 = false;
                                var3_6 = 0;
                                var4_11 = 0;
                                ** GOTO lbl87
                                break;
                            }
                            break;
                        }
                    } else if (var1_1.zzi((Object)var24_15 /* !! */ ) == -1) {
                        var30_20 /* !! */  = zzafp.zzm(var29_8, var28_9, var3_6, var7_7, var24_15 /* !! */ , var27_3.zza, var1_1);
                        if (var30_20 /* !! */  == null) {
                            var4_11 = var1_1.zze(var7_7);
                            var3_6 = 1;
                        } else {
                            var4_11 = var1_1.zzy(var30_20 /* !! */ , (zzain)var28_9).zzc;
                            var3_6 = 0;
                        }
                        var12_14 = var10_13;
                        var7_7 = false;
                        var6_22 = 0;
                        var5_21 = var4_11;
                        var4_11 = var6_22;
                    } else {
                        if (var10_13 == -9223372036854775807L) {
                            var3_6 = var1_1.zzy((Object)var24_15 /* !! */ , (zzain)var28_9).zzc;
                            ** continue;
                        }
                        if (var8_10) {
                            var27_3.zza.zzy(var25_12.zza, var28_9);
                            if (var27_3.zza.zzf((int)var28_9.zzc, (zzaip)var29_8, (long)0L).zzn == var27_3.zza.zzi(var25_12.zza)) {
                                var30_20 /* !! */  = var1_1.zzv(var29_8, var28_9, var1_1.zzy((Object)var24_15 /* !! */ , (zzain)var28_9).zzc, var10_13);
                                var24_15 /* !! */  = var30_20 /* !! */ .first;
                                var12_14 = (Long)var30_20 /* !! */ .second;
                            } else {
                                var12_14 = var10_13;
                            }
                            var5_21 = -1;
                            var7_7 = false;
                            var3_6 = 0;
                            var4_11 = 1;
                        } else {
                            var5_21 = -1;
                            ** continue;
                        }
                    }
lbl87:
                    // 5 sources

                    if (var5_21 != -1) {
                        var29_8 = var1_1.zzv(var29_8, var28_9, var5_21, -9223372036854775807L);
                        var24_15 /* !! */  = var29_8.first;
                        var14_23 = (Long)var29_8.second;
                        var12_14 = -9223372036854775807L;
                    } else {
                        var14_23 = var12_14;
                    }
                    var26_5 /* !! */  = var26_5 /* !! */ .zzp(var1_1, (Object)var24_15 /* !! */ , var14_23);
                    var5_21 = var26_5 /* !! */ .zze != -1 && ((var5_21 = var25_12.zze) == -1 || var26_5 /* !! */ .zzb < var5_21) ? 0 : 1;
                    var9_24 = var25_12.zza.equals(var24_15 /* !! */ );
                    var5_21 = var9_24 != false && var25_12.zzb() == false && var26_5 /* !! */ .zzb() == false && var5_21 != 0 ? 1 : 0;
                    var1_1.zzy((Object)var24_15 /* !! */ , var28_9);
                    if (var9_24 && !var8_10 && var10_13 == var12_14) {
                        if (var26_5 /* !! */ .zzb()) {
                            var28_9.zzj(var26_5 /* !! */ .zzb);
                        }
                        if (var25_12.zzb()) {
                            var28_9.zzj(var25_12.zzb);
                        }
                    }
                    var24_15 /* !! */  = 1 != var5_21 ? var26_5 /* !! */  : var25_12;
                    var10_13 = var14_23;
                    if (var24_15 /* !! */ .zzb()) {
                        if (var24_15 /* !! */ .equals((Object)var25_12)) {
                            var10_13 = var27_3.zzs;
                        } else {
                            var1_1.zzy(var24_15 /* !! */ .zza, var28_9);
                            if (var24_15 /* !! */ .zzc == var28_9.zzc(var24_15 /* !! */ .zzb)) {
                                var28_9.zzi();
                            }
                            var10_13 = 0L;
                        }
                    }
                    var5_21 = var3_6;
                    var3_6 = var4_11;
                    var14_23 = var10_13;
                    var10_13 = var12_14;
                    var12_14 = var14_23;
                    var25_12 = var24_15 /* !! */ ;
                    var4_11 = var5_21;
                }
                var5_21 = this.zzu.zzb.equals((Object)var25_12) && var12_14 == this.zzu.zzs ? 0 : 1;
                if (var4_11 != 0) {
                    var14_23 = var10_13;
                    try {
                        if (this.zzu.zze != 1) {
                            var14_23 = var10_13;
                            this.zzu(4);
                        }
                        var14_23 = var10_13;
                        this.zzI(false, false, false, true);
                    }
                    catch (Throwable var24_16) {
                        var16_25 = var14_23;
                        break block57;
                    }
                }
                if (var5_21 != 0) ** GOTO lbl193
                var14_23 = var10_13;
                var27_3 = this.zzr;
                var14_23 = var10_13;
                var22_26 = this.zzI;
                var14_23 = var10_13;
                var26_5 /* !! */  = var27_3.zzi();
                if (var26_5 /* !! */  == null) {
                    var14_23 = 0L;
                } else {
                    var14_23 = var10_13;
                    var16_25 = var26_5 /* !! */ .zza();
                    var14_23 = var10_13;
                    if (!var26_5 /* !! */ .zzd) {
                        var14_23 = var16_25;
                    } else {
                        var4_11 = 0;
                        var18_27 = var16_25;
                        while (true) {
                            var14_23 = var10_13;
                            var24_15 /* !! */  = this.zza;
                            var16_25 = var10_13;
                            var14_23 = var18_27;
                            var10_13 = var16_25;
                            if (var4_11 >= 2) break;
                            var10_13 = var18_27;
                            try {
                                if (zzafp.zzaf(var24_15 /* !! */ [var4_11])) {
                                    if (this.zza[var4_11].zzaj() != var26_5 /* !! */ .zzc[var4_11]) {
                                        var10_13 = var18_27;
                                    } else {
                                        var10_13 = this.zza[var4_11].zzal();
                                        if (var10_13 == -9223372036854775808L) {
                                            var14_23 = -9223372036854775808L;
                                            var10_13 = var16_25;
                                            break;
                                        }
                                        var10_13 = Math.max(var10_13, var18_27);
                                    }
                                }
                                ++var4_11;
                                var18_27 = var10_13;
                                var10_13 = var16_25;
                            }
                            catch (Throwable var24_18) {
                                break block57;
                            }
                        }
                    }
                }
                var16_25 = var12_14;
                var20_29 = var10_13;
                var18_27 = var10_13;
                try {
                    block59: {
                        if (!var27_3.zzn(var1_1, var22_26, var14_23)) {
                            var18_27 = var10_13;
                            this.zzx(false);
                            var16_25 = var12_14;
                            var20_29 = var10_13;
                        }
                        break block59;
lbl193:
                        // 1 sources

                        var16_25 = var12_14;
                        var20_29 = var10_13;
                        var18_28 = var10_13;
                        if (!var1_1.zzt()) {
                            var18_28 = var10_13;
                            for (var24_15 /* !! */  = this.zzr.zzh(); var24_15 /* !! */  != null; var24_15 /* !! */  = var24_15 /* !! */ .zzo()) {
                                var18_28 = var10_13;
                                if (var24_15 /* !! */ .zzf.zza.equals((Object)var25_12)) {
                                    var18_28 = var10_13;
                                    var24_15 /* !! */ .zzf = this.zzr.zzo(var1_1, var24_15 /* !! */ .zzf);
                                    var18_28 = var10_13;
                                    var24_15 /* !! */ .zzr();
                                }
                                var18_28 = var10_13;
                            }
                            var18_28 = var10_13;
                            var16_25 = this.zzE(var25_12, var12_14, var7_7);
                            var20_29 = var10_13;
                        }
                    }
                    var7_7 = true;
                    var26_5 /* !! */  = this.zzu;
                    var24_15 /* !! */  = var26_5 /* !! */ .zza;
                    var26_5 /* !! */  = var26_5 /* !! */ .zzb;
                    var10_13 = 1 != var3_6 ? -9223372036854775807L : var16_25;
                    this.zzO(var1_1, var25_12, (zzaiq)var24_15 /* !! */ , (zzhf)var26_5 /* !! */ , var10_13);
                    if (var5_21 == 0 && var20_29 == this.zzu.zzc) break block58;
                    var26_5 /* !! */  = this.zzu;
                    var24_15 /* !! */  = var26_5 /* !! */ .zzb.zza;
                    var26_5 /* !! */  = var26_5 /* !! */ .zza;
                    if (var5_21 != 0 && var2_2) {
                    }
                    ** GOTO lbl-1000
                }
                catch (Throwable var24_19) {
                    var16_25 = var18_27;
                    break block57;
                }
                if (!var26_5 /* !! */ .zzt() && !var26_5 /* !! */ .zzy((Object)var24_15 /* !! */ , (zzain)this.zzl).zzf) {
                    var2_2 = var7_7;
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 = false;
                }
                var10_13 = this.zzu.zzd;
                var3_6 = var1_1.zzi((Object)var24_15 /* !! */ ) == -1 ? 4 : 3;
                this.zzu = this.zzV(var25_12, var16_25, var20_29, var10_13, var2_2, var3_6);
            }
            this.zzP();
            this.zzK(var1_1, this.zzu.zza);
            this.zzu = this.zzu.zzd(var1_1);
            if (!var1_1.zzt()) {
                this.zzH = null;
            }
            this.zzY(false);
            return;
        }
        var7_7 = true;
        var27_3 = this.zzu;
        var26_5 /* !! */  = var27_3.zza;
        var27_3 = var27_3.zzb;
        var10_13 = 1 != var3_6 ? -9223372036854775807L : var12_14;
        this.zzO(var1_1, var25_12, (zzaiq)var26_5 /* !! */ , (zzhf)var27_3, var10_13);
        if (var5_21 != 0 || var16_25 != this.zzu.zzc) {
            var27_3 = this.zzu;
            var26_5 /* !! */  = var27_3.zzb.zza;
            var27_3 = var27_3.zza;
            var2_2 = var5_21 != 0 && var2_2 != false && var27_3.zzt() == false && var27_3.zzy((Object)var26_5 /* !! */ , (zzain)this.zzl).zzf == false ? var7_7 : false;
            var10_13 = this.zzu.zzd;
            var3_6 = var1_1.zzi((Object)var26_5 /* !! */ ) == -1 ? 4 : 3;
            this.zzu = this.zzV(var25_12, var12_14, var16_25, var10_13, var2_2, var3_6);
        }
        this.zzP();
        this.zzK(var1_1, this.zzu.zza);
        this.zzu = this.zzu.zzd(var1_1);
        if (!var1_1.zzt()) {
            this.zzH = null;
        }
        this.zzY(false);
        throw var24_17;
    }

    private final void zzO(zzaiq object, zzhf object2, zzaiq zzaiq2, zzhf zzhf2, long l) {
        if (!object.zzt() && this.zzC((zzaiq)object, (zzhf)object2)) {
            object.zzf(object.zzy((Object)object2.zza, (zzain)this.zzl).zzc, this.zzk, 0L);
            zzadz zzadz2 = this.zzM;
            zzagh zzagh2 = this.zzk.zzj;
            int n = zzamq.zza;
            zzadz2.zza(zzagh2);
            if (l != -9223372036854775807L) {
                this.zzM.zzb(this.zzB((zzaiq)object, object2.zza, l));
                return;
            }
            object2 = this.zzk.zzb;
            object = !zzaiq2.zzt() ? zzaiq2.zzf((int)zzaiq2.zzy((Object)zzhf2.zza, (zzain)this.zzl).zzc, (zzaip)this.zzk, (long)0L).zzb : null;
            if (zzamq.zzc((Object)object, (Object)object2)) return;
            this.zzM.zzb(-9223372036854775807L);
            return;
        }
        float f = this.zzn.zzA().zzb;
        object = this.zzu.zzn;
        if (f == object.zzb) return;
        this.zzn.zzz((zzahf)object);
    }

    private final void zzP() {
        boolean bl;
        zzagp zzagp2 = this.zzr.zzh();
        boolean bl2 = bl = false;
        if (zzagp2 != null) {
            bl2 = bl;
            if (zzagp2.zzf.zzh) {
                bl2 = bl;
                if (this.zzx) {
                    bl2 = true;
                }
            }
        }
        this.zzy = bl2;
    }

    private final void zzQ(zzahf zzahf2, boolean bl) throws zzaeg {
        this.zzR(zzahf2, zzahf2.zzb, true, bl);
    }

    private final void zzR(zzahf zzahf2, float f, boolean bl, boolean bl2) throws zzaeg {
        int n;
        zzagp zzagp2;
        if (bl) {
            if (bl2) {
                this.zzv.zzb(1);
            }
            zzagp2 = this.zzu;
            this.zzu = new zzahd(zzagp2.zza, zzagp2.zzb, zzagp2.zzc, zzagp2.zzd, zzagp2.zze, zzagp2.zzf, zzagp2.zzg, zzagp2.zzh, zzagp2.zzi, zzagp2.zzj, zzagp2.zzk, zzagp2.zzl, zzagp2.zzm, zzahf2, zzagp2.zzq, zzagp2.zzr, zzagp2.zzs, zzagp2.zzo, zzagp2.zzp);
        }
        float f2 = zzahf2.zzb;
        zzagp2 = this.zzr.zzh();
        while (true) {
            n = 0;
            if (zzagp2 == null) break;
            for (zzahv zzahv2 : zzagp2.zzq().zzd) {
            }
            zzagp2 = zzagp2.zzo();
        }
        zzagp2 = this.zza;
        int n2 = n;
        while (n2 < 2) {
            zzahv zzahv3 = zzagp2[n2];
            if (zzahv3 != null) {
                zzahv3.zzM(f, zzahf2.zzb);
            }
            ++n2;
        }
    }

    private final void zzS() {
        boolean bl;
        if (!this.zzT()) {
            bl = false;
        } else {
            long l;
            long l2;
            zzagp zzagp2 = this.zzr.zzg();
            long l3 = this.zzaa(zzagp2.zzf());
            if (zzagp2 == this.zzr.zzh()) {
                l2 = this.zzI;
                l = zzagp2.zza();
            } else {
                l2 = this.zzI - zzagp2.zza();
                l = zzagp2.zzf.zzb;
            }
            bl = this.zzf.zzf(l2 - l, l3, this.zzn.zzA().zzb);
        }
        this.zzA = bl;
        if (bl) {
            this.zzr.zzg().zzi(this.zzI);
        }
        this.zzU();
    }

    private final boolean zzT() {
        zzagp zzagp2 = this.zzr.zzg();
        if (zzagp2 == null) {
            return false;
        }
        if (zzagp2.zzf() != Long.MIN_VALUE) return true;
        return false;
    }

    private final void zzU() {
        zzagp zzagp2 = this.zzr.zzg();
        boolean bl = this.zzA || zzagp2 != null && zzagp2.zza.zzm();
        zzagp2 = this.zzu;
        if (bl == zzagp2.zzg) return;
        this.zzu = new zzahd(zzagp2.zza, zzagp2.zzb, zzagp2.zzc, zzagp2.zzd, zzagp2.zze, zzagp2.zzf, bl, zzagp2.zzh, zzagp2.zzi, zzagp2.zzj, zzagp2.zzk, zzagp2.zzl, zzagp2.zzm, zzagp2.zzn, zzagp2.zzq, zzagp2.zzr, zzagp2.zzs, zzagp2.zzo, zzagp2.zzp);
    }

    private final zzahd zzV(zzhf zzhf2, long l, long l2, long l3, boolean bl, int n) {
        boolean bl2 = this.zzK || l != this.zzu.zzs || !zzhf2.equals((Object)this.zzu.zzb);
        this.zzK = bl2;
        this.zzP();
        Object object = this.zzu;
        zzs zzs2 = object.zzh;
        zzka zzka2 = object.zzi;
        object = object.zzj;
        if (!this.zzs.zzc()) {
            if (!zzhf2.equals((Object)this.zzu.zzb)) {
                zzs2 = com.google.android.gms.internal.ads.zzs.zza;
                zzka2 = this.zze;
                object = zzfoj.zzi();
            }
        } else {
            zzagp zzagp2 = this.zzr.zzh();
            object = zzagp2 == null ? com.google.android.gms.internal.ads.zzs.zza : zzagp2.zzp();
            zzka2 = zzagp2 == null ? this.zze : zzagp2.zzq();
            zzagq zzagq2 = zzka2.zzd;
            zzs2 = new zzfog();
            int n2 = ((zzjg[])zzagq2).length;
            boolean bl3 = false;
            for (int i = 0; i < n2; ++i) {
                zzjg zzjg2 = zzagq2[i];
                boolean bl4 = bl3;
                if (zzjg2 != null) {
                    zzjg2 = zzjg2.zzd((int)0).zzj;
                    if (zzjg2 == null) {
                        zzs2.zze((Object)new zzaiv(new zzaiu[0]));
                        bl4 = bl3;
                    } else {
                        zzs2.zze((Object)zzjg2);
                        bl4 = true;
                    }
                }
                bl3 = bl4;
            }
            zzs2 = bl3 ? zzs2.zzf() : zzfoj.zzi();
            if (zzagp2 != null) {
                zzagq2 = zzagp2.zzf;
                if (zzagq2.zzc != l2) {
                    zzagp2.zzf = zzagq2.zzb(l2);
                }
            }
            zzagp2 = zzs2;
            zzs2 = object;
            object = zzagp2;
        }
        if (!bl) return this.zzu.zzc(zzhf2, l, l2, l3, this.zzZ(), zzs2, zzka2, (List)object);
        this.zzv.zzd(n);
        return this.zzu.zzc(zzhf2, l, l2, l3, this.zzZ(), zzs2, zzka2, (List)object);
    }

    private final void zzW() throws zzaeg {
        this.zzX(new boolean[2]);
    }

    private final void zzX(boolean[] blArray) throws zzaeg {
        int n;
        zzagp zzagp2 = this.zzr.zzi();
        zzka zzka2 = zzagp2.zzq();
        for (n = 0; n < 2; ++n) {
            if (zzka2.zza(n) || !this.zzb.remove(this.zza[n])) continue;
            this.zza[n].zzas();
        }
        n = 0;
        while (true) {
            if (n >= 2) {
                zzagp2.zzg = true;
                return;
            }
            if (zzka2.zza(n)) {
                boolean bl = blArray[n];
                zzahv zzahv2 = this.zza[n];
                if (!zzafp.zzaf(zzahv2)) {
                    zzagp zzagp3 = this.zzr.zzi();
                    boolean bl2 = zzagp3 == this.zzr.zzh();
                    zzafv[] zzafvArray = zzagp3.zzq();
                    zzahx zzahx2 = zzafvArray.zzb[n];
                    zzafvArray = zzafp.zzaj(zzafvArray.zzd[n]);
                    boolean bl3 = this.zzac() && this.zzu.zze == 3;
                    bl = !bl && bl3;
                    ++this.zzG;
                    this.zzb.add(zzahv2);
                    zzahv2.zzag(zzahx2, zzafvArray, zzagp3.zzc[n], this.zzI, bl, bl2, zzagp3.zzc(), zzagp3.zza());
                    zzahv2.zzE(11, (Object)new zzafh(this));
                    this.zzn.zzd(zzahv2);
                    if (bl3) {
                        zzahv2.zzah();
                    }
                }
            }
            ++n;
        }
    }

    private final void zzY(boolean bl) {
        zzagp zzagp2 = this.zzr.zzg();
        zzhf zzhf2 = zzagp2 == null ? this.zzu.zzb : zzagp2.zzf.zza;
        boolean bl2 = this.zzu.zzk.equals((Object)zzhf2) ^ true;
        if (bl2) {
            this.zzu = this.zzu.zzg(zzhf2);
        }
        zzhf2 = this.zzu;
        long l = zzagp2 == null ? zzhf2.zzs : zzagp2.zze();
        zzhf2.zzq = l;
        this.zzu.zzr = this.zzZ();
        if (!bl2) {
            if (!bl) return;
        }
        if (zzagp2 == null) return;
        if (!zzagp2.zzd) return;
        this.zzab(zzagp2.zzp(), zzagp2.zzq());
    }

    private final long zzZ() {
        return this.zzaa(this.zzu.zzq);
    }

    private final long zzaa(long l) {
        zzagp zzagp2 = this.zzr.zzg();
        if (zzagp2 != null) return Math.max(0L, l - (this.zzI - zzagp2.zza()));
        return 0L;
    }

    private final void zzab(zzs zzs2, zzka zzka2) {
        this.zzf.zzi(this.zza, zzs2, zzka2.zzd);
    }

    private final boolean zzac() {
        zzahd zzahd2 = this.zzu;
        if (!zzahd2.zzl) return false;
        if (zzahd2.zzm != 0) return false;
        return true;
    }

    private static boolean zzad(zzahd zzahd2, zzain zzain2) {
        zzhf zzhf2 = zzahd2.zzb;
        zzahd2 = zzahd2.zza;
        if (zzahd2.zzt()) return true;
        if (!zzahd2.zzy((Object)zzhf2.zza, (zzain)zzain2).zzf) return false;
        return true;
    }

    private static Pair<Object, Long> zzae(zzaiq zzaiq2, zzafo object, boolean bl, int n, boolean bl2, zzaip zzaip2, zzain zzain2) {
        block6: {
            Pair pair;
            zzaiq zzaiq3 = object.zza;
            if (zzaiq2.zzt()) {
                return null;
            }
            if (zzaiq3.zzt()) {
                zzaiq3 = zzaiq2;
            }
            try {
                pair = zzaiq3.zzv(zzaip2, zzain2, object.zzb, object.zzc);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                break block6;
            }
            if (zzaiq2.equals((Object)zzaiq3)) {
                return pair;
            }
            if (zzaiq2.zzi(pair.first) != -1) {
                if (!zzaiq3.zzy((Object)pair.first, (zzain)zzain2).zzf) return pair;
                if (zzaiq3.zzf((int)zzain2.zzc, (zzaip)zzaip2, (long)0L).zzn != zzaiq3.zzi(pair.first)) return pair;
                return zzaiq2.zzv(zzaip2, zzain2, zzaiq2.zzy((Object)pair.first, (zzain)zzain2).zzc, object.zzc);
            }
            object = zzafp.zzm(zzaip2, zzain2, n, bl2, pair.first, zzaiq3, zzaiq2);
            if (object == null) return null;
            return zzaiq2.zzv(zzaip2, zzain2, zzaiq2.zzy((Object)object, (zzain)zzain2).zzc, -9223372036854775807L);
        }
        return null;
    }

    private static boolean zzaf(zzahv zzahv2) {
        if (zzahv2.zzaf() == 0) return false;
        return true;
    }

    private static final void zzag(zzahs zzahs2) throws zzaeg {
        zzahs2.zzh();
        try {
            zzahs2.zza().zzE(zzahs2.zzc(), zzahs2.zze());
            return;
        }
        finally {
            zzahs2.zzi(true);
        }
    }

    private static final void zzah(zzahv zzahv2) throws zzaeg {
        if (zzahv2.zzaf() != 2) return;
        zzahv2.zzaq();
    }

    private static final void zzai(zzahv zzahv2, long l) {
        zzahv2.zzam();
        if (!(zzahv2 instanceof zzaks)) {
            return;
        }
        zzahv2 = (zzaks)zzahv2;
        throw null;
    }

    private static zzafv[] zzaj(zzjg zzjg2) {
        int n = 0;
        int n2 = zzjg2 != null ? zzjg2.zzc() : 0;
        zzafv[] zzafvArray = new zzafv[n2];
        while (n < n2) {
            zzafvArray[n] = zzjg2.zzd(n);
            ++n;
        }
        return zzafvArray;
    }

    static /* synthetic */ zzalg zzc(zzafp zzafp2) {
        return zzafp2.zzh;
    }

    static /* synthetic */ boolean zzd(zzafp zzafp2, boolean bl) {
        zzafp2.zzE = true;
        return true;
    }

    static Object zzm(zzaip zzaip2, zzain zzain2, int n, boolean bl, Object object, zzaiq zzaiq2, zzaiq zzaiq3) {
        int n2;
        int n3 = zzaiq2.zzi(object);
        int n4 = zzaiq2.zzg();
        int n5 = 0;
        int n6 = -1;
        while (true) {
            n2 = n6;
            if (n5 >= n4) break;
            n2 = n6;
            if (n6 != -1) break;
            if ((n3 = zzaiq2.zzu(n3, zzain2, zzaip2, n, bl)) == -1) {
                n2 = -1;
                break;
            }
            n6 = zzaiq3.zzi(zzaiq2.zzj(n3));
            ++n5;
        }
        if (n2 != -1) return zzaiq3.zzj(n2);
        return null;
    }

    static final /* synthetic */ void zzr(zzahs zzahs2) {
        try {
            zzafp.zzag(zzahs2);
            return;
        }
        catch (zzaeg zzaeg2) {
            zzaln.zzb((String)"ExoPlayerImplInternal", (String)"Unexpected error delivering message on external thread.", (Throwable)zzaeg2);
            throw new RuntimeException(zzaeg2);
        }
    }

    private final void zzs(IOException throwable, int n) {
        zzaeg zzaeg2 = zzaeg.zza((IOException)throwable, (int)n);
        zzagp zzagp2 = this.zzr.zzh();
        throwable = zzaeg2;
        if (zzagp2 != null) {
            throwable = zzaeg2.zzd((zzo)zzagp2.zzf.zza);
        }
        zzaln.zzb((String)"ExoPlayerImplInternal", (String)"Playback error", (Throwable)throwable);
        this.zzH(false, false);
        this.zzu = this.zzu.zzf((zzaeg)throwable);
    }

    private final void zzt(zzfmj<Boolean> zzfmj2, long l) {
        synchronized (this) {
            try {
                boolean bl;
                long l2 = SystemClock.elapsedRealtime();
                l = 500L;
                boolean bl2 = false;
                while (!(bl = ((Boolean)zzfmj2.zza()).booleanValue()) && l > 0L) {
                    try {
                        this.wait(l);
                    }
                    catch (InterruptedException interruptedException) {
                        bl2 = true;
                    }
                    l = l2 + 500L - SystemClock.elapsedRealtime();
                }
                if (!bl2) return;
                Thread.currentThread().interrupt();
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private final void zzu(int n) {
        zzahd zzahd2 = this.zzu;
        if (zzahd2.zze == n) return;
        this.zzu = zzahd2.zze(n);
    }

    private final void zzv() {
        this.zzv.zzc(this.zzu);
        if (!zzafm.zza((zzafm)this.zzv)) return;
        this.zzq.zza(this.zzv);
        this.zzv = new zzafm(this.zzu);
    }

    private final void zzw(boolean bl, int n, boolean n2, int n3) throws zzaeg {
        this.zzv.zzb(n2);
        this.zzv.zze(n3);
        this.zzu = this.zzu.zzh(bl, n);
        this.zzz = false;
        for (zzagp zzagp2 = this.zzr.zzh(); zzagp2 != null; zzagp2 = zzagp2.zzo()) {
            for (zzjg zzjg2 : zzagp2.zzq().zzd) {
            }
        }
        if (!this.zzac()) {
            this.zzz();
            this.zzA();
            return;
        }
        n = this.zzu.zze;
        if (n == 3) {
            this.zzy();
            this.zzh.zzf(2);
            return;
        }
        if (n != 2) return;
        this.zzh.zzf(2);
    }

    private final void zzx(boolean bl) throws zzaeg {
        zzhf zzhf2 = this.zzr.zzh().zzf.zza;
        long l = this.zzF(zzhf2, this.zzu.zzs, true, false);
        if (l == this.zzu.zzs) return;
        zzahd zzahd2 = this.zzu;
        this.zzu = this.zzV(zzhf2, l, zzahd2.zzc, zzahd2.zzd, bl, 5);
    }

    private final void zzy() throws zzaeg {
        int n = 0;
        this.zzz = false;
        this.zzn.zza();
        zzahv[] zzahvArray = this.zza;
        while (n < 2) {
            zzahv zzahv2 = zzahvArray[n];
            if (zzafp.zzaf(zzahv2)) {
                zzahv2.zzah();
            }
            ++n;
        }
    }

    private final void zzz() throws zzaeg {
        this.zzn.zzb();
        zzahv[] zzahvArray = this.zza;
        int n = 0;
        while (n < 2) {
            zzahv zzahv2 = zzahvArray[n];
            if (zzafp.zzaf(zzahv2)) {
                zzafp.zzah(zzahv2);
            }
            ++n;
        }
    }

    /*
     * Exception decompiling
     */
    public final boolean handleMessage(Message var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final void zza() {
        this.zzh.zzf(10);
    }

    public final void zzb(zzahf zzahf2) {
        this.zzh.zzc(16, (Object)zzahf2).zza();
    }

    public final void zze() {
        this.zzh.zzb(0).zza();
    }

    public final void zzf(boolean bl, int n) {
        this.zzh.zzd(1, bl ? 1 : 0, n).zza();
    }

    public final void zzg(zzaiq zzaiq2, int n, long l) {
        this.zzh.zzc(3, (Object)new zzafo(zzaiq2, n, l)).zza();
    }

    public final void zzh() {
        this.zzh.zzb(6).zza();
    }

    public final void zzi(zzahs zzahs2) {
        synchronized (this) {
            if (!this.zzw && this.zzi.isAlive()) {
                this.zzh.zzc(14, (Object)zzahs2).zza();
                return;
            }
            Log.w((String)"ExoPlayerImplInternal", (String)"Ignoring messages sent after release.");
            zzahs2.zzi(false);
            return;
        }
    }

    public final boolean zzj() {
        synchronized (this) {
            if (this.zzw) return true;
            if (!this.zzi.isAlive()) {
                return true;
            }
            this.zzh.zzf(7);
            zzaff zzaff2 = new zzaff(this);
            this.zzt((zzfmj<Boolean>)zzaff2, 500L);
            boolean bl = this.zzw;
            return bl;
        }
    }

    public final Looper zzk() {
        return this.zzj;
    }

    public final void zzl() {
        this.zzh.zzf(22);
    }

    public final void zzn(zzhe zzhe2) {
        this.zzh.zzc(8, (Object)zzhe2).zza();
    }

    final /* synthetic */ Boolean zzo() {
        return this.zzw;
    }

    public final void zzq(List<zzagx> list, int n, long l, zzix zzix2) {
        this.zzh.zzc(17, (Object)new zzafi(list, zzix2, n, l, null, null)).zza();
    }
}
