/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.core.content.res;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public static abstract class ResourcesCompat.FontCallback {
    public static Handler getHandler(Handler handler) {
        Handler handler2 = handler;
        if (handler != null) return handler2;
        handler2 = new Handler(Looper.getMainLooper());
        return handler2;
    }

    public final void callbackFailAsync(int n, Handler handler) {
        ResourcesCompat.FontCallback.getHandler(handler).post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
        ResourcesCompat.FontCallback.getHandler(handler).post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public abstract void onFontRetrievalFailed(int var1);

    public abstract void onFontRetrieved(Typeface var1);
}
