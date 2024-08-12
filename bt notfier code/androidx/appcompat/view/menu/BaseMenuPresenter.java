/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.MenuView
 *  androidx.appcompat.view.menu.MenuView$ItemView
 *  androidx.appcompat.view.menu.SubMenuBuilder
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import java.util.ArrayList;

public abstract class BaseMenuPresenter
implements MenuPresenter {
    private MenuPresenter.Callback mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected MenuBuilder mMenu;
    private int mMenuLayoutRes;
    protected MenuView mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public BaseMenuPresenter(Context context, int n, int n2) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from((Context)context);
        this.mMenuLayoutRes = n;
        this.mItemLayoutRes = n2;
    }

    protected void addItemView(View view, int n) {
        ViewGroup viewGroup = (ViewGroup)view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup)this.mMenuView).addView(view, n);
    }

    public abstract void bindItemView(MenuItemImpl var1, MenuView.ItemView var2);

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public MenuView.ItemView createItemView(ViewGroup viewGroup) {
        return (MenuView.ItemView)this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    protected boolean filterLeftoverView(ViewGroup viewGroup, int n) {
        viewGroup.removeViewAt(n);
        return true;
    }

    public boolean flagActionItems() {
        return false;
    }

    public MenuPresenter.Callback getCallback() {
        return this.mCallback;
    }

    public int getId() {
        return this.mId;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        view = view instanceof MenuView.ItemView ? (MenuView.ItemView)view : this.createItemView(viewGroup);
        this.bindItemView(menuItemImpl, (MenuView.ItemView)view);
        return view;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.mMenuView != null) return this.mMenuView;
        viewGroup = (MenuView)this.mSystemInflater.inflate(this.mMenuLayoutRes, viewGroup, false);
        this.mMenuView = viewGroup;
        viewGroup.initialize(this.mMenu);
        this.updateMenuView(true);
        return this.mMenuView;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from((Context)context);
        this.mMenu = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        MenuPresenter.Callback callback = this.mCallback;
        if (callback == null) return;
        callback.onCloseMenu(menuBuilder, bl);
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        MenuPresenter.Callback callback = this.mCallback;
        if (callback == null) return false;
        if (subMenuBuilder != null) return callback.onOpenSubMenu((MenuBuilder)subMenuBuilder);
        subMenuBuilder = this.mMenu;
        return callback.onOpenSubMenu((MenuBuilder)subMenuBuilder);
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }

    public void setId(int n) {
        this.mId = n;
    }

    public boolean shouldIncludeItem(int n, MenuItemImpl menuItemImpl) {
        return true;
    }

    public void updateMenuView(boolean bl) {
        ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        if (viewGroup == null) {
            return;
        }
        Object object = this.mMenu;
        int n = 0;
        if (object != null) {
            object.flagActionItems();
            ArrayList arrayList = this.mMenu.getVisibleItems();
            int n2 = arrayList.size();
            n = 0;
            for (int i = 0; i < n2; ++i) {
                MenuItemImpl menuItemImpl = (MenuItemImpl)arrayList.get(i);
                int n3 = n;
                if (this.shouldIncludeItem(n, menuItemImpl)) {
                    View view = viewGroup.getChildAt(n);
                    object = view instanceof MenuView.ItemView ? ((MenuView.ItemView)view).getItemData() : null;
                    View view2 = this.getItemView(menuItemImpl, view, viewGroup);
                    if (menuItemImpl != object) {
                        view2.setPressed(false);
                        view2.jumpDrawablesToCurrentState();
                    }
                    if (view2 != view) {
                        this.addItemView(view2, n);
                    }
                    n3 = n + 1;
                }
                n = n3;
            }
        }
        while (n < viewGroup.getChildCount()) {
            if (this.filterLeftoverView(viewGroup, n)) continue;
            ++n;
        }
    }
}
