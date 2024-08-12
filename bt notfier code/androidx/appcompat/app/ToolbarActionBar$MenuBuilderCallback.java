/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.MenuItem
 *  androidx.appcompat.app.ToolbarActionBar
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 */
package androidx.appcompat.app;

import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.MenuBuilder;

private final class ToolbarActionBar.MenuBuilderCallback
implements MenuBuilder.Callback {
    final ToolbarActionBar this$0;

    ToolbarActionBar.MenuBuilderCallback(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return false;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        if (this.this$0.mWindowCallback == null) return;
        if (this.this$0.mDecorToolbar.isOverflowMenuShowing()) {
            this.this$0.mWindowCallback.onPanelClosed(108, (Menu)menuBuilder);
        } else {
            if (!this.this$0.mWindowCallback.onPreparePanel(0, null, (Menu)menuBuilder)) return;
            this.this$0.mWindowCallback.onMenuOpened(108, (Menu)menuBuilder);
        }
    }
}
