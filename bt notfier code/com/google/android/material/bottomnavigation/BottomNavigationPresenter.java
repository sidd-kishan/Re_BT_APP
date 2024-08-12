/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcelable
 *  android.view.ViewGroup
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.MenuView
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  com.google.android.material.bottomnavigation.BottomNavigationMenuView
 *  com.google.android.material.bottomnavigation.BottomNavigationPresenter$SavedState
 */
package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;

public class BottomNavigationPresenter
implements MenuPresenter {
    private int id;
    private MenuBuilder menu;
    private BottomNavigationMenuView menuView;
    private boolean updateSuspended = false;

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.id;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        return this.menuView;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
        this.menuView.initialize(menuBuilder);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) return;
        this.menuView.tryRestoreSelectedItemId(((SavedState)parcelable).selectedItemId);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setBottomNavigationMenuView(BottomNavigationMenuView bottomNavigationMenuView) {
        this.menuView = bottomNavigationMenuView;
    }

    public void setCallback(MenuPresenter.Callback callback) {
    }

    public void setId(int n) {
        this.id = n;
    }

    public void setUpdateSuspended(boolean bl) {
        this.updateSuspended = bl;
    }

    public void updateMenuView(boolean bl) {
        if (this.updateSuspended) {
            return;
        }
        if (bl) {
            this.menuView.buildMenuView();
        } else {
            this.menuView.updateMenuView();
        }
    }
}
