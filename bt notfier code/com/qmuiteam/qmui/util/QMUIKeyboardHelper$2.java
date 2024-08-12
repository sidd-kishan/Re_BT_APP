/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUIKeyboardHelper$KeyboardVisibilityEventListener
 */
package com.qmuiteam.qmui.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIKeyboardHelper;

static final class QMUIKeyboardHelper.2
implements ViewTreeObserver.OnGlobalLayoutListener {
    private final Rect r;
    final Activity val$activity;
    final View val$activityRoot;
    final QMUIKeyboardHelper.KeyboardVisibilityEventListener val$listener;
    private final int visibleThreshold;
    private boolean wasOpened;

    QMUIKeyboardHelper.2(Activity activity, View view, QMUIKeyboardHelper.KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        this.val$activity = activity;
        this.val$activityRoot = view;
        this.val$listener = keyboardVisibilityEventListener;
        this.r = new Rect();
        this.visibleThreshold = Math.round(QMUIDisplayHelper.dp2px((Context)this.val$activity, (int)100));
        this.wasOpened = false;
    }

    public void onGlobalLayout() {
        this.val$activityRoot.getWindowVisibleDisplayFrame(this.r);
        int n = this.val$activityRoot.getRootView().getHeight() - this.r.height();
        boolean bl = n > this.visibleThreshold;
        if (bl == this.wasOpened) {
            return;
        }
        this.wasOpened = bl;
        if (!this.val$listener.onVisibilityChanged(bl, n)) return;
        if (Build.VERSION.SDK_INT >= 16) {
            this.val$activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        } else {
            this.val$activityRoot.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
    }
}
