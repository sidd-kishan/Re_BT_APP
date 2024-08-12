/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.viewpager.widget.PagerTabStrip
 */
package androidx.viewpager.widget;

import android.view.View;
import androidx.viewpager.widget.PagerTabStrip;

class PagerTabStrip.1
implements View.OnClickListener {
    final PagerTabStrip this$0;

    PagerTabStrip.1(PagerTabStrip pagerTabStrip) {
        this.this$0 = pagerTabStrip;
    }

    public void onClick(View view) {
        this.this$0.mPager.setCurrentItem(this.this$0.mPager.getCurrentItem() - 1);
    }
}
