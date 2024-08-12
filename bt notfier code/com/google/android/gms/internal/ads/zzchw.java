/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

abstract class zzchw {
    private final WeakReference<View> zza;

    public zzchw(View view) {
        this.zza = new WeakReference<View>(view);
    }

    protected abstract void zza(ViewTreeObserver var1);

    protected abstract void zzb(ViewTreeObserver var1);

    public final void zzc() {
        ViewTreeObserver viewTreeObserver = this.zze();
        if (viewTreeObserver == null) return;
        this.zza(viewTreeObserver);
    }

    public final void zzd() {
        ViewTreeObserver viewTreeObserver = this.zze();
        if (viewTreeObserver == null) return;
        this.zzb(viewTreeObserver);
    }

    protected final ViewTreeObserver zze() {
        View view = (View)this.zza.get();
        if (view == null) {
            return null;
        }
        if ((view = view.getViewTreeObserver()) == null) return null;
        if (view.isAlive()) return view;
        return null;
    }
}
