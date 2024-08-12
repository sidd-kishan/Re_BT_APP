/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  com.google.android.material.navigation.NavigationView
 */
package com.google.android.material.navigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import com.google.android.material.navigation.NavigationView;

class NavigationView.1
implements MenuBuilder.Callback {
    final NavigationView this$0;

    NavigationView.1(NavigationView navigationView) {
        this.this$0 = navigationView;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        boolean bl = this.this$0.listener != null && this.this$0.listener.onNavigationItemSelected(menuItem);
        return bl;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}
