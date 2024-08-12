/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.WindowInsetsCompat
 *  com.qmuiteam.qmui.util.QMUIWindowInsetHelper
 *  com.qmuiteam.qmui.widget.IWindowInsetLayout
 */
package com.qmuiteam.qmui.util;

import android.os.Build;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;
import com.qmuiteam.qmui.widget.IWindowInsetLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIWindowInsetHelper.1
implements OnApplyWindowInsetsListener {
    final QMUIWindowInsetHelper this$0;

    QMUIWindowInsetHelper.1(QMUIWindowInsetHelper qMUIWindowInsetHelper) {
        this.this$0 = qMUIWindowInsetHelper;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (Build.VERSION.SDK_INT < 21) return windowInsetsCompat;
        if (QMUIWindowInsetHelper.access$000((QMUIWindowInsetHelper)this.this$0).get() == null) return windowInsetsCompat;
        if (!((IWindowInsetLayout)QMUIWindowInsetHelper.access$000((QMUIWindowInsetHelper)this.this$0).get()).applySystemWindowInsets21((Object)windowInsetsCompat)) return windowInsetsCompat;
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
