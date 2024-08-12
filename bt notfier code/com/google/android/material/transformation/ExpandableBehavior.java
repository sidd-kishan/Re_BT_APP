/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.expandable.ExpandableWidget
 */
package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

public abstract class ExpandableBehavior
extends CoordinatorLayout.Behavior<View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private int currentState = 0;

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ int access$000(ExpandableBehavior expandableBehavior) {
        return expandableBehavior.currentState;
    }

    private boolean didStateChange(boolean bl) {
        boolean bl2 = false;
        boolean bl3 = false;
        if (!bl) {
            bl = bl2;
            if (this.currentState != 1) return bl;
            bl = true;
            return bl;
        }
        int n = this.currentState;
        if (n != 0) {
            bl = bl3;
            if (n != 2) return bl;
        }
        bl = true;
        return bl;
    }

    public static <T extends ExpandableBehavior> T from(View view, Class<T> clazz) {
        if (!((view = view.getLayoutParams()) instanceof CoordinatorLayout.LayoutParams)) throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        if (!((view = ((CoordinatorLayout.LayoutParams)view).getBehavior()) instanceof ExpandableBehavior)) throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
        return (T)((Object)((ExpandableBehavior)((Object)clazz.cast(view))));
    }

    protected ExpandableWidget findExpandableWidget(CoordinatorLayout coordinatorLayout, View view) {
        List list = coordinatorLayout.getDependencies(view);
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            View view2 = (View)list.get(n2);
            if (this.layoutDependsOn(coordinatorLayout, view, view2)) {
                return (ExpandableWidget)view2;
            }
            ++n2;
        }
        return null;
    }

    public abstract boolean layoutDependsOn(CoordinatorLayout var1, View var2, View var3);

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        coordinatorLayout = (ExpandableWidget)view2;
        if (!this.didStateChange(coordinatorLayout.isExpanded())) return false;
        int n = coordinatorLayout.isExpanded() ? 1 : 2;
        this.currentState = n;
        return this.onExpandedStateChange((View)coordinatorLayout, view, coordinatorLayout.isExpanded(), true);
    }

    protected abstract boolean onExpandedStateChange(View var1, View var2, boolean var3, boolean var4);

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int n) {
        if (ViewCompat.isLaidOut((View)view)) return false;
        if ((coordinatorLayout = this.findExpandableWidget(coordinatorLayout, view)) == null) return false;
        if (!this.didStateChange(coordinatorLayout.isExpanded())) return false;
        n = coordinatorLayout.isExpanded() ? 1 : 2;
        this.currentState = n;
        view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new /* Unavailable Anonymous Inner Class!! */);
        return false;
    }
}
