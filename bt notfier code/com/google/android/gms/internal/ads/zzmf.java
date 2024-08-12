/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.WindowManager
 *  com.google.android.gms.internal.ads.zzmd
 *  com.google.android.gms.internal.ads.zzme
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzmd;
import com.google.android.gms.internal.ads.zzme;

final class zzmf
implements zzme {
    private final WindowManager zza;

    private zzmf(WindowManager windowManager) {
        this.zza = windowManager;
    }

    public static zzme zzc(Context context) {
        if ((context = (WindowManager)context.getSystemService("window")) == null) return null;
        return new zzmf((WindowManager)context);
    }

    public final void zza(zzmd zzmd2) {
        zzmd2.zza(this.zza.getDefaultDisplay());
    }

    public final void zzb() {
    }
}
