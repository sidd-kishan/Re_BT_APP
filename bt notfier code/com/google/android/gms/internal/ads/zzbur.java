/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbqe
 *  com.google.android.gms.internal.ads.zzbtv
 *  com.google.android.gms.internal.ads.zzbus
 *  com.google.android.gms.internal.ads.zzchl
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqe;
import com.google.android.gms.internal.ads.zzbtv;
import com.google.android.gms.internal.ads.zzbus;
import com.google.android.gms.internal.ads.zzchl;
import org.json.JSONException;
import org.json.JSONObject;

final class zzbur
implements zzbqe {
    final zzbus zza;
    private final zzchl zzb;

    public zzbur(zzbus zzbus2, zzchl zzchl2) {
        this.zza = zzbus2;
        this.zzb = zzchl2;
    }

    /*
     * Enabled force condition propagation
     */
    public final void zza(JSONObject jSONObject) {
        try {
            this.zzb.zzc((Object)jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            this.zzb.zzd((Throwable)jSONException);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void zzb(String var1_1) {
        if (var1_1 != null) ** GOTO lbl8
        try {
            var1_1 = this.zzb;
            var2_3 = new zzbtv();
            var1_1.zzd((Throwable)var2_3);
            return;
lbl8:
            // 1 sources

            var3_5 = this.zzb;
            var2_4 = new zzbtv(var1_1);
            var3_5.zzd((Throwable)var2_4);
lbl12:
            // 2 sources

            return;
        }
        catch (IllegalStateException var1_2) {
            ** continue;
        }
    }
}
