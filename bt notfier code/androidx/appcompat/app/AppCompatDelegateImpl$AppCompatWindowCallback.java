/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.KeyEvent
 *  android.view.KeyboardShortcutGroup
 *  android.view.Menu
 *  android.view.View
 *  android.view.Window$Callback
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 *  androidx.appcompat.view.SupportActionModeWrapper$CallbackWrapper
 *  androidx.appcompat.view.WindowCallbackWrapper
 *  androidx.appcompat.view.menu.MenuBuilder
 */
package androidx.appcompat.app;

import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.List;

class AppCompatDelegateImpl.AppCompatWindowCallback
extends WindowCallbackWrapper {
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.AppCompatWindowCallback(AppCompatDelegateImpl appCompatDelegateImpl, Window.Callback callback) {
        this.this$0 = appCompatDelegateImpl;
        super(callback);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl = this.this$0.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        return bl;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        boolean bl = super.dispatchKeyShortcutEvent(keyEvent) || this.this$0.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        return bl;
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int n, Menu menu) {
        if (n != 0) return super.onCreatePanelMenu(n, menu);
        if (menu instanceof MenuBuilder) return super.onCreatePanelMenu(n, menu);
        return false;
    }

    public boolean onMenuOpened(int n, Menu menu) {
        super.onMenuOpened(n, menu);
        this.this$0.onMenuOpened(n);
        return true;
    }

    public void onPanelClosed(int n, Menu menu) {
        super.onPanelClosed(n, menu);
        this.this$0.onPanelClosed(n);
    }

    public boolean onPreparePanel(int n, View view, Menu menu) {
        MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder)menu : null;
        if (n == 0 && menuBuilder == null) {
            return false;
        }
        if (menuBuilder != null) {
            menuBuilder.setOverrideVisibleItems(true);
        }
        boolean bl = super.onPreparePanel(n, view, menu);
        if (menuBuilder == null) return bl;
        menuBuilder.setOverrideVisibleItems(false);
        return bl;
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int n) {
        AppCompatDelegateImpl.PanelFeatureState panelFeatureState = this.this$0.getPanelState(0, true);
        if (panelFeatureState != null && panelFeatureState.menu != null) {
            super.onProvideKeyboardShortcuts(list, (Menu)panelFeatureState.menu, n);
        } else {
            super.onProvideKeyboardShortcuts(list, menu, n);
        }
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            return null;
        }
        if (!this.this$0.isHandleNativeActionModesEnabled()) return super.onWindowStartingActionMode(callback);
        return this.startAsSupportActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int n) {
        if (!this.this$0.isHandleNativeActionModesEnabled()) return super.onWindowStartingActionMode(callback, n);
        if (n == 0) return this.startAsSupportActionMode(callback);
        return super.onWindowStartingActionMode(callback, n);
    }

    final ActionMode startAsSupportActionMode(ActionMode.Callback callback) {
        androidx.appcompat.view.ActionMode actionMode = this.this$0.startSupportActionMode((ActionMode.Callback)(callback = new SupportActionModeWrapper.CallbackWrapper(this.this$0.mContext, callback)));
        if (actionMode == null) return null;
        return callback.getActionModeWrapper(actionMode);
    }
}
