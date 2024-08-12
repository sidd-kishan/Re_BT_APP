/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.WindowInsetsCompat
 *  com.google.android.material.appbar.CollapsingToolbarLayout
 */
package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.CollapsingToolbarLayout;

class CollapsingToolbarLayout.1
implements OnApplyWindowInsetsListener {
    final CollapsingToolbarLayout this$0;

    CollapsingToolbarLayout.1(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.this$0 = collapsingToolbarLayout;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.this$0.onWindowInsetChanged(windowInsetsCompat);
    }
}
