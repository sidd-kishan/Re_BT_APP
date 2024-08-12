/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Region
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$TouchDelegateInfo
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 */
package androidx.core.view.accessibility;

import android.graphics.Region;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Map;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class AccessibilityNodeInfoCompat.TouchDelegateInfoCompat {
    final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

    AccessibilityNodeInfoCompat.TouchDelegateInfoCompat(AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
        this.mInfo = touchDelegateInfo;
    }

    public AccessibilityNodeInfoCompat.TouchDelegateInfoCompat(Map<Region, View> map) {
        this.mInfo = Build.VERSION.SDK_INT >= 29 ? new AccessibilityNodeInfo.TouchDelegateInfo(map) : null;
    }

    public Region getRegionAt(int n) {
        if (Build.VERSION.SDK_INT < 29) return null;
        return this.mInfo.getRegionAt(n);
    }

    public int getRegionCount() {
        if (Build.VERSION.SDK_INT < 29) return 0;
        return this.mInfo.getRegionCount();
    }

    public AccessibilityNodeInfoCompat getTargetForRegion(Region region) {
        if (Build.VERSION.SDK_INT < 29) return null;
        if ((region = this.mInfo.getTargetForRegion(region)) == null) return null;
        return AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)region);
    }
}
