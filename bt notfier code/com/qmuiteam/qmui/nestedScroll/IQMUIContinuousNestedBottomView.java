/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
 */
package com.qmuiteam.qmui.nestedScroll;

import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;

public interface IQMUIContinuousNestedBottomView
extends IQMUIContinuousNestedScrollCommon {
    public static final int HEIGHT_IS_ENOUGH_TO_SCROLL = -1;

    public void consumeScroll(int var1);

    public int getContentHeight();

    public int getCurrentScroll();

    public int getScrollOffsetRange();

    public void smoothScrollYBy(int var1, int var2);

    public void stopScroll();
}
