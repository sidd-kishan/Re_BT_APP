/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.R$style
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.appcompat.view.menu.ListMenuPresenter
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.MenuView
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;

protected static final class AppCompatDelegateImpl.PanelFeatureState {
    int background;
    View createdPanelView;
    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    Bundle frozenMenuState;
    int gravity;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    ListMenuPresenter listMenuPresenter;
    Context listPresenterContext;
    MenuBuilder menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    boolean wasLastOpen;
    int windowAnimations;
    int x;
    int y;

    AppCompatDelegateImpl.PanelFeatureState(int n) {
        this.featureId = n;
        this.refreshDecorView = false;
    }

    void applyFrozenState() {
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder == null) return;
        Bundle bundle = this.frozenMenuState;
        if (bundle == null) return;
        menuBuilder.restorePresenterStates(bundle);
        this.frozenMenuState = null;
    }

    public void clearMenuPresenters() {
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder != null) {
            menuBuilder.removeMenuPresenter((MenuPresenter)this.listMenuPresenter);
        }
        this.listMenuPresenter = null;
    }

    MenuView getListMenuView(MenuPresenter.Callback callback) {
        ListMenuPresenter listMenuPresenter;
        if (this.menu == null) {
            return null;
        }
        if (this.listMenuPresenter != null) return this.listMenuPresenter.getMenuView(this.decorView);
        this.listMenuPresenter = listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
        listMenuPresenter.setCallback(callback);
        this.menu.addMenuPresenter((MenuPresenter)this.listMenuPresenter);
        return this.listMenuPresenter.getMenuView(this.decorView);
    }

    public boolean hasPanelItems() {
        View view = this.shownPanelView;
        boolean bl = false;
        if (view == null) {
            return false;
        }
        if (this.createdPanelView != null) {
            return true;
        }
        if (this.listMenuPresenter.getAdapter().getCount() <= 0) return bl;
        bl = true;
        return bl;
    }

    void onRestoreInstanceState(Parcelable parcelable) {
        parcelable = (SavedState)parcelable;
        this.featureId = parcelable.featureId;
        this.wasLastOpen = parcelable.isOpen;
        this.frozenMenuState = parcelable.menuState;
        this.shownPanelView = null;
        this.decorView = null;
    }

    Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.featureId = this.featureId;
        savedState.isOpen = this.isOpen;
        if (this.menu == null) return savedState;
        savedState.menuState = new Bundle();
        this.menu.savePresenterStates(savedState.menuState);
        return savedState;
    }

    void setMenu(MenuBuilder menuBuilder) {
        MenuBuilder menuBuilder2 = this.menu;
        if (menuBuilder == menuBuilder2) {
            return;
        }
        if (menuBuilder2 != null) {
            menuBuilder2.removeMenuPresenter((MenuPresenter)this.listMenuPresenter);
        }
        this.menu = menuBuilder;
        if (menuBuilder == null) return;
        menuBuilder2 = this.listMenuPresenter;
        if (menuBuilder2 == null) return;
        menuBuilder.addMenuPresenter((MenuPresenter)menuBuilder2);
    }

    void setStyle(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getResources().newTheme();
        theme.setTo(context.getTheme());
        theme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            theme.applyStyle(typedValue.resourceId, true);
        }
        theme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            theme.applyStyle(typedValue.resourceId, true);
        } else {
            theme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
        }
        context = new ContextThemeWrapper(context, 0);
        context.getTheme().setTo(theme);
        this.listPresenterContext = context;
        context = context.obtainStyledAttributes(R.styleable.AppCompatTheme);
        this.background = context.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
        this.windowAnimations = context.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
        context.recycle();
    }
}
