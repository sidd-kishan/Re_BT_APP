/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 *  com.google.android.gms.internal.ads.zzfmj
 */
package com.google.android.gms.internal.ads;

import android.os.StrictMode;
import com.google.android.gms.internal.ads.zzfmj;

public final class zzbjn {
    public static <T> T zza(zzfmj<T> object) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder(threadPolicy);
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)builder.permitDiskReads().permitDiskWrites().build());
            object = object.zza();
            return (T)object;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }
}
