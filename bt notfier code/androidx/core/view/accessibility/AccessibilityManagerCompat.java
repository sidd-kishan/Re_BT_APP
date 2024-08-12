/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accessibilityservice.AccessibilityServiceInfo
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
 *  android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
 *  androidx.core.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListener
 *  androidx.core.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper
 *  androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener
 *  androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper
 */
package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import java.util.List;

public final class AccessibilityManagerCompat {
    private AccessibilityManagerCompat() {
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        if (accessibilityStateChangeListener != null) return accessibilityManager.addAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)new AccessibilityStateChangeListenerWrapper(accessibilityStateChangeListener));
        return false;
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        if (Build.VERSION.SDK_INT < 19) return false;
        if (touchExplorationStateChangeListener != null) return accessibilityManager.addTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)new TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener));
        return false;
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int n) {
        return accessibilityManager.getEnabledAccessibilityServiceList(n);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        if (accessibilityStateChangeListener != null) return accessibilityManager.removeAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)new AccessibilityStateChangeListenerWrapper(accessibilityStateChangeListener));
        return false;
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        if (Build.VERSION.SDK_INT < 19) return false;
        if (touchExplorationStateChangeListener != null) return accessibilityManager.removeTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)new TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener));
        return false;
    }
}
