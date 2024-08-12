/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager
 *  com.luck.picture.lib.widget.MScroller
 */
package com.luck.picture.lib.widget;

import androidx.viewpager.widget.ViewPager;
import com.luck.picture.lib.widget.MScroller;
import java.lang.reflect.Field;

public class MyViewPageHelper {
    MScroller scroller;
    ViewPager viewPager;

    public MyViewPageHelper(ViewPager viewPager) {
        this.viewPager = viewPager;
        this.init();
    }

    private void init() {
        this.scroller = new MScroller(this.viewPager.getContext());
        try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            field.set(this.viewPager, this.scroller);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public MScroller getScroller() {
        return this.scroller;
    }

    public void setCurrentItem(int n) {
        this.setCurrentItem(n, true);
    }

    public void setCurrentItem(int n, boolean bl) {
        if (Math.abs(this.viewPager.getCurrentItem() - n) > 1) {
            this.scroller.setNoDuration(true);
            this.viewPager.setCurrentItem(n, bl);
            this.scroller.setNoDuration(false);
        } else {
            this.scroller.setNoDuration(false);
            this.viewPager.setCurrentItem(n, bl);
        }
    }
}
