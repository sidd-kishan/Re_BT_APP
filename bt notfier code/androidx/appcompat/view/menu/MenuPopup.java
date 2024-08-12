/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.HeaderViewListAdapter
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.appcompat.view.menu.MenuAdapter
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuView
 *  androidx.appcompat.view.menu.ShowableListMenu
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;

abstract class MenuPopup
implements ShowableListMenu,
MenuPresenter,
AdapterView.OnItemClickListener {
    private Rect mEpicenterBounds;

    MenuPopup() {
    }

    protected static int measureIndividualMenuWidth(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int n) {
        int n2 = 0;
        int n3 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n4 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n5 = listAdapter.getCount();
        ViewGroup viewGroup2 = null;
        int n6 = 0;
        int n7 = 0;
        ViewGroup viewGroup3 = viewGroup;
        viewGroup = viewGroup2;
        while (n2 < n5) {
            int n8 = listAdapter.getItemViewType(n2);
            int n9 = n7;
            if (n8 != n7) {
                viewGroup = null;
                n9 = n8;
            }
            viewGroup2 = viewGroup3;
            if (viewGroup3 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            viewGroup = listAdapter.getView(n2, (View)viewGroup, viewGroup2);
            viewGroup.measure(n3, n4);
            n8 = viewGroup.getMeasuredWidth();
            if (n8 >= n) {
                return n;
            }
            n7 = n6;
            if (n8 > n6) {
                n7 = n8;
            }
            ++n2;
            n6 = n7;
            n7 = n9;
            viewGroup3 = viewGroup2;
        }
        return n6;
    }

    protected static boolean shouldPreserveIconSpacing(MenuBuilder menuBuilder) {
        int n = menuBuilder.size();
        boolean bl = false;
        int n2 = 0;
        while (true) {
            boolean bl2 = bl;
            if (n2 >= n) return bl2;
            MenuItem menuItem = menuBuilder.getItem(n2);
            if (menuItem.isVisible() && menuItem.getIcon() != null) {
                bl2 = true;
                return bl2;
            }
            ++n2;
        }
    }

    protected static MenuAdapter toMenuAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof HeaderViewListAdapter)) return (MenuAdapter)listAdapter;
        return (MenuAdapter)((HeaderViewListAdapter)listAdapter).getWrappedAdapter();
    }

    public abstract void addMenu(MenuBuilder var1);

    protected boolean closeMenuOnSubMenuOpened() {
        return true;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public Rect getEpicenterBounds() {
        return this.mEpicenterBounds;
    }

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
    }

    public void onItemClick(AdapterView<?> menuBuilder, View view, int n, long l) {
        view = (ListAdapter)menuBuilder.getAdapter();
        menuBuilder = MenuPopup.toMenuAdapter((ListAdapter)view).mAdapterMenu;
        view = (MenuItem)view.getItem(n);
        n = this.closeMenuOnSubMenuOpened() ? 0 : 4;
        menuBuilder.performItemAction((MenuItem)view, (MenuPresenter)this, n);
    }

    public abstract void setAnchorView(View var1);

    public void setEpicenterBounds(Rect rect) {
        this.mEpicenterBounds = rect;
    }

    public abstract void setForceShowIcon(boolean var1);

    public abstract void setGravity(int var1);

    public abstract void setHorizontalOffset(int var1);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener var1);

    public abstract void setShowTitle(boolean var1);

    public abstract void setVerticalOffset(int var1);
}
