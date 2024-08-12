/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  com.google.android.material.internal.NavigationMenuItemView
 */
package com.google.android.material.internal;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.NavigationMenuItemView;

class NavigationMenuItemView.1
extends AccessibilityDelegateCompat {
    final NavigationMenuItemView this$0;

    NavigationMenuItemView.1(NavigationMenuItemView navigationMenuItemView) {
        this.this$0 = navigationMenuItemView;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setCheckable(this.this$0.checkable);
    }
}
