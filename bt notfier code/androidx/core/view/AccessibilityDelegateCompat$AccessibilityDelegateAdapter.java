/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat
 */
package androidx.core.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/*
 * Exception performing whole class analysis ignored.
 */
static final class AccessibilityDelegateCompat.AccessibilityDelegateAdapter
extends View.AccessibilityDelegate {
    final AccessibilityDelegateCompat mCompat;

    AccessibilityDelegateCompat.AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        this.mCompat = accessibilityDelegateCompat;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider(View object) {
        object = (object = this.mCompat.getAccessibilityNodeProvider(object)) != null ? (AccessibilityNodeProvider)object.getProvider() : null;
        return object;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)accessibilityNodeInfo);
        accessibilityNodeInfoCompat.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable((View)object));
        accessibilityNodeInfoCompat.setHeading(ViewCompat.isAccessibilityHeading((View)object));
        accessibilityNodeInfoCompat.setPaneTitle(ViewCompat.getAccessibilityPaneTitle((View)object));
        accessibilityNodeInfoCompat.setStateDescription(ViewCompat.getStateDescription((View)object));
        this.mCompat.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addSpansToExtras(accessibilityNodeInfo.getText(), (View)object);
        object = AccessibilityDelegateCompat.getActionList((View)object);
        int n = 0;
        while (n < object.size()) {
            accessibilityNodeInfoCompat.addAction((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object.get(n));
            ++n;
        }
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        return this.mCompat.performAccessibilityAction(view, n, bundle);
    }

    public void sendAccessibilityEvent(View view, int n) {
        this.mCompat.sendAccessibilityEvent(view, n);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
