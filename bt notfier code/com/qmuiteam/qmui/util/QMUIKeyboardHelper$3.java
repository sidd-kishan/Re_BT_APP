/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  com.qmuiteam.qmui.util.QMUIActivityLifecycleCallbacks
 */
package com.qmuiteam.qmui.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.qmuiteam.qmui.util.QMUIActivityLifecycleCallbacks;

static final class QMUIKeyboardHelper.3
extends QMUIActivityLifecycleCallbacks {
    final View val$activityRoot;
    final ViewTreeObserver.OnGlobalLayoutListener val$layoutListener;

    QMUIKeyboardHelper.3(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.val$activityRoot = view;
        this.val$layoutListener = onGlobalLayoutListener;
        super(activity);
    }

    protected void onTargetActivityDestroyed() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.val$activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener(this.val$layoutListener);
        } else {
            this.val$activityRoot.getViewTreeObserver().removeGlobalOnLayoutListener(this.val$layoutListener);
        }
    }
}
