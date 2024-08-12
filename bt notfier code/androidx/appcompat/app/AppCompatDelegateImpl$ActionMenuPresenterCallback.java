/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.Window$Callback
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 */
package androidx.appcompat.app;

import android.view.Menu;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

private final class AppCompatDelegateImpl.ActionMenuPresenterCallback
implements MenuPresenter.Callback {
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.ActionMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        this.this$0.checkCloseActionMenu(menuBuilder);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        Window.Callback callback = this.this$0.getWindowCallback();
        if (callback == null) return true;
        callback.onMenuOpened(108, (Menu)menuBuilder);
        return true;
    }
}
