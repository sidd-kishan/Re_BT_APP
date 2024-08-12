/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.view.menu.ActionMenuItemView
 *  androidx.appcompat.view.menu.MenuBuilder$ItemInvoker
 *  androidx.appcompat.view.menu.ShowableListMenu
 *  androidx.appcompat.widget.ForwardingListener
 */
package androidx.appcompat.view.menu;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ForwardingListener;

private class ActionMenuItemView.ActionMenuItemForwardingListener
extends ForwardingListener {
    final ActionMenuItemView this$0;

    public ActionMenuItemView.ActionMenuItemForwardingListener(ActionMenuItemView actionMenuItemView) {
        this.this$0 = actionMenuItemView;
        super((View)actionMenuItemView);
    }

    public ShowableListMenu getPopup() {
        if (this.this$0.mPopupCallback == null) return null;
        return this.this$0.mPopupCallback.getPopup();
    }

    protected boolean onForwardingStarted() {
        boolean bl;
        MenuBuilder.ItemInvoker itemInvoker = this.this$0.mItemInvoker;
        boolean bl2 = bl = false;
        if (itemInvoker == null) return bl2;
        bl2 = bl;
        if (!this.this$0.mItemInvoker.invokeItem(this.this$0.mItemData)) return bl2;
        itemInvoker = this.getPopup();
        bl2 = bl;
        if (itemInvoker == null) return bl2;
        bl2 = bl;
        if (!itemInvoker.isShowing()) return bl2;
        bl2 = true;
        return bl2;
    }
}
