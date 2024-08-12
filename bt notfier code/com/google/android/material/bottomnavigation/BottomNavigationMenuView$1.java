/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.view.menu.MenuPresenter
 *  com.google.android.material.bottomnavigation.BottomNavigationItemView
 *  com.google.android.material.bottomnavigation.BottomNavigationMenuView
 */
package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuPresenter;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;

/*
 * Exception performing whole class analysis ignored.
 */
class BottomNavigationMenuView.1
implements View.OnClickListener {
    final BottomNavigationMenuView this$0;

    BottomNavigationMenuView.1(BottomNavigationMenuView bottomNavigationMenuView) {
        this.this$0 = bottomNavigationMenuView;
    }

    public void onClick(View view) {
        view = ((BottomNavigationItemView)view).getItemData();
        if (BottomNavigationMenuView.access$100((BottomNavigationMenuView)this.this$0).performItemAction((MenuItem)view, (MenuPresenter)BottomNavigationMenuView.access$000((BottomNavigationMenuView)this.this$0), 0)) return;
        view.setChecked(true);
    }
}
