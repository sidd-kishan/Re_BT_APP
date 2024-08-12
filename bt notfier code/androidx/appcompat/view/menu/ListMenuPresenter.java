/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.SparseArray
 *  android.view.ContextThemeWrapper
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListAdapter
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.view.menu.ExpandedMenuView
 *  androidx.appcompat.view.menu.ListMenuPresenter$MenuAdapter
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuDialogHelper
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.MenuView
 *  androidx.appcompat.view.menu.SubMenuBuilder
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuDialogHelper;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;

public class ListMenuPresenter
implements MenuPresenter,
AdapterView.OnItemClickListener {
    private static final String TAG = "ListMenuPresenter";
    public static final String VIEWS_TAG = "android:menu:list";
    MenuAdapter mAdapter;
    private MenuPresenter.Callback mCallback;
    Context mContext;
    private int mId;
    LayoutInflater mInflater;
    int mItemIndexOffset;
    int mItemLayoutRes;
    MenuBuilder mMenu;
    ExpandedMenuView mMenuView;
    int mThemeRes;

    public ListMenuPresenter(int n, int n2) {
        this.mItemLayoutRes = n;
        this.mThemeRes = n2;
    }

    public ListMenuPresenter(Context context, int n) {
        this(n, 0);
        this.mContext = context;
        this.mInflater = LayoutInflater.from((Context)context);
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.mAdapter != null) return this.mAdapter;
        this.mAdapter = new MenuAdapter(this);
        return this.mAdapter;
    }

    public int getId() {
        return this.mId;
    }

    int getItemIndexOffset() {
        return this.mItemIndexOffset;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.mMenuView != null) return this.mMenuView;
        this.mMenuView = (ExpandedMenuView)this.mInflater.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
        if (this.mAdapter == null) {
            this.mAdapter = new MenuAdapter(this);
        }
        this.mMenuView.setAdapter((ListAdapter)this.mAdapter);
        this.mMenuView.setOnItemClickListener((AdapterView.OnItemClickListener)this);
        return this.mMenuView;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.mThemeRes != 0) {
            this.mContext = context = new ContextThemeWrapper(context, this.mThemeRes);
            this.mInflater = LayoutInflater.from((Context)context);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from((Context)context);
            }
        }
        this.mMenu = menuBuilder;
        context = this.mAdapter;
        if (context == null) return;
        context.notifyDataSetChanged();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        MenuPresenter.Callback callback = this.mCallback;
        if (callback == null) return;
        callback.onCloseMenu(menuBuilder, bl);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
        this.mMenu.performItemAction((MenuItem)this.mAdapter.getItem(n), (MenuPresenter)this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        this.restoreHierarchyState((Bundle)parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.mMenuView == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        this.saveHierarchyState(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper((MenuBuilder)subMenuBuilder).show(null);
        MenuPresenter.Callback callback = this.mCallback;
        if (callback == null) return true;
        callback.onOpenSubMenu((MenuBuilder)subMenuBuilder);
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        if ((bundle = bundle.getSparseParcelableArray(VIEWS_TAG)) == null) return;
        this.mMenuView.restoreHierarchyState((SparseArray)bundle);
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.mMenuView;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }

    public void setId(int n) {
        this.mId = n;
    }

    public void setItemIndexOffset(int n) {
        this.mItemIndexOffset = n;
        if (this.mMenuView == null) return;
        this.updateMenuView(false);
    }

    public void updateMenuView(boolean bl) {
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter == null) return;
        menuAdapter.notifyDataSetChanged();
    }
}
