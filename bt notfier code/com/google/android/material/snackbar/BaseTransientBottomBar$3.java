/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 */
package com.google.android.material.snackbar;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;

class BaseTransientBottomBar.3
extends AccessibilityDelegateCompat {
    final BaseTransientBottomBar this$0;

    BaseTransientBottomBar.3(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(0x100000);
        accessibilityNodeInfoCompat.setDismissable(true);
    }

    public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        if (n != 0x100000) return super.performAccessibilityAction(view, n, bundle);
        this.this$0.dismiss();
        return true;
    }
}
