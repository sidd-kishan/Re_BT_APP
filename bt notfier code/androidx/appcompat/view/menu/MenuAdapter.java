/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  androidx.appcompat.view.menu.ListMenuItemView
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuView$ItemView
 */
package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

public class MenuAdapter
extends BaseAdapter {
    MenuBuilder mAdapterMenu;
    private int mExpandedIndex = -1;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean bl, int n) {
        this.mOverflowOnly = bl;
        this.mInflater = layoutInflater;
        this.mAdapterMenu = menuBuilder;
        this.mItemLayoutRes = n;
        this.findExpandedIndex();
    }

    void findExpandedIndex() {
        MenuItemImpl menuItemImpl = this.mAdapterMenu.getExpandedItem();
        if (menuItemImpl != null) {
            ArrayList arrayList = this.mAdapterMenu.getNonActionItems();
            int n = arrayList.size();
            for (int i = 0; i < n; ++i) {
                if ((MenuItemImpl)arrayList.get(i) != menuItemImpl) continue;
                this.mExpandedIndex = i;
                return;
            }
        }
        this.mExpandedIndex = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.mAdapterMenu;
    }

    public int getCount() {
        ArrayList arrayList = this.mOverflowOnly ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
        if (this.mExpandedIndex >= 0) return arrayList.size() - 1;
        return arrayList.size();
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    public MenuItemImpl getItem(int n) {
        ArrayList arrayList = this.mOverflowOnly ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
        int n2 = this.mExpandedIndex;
        int n3 = n;
        if (n2 < 0) return (MenuItemImpl)arrayList.get(n3);
        n3 = n;
        if (n < n2) return (MenuItemImpl)arrayList.get(n3);
        n3 = n + 1;
        return (MenuItemImpl)arrayList.get(n3);
    }

    public long getItemId(int n) {
        return n;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        View view2 = view;
        if (view == null) {
            view2 = this.mInflater.inflate(this.mItemLayoutRes, viewGroup, false);
        }
        int n2 = this.getItem(n).getGroupId();
        int n3 = n - 1;
        n3 = n3 >= 0 ? this.getItem(n3).getGroupId() : n2;
        view = (ListMenuItemView)view2;
        boolean bl = this.mAdapterMenu.isGroupDividerEnabled() && n2 != n3;
        view.setGroupDividerEnabled(bl);
        viewGroup = (MenuView.ItemView)view2;
        if (this.mForceShowIcon) {
            view.setForceShowIcon(true);
        }
        viewGroup.initialize(this.getItem(n), 0);
        return view2;
    }

    public void notifyDataSetChanged() {
        this.findExpandedIndex();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean bl) {
        this.mForceShowIcon = bl;
    }
}
