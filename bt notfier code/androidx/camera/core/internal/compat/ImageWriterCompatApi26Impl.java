/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.ImageWriter
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.Surface
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ImageWriterCompatApi26Impl {
    private static final String TAG = "ImageWriterCompatApi26";
    private static Method sNewInstanceMethod;

    static {
        try {
            sNewInstanceMethod = ImageWriter.class.getMethod("newInstance", Surface.class, Integer.TYPE, Integer.TYPE);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.i((String)TAG, (String)"Unable to initialize via reflection.", (Throwable)noSuchMethodException);
        }
    }

    private ImageWriterCompatApi26Impl() {
    }

    /*
     * WARNING - void declaration
     */
    static ImageWriter newInstance(Surface surface, int n, int n2) {
        void var0_3;
        int n3 = Build.VERSION.SDK_INT;
        Throwable throwable = null;
        if (n3 < 26) throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", throwable);
        try {
            surface = (ImageWriter)Preconditions.checkNotNull((Object)sNewInstanceMethod.invoke(null, surface, n, n2));
            return surface;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        throwable = var0_3;
        throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", throwable);
    }
}
