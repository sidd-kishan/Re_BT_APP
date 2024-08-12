/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  androidx.appcompat.view.menu.MenuItemWrapperICS
 *  androidx.appcompat.view.menu.SubMenuWrapperICS
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.internal.view.SupportMenuItem
 *  androidx.core.internal.view.SupportSubMenu
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.SubMenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

abstract class BaseMenuWrapper {
    final Context mContext;
    private SimpleArrayMap<SupportMenuItem, MenuItem> mMenuItems;
    private SimpleArrayMap<SupportSubMenu, SubMenu> mSubMenus;

    BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        if (!(menuItem instanceof SupportMenuItem)) return menuItem2;
        SupportMenuItem supportMenuItem = (SupportMenuItem)menuItem;
        if (this.mMenuItems == null) {
            this.mMenuItems = new SimpleArrayMap();
        }
        menuItem2 = menuItem = (MenuItem)this.mMenuItems.get((Object)menuItem);
        if (menuItem != null) return menuItem2;
        menuItem2 = new MenuItemWrapperICS(this.mContext, supportMenuItem);
        this.mMenuItems.put((Object)supportMenuItem, (Object)menuItem2);
        return menuItem2;
    }

    final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        SubMenu subMenu2;
        if (!(subMenu instanceof SupportSubMenu)) return subMenu;
        SupportSubMenu supportSubMenu = (SupportSubMenu)subMenu;
        if (this.mSubMenus == null) {
            this.mSubMenus = new SimpleArrayMap();
        }
        subMenu = subMenu2 = (SubMenu)this.mSubMenus.get((Object)supportSubMenu);
        if (subMenu2 != null) return subMenu;
        subMenu = new SubMenuWrapperICS(this.mContext, supportSubMenu);
        this.mSubMenus.put((Object)supportSubMenu, (Object)subMenu);
        return subMenu;
    }

    final void internalClear() {
        SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.mMenuItems;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        if ((simpleArrayMap = this.mSubMenus) == null) return;
        simpleArrayMap.clear();
    }

    final void internalRemoveGroup(int n) {
        if (this.mMenuItems == null) {
            return;
        }
        int n2 = 0;
        while (n2 < this.mMenuItems.size()) {
            int n3 = n2;
            if (((SupportMenuItem)this.mMenuItems.keyAt(n2)).getGroupId() == n) {
                this.mMenuItems.removeAt(n2);
                n3 = n2 - 1;
            }
            n2 = n3 + 1;
        }
    }

    final void internalRemoveItem(int n) {
        if (this.mMenuItems == null) {
            return;
        }
        int n2 = 0;
        while (n2 < this.mMenuItems.size()) {
            if (((SupportMenuItem)this.mMenuItems.keyAt(n2)).getItemId() == n) {
                this.mMenuItems.removeAt(n2);
                return;
            }
            ++n2;
        }
    }
}
