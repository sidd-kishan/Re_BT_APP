/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  com.google.android.material.internal.NavigationMenu
 */
package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.internal.NavigationMenu;

public class NavigationSubMenu
extends SubMenuBuilder {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, MenuItemImpl menuItemImpl) {
        super(context, (MenuBuilder)navigationMenu, menuItemImpl);
    }

    public void onItemsChanged(boolean bl) {
        super.onItemsChanged(bl);
        ((MenuBuilder)this.getParentMenu()).onItemsChanged(bl);
    }
}
