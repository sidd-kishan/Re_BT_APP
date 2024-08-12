/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.SubMenu
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  com.google.android.material.internal.NavigationSubMenu
 */
package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.internal.NavigationSubMenu;

public class NavigationMenu
extends MenuBuilder {
    public NavigationMenu(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int n, int n2, int n3, CharSequence charSequence) {
        charSequence = (MenuItemImpl)this.addInternal(n, n2, n3, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(this.getContext(), this, (MenuItemImpl)charSequence);
        charSequence.setSubMenu((SubMenuBuilder)navigationSubMenu);
        return navigationSubMenu;
    }
}
