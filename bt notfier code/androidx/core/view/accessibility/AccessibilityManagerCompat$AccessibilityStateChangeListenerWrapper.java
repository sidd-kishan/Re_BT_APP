/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
 *  androidx.core.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListener
 */
package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityManagerCompat;

private static class AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper
implements AccessibilityManager.AccessibilityStateChangeListener {
    AccessibilityManagerCompat.AccessibilityStateChangeListener mListener;

    AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper(AccessibilityManagerCompat.AccessibilityStateChangeListener accessibilityStateChangeListener) {
        this.mListener = accessibilityStateChangeListener;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper)) {
            return false;
        }
        object = (AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper)object;
        return this.mListener.equals(((AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper)object).mListener);
    }

    public int hashCode() {
        return this.mListener.hashCode();
    }

    public void onAccessibilityStateChanged(boolean bl) {
        this.mListener.onAccessibilityStateChanged(bl);
    }
}
