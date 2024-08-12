/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.display.DisplayManager
 *  android.hardware.display.DisplayManager$DisplayListener
 *  android.view.Display
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzmd
 *  com.google.android.gms.internal.ads.zzme
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzmd;
import com.google.android.gms.internal.ads.zzme;

final class zzmg
implements DisplayManager.DisplayListener,
zzme {
    private final DisplayManager zza;
    private zzmd zzb;

    private zzmg(DisplayManager displayManager) {
        this.zza = displayManager;
    }

    public static zzme zzc(Context context) {
        if ((context = (DisplayManager)context.getSystemService("display")) == null) return null;
        return new zzmg((DisplayManager)context);
    }

    private final Display zzd() {
        return this.zza.getDisplay(0);
    }

    public final void onDisplayAdded(int n) {
    }

    public final void onDisplayChanged(int n) {
        zzmd zzmd2 = this.zzb;
        if (zzmd2 == null) return;
        if (n != 0) return;
        zzmd2.zza(this.zzd());
    }

    public final void onDisplayRemoved(int n) {
    }

    public final void zza(zzmd zzmd2) {
        this.zzb = zzmd2;
        this.zza.registerDisplayListener((DisplayManager.DisplayListener)this, zzamq.zzh(null));
        zzmd2.zza(this.zzd());
    }

    public final void zzb() {
        this.zza.unregisterDisplayListener((DisplayManager.DisplayListener)this);
        this.zzb = null;
    }
}
