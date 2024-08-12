/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzdbx
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzdbx;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;

public final class zzcsw
implements zzdbx {
    private final zzfbi zza;

    public zzcsw(zzfbi zzfbi2) {
        this.zza = zzfbi2;
    }

    public final void zza(Context context) {
        try {
            this.zza.zzi();
            return;
        }
        catch (zzfaw zzfaw2) {
            zze.zzj((String)"Cannot invoke onPause for the mediation adapter.", (Throwable)zzfaw2);
            return;
        }
    }

    public final void zzb(Context context) {
        try {
            this.zza.zzj();
            if (context == null) return;
            this.zza.zzp(context);
            return;
        }
        catch (zzfaw zzfaw2) {
            zze.zzj((String)"Cannot invoke onResume for the mediation adapter.", (Throwable)zzfaw2);
            return;
        }
    }

    public final void zzbo(Context context) {
        try {
            this.zza.zzf();
            return;
        }
        catch (zzfaw zzfaw2) {
            zze.zzj((String)"Cannot invoke onDestroy for the mediation adapter.", (Throwable)zzfaw2);
            return;
        }
    }
}
