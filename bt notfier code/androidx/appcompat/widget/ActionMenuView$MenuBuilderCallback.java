/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.widget.ActionMenuView
 */
package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;

private class ActionMenuView.MenuBuilderCallback
implements MenuBuilder.Callback {
    final ActionMenuView this$0;

    ActionMenuView.MenuBuilderCallback(ActionMenuView actionMenuView) {
        this.this$0 = actionMenuView;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        boolean bl = this.this$0.mOnMenuItemClickListener != null && this.this$0.mOnMenuItemClickListener.onMenuItemClick(menuItem);
        return bl;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        if (this.this$0.mMenuBuilderCallback == null) return;
        this.this$0.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
    }
}
