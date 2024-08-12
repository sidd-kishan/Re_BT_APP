/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogView
 */
package com.qmuiteam.qmui.widget.dialog;

import android.graphics.Canvas;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogView;

public static interface QMUIDialogView.OnDecorationListener {
    public void onDraw(Canvas var1, QMUIDialogView var2);

    public void onDrawOver(Canvas var1, QMUIDialogView var2);
}
