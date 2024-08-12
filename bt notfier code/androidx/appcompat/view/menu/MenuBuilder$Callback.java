/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.view.menu.MenuBuilder
 */
package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;

public static interface MenuBuilder.Callback {
    public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2);

    public void onMenuModeChange(MenuBuilder var1);
}
