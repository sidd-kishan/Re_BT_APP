/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  androidx.appcompat.app.ToolbarActionBar
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 */
package androidx.appcompat.app;

import android.view.Menu;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

private final class ToolbarActionBar.ActionMenuPresenterCallback
implements MenuPresenter.Callback {
    private boolean mClosingActionMenu;
    final ToolbarActionBar this$0;

    ToolbarActionBar.ActionMenuPresenterCallback(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.this$0.mDecorToolbar.dismissPopupMenus();
        if (this.this$0.mWindowCallback != null) {
            this.this$0.mWindowCallback.onPanelClosed(108, (Menu)menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        if (this.this$0.mWindowCallback == null) return false;
        this.this$0.mWindowCallback.onMenuOpened(108, (Menu)menuBuilder);
        return true;
    }
}
