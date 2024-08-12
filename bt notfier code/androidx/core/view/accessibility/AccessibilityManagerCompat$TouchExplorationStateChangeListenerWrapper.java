/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
 *  androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener
 */
package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityManagerCompat;

private static final class AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper
implements AccessibilityManager.TouchExplorationStateChangeListener {
    final AccessibilityManagerCompat.TouchExplorationStateChangeListener mListener;

    AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper(AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        this.mListener = touchExplorationStateChangeListener;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper)) {
            return false;
        }
        object = (AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper)object;
        return this.mListener.equals(((AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper)object).mListener);
    }

    public int hashCode() {
        return this.mListener.hashCode();
    }

    public void onTouchExplorationStateChanged(boolean bl) {
        this.mListener.onTouchExplorationStateChanged(bl);
    }
}
