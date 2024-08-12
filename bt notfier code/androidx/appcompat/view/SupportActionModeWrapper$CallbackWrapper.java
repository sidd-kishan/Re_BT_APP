/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.Menu
 *  android.view.MenuItem
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 *  androidx.appcompat.view.SupportActionModeWrapper
 *  androidx.appcompat.view.menu.MenuItemWrapperICS
 *  androidx.appcompat.view.menu.MenuWrapperICS
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.internal.view.SupportMenu
 *  androidx.core.internal.view.SupportMenuItem
 */
package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

public static class SupportActionModeWrapper.CallbackWrapper
implements ActionMode.Callback {
    final ArrayList<SupportActionModeWrapper> mActionModes;
    final Context mContext;
    final SimpleArrayMap<Menu, Menu> mMenus;
    final ActionMode.Callback mWrappedCallback;

    public SupportActionModeWrapper.CallbackWrapper(Context context, ActionMode.Callback callback) {
        this.mContext = context;
        this.mWrappedCallback = callback;
        this.mActionModes = new ArrayList();
        this.mMenus = new SimpleArrayMap();
    }

    private Menu getMenuWrapper(Menu menu) {
        Menu menu2;
        Menu menu3 = menu2 = (Menu)this.mMenus.get((Object)menu);
        if (menu2 != null) return menu3;
        menu3 = new MenuWrapperICS(this.mContext, (SupportMenu)menu);
        this.mMenus.put((Object)menu, (Object)menu3);
        return menu3;
    }

    public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
        int n = this.mActionModes.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                actionMode = new SupportActionModeWrapper(this.mContext, actionMode);
                this.mActionModes.add((SupportActionModeWrapper)actionMode);
                return actionMode;
            }
            SupportActionModeWrapper supportActionModeWrapper = this.mActionModes.get(n2);
            if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                return supportActionModeWrapper;
            }
            ++n2;
        }
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.mWrappedCallback.onActionItemClicked(this.getActionModeWrapper(actionMode), (MenuItem)new MenuItemWrapperICS(this.mContext, (SupportMenuItem)menuItem));
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.mWrappedCallback.onCreateActionMode(this.getActionModeWrapper(actionMode), this.getMenuWrapper(menu));
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.mWrappedCallback.onDestroyActionMode(this.getActionModeWrapper(actionMode));
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.mWrappedCallback.onPrepareActionMode(this.getActionModeWrapper(actionMode), this.getMenuWrapper(menu));
    }
}
