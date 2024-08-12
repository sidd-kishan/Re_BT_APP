/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.widget.QMUIWrapContentScrollView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
 *  com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUIWrapContentScrollView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

public static class QMUIDialog.MessageDialogBuilder
extends QMUIDialogBuilder<QMUIDialog.MessageDialogBuilder> {
    protected CharSequence mMessage;
    private QMUIWrapContentScrollView mScrollContainer;
    private QMUISpanTouchFixTextView mTextView;

    public QMUIDialog.MessageDialogBuilder(Context context) {
        super(context);
    }

    public static void assignMessageTvWithAttr(TextView textView, boolean bl, int n) {
        QMUIResHelper.assignTextViewWithAttr((TextView)textView, (int)n);
        if (bl) return;
        Context context = textView.getContext();
        int[] nArray = R.styleable.QMUIDialogMessageTvCustomDef;
        int n2 = 0;
        context = context.obtainStyledAttributes(null, nArray, n, 0);
        int n3 = context.getIndexCount();
        n = n2;
        while (true) {
            if (n >= n3) {
                context.recycle();
                return;
            }
            n2 = context.getIndex(n);
            if (n2 == R.styleable.QMUIDialogMessageTvCustomDef_qmui_paddingTopWhenNotTitle) {
                textView.setPadding(textView.getPaddingLeft(), context.getDimensionPixelSize(n2, textView.getPaddingTop()), textView.getPaddingRight(), textView.getPaddingBottom());
            }
            ++n;
        }
    }

    public QMUISpanTouchFixTextView getTextView() {
        return this.mTextView;
    }

    protected void onConfigTitleView(TextView textView) {
        super.onConfigTitleView(textView);
        CharSequence charSequence = this.mMessage;
        if (charSequence != null) {
            if (charSequence.length() != 0) return;
        }
        charSequence = textView.getContext();
        int[] nArray = R.styleable.QMUIDialogTitleTvCustomDef;
        int n = R.attr.qmui_dialog_title_style;
        int n2 = 0;
        charSequence = charSequence.obtainStyledAttributes(null, nArray, n, 0);
        n = charSequence.getIndexCount();
        while (true) {
            if (n2 >= n) {
                charSequence.recycle();
                return;
            }
            int n3 = charSequence.getIndex(n2);
            if (n3 == R.styleable.QMUIDialogTitleTvCustomDef_qmui_paddingBottomWhenNotContent) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), charSequence.getDimensionPixelSize(n3, textView.getPaddingBottom()));
            }
            ++n2;
        }
    }

    protected void onCreateContent(QMUIDialog object, ViewGroup viewGroup, Context context) {
        object = this.mMessage;
        if (object == null) return;
        if (object.length() == 0) return;
        object = new QMUISpanTouchFixTextView(context);
        this.mTextView = object;
        QMUIDialog.MessageDialogBuilder.assignMessageTvWithAttr((TextView)object, this.hasTitle(), R.attr.qmui_dialog_message_content_style);
        this.mTextView.setText(this.mMessage);
        this.mTextView.setMovementMethodDefault();
        object = new QMUIWrapContentScrollView(context);
        this.mScrollContainer = object;
        object.setMaxHeight(this.getContentAreaMaxHeight());
        this.mScrollContainer.setVerticalScrollBarEnabled(false);
        this.mScrollContainer.addView((View)this.mTextView);
        viewGroup.addView((View)this.mScrollContainer);
    }

    public QMUIDialog.MessageDialogBuilder setMessage(int n) {
        return this.setMessage(this.getBaseContext().getResources().getString(n));
    }

    public QMUIDialog.MessageDialogBuilder setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        return this;
    }
}
