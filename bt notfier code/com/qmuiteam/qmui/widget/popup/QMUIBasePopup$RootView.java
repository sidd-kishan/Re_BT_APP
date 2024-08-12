/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.util.Log
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  com.qmuiteam.qmui.layout.QMUIFrameLayout
 *  com.qmuiteam.qmui.widget.popup.QMUIBasePopup
 */
package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.popup.QMUIBasePopup;

public class QMUIBasePopup.RootView
extends QMUIFrameLayout {
    final QMUIBasePopup this$0;

    public QMUIBasePopup.RootView(QMUIBasePopup qMUIBasePopup, Context context) {
        this(qMUIBasePopup, context, null);
    }

    public QMUIBasePopup.RootView(QMUIBasePopup qMUIBasePopup, Context context, AttributeSet attributeSet) {
        this.this$0 = qMUIBasePopup;
        super(context, attributeSet);
    }

    public void addView(View view) {
        if (this.getChildCount() > 0) throw new RuntimeException("only support one child");
        super.addView(view);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (this.this$0.mWindow != null && this.this$0.mWindow.isShowing()) {
            this.this$0.mWindow.dismiss();
        }
        this.this$0.onConfigurationChanged(configuration);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (this.getChildCount() == 0) {
            return;
        }
        View view = this.getChildAt(0);
        view.layout(this.getPaddingLeft(), this.getPaddingTop(), view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onMeasure(int n, int n2) {
        if (this.getChildCount() == 0) {
            this.setMeasuredDimension(0, 0);
        }
        int n3 = View.MeasureSpec.getSize((int)n);
        int n4 = View.MeasureSpec.getSize((int)n2);
        n = this.this$0.makeWidthMeasureSpec((View)this);
        n2 = this.this$0.makeHeightMeasureSpec((View)this);
        int n5 = View.MeasureSpec.getSize((int)n);
        int n6 = View.MeasureSpec.getMode((int)n);
        int n7 = View.MeasureSpec.getSize((int)n2);
        int n8 = View.MeasureSpec.getMode((int)n2);
        if (n3 < n5) {
            n = View.MeasureSpec.makeMeasureSpec((int)n3, (int)n6);
        }
        if (n4 < n7) {
            n2 = View.MeasureSpec.makeMeasureSpec((int)n4, (int)n8);
        }
        Object object = this.getChildAt(0);
        object.measure(n, n2);
        n2 = this.this$0.mWindowWidth;
        n = this.this$0.mWindowHeight;
        this.this$0.mWindowWidth = object.getMeasuredWidth();
        this.this$0.mWindowHeight = object.getMeasuredHeight();
        if (n2 != this.this$0.mWindowWidth || n != this.this$0.mWindowHeight && this.this$0.mWindow.isShowing()) {
            this.this$0.onWindowSizeChange();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("in measure: mWindowWidth = ");
        ((StringBuilder)object).append(this.this$0.mWindowWidth);
        ((StringBuilder)object).append(" ;mWindowHeight = ");
        ((StringBuilder)object).append(this.this$0.mWindowHeight);
        Log.i((String)"QMUIBasePopup", (String)((StringBuilder)object).toString());
        this.setMeasuredDimension(this.this$0.mWindowWidth, this.this$0.mWindowHeight);
    }
}
