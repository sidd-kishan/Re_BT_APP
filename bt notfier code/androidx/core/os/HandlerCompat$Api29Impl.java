/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.core.os;

import android.os.Handler;

private static class HandlerCompat.Api29Impl {
    private HandlerCompat.Api29Impl() {
    }

    public static boolean hasCallbacks(Handler handler, Runnable runnable) {
        return handler.hasCallbacks(runnable);
    }
}
