/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.view.WindowManager
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbiv
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbyp
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbiv;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbyp;
import com.google.android.gms.internal.ads.zzcml;

public final class zzbyo
extends zzbyp
implements zzbpr<zzcml> {
    DisplayMetrics zza;
    int zzb = -1;
    int zzc = -1;
    int zzd = -1;
    int zze = -1;
    int zzf = -1;
    int zzg = -1;
    private final zzcml zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbiv zzk;
    private float zzl;
    private int zzm;

    public zzbyo(zzcml zzcml2, Context context, zzbiv zzbiv2) {
        super(zzcml2, "");
        this.zzh = zzcml2;
        this.zzi = context;
        this.zzk = zzbiv2;
        this.zzj = (WindowManager)context.getSystemService("window");
    }

    /*
     * Unable to fully structure code
     */
    public final void zzb(int var1_1, int var2_2) {
        block6: {
            var9_3 = this.zzi instanceof Activity;
            var7_4 = 0;
            if (var9_3) {
                zzt.zzc();
                var5_5 = zzs.zzV((Activity)((Activity)this.zzi))[0];
            } else {
                var5_5 = 0;
            }
            if (this.zzh.zzP() != null && this.zzh.zzP().zzg()) break block6;
            var6_6 = this.zzh.getWidth();
            var8_7 = this.zzh.getHeight();
            var10_8 = zzbjl.zzM;
            var4_9 = var6_6;
            if (!((Boolean)zzbet.zzc().zzc(var10_8)).booleanValue()) ** GOTO lbl-1000
            var3_10 = var6_6;
            if (var6_6 == 0) {
                var3_10 = this.zzh.zzP() != null ? this.zzh.zzP().zzb : 0;
            }
            var4_9 = var3_10;
            if (var8_7 == 0) {
                var4_9 = var7_4;
                var6_6 = var3_10;
                if (this.zzh.zzP() != null) {
                    var4_9 = this.zzh.zzP().zza;
                    var6_6 = var3_10;
                }
            } else lbl-1000:
            // 2 sources

            {
                var3_10 = var8_7;
                var6_6 = var4_9;
                var4_9 = var3_10;
            }
            this.zzf = zzber.zza().zza(this.zzi, var6_6);
            this.zzg = zzber.zza().zza(this.zzi, var4_9);
        }
        this.zzi(var1_1, var2_2 - var5_5, this.zzf, this.zzg);
        this.zzh.zzR().zzE(var1_1, var2_2);
    }
}
