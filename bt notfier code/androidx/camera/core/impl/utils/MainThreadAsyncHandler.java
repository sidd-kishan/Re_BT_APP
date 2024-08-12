/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.core.os.HandlerCompat
 */
package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;

public final class MainThreadAsyncHandler {
    private static volatile Handler sHandler;

    private MainThreadAsyncHandler() {
    }

    public static Handler getInstance() {
        if (sHandler != null) {
            return sHandler;
        }
        synchronized (MainThreadAsyncHandler.class) {
            if (sHandler != null) return sHandler;
            sHandler = HandlerCompat.createAsync((Looper)Looper.getMainLooper());
            return sHandler;
        }
    }
}
