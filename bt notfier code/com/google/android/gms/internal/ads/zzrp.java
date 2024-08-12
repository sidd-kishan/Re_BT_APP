/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzakk
 *  com.google.android.gms.internal.ads.zzakn
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzalw
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zznd
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoj
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzou
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzqv
 *  com.google.android.gms.internal.ads.zzqw
 *  com.google.android.gms.internal.ads.zzre
 *  com.google.android.gms.internal.ads.zzrl
 *  com.google.android.gms.internal.ads.zzrm
 *  com.google.android.gms.internal.ads.zzrn
 *  com.google.android.gms.internal.ads.zzro
 *  com.google.android.gms.internal.ads.zzrs
 *  com.google.android.gms.internal.ads.zzrt
 *  com.google.android.gms.internal.ads.zzru
 *  com.google.android.gms.internal.ads.zzrx
 */
package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzakk;
import com.google.android.gms.internal.ads.zzakn;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzalw;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zznd;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoj;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzou;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzqv;
import com.google.android.gms.internal.ads.zzqw;
import com.google.android.gms.internal.ads.zzre;
import com.google.android.gms.internal.ads.zzrl;
import com.google.android.gms.internal.ads.zzrm;
import com.google.android.gms.internal.ads.zzrn;
import com.google.android.gms.internal.ads.zzro;
import com.google.android.gms.internal.ads.zzrs;
import com.google.android.gms.internal.ads.zzrt;
import com.google.android.gms.internal.ads.zzru;
import com.google.android.gms.internal.ads.zzrx;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public final class zzrp
implements zznu,
zzot {
    public static final zzoa zza = zzrn.zza;
    private final zzamf zzb;
    private final zzamf zzc;
    private final zzamf zzd;
    private final zzamf zze;
    private final ArrayDeque<zzqv> zzf;
    private final zzrs zzg = new zzrs();
    private final List<zzaiu> zzh = new ArrayList<zzaiu>();
    private int zzi = 0;
    private int zzj;
    private long zzk;
    private int zzl;
    private zzamf zzm;
    private int zzn = -1;
    private int zzo;
    private int zzp;
    private int zzq;
    private zznx zzr;
    private zzro[] zzs;
    private long[][] zzt;
    private int zzu;
    private long zzv;
    private int zzw;
    private zzakn zzx;

    public zzrp() {
        this(0);
    }

    public zzrp(int n) {
        this.zze = new zzamf(16);
        this.zzf = new ArrayDeque();
        this.zzb = new zzamf(zzalw.zza);
        this.zzc = new zzamf(4);
        this.zzd = new zzamf();
    }

    private final void zzh() {
        this.zzi = 0;
        this.zzl = 0;
    }

    private final void zzi(long l) throws zzaha {
        zzrp zzrp2 = this;
        while (!zzrp2.zzf.isEmpty() && zzrp2.zzf.peek().zza == l) {
            Object object;
            Object object2;
            Object object3;
            long l2;
            Object object4;
            zzrp zzrp3;
            zzoj zzoj2;
            boolean bl;
            Object object5;
            Object object6 = zzrp2.zzf.pop();
            if (object6.zzd == 1836019574) {
                object5 = new ArrayList();
                bl = zzrp2.zzw == 1;
                zzoj2 = new zzoj();
                zzrp3 = object6.zzc(1969517665);
                if (zzrp3 != null) {
                    object4 = zzre.zzb((zzqw)zzrp3);
                    zzrp3 = (zzaiv)object4.first;
                    object4 = (zzaiv)object4.second;
                    if (zzrp3 != null) {
                        zzoj2.zza((zzaiv)zzrp3);
                    }
                } else {
                    object4 = null;
                    zzrp3 = null;
                }
            } else {
                zzrp2 = zzrp3 = zzrp2;
                if (zzrp3.zzf.isEmpty()) continue;
                zzrp3.zzf.peek().zzb(object6);
                zzrp2 = zzrp3;
                continue;
            }
            Object object7 = object6.zzd(1835365473);
            object7 = object7 != null ? zzre.zzc((zzqv)object7) : null;
            object6 = zzre.zza((zzqv)object6, (zzoj)zzoj2, (long)-9223372036854775807L, null, (boolean)false, (boolean)bl, (zzfln)zzrm.zza);
            zznx zznx2 = zzrp2.zzr;
            if (zznx2 == null) throw null;
            int n = object6.size();
            long l3 = -9223372036854775807L;
            int n2 = 0;
            Object object8 = -1;
            while (true) {
                block26: {
                    zzaft zzaft2;
                    zzro zzro2;
                    zzru zzru2;
                    block28: {
                        zzaiv zzaiv2;
                        block29: {
                            block25: {
                                block27: {
                                    l2 = 0L;
                                    if (n2 >= n) break block25;
                                    object3 = (zzrx)object6.get(n2);
                                    if (object3.zzb == 0) break block26;
                                    zzru2 = object3.zza;
                                    l2 = zzru2.zze;
                                    if (l2 == -9223372036854775807L) {
                                        l2 = object3.zzh;
                                    }
                                    l3 = Math.max(l3, l2);
                                    zzro2 = new zzro(zzru2, object3, zznx2.zzB(n2, zzru2.zzb));
                                    object2 = object3.zze;
                                    zzaft2 = zzru2.zzf.zza();
                                    zzaft2.zzO(object2 + 30);
                                    if (zzru2.zzb == 2 && l2 > 0L && (object2 = object3.zzb) > 1) {
                                        zzaft2.zzU((float)object2 / ((float)l2 / 1000000.0f));
                                    }
                                    int n3 = zzru2.zzb;
                                    object2 = zzrl.zzb;
                                    if (n3 == 1 && zzoj2.zzb()) {
                                        zzaft2.zzad(zzoj2.zza);
                                        zzaft2.zzae(zzoj2.zzb);
                                    }
                                    object2 = zzru2.zzb;
                                    object3 = this;
                                    object = object3.zzh.isEmpty() ? null : new zzaiv(object3.zzh);
                                    zzaiv2 = new zzaiv(new zzaiu[0]);
                                    if (object2 != 1) break block27;
                                    zzrp2 = zzaiv2;
                                    if (zzrp3 != null) {
                                        zzrp2 = zzrp3;
                                    }
                                    break block28;
                                }
                                zzrp2 = zzaiv2;
                                if (object2 != 2) break block28;
                                zzrp2 = zzaiv2;
                                if (object7 == null) break block28;
                                break block29;
                            }
                            zzrp2.zzu = object8;
                            zzrp2.zzv = l3;
                            object = object5.toArray(new zzro[0]);
                            zzrp2.zzs = object;
                            object8 = ((zzro[])object).length;
                            object6 = new long[object8][];
                            object3 = new int[object8];
                            object4 = new long[object8];
                            object5 = new boolean[object8];
                            for (object8 = 0; object8 < ((zzro[])object).length; ++object8) {
                                object6[object8] = (zzqv)new long[object[object8].zzb.zzb];
                                object4[object8] = (Pair)object[object8].zzb.zzf[0];
                            }
                            object2 = 0;
                            l3 = l2;
                            break;
                        }
                        object2 = 0;
                        while (true) {
                            zzrp2 = zzaiv2;
                            if (object2 >= object7.zza()) break;
                            zzrp2 = object7.zzb(object2);
                            if (zzrp2 instanceof zzakk) {
                                zzrp2 = (zzakk)zzrp2;
                                if ("com.android.capture.fps".equals(((zzakk)zzrp2).zza)) {
                                    zzrp2 = new zzaiv(new zzaiu[]{zzrp2});
                                    break;
                                }
                            }
                            ++object2;
                        }
                    }
                    for (object2 = 0; object2 < 2; zzrp2 = zzrp2.zzc((new zzaiv[]{object4, object})[object2]), ++object2) {
                    }
                    if (zzrp2.zza() > 0) {
                        zzaft2.zzL((zzaiv)zzrp2);
                    }
                    zzro2.zzc.zzs(zzaft2.zzah());
                    if (zzru2.zzb == 2) {
                        object2 = object8;
                        if (object8 == -1) {
                            object2 = object5.size();
                        }
                    } else {
                        object2 = object8;
                    }
                    object5.add(zzro2);
                    object8 = object2;
                    zzrp2 = object3;
                }
                ++n2;
            }
            while (object2 < ((zzro[])object).length) {
                l2 = Long.MAX_VALUE;
                n = -1;
                for (object8 = 0; object8 < ((zzro[])object).length; ++object8) {
                    Object object9 = l2;
                    n2 = n;
                    if (object5[object8] == false) {
                        Pair pair = object4[object8];
                        object9 = l2;
                        n2 = n;
                        if (pair <= l2) {
                            n2 = object8;
                            object9 = pair;
                        }
                    }
                    l2 = object9;
                    n = n2;
                }
                object8 = object3[n];
                zzrp3 = object6[n];
                zzrp3[object8] = (zzrp)l3;
                object7 = object[n].zzb;
                l3 += (long)object7.zzd[object8];
                object3[n] = (zzrx)(++object8);
                if (object8 < ((zzrp)zzrp3).length) {
                    object4[n] = (Pair)object7.zzf[object8];
                    continue;
                }
                object5[n] = true;
                ++object2;
            }
            zzrp2.zzt = (long[][])object6;
            zznx2.zzC();
            zznx2.zzD((zzot)zzrp2);
            zzrp2.zzf.clear();
            zzrp2.zzi = 2;
        }
        if (zzrp2.zzi == 2) return;
        this.zzh();
    }

    private static long zzj(zzrx zzrx2, long l, long l2) {
        int n = zzrp.zzk(zzrx2, l);
        if (n != -1) return Math.min(zzrx2.zzc[n], l2);
        return l2;
    }

    private static int zzk(zzrx zzrx2, long l) {
        int n = zzrx2.zza(l);
        if (n != -1) return n;
        return zzrx2.zzb(l);
    }

    private static int zzl(int n) {
        if (n == 1751476579) return 2;
        if (n == 1903435808) return 1;
        return 0;
    }

    public final boolean zza(zznv zznv2) throws IOException {
        return zzrt.zzb((zznv)zznv2, (boolean)false);
    }

    public final void zzb(zznx zznx2) {
        this.zzr = zznx2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final int zzc(zznv var1_1, zzoq var2_2) throws IOException {
        block52: {
            block44: {
                block54: {
                    block53: {
                        block42: {
                            while (true) {
                                block45: {
                                    block46: {
                                        var3_4 = this.zzi;
                                        var11_6 = -1;
                                        if (var3_4 == 0) break block45;
                                        if (var3_4 != 1) {
                                            var26_11 = var1_1.zzn();
                                            if (this.zzn == -1) {
                                                var18_12 = 0x7FFFFFFFFFFFFFFFL;
                                                var14_10 = var12_7 = 0x7FFFFFFFFFFFFFFFL;
                                                var4_5 = -1;
                                                var8_13 = 1;
                                                var7_14 = 1;
                                                var6_15 = -1;
                                                break;
                                            }
                                            break block42;
                                        }
                                        var12_7 = this.zzk - (long)this.zzl;
                                        var14_10 = var1_1.zzn();
                                        var29_9 = this.zzm;
                                        if (var29_9 == null) break block46;
                                        var1_1.zzb(var29_9.zzi(), this.zzl, (int)var12_7);
                                        if (this.zzj == 1718909296) {
                                            block43: {
                                                var29_9.zzh(8);
                                                var3_4 = zzrp.zzl(var29_9.zzv());
                                                if (var3_4 == 0) {
                                                    var29_9.zzk(4);
                                                    while (var29_9.zzd() > 0) {
                                                        var3_4 = zzrp.zzl(var29_9.zzv());
                                                        if (var3_4 == 0) continue;
                                                        break block43;
                                                    }
                                                    var3_4 = 0;
                                                }
                                            }
                                            this.zzw = var3_4;
                                        } else if (!this.zzf.isEmpty()) {
                                            this.zzf.peek().zza(new zzqw(this.zzj, var29_9));
                                        }
                                        ** GOTO lbl40
                                    }
                                    if (var12_7 < 262144L) {
                                        var1_1.zze((int)var12_7);
lbl40:
                                        // 3 sources

                                        var3_4 = 0;
                                    } else {
                                        var2_2 /* !! */ .zza = var1_1.zzn() + var12_7;
                                        var3_4 = 1;
                                    }
                                    this.zzi(var14_10 + var12_7);
                                    if (var3_4 == 0 || this.zzi == 2) continue;
                                    return 1;
                                }
                                if (this.zzl == 0) {
                                    if (!var1_1.zza(this.zze.zzi(), 0, 8, true)) {
                                        return -1;
                                    }
                                    this.zzl = 8;
                                    this.zze.zzh(0);
                                    this.zzk = this.zze.zzt();
                                    this.zzj = this.zze.zzv();
                                }
                                if ((var12_7 = this.zzk) == 1L) {
                                    var1_1.zzb(this.zze.zzi(), 8, 8);
                                    this.zzl += 8;
                                    this.zzk = this.zze.zzD();
                                } else if (var12_7 == 0L) {
                                    var12_7 = var14_10 = var1_1.zzo();
                                    if (var14_10 == -1L) {
                                        var29_9 = this.zzf.peek();
                                        var12_7 = var14_10;
                                        if (var29_9 != null) {
                                            var12_7 = var29_9.zza;
                                        }
                                    }
                                    if (var12_7 != -1L) {
                                        this.zzk = var12_7 - var1_1.zzn() + (long)this.zzl;
                                    }
                                }
                                var12_7 = this.zzk;
                                var4_5 = this.zzl;
                                if (var12_7 < (long)var4_5) {
                                    var1_1 = zzaha.zzc((String)"Atom size less than header length (unsupported).");
                                    throw var1_1;
                                }
                                var3_4 = this.zzj;
                                if (var3_4 != 1836019574 && var3_4 != 1953653099 && var3_4 != 1835297121 && var3_4 != 1835626086 && var3_4 != 1937007212 && var3_4 != 1701082227 && var3_4 != 1835365473) {
                                    if (var3_4 != 1835296868 && var3_4 != 1836476516 && var3_4 != 1751411826 && var3_4 != 1937011556 && var3_4 != 0x73747473 && var3_4 != 0x73747373 && var3_4 != 1668576371 && var3_4 != 1701606260 && var3_4 != 1937011555 && var3_4 != 1937011578 && var3_4 != 1937013298 && var3_4 != 1937007471 && var3_4 != 1668232756 && var3_4 != 1953196132 && var3_4 != 1718909296 && var3_4 != 1969517665 && var3_4 != 1801812339 && var3_4 != 1768715124) {
                                        var14_10 = var1_1.zzn();
                                        var12_7 = this.zzl;
                                        var14_10 -= var12_7;
                                        if (this.zzj == 1836086884) {
                                            this.zzx = new zzakn(0L, var14_10, -9223372036854775807L, var14_10 + var12_7, this.zzk - var12_7);
                                        }
                                        this.zzm = null;
                                        this.zzi = 1;
                                        continue;
                                    }
                                    var28_8 = var4_5 == 8;
                                    zzakt.zzd((boolean)var28_8);
                                    var28_8 = this.zzk <= 0x7FFFFFFFL;
                                    zzakt.zzd((boolean)var28_8);
                                    var29_9 = new zzamf((int)this.zzk);
                                    System.arraycopy(this.zze.zzi(), 0, var29_9.zzi(), 0, 8);
                                    this.zzm = var29_9;
                                    this.zzi = 1;
                                    continue;
                                }
                                var16_3 = var1_1.zzn();
                                var14_10 = this.zzk;
                                var12_7 = this.zzl;
                                var16_3 = var16_3 + var14_10 - var12_7;
                                if (var14_10 != var12_7 && this.zzj == 1835365473) {
                                    this.zzd.zza(8);
                                    var1_1.zzi(this.zzd.zzi(), 0, 8);
                                    zzre.zzd((zzamf)this.zzd);
                                    var1_1.zze(this.zzd.zzg());
                                    var1_1.zzl();
                                }
                                this.zzf.push(new zzqv(this.zzj, var16_3));
                                if (this.zzk == (long)this.zzl) {
                                    this.zzi(var16_3);
                                    continue;
                                }
                                this.zzh();
                            }
                            for (var3_4 = 0; var3_4 < ((zzro[])zzamq.zzd((Object)this.zzs)).length; ++var3_4) {
                                block48: {
                                    block51: {
                                        block50: {
                                            block49: {
                                                block47: {
                                                    var29_9 = this.zzs[var3_4];
                                                    var5_16 = var29_9.zzd;
                                                    var29_9 = var29_9.zzb;
                                                    if (var5_16 != var29_9.zzb) break block47;
                                                    var10_18 = var4_5;
                                                    var24_21 = var18_12;
                                                    var20_19 = var12_7;
                                                    var9_17 = var7_14;
                                                    var22_20 = var14_10;
                                                    break block48;
                                                }
                                                var20_19 = var29_9.zzc[var5_16];
                                                var16_3 = ((long[][])zzamq.zzd((Object)this.zzt))[var3_4][var5_16];
                                                var5_16 = (var20_19 -= var26_11) >= 0L && var20_19 < 262144L ? 0 : 1;
                                                if (var5_16 != 0) break block49;
                                                if (var7_14 != 0) break block50;
                                                var7_14 = 0;
                                            }
                                            if (var5_16 != var7_14 || var20_19 >= var12_7) break block51;
                                        }
                                        var4_5 = var3_4;
                                        var7_14 = var5_16;
                                        var12_7 = var20_19;
                                        var14_10 = var16_3;
                                    }
                                    var10_18 = var4_5;
                                    var24_21 = var18_12;
                                    var20_19 = var12_7;
                                    var9_17 = var7_14;
                                    var22_20 = var14_10;
                                    if (var16_3 < var18_12) {
                                        var6_15 = var3_4;
                                        var22_20 = var14_10;
                                        var9_17 = var7_14;
                                        var20_19 = var12_7;
                                        var24_21 = var16_3;
                                        var8_13 = var5_16;
                                        var10_18 = var4_5;
                                    }
                                }
                                var4_5 = var10_18;
                                var18_12 = var24_21;
                                var12_7 = var20_19;
                                var7_14 = var9_17;
                                var14_10 = var22_20;
                            }
                            var3_4 = var4_5;
                            if (var18_12 != 0x7FFFFFFFFFFFFFFFL) {
                                var3_4 = var4_5;
                                if (var8_13 != 0) {
                                    var3_4 = var14_10 < var18_12 + 0xA00000L ? var4_5 : var6_15;
                                }
                            }
                            this.zzn = var3_4;
                            if (var3_4 != -1) break block42;
                            var3_4 = var11_6;
                            break block52;
                        }
                        var29_9 = ((zzro[])zzamq.zzd((Object)this.zzs))[this.zzn];
                        var30_22 = var29_9.zzc;
                        var6_15 = var29_9.zzd;
                        var31_23 = var29_9.zzb;
                        var14_10 = var31_23.zzc[var6_15];
                        var3_4 = var31_23.zzd[var6_15];
                        var12_7 = var14_10 - var26_11 + (long)this.zzo;
                        if (var12_7 < 0L || var12_7 >= 262144L) break block53;
                        if (var29_9.zza.zzg == 1) {
                            var3_4 -= 8;
                            var12_7 += 8L;
                        }
                        var1_1.zze((int)var12_7);
                        var2_2 /* !! */  = var29_9.zza;
                        if (var2_2 /* !! */ .zzj == 0) {
                            var4_5 = var3_4;
                            if ("audio/ac4".equals(var2_2 /* !! */ .zzf.zzl)) {
                                if (this.zzp == 0) {
                                    zznd.zzb((int)var3_4, (zzamf)this.zzd);
                                    zzov.zzb((zzox)var30_22, (zzamf)this.zzd, (int)7);
                                    this.zzp += 7;
                                }
                                var4_5 = var3_4 + 7;
                            }
                            while (true) {
                                var3_4 = this.zzp;
                                var5_16 = var4_5;
                                if (var3_4 < var4_5) {
                                    var3_4 = zzov.zza((zzox)var30_22, (zzah)var1_1, (int)(var4_5 - var3_4), (boolean)false);
                                    this.zzo += var3_4;
                                    this.zzp += var3_4;
                                    this.zzq -= var3_4;
                                    continue;
                                }
                                break block44;
                                break;
                            }
                        }
                        break block54;
                    }
                    var2_2 /* !! */ .zza = var14_10;
                    var3_4 = 1;
                    break block52;
                }
                var2_2 /* !! */  = (zzoq)this.zzc.zzi();
                var2_2 /* !! */ [0] = (zzoq)false;
                var2_2 /* !! */ [1] = (zzoq)false;
                var2_2 /* !! */ [2] = (zzoq)false;
                var7_14 = var29_9.zza.zzj;
                var4_5 = 4 - var7_14;
                while (true) {
                    var5_16 = var3_4;
                    if (this.zzp >= var3_4) break;
                    var5_16 = this.zzq;
                    if (var5_16 == 0) {
                        var1_1.zzb((byte[])var2_2 /* !! */ , var4_5, var7_14);
                        this.zzo += var7_14;
                        this.zzc.zzh(0);
                        var5_16 = this.zzc.zzv();
                        if (var5_16 < 0) throw zzaha.zzb((String)"Invalid NAL length", null);
                        this.zzq = var5_16;
                        this.zzb.zzh(0);
                        zzov.zzb((zzox)var30_22, (zzamf)this.zzb, (int)4);
                        this.zzp += 4;
                        var3_4 += var4_5;
                        continue;
                    }
                    var5_16 = zzov.zza((zzox)var30_22, (zzah)var1_1, (int)var5_16, (boolean)false);
                    this.zzo += var5_16;
                    this.zzp += var5_16;
                    this.zzq -= var5_16;
                }
            }
            var1_1 = var29_9.zzb;
            var30_22.zzv(var1_1.zzf[var6_15], var1_1.zzg[var6_15], var5_16, 0, null);
            ++var29_9.zzd;
            this.zzn = -1;
            this.zzo = 0;
            this.zzp = 0;
            this.zzq = 0;
            var3_4 = 0;
        }
        return var3_4;
    }

    public final void zzd(long l, long l2) {
        this.zzf.clear();
        int n = 0;
        this.zzl = 0;
        this.zzn = -1;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        if (l == 0L) {
            this.zzh();
            return;
        }
        zzro[] zzroArray = this.zzs;
        if (zzroArray == null) return;
        int n2 = zzroArray.length;
        while (n < n2) {
            int n3;
            zzro zzro2 = zzroArray[n];
            zzrx zzrx2 = zzro2.zzb;
            int n4 = n3 = zzrx2.zza(l2);
            if (n3 == -1) {
                n4 = zzrx2.zzb(l2);
            }
            zzro2.zzd = n4;
            ++n;
        }
    }

    public final boolean zze() {
        return true;
    }

    public final zzor zzf(long l) {
        long l2;
        long l3;
        long l4;
        zzou zzou2 = this.zzs;
        if (zzou2 == null) throw null;
        if (((zzro[])zzou2).length == 0) {
            zzou2 = zzou.zza;
            return new zzor(zzou2, zzou2);
        }
        int n = this.zzu;
        long l5 = -1L;
        if (n != -1) {
            zzou2 = zzou2[n].zzb;
            int n2 = zzrp.zzk((zzrx)zzou2, l);
            if (n2 == -1) {
                zzou2 = zzou.zza;
                return new zzor(zzou2, zzou2);
            }
            l4 = zzou2.zzf[n2];
            l3 = zzou2.zzc[n2];
            if (l4 < l && n2 < zzou2.zzb - 1 && (n = zzou2.zzb(l)) != -1 && n != n2) {
                l2 = zzou2.zzf[n];
                l = zzou2.zzc[n];
            } else {
                l2 = -9223372036854775807L;
                l = l5;
            }
            l5 = l2;
            l2 = l3;
        } else {
            l2 = Long.MAX_VALUE;
            l3 = -9223372036854775807L;
            l4 = l;
            l = l5;
            l5 = l3;
        }
        n = 0;
        while (true) {
            if (n >= ((zzro[])(zzou2 = this.zzs)).length) {
                zzou2 = new zzou(l4, l2);
                if (l5 != -9223372036854775807L) return new zzor(zzou2, new zzou(l5, l));
                return new zzor(zzou2, zzou2);
            }
            long l6 = l;
            l3 = l2;
            if (n != this.zzu) {
                zzou2 = zzou2[n].zzb;
                l3 = zzrp.zzj((zzrx)zzou2, l4, l2);
                l2 = l;
                if (l5 != -9223372036854775807L) {
                    l2 = zzrp.zzj((zzrx)zzou2, l5, l);
                }
                l6 = l2;
            }
            ++n;
            l = l6;
            l2 = l3;
        }
    }

    public final long zzg() {
        return this.zzv;
    }
}
