/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityNodeInfo
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16
 */
package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;

static class AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi19
extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16 {
    AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
        super(accessibilityNodeProviderCompat);
    }

    public AccessibilityNodeInfo findFocus(int n) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.mCompat.findFocus(n);
        if (accessibilityNodeInfoCompat != null) return accessibilityNodeInfoCompat.unwrap();
        return null;
    }
}
