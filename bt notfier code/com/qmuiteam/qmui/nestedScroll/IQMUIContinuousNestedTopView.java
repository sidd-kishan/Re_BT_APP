/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
 */
package com.qmuiteam.qmui.nestedScroll;

import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;

public interface IQMUIContinuousNestedTopView
extends IQMUIContinuousNestedScrollCommon {
    public int consumeScroll(int var1);

    public int getCurrentScroll();

    public int getScrollOffsetRange();
}
