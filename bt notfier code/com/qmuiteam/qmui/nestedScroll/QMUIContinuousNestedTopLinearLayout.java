/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.qmuiteam.qmui.layout.QMUILinearLayout
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView;

public class QMUIContinuousNestedTopLinearLayout
extends QMUILinearLayout
implements IQMUIContinuousNestedTopView {
    public QMUIContinuousNestedTopLinearLayout(Context context) {
        super(context);
    }

    public QMUIContinuousNestedTopLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIContinuousNestedTopLinearLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    public int consumeScroll(int n) {
        return n;
    }

    public int getCurrentScroll() {
        return 0;
    }

    public int getScrollOffsetRange() {
        return 0;
    }

    public void injectScrollNotifier(IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
    }

    public void restoreScrollInfo(Bundle bundle) {
    }

    public void saveScrollInfo(Bundle bundle) {
    }
}
