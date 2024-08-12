/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.layout.QMUIFrameLayout
 *  com.qmuiteam.qmui.util.QMUIWindowInsetHelper
 *  com.qmuiteam.qmui.widget.IWindowInsetLayout
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;
import com.qmuiteam.qmui.widget.IWindowInsetLayout;

public class QMUIWindowInsetLayout
extends QMUIFrameLayout
implements IWindowInsetLayout {
    protected QMUIWindowInsetHelper mQMUIWindowInsetHelper = new QMUIWindowInsetHelper((ViewGroup)this, (IWindowInsetLayout)this);

    public QMUIWindowInsetLayout(Context context) {
        this(context, null);
    }

    public QMUIWindowInsetLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIWindowInsetLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    public boolean applySystemWindowInsets19(Rect rect) {
        return this.mQMUIWindowInsetHelper.defaultApplySystemWindowInsets19((ViewGroup)this, rect);
    }

    public boolean applySystemWindowInsets21(Object object) {
        return this.mQMUIWindowInsetHelper.defaultApplySystemWindowInsets21((ViewGroup)this, object);
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT < 19) return super.fitSystemWindows(rect);
        if (Build.VERSION.SDK_INT >= 21) return super.fitSystemWindows(rect);
        return this.applySystemWindowInsets19(rect);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.requestApplyInsets((View)this);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ViewCompat.requestApplyInsets((View)this);
    }
}
