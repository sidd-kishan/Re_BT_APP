/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;

class CalleeHandler {
    private CalleeHandler() {
    }

    static Handler create() {
        Handler handler = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
        return handler;
    }
}
