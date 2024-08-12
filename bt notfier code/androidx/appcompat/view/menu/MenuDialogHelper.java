/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.os.IBinder
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.Window
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.app.AlertDialog
 *  androidx.appcompat.app.AlertDialog$Builder
 *  androidx.appcompat.view.menu.ListMenuPresenter
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 */
package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;

class MenuDialogHelper
implements DialogInterface.OnKeyListener,
DialogInterface.OnClickListener,
DialogInterface.OnDismissListener,
MenuPresenter.Callback {
    private AlertDialog mDialog;
    private MenuBuilder mMenu;
    ListMenuPresenter mPresenter;
    private MenuPresenter.Callback mPresenterCallback;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public void dismiss() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog == null) return;
        alertDialog.dismiss();
    }

    public void onClick(DialogInterface dialogInterface, int n) {
        this.mMenu.performItemAction((MenuItem)((MenuItemImpl)this.mPresenter.getAdapter().getItem(n)), 0);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        MenuPresenter.Callback callback;
        if (bl || menuBuilder == this.mMenu) {
            this.dismiss();
        }
        if ((callback = this.mPresenterCallback) == null) return;
        callback.onCloseMenu(menuBuilder, bl);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.mPresenter.onCloseMenu(this.mMenu, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int n, KeyEvent keyEvent) {
        if (n != 82) {
            if (n != 4) return this.mMenu.performShortcut(n, keyEvent, 0);
        }
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            dialogInterface = this.mDialog.getWindow();
            if (dialogInterface == null) return this.mMenu.performShortcut(n, keyEvent, 0);
            if ((dialogInterface = dialogInterface.getDecorView()) == null) return this.mMenu.performShortcut(n, keyEvent, 0);
            if ((dialogInterface = dialogInterface.getKeyDispatcherState()) == null) return this.mMenu.performShortcut(n, keyEvent, 0);
            dialogInterface.startTracking(keyEvent, (Object)this);
            return true;
        }
        if (keyEvent.getAction() != 1) return this.mMenu.performShortcut(n, keyEvent, 0);
        if (keyEvent.isCanceled()) return this.mMenu.performShortcut(n, keyEvent, 0);
        Window window = this.mDialog.getWindow();
        if (window == null) return this.mMenu.performShortcut(n, keyEvent, 0);
        if ((window = window.getDecorView()) == null) return this.mMenu.performShortcut(n, keyEvent, 0);
        if ((window = window.getKeyDispatcherState()) == null) return this.mMenu.performShortcut(n, keyEvent, 0);
        if (!window.isTracking(keyEvent)) return this.mMenu.performShortcut(n, keyEvent, 0);
        this.mMenu.close(true);
        dialogInterface.dismiss();
        return true;
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback == null) return false;
        return callback.onOpenSubMenu(menuBuilder);
    }

    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    public void show(IBinder iBinder) {
        ListMenuPresenter listMenuPresenter;
        MenuBuilder menuBuilder = this.mMenu;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.getContext());
        this.mPresenter = listMenuPresenter = new ListMenuPresenter(builder.getContext(), R.layout.abc_list_menu_item_layout);
        listMenuPresenter.setCallback((MenuPresenter.Callback)this);
        this.mMenu.addMenuPresenter((MenuPresenter)this.mPresenter);
        builder.setAdapter(this.mPresenter.getAdapter(), (DialogInterface.OnClickListener)this);
        listMenuPresenter = menuBuilder.getHeaderView();
        if (listMenuPresenter != null) {
            builder.setCustomTitle((View)listMenuPresenter);
        } else {
            builder.setIcon(menuBuilder.getHeaderIcon()).setTitle(menuBuilder.getHeaderTitle());
        }
        builder.setOnKeyListener((DialogInterface.OnKeyListener)this);
        builder = builder.create();
        this.mDialog = builder;
        builder.setOnDismissListener((DialogInterface.OnDismissListener)this);
        builder = this.mDialog.getWindow().getAttributes();
        builder.type = 1003;
        if (iBinder != null) {
            builder.token = iBinder;
        }
        builder.flags |= 0x20000;
        this.mDialog.show();
    }
}
