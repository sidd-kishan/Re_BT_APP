/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionProvider
 *  android.view.SubMenu
 *  android.view.View
 *  androidx.appcompat.view.menu.MenuItemWrapperICS
 *  androidx.core.view.ActionProvider
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.core.view.ActionProvider;

private class MenuItemWrapperICS.ActionProviderWrapper
extends ActionProvider {
    final android.view.ActionProvider mInner;
    final MenuItemWrapperICS this$0;

    MenuItemWrapperICS.ActionProviderWrapper(MenuItemWrapperICS menuItemWrapperICS, Context context, android.view.ActionProvider actionProvider) {
        this.this$0 = menuItemWrapperICS;
        super(context);
        this.mInner = actionProvider;
    }

    public boolean hasSubMenu() {
        return this.mInner.hasSubMenu();
    }

    public View onCreateActionView() {
        return this.mInner.onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return this.mInner.onPerformDefaultAction();
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(subMenu));
    }
}
