/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.accessibility.AccessibilityNodeInfo
 *  androidx.appcompat.widget.ActivityChooserView
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 */
package androidx.appcompat.widget;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class ActivityChooserView.3
extends View.AccessibilityDelegate {
    final ActivityChooserView this$0;

    ActivityChooserView.3(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)accessibilityNodeInfo).setCanOpenPopup(true);
    }
}
