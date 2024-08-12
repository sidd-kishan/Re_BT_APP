/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 */
package com.google.android.gms.internal.ads;

import android.os.Build;
import android.view.View;

public final class zzfhl {
    public static float zza(View view) {
        if (Build.VERSION.SDK_INT < 21) return 0.0f;
        return view.getZ();
    }

    public static String zzb(View view) {
        int n;
        if (Build.VERSION.SDK_INT >= 19) {
            if (!view.isAttachedToWindow()) return "notAttached";
        }
        if ((n = view.getVisibility()) != 0) {
            if (n == 4) return "viewInvisible";
            if (n == 8) return "viewGone";
            return "viewNotVisible";
        }
        if (view.getAlpha() != 0.0f) return null;
        return "viewAlphaZero";
    }
}
