/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzadu
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzadz
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzaeh
 *  com.google.android.gms.internal.ads.zzaej
 *  com.google.android.gms.internal.ads.zzaek
 *  com.google.android.gms.internal.ads.zzael
 *  com.google.android.gms.internal.ads.zzaem
 *  com.google.android.gms.internal.ads.zzaen
 *  com.google.android.gms.internal.ads.zzaeo
 *  com.google.android.gms.internal.ads.zzaep
 *  com.google.android.gms.internal.ads.zzaeq
 *  com.google.android.gms.internal.ads.zzaer
 *  com.google.android.gms.internal.ads.zzaes
 *  com.google.android.gms.internal.ads.zzaet
 *  com.google.android.gms.internal.ads.zzaeu
 *  com.google.android.gms.internal.ads.zzaev
 *  com.google.android.gms.internal.ads.zzaew
 *  com.google.android.gms.internal.ads.zzaex
 *  com.google.android.gms.internal.ads.zzaey
 *  com.google.android.gms.internal.ads.zzaez
 *  com.google.android.gms.internal.ads.zzafa
 *  com.google.android.gms.internal.ads.zzafb
 *  com.google.android.gms.internal.ads.zzafc
 *  com.google.android.gms.internal.ads.zzafd
 *  com.google.android.gms.internal.ads.zzafm
 *  com.google.android.gms.internal.ads.zzafn
 *  com.google.android.gms.internal.ads.zzafp
 *  com.google.android.gms.internal.ads.zzafq
 *  com.google.android.gms.internal.ads.zzafx
 *  com.google.android.gms.internal.ads.zzafy
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzagm
 *  com.google.android.gms.internal.ads.zzago
 *  com.google.android.gms.internal.ads.zzagx
 *  com.google.android.gms.internal.ads.zzahd
 *  com.google.android.gms.internal.ads.zzahh
 *  com.google.android.gms.internal.ads.zzahi
 *  com.google.android.gms.internal.ads.zzahj
 *  com.google.android.gms.internal.ads.zzaho
 *  com.google.android.gms.internal.ads.zzahp
 *  com.google.android.gms.internal.ads.zzahq
 *  com.google.android.gms.internal.ads.zzahr
 *  com.google.android.gms.internal.ads.zzahs
 *  com.google.android.gms.internal.ads.zzaht
 *  com.google.android.gms.internal.ads.zzahv
 *  com.google.android.gms.internal.ads.zzahx
 *  com.google.android.gms.internal.ads.zzahz
 *  com.google.android.gms.internal.ads.zzain
 *  com.google.android.gms.internal.ads.zzaip
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzaiv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzaku
 *  com.google.android.gms.internal.ads.zzalg
 *  com.google.android.gms.internal.ads.zzalj
 *  com.google.android.gms.internal.ads.zzalk
 *  com.google.android.gms.internal.ads.zzalm
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzcy
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzhh
 *  com.google.android.gms.internal.ads.zzhq
 *  com.google.android.gms.internal.ads.zzix
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzjz
 *  com.google.android.gms.internal.ads.zzka
 *  com.google.android.gms.internal.ads.zzkh
 *  com.google.android.gms.internal.ads.zzki
 *  com.google.android.gms.internal.ads.zzs
 *  com.google.android.gms.internal.ads.zzt
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzadu;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzadz;
import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaej;
import com.google.android.gms.internal.ads.zzaek;
import com.google.android.gms.internal.ads.zzael;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaeo;
import com.google.android.gms.internal.ads.zzaep;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzaes;
import com.google.android.gms.internal.ads.zzaet;
import com.google.android.gms.internal.ads.zzaeu;
import com.google.android.gms.internal.ads.zzaev;
import com.google.android.gms.internal.ads.zzaew;
import com.google.android.gms.internal.ads.zzaex;
import com.google.android.gms.internal.ads.zzaey;
import com.google.android.gms.internal.ads.zzaez;
import com.google.android.gms.internal.ads.zzafa;
import com.google.android.gms.internal.ads.zzafb;
import com.google.android.gms.internal.ads.zzafc;
import com.google.android.gms.internal.ads.zzafd;
import com.google.android.gms.internal.ads.zzafm;
import com.google.android.gms.internal.ads.zzafn;
import com.google.android.gms.internal.ads.zzafp;
import com.google.android.gms.internal.ads.zzafq;
import com.google.android.gms.internal.ads.zzafx;
import com.google.android.gms.internal.ads.zzafy;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzahd;
import com.google.android.gms.internal.ads.zzahh;
import com.google.android.gms.internal.ads.zzahi;
import com.google.android.gms.internal.ads.zzahj;
import com.google.android.gms.internal.ads.zzaho;
import com.google.android.gms.internal.ads.zzahp;
import com.google.android.gms.internal.ads.zzahq;
import com.google.android.gms.internal.ads.zzahr;
import com.google.android.gms.internal.ads.zzahs;
import com.google.android.gms.internal.ads.zzaht;
import com.google.android.gms.internal.ads.zzahv;
import com.google.android.gms.internal.ads.zzahx;
import com.google.android.gms.internal.ads.zzahz;
import com.google.android.gms.internal.ads.zzain;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzaiv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzaku;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzalk;
import com.google.android.gms.internal.ads.zzalm;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzcy;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzhh;
import com.google.android.gms.internal.ads.zzhq;
import com.google.android.gms.internal.ads.zzix;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzjz;
import com.google.android.gms.internal.ads.zzka;
import com.google.android.gms.internal.ads.zzkh;
import com.google.android.gms.internal.ads.zzki;
import com.google.android.gms.internal.ads.zzs;
import com.google.android.gms.internal.ads.zzt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class zzafe
extends zzadu {
    private zzahd zzA;
    private int zzB;
    private long zzC;
    private zzix zzD;
    final zzka zzb;
    final zzahi zzc;
    private final zzahv[] zzd;
    private final zzjz zze;
    private final zzalg zzf;
    private final zzafn zzg;
    private final zzafp zzh;
    private final zzalm<zzahj> zzi;
    private final CopyOnWriteArraySet<zzaeh> zzj;
    private final zzain zzk;
    private final List<zzafd> zzl;
    private final boolean zzm;
    private final zzhq zzn;
    private final zzcy zzo;
    private final Looper zzp;
    private final zzki zzq;
    private final zzaku zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private int zzv;
    private zzahz zzw;
    private zzahi zzx;
    private zzago zzy;
    private zzago zzz;

    public zzafe(zzahv[] zzahvArray, zzjz zzjz2, zzhq zzhq2, zzafy zzafy2, zzki zzki2, zzcy zzcy2, boolean bl, zzahz zzahz2, long l, long l2, zzadz zzadz2, long l3, boolean bl2, zzaku zzaku2, Looper looper, zzahp zzahp2, zzahi zzahi2, byte[] object) {
        object = Integer.toHexString(System.identityHashCode((Object)this));
        String string = zzamq.zze;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 30 + String.valueOf(string).length());
        stringBuilder.append("Init ");
        stringBuilder.append((String)object);
        stringBuilder.append(" [ExoPlayerLib/2.15.0] [");
        stringBuilder.append(string);
        stringBuilder.append("]");
        Log.i((String)"ExoPlayerImpl", (String)stringBuilder.toString());
        int n = zzahvArray.length;
        if (zzahvArray == null) throw null;
        this.zzd = zzahvArray;
        if (zzjz2 == null) throw null;
        this.zze = zzjz2;
        this.zzn = zzhq2;
        this.zzq = zzki2;
        this.zzo = zzcy2;
        this.zzm = true;
        this.zzw = zzahz2;
        this.zzp = looper;
        this.zzr = zzaku2;
        this.zzi = new zzalm(looper, zzaku2, (zzalk)new zzaej(zzahp2));
        this.zzj = new CopyOnWriteArraySet();
        this.zzl = new ArrayList<zzafd>();
        this.zzD = new zzix(0);
        this.zzb = new zzka(new zzahx[2], new zzjg[2], null, null);
        this.zzk = new zzain();
        zzhq2 = new zzahh();
        zzhq2.zzc(new int[]{1, 2, 12, 13, 14, 15, 16, 17, 18, 19});
        zzhq2.zzb(28, true);
        zzhq2.zzd(zzahi2);
        this.zzc = zzhq2.zze();
        zzhq2 = new zzahh();
        zzhq2.zzd(this.zzc);
        zzhq2.zza(3);
        zzhq2.zza(9);
        this.zzx = zzhq2.zze();
        this.zzy = zzago.zza;
        this.zzz = zzago.zza;
        this.zzB = -1;
        this.zzf = zzaku2.zza(looper, null);
        this.zzg = new zzaeu(this);
        this.zzA = zzahd.zza((zzka)this.zzb);
        zzcy2.zzc(zzahp2, looper);
        this.zzi.zzb((Object)zzcy2);
        zzki2.zze(new Handler(looper), (zzkh)zzcy2);
        this.zzh = new zzafp(zzahvArray, zzjz2, this.zzb, zzafy2, zzki2, 0, false, zzcy2, zzahz2, zzadz2, 500L, false, looper, zzaku2, this.zzg, null);
    }

    static final /* synthetic */ void zzH(zzahd zzahd2, zzahj zzahj2) {
        zzahj2.zzQ(zzafe.zzR(zzahd2));
    }

    private final int zzK() {
        if (this.zzA.zza.zzt()) {
            return this.zzB;
        }
        zzahd zzahd2 = this.zzA;
        return zzahd2.zza.zzy((Object)zzahd2.zzb.zza, (zzain)this.zzk).zzc;
    }

    private final long zzL(zzahd zzahd2) {
        if (zzahd2.zza.zzt()) {
            return zzadx.zzb((long)this.zzC);
        }
        if (zzahd2.zzb.zzb()) {
            return zzahd2.zzs;
        }
        zzaiq zzaiq2 = zzahd2.zza;
        zzhf zzhf2 = zzahd2.zzb;
        long l = zzahd2.zzs;
        this.zzQ(zzaiq2, zzhf2, l);
        return l;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void zzM(zzahd var1_1, int var2_2, int var3_3, boolean var4_4, boolean var5_5, int var6_6, long var7_7, int var9_8) {
        block43: {
            block46: {
                block44: {
                    block45: {
                        var23_9 = this.zzA;
                        this.zzA = var1_1;
                        var13_10 = var23_9.zza.equals((Object)var1_1.zza);
                        var19_11 = Boolean.valueOf(true);
                        var21_12 /* !! */  = var23_9.zza;
                        var20_13 = var1_1.zza;
                        var14_14 = var20_13.zzt();
                        var24_15 = -1;
                        var22_16 = false;
                        if (var14_14 && var21_12 /* !! */ .zzt()) {
                            var19_11 = new Pair(var22_16, (Object)var24_15);
                        } else if (var20_13.zzt() != var21_12 /* !! */ .zzt()) {
                            var19_11 = new Pair((Object)var19_11, (Object)3);
                        } else if (!var21_12 /* !! */ .zzf((int)var21_12 /* !! */ .zzy((Object)var23_9.zzb.zza, (zzain)this.zzk).zzc, (zzaip)this.zza, (long)0L).zzb.equals(var20_13.zzf((int)var20_13.zzy((Object)var1_1.zzb.zza, (zzain)this.zzk).zzc, (zzaip)this.zza, (long)0L).zzb)) {
                            if (var5_5 && var6_6 == 0) {
                                var10_17 = 1;
                            } else if (var5_5 && var6_6 == 1) {
                                var10_17 = 2;
                            } else {
                                if ((var13_10 ^ true) == false) throw new IllegalStateException();
                                var10_17 = 3;
                            }
                            var19_11 = new Pair((Object)var19_11, (Object)var10_17);
                        } else {
                            var19_11 = var5_5 != false && var6_6 == 0 && var23_9.zzb.zzd < var1_1.zzb.zzd ? new Pair((Object)var19_11, (Object)0) : new Pair(var22_16, (Object)var24_15);
                        }
                        var14_14 = (Boolean)var19_11.first;
                        var12_18 = (Integer)var19_11.second;
                        var19_11 = this.zzy;
                        if (var14_14) {
                            if (!var1_1.zza.zzt()) {
                                var10_17 = var1_1.zza.zzy((Object)var1_1.zzb.zza, (zzain)this.zzk).zzc;
                                var19_11 = var1_1.zza.zzf((int)var10_17, (zzaip)this.zza, (long)0L).zzc;
                            } else {
                                var19_11 = null;
                            }
                            var20_13 = var19_11 != null ? var19_11.zze : zzago.zza;
                            var21_12 /* !! */  = var19_11;
                            var19_11 = var20_13;
                            var20_13 = var21_12 /* !! */ ;
                        } else {
                            var20_13 = null;
                        }
                        var21_12 /* !! */  = var19_11;
                        if (!var23_9.zzj.equals(var1_1.zzj)) {
                            var22_16 = new zzagm((zzago)var19_11, null);
                            var19_11 = var1_1.zzj;
                            for (var10_17 = 0; var10_17 < var19_11.size(); ++var10_17) {
                                var21_12 /* !! */  = (zzaiv)var19_11.get(var10_17);
                                for (var11_19 = 0; var11_19 < var21_12 /* !! */ .zza(); ++var11_19) {
                                    var21_12 /* !! */ .zzb(var11_19).zza((zzagm)var22_16);
                                }
                            }
                            var21_12 /* !! */  = new zzago((zzagm)var22_16, null);
                        }
                        var13_10 = var21_12 /* !! */ .equals((Object)this.zzy);
                        this.zzy = var21_12 /* !! */ ;
                        if (!var23_9.zza.equals((Object)var1_1.zza)) {
                            this.zzi.zzd(0, (zzalj)new zzafb(var1_1, var2_2));
                        }
                        if (!var5_5) break block43;
                        var24_15 = new zzain();
                        if (!var23_9.zza.zzt()) {
                            var22_16 = var23_9.zzb.zza;
                            var23_9.zza.zzy(var22_16, (zzain)var24_15);
                            var9_8 = var24_15.zzc;
                            var2_2 = var23_9.zza.zzi(var22_16);
                            var19_11 = var23_9.zza.zzf((int)var9_8, (zzaip)this.zza, (long)0L).zzb;
                            var21_12 /* !! */  = this.zza.zzc;
                        } else {
                            var19_11 = null;
                            var21_12 /* !! */  = null;
                            var22_16 = null;
                            var2_2 = -1;
                        }
                        if (var6_6 != 0) break block44;
                        var17_20 = var24_15.zzd;
                        if (!var23_9.zzb.zzb()) break block45;
                        var25_21 = var23_9.zzb;
                        var15_22 = var24_15.zzh(var25_21.zzb, var25_21.zzc);
                        var17_20 = zzafe.zzN(var23_9);
                        break block46;
                    }
                    var15_22 = var17_20;
                    if (var23_9.zzb.zze != -1) {
                        var15_22 = var17_20;
                        if (this.zzA.zzb.zzb()) {
                            var15_22 = zzafe.zzN(this.zzA);
                        }
                    }
                    ** GOTO lbl93
                }
                if (var23_9.zzb.zzb()) {
                    var15_22 = var23_9.zzs;
                    var17_20 = zzafe.zzN(var23_9);
                } else {
                    var15_22 = var23_9.zzs;
lbl93:
                    // 2 sources

                    var17_20 = var15_22;
                }
            }
            var15_22 = zzadx.zza((long)var15_22);
            var17_20 = zzadx.zza((long)var17_20);
            var24_15 = var23_9.zzb;
            var24_15 = new zzaho((Object)var19_11, var9_8, (zzagk)var21_12 /* !! */ , var22_16, var2_2, var15_22, var17_20, var24_15.zzb, var24_15.zzc);
            var9_8 = this.zzv();
            if (!this.zzA.zza.zzt()) {
                var21_12 /* !! */  = this.zzA;
                var19_11 = var21_12 /* !! */ .zzb.zza;
                var21_12 /* !! */ .zza.zzy((Object)var19_11, this.zzk);
                var2_2 = this.zzA.zza.zzi((Object)var19_11);
                var22_16 = this.zzA.zza.zzf((int)var9_8, (zzaip)this.zza, (long)0L).zzb;
                var21_12 /* !! */  = this.zza.zzc;
            } else {
                var22_16 = null;
                var21_12 /* !! */  = null;
                var19_11 = null;
                var2_2 = -1;
            }
            var15_22 = zzadx.zza((long)var7_7);
            var7_7 = this.zzA.zzb.zzb() != false ? zzadx.zza((long)zzafe.zzN(this.zzA)) : var15_22;
            var25_21 = this.zzA.zzb;
            var19_11 = new zzaho(var22_16, var9_8, (zzagk)var21_12 /* !! */ , (Object)var19_11, var2_2, var15_22, var7_7, var25_21.zzb, var25_21.zzc);
            this.zzi.zzd(11, (zzalj)new zzafc(var6_6, (zzaho)var24_15, (zzaho)var19_11));
        }
        if (var14_14) {
            this.zzi.zzd(1, (zzalj)new zzaek((zzagk)var20_13, var12_18));
        }
        if (var23_9.zzf != var1_1.zzf) {
            this.zzi.zzd(10, (zzalj)new zzael(var1_1));
            if (var1_1.zzf != null) {
                this.zzi.zzd(10, (zzalj)new zzaem(var1_1));
            }
        }
        if ((var19_11 = var23_9.zzi) != (var20_13 = var1_1.zzi)) {
            this.zze.zzi(var20_13.zzc);
            var19_11 = new zzt(var1_1.zzi.zzd, null);
            this.zzi.zzd(2, (zzalj)new zzaen(var1_1, (zzt)var19_11));
        }
        if (var13_10 ^ true) {
            var19_11 = this.zzy;
            this.zzi.zzd(14, (zzalj)new zzaeo((zzago)var19_11));
        }
        if (var23_9.zzg != var1_1.zzg) {
            this.zzi.zzd(3, (zzalj)new zzaep(var1_1));
        }
        if (var23_9.zze != var1_1.zze || var23_9.zzl != var1_1.zzl) {
            this.zzi.zzd(-1, (zzalj)new zzaeq(var1_1));
        }
        if (var23_9.zze != var1_1.zze) {
            this.zzi.zzd(4, (zzalj)new zzaer(var1_1));
        }
        if (var23_9.zzl != var1_1.zzl) {
            this.zzi.zzd(5, (zzalj)new zzaes(var1_1, var3_3));
        }
        if (var23_9.zzm != var1_1.zzm) {
            this.zzi.zzd(6, (zzalj)new zzaet(var1_1));
        }
        if (zzafe.zzR(var23_9) != zzafe.zzR(var1_1)) {
            this.zzi.zzd(7, (zzalj)new zzaev(var1_1));
        }
        if (!var23_9.zzn.equals((Object)var1_1.zzn)) {
            this.zzi.zzd(12, (zzalj)new zzaew(var1_1));
        }
        if (var4_4) {
            this.zzi.zzd(-1, zzaex.zza);
        }
        var19_11 = this.zzx;
        var21_12 /* !! */  = this.zzc;
        var20_13 = new zzahh();
        var20_13.zzd((zzahi)var21_12 /* !! */ );
        var20_13.zzb(3, this.zzA() ^ true);
        var4_4 = this.zzd() != false && this.zzA() == false;
        var20_13.zzb(4, var4_4);
        var4_4 = this.zza() != false && this.zzA() == false;
        var20_13.zzb(5, var4_4);
        var4_4 = this.zzA.zza.zzt() == false && (this.zza() != false || this.zzc() == false || this.zzd() != false) && this.zzA() == false;
        var20_13.zzb(6, var4_4);
        var4_4 = this.zzb() != false && this.zzA() == false;
        var20_13.zzb(7, var4_4);
        var4_4 = this.zzA.zza.zzt() == false && (this.zzb() != false || this.zzc() != false && (var21_12 /* !! */  = this.zzA.zza).zzt() == false && var21_12 /* !! */ .zzf((int)this.zzv(), (zzaip)this.zza, (long)0L).zzh != false) && this.zzA() == false;
        var20_13.zzb(8, var4_4);
        var20_13.zzb(9, this.zzA() ^ true);
        var4_4 = this.zzd() != false && this.zzA() == false;
        var20_13.zzb(10, var4_4);
        var4_4 = this.zzd() != false && this.zzA() == false;
        var20_13.zzb(11, var4_4);
        var20_13 = var20_13.zze();
        this.zzx = var20_13;
        if (!var20_13.equals((Object)var19_11)) {
            this.zzi.zzd(13, (zzalj)new zzaey(this));
        }
        this.zzi.zze();
        if (var23_9.zzo != var1_1.zzo) {
            var19_11 = this.zzj.iterator();
            while (var19_11.hasNext()) {
                var19_11.next().zza(var1_1.zzo);
            }
        }
        if (var23_9.zzp == var1_1.zzp) return;
        var19_11 = this.zzj.iterator();
        while (var19_11.hasNext() != false) {
            var19_11.next().zzb(var1_1.zzp);
        }
    }

    private static long zzN(zzahd zzahd2) {
        long l;
        zzaip zzaip2 = new zzaip();
        zzain zzain2 = new zzain();
        zzahd2.zza.zzy(zzahd2.zzb.zza, zzain2);
        long l2 = l = zzahd2.zzc;
        if (l != -9223372036854775807L) return l2;
        zzahd2 = zzahd2.zza;
        int n = zzain2.zzc;
        l2 = 0L;
        l = zzahd2.zzf((int)n, (zzaip)zzaip2, (long)0L).zzl;
        return l2;
    }

    private final zzahd zzO(zzahd object, zzaiq zzaiq2, Pair<Object, Long> object2) {
        boolean bl = zzaiq2.zzt() || object2 != null;
        zzakt.zza((boolean)bl);
        zzaiq zzaiq3 = ((zzahd)object).zza;
        zzahd zzahd2 = object.zzd(zzaiq2);
        if (zzaiq2.zzt()) {
            object = zzahd.zzb();
            long l = zzadx.zzb((long)this.zzC);
            object = zzahd2.zzc((zzhf)object, l, l, l, 0L, com.google.android.gms.internal.ads.zzs.zza, this.zzb, (List)zzfoj.zzi()).zzg((zzhf)object);
            ((zzahd)object).zzq = ((zzahd)object).zzs;
            return object;
        }
        object = zzahd2.zzb.zza;
        int n = zzamq.zza;
        n = object.equals(object2.first) ^ 1;
        zzhf zzhf2 = n != 0 ? new zzhf(object2.first) : zzahd2.zzb;
        long l = (Long)object2.second;
        long l2 = zzadx.zzb((long)this.zzD());
        if (!zzaiq3.zzt()) {
            zzaiq3.zzy(object, this.zzk);
        }
        if (n == 0 && l >= l2) {
            if (l == l2) {
                n = zzaiq2.zzi(zzahd2.zzk.zza);
                if (n != -1) {
                    object = zzahd2;
                    if (zzaiq2.zzh((int)n, (zzain)this.zzk, (boolean)false).zzc == zzaiq2.zzy((Object)zzhf2.zza, (zzain)this.zzk).zzc) return object;
                }
                zzaiq2.zzy(zzhf2.zza, this.zzk);
                l2 = zzhf2.zzb() ? this.zzk.zzh(zzhf2.zzb, zzhf2.zzc) : this.zzk.zzd;
                object = zzahd2.zzc(zzhf2, zzahd2.zzs, zzahd2.zzs, zzahd2.zzd, l2 - zzahd2.zzs, zzahd2.zzh, zzahd2.zzi, zzahd2.zzj).zzg(zzhf2);
                ((zzahd)object).zzq = l2;
            } else {
                zzakt.zzd((boolean)(zzhf2.zzb() ^ true));
                long l3 = Math.max(0L, zzahd2.zzr - (l - l2));
                l2 = zzahd2.zzq;
                if (zzahd2.zzk.equals((Object)zzahd2.zzb)) {
                    l2 = l + l3;
                }
                object = zzahd2.zzc(zzhf2, l, l, l, l3, zzahd2.zzh, zzahd2.zzi, zzahd2.zzj);
                ((zzahd)object).zzq = l2;
            }
        } else {
            zzakt.zzd((boolean)(zzhf2.zzb() ^ true));
            object = n != 0 ? com.google.android.gms.internal.ads.zzs.zza : zzahd2.zzh;
            zzaiq2 = n != 0 ? this.zzb : zzahd2.zzi;
            object2 = n != 0 ? zzfoj.zzi() : zzahd2.zzj;
            object = zzahd2.zzc(zzhf2, l, l, l, 0L, (zzs)object, (zzka)zzaiq2, (List)object2).zzg(zzhf2);
            ((zzahd)object).zzq = l;
        }
        return object;
    }

    private final Pair<Object, Long> zzP(zzaiq zzaiq2, int n, long l) {
        int n2;
        if (zzaiq2.zzt()) {
            this.zzB = n;
            long l2 = l;
            if (l == -9223372036854775807L) {
                l2 = 0L;
            }
            this.zzC = l2;
            return null;
        }
        if (n != -1) {
            n2 = n;
            if (n < zzaiq2.zza()) return zzaiq2.zzv(this.zza, this.zzk, n2, zzadx.zzb((long)l));
        }
        n2 = zzaiq2.zze(false);
        l = zzaiq2.zzf((int)n2, (zzaip)this.zza, (long)0L).zzl;
        l = zzadx.zza((long)0L);
        return zzaiq2.zzv(this.zza, this.zzk, n2, zzadx.zzb((long)l));
    }

    private final long zzQ(zzaiq zzaiq2, zzhf zzhf2, long l) {
        zzaiq2.zzy(zzhf2.zza, this.zzk);
        return l;
    }

    private static boolean zzR(zzahd zzahd2) {
        if (zzahd2.zze != 3) return false;
        if (!zzahd2.zzl) return false;
        if (zzahd2.zzm != 0) return false;
        return true;
    }

    public final boolean zzA() {
        return this.zzA.zzb.zzb();
    }

    public final int zzB() {
        if (!this.zzA()) return -1;
        return this.zzA.zzb.zzb;
    }

    public final int zzC() {
        if (!this.zzA()) return -1;
        return this.zzA.zzb.zzc;
    }

    public final long zzD() {
        long l;
        if (!this.zzA()) return this.zzx();
        zzahd zzahd2 = this.zzA;
        zzahd2.zza.zzy(zzahd2.zzb.zza, this.zzk);
        zzahd2 = this.zzA;
        if (zzahd2.zzc == -9223372036854775807L) {
            l = zzahd2.zza.zzf((int)this.zzv(), (zzaip)this.zza, (long)0L).zzl;
            l = zzadx.zza((long)0L);
        } else {
            l = zzadx.zza((long)0L) + zzadx.zza((long)this.zzA.zzc);
        }
        return l;
    }

    public final int zzE() {
        int n = this.zzd.length;
        return 2;
    }

    public final zzaiq zzF() {
        return this.zzA.zza;
    }

    final /* synthetic */ void zzG(zzahj zzahj2) {
        zzahj2.zzL(this.zzx);
    }

    final /* synthetic */ void zzI(zzafm zzafm2) {
        this.zzf.zzj((Runnable)new zzaez(this, zzafm2));
    }

    final /* synthetic */ void zzJ(zzafm zzafm2) {
        long l;
        List list;
        int n;
        this.zzs = n = this.zzs - zzafm2.zzb;
        boolean bl = zzafm2.zzc;
        boolean bl2 = true;
        if (bl) {
            this.zzt = zzafm2.zzd;
            this.zzu = true;
        }
        if (zzafm2.zze) {
            this.zzv = zzafm2.zzf;
        }
        if (n != 0) return;
        zzaiq zzaiq2 = zzafm2.zza.zza;
        if (!this.zzA.zza.zzt() && zzaiq2.zzt()) {
            this.zzB = -1;
            this.zzC = 0L;
        }
        if (!zzaiq2.zzt()) {
            list = ((zzaht)zzaiq2).zzs();
            bl = list.size() == this.zzl.size();
            zzakt.zzd((boolean)bl);
            for (n = 0; n < list.size(); ++n) {
                zzafd.zza((zzafd)this.zzl.get(n), (zzaiq)((zzaiq)list.get(n)));
            }
        }
        if (this.zzu) {
            bl = bl2;
            if (zzafm2.zza.zzb.equals((Object)this.zzA.zzb)) {
                bl = zzafm2.zza.zzd != this.zzA.zzs ? bl2 : false;
            }
            if (bl) {
                if (!zzaiq2.zzt() && !zzafm2.zza.zzb.zzb()) {
                    zzahd zzahd2 = zzafm2.zza;
                    list = zzahd2.zzb;
                    l = zzahd2.zzd;
                    this.zzQ(zzaiq2, (zzhf)list, l);
                } else {
                    l = zzafm2.zza.zzd;
                }
            } else {
                l = -9223372036854775807L;
            }
        } else {
            l = -9223372036854775807L;
            bl = false;
        }
        this.zzu = false;
        this.zzM(zzafm2.zza, 1, this.zzv, false, bl, this.zzt, l, -1);
    }

    public final boolean zze() {
        return this.zzA.zzp;
    }

    public final Looper zzf() {
        return this.zzp;
    }

    public final void zzg(zzahj zzahj2) {
        this.zzi.zzb((Object)zzahj2);
    }

    public final void zzh(zzaeh zzaeh2) {
        this.zzj.add(zzaeh2);
    }

    public final int zzi() {
        return this.zzA.zze;
    }

    public final void zzj() {
        zzahd zzahd2 = this.zzA;
        if (zzahd2.zze != 1) {
            return;
        }
        zzahd2 = zzahd2.zzf(null);
        int n = true != zzahd2.zza.zzt() ? 2 : 4;
        zzahd2 = zzahd2.zze(n);
        ++this.zzs;
        this.zzh.zze();
        this.zzM(zzahd2, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }

    public final void zzk(List<zzhh> zzahd2, boolean bl) {
        zzagx zzagx2;
        int n;
        int n2;
        this.zzK();
        this.zzx();
        ++this.zzs;
        if (!this.zzl.isEmpty()) {
            n2 = this.zzl.size();
            for (n = n2 - 1; n >= 0; --n) {
                this.zzl.remove(n);
            }
            this.zzD = this.zzD.zzg(0, n2);
        }
        ArrayList<zzagx> arrayList = new ArrayList<zzagx>();
        for (n = 0; n < zzahd2.size(); ++n) {
            zzagx2 = new zzagx(zzahd2.get(n), this.zzm);
            arrayList.add(zzagx2);
            this.zzl.add(n, new zzafd(zzagx2.zzb, zzagx2.zza.zzy()));
        }
        this.zzD = this.zzD.zzf(0, arrayList.size());
        zzagx2 = new zzaht(this.zzl, this.zzD, null);
        if (!zzagx2.zzt()) {
            if (zzagx2.zza() < 0) throw new zzafx((zzaiq)zzagx2, -1, -9223372036854775807L);
        }
        int n3 = zzagx2.zze(false);
        zzahd2 = this.zzO(this.zzA, (zzaiq)zzagx2, this.zzP((zzaiq)zzagx2, n3, -9223372036854775807L));
        n = n2 = zzahd2.zze;
        if (n3 != -1) {
            n = n2;
            if (n2 != 1) {
                n = !zzagx2.zzt() && n3 < zzagx2.zza() ? 2 : 4;
            }
        }
        zzahd2 = zzahd2.zze(n);
        this.zzh.zzq(arrayList, n3, zzadx.zzb((long)-9223372036854775807L), this.zzD);
        bl = !this.zzA.zzb.zza.equals(zzahd2.zzb.zza) && !this.zzA.zza.zzt();
        this.zzM(zzahd2, 0, 1, false, bl, 4, this.zzL(zzahd2), -1);
    }

    public final void zzl(boolean bl, int n, int n2) {
        zzahd zzahd2 = this.zzA;
        if (zzahd2.zzl == bl && zzahd2.zzm == n) {
            return;
        }
        ++this.zzs;
        zzahd2 = zzahd2.zzh(bl, n);
        this.zzh.zzf(bl, n);
        this.zzM(zzahd2, 0, n2, false, false, 5, -9223372036854775807L, -1);
    }

    public final boolean zzm() {
        return this.zzA.zzl;
    }

    public final int zzn() {
        return 0;
    }

    public final boolean zzo() {
        return false;
    }

    public final void zzp(int n, long l) {
        zzaiq zzaiq2 = this.zzA.zza;
        if (n < 0) throw new zzafx(zzaiq2, n, l);
        if (!zzaiq2.zzt()) {
            if (n >= zzaiq2.zza()) throw new zzafx(zzaiq2, n, l);
        }
        int n2 = this.zzs;
        int n3 = 1;
        this.zzs = n2 + 1;
        if (this.zzA()) {
            Log.w((String)"ExoPlayerImpl", (String)"seekTo ignored because an ad is playing");
            zzaiq2 = new zzafm(this.zzA);
            zzaiq2.zzb(1);
            this.zzg.zza((zzafm)zzaiq2);
            return;
        }
        if (this.zzA.zze != 1) {
            n3 = 2;
        }
        n2 = this.zzv();
        zzahd zzahd2 = this.zzO(this.zzA.zze(n3), zzaiq2, this.zzP(zzaiq2, n, l));
        this.zzh.zzg(zzaiq2, n, zzadx.zzb((long)l));
        this.zzM(zzahd2, 0, 1, true, true, 1, this.zzL(zzahd2), n2);
    }

    public final void zzq(boolean bl) {
        throw null;
    }

    public final void zzr(boolean bl, zzaeg zzaeg2) {
        zzahd zzahd2;
        zzahd zzahd3 = this.zzA;
        zzahd3 = zzahd3.zzg(zzahd3.zzb);
        zzahd3.zzq = zzahd3.zzs;
        zzahd3.zzr = 0L;
        zzahd3 = zzahd2 = zzahd3.zze(1);
        if (zzaeg2 != null) {
            zzahd3 = zzahd2.zzf(zzaeg2);
        }
        ++this.zzs;
        this.zzh.zzh();
        bl = zzahd3.zza.zzt() && !this.zzA.zza.zzt();
        this.zzM(zzahd3, 0, 1, false, bl, 4, this.zzL(zzahd3), -1);
    }

    public final void zzs() {
        zzcy zzcy2 = Integer.toHexString(System.identityHashCode((Object)this));
        String string = zzamq.zze;
        String string2 = zzafq.zza();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(zzcy2).length() + 36 + String.valueOf(string).length() + String.valueOf(string2).length());
        stringBuilder.append("Release ");
        stringBuilder.append((String)zzcy2);
        stringBuilder.append(" [ExoPlayerLib/2.15.0] [");
        stringBuilder.append(string);
        stringBuilder.append("] [");
        stringBuilder.append(string2);
        stringBuilder.append("]");
        Log.i((String)"ExoPlayerImpl", (String)stringBuilder.toString());
        if (!this.zzh.zzj()) {
            zzcy2 = this.zzi;
            zzcy2.zzd(10, zzafa.zza);
            zzcy2.zze();
        }
        this.zzi.zzf();
        this.zzf.zzi(null);
        zzcy2 = this.zzo;
        if (zzcy2 != null) {
            this.zzq.zzf((zzkh)zzcy2);
        }
        zzcy2 = this.zzA.zze(1);
        this.zzA = zzcy2;
        zzcy2 = zzcy2.zzg(zzcy2.zzb);
        this.zzA = zzcy2;
        zzcy2.zzq = zzcy2.zzs;
        this.zzA.zzr = 0L;
    }

    public final zzahs zzt(zzahr zzahr2) {
        return new zzahs((zzahq)this.zzh, zzahr2, this.zzA.zza, this.zzv(), this.zzr, this.zzh.zzk());
    }

    public final int zzu() {
        if (this.zzA.zza.zzt()) {
            return 0;
        }
        zzahd zzahd2 = this.zzA;
        return zzahd2.zza.zzi(zzahd2.zzb.zza);
    }

    public final int zzv() {
        int n;
        int n2 = n = this.zzK();
        if (n != -1) return n2;
        n2 = 0;
        return n2;
    }

    public final long zzw() {
        if (!this.zzA()) {
            zzaiq zzaiq2 = this.zzA.zza;
            if (!zzaiq2.zzt()) return zzadx.zza((long)zzaiq2.zzf((int)this.zzv(), (zzaip)this.zza, (long)0L).zzm);
            return -9223372036854775807L;
        }
        zzahd zzahd2 = this.zzA;
        zzhf zzhf2 = zzahd2.zzb;
        zzahd2.zza.zzy(zzhf2.zza, this.zzk);
        return zzadx.zza((long)this.zzk.zzh(zzhf2.zzb, zzhf2.zzc));
    }

    public final long zzx() {
        return zzadx.zza((long)this.zzL(this.zzA));
    }

    public final long zzy() {
        long l;
        if (this.zzA()) {
            zzahd zzahd2 = this.zzA;
            long l2 = zzahd2.zzk.equals((Object)zzahd2.zzb) ? zzadx.zza((long)this.zzA.zzq) : this.zzw();
            return l2;
        }
        if (this.zzA.zza.zzt()) {
            l = this.zzC;
        } else {
            zzahd zzahd3 = this.zzA;
            long l3 = zzahd3.zzk.zzd;
            long l4 = zzahd3.zzb.zzd;
            l = 0L;
            if (l3 != l4) {
                l = zzadx.zza((long)zzahd3.zza.zzf((int)this.zzv(), (zzaip)this.zza, (long)0L).zzm);
            } else {
                l3 = zzahd3.zzq;
                if (this.zzA.zzk.zzb()) {
                    zzahd3 = this.zzA;
                    zzahd3.zza.zzy(zzahd3.zzk.zza, this.zzk).zzb(this.zzA.zzk.zzb);
                } else {
                    l = l3;
                }
                zzahd3 = this.zzA;
                this.zzQ(zzahd3.zza, zzahd3.zzk, l);
                l = zzadx.zza((long)l);
            }
        }
        return l;
    }

    public final long zzz() {
        return zzadx.zza((long)this.zzA.zzr);
    }
}
