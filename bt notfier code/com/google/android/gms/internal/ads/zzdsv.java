/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.google.android.gms.ads.internal.util.zzav
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zzav;
import com.google.android.gms.internal.ads.zzcml;
import java.util.ArrayList;

public final class zzdsv
extends FrameLayout {
    private final zzav zza;

    public zzdsv(Context context, View view, zzav zzav2) {
        super(context);
        this.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.addView(view);
        this.zza = zzav2;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zza.zza(motionEvent);
        return false;
    }

    public final void removeAllViews() {
        int n;
        ArrayList<zzcml> arrayList = new ArrayList<zzcml>();
        int n2 = 0;
        for (n = 0; n < this.getChildCount(); ++n) {
            View view = this.getChildAt(n);
            if (view == null || !(view instanceof zzcml)) continue;
            arrayList.add((zzcml)view);
        }
        super.removeAllViews();
        int n3 = arrayList.size();
        n = n2;
        while (n < n3) {
            ((zzcml)arrayList.get(n)).destroy();
            ++n;
        }
    }
}
