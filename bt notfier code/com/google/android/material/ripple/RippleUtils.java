/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.os.Build$VERSION
 *  android.util.StateSet
 *  androidx.core.graphics.ColorUtils
 */
package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;

public class RippleUtils {
    private static final int[] FOCUSED_STATE_SET;
    private static final int[] HOVERED_FOCUSED_STATE_SET;
    private static final int[] HOVERED_STATE_SET;
    private static final int[] PRESSED_STATE_SET;
    private static final int[] SELECTED_FOCUSED_STATE_SET;
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET;
    private static final int[] SELECTED_HOVERED_STATE_SET;
    private static final int[] SELECTED_PRESSED_STATE_SET;
    private static final int[] SELECTED_STATE_SET;
    public static final boolean USE_FRAMEWORK_RIPPLE;

    static {
        boolean bl = Build.VERSION.SDK_INT >= 21;
        USE_FRAMEWORK_RIPPLE = bl;
        PRESSED_STATE_SET = new int[]{16842919};
        HOVERED_FOCUSED_STATE_SET = new int[]{16843623, 16842908};
        FOCUSED_STATE_SET = new int[]{16842908};
        HOVERED_STATE_SET = new int[]{16843623};
        SELECTED_PRESSED_STATE_SET = new int[]{0x10100A1, 16842919};
        SELECTED_HOVERED_FOCUSED_STATE_SET = new int[]{0x10100A1, 16843623, 16842908};
        SELECTED_FOCUSED_STATE_SET = new int[]{0x10100A1, 16842908};
        SELECTED_HOVERED_STATE_SET = new int[]{0x10100A1, 16843623};
        SELECTED_STATE_SET = new int[]{0x10100A1};
    }

    private RippleUtils() {
    }

    public static ColorStateList convertToRippleDrawableColor(ColorStateList colorStateList) {
        if (USE_FRAMEWORK_RIPPLE) {
            int[] nArray = SELECTED_STATE_SET;
            int n = RippleUtils.getColorForState(colorStateList, SELECTED_PRESSED_STATE_SET);
            int[] nArray2 = StateSet.NOTHING;
            int n2 = RippleUtils.getColorForState(colorStateList, PRESSED_STATE_SET);
            return new ColorStateList((int[][])new int[][]{nArray, nArray2}, new int[]{n, n2});
        }
        int[] nArray = SELECTED_PRESSED_STATE_SET;
        int n = RippleUtils.getColorForState(colorStateList, nArray);
        int[] nArray3 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        int n3 = RippleUtils.getColorForState(colorStateList, nArray3);
        int[] nArray4 = SELECTED_FOCUSED_STATE_SET;
        int n4 = RippleUtils.getColorForState(colorStateList, nArray4);
        int[] nArray5 = SELECTED_HOVERED_STATE_SET;
        int n5 = RippleUtils.getColorForState(colorStateList, nArray5);
        int[] nArray6 = SELECTED_STATE_SET;
        int[] nArray7 = PRESSED_STATE_SET;
        int n6 = RippleUtils.getColorForState(colorStateList, nArray7);
        int[] nArray8 = HOVERED_FOCUSED_STATE_SET;
        int n7 = RippleUtils.getColorForState(colorStateList, nArray8);
        int[] nArray9 = FOCUSED_STATE_SET;
        int n8 = RippleUtils.getColorForState(colorStateList, nArray9);
        int[] nArray10 = HOVERED_STATE_SET;
        int n9 = RippleUtils.getColorForState(colorStateList, nArray10);
        return new ColorStateList((int[][])new int[][]{nArray, nArray3, nArray4, nArray5, nArray6, nArray7, nArray8, nArray9, nArray10, StateSet.NOTHING}, new int[]{n, n3, n4, n5, 0, n6, n7, n8, n9, 0});
    }

    private static int doubleAlpha(int n) {
        return ColorUtils.setAlphaComponent((int)n, (int)Math.min(Color.alpha((int)n) * 2, 255));
    }

    private static int getColorForState(ColorStateList colorStateList, int[] nArray) {
        int n = colorStateList != null ? colorStateList.getColorForState(nArray, colorStateList.getDefaultColor()) : 0;
        int n2 = n;
        if (!USE_FRAMEWORK_RIPPLE) return n2;
        n2 = RippleUtils.doubleAlpha(n);
        return n2;
    }
}
