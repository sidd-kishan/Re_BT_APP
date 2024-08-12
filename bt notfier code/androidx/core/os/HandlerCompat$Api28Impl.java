/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 */
package androidx.core.os;

import android.os.Handler;
import android.os.Looper;

private static class HandlerCompat.Api28Impl {
    private HandlerCompat.Api28Impl() {
    }

    public static Handler createAsync(Looper looper) {
        return Handler.createAsync((Looper)looper);
    }

    public static Handler createAsync(Looper looper, Handler.Callback callback) {
        return Handler.createAsync((Looper)looper, (Handler.Callback)callback);
    }

    public static boolean postDelayed(Handler handler, Runnable runnable, Object object, long l) {
        return handler.postDelayed(runnable, object, l);
    }
}
