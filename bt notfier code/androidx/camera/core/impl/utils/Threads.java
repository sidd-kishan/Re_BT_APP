/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils;

import android.os.Looper;
import androidx.core.util.Preconditions;

public final class Threads {
    private Threads() {
    }

    public static void checkBackgroundThread() {
        Preconditions.checkState((boolean)Threads.isBackgroundThread(), (String)"In application's main thread");
    }

    public static void checkMainThread() {
        Preconditions.checkState((boolean)Threads.isMainThread(), (String)"Not in application's main thread");
    }

    public static boolean isBackgroundThread() {
        return Threads.isMainThread() ^ true;
    }

    public static boolean isMainThread() {
        boolean bl = Looper.getMainLooper().getThread() == Thread.currentThread();
        return bl;
    }
}
