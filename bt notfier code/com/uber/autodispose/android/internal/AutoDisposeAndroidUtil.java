/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.uber.autodispose.android.AutoDisposeAndroidPlugins
 *  com.uber.autodispose.android.internal._$$Lambda$AutoDisposeAndroidUtil$sOrUUQiHwko57VUWlJiVZGc2QjA
 *  io.reactivex.functions.BooleanSupplier
 */
package com.uber.autodispose.android.internal;

import android.os.Looper;
import com.uber.autodispose.android.AutoDisposeAndroidPlugins;
import com.uber.autodispose.android.internal._$;
import io.reactivex.functions.BooleanSupplier;

public class AutoDisposeAndroidUtil {
    private static final BooleanSupplier MAIN_THREAD_CHECK = _$.Lambda.AutoDisposeAndroidUtil.sOrUUQiHwko57VUWlJiVZGc2QjA.INSTANCE;

    private AutoDisposeAndroidUtil() {
    }

    public static boolean isMainThread() {
        return AutoDisposeAndroidPlugins.onCheckMainThread((BooleanSupplier)MAIN_THREAD_CHECK);
    }

    static /* synthetic */ boolean lambda$static$0() throws Exception {
        boolean bl = Looper.myLooper() == Looper.getMainLooper();
        return bl;
    }
}
