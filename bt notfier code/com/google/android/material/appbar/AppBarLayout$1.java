/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.WindowInsetsCompat
 *  com.google.android.material.appbar.AppBarLayout
 */
package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;

class AppBarLayout.1
implements OnApplyWindowInsetsListener {
    final AppBarLayout this$0;

    AppBarLayout.1(AppBarLayout appBarLayout) {
        this.this$0 = appBarLayout;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.this$0.onWindowInsetChanged(windowInsetsCompat);
    }
}
