/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPopupHelper
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  androidx.appcompat.widget.ActionMenuPresenter
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;

/*
 * Exception performing whole class analysis ignored.
 */
private class ActionMenuPresenter.ActionButtonSubmenu
extends MenuPopupHelper {
    final ActionMenuPresenter this$0;

    public ActionMenuPresenter.ActionButtonSubmenu(ActionMenuPresenter actionMenuPresenter, Context object, SubMenuBuilder subMenuBuilder, View view) {
        this.this$0 = actionMenuPresenter;
        super(object, (MenuBuilder)subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
        if (!((MenuItemImpl)subMenuBuilder.getItem()).isActionButton()) {
            object = actionMenuPresenter.mOverflowButton == null ? (View)ActionMenuPresenter.access$200((ActionMenuPresenter)actionMenuPresenter) : actionMenuPresenter.mOverflowButton;
            this.setAnchorView((View)object);
        }
        this.setPresenterCallback((MenuPresenter.Callback)actionMenuPresenter.mPopupPresenterCallback);
    }

    protected void onDismiss() {
        this.this$0.mActionButtonPopup = null;
        this.this$0.mOpenSubMenuId = 0;
        super.onDismiss();
    }
}
