/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.widget.CheckedTextView
 */
package androidx.core.widget;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CheckedTextView;
import java.lang.reflect.Field;

private static class CheckedTextViewCompat.Api14Impl {
    private static Field sCheckMarkDrawableField;
    private static boolean sResolved;

    private CheckedTextViewCompat.Api14Impl() {
    }

    static Drawable getCheckMarkDrawable(CheckedTextView checkedTextView) {
        Field field;
        if (!sResolved) {
            try {
                sCheckMarkDrawableField = field = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                field.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                Log.i((String)"CheckedTextViewCompat", (String)"Failed to retrieve mCheckMarkDrawable field", (Throwable)noSuchFieldException);
            }
            sResolved = true;
        }
        if ((field = sCheckMarkDrawableField) == null) return null;
        try {
            checkedTextView = (Drawable)field.get(checkedTextView);
            return checkedTextView;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.i((String)"CheckedTextViewCompat", (String)"Failed to get check mark drawable via reflection", (Throwable)illegalAccessException);
            sCheckMarkDrawableField = null;
        }
        return null;
    }
}
