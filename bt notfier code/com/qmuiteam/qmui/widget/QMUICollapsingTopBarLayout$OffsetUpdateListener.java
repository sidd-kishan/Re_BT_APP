/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener
 *  com.qmuiteam.qmui.util.QMUILangHelper
 *  com.qmuiteam.qmui.util.QMUIViewOffsetHelper
 *  com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout
 *  com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout$LayoutParams
 */
package com.qmuiteam.qmui.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIViewOffsetHelper;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;

/*
 * Exception performing whole class analysis ignored.
 */
private class QMUICollapsingTopBarLayout.OffsetUpdateListener
implements AppBarLayout.OnOffsetChangedListener {
    final QMUICollapsingTopBarLayout this$0;

    QMUICollapsingTopBarLayout.OffsetUpdateListener(QMUICollapsingTopBarLayout qMUICollapsingTopBarLayout) {
        this.this$0 = qMUICollapsingTopBarLayout;
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int n) {
        int n2;
        this.this$0.mCurrentOffset = n;
        int n3 = QMUICollapsingTopBarLayout.access$100((QMUICollapsingTopBarLayout)this.this$0);
        int n4 = this.this$0.getChildCount();
        for (n2 = 0; n2 < n4; ++n2) {
            appBarLayout = this.this$0.getChildAt(n2);
            QMUICollapsingTopBarLayout.LayoutParams layoutParams = (QMUICollapsingTopBarLayout.LayoutParams)appBarLayout.getLayoutParams();
            QMUIViewOffsetHelper qMUIViewOffsetHelper = QMUICollapsingTopBarLayout.getViewOffsetHelper((View)appBarLayout);
            int n5 = layoutParams.mCollapseMode;
            if (n5 != 1) {
                if (n5 != 2) continue;
                qMUIViewOffsetHelper.setTopAndBottomOffset(Math.round((float)(-n) * layoutParams.mParallaxMult));
                continue;
            }
            qMUIViewOffsetHelper.setTopAndBottomOffset(QMUILangHelper.constrain((int)(-n), (int)0, (int)this.this$0.getMaxOffsetForPinChild((View)appBarLayout, false)));
        }
        this.this$0.updateScrimVisibility();
        if (this.this$0.mStatusBarScrim != null && n3 > 0) {
            ViewCompat.postInvalidateOnAnimation((View)this.this$0);
        }
        n2 = this.this$0.getHeight();
        n4 = ViewCompat.getMinimumHeight((View)this.this$0);
        this.this$0.mCollapsingTextHelper.setExpansionFraction((float)Math.abs(n) / (float)(n2 - n4 - n3));
    }
}
