/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.core.view.ActionProvider$VisibilityListener
 */
package androidx.appcompat.view.menu;

import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.view.ActionProvider;

class MenuItemImpl.1
implements ActionProvider.VisibilityListener {
    final MenuItemImpl this$0;

    MenuItemImpl.1(MenuItemImpl menuItemImpl) {
        this.this$0 = menuItemImpl;
    }

    public void onActionProviderVisibilityChanged(boolean bl) {
        this.this$0.mMenu.onItemVisibleChanged(this.this$0);
    }
}
