/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.TouchDelegate
 *  android.view.View
 */
package com.qmuiteam.qmui.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

static final class QMUIViewHelper.1
implements Runnable {
    final int val$expendSize;
    final View val$parentView;
    final View val$view;

    QMUIViewHelper.1(View view, int n, View view2) {
        this.val$view = view;
        this.val$expendSize = n;
        this.val$parentView = view2;
    }

    @Override
    public void run() {
        Rect rect = new Rect();
        this.val$view.getHitRect(rect);
        rect.left -= this.val$expendSize;
        rect.top -= this.val$expendSize;
        rect.right += this.val$expendSize;
        rect.bottom += this.val$expendSize;
        this.val$parentView.setTouchDelegate(new TouchDelegate(rect, this.val$view));
    }
}
