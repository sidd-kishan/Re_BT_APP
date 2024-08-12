/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat
 *  androidx.drawerlayout.widget.DrawerLayout
 */
package androidx.drawerlayout.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.drawerlayout.widget.DrawerLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class DrawerLayout.AccessibilityDelegate
extends AccessibilityDelegateCompat {
    private final Rect mTmpRect;
    final DrawerLayout this$0;

    DrawerLayout.AccessibilityDelegate(DrawerLayout drawerLayout) {
        this.this$0 = drawerLayout;
        this.mTmpRect = new Rect();
    }

    private void addChildrenForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
        int n = viewGroup.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = viewGroup.getChildAt(n2);
            if (DrawerLayout.includeChildForAccessibility((View)view)) {
                accessibilityNodeInfoCompat.addChild(view);
            }
            ++n2;
        }
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
    }

    public boolean dispatchPopulateAccessibilityEvent(View object, AccessibilityEvent object2) {
        if (object2.getEventType() != 32) return super.dispatchPopulateAccessibilityEvent((View)object, object2);
        object = object2.getText();
        object2 = this.this$0.findVisibleDrawer();
        if (object2 == null) return true;
        int n = this.this$0.getDrawerViewAbsoluteGravity((View)object2);
        if ((object2 = this.this$0.getDrawerTitle(n)) == null) return true;
        object.add(object2);
        return true;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)DrawerLayout.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        } else {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = AccessibilityNodeInfoCompat.obtain((AccessibilityNodeInfoCompat)accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat2);
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent viewParent = ViewCompat.getParentForAccessibility((View)view);
            if (viewParent instanceof View) {
                accessibilityNodeInfoCompat.setParent((View)viewParent);
            }
            this.copyNodeInfoNoChildren(accessibilityNodeInfoCompat, accessibilityNodeInfoCompat2);
            accessibilityNodeInfoCompat2.recycle();
            this.addChildrenForAccessibility(accessibilityNodeInfoCompat, (ViewGroup)view);
        }
        accessibilityNodeInfoCompat.setClassName((CharSequence)DrawerLayout.class.getName());
        accessibilityNodeInfoCompat.setFocusable(false);
        accessibilityNodeInfoCompat.setFocused(false);
        accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
        accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (DrawerLayout.CAN_HIDE_DESCENDANTS) return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        if (!DrawerLayout.includeChildForAccessibility((View)view)) return false;
        return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
}
