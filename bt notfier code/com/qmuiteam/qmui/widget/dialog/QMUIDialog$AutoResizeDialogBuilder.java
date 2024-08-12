/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ScrollView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;

public static abstract class QMUIDialog.AutoResizeDialogBuilder
extends QMUIDialogBuilder {
    private int mAnchorHeight = 0;
    private int mScreenHeight = 0;
    private int mScrollHeight = 0;
    private ScrollView mScrollerView;

    public QMUIDialog.AutoResizeDialogBuilder(Context context) {
        super(context);
    }

    static /* synthetic */ int access$100(QMUIDialog.AutoResizeDialogBuilder autoResizeDialogBuilder) {
        return autoResizeDialogBuilder.mScreenHeight;
    }

    static /* synthetic */ int access$102(QMUIDialog.AutoResizeDialogBuilder autoResizeDialogBuilder, int n) {
        autoResizeDialogBuilder.mScreenHeight = n;
        return n;
    }

    static /* synthetic */ int access$200(QMUIDialog.AutoResizeDialogBuilder autoResizeDialogBuilder) {
        return autoResizeDialogBuilder.mAnchorHeight;
    }

    static /* synthetic */ int access$202(QMUIDialog.AutoResizeDialogBuilder autoResizeDialogBuilder, int n) {
        autoResizeDialogBuilder.mAnchorHeight = n;
        return n;
    }

    static /* synthetic */ ScrollView access$300(QMUIDialog.AutoResizeDialogBuilder autoResizeDialogBuilder) {
        return autoResizeDialogBuilder.mScrollerView;
    }

    static /* synthetic */ int access$400(QMUIDialog.AutoResizeDialogBuilder autoResizeDialogBuilder) {
        return autoResizeDialogBuilder.mScrollHeight;
    }

    static /* synthetic */ int access$402(QMUIDialog.AutoResizeDialogBuilder autoResizeDialogBuilder, int n) {
        autoResizeDialogBuilder.mScrollHeight = n;
        return n;
    }

    private void bindEvent(Context context) {
        this.mAnchorTopView.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mAnchorBottomView.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    protected void onAfter(QMUIDialog qMUIDialog, LinearLayout linearLayout, Context context) {
        super.onAfter(qMUIDialog, linearLayout, context);
        this.bindEvent(context);
    }

    public abstract View onBuildContent(QMUIDialog var1, ScrollView var2);

    protected void onCreateContent(QMUIDialog qMUIDialog, ViewGroup viewGroup, Context context) {
        context = new ScrollView(context);
        this.mScrollerView = context;
        context.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.onGetScrollHeight()));
        context = this.mScrollerView;
        context.addView(this.onBuildContent(qMUIDialog, (ScrollView)context));
        viewGroup.addView((View)this.mScrollerView);
    }

    public int onGetScrollHeight() {
        return -2;
    }
}
