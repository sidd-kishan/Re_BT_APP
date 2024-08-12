/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  androidx.viewpager.widget.ViewPager
 *  com.luck.picture.lib.widget.MScroller
 *  com.luck.picture.lib.widget.MyViewPageHelper
 */
package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.luck.picture.lib.widget.MScroller;
import com.luck.picture.lib.widget.MyViewPageHelper;

public class PreviewViewPager
extends ViewPager {
    private MyViewPageHelper helper;

    public PreviewViewPager(Context context) {
        super(context);
    }

    public PreviewViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.helper = new MyViewPageHelper((ViewPager)this);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            boolean bl = super.dispatchTouchEvent(motionEvent);
            return bl;
        }
        catch (ArrayIndexOutOfBoundsException | IllegalArgumentException runtimeException) {
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            boolean bl = super.onInterceptTouchEvent(motionEvent);
            return bl;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            boolean bl = super.onTouchEvent(motionEvent);
            return bl;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return false;
        }
    }

    public void setCurrentItem(int n) {
        this.setCurrentItem(n, true);
    }

    public void setCurrentItem(int n, boolean bl) {
        MScroller mScroller = this.helper.getScroller();
        if (Math.abs(this.getCurrentItem() - n) > 1) {
            mScroller.setNoDuration(true);
            super.setCurrentItem(n, bl);
            mScroller.setNoDuration(false);
        } else {
            mScroller.setNoDuration(false);
            super.setCurrentItem(n, bl);
        }
    }
}
