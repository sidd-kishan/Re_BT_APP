/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.view.menu.ShowableListMenu
 *  androidx.appcompat.widget.ActionMenuPresenter
 *  androidx.appcompat.widget.ActionMenuPresenter$OverflowMenuButton
 *  androidx.appcompat.widget.ForwardingListener
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ForwardingListener;

class ActionMenuPresenter.OverflowMenuButton.1
extends ForwardingListener {
    final ActionMenuPresenter.OverflowMenuButton this$1;
    final ActionMenuPresenter val$this$0;

    ActionMenuPresenter.OverflowMenuButton.1(ActionMenuPresenter.OverflowMenuButton overflowMenuButton, View view, ActionMenuPresenter actionMenuPresenter) {
        this.this$1 = overflowMenuButton;
        this.val$this$0 = actionMenuPresenter;
        super(view);
    }

    public ShowableListMenu getPopup() {
        if (this.this$1.this$0.mOverflowPopup != null) return this.this$1.this$0.mOverflowPopup.getPopup();
        return null;
    }

    public boolean onForwardingStarted() {
        this.this$1.this$0.showOverflowMenu();
        return true;
    }

    public boolean onForwardingStopped() {
        if (this.this$1.this$0.mPostedOpenRunnable != null) {
            return false;
        }
        this.this$1.this$0.hideOverflowMenu();
        return true;
    }
}
