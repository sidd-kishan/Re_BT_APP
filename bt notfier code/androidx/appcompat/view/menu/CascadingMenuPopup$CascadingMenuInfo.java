/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.ListView
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.widget.MenuPopupWindow
 */
package androidx.appcompat.view.menu;

import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.MenuPopupWindow;

private static class CascadingMenuPopup.CascadingMenuInfo {
    public final MenuBuilder menu;
    public final int position;
    public final MenuPopupWindow window;

    public CascadingMenuPopup.CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int n) {
        this.window = menuPopupWindow;
        this.menu = menuBuilder;
        this.position = n;
    }

    public ListView getListView() {
        return this.window.getListView();
    }
}
