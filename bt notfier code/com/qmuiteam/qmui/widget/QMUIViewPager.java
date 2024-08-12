/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.core.view.ViewCompat
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  com.qmuiteam.qmui.util.QMUIWindowInsetHelper
 *  com.qmuiteam.qmui.widget.IWindowInsetLayout
 *  com.qmuiteam.qmui.widget.QMUIPagerAdapter
 *  com.qmuiteam.qmui.widget.QMUIViewPager$WrapperPagerAdapter
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;
import com.qmuiteam.qmui.widget.IWindowInsetLayout;
import com.qmuiteam.qmui.widget.QMUIPagerAdapter;
import com.qmuiteam.qmui.widget.QMUIViewPager;

public class QMUIViewPager
extends ViewPager
implements IWindowInsetLayout {
    private static final int DEFAULT_INFINITE_RATIO = 100;
    private boolean mEnableLoop = false;
    private int mInfiniteRatio = 100;
    private boolean mIsInMeasure = false;
    private boolean mIsSwipeable = true;
    private QMUIWindowInsetHelper mQMUIWindowInsetHelper = new QMUIWindowInsetHelper((ViewGroup)this, (IWindowInsetLayout)this);

    public QMUIViewPager(Context context) {
        this(context, null);
    }

    public QMUIViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ boolean access$000(QMUIViewPager qMUIViewPager) {
        return qMUIViewPager.mEnableLoop;
    }

    static /* synthetic */ int access$100(QMUIViewPager qMUIViewPager) {
        return qMUIViewPager.mInfiniteRatio;
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, n, layoutParams);
        ViewCompat.requestApplyInsets((View)this);
    }

    public boolean applySystemWindowInsets19(Rect rect) {
        return this.mQMUIWindowInsetHelper.defaultApplySystemWindowInsets19((ViewGroup)this, rect);
    }

    public boolean applySystemWindowInsets21(Object object) {
        return this.mQMUIWindowInsetHelper.defaultApplySystemWindowInsets21((ViewGroup)this, object);
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT < 19) return super.fitSystemWindows(rect);
        if (Build.VERSION.SDK_INT >= 21) return super.fitSystemWindows(rect);
        return this.applySystemWindowInsets19(rect);
    }

    public int getInfiniteRatio() {
        return this.mInfiniteRatio;
    }

    public boolean isEnableLoop() {
        return this.mEnableLoop;
    }

    public boolean isInMeasure() {
        return this.mIsInMeasure;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.mIsSwipeable && super.onInterceptTouchEvent(motionEvent);
        return bl;
    }

    protected void onMeasure(int n, int n2) {
        this.mIsInMeasure = true;
        super.onMeasure(n, n2);
        this.mIsInMeasure = false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.mIsSwipeable && super.onTouchEvent(motionEvent);
        return bl;
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (pagerAdapter instanceof QMUIPagerAdapter) {
            super.setAdapter((PagerAdapter)new WrapperPagerAdapter(this, (QMUIPagerAdapter)pagerAdapter));
        } else {
            super.setAdapter(pagerAdapter);
        }
    }

    public void setEnableLoop(boolean bl) {
        if (this.mEnableLoop == bl) return;
        this.mEnableLoop = bl;
        if (this.getAdapter() == null) return;
        this.getAdapter().notifyDataSetChanged();
    }

    public void setInfiniteRatio(int n) {
        this.mInfiniteRatio = n;
    }

    public void setSwipeable(boolean bl) {
        this.mIsSwipeable = bl;
    }
}
