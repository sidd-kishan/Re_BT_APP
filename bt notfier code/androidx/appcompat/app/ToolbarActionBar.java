/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window$Callback
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.SpinnerAdapter
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.app.ActionBar$LayoutParams
 *  androidx.appcompat.app.ActionBar$OnMenuVisibilityListener
 *  androidx.appcompat.app.ActionBar$OnNavigationListener
 *  androidx.appcompat.app.ActionBar$Tab
 *  androidx.appcompat.app.NavItemSelectedListener
 *  androidx.appcompat.app.ToolbarActionBar$ActionMenuPresenterCallback
 *  androidx.appcompat.app.ToolbarActionBar$MenuBuilderCallback
 *  androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.widget.DecorToolbar
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.Toolbar$OnMenuItemClickListener
 *  androidx.appcompat.widget.ToolbarWidgetWrapper
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.NavItemSelectedListener;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class ToolbarActionBar
extends ActionBar {
    DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    private boolean mMenuCallbackSet;
    private final Toolbar.OnMenuItemClickListener mMenuClicker;
    private final Runnable mMenuInvalidator;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
    boolean mToolbarMenuPrepared;
    Window.Callback mWindowCallback;

    ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.mMenuInvalidator = new /* Unavailable Anonymous Inner Class!! */;
        this.mMenuClicker = new /* Unavailable Anonymous Inner Class!! */;
        this.mDecorToolbar = new ToolbarWidgetWrapper(toolbar, false);
        this.mWindowCallback = callback = new ToolbarCallbackWrapper(this, callback);
        this.mDecorToolbar.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(this.mMenuClicker);
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    private Menu getMenu() {
        if (this.mMenuCallbackSet) return this.mDecorToolbar.getMenu();
        this.mDecorToolbar.setMenuCallbacks((MenuPresenter.Callback)new ActionMenuPresenterCallback(this), (MenuBuilder.Callback)new MenuBuilderCallback(this));
        this.mMenuCallbackSet = true;
        return this.mDecorToolbar.getMenu();
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, int n) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, int n, boolean bl) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, boolean bl) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean closeOptionsMenu() {
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public boolean collapseActionView() {
        if (!this.mDecorToolbar.hasExpandedActionView()) return false;
        this.mDecorToolbar.collapseActionView();
        return true;
    }

    public void dispatchMenuVisibilityChanged(boolean bl) {
        if (bl == this.mLastMenuVisibility) {
            return;
        }
        this.mLastMenuVisibility = bl;
        int n = this.mMenuVisibilityListeners.size();
        int n2 = 0;
        while (n2 < n) {
            this.mMenuVisibilityListeners.get(n2).onMenuVisibilityChanged(bl);
            ++n2;
        }
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation((View)this.mDecorToolbar.getViewGroup());
    }

    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public int getNavigationMode() {
        return 0;
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int n) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public int getTabCount() {
        return 0;
    }

    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public Window.Callback getWrappedWindowCallback() {
        return this.mWindowCallback;
    }

    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }

    public boolean invalidateOptionsMenu() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation((View)this.mDecorToolbar.getViewGroup(), (Runnable)this.mMenuInvalidator);
        return true;
    }

    public boolean isShowing() {
        boolean bl = this.mDecorToolbar.getVisibility() == 0;
        return bl;
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    void onDestroy() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }

    public boolean onKeyShortcut(int n, KeyEvent keyEvent) {
        Menu menu = this.getMenu();
        if (menu == null) return false;
        int n2 = keyEvent != null ? keyEvent.getDeviceId() : -1;
        n2 = KeyCharacterMap.load((int)n2).getKeyboardType();
        boolean bl = true;
        if (n2 == 1) {
            bl = false;
        }
        menu.setQwertyMode(bl);
        return menu.performShortcut(n, keyEvent, 0);
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1) return true;
        this.openOptionsMenu();
        return true;
    }

    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    void populateOptionsMenu() {
        Menu menu = this.getMenu();
        MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder)menu : null;
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        try {
            menu.clear();
            if (this.mWindowCallback.onCreatePanelMenu(0, menu)) {
                if (this.mWindowCallback.onPreparePanel(0, null, menu)) return;
            }
            menu.clear();
            return;
        }
        finally {
            if (menuBuilder != null) {
                menuBuilder.startDispatchingItemsChanged();
            }
        }
    }

    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTabAt(int n) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup == null) return false;
        if (viewGroup.hasFocus()) return false;
        viewGroup.requestFocus();
        return true;
    }

    public void selectTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mDecorToolbar.setBackgroundDrawable(drawable);
    }

    public void setCustomView(int n) {
        this.setCustomView(LayoutInflater.from((Context)this.mDecorToolbar.getContext()).inflate(n, this.mDecorToolbar.getViewGroup(), false));
    }

    public void setCustomView(View view) {
        this.setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
        this.mDecorToolbar.setCustomView(view);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean bl) {
    }

    public void setDisplayHomeAsUpEnabled(boolean bl) {
        int n = bl ? 4 : 0;
        this.setDisplayOptions(n, 4);
    }

    public void setDisplayOptions(int n) {
        this.setDisplayOptions(n, -1);
    }

    public void setDisplayOptions(int n, int n2) {
        int n3 = this.mDecorToolbar.getDisplayOptions();
        this.mDecorToolbar.setDisplayOptions(n & n2 | ~n2 & n3);
    }

    public void setDisplayShowCustomEnabled(boolean bl) {
        int n = bl ? 16 : 0;
        this.setDisplayOptions(n, 16);
    }

    public void setDisplayShowHomeEnabled(boolean bl) {
        int n = bl ? 2 : 0;
        this.setDisplayOptions(n, 2);
    }

    public void setDisplayShowTitleEnabled(boolean bl) {
        int n = bl ? 8 : 0;
        this.setDisplayOptions(n, 8);
    }

    public void setDisplayUseLogoEnabled(boolean bl) {
        this.setDisplayOptions(bl ? 1 : 0, 1);
    }

    public void setElevation(float f) {
        ViewCompat.setElevation((View)this.mDecorToolbar.getViewGroup(), (float)f);
    }

    public void setHomeActionContentDescription(int n) {
        this.mDecorToolbar.setNavigationContentDescription(n);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(int n) {
        this.mDecorToolbar.setNavigationIcon(n);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean bl) {
    }

    public void setIcon(int n) {
        this.mDecorToolbar.setIcon(n);
    }

    public void setIcon(Drawable drawable) {
        this.mDecorToolbar.setIcon(drawable);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.mDecorToolbar.setDropdownParams(spinnerAdapter, (AdapterView.OnItemSelectedListener)new NavItemSelectedListener(onNavigationListener));
    }

    public void setLogo(int n) {
        this.mDecorToolbar.setLogo(n);
    }

    public void setLogo(Drawable drawable) {
        this.mDecorToolbar.setLogo(drawable);
    }

    public void setNavigationMode(int n) {
        if (n == 2) throw new IllegalArgumentException("Tabs not supported in this configuration");
        this.mDecorToolbar.setNavigationMode(n);
    }

    public void setSelectedNavigationItem(int n) {
        if (this.mDecorToolbar.getNavigationMode() != 1) throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        this.mDecorToolbar.setDropdownSelectedPosition(n);
    }

    public void setShowHideAnimationEnabled(boolean bl) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public void setSubtitle(int n) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        CharSequence charSequence = n != 0 ? decorToolbar.getContext().getText(n) : null;
        decorToolbar.setSubtitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setTitle(int n) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        CharSequence charSequence = n != 0 ? decorToolbar.getContext().getText(n) : null;
        decorToolbar.setTitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }
}
