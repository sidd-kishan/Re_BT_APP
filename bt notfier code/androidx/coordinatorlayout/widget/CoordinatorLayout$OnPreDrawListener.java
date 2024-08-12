/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 */
package androidx.coordinatorlayout.widget;

import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class CoordinatorLayout.OnPreDrawListener
implements ViewTreeObserver.OnPreDrawListener {
    final CoordinatorLayout this$0;

    CoordinatorLayout.OnPreDrawListener(CoordinatorLayout coordinatorLayout) {
        this.this$0 = coordinatorLayout;
    }

    public boolean onPreDraw() {
        this.this$0.onChildViewsChanged(0);
        return true;
    }
}
