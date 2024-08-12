/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.lianhezhuli.btnotification.function.home.fragment.SportFragment
 *  com.lianhezhuli.btnotification.function.home.fragment.mvp.sport.SportPresenter
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.lianhezhuli.btnotification.function.home.fragment.SportFragment;
import com.lianhezhuli.btnotification.function.home.fragment.mvp.sport.SportPresenter;

/*
 * Exception performing whole class analysis ignored.
 */
class SportFragment.2
implements ViewPager.OnPageChangeListener {
    final SportFragment this$0;

    SportFragment.2(SportFragment sportFragment) {
        this.this$0 = sportFragment;
    }

    public void onPageScrollStateChanged(int n) {
    }

    public void onPageScrolled(int n, float f, int n2) {
    }

    public void onPageSelected(int n) {
        int n2 = 0;
        while (true) {
            if (n2 >= SportFragment.access$100((SportFragment)this.this$0).length) {
                ((TextView)((View)SportFragment.access$000((SportFragment)this.this$0).get(n)).findViewById(2131296765)).setText((CharSequence)SportFragment.access$200((SportFragment)this.this$0)[n]);
                ((SportPresenter)SportFragment.access$300((SportFragment)this.this$0)).getStepData(n);
                return;
            }
            if (n != n2) {
                SportFragment.access$100((SportFragment)this.this$0)[n2].setBackgroundResource(2131623983);
            } else {
                SportFragment.access$100((SportFragment)this.this$0)[n2].setBackgroundResource(2131623982);
            }
            ++n2;
        }
    }
}
