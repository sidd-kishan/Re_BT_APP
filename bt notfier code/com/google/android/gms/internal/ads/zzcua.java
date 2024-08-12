/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzawd
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzctm
 *  com.google.android.gms.internal.ads.zzctp
 *  com.google.android.gms.internal.ads.zzctz
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzctm;
import com.google.android.gms.internal.ads.zzctp;
import com.google.android.gms.internal.ads.zzctz;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcua
implements zzawd {
    private zzcml zza;
    private final Executor zzb;
    private final zzctm zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzctp zzg = new zzctp();

    public zzcua(Executor executor, zzctm zzctm2, Clock clock) {
        this.zzb = executor;
        this.zzc = zzctm2;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            JSONObject jSONObject = this.zzc.zza(this.zzg);
            if (this.zza == null) return;
            Executor executor = this.zzb;
            zzctz zzctz2 = new zzctz(this, jSONObject);
            executor.execute((Runnable)zzctz2);
            return;
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzb((String)"Failed to call video active view js", (Throwable)jSONException);
            return;
        }
    }

    public final void zza(zzcml zzcml2) {
        this.zza = zzcml2;
    }

    public final void zzb() {
        this.zze = false;
    }

    public final void zzc(zzawc zzawc2) {
        zzctp zzctp2 = this.zzg;
        boolean bl = this.zzf ? false : zzawc2.zzj;
        zzctp2.zza = bl;
        zzctp2.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzawc2;
        if (!this.zze) return;
        this.zzg();
    }

    public final void zzd() {
        this.zze = true;
        this.zzg();
    }

    public final void zze(boolean bl) {
        this.zzf = bl;
    }

    final /* synthetic */ void zzf(JSONObject jSONObject) {
        this.zza.zzr("AFMA_updateActiveView", jSONObject);
    }
}
