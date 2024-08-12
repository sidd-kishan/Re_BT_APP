/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.WindowInsetsCompat
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 */
package com.google.android.material.snackbar;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;

class BaseTransientBottomBar.2
implements OnApplyWindowInsetsListener {
    final BaseTransientBottomBar this$0;

    BaseTransientBottomBar.2(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        return windowInsetsCompat;
    }
}
