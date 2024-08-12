/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager
 */
package androidx.viewpager.widget;

import androidx.viewpager.widget.ViewPager;

class ViewPager.3
implements Runnable {
    final ViewPager this$0;

    ViewPager.3(ViewPager viewPager) {
        this.this$0 = viewPager;
    }

    @Override
    public void run() {
        this.this$0.setScrollState(0);
        this.this$0.populate();
    }
}
