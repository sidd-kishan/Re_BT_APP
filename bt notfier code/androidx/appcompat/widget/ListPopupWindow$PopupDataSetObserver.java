/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  androidx.appcompat.widget.ListPopupWindow
 */
package androidx.appcompat.widget;

import android.database.DataSetObserver;
import androidx.appcompat.widget.ListPopupWindow;

private class ListPopupWindow.PopupDataSetObserver
extends DataSetObserver {
    final ListPopupWindow this$0;

    ListPopupWindow.PopupDataSetObserver(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public void onChanged() {
        if (!this.this$0.isShowing()) return;
        this.this$0.show();
    }

    public void onInvalidated() {
        this.this$0.dismiss();
    }
}
