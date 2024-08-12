/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  androidx.appcompat.view.menu.MenuItemImpl
 */
package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;
import androidx.appcompat.view.menu.MenuItemImpl;

public static interface MenuView.ItemView {
    public MenuItemImpl getItemData();

    public void initialize(MenuItemImpl var1, int var2);

    public boolean prefersCondensedTitle();

    public void setCheckable(boolean var1);

    public void setChecked(boolean var1);

    public void setEnabled(boolean var1);

    public void setIcon(Drawable var1);

    public void setShortcut(boolean var1, char var2);

    public void setTitle(CharSequence var1);

    public boolean showsIcon();
}
