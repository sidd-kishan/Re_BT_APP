/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.ListPopupWindow
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.ListPopupWindow;

private class ListPopupWindow.ListSelectorHider
implements Runnable {
    final ListPopupWindow this$0;

    ListPopupWindow.ListSelectorHider(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override
    public void run() {
        this.this$0.clearListSelection();
    }
}
