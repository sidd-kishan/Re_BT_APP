/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;

public static class QMUIDialog.CustomDialogBuilder
extends QMUIDialogBuilder {
    private int mLayoutId;

    public QMUIDialog.CustomDialogBuilder(Context context) {
        super(context);
    }

    protected void onCreateContent(QMUIDialog qMUIDialog, ViewGroup viewGroup, Context context) {
        viewGroup.addView(LayoutInflater.from((Context)context).inflate(this.mLayoutId, viewGroup, false));
    }

    public QMUIDialog.CustomDialogBuilder setLayout(int n) {
        this.mLayoutId = n;
        return this;
    }
}
