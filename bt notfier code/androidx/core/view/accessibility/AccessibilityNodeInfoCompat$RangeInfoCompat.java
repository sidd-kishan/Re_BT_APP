/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityNodeInfo$RangeInfo
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public static class AccessibilityNodeInfoCompat.RangeInfoCompat {
    public static final int RANGE_TYPE_FLOAT = 1;
    public static final int RANGE_TYPE_INT = 0;
    public static final int RANGE_TYPE_PERCENT = 2;
    final Object mInfo;

    AccessibilityNodeInfoCompat.RangeInfoCompat(Object object) {
        this.mInfo = object;
    }

    public static AccessibilityNodeInfoCompat.RangeInfoCompat obtain(int n, float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT < 19) return new AccessibilityNodeInfoCompat.RangeInfoCompat(null);
        return new AccessibilityNodeInfoCompat.RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain((int)n, (float)f, (float)f2, (float)f3));
    }

    public float getCurrent() {
        if (Build.VERSION.SDK_INT < 19) return 0.0f;
        return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getCurrent();
    }

    public float getMax() {
        if (Build.VERSION.SDK_INT < 19) return 0.0f;
        return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getMax();
    }

    public float getMin() {
        if (Build.VERSION.SDK_INT < 19) return 0.0f;
        return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getMin();
    }

    public int getType() {
        if (Build.VERSION.SDK_INT < 19) return 0;
        return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getType();
    }
}
