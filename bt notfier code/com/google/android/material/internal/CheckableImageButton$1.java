/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  com.google.android.material.internal.CheckableImageButton
 */
package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

class CheckableImageButton.1
extends AccessibilityDelegateCompat {
    final CheckableImageButton this$0;

    CheckableImageButton.1(CheckableImageButton checkableImageButton) {
        this.this$0 = checkableImageButton;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.this$0.isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setCheckable(true);
        accessibilityNodeInfoCompat.setChecked(this.this$0.isChecked());
    }
}
