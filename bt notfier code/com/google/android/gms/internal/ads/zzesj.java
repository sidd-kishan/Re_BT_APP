/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.telephony.TelephonyManager
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzesh
 *  com.google.android.gms.internal.ads.zzesi
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzesh;
import com.google.android.gms.internal.ads.zzesi;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzesj
implements zzery<zzesh> {
    private final zzfsn zza;
    private final Context zzb;

    public zzesj(zzfsn zzfsn2, Context context) {
        this.zza = zzfsn2;
        this.zzb = context;
    }

    public final zzfsm<zzesh> zza() {
        return this.zza.zzb((Callable)new zzesi(this));
    }

    /*
     * Unable to fully structure code
     */
    final /* synthetic */ zzesh zzb() throws Exception {
        var8_1 = (TelephonyManager)this.zzb.getSystemService("phone");
        var7_2 = var8_1.getNetworkOperator();
        if (!PlatformVersion.isAtLeastR()) ** GOTO lbl-1000
        var9_3 = zzbjl.zzgd;
        if (((Boolean)zzbet.zzc().zzc(var9_3)).booleanValue()) {
            var3_4 = 0;
        } else lbl-1000:
        // 2 sources

        {
            var3_4 = var8_1.getNetworkType();
        }
        var5_5 = var8_1.getPhoneType();
        zzt.zzc();
        var6_6 = zzs.zzE((Context)this.zzb, (String)"android.permission.ACCESS_NETWORK_STATE");
        var2_7 = -1;
        if (var6_6) {
            var8_1 = (ConnectivityManager)this.zzb.getSystemService("connectivity");
            var9_3 = var8_1.getActiveNetworkInfo();
            if (var9_3 != null) {
                var1_8 = var9_3.getType();
                var2_7 = var9_3.getDetailedState().ordinal();
            } else {
                var1_8 = -1;
            }
            var6_6 = var8_1.isActiveNetworkMetered();
            var4_9 = var1_8;
            var1_8 = var2_7;
        } else {
            var4_9 = -2;
            var6_6 = false;
            var1_8 = -1;
        }
        return new zzesh(var7_2, var4_9, var3_4, var5_5, var6_6, var1_8);
    }
}
