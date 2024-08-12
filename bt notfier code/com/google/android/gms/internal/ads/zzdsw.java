/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.FrameLayout
 *  android.widget.PopupWindow
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.util.PlatformVersion
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.PlatformVersion;

public final class zzdsw {
    private Context zza;
    private PopupWindow zzb;

    public final void zza(Context context, View view) {
        if (!PlatformVersion.isAtLeastKitKat()) return;
        if (PlatformVersion.isAtLeastLollipop()) return;
        Window window = context instanceof Activity ? ((Activity)context).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity)context).isDestroyed()) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.addView(view, -1, -1);
            view = new PopupWindow((View)frameLayout, 1, 1, false);
            view.setOutsideTouchable(true);
            view.setClippingEnabled(false);
            zze.zzd((String)"Displaying the 1x1 popup off the screen.");
            try {
                view.showAtLocation(window.getDecorView(), 0, -1, -1);
            }
            catch (Exception exception) {}
        }
        view = null;
        this.zzb = view;
        if (view == null) {
            context = null;
        }
        this.zza = context;
    }

    public final void zzb() {
        Context context = this.zza;
        if (context == null) return;
        if (this.zzb == null) {
            return;
        }
        if (!(context instanceof Activity && ((Activity)context).isDestroyed() || !this.zzb.isShowing())) {
            this.zzb.dismiss();
        }
        this.zza = null;
        this.zzb = null;
    }
}
