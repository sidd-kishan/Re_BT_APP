/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

public static class QMUIDialogMenuItemView.TextItemView
extends QMUIDialogMenuItemView {
    protected TextView mTextView;

    public QMUIDialogMenuItemView.TextItemView(Context context) {
        super(context);
        this.init();
    }

    public QMUIDialogMenuItemView.TextItemView(Context context, CharSequence charSequence) {
        super(context);
        this.init();
        this.setText(charSequence);
    }

    private void init() {
        TextView textView;
        this.mTextView = textView = QMUIDialogMenuItemView.TextItemView.createItemTextView((Context)this.getContext());
        this.addView((View)textView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    }

    public void setText(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
    }

    public void setTextColor(int n) {
        this.mTextView.setTextColor(n);
    }
}
