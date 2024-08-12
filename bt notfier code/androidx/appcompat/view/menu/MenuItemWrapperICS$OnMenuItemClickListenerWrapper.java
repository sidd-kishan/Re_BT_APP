/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 *  androidx.appcompat.view.menu.MenuItemWrapperICS
 */
package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuItemWrapperICS;

private class MenuItemWrapperICS.OnMenuItemClickListenerWrapper
implements MenuItem.OnMenuItemClickListener {
    private final MenuItem.OnMenuItemClickListener mObject;
    final MenuItemWrapperICS this$0;

    MenuItemWrapperICS.OnMenuItemClickListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.this$0 = menuItemWrapperICS;
        this.mObject = onMenuItemClickListener;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.mObject.onMenuItemClick(this.this$0.getMenuItemWrapper(menuItem));
    }
}
