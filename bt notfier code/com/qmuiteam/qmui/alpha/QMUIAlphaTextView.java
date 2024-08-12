/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  androidx.appcompat.widget.AppCompatTextView
 *  com.qmuiteam.qmui.alpha.QMUIAlphaViewHelper
 */
package com.qmuiteam.qmui.alpha;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.qmuiteam.qmui.alpha.QMUIAlphaViewHelper;

public class QMUIAlphaTextView
extends AppCompatTextView {
    private QMUIAlphaViewHelper mAlphaViewHelper;

    public QMUIAlphaTextView(Context context) {
        super(context);
    }

    public QMUIAlphaTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIAlphaTextView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    private QMUIAlphaViewHelper getAlphaViewHelper() {
        if (this.mAlphaViewHelper != null) return this.mAlphaViewHelper;
        this.mAlphaViewHelper = new QMUIAlphaViewHelper((View)this);
        return this.mAlphaViewHelper;
    }

    public void setChangeAlphaWhenDisable(boolean bl) {
        this.getAlphaViewHelper().setChangeAlphaWhenDisable(bl);
    }

    public void setChangeAlphaWhenPress(boolean bl) {
        this.getAlphaViewHelper().setChangeAlphaWhenPress(bl);
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        this.getAlphaViewHelper().onEnabledChanged((View)this, bl);
    }

    public void setPressed(boolean bl) {
        super.setPressed(bl);
        this.getAlphaViewHelper().onPressedChanged((View)this, bl);
    }
}
