/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  androidx.core.os.HandlerCompat$Api28Impl
 *  androidx.core.os.HandlerCompat$Api29Impl
 */
package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.os.HandlerCompat;
import java.lang.reflect.InvocationTargetException;

/*
 * Exception performing whole class analysis ignored.
 */
public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    private HandlerCompat() {
    }

    /*
     * WARNING - void declaration
     */
    public static Handler createAsync(Looper looper) {
        void var1_7;
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync((Looper)looper);
        }
        if (Build.VERSION.SDK_INT < 17) return new Handler(looper);
        try {
            Handler handler = (Handler)Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
            return handler;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (throwable instanceof RuntimeException) throw (RuntimeException)throwable;
            if (!(throwable instanceof Error)) throw new RuntimeException(throwable);
            throw (Error)throwable;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        Log.w((String)"HandlerCompat", (String)"Unable to invoke Handler(Looper, Callback, boolean) constructor", (Throwable)var1_7);
        return new Handler(looper);
    }

    /*
     * WARNING - void declaration
     */
    public static Handler createAsync(Looper looper, Handler.Callback callback) {
        void var2_8;
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync((Looper)looper, (Handler.Callback)callback);
        }
        if (Build.VERSION.SDK_INT < 17) return new Handler(looper, callback);
        try {
            Handler handler = (Handler)Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, callback, true);
            return handler;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (throwable instanceof RuntimeException) throw (RuntimeException)throwable;
            if (!(throwable instanceof Error)) throw new RuntimeException(throwable);
            throw (Error)throwable;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        Log.w((String)"HandlerCompat", (String)"Unable to invoke Handler(Looper, Callback, boolean) constructor", (Throwable)var2_8);
        return new Handler(looper, callback);
    }

    public static boolean hasCallbacks(Handler handler, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.hasCallbacks((Handler)handler, (Runnable)runnable);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                boolean bl = (Boolean)Handler.class.getMethod("hasCallbacks", Runnable.class).invoke(handler, runnable);
                return bl;
            }
            catch (NullPointerException nullPointerException) {
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InvocationTargetException invocationTargetException) {
                Throwable throwable = invocationTargetException.getCause();
                if (throwable instanceof RuntimeException) throw (RuntimeException)throwable;
                if (!(throwable instanceof Error)) throw new RuntimeException(throwable);
                throw (Error)throwable;
            }
        } else {
            handler = null;
        }
        throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", (Throwable)handler);
    }

    public static boolean postDelayed(Handler handler, Runnable runnable, Object object, long l) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.postDelayed((Handler)handler, (Runnable)runnable, (Object)object, (long)l);
        }
        runnable = Message.obtain((Handler)handler, (Runnable)runnable);
        ((Message)runnable).obj = object;
        return handler.sendMessageDelayed((Message)runnable, l);
    }
}
