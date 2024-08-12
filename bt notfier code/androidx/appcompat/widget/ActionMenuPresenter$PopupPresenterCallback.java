/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  androidx.appcompat.widget.ActionMenuPresenter
 */
package androidx.appcompat.widget;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;

/*
 * Exception performing whole class analysis ignored.
 */
private class ActionMenuPresenter.PopupPresenterCallback
implements MenuPresenter.Callback {
    final ActionMenuPresenter this$0;

    ActionMenuPresenter.PopupPresenterCallback(ActionMenuPresenter actionMenuPresenter) {
        this.this$0 = actionMenuPresenter;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        MenuPresenter.Callback callback;
        if (menuBuilder instanceof SubMenuBuilder) {
            menuBuilder.getRootMenu().close(false);
        }
        if ((callback = this.this$0.getCallback()) == null) return;
        callback.onCloseMenu(menuBuilder, bl);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        MenuBuilder menuBuilder2 = ActionMenuPresenter.access$300((ActionMenuPresenter)this.this$0);
        boolean bl = false;
        if (menuBuilder == menuBuilder2) {
            return false;
        }
        this.this$0.mOpenSubMenuId = ((SubMenuBuilder)menuBuilder).getItem().getItemId();
        menuBuilder2 = this.this$0.getCallback();
        if (menuBuilder2 == null) return bl;
        bl = menuBuilder2.onOpenSubMenu(menuBuilder);
        return bl;
    }
}
