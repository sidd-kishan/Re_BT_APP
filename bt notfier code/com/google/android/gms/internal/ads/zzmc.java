/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzaln
 */
package com.google.android.gms.internal.ads;

import android.view.Surface;
import com.google.android.gms.internal.ads.zzaln;

final class zzmc {
    public static void zza(Surface surface, float f) {
        int n = f == 0.0f ? 0 : 1;
        try {
            surface.setFrameRate(f, n);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            zzaln.zzb((String)"VideoFrameReleaseHelper", (String)"Failed to call Surface.setFrameRate", (Throwable)illegalStateException);
            return;
        }
    }
}
