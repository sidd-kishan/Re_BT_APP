/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.View
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Builder
 */
package androidx.core.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import java.lang.reflect.Field;

static class WindowInsetsCompat.Api21ReflectionHolder {
    private static Field sContentInsets;
    private static boolean sReflectionSucceeded;
    private static Field sStableInsets;
    private static Field sViewAttachInfoField;

    static {
        try {
            Field field;
            sViewAttachInfoField = field = View.class.getDeclaredField("mAttachInfo");
            field.setAccessible(true);
            Class<?> clazz = Class.forName("android.view.View$AttachInfo");
            sStableInsets = field = clazz.getDeclaredField("mStableInsets");
            field.setAccessible(true);
            sContentInsets = field = clazz.getDeclaredField("mContentInsets");
            field.setAccessible(true);
            sReflectionSucceeded = true;
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to get visible insets from AttachInfo ");
            stringBuilder.append(reflectiveOperationException.getMessage());
            Log.w((String)"WindowInsetsCompat", (String)stringBuilder.toString(), (Throwable)reflectiveOperationException);
        }
    }

    private WindowInsetsCompat.Api21ReflectionHolder() {
    }

    public static WindowInsetsCompat getRootWindowInsets(View object) {
        if (!sReflectionSucceeded) return null;
        if (!object.isAttachedToWindow()) return null;
        View view = object.getRootView();
        try {
            Object object2 = sViewAttachInfoField.get(view);
            if (object2 == null) return null;
            view = (Rect)sStableInsets.get(object2);
            object2 = (Rect)sContentInsets.get(object2);
            if (view == null) return null;
            if (object2 == null) return null;
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder();
            view = builder.setStableInsets(Insets.of((Rect)view)).setSystemWindowInsets(Insets.of((Rect)object2)).build();
            view.setRootWindowInsets((WindowInsetsCompat)view);
            view.copyRootViewBounds(object.getRootView());
            return view;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to get insets from AttachInfo. ");
            ((StringBuilder)object).append(illegalAccessException.getMessage());
            Log.w((String)"WindowInsetsCompat", (String)((StringBuilder)object).toString(), (Throwable)illegalAccessException);
        }
        return null;
    }
}
