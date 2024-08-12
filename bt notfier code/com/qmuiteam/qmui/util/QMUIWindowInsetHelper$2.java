/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 *  com.qmuiteam.qmui.util.QMUIWindowInsetHelper
 *  com.qmuiteam.qmui.widget.IWindowInsetLayout
 */
package com.qmuiteam.qmui.util;

import android.view.View;
import android.view.WindowInsets;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;
import com.qmuiteam.qmui.widget.IWindowInsetLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIWindowInsetHelper.2
implements View.OnApplyWindowInsetsListener {
    final QMUIWindowInsetHelper this$0;

    QMUIWindowInsetHelper.2(QMUIWindowInsetHelper qMUIWindowInsetHelper) {
        this.this$0 = qMUIWindowInsetHelper;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (QMUIWindowInsetHelper.access$000((QMUIWindowInsetHelper)this.this$0).get() == null) return windowInsets;
        if (!((IWindowInsetLayout)QMUIWindowInsetHelper.access$000((QMUIWindowInsetHelper)this.this$0).get()).applySystemWindowInsets21((Object)windowInsets)) return windowInsets;
        windowInsets = windowInsets.consumeSystemWindowInsets();
        view = windowInsets;
        if (windowInsets.getDisplayCutout() == null) return view;
        view = windowInsets.consumeDisplayCutout();
        return view;
    }
}
