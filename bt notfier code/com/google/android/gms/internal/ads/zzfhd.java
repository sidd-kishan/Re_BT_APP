/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  com.google.android.gms.internal.ads.zzfgz
 *  com.google.android.gms.internal.ads.zzfha
 *  com.google.android.gms.internal.ads.zzfhi
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzfgz;
import com.google.android.gms.internal.ads.zzfha;
import com.google.android.gms.internal.ads.zzfhi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

public final class zzfhd
implements zzfha {
    private final int[] zza = new int[2];

    public final JSONObject zza(View object) {
        if (object == null) {
            return zzfhi.zzb((int)0, (int)0, (int)0, (int)0);
        }
        int n = object.getWidth();
        int n2 = object.getHeight();
        object.getLocationOnScreen(this.zza);
        object = this.zza;
        return zzfhi.zzb((int)object[0], (int)object[1], (int)n, (int)n2);
    }

    /*
     * Unable to fully structure code
     */
    public final void zzb(View var1_1, JSONObject var2_2, zzfgz var3_3, boolean var4_4) {
        if (!(var1_1 instanceof ViewGroup)) {
            return;
        }
        var11_5 = (ViewGroup)var1_1;
        var5_7 = var6_6 = 0;
        if (!var4_4) ** GOTO lbl21
        if (Build.VERSION.SDK_INT >= 21) {
            var10_8 = new HashMap<Float, Object>();
            for (var5_7 = 0; var5_7 < var11_5.getChildCount(); ++var5_7) {
                var12_10 = var11_5.getChildAt(var5_7);
                var9_9 = (ArrayList)var10_8.get(Float.valueOf(var12_10.getZ()));
                var1_1 = var9_9;
                if (var9_9 == null) {
                    var1_1 = new ArrayList<E>();
                    var10_8.put(Float.valueOf(var12_10.getZ()), var1_1);
                }
                var1_1.add(var12_10);
            }
        } else {
            var5_7 = var6_6;
lbl21:
            // 3 sources

            while (var5_7 < var11_5.getChildCount()) {
                var3_3.zza(var11_5.getChildAt(var5_7), (zzfha)this, var2_2);
                ++var5_7;
            }
            return;
        }
        var1_1 = new ArrayList<K>(var10_8.keySet());
        Collections.sort(var1_1);
        var7_11 = var1_1.size();
        var5_7 = 0;
        while (var5_7 < var7_11) {
            var9_9 = (ArrayList)var10_8.get((Float)var1_1.get(var5_7));
            var8_12 = var9_9.size();
            for (var6_6 = 0; var6_6 < var8_12; ++var6_6) {
                var3_3.zza((View)var9_9.get(var6_6), (zzfha)this, var2_2);
            }
            ++var5_7;
        }
    }
}
