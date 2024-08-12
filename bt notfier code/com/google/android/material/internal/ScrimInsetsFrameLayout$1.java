/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  com.google.android.material.internal.ScrimInsetsFrameLayout
 */
package com.google.android.material.internal;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ScrimInsetsFrameLayout;

class ScrimInsetsFrameLayout.1
implements OnApplyWindowInsetsListener {
    final ScrimInsetsFrameLayout this$0;

    ScrimInsetsFrameLayout.1(ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
        this.this$0 = scrimInsetsFrameLayout;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (this.this$0.insets == null) {
            this.this$0.insets = new Rect();
        }
        this.this$0.insets.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        this.this$0.onInsetsChanged(windowInsetsCompat);
        view = this.this$0;
        boolean bl = !windowInsetsCompat.hasSystemWindowInsets() || this.this$0.insetForeground == null;
        view.setWillNotDraw(bl);
        ViewCompat.postInvalidateOnAnimation((View)this.this$0);
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
