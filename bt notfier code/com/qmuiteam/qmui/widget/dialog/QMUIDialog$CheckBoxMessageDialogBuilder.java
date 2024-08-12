/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.widget.QMUIWrapContentScrollView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MessageDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
 *  com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUIWrapContentScrollView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

/*
 * Exception performing whole class analysis ignored.
 */
public static class QMUIDialog.CheckBoxMessageDialogBuilder
extends QMUIDialogBuilder<QMUIDialog.CheckBoxMessageDialogBuilder> {
    private Drawable mCheckMarkDrawable;
    private boolean mIsChecked = false;
    protected String mMessage;
    private QMUIWrapContentScrollView mScrollContainer;
    private QMUISpanTouchFixTextView mTextView;

    public QMUIDialog.CheckBoxMessageDialogBuilder(Context context) {
        super(context);
        this.mCheckMarkDrawable = QMUIResHelper.getAttrDrawable((Context)context, (int)R.attr.qmui_s_checkbox);
    }

    static /* synthetic */ boolean access$000(QMUIDialog.CheckBoxMessageDialogBuilder checkBoxMessageDialogBuilder) {
        return checkBoxMessageDialogBuilder.mIsChecked;
    }

    public QMUISpanTouchFixTextView getTextView() {
        return this.mTextView;
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }

    protected void onCreateContent(QMUIDialog object, ViewGroup viewGroup, Context context) {
        object = this.mMessage;
        if (object == null) return;
        if (((String)object).length() == 0) return;
        this.mScrollContainer = new QMUIWrapContentScrollView(context);
        object = new QMUISpanTouchFixTextView(context);
        this.mTextView = object;
        object.setMovementMethodDefault();
        QMUIDialog.MessageDialogBuilder.assignMessageTvWithAttr((TextView)this.mTextView, (boolean)this.hasTitle(), (int)R.attr.qmui_dialog_message_content_style);
        object = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)object).gravity = this.mTextView.getGravity();
        this.mScrollContainer.addView((View)this.mTextView, (ViewGroup.LayoutParams)object);
        this.mScrollContainer.setVerticalScrollBarEnabled(false);
        this.mScrollContainer.setMaxHeight(this.getContentAreaMaxHeight());
        this.mTextView.setText((CharSequence)this.mMessage);
        object = this.mCheckMarkDrawable;
        object.setBounds(0, 0, object.getIntrinsicWidth(), this.mCheckMarkDrawable.getIntrinsicHeight());
        this.mTextView.setCompoundDrawables(this.mCheckMarkDrawable, null, null, null);
        this.mTextView.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mTextView.setSelected(this.mIsChecked);
        viewGroup.addView((View)this.mScrollContainer);
    }

    public QMUIDialog.CheckBoxMessageDialogBuilder setChecked(boolean bl) {
        if (this.mIsChecked == bl) return this;
        this.mIsChecked = bl;
        QMUISpanTouchFixTextView qMUISpanTouchFixTextView = this.mTextView;
        if (qMUISpanTouchFixTextView == null) return this;
        qMUISpanTouchFixTextView.setSelected(bl);
        return this;
    }

    public QMUIDialog.CheckBoxMessageDialogBuilder setMessage(int n) {
        return this.setMessage(this.getBaseContext().getResources().getString(n));
    }

    public QMUIDialog.CheckBoxMessageDialogBuilder setMessage(String string) {
        this.mMessage = string;
        return this;
    }
}
