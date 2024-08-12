/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat
 *  androidx.customview.widget.ExploreByTouchHelper
 */
package androidx.customview.widget;

import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;

private class ExploreByTouchHelper.MyNodeProvider
extends AccessibilityNodeProviderCompat {
    final ExploreByTouchHelper this$0;

    ExploreByTouchHelper.MyNodeProvider(ExploreByTouchHelper exploreByTouchHelper) {
        this.this$0 = exploreByTouchHelper;
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int n) {
        return AccessibilityNodeInfoCompat.obtain((AccessibilityNodeInfoCompat)this.this$0.obtainAccessibilityNodeInfo(n));
    }

    public AccessibilityNodeInfoCompat findFocus(int n) {
        n = n == 2 ? this.this$0.mAccessibilityFocusedVirtualViewId : this.this$0.mKeyboardFocusedVirtualViewId;
        if (n != Integer.MIN_VALUE) return this.createAccessibilityNodeInfo(n);
        return null;
    }

    public boolean performAction(int n, int n2, Bundle bundle) {
        return this.this$0.performAction(n, n2, bundle);
    }
}
