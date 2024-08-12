/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionInfo
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public static class AccessibilityNodeInfoCompat.CollectionInfoCompat {
    public static final int SELECTION_MODE_MULTIPLE = 2;
    public static final int SELECTION_MODE_NONE = 0;
    public static final int SELECTION_MODE_SINGLE = 1;
    final Object mInfo;

    AccessibilityNodeInfoCompat.CollectionInfoCompat(Object object) {
        this.mInfo = object;
    }

    public static AccessibilityNodeInfoCompat.CollectionInfoCompat obtain(int n, int n2, boolean bl) {
        if (Build.VERSION.SDK_INT < 19) return new AccessibilityNodeInfoCompat.CollectionInfoCompat(null);
        return new AccessibilityNodeInfoCompat.CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain((int)n, (int)n2, (boolean)bl));
    }

    public static AccessibilityNodeInfoCompat.CollectionInfoCompat obtain(int n, int n2, boolean bl, int n3) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new AccessibilityNodeInfoCompat.CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain((int)n, (int)n2, (boolean)bl, (int)n3));
        }
        if (Build.VERSION.SDK_INT < 19) return new AccessibilityNodeInfoCompat.CollectionInfoCompat(null);
        return new AccessibilityNodeInfoCompat.CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain((int)n, (int)n2, (boolean)bl));
    }

    public int getColumnCount() {
        if (Build.VERSION.SDK_INT < 19) return -1;
        return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getColumnCount();
    }

    public int getRowCount() {
        if (Build.VERSION.SDK_INT < 19) return -1;
        return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getRowCount();
    }

    public int getSelectionMode() {
        if (Build.VERSION.SDK_INT < 21) return 0;
        return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getSelectionMode();
    }

    public boolean isHierarchical() {
        if (Build.VERSION.SDK_INT < 19) return false;
        return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).isHierarchical();
    }
}
