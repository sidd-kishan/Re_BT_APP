/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityRecord
 *  android.widget.ScrollView
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat
 *  androidx.core.view.accessibility.AccessibilityRecordCompat
 *  androidx.core.widget.NestedScrollView
 */
package androidx.core.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.widget.ScrollView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.NestedScrollView;

static class NestedScrollView.AccessibilityDelegate
extends AccessibilityDelegateCompat {
    NestedScrollView.AccessibilityDelegate() {
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        view = (NestedScrollView)view;
        accessibilityEvent.setClassName((CharSequence)ScrollView.class.getName());
        boolean bl = view.getScrollRange() > 0;
        accessibilityEvent.setScrollable(bl);
        accessibilityEvent.setScrollX(view.getScrollX());
        accessibilityEvent.setScrollY(view.getScrollY());
        AccessibilityRecordCompat.setMaxScrollX((AccessibilityRecord)accessibilityEvent, (int)view.getScrollX());
        AccessibilityRecordCompat.setMaxScrollY((AccessibilityRecord)accessibilityEvent, (int)view.getScrollRange());
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        view = (NestedScrollView)view;
        accessibilityNodeInfoCompat.setClassName((CharSequence)ScrollView.class.getName());
        if (!view.isEnabled()) return;
        int n = view.getScrollRange();
        if (n <= 0) return;
        accessibilityNodeInfoCompat.setScrollable(true);
        if (view.getScrollY() > 0) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
        }
        if (view.getScrollY() >= n) return;
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
    }

    public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        if (super.performAccessibilityAction(view, n, bundle)) {
            return true;
        }
        if (!(view = (NestedScrollView)view).isEnabled()) {
            return false;
        }
        if (n != 4096) {
            if (n != 8192 && n != 16908344) {
                if (n != 16908346) {
                    return false;
                }
            } else {
                int n2 = view.getHeight();
                int n3 = view.getPaddingBottom();
                n = view.getPaddingTop();
                n = Math.max(view.getScrollY() - (n2 - n3 - n), 0);
                if (n == view.getScrollY()) return false;
                view.smoothScrollTo(0, n, true);
                return true;
            }
        }
        n = view.getHeight();
        int n4 = view.getPaddingBottom();
        int n5 = view.getPaddingTop();
        n = Math.min(view.getScrollY() + (n - n4 - n5), view.getScrollRange());
        if (n == view.getScrollY()) return false;
        view.smoothScrollTo(0, n, true);
        return true;
    }
}
