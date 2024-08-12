/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  androidx.appcompat.view.menu.MenuItemWrapperICS
 */
package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuItemWrapperICS;

private class MenuItemWrapperICS.OnActionExpandListenerWrapper
implements MenuItem.OnActionExpandListener {
    private final MenuItem.OnActionExpandListener mObject;
    final MenuItemWrapperICS this$0;

    MenuItemWrapperICS.OnActionExpandListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.this$0 = menuItemWrapperICS;
        this.mObject = onActionExpandListener;
    }

    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.mObject.onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(menuItem));
    }

    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.mObject.onMenuItemActionExpand(this.this$0.getMenuItemWrapper(menuItem));
    }
}
