/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzcsc
 *  com.google.android.gms.internal.ads.zzdxy
 *  com.google.android.gms.internal.ads.zzdyc
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzcsc;
import com.google.android.gms.internal.ads.zzdxy;
import com.google.android.gms.internal.ads.zzdyc;
import java.util.Map;

public final class zzcsi
implements zzcsc {
    private final zzdyc zza;

    zzcsi(zzdyc zzdyc2) {
        this.zza = zzdyc2;
    }

    /*
     * Unable to fully structure code
     */
    public final void zza(Map<String, String> var1_1) {
        block6: {
            block5: {
                if (TextUtils.isEmpty((CharSequence)(var1_1 = var1_1.get("gesture")))) {
                    return;
                }
                var2_2 = var1_1.hashCode();
                if (var2_2 == 97520651) break block5;
                if (var2_2 != 109399814 || !var1_1.equals("shake")) ** GOTO lbl-1000
                var2_2 = 0;
                break block6;
            }
            if (var1_1.equals("flick")) {
                var2_2 = 1;
            } else lbl-1000:
            // 2 sources

            {
                var2_2 = -1;
            }
        }
        if (var2_2 == 0) {
            this.zza.zze(zzdxy.zzb);
            return;
        }
        if (var2_2 != 1) {
            this.zza.zze(zzdxy.zza);
            return;
        }
        this.zza.zze(zzdxy.zzc);
    }
}
