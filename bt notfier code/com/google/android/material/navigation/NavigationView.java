/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.view.SupportMenuInflater
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.content.ContextCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.internal.NavigationMenu
 *  com.google.android.material.internal.NavigationMenuPresenter
 *  com.google.android.material.internal.ScrimInsetsFrameLayout
 *  com.google.android.material.internal.ThemeEnforcement
 *  com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener
 *  com.google.android.material.navigation.NavigationView$SavedState
 */
package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.navigation.NavigationView;

public class NavigationView
extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = new int[]{0x10100A0};
    private static final int[] DISABLED_STATE_SET = new int[]{-16842910};
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private final NavigationMenuPresenter presenter = new NavigationMenuPresenter();

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        int n2;
        int n3;
        this.menu = new NavigationMenu(context);
        TintTypedArray tintTypedArray = ThemeEnforcement.obtainTintedStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.NavigationView, (int)n, (int)R.style.Widget_Design_NavigationView, (int[])new int[0]);
        ViewCompat.setBackground((View)this, (Drawable)tintTypedArray.getDrawable(R.styleable.NavigationView_android_background));
        if (tintTypedArray.hasValue(R.styleable.NavigationView_elevation)) {
            ViewCompat.setElevation((View)this, (float)tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_elevation, 0));
        }
        ViewCompat.setFitsSystemWindows((View)this, (boolean)tintTypedArray.getBoolean(R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_android_maxWidth, 0);
        ColorStateList colorStateList = tintTypedArray.hasValue(R.styleable.NavigationView_itemIconTint) ? tintTypedArray.getColorStateList(R.styleable.NavigationView_itemIconTint) : this.createDefaultColorStateList(16842808);
        if (tintTypedArray.hasValue(R.styleable.NavigationView_itemTextAppearance)) {
            n3 = tintTypedArray.getResourceId(R.styleable.NavigationView_itemTextAppearance, 0);
            n = 1;
        } else {
            n3 = 0;
            n = 0;
        }
        attributeSet = null;
        if (tintTypedArray.hasValue(R.styleable.NavigationView_itemTextColor)) {
            attributeSet = tintTypedArray.getColorStateList(R.styleable.NavigationView_itemTextColor);
        }
        AttributeSet attributeSet2 = attributeSet;
        if (n == 0) {
            attributeSet2 = attributeSet;
            if (attributeSet == null) {
                attributeSet2 = this.createDefaultColorStateList(16842806);
            }
        }
        attributeSet = tintTypedArray.getDrawable(R.styleable.NavigationView_itemBackground);
        if (tintTypedArray.hasValue(R.styleable.NavigationView_itemHorizontalPadding)) {
            n2 = tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemHorizontalPadding, 0);
            this.presenter.setItemHorizontalPadding(n2);
        }
        n2 = tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemIconPadding, 0);
        this.menu.setCallback((MenuBuilder.Callback)new /* Unavailable Anonymous Inner Class!! */);
        this.presenter.setId(1);
        this.presenter.initForMenu(context, (MenuBuilder)this.menu);
        this.presenter.setItemIconTintList(colorStateList);
        if (n != 0) {
            this.presenter.setItemTextAppearance(n3);
        }
        this.presenter.setItemTextColor((ColorStateList)attributeSet2);
        this.presenter.setItemBackground((Drawable)attributeSet);
        this.presenter.setItemIconPadding(n2);
        this.menu.addMenuPresenter((MenuPresenter)this.presenter);
        this.addView((View)this.presenter.getMenuView((ViewGroup)this));
        if (tintTypedArray.hasValue(R.styleable.NavigationView_menu)) {
            this.inflateMenu(tintTypedArray.getResourceId(R.styleable.NavigationView_menu, 0));
        }
        if (tintTypedArray.hasValue(R.styleable.NavigationView_headerLayout)) {
            this.inflateHeaderView(tintTypedArray.getResourceId(R.styleable.NavigationView_headerLayout, 0));
        }
        tintTypedArray.recycle();
    }

    private ColorStateList createDefaultColorStateList(int n) {
        Object object = new TypedValue();
        if (!this.getContext().getTheme().resolveAttribute(n, (TypedValue)object, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList((Context)this.getContext(), (int)((TypedValue)object).resourceId);
        if (!this.getContext().getTheme().resolveAttribute(R.attr.colorPrimary, (TypedValue)object, true)) {
            return null;
        }
        n = ((TypedValue)object).data;
        int n2 = colorStateList.getDefaultColor();
        int[] nArray = DISABLED_STATE_SET;
        object = CHECKED_STATE_SET;
        int[] nArray2 = EMPTY_STATE_SET;
        int n3 = colorStateList.getColorForState(DISABLED_STATE_SET, n2);
        return new ColorStateList((int[][])new int[][]{nArray, (int[])object, nArray2}, new int[]{n3, n, n2});
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) return this.menuInflater;
        this.menuInflater = new SupportMenuInflater(this.getContext());
        return this.menuInflater;
    }

    public void addHeaderView(View view) {
        this.presenter.addHeaderView(view);
    }

    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int n) {
        return this.presenter.getHeaderView(n);
    }

    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(int n) {
        return this.presenter.inflateHeaderView(n);
    }

    public void inflateMenu(int n) {
        this.presenter.setUpdateSuspended(true);
        this.getMenuInflater().inflate(n, (Menu)this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    protected void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
        this.presenter.dispatchApplyWindowInsets(windowInsetsCompat);
    }

    protected void onMeasure(int n, int n2) {
        int n3 = View.MeasureSpec.getMode((int)n);
        if (n3 != Integer.MIN_VALUE) {
            if (n3 == 0) {
                n = View.MeasureSpec.makeMeasureSpec((int)this.maxWidth, (int)0x40000000);
            }
        } else {
            n = View.MeasureSpec.makeMeasureSpec((int)Math.min(View.MeasureSpec.getSize((int)n), this.maxWidth), (int)0x40000000);
        }
        super.onMeasure(n, n2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        this.menu.restorePresenterStates(parcelable.menuState);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuState = new Bundle();
        this.menu.savePresenterStates(savedState.menuState);
        return savedState;
    }

    public void removeHeaderView(View view) {
        this.presenter.removeHeaderView(view);
    }

    public void setCheckedItem(int n) {
        MenuItem menuItem = this.menu.findItem(n);
        if (menuItem == null) return;
        this.presenter.setCheckedItem((MenuItemImpl)menuItem);
    }

    public void setCheckedItem(MenuItem menuItem) {
        if ((menuItem = this.menu.findItem(menuItem.getItemId())) == null) throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
        this.presenter.setCheckedItem((MenuItemImpl)menuItem);
    }

    public void setItemBackground(Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int n) {
        this.setItemBackground(ContextCompat.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setItemHorizontalPadding(int n) {
        this.presenter.setItemHorizontalPadding(n);
    }

    public void setItemHorizontalPaddingResource(int n) {
        this.presenter.setItemHorizontalPadding(this.getResources().getDimensionPixelSize(n));
    }

    public void setItemIconPadding(int n) {
        this.presenter.setItemIconPadding(n);
    }

    public void setItemIconPaddingResource(int n) {
        this.presenter.setItemIconPadding(this.getResources().getDimensionPixelSize(n));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public void setItemTextAppearance(int n) {
        this.presenter.setItemTextAppearance(n);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }
}
