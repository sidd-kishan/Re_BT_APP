/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.view.View
 *  android.widget.FrameLayout
 *  com.qmuiteam.qmui.util.QMUINotchHelper
 *  com.qmuiteam.qmui.widget.INotchInsetConsumer
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qmuiteam.qmui.util.QMUINotchHelper;
import com.qmuiteam.qmui.widget.INotchInsetConsumer;

public class QMUINotchConsumeLayout
extends FrameLayout
implements INotchInsetConsumer {
    public QMUINotchConsumeLayout(Context context) {
        this(context, null);
    }

    public QMUINotchConsumeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUINotchConsumeLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.setFitsSystemWindows(false);
    }

    public boolean notifyInsetMaybeChanged() {
        this.setPadding(QMUINotchHelper.getSafeInsetLeft((View)this), QMUINotchHelper.getSafeInsetTop((View)this), QMUINotchHelper.getSafeInsetRight((View)this), QMUINotchHelper.getSafeInsetBottom((View)this));
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (QMUINotchHelper.isNotchOfficialSupport()) return;
        this.notifyInsetMaybeChanged();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (QMUINotchHelper.isNotchOfficialSupport()) return;
        this.notifyInsetMaybeChanged();
    }
}
