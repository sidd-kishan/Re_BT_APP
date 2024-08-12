/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuView$ItemView
 *  androidx.appcompat.widget.TooltipCompat
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.PointerIconCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.TextViewCompat
 *  com.google.android.material.R$dimen
 *  com.google.android.material.R$drawable
 *  com.google.android.material.R$id
 *  com.google.android.material.R$layout
 */
package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;

public class BottomNavigationItemView
extends FrameLayout
implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = new int[]{0x10100A0};
    public static final int INVALID_ITEM_POSITION = -1;
    private final int defaultMargin;
    private ImageView icon;
    private ColorStateList iconTint;
    private boolean isShifting;
    private MenuItemImpl itemData;
    private int itemPosition = -1;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        attributeSet = this.getResources();
        LayoutInflater.from((Context)context).inflate(R.layout.design_bottom_navigation_item, (ViewGroup)this, true);
        this.setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
        this.defaultMargin = attributeSet.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
        this.icon = (ImageView)this.findViewById(R.id.icon);
        this.smallLabel = (TextView)this.findViewById(R.id.smallLabel);
        this.largeLabel = (TextView)this.findViewById(R.id.largeLabel);
        ViewCompat.setImportantForAccessibility((View)this.smallLabel, (int)2);
        ViewCompat.setImportantForAccessibility((View)this.largeLabel, (int)2);
        this.setFocusable(true);
        this.calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    private void calculateTextScaleFactors(float f, float f2) {
        this.shiftAmount = f - f2;
        this.scaleUpFactor = f2 * 1.0f / f;
        this.scaleDownFactor = f * 1.0f / f2;
    }

    private void setViewLayoutParams(View view, int n, int n2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        layoutParams.topMargin = n;
        layoutParams.gravity = n2;
        view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    private void setViewValues(View view, float f, float f2, int n) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(n);
    }

    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void initialize(MenuItemImpl menuItemImpl, int n) {
        this.itemData = menuItemImpl;
        this.setCheckable(menuItemImpl.isCheckable());
        this.setChecked(menuItemImpl.isChecked());
        this.setEnabled(menuItemImpl.isEnabled());
        this.setIcon(menuItemImpl.getIcon());
        this.setTitle(menuItemImpl.getTitle());
        this.setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty((CharSequence)menuItemImpl.getContentDescription())) {
            this.setContentDescription(menuItemImpl.getContentDescription());
        }
        TooltipCompat.setTooltipText((View)this, (CharSequence)menuItemImpl.getTooltipText());
        n = menuItemImpl.isVisible() ? 0 : 8;
        this.setVisibility(n);
    }

    public int[] onCreateDrawableState(int n) {
        int[] nArray = super.onCreateDrawableState(n + 1);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl == null) return nArray;
        if (!menuItemImpl.isCheckable()) return nArray;
        if (!this.itemData.isChecked()) return nArray;
        BottomNavigationItemView.mergeDrawableStates((int[])nArray, (int[])CHECKED_STATE_SET);
        return nArray;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean bl) {
        this.refreshDrawableState();
    }

    public void setChecked(boolean bl) {
        TextView textView = this.largeLabel;
        textView.setPivotX((float)(textView.getWidth() / 2));
        textView = this.largeLabel;
        textView.setPivotY((float)textView.getBaseline());
        textView = this.smallLabel;
        textView.setPivotX((float)(textView.getWidth() / 2));
        textView = this.smallLabel;
        textView.setPivotY((float)textView.getBaseline());
        int n = this.labelVisibilityMode;
        if (n != -1) {
            if (n != 0) {
                if (n != 1) {
                    if (n == 2) {
                        this.setViewLayoutParams((View)this.icon, this.defaultMargin, 17);
                        this.largeLabel.setVisibility(8);
                        this.smallLabel.setVisibility(8);
                    }
                } else if (bl) {
                    this.setViewLayoutParams((View)this.icon, (int)((float)this.defaultMargin + this.shiftAmount), 49);
                    this.setViewValues((View)this.largeLabel, 1.0f, 1.0f, 0);
                    textView = this.smallLabel;
                    float f = this.scaleUpFactor;
                    this.setViewValues((View)textView, f, f, 4);
                } else {
                    this.setViewLayoutParams((View)this.icon, this.defaultMargin, 49);
                    textView = this.largeLabel;
                    float f = this.scaleDownFactor;
                    this.setViewValues((View)textView, f, f, 4);
                    this.setViewValues((View)this.smallLabel, 1.0f, 1.0f, 0);
                }
            } else {
                if (bl) {
                    this.setViewLayoutParams((View)this.icon, this.defaultMargin, 49);
                    this.setViewValues((View)this.largeLabel, 1.0f, 1.0f, 0);
                } else {
                    this.setViewLayoutParams((View)this.icon, this.defaultMargin, 17);
                    this.setViewValues((View)this.largeLabel, 0.5f, 0.5f, 4);
                }
                this.smallLabel.setVisibility(4);
            }
        } else if (this.isShifting) {
            if (bl) {
                this.setViewLayoutParams((View)this.icon, this.defaultMargin, 49);
                this.setViewValues((View)this.largeLabel, 1.0f, 1.0f, 0);
            } else {
                this.setViewLayoutParams((View)this.icon, this.defaultMargin, 17);
                this.setViewValues((View)this.largeLabel, 0.5f, 0.5f, 4);
            }
            this.smallLabel.setVisibility(4);
        } else if (bl) {
            this.setViewLayoutParams((View)this.icon, (int)((float)this.defaultMargin + this.shiftAmount), 49);
            this.setViewValues((View)this.largeLabel, 1.0f, 1.0f, 0);
            textView = this.smallLabel;
            float f = this.scaleUpFactor;
            this.setViewValues((View)textView, f, f, 4);
        } else {
            this.setViewLayoutParams((View)this.icon, this.defaultMargin, 49);
            textView = this.largeLabel;
            float f = this.scaleDownFactor;
            this.setViewValues((View)textView, f, f, 4);
            this.setViewValues((View)this.smallLabel, 1.0f, 1.0f, 0);
        }
        this.refreshDrawableState();
        this.setSelected(bl);
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        this.smallLabel.setEnabled(bl);
        this.largeLabel.setEnabled(bl);
        this.icon.setEnabled(bl);
        if (bl) {
            ViewCompat.setPointerIcon((View)this, (PointerIconCompat)PointerIconCompat.getSystemIcon((Context)this.getContext(), (int)1002));
        } else {
            ViewCompat.setPointerIcon((View)this, null);
        }
    }

    public void setIcon(Drawable drawable2) {
        Drawable drawable3 = drawable2;
        if (drawable2 != null) {
            drawable3 = drawable2.getConstantState();
            if (drawable3 != null) {
                drawable2 = drawable3.newDrawable();
            }
            drawable3 = DrawableCompat.wrap((Drawable)drawable2).mutate();
            DrawableCompat.setTintList((Drawable)drawable3, (ColorStateList)this.iconTint);
        }
        this.icon.setImageDrawable(drawable3);
    }

    public void setIconSize(int n) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.icon.getLayoutParams();
        layoutParams.width = n;
        layoutParams.height = n;
        this.icon.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.iconTint = colorStateList;
        colorStateList = this.itemData;
        if (colorStateList == null) return;
        this.setIcon(colorStateList.getIcon());
    }

    public void setItemBackground(int n) {
        Drawable drawable2 = n == 0 ? null : ContextCompat.getDrawable((Context)this.getContext(), (int)n);
        this.setItemBackground(drawable2);
    }

    public void setItemBackground(Drawable drawable2) {
        ViewCompat.setBackground((View)this, (Drawable)drawable2);
    }

    public void setItemPosition(int n) {
        this.itemPosition = n;
    }

    public void setLabelVisibilityMode(int n) {
        if (this.labelVisibilityMode == n) return;
        this.labelVisibilityMode = n;
        n = this.itemData != null ? 1 : 0;
        if (n == 0) return;
        this.setChecked(this.itemData.isChecked());
    }

    public void setShifting(boolean bl) {
        if (this.isShifting == bl) return;
        this.isShifting = bl;
        boolean bl2 = this.itemData != null;
        if (!bl2) return;
        this.setChecked(this.itemData.isChecked());
    }

    public void setShortcut(boolean bl, char c) {
    }

    public void setTextAppearanceActive(int n) {
        TextViewCompat.setTextAppearance((TextView)this.largeLabel, (int)n);
        this.calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(int n) {
        TextViewCompat.setTextAppearance((TextView)this.smallLabel, (int)n);
        this.calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) return;
        this.smallLabel.setTextColor(colorStateList);
        this.largeLabel.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null) {
            if (!TextUtils.isEmpty((CharSequence)menuItemImpl.getContentDescription())) return;
        }
        this.setContentDescription(charSequence);
    }

    public boolean showsIcon() {
        return true;
    }
}
