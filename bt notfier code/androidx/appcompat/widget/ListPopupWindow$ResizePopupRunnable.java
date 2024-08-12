/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.widget.ListPopupWindow
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.ViewCompat;

private class ListPopupWindow.ResizePopupRunnable
implements Runnable {
    final ListPopupWindow this$0;

    ListPopupWindow.ResizePopupRunnable(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override
    public void run() {
        if (this.this$0.mDropDownList == null) return;
        if (!ViewCompat.isAttachedToWindow((View)this.this$0.mDropDownList)) return;
        if (this.this$0.mDropDownList.getCount() <= this.this$0.mDropDownList.getChildCount()) return;
        if (this.this$0.mDropDownList.getChildCount() > this.this$0.mListItemExpandMaximum) return;
        this.this$0.mPopup.setInputMethodMode(2);
        this.this$0.show();
    }
}
