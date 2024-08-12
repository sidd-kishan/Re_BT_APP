/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    private final Object mProvider;

    public AccessibilityNodeProviderCompat() {
        this.mProvider = Build.VERSION.SDK_INT >= 26 ? new AccessibilityNodeProviderApi26(this) : (Build.VERSION.SDK_INT >= 19 ? new AccessibilityNodeProviderApi19(this) : (Build.VERSION.SDK_INT >= 16 ? new AccessibilityNodeProviderApi16(this) : null));
    }

    public AccessibilityNodeProviderCompat(Object object) {
        this.mProvider = object;
    }

    public void addExtraDataToAccessibilityNodeInfo(int n, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String string, Bundle bundle) {
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int n) {
        return null;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String string, int n) {
        return null;
    }

    public AccessibilityNodeInfoCompat findFocus(int n) {
        return null;
    }

    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int n, int n2, Bundle bundle) {
        return false;
    }
}
