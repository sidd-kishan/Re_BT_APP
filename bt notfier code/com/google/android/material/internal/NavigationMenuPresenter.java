/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.MenuView
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  com.google.android.material.R$dimen
 *  com.google.android.material.R$layout
 *  com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuAdapter
 *  com.google.android.material.internal.NavigationMenuView
 */
package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuView;

public class NavigationMenuPresenter
implements MenuPresenter {
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HEADER = "android:menu:header";
    private static final String STATE_HIERARCHY = "android:menu:list";
    NavigationMenuAdapter adapter;
    private MenuPresenter.Callback callback;
    LinearLayout headerLayout;
    ColorStateList iconTintList;
    private int id;
    Drawable itemBackground;
    int itemHorizontalPadding;
    int itemIconPadding;
    LayoutInflater layoutInflater;
    MenuBuilder menu;
    private NavigationMenuView menuView;
    final View.OnClickListener onClickListener = new /* Unavailable Anonymous Inner Class!! */;
    int paddingSeparator;
    private int paddingTopDefault;
    int textAppearance;
    boolean textAppearanceSet;
    ColorStateList textColor;

    public void addHeaderView(View view) {
        this.headerLayout.addView(view);
        view = this.menuView;
        view.setPadding(0, 0, 0, view.getPaddingBottom());
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dispatchApplyWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        int n = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.paddingTopDefault != n) {
            this.paddingTopDefault = n;
            if (this.headerLayout.getChildCount() == 0) {
                NavigationMenuView navigationMenuView = this.menuView;
                navigationMenuView.setPadding(0, this.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
            }
        }
        ViewCompat.dispatchApplyWindowInsets((View)this.headerLayout, (WindowInsetsCompat)windowInsetsCompat);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public MenuItemImpl getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int n) {
        return this.headerLayout.getChildAt(n);
    }

    public int getId() {
        return this.id;
    }

    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.menuView != null) return this.menuView;
        this.menuView = (NavigationMenuView)this.layoutInflater.inflate(R.layout.design_navigation_menu, viewGroup, false);
        if (this.adapter == null) {
            this.adapter = new NavigationMenuAdapter(this);
        }
        this.headerLayout = (LinearLayout)this.layoutInflater.inflate(R.layout.design_navigation_item_header, (ViewGroup)this.menuView, false);
        this.menuView.setAdapter((RecyclerView.Adapter)this.adapter);
        return this.menuView;
    }

    public View inflateHeaderView(int n) {
        View view = this.layoutInflater.inflate(n, (ViewGroup)this.headerLayout, false);
        this.addHeaderView(view);
        return view;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.layoutInflater = LayoutInflater.from((Context)context);
        this.menu = menuBuilder;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        MenuPresenter.Callback callback = this.callback;
        if (callback == null) return;
        callback.onCloseMenu(menuBuilder, bl);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) return;
        SparseArray sparseArray = (parcelable = (Bundle)parcelable).getSparseParcelableArray(STATE_HIERARCHY);
        if (sparseArray != null) {
            this.menuView.restoreHierarchyState(sparseArray);
        }
        if ((sparseArray = parcelable.getBundle(STATE_ADAPTER)) != null) {
            this.adapter.restoreInstanceState((Bundle)sparseArray);
        }
        if ((parcelable = parcelable.getSparseParcelableArray(STATE_HEADER)) == null) return;
        this.headerLayout.restoreHierarchyState((SparseArray)parcelable);
    }

    public Parcelable onSaveInstanceState() {
        NavigationMenuAdapter navigationMenuAdapter;
        Bundle bundle = new Bundle();
        if (this.menuView != null) {
            navigationMenuAdapter = new SparseArray();
            this.menuView.saveHierarchyState((SparseArray)navigationMenuAdapter);
            bundle.putSparseParcelableArray(STATE_HIERARCHY, (SparseArray)navigationMenuAdapter);
        }
        if ((navigationMenuAdapter = this.adapter) != null) {
            bundle.putBundle(STATE_ADAPTER, navigationMenuAdapter.createInstanceState());
        }
        if (this.headerLayout == null) return bundle;
        navigationMenuAdapter = new SparseArray();
        this.headerLayout.saveHierarchyState((SparseArray)navigationMenuAdapter);
        bundle.putSparseParcelableArray(STATE_HEADER, (SparseArray)navigationMenuAdapter);
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void removeHeaderView(View view) {
        this.headerLayout.removeView(view);
        if (this.headerLayout.getChildCount() != 0) return;
        view = this.menuView;
        view.setPadding(0, this.paddingTopDefault, 0, view.getPaddingBottom());
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.callback = callback;
    }

    public void setCheckedItem(MenuItemImpl menuItemImpl) {
        this.adapter.setCheckedItem(menuItemImpl);
    }

    public void setId(int n) {
        this.id = n;
    }

    public void setItemBackground(Drawable drawable) {
        this.itemBackground = drawable;
        this.updateMenuView(false);
    }

    public void setItemHorizontalPadding(int n) {
        this.itemHorizontalPadding = n;
        this.updateMenuView(false);
    }

    public void setItemIconPadding(int n) {
        this.itemIconPadding = n;
        this.updateMenuView(false);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        this.updateMenuView(false);
    }

    public void setItemTextAppearance(int n) {
        this.textAppearance = n;
        this.textAppearanceSet = true;
        this.updateMenuView(false);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.textColor = colorStateList;
        this.updateMenuView(false);
    }

    public void setUpdateSuspended(boolean bl) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter == null) return;
        navigationMenuAdapter.setUpdateSuspended(bl);
    }

    public void updateMenuView(boolean bl) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter == null) return;
        navigationMenuAdapter.update();
    }
}
