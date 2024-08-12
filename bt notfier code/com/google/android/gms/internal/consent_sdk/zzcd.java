/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.google.android.gms.internal.consent_sdk.zzcg
 */
package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.consent_sdk.zzcg;
import java.util.concurrent.Executor;

public final class zzcd {
    public static final Handler zza = new Handler(Looper.getMainLooper());
    public static final Executor zzb = new zzcg("Google consent worker");

    public static void zza() {
        if (Looper.myLooper() != Looper.getMainLooper()) throw new IllegalStateException("Method must be call on main thread.");
    }
}
