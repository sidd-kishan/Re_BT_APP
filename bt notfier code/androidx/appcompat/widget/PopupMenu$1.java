/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.widget.PopupMenu
 */
package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.PopupMenu;

class PopupMenu.1
implements MenuBuilder.Callback {
    final PopupMenu this$0;

    PopupMenu.1(PopupMenu popupMenu) {
        this.this$0 = popupMenu;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.this$0.mMenuItemClickListener == null) return false;
        return this.this$0.mMenuItemClickListener.onMenuItemClick(menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}
