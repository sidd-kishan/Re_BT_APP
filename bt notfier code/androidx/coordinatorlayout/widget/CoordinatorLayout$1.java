/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.WindowInsetsCompat
 */
package androidx.coordinatorlayout.widget;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

class CoordinatorLayout.1
implements OnApplyWindowInsetsListener {
    final CoordinatorLayout this$0;

    CoordinatorLayout.1(CoordinatorLayout coordinatorLayout) {
        this.this$0 = coordinatorLayout;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.this$0.setWindowInsets(windowInsetsCompat);
    }
}
