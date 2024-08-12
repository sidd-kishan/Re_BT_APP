/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  androidx.appcompat.view.menu.ListMenuPresenter
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuView$ItemView
 */
package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

private class ListMenuPresenter.MenuAdapter
extends BaseAdapter {
    private int mExpandedIndex;
    final ListMenuPresenter this$0;

    public ListMenuPresenter.MenuAdapter(ListMenuPresenter listMenuPresenter) {
        this.this$0 = listMenuPresenter;
        this.mExpandedIndex = -1;
        this.findExpandedIndex();
    }

    void findExpandedIndex() {
        MenuItemImpl menuItemImpl = this.this$0.mMenu.getExpandedItem();
        if (menuItemImpl != null) {
            ArrayList arrayList = this.this$0.mMenu.getNonActionItems();
            int n = arrayList.size();
            for (int i = 0; i < n; ++i) {
                if ((MenuItemImpl)arrayList.get(i) != menuItemImpl) continue;
                this.mExpandedIndex = i;
                return;
            }
        }
        this.mExpandedIndex = -1;
    }

    public int getCount() {
        int n = this.this$0.mMenu.getNonActionItems().size() - this.this$0.mItemIndexOffset;
        if (this.mExpandedIndex >= 0) return n - 1;
        return n;
    }

    public MenuItemImpl getItem(int n) {
        ArrayList arrayList = this.this$0.mMenu.getNonActionItems();
        int n2 = n + this.this$0.mItemIndexOffset;
        int n3 = this.mExpandedIndex;
        n = n2;
        if (n3 < 0) return (MenuItemImpl)arrayList.get(n);
        n = n2;
        if (n2 < n3) return (MenuItemImpl)arrayList.get(n);
        n = n2 + 1;
        return (MenuItemImpl)arrayList.get(n);
    }

    public long getItemId(int n) {
        return n;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        View view2 = view;
        if (view == null) {
            view2 = this.this$0.mInflater.inflate(this.this$0.mItemLayoutRes, viewGroup, false);
        }
        ((MenuView.ItemView)view2).initialize(this.getItem(n), 0);
        return view2;
    }

    public void notifyDataSetChanged() {
        this.findExpandedIndex();
        super.notifyDataSetChanged();
    }
}
