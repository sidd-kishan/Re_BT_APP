/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.LinearLayout
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButtonDrawable
 */
package com.qmuiteam.qmui.widget.roundwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButtonDrawable;

public class QMUIRoundLinearLayout
extends LinearLayout {
    public QMUIRoundLinearLayout(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public QMUIRoundLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, R.attr.QMUIButtonStyle);
    }

    public QMUIRoundLinearLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        QMUIViewHelper.setBackgroundKeepingPadding((View)this, (Drawable)QMUIRoundButtonDrawable.fromAttributeSet((Context)context, (AttributeSet)attributeSet, (int)0));
    }
}