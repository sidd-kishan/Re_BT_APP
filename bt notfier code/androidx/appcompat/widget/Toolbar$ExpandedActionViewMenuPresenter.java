/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.appcompat.view.CollapsibleActionView
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.MenuView
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  androidx.appcompat.widget.Toolbar
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.Toolbar;

private class Toolbar.ExpandedActionViewMenuPresenter
implements MenuPresenter {
    MenuItemImpl mCurrentExpandedItem;
    MenuBuilder mMenu;
    final Toolbar this$0;

    Toolbar.ExpandedActionViewMenuPresenter(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        if (this.this$0.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewCollapsed();
        }
        menuBuilder = this.this$0;
        menuBuilder.removeView(menuBuilder.mExpandedActionView);
        menuBuilder = this.this$0;
        menuBuilder.removeView((View)menuBuilder.mCollapseButtonView);
        this.this$0.mExpandedActionView = null;
        this.this$0.addChildrenForExpandedActionView();
        this.mCurrentExpandedItem = null;
        this.this$0.requestLayout();
        menuItemImpl.setActionViewExpanded(false);
        return true;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        this.this$0.ensureCollapseButtonView();
        menuBuilder = this.this$0.mCollapseButtonView.getParent();
        Toolbar toolbar = this.this$0;
        if (menuBuilder != toolbar) {
            if (menuBuilder instanceof ViewGroup) {
                ((ViewGroup)menuBuilder).removeView((View)toolbar.mCollapseButtonView);
            }
            menuBuilder = this.this$0;
            menuBuilder.addView((View)menuBuilder.mCollapseButtonView);
        }
        this.this$0.mExpandedActionView = menuItemImpl.getActionView();
        this.mCurrentExpandedItem = menuItemImpl;
        menuBuilder = this.this$0.mExpandedActionView.getParent();
        if (menuBuilder != (toolbar = this.this$0)) {
            if (menuBuilder instanceof ViewGroup) {
                ((ViewGroup)menuBuilder).removeView(toolbar.mExpandedActionView);
            }
            menuBuilder = this.this$0.generateDefaultLayoutParams();
            menuBuilder.gravity = 0x800003 | this.this$0.mButtonGravity & 0x70;
            menuBuilder.mViewType = 2;
            this.this$0.mExpandedActionView.setLayoutParams((ViewGroup.LayoutParams)menuBuilder);
            menuBuilder = this.this$0;
            menuBuilder.addView(menuBuilder.mExpandedActionView);
        }
        this.this$0.removeChildrenForExpandedActionView();
        this.this$0.requestLayout();
        menuItemImpl.setActionViewExpanded(true);
        if (!(this.this$0.mExpandedActionView instanceof CollapsibleActionView)) return true;
        ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewExpanded();
        return true;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        return null;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        MenuBuilder menuBuilder2 = this.mMenu;
        if (menuBuilder2 != null && (context = this.mCurrentExpandedItem) != null) {
            menuBuilder2.collapseItemActionView((MenuItemImpl)context);
        }
        this.mMenu = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setCallback(MenuPresenter.Callback callback) {
    }

    public void updateMenuView(boolean bl) {
        boolean bl2;
        if (this.mCurrentExpandedItem == null) return;
        MenuBuilder menuBuilder = this.mMenu;
        boolean bl3 = bl2 = false;
        if (menuBuilder != null) {
            int n = menuBuilder.size();
            int n2 = 0;
            while (true) {
                bl3 = bl2;
                if (n2 >= n) break;
                if (this.mMenu.getItem(n2) == this.mCurrentExpandedItem) {
                    bl3 = true;
                    break;
                }
                ++n2;
            }
        }
        if (bl3) return;
        this.collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
    }
}
