/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.widget.ListPopupWindow
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ListPopupWindow;

class ListPopupWindow.2
implements Runnable {
    final ListPopupWindow this$0;

    ListPopupWindow.2(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override
    public void run() {
        View view = this.this$0.getAnchorView();
        if (view == null) return;
        if (view.getWindowToken() == null) return;
        this.this$0.show();
    }
}
