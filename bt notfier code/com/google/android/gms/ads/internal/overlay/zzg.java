/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.widget.RelativeLayout
 *  com.google.android.gms.ads.internal.util.zzav
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzav;

final class zzg
extends RelativeLayout {
    final zzav zza;
    boolean zzb;

    public zzg(Context context, String string, String string2, String string3) {
        super(context);
        context = new zzav(context, string);
        this.zza = context;
        context.zzd(string2);
        this.zza.zzc(string3);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzb) return false;
        this.zza.zza(motionEvent);
        return false;
    }
}
