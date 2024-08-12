/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 */
package com.qmuiteam.qmui.nestedScroll;

import android.os.Bundle;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;

public interface IQMUIContinuousNestedScrollCommon {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;

    public void injectScrollNotifier(OnScrollNotifier var1);

    public void restoreScrollInfo(Bundle var1);

    public void saveScrollInfo(Bundle var1);
}
