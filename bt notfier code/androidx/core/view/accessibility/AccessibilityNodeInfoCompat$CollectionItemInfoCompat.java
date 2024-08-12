/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public static class AccessibilityNodeInfoCompat.CollectionItemInfoCompat {
    final Object mInfo;

    AccessibilityNodeInfoCompat.CollectionItemInfoCompat(Object object) {
        this.mInfo = object;
    }

    public static AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain(int n, int n2, int n3, int n4, boolean bl) {
        if (Build.VERSION.SDK_INT < 19) return new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(null);
        return new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n, (int)n2, (int)n3, (int)n4, (boolean)bl));
    }

    public static AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n, (int)n2, (int)n3, (int)n4, (boolean)bl, (boolean)bl2));
        }
        if (Build.VERSION.SDK_INT < 19) return new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(null);
        return new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n, (int)n2, (int)n3, (int)n4, (boolean)bl));
    }

    public int getColumnIndex() {
        if (Build.VERSION.SDK_INT < 19) return 0;
        return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getColumnIndex();
    }

    public int getColumnSpan() {
        if (Build.VERSION.SDK_INT < 19) return 0;
        return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getColumnSpan();
    }

    public int getRowIndex() {
        if (Build.VERSION.SDK_INT < 19) return 0;
        return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getRowIndex();
    }

    public int getRowSpan() {
        if (Build.VERSION.SDK_INT < 19) return 0;
        return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getRowSpan();
    }

    @Deprecated
    public boolean isHeading() {
        if (Build.VERSION.SDK_INT < 19) return false;
        return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).isHeading();
    }

    public boolean isSelected() {
        if (Build.VERSION.SDK_INT < 21) return false;
        return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).isSelected();
    }
}
