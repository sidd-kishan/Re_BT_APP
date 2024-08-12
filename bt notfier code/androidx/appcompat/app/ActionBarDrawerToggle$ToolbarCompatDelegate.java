/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  androidx.appcompat.app.ActionBarDrawerToggle$Delegate
 *  androidx.appcompat.widget.Toolbar
 */
package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

static class ActionBarDrawerToggle.ToolbarCompatDelegate
implements ActionBarDrawerToggle.Delegate {
    final CharSequence mDefaultContentDescription;
    final Drawable mDefaultUpIndicator;
    final Toolbar mToolbar;

    ActionBarDrawerToggle.ToolbarCompatDelegate(Toolbar toolbar) {
        this.mToolbar = toolbar;
        this.mDefaultUpIndicator = toolbar.getNavigationIcon();
        this.mDefaultContentDescription = toolbar.getNavigationContentDescription();
    }

    public Context getActionBarThemedContext() {
        return this.mToolbar.getContext();
    }

    public Drawable getThemeUpIndicator() {
        return this.mDefaultUpIndicator;
    }

    public boolean isNavigationVisible() {
        return true;
    }

    public void setActionBarDescription(int n) {
        if (n == 0) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
        } else {
            this.mToolbar.setNavigationContentDescription(n);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable, int n) {
        this.mToolbar.setNavigationIcon(drawable);
        this.setActionBarDescription(n);
    }
}
