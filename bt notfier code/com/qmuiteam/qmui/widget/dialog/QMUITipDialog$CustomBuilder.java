/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$layout
 *  com.qmuiteam.qmui.widget.dialog.QMUITipDialog
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

public static class QMUITipDialog.CustomBuilder {
    private int mContentLayoutId;
    private Context mContext;

    public QMUITipDialog.CustomBuilder(Context context) {
        this.mContext = context;
    }

    public QMUITipDialog create() {
        QMUITipDialog qMUITipDialog = new QMUITipDialog(this.mContext);
        qMUITipDialog.setContentView(R.layout.qmui_tip_dialog_layout);
        ViewGroup viewGroup = (ViewGroup)qMUITipDialog.findViewById(R.id.contentWrap);
        LayoutInflater.from((Context)this.mContext).inflate(this.mContentLayoutId, viewGroup, true);
        return qMUITipDialog;
    }

    public QMUITipDialog.CustomBuilder setContent(int n) {
        this.mContentLayoutId = n;
        return this;
    }
}
