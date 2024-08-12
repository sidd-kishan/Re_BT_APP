/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.math.MathUtils
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener
 *  com.google.android.material.appbar.CollapsingToolbarLayout
 *  com.google.android.material.appbar.CollapsingToolbarLayout$LayoutParams
 *  com.google.android.material.appbar.ViewOffsetHelper
 */
package com.google.android.material.appbar;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.ViewOffsetHelper;

/*
 * Exception performing whole class analysis ignored.
 */
private class CollapsingToolbarLayout.OffsetUpdateListener
implements AppBarLayout.OnOffsetChangedListener {
    final CollapsingToolbarLayout this$0;

    CollapsingToolbarLayout.OffsetUpdateListener(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.this$0 = collapsingToolbarLayout;
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int n) {
        int n2;
        this.this$0.currentOffset = n;
        int n3 = this.this$0.lastInsets != null ? this.this$0.lastInsets.getSystemWindowInsetTop() : 0;
        int n4 = this.this$0.getChildCount();
        for (n2 = 0; n2 < n4; ++n2) {
            View view = this.this$0.getChildAt(n2);
            appBarLayout = (CollapsingToolbarLayout.LayoutParams)view.getLayoutParams();
            ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper((View)view);
            int n5 = appBarLayout.collapseMode;
            if (n5 != 1) {
                if (n5 != 2) continue;
                viewOffsetHelper.setTopAndBottomOffset(Math.round((float)(-n) * appBarLayout.parallaxMult));
                continue;
            }
            viewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp((int)(-n), (int)0, (int)this.this$0.getMaxOffsetForPinChild(view)));
        }
        this.this$0.updateScrimVisibility();
        if (this.this$0.statusBarScrim != null && n3 > 0) {
            ViewCompat.postInvalidateOnAnimation((View)this.this$0);
        }
        n2 = this.this$0.getHeight();
        n4 = ViewCompat.getMinimumHeight((View)this.this$0);
        this.this$0.collapsingTextHelper.setExpansionFraction((float)Math.abs(n) / (float)(n2 - n4 - n3));
    }
}
