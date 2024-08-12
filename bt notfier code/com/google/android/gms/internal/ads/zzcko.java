/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcip
 *  com.google.android.gms.internal.ads.zzcjb
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcip;
import com.google.android.gms.internal.ads.zzcjb;
import java.util.Map;

public final class zzcko
implements zzbpr<zzcjb> {
    private boolean zza;

    private static int zzb(Context object, Map<String, String> object2, String string, int n) {
        object2 = object2.get(string);
        int n2 = n;
        if (object2 != null) {
            try {
                zzber.zza();
                n2 = zzcgm.zzs((Context)object, (int)Integer.parseInt((String)object2));
            }
            catch (NumberFormatException numberFormatException) {
                object = new StringBuilder(string.length() + 34 + ((String)object2).length());
                ((StringBuilder)object).append("Could not parse ");
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append(" in a video GMSG: ");
                ((StringBuilder)object).append((String)object2);
                zze.zzi((String)((StringBuilder)object).toString());
                n2 = n;
            }
        }
        if (!zze.zzc()) return n2;
        n = String.valueOf(object2).length();
        object = new StringBuilder(string.length() + 48 + n);
        ((StringBuilder)object).append("Parse pixels for ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(", got string ");
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(", int ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(".");
        zze.zza((String)((StringBuilder)object).toString());
        return n2;
    }

    /*
     * Unable to fully structure code
     */
    private static void zzc(zzcip var0, Map<String, String> var1_2) {
        var3_3 = var1_2.get("minBufferMs");
        var2_4 = var1_2.get("maxBufferMs");
        var4_5 = var1_2.get("bufferForPlaybackMs");
        var5_6 = var1_2.get("bufferForPlaybackAfterRebufferMs");
        var1_2 = var1_2.get("socketReceiveBufferSize");
        if (var3_3 == null) ** GOTO lbl9
        try {
            var0.zzw(Integer.parseInt(var3_3));
lbl9:
            // 2 sources

            if (var2_4 != null) {
                var0.zzx(Integer.parseInt(var2_4));
            }
            if (var4_5 != null) {
                var0.zzy(Integer.parseInt(var4_5));
            }
            if (var5_6 != null) {
                var0.zzz(Integer.parseInt(var5_6));
            }
            if (var1_2 == null) return;
            var0.zzA(Integer.parseInt((String)var1_2));
            return;
        }
        catch (NumberFormatException var0_1) {
            zze.zzi((String)String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{var3_3, var2_4}));
        }
    }
}
