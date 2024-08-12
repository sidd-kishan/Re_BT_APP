/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationSet
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.TranslateAnimation
 *  com.qmuiteam.qmui.R$style
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$1
 *  com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet$OnBottomSheetShowListener
 */
package com.qmuiteam.qmui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;

public class QMUIBottomSheet
extends Dialog {
    private static final String TAG = "QMUIBottomSheet";
    private static final int mAnimationDuration = 200;
    private View mContentView;
    private boolean mIsAnimating = false;
    private OnBottomSheetShowListener mOnBottomSheetShowListener;

    public QMUIBottomSheet(Context context) {
        super(context, R.style.QMUI_BottomSheet);
    }

    static /* synthetic */ void access$001(QMUIBottomSheet qMUIBottomSheet) {
        super.dismiss();
    }

    static /* synthetic */ boolean access$102(QMUIBottomSheet qMUIBottomSheet, boolean bl) {
        qMUIBottomSheet.mIsAnimating = bl;
        return bl;
    }

    static /* synthetic */ View access$200(QMUIBottomSheet qMUIBottomSheet) {
        return qMUIBottomSheet.mContentView;
    }

    private void animateDown() {
        if (this.mContentView == null) {
            return;
        }
        1 var1_1 = new /* Unavailable Anonymous Inner Class!! */;
        if (this.mContentView.getHeight() == 0) {
            var1_1.run();
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation((Animation)translateAnimation);
        animationSet.addAnimation((Animation)alphaAnimation);
        animationSet.setInterpolator((Interpolator)new DecelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener((Animation.AnimationListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mContentView.startAnimation((Animation)animationSet);
    }

    private void animateUp() {
        if (this.mContentView == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation((Animation)translateAnimation);
        animationSet.addAnimation((Animation)alphaAnimation);
        animationSet.setInterpolator((Interpolator)new DecelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        this.mContentView.startAnimation((Animation)animationSet);
    }

    public void dismiss() {
        if (this.mIsAnimating) {
            return;
        }
        this.animateDown();
    }

    public View getContentView() {
        return this.mContentView;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        bundle = this.getWindow().getAttributes();
        bundle.height = -2;
        bundle.gravity = 81;
        int n = QMUIDisplayHelper.getScreenWidth((Context)this.getContext());
        int n2 = QMUIDisplayHelper.getScreenHeight((Context)this.getContext());
        if (n >= n2) {
            n = n2;
        }
        bundle.width = n;
        this.getWindow().setAttributes((WindowManager.LayoutParams)bundle);
        this.setCanceledOnTouchOutside(true);
    }

    public void setContentView(int n) {
        View view;
        this.mContentView = view = LayoutInflater.from((Context)this.getContext()).inflate(n, null);
        super.setContentView(view);
    }

    public void setContentView(View view) {
        this.mContentView = view;
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mContentView = view;
        super.setContentView(view, layoutParams);
    }

    public void setOnBottomSheetShowListener(OnBottomSheetShowListener onBottomSheetShowListener) {
        this.mOnBottomSheetShowListener = onBottomSheetShowListener;
    }

    public void show() {
        super.show();
        this.animateUp();
        OnBottomSheetShowListener onBottomSheetShowListener = this.mOnBottomSheetShowListener;
        if (onBottomSheetShowListener == null) return;
        onBottomSheetShowListener.onShow();
    }
}
