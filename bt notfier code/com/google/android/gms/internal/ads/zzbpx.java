/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbpr
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbpr;
import java.util.Map;

public final class zzbpx
implements zzbpr<Object> {
    private final Context zza;

    public zzbpx(Context context) {
        this.zza = context;
    }

    /*
     * Unable to fully structure code
     */
    public final void zza(Object var1_1, Map<String, String> var2_2) {
        block8: {
            block6: {
                block7: {
                    if (!zzt.zzA().zzb(this.zza)) {
                        return;
                    }
                    var1_1 = var2_2.get("eventName");
                    var2_2 = var2_2.get("eventId");
                    var3_3 = var1_1.hashCode();
                    if (var3_3 == 94399) break block6;
                    if (var3_3 == 94401) break block7;
                    if (var3_3 != 94407 || !var1_1.equals("_ai")) ** GOTO lbl-1000
                    var3_3 = 1;
                    break block8;
                }
                if (!var1_1.equals("_ac")) ** GOTO lbl-1000
                var3_3 = 0;
                break block8;
            }
            if (var1_1.equals("_aa")) {
                var3_3 = 2;
            } else lbl-1000:
            // 3 sources

            {
                var3_3 = -1;
            }
        }
        if (var3_3 == 0) {
            zzt.zzA().zzn(this.zza, (String)var2_2);
            return;
        }
        if (var3_3 == 1) {
            zzt.zzA().zzo(this.zza, (String)var2_2);
            return;
        }
        if (var3_3 != 2) {
            zze.zzf((String)"logScionEvent gmsg contained unsupported eventName");
            return;
        }
        zzt.zzA().zzq(this.zza, (String)var2_2);
    }
}
