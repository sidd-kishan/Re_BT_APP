/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.Window$Callback
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 */
package androidx.appcompat.app;

import android.view.Menu;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

private final class AppCompatDelegateImpl.PanelMenuPresenterCallback
implements MenuPresenter.Callback {
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.PanelMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        MenuBuilder menuBuilder2 = menuBuilder.getRootMenu();
        boolean bl2 = menuBuilder2 != menuBuilder;
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        if (bl2) {
            menuBuilder = menuBuilder2;
        }
        if ((menuBuilder = appCompatDelegateImpl.findMenuPanel((Menu)menuBuilder)) == null) return;
        if (bl2) {
            this.this$0.callOnPanelClosed(menuBuilder.featureId, (AppCompatDelegateImpl.PanelFeatureState)menuBuilder, (Menu)menuBuilder2);
            this.this$0.closePanel((AppCompatDelegateImpl.PanelFeatureState)menuBuilder, true);
        } else {
            this.this$0.closePanel((AppCompatDelegateImpl.PanelFeatureState)menuBuilder, bl);
        }
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        if (menuBuilder != menuBuilder.getRootMenu()) return true;
        if (!this.this$0.mHasActionBar) return true;
        Window.Callback callback = this.this$0.getWindowCallback();
        if (callback == null) return true;
        if (this.this$0.mIsDestroyed) return true;
        callback.onMenuOpened(108, (Menu)menuBuilder);
        return true;
    }
}
