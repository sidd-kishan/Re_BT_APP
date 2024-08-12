/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.View
 *  androidx.core.internal.view.SupportMenuItem
 *  androidx.core.view.ActionProvider
 *  androidx.core.view.MenuItemCompat$OnActionExpandListener
 */
package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;

public final class MenuItemCompat {
    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;
    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static ActionProvider getActionProvider(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).getSupportActionProvider();
        }
        Log.w((String)TAG, (String)"getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @Deprecated
    public static View getActionView(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int getAlphabeticModifiers(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).getAlphabeticModifiers();
        }
        if (Build.VERSION.SDK_INT < 26) return 0;
        return menuItem.getAlphabeticModifiers();
    }

    public static CharSequence getContentDescription(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).getContentDescription();
        }
        if (Build.VERSION.SDK_INT < 26) return null;
        return menuItem.getContentDescription();
    }

    public static ColorStateList getIconTintList(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).getIconTintList();
        }
        if (Build.VERSION.SDK_INT < 26) return null;
        return menuItem.getIconTintList();
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).getIconTintMode();
        }
        if (Build.VERSION.SDK_INT < 26) return null;
        return menuItem.getIconTintMode();
    }

    public static int getNumericModifiers(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).getNumericModifiers();
        }
        if (Build.VERSION.SDK_INT < 26) return 0;
        return menuItem.getNumericModifiers();
    }

    public static CharSequence getTooltipText(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).getTooltipText();
        }
        if (Build.VERSION.SDK_INT < 26) return null;
        return menuItem.getTooltipText();
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).setSupportActionProvider(actionProvider);
        }
        Log.w((String)TAG, (String)"setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, int n) {
        return menuItem.setActionView(n);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void setAlphabeticShortcut(MenuItem menuItem, char c, int n) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem)menuItem).setAlphabeticShortcut(c, n);
        } else {
            if (Build.VERSION.SDK_INT < 26) return;
            menuItem.setAlphabeticShortcut(c, n);
        }
    }

    public static void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem)menuItem).setContentDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 26) return;
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem)menuItem).setIconTintList(colorStateList);
        } else {
            if (Build.VERSION.SDK_INT < 26) return;
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem)menuItem).setIconTintMode(mode);
        } else {
            if (Build.VERSION.SDK_INT < 26) return;
            menuItem.setIconTintMode(mode);
        }
    }

    public static void setNumericShortcut(MenuItem menuItem, char c, int n) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem)menuItem).setNumericShortcut(c, n);
        } else {
            if (Build.VERSION.SDK_INT < 26) return;
            menuItem.setNumericShortcut(c, n);
        }
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        return menuItem.setOnActionExpandListener((MenuItem.OnActionExpandListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public static void setShortcut(MenuItem menuItem, char c, char c2, int n, int n2) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem)menuItem).setShortcut(c, c2, n, n2);
        } else {
            if (Build.VERSION.SDK_INT < 26) return;
            menuItem.setShortcut(c, c2, n, n2);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int n) {
        menuItem.setShowAsAction(n);
    }

    public static void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem)menuItem).setTooltipText(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 26) return;
            menuItem.setTooltipText(charSequence);
        }
    }
}
