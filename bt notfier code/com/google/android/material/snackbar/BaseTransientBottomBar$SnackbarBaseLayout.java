/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.accessibility.AccessibilityManager
 *  android.widget.FrameLayout
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.accessibility.AccessibilityManagerCompat
 *  androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener
 *  com.google.android.material.R$styleable
 *  com.google.android.material.snackbar.BaseTransientBottomBar$OnAttachStateChangeListener
 *  com.google.android.material.snackbar.BaseTransientBottomBar$OnLayoutChangeListener
 */
package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;

protected static class BaseTransientBottomBar.SnackbarBaseLayout
extends FrameLayout {
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener;
    private BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener;
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    protected BaseTransientBottomBar.SnackbarBaseLayout(Context context) {
        this(context, null);
    }

    protected BaseTransientBottomBar.SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        if (attributeSet.hasValue(R.styleable.SnackbarLayout_elevation)) {
            ViewCompat.setElevation((View)this, (float)attributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
        }
        attributeSet.recycle();
        this.accessibilityManager = (AccessibilityManager)context.getSystemService("accessibility");
        context = new /* Unavailable Anonymous Inner Class!! */;
        this.touchExplorationStateChangeListener = context;
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener((AccessibilityManager)this.accessibilityManager, (AccessibilityManagerCompat.TouchExplorationStateChangeListener)context);
        this.setClickableOrFocusableBasedOnAccessibility(this.accessibilityManager.isTouchExplorationEnabled());
    }

    static /* synthetic */ void access$300(BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout, boolean bl) {
        snackbarBaseLayout.setClickableOrFocusableBasedOnAccessibility(bl);
    }

    private void setClickableOrFocusableBasedOnAccessibility(boolean bl) {
        this.setClickable(bl ^ true);
        this.setFocusable(bl);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
        if (onAttachStateChangeListener != null) {
            onAttachStateChangeListener.onViewAttachedToWindow((View)this);
        }
        ViewCompat.requestApplyInsets((View)this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
        if (onAttachStateChangeListener != null) {
            onAttachStateChangeListener.onViewDetachedFromWindow((View)this);
        }
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener((AccessibilityManager)this.accessibilityManager, (AccessibilityManagerCompat.TouchExplorationStateChangeListener)this.touchExplorationStateChangeListener);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
        if (onLayoutChangeListener == null) return;
        onLayoutChangeListener.onLayoutChange((View)this, n, n2, n3, n4);
    }

    void setOnAttachStateChangeListener(BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener) {
        this.onAttachStateChangeListener = onAttachStateChangeListener;
    }

    void setOnLayoutChangeListener(BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener) {
        this.onLayoutChangeListener = onLayoutChangeListener;
    }
}
