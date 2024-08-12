/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.view.View$MeasureSpec
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.layout.QMUILinearLayout
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogView$OnDecorationListener
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogView;

public class QMUIDialogView
extends QMUILinearLayout {
    private int mMaxWidth;
    private int mMinWidth;
    private OnDecorationListener mOnDecorationListener;

    public QMUIDialogView(Context context) {
        this(context, null);
    }

    public QMUIDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIDialogView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mMinWidth = QMUIResHelper.getAttrDimen((Context)context, (int)R.attr.qmui_dialog_min_width);
        this.mMaxWidth = QMUIResHelper.getAttrDimen((Context)context, (int)R.attr.qmui_dialog_max_width);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        OnDecorationListener onDecorationListener = this.mOnDecorationListener;
        if (onDecorationListener == null) return;
        onDecorationListener.onDrawOver(canvas, this);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        OnDecorationListener onDecorationListener = this.mOnDecorationListener;
        if (onDecorationListener == null) return;
        onDecorationListener.onDraw(canvas, this);
    }

    protected void onMeasure(int n, int n2) {
        int n3 = View.MeasureSpec.getSize((int)n);
        int n4 = View.MeasureSpec.getMode((int)n);
        int n5 = this.mMaxWidth;
        int n6 = n;
        if (n5 > 0) {
            n6 = n;
            if (n3 > n5) {
                n6 = View.MeasureSpec.makeMeasureSpec((int)n5, (int)n4);
            }
        }
        super.onMeasure(n6, n2);
        if (n4 != Integer.MIN_VALUE) return;
        n = this.getMeasuredWidth();
        if (n >= (n6 = this.mMinWidth)) return;
        if (n6 >= n3) return;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)n6, (int)0x40000000), n2);
    }

    public void setMaxWidth(int n) {
        this.mMaxWidth = n;
    }

    public void setMinWidth(int n) {
        this.mMinWidth = n;
    }

    public void setOnDecorationListener(OnDecorationListener onDecorationListener) {
        this.mOnDecorationListener = onDecorationListener;
    }
}
