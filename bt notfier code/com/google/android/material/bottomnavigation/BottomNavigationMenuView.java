/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuView
 *  androidx.core.util.Pools$Pool
 *  androidx.core.util.Pools$SynchronizedPool
 *  androidx.core.view.ViewCompat
 *  androidx.interpolator.view.animation.FastOutSlowInInterpolator
 *  androidx.transition.AutoTransition
 *  androidx.transition.Transition
 *  androidx.transition.TransitionManager
 *  androidx.transition.TransitionSet
 *  com.google.android.material.R$dimen
 *  com.google.android.material.bottomnavigation.BottomNavigationItemView
 *  com.google.android.material.bottomnavigation.BottomNavigationPresenter
 *  com.google.android.material.internal.TextScale
 */
package com.google.android.material.bottomnavigation;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;
import com.google.android.material.internal.TextScale;

public class BottomNavigationMenuView
extends ViewGroup
implements MenuView {
    private static final long ACTIVE_ANIMATION_DURATION_MS = 115L;
    private static final int[] CHECKED_STATE_SET = new int[]{0x10100A0};
    private static final int[] DISABLED_STATE_SET = new int[]{-16842910};
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private BottomNavigationItemView[] buttons;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private final Pools.Pool<BottomNavigationItemView> itemPool = new Pools.SynchronizedPool(5);
    private int itemTextAppearanceActive;
    private int itemTextAppearanceInactive;
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;
    private final View.OnClickListener onClickListener;
    private BottomNavigationPresenter presenter;
    private int selectedItemId = 0;
    private int selectedItemPosition = 0;
    private final TransitionSet set;
    private int[] tempChildWidths;

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = this.getResources();
        this.inactiveItemMaxWidth = context.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = context.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = context.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = context.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = context.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        this.itemTextColorDefault = this.createDefaultColorStateList(16842808);
        context = new AutoTransition();
        this.set = context;
        context.setOrdering(0);
        this.set.setDuration(115L);
        this.set.setInterpolator((TimeInterpolator)new FastOutSlowInInterpolator());
        this.set.addTransition((Transition)new TextScale());
        this.onClickListener = new /* Unavailable Anonymous Inner Class!! */;
        this.tempChildWidths = new int[5];
    }

    static /* synthetic */ BottomNavigationPresenter access$000(BottomNavigationMenuView bottomNavigationMenuView) {
        return bottomNavigationMenuView.presenter;
    }

    static /* synthetic */ MenuBuilder access$100(BottomNavigationMenuView bottomNavigationMenuView) {
        return bottomNavigationMenuView.menu;
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemView;
        BottomNavigationItemView bottomNavigationItemView2 = bottomNavigationItemView = (BottomNavigationItemView)this.itemPool.acquire();
        if (bottomNavigationItemView != null) return bottomNavigationItemView2;
        bottomNavigationItemView2 = new BottomNavigationItemView(this.getContext());
        return bottomNavigationItemView2;
    }

    private boolean isShifting(int n, int n2) {
        boolean bl = true;
        if (n == -1 ? n2 > 3 : n == 0) return bl;
        bl = false;
        return bl;
    }

    public void buildMenuView() {
        this.removeAllViews();
        Drawable drawable = this.buttons;
        if (drawable != null) {
            for (BottomNavigationItemView bottomNavigationItemView : drawable) {
                if (bottomNavigationItemView == null) continue;
                this.itemPool.release((Object)bottomNavigationItemView);
            }
        }
        if (this.menu.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
        this.buttons = new BottomNavigationItemView[this.menu.size()];
        boolean bl = this.isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int n = 0;
        while (true) {
            BottomNavigationItemView bottomNavigationItemView;
            if (n >= this.menu.size()) {
                this.selectedItemPosition = n = Math.min(this.menu.size() - 1, this.selectedItemPosition);
                this.menu.getItem(n).setChecked(true);
                return;
            }
            this.presenter.setUpdateSuspended(true);
            this.menu.getItem(n).setCheckable(true);
            this.presenter.setUpdateSuspended(false);
            this.buttons[n] = bottomNavigationItemView = this.getNewItem();
            bottomNavigationItemView.setIconTintList(this.itemIconTint);
            bottomNavigationItemView.setIconSize(this.itemIconSize);
            bottomNavigationItemView.setTextColor(this.itemTextColorDefault);
            bottomNavigationItemView.setTextAppearanceInactive(this.itemTextAppearanceInactive);
            bottomNavigationItemView.setTextAppearanceActive(this.itemTextAppearanceActive);
            bottomNavigationItemView.setTextColor(this.itemTextColorFromUser);
            drawable = this.itemBackground;
            if (drawable != null) {
                bottomNavigationItemView.setItemBackground(drawable);
            } else {
                bottomNavigationItemView.setItemBackground(this.itemBackgroundRes);
            }
            bottomNavigationItemView.setShifting(bl);
            bottomNavigationItemView.setLabelVisibilityMode(this.labelVisibilityMode);
            bottomNavigationItemView.initialize((MenuItemImpl)this.menu.getItem(n), 0);
            bottomNavigationItemView.setItemPosition(n);
            bottomNavigationItemView.setOnClickListener(this.onClickListener);
            this.addView((View)bottomNavigationItemView);
            ++n;
        }
    }

    public ColorStateList createDefaultColorStateList(int n) {
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
        int[] nArray2 = CHECKED_STATE_SET;
        object = EMPTY_STATE_SET;
        int n3 = colorStateList.getColorForState(DISABLED_STATE_SET, n2);
        return new ColorStateList((int[][])new int[][]{nArray, nArray2, (int[])object}, new int[]{n3, n, n2});
    }

    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray == null) return this.itemBackground;
        if (bottomNavigationItemViewArray.length <= 0) return this.itemBackground;
        return bottomNavigationItemViewArray[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    public int getItemIconSize() {
        return this.itemIconSize;
    }

    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        int n5 = this.getChildCount();
        int n6 = n4 - n2;
        n2 = 0;
        n4 = 0;
        while (n2 < n5) {
            View view = this.getChildAt(n2);
            if (view.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection((View)this) == 1) {
                    int n7 = n3 - n - n4;
                    view.layout(n7 - view.getMeasuredWidth(), 0, n7, n6);
                } else {
                    view.layout(n4, 0, view.getMeasuredWidth() + n4, n6);
                }
                n4 += view.getMeasuredWidth();
            }
            ++n2;
        }
    }

    protected void onMeasure(int n, int n2) {
        Object object;
        int n3;
        int n4;
        block14: {
            int n5;
            int n6;
            block13: {
                int n7;
                block12: {
                    n7 = View.MeasureSpec.getSize((int)n);
                    n6 = this.menu.getVisibleItems().size();
                    n4 = this.getChildCount();
                    n3 = View.MeasureSpec.makeMeasureSpec((int)this.itemHeight, (int)0x40000000);
                    if (this.isShifting(this.labelVisibilityMode, n6) && this.itemHorizontalTranslationEnabled) break block12;
                    n = n6 == 0 ? 1 : n6;
                    n5 = Math.min(n7 / n, this.activeItemMaxWidth);
                    n2 = n7 - n6 * n5;
                    break block13;
                }
                object = this.getChildAt(this.selectedItemPosition);
                n = n2 = this.activeItemMinWidth;
                if (object.getVisibility() != 8) {
                    object.measure(View.MeasureSpec.makeMeasureSpec((int)this.activeItemMaxWidth, (int)Integer.MIN_VALUE), n3);
                    n = Math.max(n2, object.getMeasuredWidth());
                }
                n2 = object.getVisibility() != 8 ? 1 : 0;
                n2 = n6 - n2;
                n5 = Math.min(n7 - this.inactiveItemMinWidth * n2, Math.min(n, this.activeItemMaxWidth));
                n6 = n7 - n5;
                n = n2 == 0 ? 1 : n2;
                n7 = Math.min(n6 / n, this.inactiveItemMaxWidth);
                n2 = n6 - n2 * n7;
                for (n = 0; n < n4; ++n) {
                    if (this.getChildAt(n).getVisibility() != 8) {
                        object = this.tempChildWidths;
                        n6 = n == this.selectedItemPosition ? n5 : n7;
                        object[n] = (View)n6;
                        n6 = n2;
                        if (n2 > 0) {
                            object = this.tempChildWidths;
                            object[n] = object[n] + true;
                            n6 = n2 - 1;
                        }
                    } else {
                        this.tempChildWidths[n] = 0;
                        n6 = n2;
                    }
                    n2 = n6;
                }
                break block14;
            }
            for (n = 0; n < n4; ++n) {
                if (this.getChildAt(n).getVisibility() != 8) {
                    object = this.tempChildWidths;
                    object[n] = (View)n5;
                    n6 = n2;
                    if (n2 > 0) {
                        object[n] = object[n] + true;
                        n6 = n2 - 1;
                    }
                } else {
                    this.tempChildWidths[n] = 0;
                    n6 = n2;
                }
                n2 = n6;
            }
        }
        n = 0;
        n2 = 0;
        while (true) {
            if (n >= n4) {
                this.setMeasuredDimension(View.resolveSizeAndState((int)n2, (int)View.MeasureSpec.makeMeasureSpec((int)n2, (int)0x40000000), (int)0), View.resolveSizeAndState((int)this.itemHeight, (int)n3, (int)0));
                return;
            }
            object = this.getChildAt(n);
            if (object.getVisibility() != 8) {
                object.measure(View.MeasureSpec.makeMeasureSpec((int)this.tempChildWidths[n], (int)0x40000000), n3);
                object.getLayoutParams().width = object.getMeasuredWidth();
                n2 += object.getMeasuredWidth();
            }
            ++n;
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray == null) return;
        int n = bottomNavigationItemViewArray.length;
        int n2 = 0;
        while (n2 < n) {
            bottomNavigationItemViewArray[n2].setIconTintList(colorStateList);
            ++n2;
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.itemBackground = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray == null) return;
        int n = bottomNavigationItemViewArray.length;
        int n2 = 0;
        while (n2 < n) {
            bottomNavigationItemViewArray[n2].setItemBackground(drawable);
            ++n2;
        }
    }

    public void setItemBackgroundRes(int n) {
        this.itemBackgroundRes = n;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray == null) return;
        int n2 = bottomNavigationItemViewArray.length;
        int n3 = 0;
        while (n3 < n2) {
            bottomNavigationItemViewArray[n3].setItemBackground(n);
            ++n3;
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean bl) {
        this.itemHorizontalTranslationEnabled = bl;
    }

    public void setItemIconSize(int n) {
        this.itemIconSize = n;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray == null) return;
        int n2 = bottomNavigationItemViewArray.length;
        int n3 = 0;
        while (n3 < n2) {
            bottomNavigationItemViewArray[n3].setIconSize(n);
            ++n3;
        }
    }

    public void setItemTextAppearanceActive(int n) {
        this.itemTextAppearanceActive = n;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray == null) return;
        int n2 = bottomNavigationItemViewArray.length;
        int n3 = 0;
        while (n3 < n2) {
            BottomNavigationItemView bottomNavigationItemView = bottomNavigationItemViewArray[n3];
            bottomNavigationItemView.setTextAppearanceActive(n);
            ColorStateList colorStateList = this.itemTextColorFromUser;
            if (colorStateList != null) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
            ++n3;
        }
    }

    public void setItemTextAppearanceInactive(int n) {
        this.itemTextAppearanceInactive = n;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray == null) return;
        int n2 = bottomNavigationItemViewArray.length;
        int n3 = 0;
        while (n3 < n2) {
            BottomNavigationItemView bottomNavigationItemView = bottomNavigationItemViewArray[n3];
            bottomNavigationItemView.setTextAppearanceInactive(n);
            ColorStateList colorStateList = this.itemTextColorFromUser;
            if (colorStateList != null) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
            ++n3;
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray == null) return;
        int n = bottomNavigationItemViewArray.length;
        int n2 = 0;
        while (n2 < n) {
            bottomNavigationItemViewArray[n2].setTextColor(colorStateList);
            ++n2;
        }
    }

    public void setLabelVisibilityMode(int n) {
        this.labelVisibilityMode = n;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.presenter = bottomNavigationPresenter;
    }

    void tryRestoreSelectedItemId(int n) {
        int n2 = this.menu.size();
        int n3 = 0;
        while (n3 < n2) {
            MenuItem menuItem = this.menu.getItem(n3);
            if (n == menuItem.getItemId()) {
                this.selectedItemId = n;
                this.selectedItemPosition = n3;
                menuItem.setChecked(true);
                return;
            }
            ++n3;
        }
    }

    public void updateMenuView() {
        int n;
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder == null) return;
        if (this.buttons == null) {
            return;
        }
        int n2 = menuBuilder.size();
        if (n2 != this.buttons.length) {
            this.buildMenuView();
            return;
        }
        int n3 = this.selectedItemId;
        for (n = 0; n < n2; ++n) {
            menuBuilder = this.menu.getItem(n);
            if (!menuBuilder.isChecked()) continue;
            this.selectedItemId = menuBuilder.getItemId();
            this.selectedItemPosition = n;
        }
        if (n3 != this.selectedItemId) {
            TransitionManager.beginDelayedTransition((ViewGroup)this, (Transition)this.set);
        }
        boolean bl = this.isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        n = 0;
        while (n < n2) {
            this.presenter.setUpdateSuspended(true);
            this.buttons[n].setLabelVisibilityMode(this.labelVisibilityMode);
            this.buttons[n].setShifting(bl);
            this.buttons[n].initialize((MenuItemImpl)this.menu.getItem(n), 0);
            this.presenter.setUpdateSuspended(false);
            ++n;
        }
    }
}
