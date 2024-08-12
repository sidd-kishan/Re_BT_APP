/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.widget.TextView
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.AppCompatButton
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.TextViewCompat
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.button.MaterialButtonHelper
 *  com.google.android.material.internal.ThemeEnforcement
 *  com.google.android.material.internal.ViewUtils
 *  com.google.android.material.resources.MaterialResources
 */
package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

public class MaterialButton
extends AppCompatButton {
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    private static final String LOG_TAG = "MaterialButton";
    private Drawable icon;
    private int iconGravity;
    private int iconLeft;
    private int iconPadding;
    private int iconSize;
    private ColorStateList iconTint;
    private PorterDuff.Mode iconTintMode;
    private final MaterialButtonHelper materialButtonHelper;

    public MaterialButton(Context context) {
        this(context, null);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        attributeSet = ThemeEnforcement.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.MaterialButton, (int)n, (int)R.style.Widget_MaterialComponents_Button, (int[])new int[0]);
        this.iconPadding = attributeSet.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ViewUtils.parseTintMode((int)attributeSet.getInt(R.styleable.MaterialButton_iconTintMode, -1), (PorterDuff.Mode)PorterDuff.Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList((Context)this.getContext(), (TypedArray)attributeSet, (int)R.styleable.MaterialButton_iconTint);
        this.icon = MaterialResources.getDrawable((Context)this.getContext(), (TypedArray)attributeSet, (int)R.styleable.MaterialButton_icon);
        this.iconGravity = attributeSet.getInteger(R.styleable.MaterialButton_iconGravity, 1);
        this.iconSize = attributeSet.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
        context = new MaterialButtonHelper(this);
        this.materialButtonHelper = context;
        context.loadFromAttributes((TypedArray)attributeSet);
        attributeSet.recycle();
        this.setCompoundDrawablePadding(this.iconPadding);
        this.updateIcon();
    }

    private boolean isLayoutRTL() {
        int n = ViewCompat.getLayoutDirection((View)this);
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    private boolean isUsingOriginalBackground() {
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        boolean bl = materialButtonHelper != null && !materialButtonHelper.isBackgroundOverwritten();
        return bl;
    }

    private void updateIcon() {
        Drawable drawable = this.icon;
        if (drawable != null) {
            int n;
            this.icon = drawable = drawable.mutate();
            DrawableCompat.setTintList((Drawable)drawable, (ColorStateList)this.iconTint);
            drawable = this.iconTintMode;
            if (drawable != null) {
                DrawableCompat.setTintMode((Drawable)this.icon, (PorterDuff.Mode)drawable);
            }
            if ((n = this.iconSize) == 0) {
                n = this.icon.getIntrinsicWidth();
            }
            int n2 = this.iconSize;
            if (n2 == 0) {
                n2 = this.icon.getIntrinsicHeight();
            }
            drawable = this.icon;
            int n3 = this.iconLeft;
            drawable.setBounds(n3, 0, n + n3, n2);
        }
        TextViewCompat.setCompoundDrawablesRelative((TextView)this, (Drawable)this.icon, null, null, null);
    }

    public ColorStateList getBackgroundTintList() {
        return this.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        int n = this.isUsingOriginalBackground() ? this.materialButtonHelper.getCornerRadius() : 0;
        return n;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public ColorStateList getRippleColor() {
        ColorStateList colorStateList = this.isUsingOriginalBackground() ? this.materialButtonHelper.getRippleColor() : null;
        return colorStateList;
    }

    public ColorStateList getStrokeColor() {
        ColorStateList colorStateList = this.isUsingOriginalBackground() ? this.materialButtonHelper.getStrokeColor() : null;
        return colorStateList;
    }

    public int getStrokeWidth() {
        int n = this.isUsingOriginalBackground() ? this.materialButtonHelper.getStrokeWidth() : 0;
        return n;
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (!this.isUsingOriginalBackground()) return super.getSupportBackgroundTintList();
        return this.materialButtonHelper.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (!this.isUsingOriginalBackground()) return super.getSupportBackgroundTintMode();
        return this.materialButtonHelper.getSupportBackgroundTintMode();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= 21) return;
        if (!this.isUsingOriginalBackground()) return;
        this.materialButtonHelper.drawStroke(canvas);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (Build.VERSION.SDK_INT != 21) return;
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        if (materialButtonHelper == null) return;
        materialButtonHelper.updateMaskBounds(n4 - n2, n3 - n);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        if (this.icon == null) return;
        if (this.iconGravity != 2) return;
        int n3 = (int)this.getPaint().measureText(this.getText().toString());
        n = n2 = this.iconSize;
        if (n2 == 0) {
            n = this.icon.getIntrinsicWidth();
        }
        n = n2 = (this.getMeasuredWidth() - n3 - ViewCompat.getPaddingEnd((View)this) - n - this.iconPadding - ViewCompat.getPaddingStart((View)this)) / 2;
        if (this.isLayoutRTL()) {
            n = -n2;
        }
        if (this.iconLeft == n) return;
        this.iconLeft = n;
        this.updateIcon();
    }

    public void setBackground(Drawable drawable) {
        this.setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int n) {
        if (this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setBackgroundColor(n);
        } else {
            super.setBackgroundColor(n);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.isUsingOriginalBackground()) {
            if (drawable != this.getBackground()) {
                Log.i((String)LOG_TAG, (String)"Setting a custom background is not supported.");
                this.materialButtonHelper.setBackgroundOverwritten();
                super.setBackgroundDrawable(drawable);
            } else {
                this.getBackground().setState(drawable.getState());
            }
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundResource(int n) {
        Drawable drawable = n != 0 ? AppCompatResources.getDrawable((Context)this.getContext(), (int)n) : null;
        this.setBackgroundDrawable(drawable);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int n) {
        if (!this.isUsingOriginalBackground()) return;
        this.materialButtonHelper.setCornerRadius(n);
    }

    public void setCornerRadiusResource(int n) {
        if (!this.isUsingOriginalBackground()) return;
        this.setCornerRadius(this.getResources().getDimensionPixelSize(n));
    }

    public void setIcon(Drawable drawable) {
        if (this.icon == drawable) return;
        this.icon = drawable;
        this.updateIcon();
    }

    public void setIconGravity(int n) {
        this.iconGravity = n;
    }

    public void setIconPadding(int n) {
        if (this.iconPadding == n) return;
        this.iconPadding = n;
        this.setCompoundDrawablePadding(n);
    }

    public void setIconResource(int n) {
        Drawable drawable = n != 0 ? AppCompatResources.getDrawable((Context)this.getContext(), (int)n) : null;
        this.setIcon(drawable);
    }

    public void setIconSize(int n) {
        if (n < 0) throw new IllegalArgumentException("iconSize cannot be less than 0");
        if (this.iconSize == n) return;
        this.iconSize = n;
        this.updateIcon();
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.iconTint == colorStateList) return;
        this.iconTint = colorStateList;
        this.updateIcon();
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode == mode) return;
        this.iconTintMode = mode;
        this.updateIcon();
    }

    public void setIconTintResource(int n) {
        this.setIconTint(AppCompatResources.getColorStateList((Context)this.getContext(), (int)n));
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (!this.isUsingOriginalBackground()) return;
        this.materialButtonHelper.setRippleColor(colorStateList);
    }

    public void setRippleColorResource(int n) {
        if (!this.isUsingOriginalBackground()) return;
        this.setRippleColor(AppCompatResources.getColorStateList((Context)this.getContext(), (int)n));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (!this.isUsingOriginalBackground()) return;
        this.materialButtonHelper.setStrokeColor(colorStateList);
    }

    public void setStrokeColorResource(int n) {
        if (!this.isUsingOriginalBackground()) return;
        this.setStrokeColor(AppCompatResources.getColorStateList((Context)this.getContext(), (int)n));
    }

    public void setStrokeWidth(int n) {
        if (!this.isUsingOriginalBackground()) return;
        this.materialButtonHelper.setStrokeWidth(n);
    }

    public void setStrokeWidthResource(int n) {
        if (!this.isUsingOriginalBackground()) return;
        this.setStrokeWidth(this.getResources().getDimensionPixelSize(n));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintList(colorStateList);
        } else {
            if (this.materialButtonHelper == null) return;
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintMode(mode);
        } else {
            if (this.materialButtonHelper == null) return;
            super.setSupportBackgroundTintMode(mode);
        }
    }
}
