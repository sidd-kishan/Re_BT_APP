/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.accessibility.AccessibilityNodeInfo
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19
 */
package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;

static class AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi26
extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi19 {
    AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
        super(accessibilityNodeProviderCompat);
    }

    public void addExtraDataToAccessibilityNodeInfo(int n, AccessibilityNodeInfo accessibilityNodeInfo, String string, Bundle bundle) {
        this.mCompat.addExtraDataToAccessibilityNodeInfo(n, AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)accessibilityNodeInfo), string, bundle);
    }
}
