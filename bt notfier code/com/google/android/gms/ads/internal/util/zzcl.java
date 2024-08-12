/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzcht
 */
package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcht;

public final class zzcl {
    private final View zza;
    private Activity zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final ViewTreeObserver.OnGlobalLayoutListener zzf;

    public zzcl(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzb = activity;
        this.zza = view;
        this.zzf = onGlobalLayoutListener;
    }

    private final void zzf() {
        if (this.zzc) return;
        Activity activity = this.zzb;
        if (activity != null) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzf;
            if ((activity = zzcl.zzh(activity)) != null) {
                activity.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
        zzt.zzz();
        zzcht.zza((View)this.zza, (ViewTreeObserver.OnGlobalLayoutListener)this.zzf);
        this.zzc = true;
    }

    private final void zzg() {
        Activity activity = this.zzb;
        if (activity == null) {
            return;
        }
        if (!this.zzc) return;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzf;
        if ((activity = zzcl.zzh(activity)) != null) {
            zzt.zze();
            activity.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
        this.zzc = false;
    }

    private static ViewTreeObserver zzh(Activity activity) {
        if ((activity = activity.getWindow()) == null) {
            return null;
        }
        if ((activity = activity.getDecorView()) != null) return activity.getViewTreeObserver();
        return null;
    }

    public final void zza(Activity activity) {
        this.zzb = activity;
    }

    public final void zzb() {
        this.zze = true;
        if (!this.zzd) return;
        this.zzf();
    }

    public final void zzc() {
        this.zze = false;
        this.zzg();
    }

    public final void zzd() {
        this.zzd = true;
        if (!this.zze) return;
        this.zzf();
    }

    public final void zze() {
        this.zzd = false;
        this.zzg();
    }
}
