/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.ScaleGestureDetector
 */
package androidx.core.view;

import android.os.Build;
import android.view.ScaleGestureDetector;

public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        if (Build.VERSION.SDK_INT < 19) return false;
        return scaleGestureDetector.isQuickScaleEnabled();
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object object) {
        return ScaleGestureDetectorCompat.isQuickScaleEnabled((ScaleGestureDetector)object);
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean bl) {
        if (Build.VERSION.SDK_INT < 19) return;
        scaleGestureDetector.setQuickScaleEnabled(bl);
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object object, boolean bl) {
        ScaleGestureDetectorCompat.setQuickScaleEnabled((ScaleGestureDetector)object, bl);
    }
}
