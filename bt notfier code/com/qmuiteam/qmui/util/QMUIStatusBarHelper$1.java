/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.Window
 *  com.qmuiteam.qmui.util.QMUIStatusBarHelper
 */
package com.qmuiteam.qmui.util;

import android.view.View;
import android.view.Window;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

/*
 * Exception performing whole class analysis ignored.
 */
static final class QMUIStatusBarHelper.1
implements View.OnAttachStateChangeListener {
    final Window val$window;

    QMUIStatusBarHelper.1(Window window) {
        this.val$window = window;
    }

    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        QMUIStatusBarHelper.access$000((Window)this.val$window, (View)view);
    }

    public void onViewDetachedFromWindow(View view) {
    }
}
