/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat
 */
package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.ArrayList;
import java.util.List;

static class AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16
extends AccessibilityNodeProvider {
    final AccessibilityNodeProviderCompat mCompat;

    AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
        this.mCompat = accessibilityNodeProviderCompat;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int n) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.mCompat.createAccessibilityNodeInfo(n);
        if (accessibilityNodeInfoCompat != null) return accessibilityNodeInfoCompat.unwrap();
        return null;
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String object, int n) {
        if ((object = this.mCompat.findAccessibilityNodeInfosByText((String)object, n)) == null) {
            return null;
        }
        ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList<AccessibilityNodeInfo>();
        int n2 = object.size();
        n = 0;
        while (n < n2) {
            arrayList.add(((AccessibilityNodeInfoCompat)object.get(n)).unwrap());
            ++n;
        }
        return arrayList;
    }

    public boolean performAction(int n, int n2, Bundle bundle) {
        return this.mCompat.performAction(n, n2, bundle);
    }
}
