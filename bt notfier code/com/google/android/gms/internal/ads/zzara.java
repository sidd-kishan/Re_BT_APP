/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzanp
 *  com.google.android.gms.internal.ads.zzapn
 *  com.google.android.gms.internal.ads.zzapo
 *  com.google.android.gms.internal.ads.zzapp
 *  com.google.android.gms.internal.ads.zzapq
 *  com.google.android.gms.internal.ads.zzaps
 *  com.google.android.gms.internal.ads.zzapt
 *  com.google.android.gms.internal.ads.zzapv
 *  com.google.android.gms.internal.ads.zzaqi
 *  com.google.android.gms.internal.ads.zzaqj
 *  com.google.android.gms.internal.ads.zzaqk
 *  com.google.android.gms.internal.ads.zzaqr
 *  com.google.android.gms.internal.ads.zzaqy
 *  com.google.android.gms.internal.ads.zzaqz
 *  com.google.android.gms.internal.ads.zzarb
 *  com.google.android.gms.internal.ads.zzarc
 *  com.google.android.gms.internal.ads.zzarf
 *  com.google.android.gms.internal.ads.zzaru
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzauv
 *  com.google.android.gms.internal.ads.zzaux
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzanp;
import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzapo;
import com.google.android.gms.internal.ads.zzapp;
import com.google.android.gms.internal.ads.zzapq;
import com.google.android.gms.internal.ads.zzaps;
import com.google.android.gms.internal.ads.zzapt;
import com.google.android.gms.internal.ads.zzapv;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzaqj;
import com.google.android.gms.internal.ads.zzaqk;
import com.google.android.gms.internal.ads.zzaqr;
import com.google.android.gms.internal.ads.zzaqy;
import com.google.android.gms.internal.ads.zzaqz;
import com.google.android.gms.internal.ads.zzarb;
import com.google.android.gms.internal.ads.zzarc;
import com.google.android.gms.internal.ads.zzarf;
import com.google.android.gms.internal.ads.zzaru;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzauv;
import com.google.android.gms.internal.ads.zzaux;
import com.google.android.gms.internal.ads.zzave;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public final class zzara
implements zzapo,
zzapv {
    public static final zzapq zza = new zzaqy();
    private static final int zzb = zzave.zzl((String)"qt  ");
    private final zzaux zzc;
    private final zzaux zzd;
    private final zzaux zze = new zzaux(16);
    private final Stack<zzaqi> zzf = new Stack();
    private int zzg;
    private int zzh;
    private long zzi;
    private int zzj;
    private zzaux zzk;
    private int zzl;
    private int zzm;
    private zzapp zzn;
    private zzaqz[] zzo;
    private long zzp;
    private boolean zzq;

    public zzara() {
        this.zzc = new zzaux(zzauv.zza);
        this.zzd = new zzaux(4);
    }

    private final void zzh() {
        this.zzg = 0;
        this.zzj = 0;
    }

    private final void zzi(long l) throws zzanp {
        while (!this.zzf.isEmpty() && this.zzf.peek().zza == l) {
            zzaqj zzaqj2;
            long l2;
            long l3;
            zzaru zzaru2;
            zzaqj zzaqj3;
            zzaps zzaps2;
            ArrayList<zzaqz> arrayList;
            zzaqi zzaqi2 = this.zzf.pop();
            if (zzaqi2.zzaR == zzaqk.zzE) {
                arrayList = new ArrayList<zzaqz>();
                zzaps2 = new zzaps();
                zzaqj3 = zzaqi2.zzc(zzaqk.zzaC);
                if (zzaqj3 != null) {
                    zzaru2 = zzaqr.zzc((zzaqj)zzaqj3, (boolean)this.zzq);
                    zzaqj3 = zzaru2;
                    if (zzaru2 != null) {
                        zzaps2.zza(zzaru2);
                        zzaqj3 = zzaru2;
                    }
                } else {
                    zzaqj3 = null;
                }
                l3 = -9223372036854775807L;
                l2 = Long.MAX_VALUE;
                zzaqj2 = zzaqj3;
            } else {
                if (this.zzf.isEmpty()) continue;
                this.zzf.peek().zzb(zzaqi2);
                continue;
            }
            for (int i = 0; i < zzaqi2.zzc.size(); ++i) {
                zzarc zzarc2;
                zzaqj3 = (zzaqi)zzaqi2.zzc.get(i);
                if (zzaqj3.zzaR != zzaqk.zzG || (zzarc2 = zzaqr.zza((zzaqi)zzaqj3, (zzaqj)zzaqi2.zzc(zzaqk.zzF), (long)-9223372036854775807L, null, (boolean)this.zzq)) == null) continue;
                zzarf zzarf2 = zzaqr.zzb((zzarc)zzarc2, (zzaqi)zzaqj3.zzd(zzaqk.zzH).zzd(zzaqk.zzI).zzd(zzaqk.zzJ), (zzaps)zzaps2);
                if (zzarf2.zza == 0) continue;
                zzaqz zzaqz2 = new zzaqz(zzarc2, zzarf2, this.zzn.zzbf(i, zzarc2.zzb));
                int n = zzarf2.zzd;
                zzanm zzanm2 = zzarc2.zzf.zzg(n + 30);
                zzaqj3 = zzanm2;
                if (zzarc2.zzb == 1) {
                    zzaru2 = zzanm2;
                    if (zzaps2.zzb()) {
                        zzaru2 = zzanm2.zzh(zzaps2.zzb, zzaps2.zzc);
                    }
                    zzaqj3 = zzaru2;
                    if (zzaqj2 != null) {
                        zzaqj3 = zzaru2.zzj((zzaru)zzaqj2);
                    }
                }
                zzaqz2.zzc.zza((zzanm)zzaqj3);
                l3 = Math.max(l3, zzarc2.zze);
                arrayList.add(zzaqz2);
                long l4 = zzarf2.zzb[0];
                if (l4 >= l2) continue;
                l2 = l4;
            }
            this.zzp = l3;
            this.zzo = arrayList.toArray(new zzaqz[arrayList.size()]);
            this.zzn.zzbg();
            this.zzn.zzc((zzapv)this);
            this.zzf.clear();
            this.zzg = 2;
        }
        if (this.zzg == 2) return;
        this.zzh();
    }

    public final boolean zza() {
        return true;
    }

    public final long zzb() {
        return this.zzp;
    }

    public final long zzc(long l) {
        zzaqz[] zzaqzArray = this.zzo;
        int n = zzaqzArray.length;
        long l2 = Long.MAX_VALUE;
        int n2 = 0;
        while (n2 < n) {
            int n3;
            zzarf zzarf2 = zzaqzArray[n2].zzb;
            int n4 = n3 = zzarf2.zza(l);
            if (n3 == -1) {
                n4 = zzarf2.zzb(l);
            }
            long l3 = zzarf2.zzb[n4];
            long l4 = l2;
            if (l3 < l2) {
                l4 = l3;
            }
            ++n2;
            l2 = l4;
        }
        return l2;
    }

    public final void zzd(zzapp zzapp2) {
        this.zzn = zzapp2;
    }

    public final void zze(long l, long l2) {
        this.zzf.clear();
        int n = 0;
        this.zzj = 0;
        this.zzl = 0;
        this.zzm = 0;
        if (l == 0L) {
            this.zzh();
            return;
        }
        zzaqz[] zzaqzArray = this.zzo;
        if (zzaqzArray == null) return;
        int n2 = zzaqzArray.length;
        while (n < n2) {
            int n3;
            zzaqz zzaqz2 = zzaqzArray[n];
            zzarf zzarf2 = zzaqz2.zzb;
            int n4 = n3 = zzarf2.zza(l2);
            if (n3 == -1) {
                n4 = zzarf2.zzb(l2);
            }
            zzaqz2.zzd = n4;
            ++n;
        }
    }

    public final boolean zzf(zzapn zzapn2) throws IOException, InterruptedException {
        return zzarb.zzb((zzapn)zzapn2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final int zzg(zzapn var1_1, zzapt var2_2) throws IOException, InterruptedException {
        block29: {
            block24: {
                block31: {
                    block30: {
                        block28: {
                            while (true) {
                                block25: {
                                    block26: {
                                        block27: {
                                            block23: {
                                                var3_3 = this.zzg;
                                                var5_4 = -1;
                                                if (var3_3 == 0) break block25;
                                                if (var3_3 != 1) {
                                                    var10_6 = 0x7FFFFFFFFFFFFFFFL;
                                                    var4_9 = -1;
                                                    break;
                                                }
                                                var8_5 = this.zzi - (long)this.zzj;
                                                var10_6 = var1_1.zzh();
                                                var15_8 = this.zzk;
                                                if (var15_8 == null) break block26;
                                                var1_1.zzb(var15_8.zza, this.zzj, (int)var8_5, false);
                                                if (this.zzh != zzaqk.zzd) break block27;
                                                var15_8 = this.zzk;
                                                var15_8.zzi(8);
                                                if (var15_8.zzr() == zzara.zzb) ** GOTO lbl22
                                                var15_8.zzj(4);
                                                while (var15_8.zzd() > 0) {
                                                    if (var15_8.zzr() != zzara.zzb) continue;
lbl22:
                                                    // 2 sources

                                                    var14_7 = true;
                                                    break block23;
                                                }
                                                var14_7 = false;
                                            }
                                            this.zzq = var14_7;
                                            ** GOTO lbl36
                                        }
                                        if (!this.zzf.isEmpty()) {
                                            this.zzf.peek().zza(new zzaqj(this.zzh, this.zzk));
                                        }
                                        ** GOTO lbl36
                                    }
                                    if (var8_5 < 262144L) {
                                        var1_1.zzd((int)var8_5, false);
lbl36:
                                        // 3 sources

                                        var3_3 = 0;
                                    } else {
                                        var2_2 /* !! */ .zza = var1_1.zzh() + var8_5;
                                        var3_3 = 1;
                                    }
                                    this.zzi(var10_6 + var8_5);
                                    if (var3_3 == 0 || this.zzg == 2) continue;
                                    return 1;
                                }
                                if (this.zzj == 0) {
                                    if (!var1_1.zzb(this.zze.zza, 0, 8, true)) {
                                        return -1;
                                    }
                                    this.zzj = 8;
                                    this.zze.zzi(0);
                                    this.zzi = this.zze.zzp();
                                    this.zzh = this.zze.zzr();
                                }
                                if (this.zzi == 1L) {
                                    var1_1.zzb(this.zze.zza, 8, 8, false);
                                    this.zzj += 8;
                                    this.zzi = this.zze.zzv();
                                }
                                if ((var3_3 = this.zzh) != zzaqk.zzE && var3_3 != zzaqk.zzG && var3_3 != zzaqk.zzH && var3_3 != zzaqk.zzI && var3_3 != zzaqk.zzJ && var3_3 != zzaqk.zzS) {
                                    var3_3 = this.zzh;
                                    if (var3_3 != zzaqk.zzU && var3_3 != zzaqk.zzF && var3_3 != zzaqk.zzV && var3_3 != zzaqk.zzW && var3_3 != zzaqk.zzao && var3_3 != zzaqk.zzap && var3_3 != zzaqk.zzaq && var3_3 != zzaqk.zzT && var3_3 != zzaqk.zzar && var3_3 != zzaqk.zzas && var3_3 != zzaqk.zzat && var3_3 != zzaqk.zzau && var3_3 != zzaqk.zzav && var3_3 != zzaqk.zzR && var3_3 != zzaqk.zzd && var3_3 != zzaqk.zzaC) {
                                        this.zzk = null;
                                    } else {
                                        var14_7 = this.zzj == 8;
                                        zzaup.zzd((boolean)var14_7);
                                        var14_7 = this.zzi <= 0x7FFFFFFFL;
                                        zzaup.zzd((boolean)var14_7);
                                        this.zzk = new zzaux((int)this.zzi);
                                        System.arraycopy(this.zze.zza, 0, this.zzk.zza, 0, 8);
                                    }
                                    this.zzg = 1;
                                    continue;
                                }
                                var8_5 = var1_1.zzh() + this.zzi - (long)this.zzj;
                                this.zzf.add(new zzaqi(this.zzh, var8_5));
                                if (this.zzi == (long)this.zzj) {
                                    this.zzi(var8_5);
                                    continue;
                                }
                                this.zzh();
                            }
                            for (var3_3 = 0; var3_3 < ((zzaqz[])(var15_8 = this.zzo)).length; ++var3_3) {
                                var15_8 = var15_8[var3_3];
                                var6_10 = var15_8.zzd;
                                var15_8 = var15_8.zzb;
                                if (var6_10 == var15_8.zza) {
                                    var8_5 = var10_6;
                                } else {
                                    var12_11 = var15_8.zzb[var6_10];
                                    var8_5 = var10_6;
                                    if (var12_11 < var10_6) {
                                        var4_9 = var3_3;
                                        var8_5 = var12_11;
                                    }
                                }
                                var10_6 = var8_5;
                            }
                            if (var4_9 != -1) break block28;
                            var3_3 = var5_4;
                            break block29;
                        }
                        var16_12 = var15_8[var4_9];
                        var15_8 = var16_12.zzc;
                        var5_4 = var16_12.zzd;
                        var17_13 = var16_12.zzb;
                        var10_6 = var17_13.zzb[var5_4];
                        var3_3 = var4_9 = var17_13.zzc[var5_4];
                        var8_5 = var10_6;
                        if (var16_12.zza.zzg == 1) {
                            var8_5 = var10_6 + 8L;
                            var3_3 = var4_9 - 8;
                        }
                        if ((var10_6 = var8_5 - var1_1.zzh() + (long)this.zzl) < 0L || var10_6 >= 262144L) break block30;
                        var1_1.zzd((int)var10_6, false);
                        var7_14 = var16_12.zza.zzk;
                        if (var7_14 == 0) {
                            while (true) {
                                var6_10 = this.zzl;
                                var4_9 = var3_3;
                                if (var6_10 < var3_3) {
                                    var4_9 = var15_8.zzd(var1_1, var3_3 - var6_10, false);
                                    this.zzl += var4_9;
                                    this.zzm -= var4_9;
                                    continue;
                                }
                                break block24;
                                break;
                            }
                        }
                        break block31;
                    }
                    var2_2 /* !! */ .zza = var8_5;
                    var3_3 = 1;
                    break block29;
                }
                var2_2 /* !! */  = (zzapt)this.zzd.zza;
                var2_2 /* !! */ [0] = (zzapt)false;
                var2_2 /* !! */ [1] = (zzapt)false;
                var2_2 /* !! */ [2] = (zzapt)false;
                var6_10 = 4 - var7_14;
                while (true) {
                    var4_9 = var3_3;
                    if (this.zzl >= var3_3) break;
                    var4_9 = this.zzm;
                    if (var4_9 == 0) {
                        var1_1.zzb(this.zzd.zza, var6_10, var7_14, false);
                        this.zzd.zzi(0);
                        this.zzm = this.zzd.zzu();
                        this.zzc.zzi(0);
                        var15_8.zzb(this.zzc, 4);
                        this.zzl += 4;
                        var3_3 += var6_10;
                        continue;
                    }
                    var4_9 = var15_8.zzd(var1_1, var4_9, false);
                    this.zzl += var4_9;
                    this.zzm -= var4_9;
                }
            }
            var1_1 = var16_12.zzb;
            var15_8.zzc(var1_1.zze[var5_4], var1_1.zzf[var5_4], var4_9, 0, null);
            ++var16_12.zzd;
            this.zzl = 0;
            this.zzm = 0;
            var3_3 = 0;
        }
        return var3_3;
    }
}
