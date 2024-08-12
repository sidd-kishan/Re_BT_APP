/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.SparseArrayCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.customview.widget.FocusStrategy$CollectionAdapter
 */
package androidx.customview.widget;

import androidx.collection.SparseArrayCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.FocusStrategy;

static final class ExploreByTouchHelper.2
implements FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> {
    ExploreByTouchHelper.2() {
    }

    public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int n) {
        return (AccessibilityNodeInfoCompat)sparseArrayCompat.valueAt(n);
    }

    public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
        return sparseArrayCompat.size();
    }
}
