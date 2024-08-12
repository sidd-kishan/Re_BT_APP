/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 */
package com.qmuiteam.qmui.widget;

import android.database.DataSetObserver;
import com.qmuiteam.qmui.widget.QMUITabSegment;

private class QMUITabSegment.PagerAdapterObserver
extends DataSetObserver {
    private final boolean mUseAdapterTitle;
    final QMUITabSegment this$0;

    QMUITabSegment.PagerAdapterObserver(QMUITabSegment qMUITabSegment, boolean bl) {
        this.this$0 = qMUITabSegment;
        this.mUseAdapterTitle = bl;
    }

    public void onChanged() {
        this.this$0.populateFromPagerAdapter(this.mUseAdapterTitle);
    }

    public void onInvalidated() {
        this.this$0.populateFromPagerAdapter(this.mUseAdapterTitle);
    }
}
