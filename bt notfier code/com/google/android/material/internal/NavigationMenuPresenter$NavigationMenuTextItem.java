/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuItem
 */
package com.google.android.material.internal;

import androidx.appcompat.view.menu.MenuItemImpl;
import com.google.android.material.internal.NavigationMenuPresenter;

private static class NavigationMenuPresenter.NavigationMenuTextItem
implements NavigationMenuPresenter.NavigationMenuItem {
    private final MenuItemImpl menuItem;
    boolean needsEmptyIcon;

    NavigationMenuPresenter.NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
        this.menuItem = menuItemImpl;
    }

    public MenuItemImpl getMenuItem() {
        return this.menuItem;
    }
}
