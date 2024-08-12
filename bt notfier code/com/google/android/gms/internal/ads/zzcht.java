/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  com.google.android.gms.internal.ads.zzchu
 *  com.google.android.gms.internal.ads.zzchv
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.ads.zzchu;
import com.google.android.gms.internal.ads.zzchv;

public final class zzcht {
    public static final void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new zzchu(view, onGlobalLayoutListener).zzc();
    }

    public static final void zzb(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new zzchv(view, onScrollChangedListener).zzc();
    }
}
