/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 */
package androidx.coordinatorlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

private class CoordinatorLayout.HierarchyChangeListener
implements ViewGroup.OnHierarchyChangeListener {
    final CoordinatorLayout this$0;

    CoordinatorLayout.HierarchyChangeListener(CoordinatorLayout coordinatorLayout) {
        this.this$0 = coordinatorLayout;
    }

    public void onChildViewAdded(View view, View view2) {
        if (this.this$0.mOnHierarchyChangeListener == null) return;
        this.this$0.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
    }

    public void onChildViewRemoved(View view, View view2) {
        this.this$0.onChildViewsChanged(2);
        if (this.this$0.mOnHierarchyChangeListener == null) return;
        this.this$0.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
    }
}
