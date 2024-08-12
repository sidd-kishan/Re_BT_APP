/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.appcompat.view.SupportMenuInflater
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.content.ContextCompat
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$color
 *  com.google.android.material.R$dimen
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.bottomnavigation.BottomNavigationMenu
 *  com.google.android.material.bottomnavigation.BottomNavigationMenuView
 *  com.google.android.material.bottomnavigation.BottomNavigationPresenter
 *  com.google.android.material.bottomnavigation.BottomNavigationView$OnNavigationItemReselectedListener
 *  com.google.android.material.bottomnavigation.BottomNavigationView$OnNavigationItemSelectedListener
 *  com.google.android.material.bottomnavigation.BottomNavigationView$SavedState
 *  com.google.android.material.internal.ThemeEnforcement
 */
package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.ThemeEnforcement;

public class BottomNavigationView
extends FrameLayout {
    private static final int MENU_PRESENTER_ID = 1;
    private final MenuBuilder menu;
    private MenuInflater menuInflater;
    private final BottomNavigationMenuView menuView;
    private final BottomNavigationPresenter presenter = new BottomNavigationPresenter();
    private OnNavigationItemReselectedListener reselectedListener;
    private OnNavigationItemSelectedListener selectedListener;

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.menu = new BottomNavigationMenu(context);
        this.menuView = new BottomNavigationMenuView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.menuView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.presenter.setBottomNavigationMenuView(this.menuView);
        this.presenter.setId(1);
        this.menuView.setPresenter(this.presenter);
        this.menu.addMenuPresenter((MenuPresenter)this.presenter);
        this.presenter.initForMenu(this.getContext(), this.menu);
        TintTypedArray tintTypedArray = ThemeEnforcement.obtainTintedStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.BottomNavigationView, (int)n, (int)R.style.Widget_Design_BottomNavigationView, (int[])new int[]{R.styleable.BottomNavigationView_itemTextAppearanceInactive, R.styleable.BottomNavigationView_itemTextAppearanceActive});
        if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_itemIconTint)) {
            this.menuView.setIconTintList(tintTypedArray.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
        } else {
            attributeSet = this.menuView;
            attributeSet.setIconTintList(attributeSet.createDefaultColorStateList(16842808));
        }
        this.setItemIconSize(tintTypedArray.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, this.getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceInactive)) {
            this.setItemTextAppearanceInactive(tintTypedArray.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceActive)) {
            this.setItemTextAppearanceActive(tintTypedArray.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_itemTextColor)) {
            this.setItemTextColor(tintTypedArray.getColorStateList(R.styleable.BottomNavigationView_itemTextColor));
        }
        if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_elevation)) {
            ViewCompat.setElevation((View)this, (float)tintTypedArray.getDimensionPixelSize(R.styleable.BottomNavigationView_elevation, 0));
        }
        this.setLabelVisibilityMode(tintTypedArray.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
        this.setItemHorizontalTranslationEnabled(tintTypedArray.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        n = tintTypedArray.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
        this.menuView.setItemBackgroundRes(n);
        if (tintTypedArray.hasValue(R.styleable.BottomNavigationView_menu)) {
            this.inflateMenu(tintTypedArray.getResourceId(R.styleable.BottomNavigationView_menu, 0));
        }
        tintTypedArray.recycle();
        this.addView((View)this.menuView, (ViewGroup.LayoutParams)layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            this.addCompatibilityTopDivider(context);
        }
        this.menu.setCallback((MenuBuilder.Callback)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ OnNavigationItemReselectedListener access$000(BottomNavigationView bottomNavigationView) {
        return bottomNavigationView.reselectedListener;
    }

    static /* synthetic */ OnNavigationItemSelectedListener access$100(BottomNavigationView bottomNavigationView) {
        return bottomNavigationView.selectedListener;
    }

    private void addCompatibilityTopDivider(Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor((Context)context, (int)R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, this.getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        this.addView(view);
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) return this.menuInflater;
        this.menuInflater = new SupportMenuInflater(this.getContext());
        return this.menuInflater;
    }

    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int n) {
        this.presenter.setUpdateSuspended(true);
        this.getMenuInflater().inflate(n, (Menu)this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.menuView.isItemHorizontalTranslationEnabled();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        this.menu.restorePresenterStates(parcelable.menuPresenterState);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuPresenterState = new Bundle();
        this.menu.savePresenterStates(savedState.menuPresenterState);
        return savedState;
    }

    public void setItemBackground(Drawable drawable) {
        this.menuView.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int n) {
        this.menuView.setItemBackgroundRes(n);
    }

    public void setItemHorizontalTranslationEnabled(boolean bl) {
        if (this.menuView.isItemHorizontalTranslationEnabled() == bl) return;
        this.menuView.setItemHorizontalTranslationEnabled(bl);
        this.presenter.updateMenuView(false);
    }

    public void setItemIconSize(int n) {
        this.menuView.setItemIconSize(n);
    }

    public void setItemIconSizeRes(int n) {
        this.setItemIconSize(this.getResources().getDimensionPixelSize(n));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.menuView.setIconTintList(colorStateList);
    }

    public void setItemTextAppearanceActive(int n) {
        this.menuView.setItemTextAppearanceActive(n);
    }

    public void setItemTextAppearanceInactive(int n) {
        this.menuView.setItemTextAppearanceInactive(n);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.menuView.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int n) {
        if (this.menuView.getLabelVisibilityMode() == n) return;
        this.menuView.setLabelVisibilityMode(n);
        this.presenter.updateMenuView(false);
    }

    public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        this.reselectedListener = onNavigationItemReselectedListener;
    }

    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.selectedListener = onNavigationItemSelectedListener;
    }

    public void setSelectedItemId(int n) {
        MenuItem menuItem = this.menu.findItem(n);
        if (menuItem == null) return;
        if (this.menu.performItemAction(menuItem, (MenuPresenter)this.presenter, 0)) return;
        menuItem.setChecked(true);
    }
}
