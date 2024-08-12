/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  com.google.android.material.expandable.ExpandableWidget
 *  com.google.android.material.transformation.ExpandableBehavior
 */
package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.transformation.ExpandableBehavior;

/*
 * Exception performing whole class analysis ignored.
 */
class ExpandableBehavior.1
implements ViewTreeObserver.OnPreDrawListener {
    final ExpandableBehavior this$0;
    final View val$child;
    final ExpandableWidget val$dep;
    final int val$expectedState;

    ExpandableBehavior.1(ExpandableBehavior expandableBehavior, View view, int n, ExpandableWidget expandableWidget) {
        this.this$0 = expandableBehavior;
        this.val$child = view;
        this.val$expectedState = n;
        this.val$dep = expandableWidget;
    }

    public boolean onPreDraw() {
        this.val$child.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        if (ExpandableBehavior.access$000((ExpandableBehavior)this.this$0) != this.val$expectedState) return false;
        ExpandableBehavior expandableBehavior = this.this$0;
        ExpandableWidget expandableWidget = this.val$dep;
        expandableBehavior.onExpandedStateChange((View)expandableWidget, this.val$child, expandableWidget.isExpanded(), false);
        return false;
    }
}
