/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbqe
 *  com.google.android.gms.internal.ads.zzbtm
 *  com.google.android.gms.internal.ads.zzbtv
 *  com.google.android.gms.internal.ads.zzbuk
 *  com.google.android.gms.internal.ads.zzchl
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqe;
import com.google.android.gms.internal.ads.zzbtm;
import com.google.android.gms.internal.ads.zzbtv;
import com.google.android.gms.internal.ads.zzbuk;
import com.google.android.gms.internal.ads.zzchl;
import org.json.JSONException;
import org.json.JSONObject;

final class zzbuj
implements zzbqe {
    final zzbuk zza;
    private final zzbtm zzb;
    private final zzchl zzc;

    public zzbuj(zzbuk zzbuk2, zzbtm zzbtm2, zzchl zzchl2) {
        this.zza = zzbuk2;
        this.zzb = zzbtm2;
        this.zzc = zzchl2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void zza(JSONObject jSONObject) {
        Throwable throwable2;
        block5: {
            try {
                this.zzc.zzc(zzbuk.zzc((zzbuk)this.zza).zza(jSONObject));
                jSONObject = this.zzb;
            }
            catch (IllegalStateException illegalStateException) {
                jSONObject = this.zzb;
            }
            {
                catch (Throwable throwable2) {
                    break block5;
                }
                catch (JSONException jSONException) {}
                {
                    this.zzc.zzd((Throwable)jSONException);
                    jSONObject = this.zzb;
                }
            }
            jSONObject.zzb();
            return;
        }
        this.zzb.zzb();
        throw throwable2;
    }

    /*
     * Unable to fully structure code
     */
    public final void zzb(String var1_1) {
        if (var1_1 != null) ** GOTO lbl8
        try {
            block3: {
                var1_1 = this.zzc;
                var2_4 = new zzbtv();
                var1_1.zzd((Throwable)var2_4);
                break block3;
lbl8:
                // 1 sources

                var2_5 = this.zzc;
                var3_6 = new zzbtv(var1_1);
                var2_5.zzd((Throwable)var3_6);
            }
            var1_1 = this.zzb;
        }
        catch (Throwable var1_2) {
            this.zzb.zzb();
            throw var1_2;
        }
        catch (IllegalStateException var1_3) {
            var1_1 = this.zzb;
        }
        var1_1.zzb();
    }
}
