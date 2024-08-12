/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.alpha.QMUIAlphaButton
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButtonDrawable
 */
package com.qmuiteam.qmui.widget.roundwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaButton;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButtonDrawable;

public class QMUIRoundButton
extends QMUIAlphaButton {
    public QMUIRoundButton(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public QMUIRoundButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.QMUIButtonStyle);
        this.init(context, attributeSet, R.attr.QMUIButtonStyle);
    }

    public QMUIRoundButton(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        QMUIViewHelper.setBackgroundKeepingPadding((View)this, (Drawable)QMUIRoundButtonDrawable.fromAttributeSet((Context)context, (AttributeSet)attributeSet, (int)n));
        this.setChangeAlphaWhenDisable(false);
        this.setChangeAlphaWhenPress(false);
    }
}
