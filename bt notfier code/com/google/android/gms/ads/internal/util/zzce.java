/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 *  com.google.android.gms.internal.ads.zzcar
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.internal.ads.zzcar;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.concurrent.Callable;

public final class zzce {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    @Deprecated
    public static <T> T zza(Context context, Callable<T> callable) {
        StrictMode.ThreadPolicy threadPolicy;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"Unexpected exception.", (Throwable)throwable);
            zzcar.zza((Context)context).zzd(throwable, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
        try {
            StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder(threadPolicy);
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)builder.permitDiskReads().permitDiskWrites().build());
            callable = callable.call();
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
        return (T)callable;
    }
}
