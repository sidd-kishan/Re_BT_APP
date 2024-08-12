/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuItemImpl
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

public class SubMenuBuilder
extends MenuBuilder
implements SubMenu {
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.mParentMenu = menuBuilder;
        this.mItem = menuItemImpl;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.mParentMenu.collapseItemActionView(menuItemImpl);
    }

    boolean dispatchMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        boolean bl = super.dispatchMenuItemSelected(menuBuilder, menuItem) || this.mParentMenu.dispatchMenuItemSelected(menuBuilder, menuItem);
        return bl;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.mParentMenu.expandItemActionView(menuItemImpl);
    }

    public String getActionViewStatesKey() {
        Object object = this.mItem;
        int n = object != null ? object.getItemId() : 0;
        if (n == 0) {
            return null;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(super.getActionViewStatesKey());
        ((StringBuilder)object).append(":");
        ((StringBuilder)object).append(n);
        return ((StringBuilder)object).toString();
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public MenuBuilder getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public void setCallback(MenuBuilder.Callback callback) {
        this.mParentMenu.setCallback(callback);
    }

    public void setGroupDividerEnabled(boolean bl) {
        this.mParentMenu.setGroupDividerEnabled(bl);
    }

    public SubMenu setHeaderIcon(int n) {
        return (SubMenu)super.setHeaderIconInt(n);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu)super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderTitle(int n) {
        return (SubMenu)super.setHeaderTitleInt(n);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu)super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu)super.setHeaderViewInt(view);
    }

    public SubMenu setIcon(int n) {
        this.mItem.setIcon(n);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean bl) {
        this.mParentMenu.setQwertyMode(bl);
    }

    public void setShortcutsVisible(boolean bl) {
        this.mParentMenu.setShortcutsVisible(bl);
    }
}
