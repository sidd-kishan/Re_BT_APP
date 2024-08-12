/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  com.google.android.material.bottomsheet.BottomSheetDialog
 */
package com.google.android.material.bottomsheet;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.bottomsheet.BottomSheetDialog;

class BottomSheetDialog.2
extends AccessibilityDelegateCompat {
    final BottomSheetDialog this$0;

    BottomSheetDialog.2(BottomSheetDialog bottomSheetDialog) {
        this.this$0 = bottomSheetDialog;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (this.this$0.cancelable) {
            accessibilityNodeInfoCompat.addAction(0x100000);
            accessibilityNodeInfoCompat.setDismissable(true);
        } else {
            accessibilityNodeInfoCompat.setDismissable(false);
        }
    }

    public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        if (n != 0x100000) return super.performAccessibilityAction(view, n, bundle);
        if (!this.this$0.cancelable) return super.performAccessibilityAction(view, n, bundle);
        this.this$0.cancel();
        return true;
    }
}
