/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzcml;

final class zzdoc
implements ViewTreeObserver.OnScrollChangedListener {
    private final View zza;
    private final zzcml zzb;
    private final String zzc;
    private final WindowManager.LayoutParams zzd;
    private final int zze;
    private final WindowManager zzf;

    zzdoc(View view, zzcml zzcml2, String string, WindowManager.LayoutParams layoutParams, int n, WindowManager windowManager) {
        this.zza = view;
        this.zzb = zzcml2;
        this.zzc = string;
        this.zzd = layoutParams;
        this.zze = n;
        this.zzf = windowManager;
    }

    public final void onScrollChanged() {
        View view = this.zza;
        zzcml zzcml2 = this.zzb;
        String string = this.zzc;
        WindowManager.LayoutParams layoutParams = this.zzd;
        int n = this.zze;
        WindowManager windowManager = this.zzf;
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) return;
        if (zzcml2.zzH().getWindowToken() == null) return;
        layoutParams.y = !"1".equals(string) && !"2".equals(string) ? rect.top - n : rect.bottom - n;
        windowManager.updateViewLayout(zzcml2.zzH(), (ViewGroup.LayoutParams)layoutParams);
    }
}
