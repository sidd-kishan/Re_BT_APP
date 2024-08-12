/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.View
 *  android.widget.HeaderViewListAdapter
 *  android.widget.ListAdapter
 *  androidx.appcompat.view.menu.ListMenuItemView
 *  androidx.appcompat.view.menu.MenuAdapter
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.widget.DropDownListView
 *  androidx.appcompat.widget.MenuItemHoverListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.MenuItemHoverListener;

public static class MenuPopupWindow.MenuDropDownListView
extends DropDownListView {
    final int mAdvanceKey;
    private MenuItemHoverListener mHoverListener;
    private MenuItem mHoveredMenuItem;
    final int mRetreatKey;

    public MenuPopupWindow.MenuDropDownListView(Context context, boolean bl) {
        super(context, bl);
        context = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 17 && 1 == context.getLayoutDirection()) {
            this.mAdvanceKey = 21;
            this.mRetreatKey = 22;
        } else {
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
        }
    }

    public void clearSelection() {
        this.setSelection(-1);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        MenuAdapter menuAdapter;
        int n;
        if (this.mHoverListener == null) return super.onHoverEvent(motionEvent);
        ListAdapter listAdapter = this.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            listAdapter = (HeaderViewListAdapter)listAdapter;
            n = listAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter)listAdapter.getWrappedAdapter();
        } else {
            n = 0;
            menuAdapter = (MenuAdapter)listAdapter;
        }
        MenuItem menuItem = null;
        listAdapter = menuItem;
        if (motionEvent.getAction() != 10) {
            int n2 = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
            listAdapter = menuItem;
            if (n2 != -1) {
                n = n2 - n;
                listAdapter = menuItem;
                if (n >= 0) {
                    listAdapter = menuItem;
                    if (n < menuAdapter.getCount()) {
                        listAdapter = menuAdapter.getItem(n);
                    }
                }
            }
        }
        if ((menuItem = this.mHoveredMenuItem) == listAdapter) return super.onHoverEvent(motionEvent);
        menuAdapter = menuAdapter.getAdapterMenu();
        if (menuItem != null) {
            this.mHoverListener.onItemHoverExit((MenuBuilder)menuAdapter, menuItem);
        }
        this.mHoveredMenuItem = listAdapter;
        if (listAdapter == null) return super.onHoverEvent(motionEvent);
        this.mHoverListener.onItemHoverEnter((MenuBuilder)menuAdapter, (MenuItem)listAdapter);
        return super.onHoverEvent(motionEvent);
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView)this.getSelectedView();
        if (listMenuItemView != null && n == this.mAdvanceKey) {
            if (!listMenuItemView.isEnabled()) return true;
            if (!listMenuItemView.getItemData().hasSubMenu()) return true;
            this.performItemClick((View)listMenuItemView, this.getSelectedItemPosition(), this.getSelectedItemId());
            return true;
        }
        if (listMenuItemView == null) return super.onKeyDown(n, keyEvent);
        if (n != this.mRetreatKey) return super.onKeyDown(n, keyEvent);
        this.setSelection(-1);
        keyEvent = this.getAdapter();
        keyEvent = keyEvent instanceof HeaderViewListAdapter ? (MenuAdapter)((HeaderViewListAdapter)keyEvent).getWrappedAdapter() : (MenuAdapter)keyEvent;
        keyEvent.getAdapterMenu().close(false);
        return true;
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        this.mHoverListener = menuItemHoverListener;
    }
}
