/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  com.google.android.material.bottomnavigation.BottomNavigationView
 */
package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/*
 * Exception performing whole class analysis ignored.
 */
class BottomNavigationView.1
implements MenuBuilder.Callback {
    final BottomNavigationView this$0;

    BottomNavigationView.1(BottomNavigationView bottomNavigationView) {
        this.this$0 = bottomNavigationView;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        menuBuilder = BottomNavigationView.access$000((BottomNavigationView)this.this$0);
        boolean bl = true;
        if (menuBuilder != null && menuItem.getItemId() == this.this$0.getSelectedItemId()) {
            BottomNavigationView.access$000((BottomNavigationView)this.this$0).onNavigationItemReselected(menuItem);
            return true;
        }
        if (BottomNavigationView.access$100((BottomNavigationView)this.this$0) != null && !BottomNavigationView.access$100((BottomNavigationView)this.this$0).onNavigationItemSelected(menuItem)) return bl;
        bl = false;
        return bl;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}
