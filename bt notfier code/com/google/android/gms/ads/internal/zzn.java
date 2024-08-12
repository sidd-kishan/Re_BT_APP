/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  com.google.android.gms.ads.internal.zzs
 */
package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzs;

final class zzn
implements View.OnTouchListener {
    final zzs zza;

    zzn(zzs zzs2) {
        this.zza = zzs2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (zzs.zzg((zzs)this.zza) == null) return false;
        zzs.zzg((zzs)this.zza).zzd(motionEvent);
        return false;
    }
}
