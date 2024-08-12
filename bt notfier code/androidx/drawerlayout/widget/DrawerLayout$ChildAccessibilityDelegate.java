/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.drawerlayout.widget.DrawerLayout
 */
package androidx.drawerlayout.widget;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.drawerlayout.widget.DrawerLayout;

/*
 * Exception performing whole class analysis ignored.
 */
static final class DrawerLayout.ChildAccessibilityDelegate
extends AccessibilityDelegateCompat {
    DrawerLayout.ChildAccessibilityDelegate() {
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (DrawerLayout.includeChildForAccessibility((View)view)) return;
        accessibilityNodeInfoCompat.setParent(null);
    }
}
