/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.util.Log
 *  android.view.View
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.graphics.ColorUtils
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.ColorUtils;

public class ThemeUtils {
    static final int[] ACTIVATED_STATE_SET;
    static final int[] CHECKED_STATE_SET;
    static final int[] DISABLED_STATE_SET;
    static final int[] EMPTY_STATE_SET;
    static final int[] FOCUSED_STATE_SET;
    static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET;
    static final int[] PRESSED_STATE_SET;
    static final int[] SELECTED_STATE_SET;
    private static final String TAG = "ThemeUtils";
    private static final int[] TEMP_ARRAY;
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE;

    static {
        TL_TYPED_VALUE = new ThreadLocal();
        DISABLED_STATE_SET = new int[]{-16842910};
        FOCUSED_STATE_SET = new int[]{16842908};
        ACTIVATED_STATE_SET = new int[]{16843518};
        PRESSED_STATE_SET = new int[]{16842919};
        CHECKED_STATE_SET = new int[]{0x10100A0};
        SELECTED_STATE_SET = new int[]{0x10100A1};
        NOT_PRESSED_OR_FOCUSED_STATE_SET = new int[]{-16842919, -16842908};
        EMPTY_STATE_SET = new int[0];
        TEMP_ARRAY = new int[1];
    }

    private ThemeUtils() {
    }

    public static void checkAppCompatTheme(View view, Context context) {
        context = context.obtainStyledAttributes(R.styleable.AppCompatTheme);
        try {
            if (context.hasValue(R.styleable.AppCompatTheme_windowActionBar)) return;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(view.getClass());
            stringBuilder.append(" is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            Log.e((String)TAG, (String)stringBuilder.toString());
            return;
        }
        finally {
            context.recycle();
        }
    }

    public static ColorStateList createDisabledStateList(int n, int n2) {
        return new ColorStateList((int[][])new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{n2, n});
    }

    public static int getDisabledThemeAttrColor(Context context, int n) {
        Object object = ThemeUtils.getThemeAttrColorStateList(context, n);
        if (object != null && object.isStateful()) {
            return object.getColorForState(DISABLED_STATE_SET, object.getDefaultColor());
        }
        object = ThemeUtils.getTypedValue();
        context.getTheme().resolveAttribute(0x1010033, (TypedValue)object, true);
        return ThemeUtils.getThemeAttrColor(context, n, object.getFloat());
    }

    public static int getThemeAttrColor(Context context, int n) {
        int[] nArray = TEMP_ARRAY;
        nArray[0] = n;
        context = TintTypedArray.obtainStyledAttributes((Context)context, null, (int[])nArray);
        try {
            n = context.getColor(0, 0);
            return n;
        }
        finally {
            context.recycle();
        }
    }

    static int getThemeAttrColor(Context context, int n, float f) {
        n = ThemeUtils.getThemeAttrColor(context, n);
        return ColorUtils.setAlphaComponent((int)n, (int)Math.round((float)Color.alpha((int)n) * f));
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int n) {
        Object object = TEMP_ARRAY;
        object[0] = n;
        context = TintTypedArray.obtainStyledAttributes((Context)context, null, (int[])object);
        try {
            object = context.getColorStateList(0);
            return object;
        }
        finally {
            context.recycle();
        }
    }

    private static TypedValue getTypedValue() {
        TypedValue typedValue;
        TypedValue typedValue2 = typedValue = TL_TYPED_VALUE.get();
        if (typedValue != null) return typedValue2;
        typedValue2 = new TypedValue();
        TL_TYPED_VALUE.set(typedValue2);
        return typedValue2;
    }
}
