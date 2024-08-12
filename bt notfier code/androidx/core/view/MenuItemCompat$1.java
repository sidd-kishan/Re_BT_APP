/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  androidx.core.view.MenuItemCompat$OnActionExpandListener
 */
package androidx.core.view;

import android.view.MenuItem;
import androidx.core.view.MenuItemCompat;

class MenuItemCompat.1
implements MenuItem.OnActionExpandListener {
    final MenuItemCompat.OnActionExpandListener val$listener;

    MenuItemCompat.1(MenuItemCompat.OnActionExpandListener onActionExpandListener) {
        this.val$listener = onActionExpandListener;
    }

    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.val$listener.onMenuItemActionCollapse(menuItem);
    }

    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.val$listener.onMenuItemActionExpand(menuItem);
    }
}
