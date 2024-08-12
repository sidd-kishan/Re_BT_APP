/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.WindowInsets
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$BuilderImpl
 */
package androidx.core.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsCompat.BuilderImpl20
extends WindowInsetsCompat.BuilderImpl {
    private static Constructor<WindowInsets> sConstructor;
    private static boolean sConstructorFetched;
    private static Field sConsumedField;
    private static boolean sConsumedFieldFetched;
    private WindowInsets mPlatformInsets;
    private Insets mStableInsets;

    WindowInsetsCompat.BuilderImpl20() {
        this.mPlatformInsets = WindowInsetsCompat.BuilderImpl20.createWindowInsetsInstance();
    }

    WindowInsetsCompat.BuilderImpl20(WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
        this.mPlatformInsets = windowInsetsCompat.toWindowInsets();
    }

    private static WindowInsets createWindowInsetsInstance() {
        Constructor<WindowInsets> constructor;
        Field field;
        if (!sConsumedFieldFetched) {
            try {
                sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                Log.i((String)"WindowInsetsCompat", (String)"Could not retrieve WindowInsets.CONSUMED field", (Throwable)reflectiveOperationException);
            }
            sConsumedFieldFetched = true;
        }
        if ((field = sConsumedField) != null) {
            try {
                field = (WindowInsets)field.get(null);
                if (field != null) {
                    field = new WindowInsets((WindowInsets)field);
                    return field;
                }
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                Log.i((String)"WindowInsetsCompat", (String)"Could not get value from WindowInsets.CONSUMED field", (Throwable)reflectiveOperationException);
            }
        }
        if (!sConstructorFetched) {
            try {
                sConstructor = WindowInsets.class.getConstructor(Rect.class);
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                Log.i((String)"WindowInsetsCompat", (String)"Could not retrieve WindowInsets(Rect) constructor", (Throwable)reflectiveOperationException);
            }
            sConstructorFetched = true;
        }
        if ((constructor = sConstructor) == null) return null;
        try {
            field = new Rect();
            field = constructor.newInstance(field);
            return field;
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            Log.i((String)"WindowInsetsCompat", (String)"Could not invoke WindowInsets(Rect) constructor", (Throwable)reflectiveOperationException);
        }
        return null;
    }

    WindowInsetsCompat build() {
        this.applyInsetTypes();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)this.mPlatformInsets);
        windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
        windowInsetsCompat.setStableInsets(this.mStableInsets);
        return windowInsetsCompat;
    }

    void setStableInsets(Insets insets) {
        this.mStableInsets = insets;
    }

    void setSystemWindowInsets(Insets insets) {
        WindowInsets windowInsets = this.mPlatformInsets;
        if (windowInsets == null) return;
        this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
    }
}
