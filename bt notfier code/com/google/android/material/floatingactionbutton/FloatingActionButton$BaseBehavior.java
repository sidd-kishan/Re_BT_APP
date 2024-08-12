/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$styleable
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener
 *  com.google.android.material.internal.DescendantOffsetUtils
 */
package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;

protected static class FloatingActionButton.BaseBehavior<T extends FloatingActionButton>
extends CoordinatorLayout.Behavior<T> {
    private static final boolean AUTO_HIDE_DEFAULT = true;
    private boolean autoHideEnabled;
    private FloatingActionButton.OnVisibilityChangedListener internalAutoHideListener;
    private Rect tmpRect;

    public FloatingActionButton.BaseBehavior() {
        this.autoHideEnabled = true;
    }

    public FloatingActionButton.BaseBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
        this.autoHideEnabled = context.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
        context.recycle();
    }

    private static boolean isBottomSheet(View view) {
        if (!((view = view.getLayoutParams()) instanceof CoordinatorLayout.LayoutParams)) return false;
        return ((CoordinatorLayout.LayoutParams)view).getBehavior() instanceof BottomSheetBehavior;
    }

    private void offsetIfNeeded(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
        Rect rect = floatingActionButton.shadowPadding;
        if (rect == null) return;
        if (rect.centerX() <= 0) return;
        if (rect.centerY() <= 0) return;
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)floatingActionButton.getLayoutParams();
        int n = floatingActionButton.getRight();
        int n2 = coordinatorLayout.getWidth();
        int n3 = layoutParams.rightMargin;
        int n4 = 0;
        n2 = n >= n2 - n3 ? rect.right : (floatingActionButton.getLeft() <= layoutParams.leftMargin ? -rect.left : 0);
        if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - layoutParams.bottomMargin) {
            n4 = rect.bottom;
        } else if (floatingActionButton.getTop() <= layoutParams.topMargin) {
            n4 = -rect.top;
        }
        if (n4 != 0) {
            ViewCompat.offsetTopAndBottom((View)floatingActionButton, (int)n4);
        }
        if (n2 == 0) return;
        ViewCompat.offsetLeftAndRight((View)floatingActionButton, (int)n2);
    }

    private boolean shouldUpdateVisibility(View view, FloatingActionButton floatingActionButton) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)floatingActionButton.getLayoutParams();
        if (!this.autoHideEnabled) {
            return false;
        }
        if (layoutParams.getAnchorId() != view.getId()) {
            return false;
        }
        if (floatingActionButton.getUserSetVisibility() == 0) return true;
        return false;
    }

    private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
        if (!this.shouldUpdateVisibility((View)appBarLayout, floatingActionButton)) {
            return false;
        }
        if (this.tmpRect == null) {
            this.tmpRect = new Rect();
        }
        Rect rect = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect((ViewGroup)coordinatorLayout, (View)appBarLayout, (Rect)rect);
        if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
            floatingActionButton.hide(this.internalAutoHideListener, false);
        } else {
            floatingActionButton.show(this.internalAutoHideListener, false);
        }
        return true;
    }

    private boolean updateFabVisibilityForBottomSheet(View view, FloatingActionButton floatingActionButton) {
        if (!this.shouldUpdateVisibility(view, floatingActionButton)) {
            return false;
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)floatingActionButton.getLayoutParams();
        if (view.getTop() < floatingActionButton.getHeight() / 2 + layoutParams.topMargin) {
            floatingActionButton.hide(this.internalAutoHideListener, false);
        } else {
            floatingActionButton.show(this.internalAutoHideListener, false);
        }
        return true;
    }

    public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
        coordinatorLayout = floatingActionButton.shadowPadding;
        rect.set(floatingActionButton.getLeft() + coordinatorLayout.left, floatingActionButton.getTop() + coordinatorLayout.top, floatingActionButton.getRight() - coordinatorLayout.right, floatingActionButton.getBottom() - coordinatorLayout.bottom);
        return true;
    }

    public boolean isAutoHideEnabled() {
        return this.autoHideEnabled;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges != 0) return;
        layoutParams.dodgeInsetEdges = 80;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        if (view instanceof AppBarLayout) {
            this.updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout)view, floatingActionButton);
        } else {
            if (!FloatingActionButton.BaseBehavior.isBottomSheet(view)) return false;
            this.updateFabVisibilityForBottomSheet(view, floatingActionButton);
        }
        return false;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int n) {
        View view;
        List list = coordinatorLayout.getDependencies((View)floatingActionButton);
        int n2 = list.size();
        for (int i = 0; i < n2 && !((view = (View)list.get(i)) instanceof AppBarLayout ? this.updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout)view, floatingActionButton) : FloatingActionButton.BaseBehavior.isBottomSheet(view) && this.updateFabVisibilityForBottomSheet(view, floatingActionButton)); ++i) {
        }
        coordinatorLayout.onLayoutChild((View)floatingActionButton, n);
        this.offsetIfNeeded(coordinatorLayout, floatingActionButton);
        return true;
    }

    public void setAutoHideEnabled(boolean bl) {
        this.autoHideEnabled = bl;
    }

    public void setInternalAutoHideListener(FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
        this.internalAutoHideListener = onVisibilityChangedListener;
    }
}
