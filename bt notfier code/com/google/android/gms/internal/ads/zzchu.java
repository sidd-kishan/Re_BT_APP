/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzchw
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzchw;
import java.lang.ref.WeakReference;

final class zzchu
extends zzchw
implements ViewTreeObserver.OnGlobalLayoutListener {
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> zza;

    public zzchu(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.zza = new WeakReference<ViewTreeObserver.OnGlobalLayoutListener>(onGlobalLayoutListener);
    }

    public final void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener)this.zza.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
            return;
        }
        this.zzd();
    }

    protected final void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }

    protected final void zzb(ViewTreeObserver viewTreeObserver) {
        zzt.zze();
        viewTreeObserver.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }
}
