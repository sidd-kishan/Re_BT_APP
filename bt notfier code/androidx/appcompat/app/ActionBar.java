/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.view.KeyEvent
 *  android.view.View
 *  android.widget.SpinnerAdapter
 *  androidx.appcompat.app.ActionBar$LayoutParams
 *  androidx.appcompat.app.ActionBar$OnMenuVisibilityListener
 *  androidx.appcompat.app.ActionBar$OnNavigationListener
 *  androidx.appcompat.app.ActionBar$Tab
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionMode;

public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;
    @Deprecated
    public static final int NAVIGATION_MODE_LIST = 1;
    @Deprecated
    public static final int NAVIGATION_MODE_STANDARD = 0;
    @Deprecated
    public static final int NAVIGATION_MODE_TABS = 2;

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener var1);

    @Deprecated
    public abstract void addTab(Tab var1);

    @Deprecated
    public abstract void addTab(Tab var1, int var2);

    @Deprecated
    public abstract void addTab(Tab var1, int var2, boolean var3);

    @Deprecated
    public abstract void addTab(Tab var1, boolean var2);

    public boolean closeOptionsMenu() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public void dispatchMenuVisibilityChanged(boolean bl) {
    }

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    @Deprecated
    public abstract int getNavigationItemCount();

    @Deprecated
    public abstract int getNavigationMode();

    @Deprecated
    public abstract int getSelectedNavigationIndex();

    @Deprecated
    public abstract Tab getSelectedTab();

    public abstract CharSequence getSubtitle();

    @Deprecated
    public abstract Tab getTabAt(int var1);

    @Deprecated
    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    public abstract CharSequence getTitle();

    public abstract void hide();

    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    public boolean isTitleTruncated() {
        return false;
    }

    @Deprecated
    public abstract Tab newTab();

    public void onConfigurationChanged(Configuration configuration) {
    }

    void onDestroy() {
    }

    public boolean onKeyShortcut(int n, KeyEvent keyEvent) {
        return false;
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean openOptionsMenu() {
        return false;
    }

    @Deprecated
    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener var1);

    @Deprecated
    public abstract void removeTab(Tab var1);

    @Deprecated
    public abstract void removeTabAt(int var1);

    boolean requestFocus() {
        return false;
    }

    @Deprecated
    public abstract void selectTab(Tab var1);

    public abstract void setBackgroundDrawable(Drawable var1);

    public abstract void setCustomView(int var1);

    public abstract void setCustomView(View var1);

    public abstract void setCustomView(View var1, LayoutParams var2);

    public void setDefaultDisplayHomeAsUpEnabled(boolean bl) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean var1);

    public abstract void setDisplayOptions(int var1);

    public abstract void setDisplayOptions(int var1, int var2);

    public abstract void setDisplayShowCustomEnabled(boolean var1);

    public abstract void setDisplayShowHomeEnabled(boolean var1);

    public abstract void setDisplayShowTitleEnabled(boolean var1);

    public abstract void setDisplayUseLogoEnabled(boolean var1);

    public void setElevation(float f) {
        if (f != 0.0f) throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }

    public void setHideOffset(int n) {
        if (n != 0) throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
    }

    public void setHideOnContentScrollEnabled(boolean bl) {
        if (bl) throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public void setHomeActionContentDescription(int n) {
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
    }

    public void setHomeAsUpIndicator(int n) {
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
    }

    public void setHomeButtonEnabled(boolean bl) {
    }

    public abstract void setIcon(int var1);

    public abstract void setIcon(Drawable var1);

    @Deprecated
    public abstract void setListNavigationCallbacks(SpinnerAdapter var1, OnNavigationListener var2);

    public abstract void setLogo(int var1);

    public abstract void setLogo(Drawable var1);

    @Deprecated
    public abstract void setNavigationMode(int var1);

    @Deprecated
    public abstract void setSelectedNavigationItem(int var1);

    public void setShowHideAnimationEnabled(boolean bl) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public abstract void setSubtitle(int var1);

    public abstract void setSubtitle(CharSequence var1);

    public abstract void setTitle(int var1);

    public abstract void setTitle(CharSequence var1);

    public void setWindowTitle(CharSequence charSequence) {
    }

    public abstract void show();

    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }
}
