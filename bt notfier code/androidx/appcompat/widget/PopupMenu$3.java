/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.view.menu.ShowableListMenu
 *  androidx.appcompat.widget.ForwardingListener
 *  androidx.appcompat.widget.PopupMenu
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.PopupMenu;

class PopupMenu.3
extends ForwardingListener {
    final PopupMenu this$0;

    PopupMenu.3(PopupMenu popupMenu, View view) {
        this.this$0 = popupMenu;
        super(view);
    }

    public ShowableListMenu getPopup() {
        return this.this$0.mPopup.getPopup();
    }

    protected boolean onForwardingStarted() {
        this.this$0.show();
        return true;
    }

    protected boolean onForwardingStopped() {
        this.this$0.dismiss();
        return true;
    }
}
