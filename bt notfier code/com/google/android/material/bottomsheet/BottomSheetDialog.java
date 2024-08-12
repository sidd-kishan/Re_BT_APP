/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  androidx.appcompat.app.AppCompatDialog
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$id
 *  com.google.android.material.R$layout
 *  com.google.android.material.R$style
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
 */
package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetDialog
extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new /* Unavailable Anonymous Inner Class!! */;
    boolean cancelable = true;
    private boolean canceledOnTouchOutside = true;
    private boolean canceledOnTouchOutsideSet;

    public BottomSheetDialog(Context context) {
        this(context, 0);
    }

    public BottomSheetDialog(Context context, int n) {
        super(context, BottomSheetDialog.getThemeResId(context, n));
        this.supportRequestWindowFeature(1);
    }

    protected BottomSheetDialog(Context context, boolean bl, DialogInterface.OnCancelListener onCancelListener) {
        super(context, bl, onCancelListener);
        this.supportRequestWindowFeature(1);
        this.cancelable = bl;
    }

    private static int getThemeResId(Context context, int n) {
        int n2 = n;
        if (n != 0) return n2;
        TypedValue typedValue = new TypedValue();
        n2 = context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R.style.Theme_Design_Light_BottomSheetDialog;
        return n2;
    }

    private View wrapInBottomSheet(int n, View view, ViewGroup.LayoutParams layoutParams) {
        BottomSheetBehavior bottomSheetBehavior;
        FrameLayout frameLayout = (FrameLayout)View.inflate((Context)this.getContext(), (int)R.layout.design_bottom_sheet_dialog, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout)frameLayout.findViewById(R.id.coordinator);
        View view2 = view;
        if (n != 0) {
            view2 = view;
            if (view == null) {
                view2 = this.getLayoutInflater().inflate(n, (ViewGroup)coordinatorLayout, false);
            }
        }
        view = (FrameLayout)coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        this.behavior = bottomSheetBehavior = BottomSheetBehavior.from((View)view);
        bottomSheetBehavior.setBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
        if (layoutParams == null) {
            view.addView(view2);
        } else {
            view.addView(view2, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        ViewCompat.setAccessibilityDelegate((View)view, (AccessibilityDelegateCompat)new /* Unavailable Anonymous Inner Class!! */);
        view.setOnTouchListener((View.OnTouchListener)new /* Unavailable Anonymous Inner Class!! */);
        return frameLayout;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = this.getWindow();
        if (bundle == null) return;
        if (Build.VERSION.SDK_INT >= 21) {
            bundle.clearFlags(0x4000000);
            bundle.addFlags(Integer.MIN_VALUE);
        }
        bundle.setLayout(-1, -1);
    }

    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior == null) return;
        if (bottomSheetBehavior.getState() != 5) return;
        this.behavior.setState(4);
    }

    public void setCancelable(boolean bl) {
        super.setCancelable(bl);
        if (this.cancelable == bl) return;
        this.cancelable = bl;
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior == null) return;
        bottomSheetBehavior.setHideable(bl);
    }

    public void setCanceledOnTouchOutside(boolean bl) {
        super.setCanceledOnTouchOutside(bl);
        if (bl && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = bl;
        this.canceledOnTouchOutsideSet = true;
    }

    public void setContentView(int n) {
        super.setContentView(this.wrapInBottomSheet(n, null, null));
    }

    public void setContentView(View view) {
        super.setContentView(this.wrapInBottomSheet(0, view, null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(this.wrapInBottomSheet(0, view, layoutParams));
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet) return this.canceledOnTouchOutside;
        TypedArray typedArray = this.getContext().obtainStyledAttributes(new int[]{16843611});
        this.canceledOnTouchOutside = typedArray.getBoolean(0, true);
        typedArray.recycle();
        this.canceledOnTouchOutsideSet = true;
        return this.canceledOnTouchOutside;
    }
}
