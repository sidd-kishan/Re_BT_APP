/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 *  androidx.appcompat.widget.ListPopupWindow
 */
package androidx.appcompat.widget;

import android.widget.AbsListView;
import androidx.appcompat.widget.ListPopupWindow;

private class ListPopupWindow.PopupScrollListener
implements AbsListView.OnScrollListener {
    final ListPopupWindow this$0;

    ListPopupWindow.PopupScrollListener(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public void onScroll(AbsListView absListView, int n, int n2, int n3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int n) {
        if (n != 1) return;
        if (this.this$0.isInputMethodNotNeeded()) return;
        if (this.this$0.mPopup.getContentView() == null) return;
        this.this$0.mHandler.removeCallbacks((Runnable)this.this$0.mResizePopupRunnable);
        this.this$0.mResizePopupRunnable.run();
    }
}
