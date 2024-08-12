/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.widget.ForwardingListener
 *  androidx.appcompat.widget.ListPopupWindow
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.ListPopupWindow;

class ListPopupWindow.1
extends ForwardingListener {
    final ListPopupWindow this$0;

    ListPopupWindow.1(ListPopupWindow listPopupWindow, View view) {
        this.this$0 = listPopupWindow;
        super(view);
    }

    public ListPopupWindow getPopup() {
        return this.this$0;
    }
}
