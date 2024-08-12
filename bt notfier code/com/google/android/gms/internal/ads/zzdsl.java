/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  com.google.android.gms.internal.ads.zzdsr
 */
package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzdsr;

final class zzdsl
implements View.OnTouchListener {
    private final zzdsr zza;

    zzdsl(zzdsr zzdsr2) {
        this.zza = zzdsr2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zza.zze(view, motionEvent);
        return false;
    }
}
