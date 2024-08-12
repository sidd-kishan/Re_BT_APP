/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.view.menu.ActionMenuItemView$PopupCallback
 *  androidx.appcompat.view.menu.MenuPopup
 *  androidx.appcompat.view.menu.ShowableListMenu
 *  androidx.appcompat.widget.ActionMenuPresenter
 */
package androidx.appcompat.widget;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActionMenuPresenter;

private class ActionMenuPresenter.ActionMenuPopupCallback
extends ActionMenuItemView.PopupCallback {
    final ActionMenuPresenter this$0;

    ActionMenuPresenter.ActionMenuPopupCallback(ActionMenuPresenter actionMenuPresenter) {
        this.this$0 = actionMenuPresenter;
    }

    public ShowableListMenu getPopup() {
        MenuPopup menuPopup = this.this$0.mActionButtonPopup != null ? this.this$0.mActionButtonPopup.getPopup() : null;
        return menuPopup;
    }
}
