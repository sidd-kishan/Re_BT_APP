/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout
 */
package androidx.slidingpanelayout.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

class SlidingPaneLayout.AccessibilityDelegate
extends AccessibilityDelegateCompat {
    private final Rect mTmpRect;
    final SlidingPaneLayout this$0;

    SlidingPaneLayout.AccessibilityDelegate(SlidingPaneLayout slidingPaneLayout) {
        this.this$0 = slidingPaneLayout;
        this.mTmpRect = new Rect();
    }

    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
        Rect rect = this.mTmpRect;
        accessibilityNodeInfoCompat2.getBoundsInParent(rect);
        accessibilityNodeInfoCompat.setBoundsInParent(rect);
        accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
        accessibilityNodeInfoCompat.setBoundsInScreen(rect);
        accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
        accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
        accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
        accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
        accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
        accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
        accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
        accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
        accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
        accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
        accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
        accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
        accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
    }

    public boolean filter(View view) {
        return this.this$0.isDimmed(view);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)SlidingPaneLayout.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = AccessibilityNodeInfoCompat.obtain((AccessibilityNodeInfoCompat)accessibilityNodeInfoCompat);
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat2);
        this.copyNodeInfoNoChildren(accessibilityNodeInfoCompat, accessibilityNodeInfoCompat2);
        accessibilityNodeInfoCompat2.recycle();
        accessibilityNodeInfoCompat.setClassName((CharSequence)SlidingPaneLayout.class.getName());
        accessibilityNodeInfoCompat.setSource(view);
        view = ViewCompat.getParentForAccessibility((View)view);
        if (view instanceof View) {
            accessibilityNodeInfoCompat.setParent(view);
        }
        int n = this.this$0.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            view = this.this$0.getChildAt(n2);
            if (!this.filter(view) && view.getVisibility() == 0) {
                ViewCompat.setImportantForAccessibility((View)view, (int)1);
                accessibilityNodeInfoCompat.addChild(view);
            }
            ++n2;
        }
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (this.filter(view)) return false;
        return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
}
