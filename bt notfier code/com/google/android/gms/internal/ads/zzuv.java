/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzur
 *  com.google.android.gms.internal.ads.zzus
 *  com.google.android.gms.internal.ads.zzut
 *  com.google.android.gms.internal.ads.zzuu
 *  com.google.android.gms.internal.ads.zzuw
 *  com.google.android.gms.internal.ads.zzux
 *  com.google.android.gms.internal.ads.zzuy
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzur;
import com.google.android.gms.internal.ads.zzus;
import com.google.android.gms.internal.ads.zzut;
import com.google.android.gms.internal.ads.zzuu;
import com.google.android.gms.internal.ads.zzuw;
import com.google.android.gms.internal.ads.zzux;
import com.google.android.gms.internal.ads.zzuy;
import java.io.IOException;

public final class zzuv
implements zznu {
    public static final zzoa zza = zzur.zza;
    private zznx zzb;
    private zzox zzc;
    private zzut zzd;
    private int zze = -1;
    private long zzf = -1L;

    public final boolean zza(zznv zznv2) throws IOException {
        if (zzuy.zza((zznv)zznv2) == null) return false;
        return true;
    }

    public final void zzb(zznx zznx2) {
        this.zzb = zznx2;
        this.zzc = zznx2.zzB(0, 1);
        zznx2.zzC();
    }

    /*
     * Unable to fully structure code
     */
    public final int zzc(zznv var1_1, zzoq var2_2) throws IOException {
        block13: {
            block19: {
                block17: {
                    block18: {
                        block16: {
                            block15: {
                                block14: {
                                    zzakt.zze((Object)this.zzc);
                                    var3_3 = zzamq.zza;
                                    var2_2 = this.zzd;
                                    var5_4 = true;
                                    if (var2_2 != null) break block13;
                                    var2_2 = zzuy.zza((zznv)var1_1);
                                    if (var2_2 == null) throw zzaha.zzb((String)"Unsupported or unrecognized wav header.", null);
                                    var3_3 = var2_2.zza;
                                    if (var3_3 != 17) break block14;
                                    this.zzd = new zzus(this.zzb, this.zzc, (zzuw)var2_2);
                                    break block13;
                                }
                                if (var3_3 != 6) break block15;
                                this.zzd = new zzuu(this.zzb, this.zzc, (zzuw)var2_2, "audio/g711-alaw", -1);
                                break block13;
                            }
                            if (var3_3 != 7) break block16;
                            this.zzd = new zzuu(this.zzb, this.zzc, (zzuw)var2_2, "audio/g711-mlaw", -1);
                            break block13;
                        }
                        var4_5 = var2_2.zze;
                        if (var3_3 == 1) break block17;
                        if (var3_3 == 3) break block18;
                        if (var3_3 == 65534) break block17;
                        ** GOTO lbl-1000
                    }
                    if (var4_5 == 32) {
                        var3_3 = 4;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var3_3 = 0;
                    }
                    break block19;
                }
                var3_3 = zzamq.zzO((int)var4_5);
            }
            if (var3_3 == 0) {
                var3_3 = var2_2.zza;
                var1_1 = new StringBuilder(40);
                var1_1.append("Unsupported WAV format type: ");
                var1_1.append(var3_3);
                throw zzaha.zzc((String)var1_1.toString());
            }
            this.zzd = new zzuu(this.zzb, this.zzc, (zzuw)var2_2, "audio/raw", var3_3);
        }
        if (this.zze == -1) {
            var1_1.zzl();
            var14_6 = new zzamf(8);
            var2_2 = zzux.zza((zznv)var1_1, (zzamf)var14_6);
            while ((var3_3 = var2_2.zza) != 1684108385) {
                if (var3_3 != 1380533830 && var3_3 != 1718449184) {
                    var15_8 = new StringBuilder(39);
                    var15_8.append("Ignoring unknown WAV chunk: ");
                    var15_8.append(var3_3);
                    Log.w((String)"WavHeaderReader", (String)var15_8.toString());
                }
                var6_7 = var2_2.zzb + 8L;
                var3_3 = var2_2.zza;
                if (var3_3 == 1380533830) {
                    var6_7 = 12L;
                }
                if (var6_7 > 0x7FFFFFFFL) {
                    var1_1 = new StringBuilder(51);
                    var1_1.append("Chunk is too large (~2GB+) to skip; id: ");
                    var1_1.append(var3_3);
                    throw zzaha.zzc((String)var1_1.toString());
                }
                ((zznp)var1_1).zzd((int)var6_7, false);
                var2_2 = zzux.zza((zznv)var1_1, (zzamf)var14_6);
            }
            ((zznp)var1_1).zzd(8, false);
            var12_9 = var1_1.zzn();
            var8_10 = var2_2.zzb + var12_9;
            var10_11 = var1_1.zzo();
            var6_7 = var8_10;
            if (var10_11 != -1L) {
                var6_7 = var8_10;
                if (var8_10 > var10_11) {
                    var2_2 = new StringBuilder(69);
                    var2_2.append("Data exceeds input length: ");
                    var2_2.append(var8_10);
                    var2_2.append(", ");
                    var2_2.append(var10_11);
                    Log.w((String)"WavHeaderReader", (String)var2_2.toString());
                    var6_7 = var10_11;
                }
            }
            var2_2 = Pair.create((Object)var12_9, (Object)var6_7);
            this.zze = ((Long)var2_2.first).intValue();
            this.zzf = var6_7 = ((Long)var2_2.second).longValue();
            this.zzd.zzb(this.zze, var6_7);
        } else if (var1_1.zzn() == 0L) {
            var3_3 = this.zze;
            ((zznp)var1_1).zzd(var3_3, false);
        }
        if (this.zzf == -1L) {
            var5_4 = false;
        }
        zzakt.zzd((boolean)var5_4);
        var6_7 = this.zzf;
        var8_10 = var1_1.zzn();
        if (this.zzd.zzc((zznv)var1_1, var6_7 - var8_10) == false) return 0;
        return -1;
    }

    public final void zzd(long l, long l2) {
        zzut zzut2 = this.zzd;
        if (zzut2 == null) return;
        zzut2.zza(l2);
    }
}
