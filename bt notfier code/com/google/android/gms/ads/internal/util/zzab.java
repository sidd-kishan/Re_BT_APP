/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 *  com.google.android.gms.ads.internal.util.zzac
 */
package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.gms.ads.internal.util.zzac;

final class zzab
implements View.OnApplyWindowInsetsListener {
    private final zzac zza;
    private final Activity zzb;

    zzab(zzac zzac2, Activity activity) {
        this.zza = zzac2;
        this.zzb = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzac.zzs((Activity)this.zzb, (View)view, (WindowInsets)windowInsets);
    }
}
