/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPresenter
 *  com.google.android.material.internal.NavigationMenuItemView
 *  com.google.android.material.internal.NavigationMenuPresenter
 */
package com.google.android.material.internal;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.internal.NavigationMenuPresenter;

class NavigationMenuPresenter.1
implements View.OnClickListener {
    final NavigationMenuPresenter this$0;

    NavigationMenuPresenter.1(NavigationMenuPresenter navigationMenuPresenter) {
        this.this$0 = navigationMenuPresenter;
    }

    public void onClick(View view) {
        view = (NavigationMenuItemView)view;
        this.this$0.setUpdateSuspended(true);
        view = view.getItemData();
        boolean bl = this.this$0.menu.performItemAction((MenuItem)view, (MenuPresenter)this.this$0, 0);
        if (view != null && view.isCheckable() && bl) {
            this.this$0.adapter.setCheckedItem((MenuItemImpl)view);
        }
        this.this$0.setUpdateSuspended(false);
        this.this$0.updateMenuView(false);
    }
}
