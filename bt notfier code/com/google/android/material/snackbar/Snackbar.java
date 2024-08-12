/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityManager
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$layout
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 *  com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback
 *  com.google.android.material.snackbar.ContentViewCallback
 *  com.google.android.material.snackbar.Snackbar$Callback
 *  com.google.android.material.snackbar.SnackbarContentLayout
 */
package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.ContentViewCallback;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;

public final class Snackbar
extends BaseTransientBottomBar<Snackbar> {
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR = new int[]{R.attr.snackbarButtonStyle};
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    private Snackbar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        super(viewGroup, view, contentViewCallback);
        this.accessibilityManager = (AccessibilityManager)viewGroup.getContext().getSystemService("accessibility");
    }

    private static ViewGroup findSuitableParent(View view) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        View view2 = view;
        do {
            if (view2 instanceof CoordinatorLayout) {
                return (ViewGroup)view2;
            }
            viewGroup = viewGroup2;
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 0x1020002) {
                    return (ViewGroup)view2;
                }
                viewGroup = (ViewGroup)view2;
            }
            view = view2;
            if (view2 != null && !((view = view2.getParent()) instanceof View)) {
                view = null;
            }
            viewGroup2 = viewGroup;
            view2 = view;
        } while (view != null);
        return viewGroup;
    }

    protected static boolean hasSnackbarButtonStyleAttr(Context context) {
        context = context.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        boolean bl = false;
        int n = context.getResourceId(0, -1);
        context.recycle();
        if (n == -1) return bl;
        bl = true;
        return bl;
    }

    public static Snackbar make(View view, int n, int n2) {
        return Snackbar.make(view, view.getResources().getText(n), n2);
    }

    public static Snackbar make(View object, CharSequence charSequence, int n) {
        if ((object = Snackbar.findSuitableParent((View)object)) == null) throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        LayoutInflater layoutInflater = LayoutInflater.from((Context)object.getContext());
        int n2 = Snackbar.hasSnackbarButtonStyleAttr(object.getContext()) ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include;
        layoutInflater = (SnackbarContentLayout)layoutInflater.inflate(n2, (ViewGroup)object, false);
        object = new Snackbar((ViewGroup)object, (View)layoutInflater, (ContentViewCallback)layoutInflater);
        ((Snackbar)((Object)object)).setText(charSequence);
        object.setDuration(n);
        return object;
    }

    public void dismiss() {
        super.dismiss();
    }

    public int getDuration() {
        int n = this.hasAction && this.accessibilityManager.isTouchExplorationEnabled() ? -2 : super.getDuration();
        return n;
    }

    public boolean isShown() {
        return super.isShown();
    }

    public Snackbar setAction(int n, View.OnClickListener onClickListener) {
        return this.setAction(this.getContext().getText(n), onClickListener);
    }

    public Snackbar setAction(CharSequence charSequence, View.OnClickListener onClickListener) {
        Button button = ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView();
        if (!TextUtils.isEmpty((CharSequence)charSequence) && onClickListener != null) {
            this.hasAction = true;
            button.setVisibility(0);
            button.setText(charSequence);
            button.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            button.setVisibility(8);
            button.setOnClickListener(null);
            this.hasAction = false;
        }
        return this;
    }

    public Snackbar setActionTextColor(int n) {
        ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView().setTextColor(n);
        return this;
    }

    public Snackbar setActionTextColor(ColorStateList colorStateList) {
        ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView().setTextColor(colorStateList);
        return this;
    }

    @Deprecated
    public Snackbar setCallback(Callback callback) {
        BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback = this.callback;
        if (baseCallback != null) {
            this.removeCallback(baseCallback);
        }
        if (callback != null) {
            this.addCallback((BaseTransientBottomBar.BaseCallback)callback);
        }
        this.callback = callback;
        return this;
    }

    public Snackbar setText(int n) {
        return this.setText(this.getContext().getText(n));
    }

    public Snackbar setText(CharSequence charSequence) {
        ((SnackbarContentLayout)this.view.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    public void show() {
        super.show();
    }
}
