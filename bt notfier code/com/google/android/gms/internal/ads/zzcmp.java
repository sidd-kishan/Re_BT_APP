/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  com.google.android.gms.internal.ads.zzcdy
 *  com.google.android.gms.internal.ads.zzcms
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcdy;
import com.google.android.gms.internal.ads.zzcms;

final class zzcmp
implements View.OnAttachStateChangeListener {
    final zzcdy zza;
    final zzcms zzb;

    zzcmp(zzcms zzcms2, zzcdy zzcdy2) {
        this.zzb = zzcms2;
        this.zza = zzcdy2;
    }

    public final void onViewAttachedToWindow(View view) {
        zzcms.zzi((zzcms)this.zzb, (View)view, (zzcdy)this.zza, (int)10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
