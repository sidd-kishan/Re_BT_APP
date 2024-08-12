/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  com.google.android.gms.internal.ads.zzchw
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.ads.zzchw;
import java.lang.ref.WeakReference;

final class zzchv
extends zzchw
implements ViewTreeObserver.OnScrollChangedListener {
    private final WeakReference<ViewTreeObserver.OnScrollChangedListener> zza;

    public zzchv(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.zza = new WeakReference<ViewTreeObserver.OnScrollChangedListener>(onScrollChangedListener);
    }

    public final void onScrollChanged() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = (ViewTreeObserver.OnScrollChangedListener)this.zza.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
            return;
        }
        this.zzd();
    }

    protected final void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)this);
    }

    protected final void zzb(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)this);
    }
}
