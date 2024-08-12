/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.CompoundButton
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.DrawableUtils
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.CompoundButtonCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList = null;
    private PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;
    private final CompoundButton mView;

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    void applyButtonTint() {
        Drawable drawable = CompoundButtonCompat.getButtonDrawable((CompoundButton)this.mView);
        if (drawable == null) return;
        if (!this.mHasButtonTint) {
            if (!this.mHasButtonTintMode) return;
        }
        drawable = DrawableCompat.wrap((Drawable)drawable).mutate();
        if (this.mHasButtonTint) {
            DrawableCompat.setTintList((Drawable)drawable, (ColorStateList)this.mButtonTintList);
        }
        if (this.mHasButtonTintMode) {
            DrawableCompat.setTintMode((Drawable)drawable, (PorterDuff.Mode)this.mButtonTintMode);
        }
        if (drawable.isStateful()) {
            drawable.setState(this.mView.getDrawableState());
        }
        this.mView.setButtonDrawable(drawable);
    }

    int getCompoundPaddingLeft(int n) {
        int n2 = n;
        if (Build.VERSION.SDK_INT >= 17) return n2;
        Drawable drawable = CompoundButtonCompat.getButtonDrawable((CompoundButton)this.mView);
        n2 = n;
        if (drawable == null) return n2;
        n2 = n + drawable.getIntrinsicWidth();
        return n2;
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void loadFromAttributes(AttributeSet attributeSet, int n) {
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)this.mView.getContext(), (AttributeSet)attributeSet, (int[])R.styleable.CompoundButton, (int)n, (int)0);
        CompoundButton compoundButton = this.mView;
        ViewCompat.saveAttributeDataForStyleable((View)compoundButton, (Context)compoundButton.getContext(), (int[])R.styleable.CompoundButton, (AttributeSet)attributeSet, (TypedArray)tintTypedArray.getWrappedTypeArray(), (int)n, (int)0);
        try {
            if (tintTypedArray.hasValue(R.styleable.CompoundButton_buttonCompat) && (n = tintTypedArray.getResourceId(R.styleable.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    this.mView.setButtonDrawable(AppCompatResources.getDrawable((Context)this.mView.getContext(), (int)n));
                    n = 1;
                }
                catch (Resources.NotFoundException notFoundException) {}
            }
            n = 0;
            if (n == 0 && tintTypedArray.hasValue(R.styleable.CompoundButton_android_button) && (n = tintTypedArray.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.mView.setButtonDrawable(AppCompatResources.getDrawable((Context)this.mView.getContext(), (int)n));
            }
            if (tintTypedArray.hasValue(R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList((CompoundButton)this.mView, (ColorStateList)tintTypedArray.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (!tintTypedArray.hasValue(R.styleable.CompoundButton_buttonTintMode)) return;
            CompoundButtonCompat.setButtonTintMode((CompoundButton)this.mView, (PorterDuff.Mode)DrawableUtils.parseTintMode((int)tintTypedArray.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            return;
        }
        finally {
            tintTypedArray.recycle();
        }
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        this.applyButtonTint();
    }

    void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        this.applyButtonTint();
    }

    void setSupportButtonTintMode(PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        this.applyButtonTint();
    }
}
