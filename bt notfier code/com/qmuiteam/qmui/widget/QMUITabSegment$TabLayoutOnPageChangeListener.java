/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 */
package com.qmuiteam.qmui.widget;

import androidx.viewpager.widget.ViewPager;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import java.lang.ref.WeakReference;

/*
 * Exception performing whole class analysis ignored.
 */
public static class QMUITabSegment.TabLayoutOnPageChangeListener
implements ViewPager.OnPageChangeListener {
    private final WeakReference<QMUITabSegment> mTabSegmentRef;

    public QMUITabSegment.TabLayoutOnPageChangeListener(QMUITabSegment qMUITabSegment) {
        this.mTabSegmentRef = new WeakReference<QMUITabSegment>(qMUITabSegment);
    }

    public void onPageScrollStateChanged(int n) {
        QMUITabSegment qMUITabSegment = (QMUITabSegment)this.mTabSegmentRef.get();
        if (qMUITabSegment == null) return;
        QMUITabSegment.access$1700((QMUITabSegment)qMUITabSegment, (int)n);
    }

    public void onPageScrolled(int n, float f, int n2) {
        QMUITabSegment qMUITabSegment = (QMUITabSegment)this.mTabSegmentRef.get();
        if (qMUITabSegment == null) return;
        qMUITabSegment.updateIndicatorPosition(n, f);
    }

    public void onPageSelected(int n) {
        QMUITabSegment qMUITabSegment = (QMUITabSegment)this.mTabSegmentRef.get();
        if (qMUITabSegment != null && QMUITabSegment.access$1300((QMUITabSegment)qMUITabSegment) != -1) {
            QMUITabSegment.access$1302((QMUITabSegment)qMUITabSegment, (int)n);
            return;
        }
        if (qMUITabSegment == null) return;
        if (qMUITabSegment.getSelectedIndex() == n) return;
        if (n >= QMUITabSegment.access$1800((QMUITabSegment)qMUITabSegment)) return;
        qMUITabSegment.selectTab(n, true, false);
    }
}
