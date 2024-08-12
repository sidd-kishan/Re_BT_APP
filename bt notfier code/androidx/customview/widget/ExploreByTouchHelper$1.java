/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.customview.widget.FocusStrategy$BoundsAdapter
 */
package androidx.customview.widget;

import android.graphics.Rect;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.FocusStrategy;

static final class ExploreByTouchHelper.1
implements FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> {
    ExploreByTouchHelper.1() {
    }

    public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
        accessibilityNodeInfoCompat.getBoundsInParent(rect);
    }
}
