/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.WindowManager
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdoe
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdoe;
import java.util.Map;

final class zzdoa
implements zzbpr {
    private final zzdoe zza;
    private final View zzb;
    private final WindowManager zzc;

    zzdoa(zzdoe zzdoe2, View view, WindowManager windowManager) {
        this.zza = zzdoe2;
        this.zzb = view;
        this.zzc = windowManager;
    }

    public final void zza(Object object, Map map) {
        this.zza.zzb(this.zzb, this.zzc, (zzcml)object, map);
    }
}
