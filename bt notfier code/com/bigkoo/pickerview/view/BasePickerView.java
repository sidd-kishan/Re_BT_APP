/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface$OnDismissListener
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnKeyListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.widget.FrameLayout$LayoutParams
 *  com.bigkoo.pickerview.R$id
 *  com.bigkoo.pickerview.R$layout
 *  com.bigkoo.pickerview.R$style
 *  com.bigkoo.pickerview.configure.PickerOptions
 *  com.bigkoo.pickerview.listener.OnDismissListener
 *  com.bigkoo.pickerview.utils.PickerViewAnimateUtil
 */
package com.bigkoo.pickerview.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.OnDismissListener;
import com.bigkoo.pickerview.utils.PickerViewAnimateUtil;

public class BasePickerView {
    protected int animGravity = 80;
    protected View clickView;
    protected ViewGroup contentContainer;
    private Context context;
    private ViewGroup dialogView;
    private boolean dismissing;
    private Animation inAnim;
    private boolean isAnim = true;
    private boolean isShowing;
    private Dialog mDialog;
    protected PickerOptions mPickerOptions;
    private final View.OnTouchListener onCancelableTouchListener;
    private OnDismissListener onDismissListener;
    private View.OnKeyListener onKeyBackListener = new /* Unavailable Anonymous Inner Class!! */;
    private Animation outAnim;
    private ViewGroup rootView;

    public BasePickerView(Context context) {
        this.onCancelableTouchListener = new /* Unavailable Anonymous Inner Class!! */;
        this.context = context;
    }

    static /* synthetic */ ViewGroup access$000(BasePickerView basePickerView) {
        return basePickerView.rootView;
    }

    static /* synthetic */ boolean access$102(BasePickerView basePickerView, boolean bl) {
        basePickerView.isShowing = bl;
        return bl;
    }

    static /* synthetic */ boolean access$202(BasePickerView basePickerView, boolean bl) {
        basePickerView.dismissing = bl;
        return bl;
    }

    static /* synthetic */ OnDismissListener access$300(BasePickerView basePickerView) {
        return basePickerView.onDismissListener;
    }

    private void dismissDialog() {
        Dialog dialog = this.mDialog;
        if (dialog == null) return;
        dialog.dismiss();
    }

    private Animation getInAnimation() {
        int n = PickerViewAnimateUtil.getAnimationResource((int)this.animGravity, (boolean)true);
        return AnimationUtils.loadAnimation((Context)this.context, (int)n);
    }

    private Animation getOutAnimation() {
        int n = PickerViewAnimateUtil.getAnimationResource((int)this.animGravity, (boolean)false);
        return AnimationUtils.loadAnimation((Context)this.context, (int)n);
    }

    private void onAttached(View view) {
        this.mPickerOptions.decorView.addView(view);
        if (!this.isAnim) return;
        this.contentContainer.startAnimation(this.inAnim);
    }

    private void showDialog() {
        Dialog dialog = this.mDialog;
        if (dialog == null) return;
        dialog.show();
    }

    public void createDialog() {
        Dialog dialog;
        if (this.dialogView == null) return;
        this.mDialog = dialog = new Dialog(this.context, R.style.custom_dialog2);
        dialog.setCancelable(this.mPickerOptions.cancelable);
        this.mDialog.setContentView((View)this.dialogView);
        dialog = this.mDialog.getWindow();
        if (dialog != null) {
            dialog.setWindowAnimations(R.style.picker_view_scale_anim);
            dialog.setGravity(17);
        }
        this.mDialog.setOnDismissListener((DialogInterface.OnDismissListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void dismiss() {
        if (this.isDialog()) {
            this.dismissDialog();
        } else {
            if (this.dismissing) {
                return;
            }
            if (this.isAnim) {
                this.outAnim.setAnimationListener((Animation.AnimationListener)new /* Unavailable Anonymous Inner Class!! */);
                this.contentContainer.startAnimation(this.outAnim);
            } else {
                this.dismissImmediately();
            }
            this.dismissing = true;
        }
    }

    public void dismissImmediately() {
        this.mPickerOptions.decorView.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public View findViewById(int n) {
        return this.contentContainer.findViewById(n);
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public ViewGroup getDialogContainerLayout() {
        return this.contentContainer;
    }

    protected void initAnim() {
        this.inAnim = this.getInAnimation();
        this.outAnim = this.getOutAnimation();
    }

    protected void initEvents() {
    }

    protected void initViews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.context);
        if (this.isDialog()) {
            layoutInflater = (ViewGroup)layoutInflater.inflate(R.layout.layout_basepickerview, null, false);
            this.dialogView = layoutInflater;
            layoutInflater.setBackgroundColor(0);
            this.contentContainer = (ViewGroup)this.dialogView.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.contentContainer.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.createDialog();
            this.dialogView.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            if (this.mPickerOptions.decorView == null) {
                this.mPickerOptions.decorView = (ViewGroup)((Activity)this.context).getWindow().getDecorView();
            }
            layoutInflater = (ViewGroup)layoutInflater.inflate(R.layout.layout_basepickerview, this.mPickerOptions.decorView, false);
            this.rootView = layoutInflater;
            layoutInflater.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
            if (this.mPickerOptions.outSideColor != -1) {
                this.rootView.setBackgroundColor(this.mPickerOptions.outSideColor);
            }
            layoutInflater = (ViewGroup)this.rootView.findViewById(R.id.content_container);
            this.contentContainer = layoutInflater;
            layoutInflater.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
        this.setKeyBackCancelable(true);
    }

    public boolean isDialog() {
        return false;
    }

    public boolean isShowing() {
        boolean bl = this.isDialog();
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        if (this.rootView.getParent() == null) {
            if (!this.isShowing) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    public void setDialogOutSideCancelable() {
        Dialog dialog = this.mDialog;
        if (dialog == null) return;
        dialog.setCancelable(this.mPickerOptions.cancelable);
    }

    public void setKeyBackCancelable(boolean bl) {
        ViewGroup viewGroup = this.isDialog() ? this.dialogView : this.rootView;
        viewGroup.setFocusable(bl);
        viewGroup.setFocusableInTouchMode(bl);
        if (bl) {
            viewGroup.setOnKeyListener(this.onKeyBackListener);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public BasePickerView setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
        return this;
    }

    protected BasePickerView setOutSideCancelable(boolean bl) {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) return this;
        viewGroup = viewGroup.findViewById(R.id.outmost_container);
        if (bl) {
            viewGroup.setOnTouchListener(this.onCancelableTouchListener);
        } else {
            viewGroup.setOnTouchListener(null);
        }
        return this;
    }

    public void show() {
        if (this.isDialog()) {
            this.showDialog();
        } else {
            if (this.isShowing()) {
                return;
            }
            this.isShowing = true;
            this.onAttached((View)this.rootView);
            this.rootView.requestFocus();
        }
    }

    public void show(View view) {
        this.clickView = view;
        this.show();
    }

    public void show(View view, boolean bl) {
        this.clickView = view;
        this.isAnim = bl;
        this.show();
    }

    public void show(boolean bl) {
        this.show(null, bl);
    }
}
