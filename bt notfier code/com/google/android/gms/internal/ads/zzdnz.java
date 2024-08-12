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

final class zzdnz
implements zzbpr {
    private final zzdoe zza;
    private final WindowManager zzb;
    private final View zzc;

    zzdnz(zzdoe zzdoe2, WindowManager windowManager, View view) {
        this.zza = zzdoe2;
        this.zzb = windowManager;
        this.zzc = view;
    }

    public final void zza(Object object, Map map) {
        this.zza.zzd(this.zzb, this.zzc, (zzcml)object, map);
    }
}
