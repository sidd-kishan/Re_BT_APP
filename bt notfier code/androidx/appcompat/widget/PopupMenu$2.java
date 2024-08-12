/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.appcompat.widget.PopupMenu
 */
package androidx.appcompat.widget;

import android.widget.PopupWindow;
import androidx.appcompat.widget.PopupMenu;

class PopupMenu.2
implements PopupWindow.OnDismissListener {
    final PopupMenu this$0;

    PopupMenu.2(PopupMenu popupMenu) {
        this.this$0 = popupMenu;
    }

    public void onDismiss() {
        if (this.this$0.mOnDismissListener == null) return;
        this.this$0.mOnDismissListener.onDismiss(this.this$0);
    }
}
