/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.widget.AppCompatDrawableManager
 *  androidx.appcompat.widget.DrawableUtils
 *  androidx.appcompat.widget.TintInfo
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper {
    private int mBackgroundResId = -1;
    private TintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private TintInfo mInternalBackgroundTint;
    private TintInfo mTmpInfo;
    private final View mView;

    AppCompatBackgroundHelper(View view) {
        this.mView = view;
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new TintInfo();
        }
        TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        ColorStateList colorStateList = ViewCompat.getBackgroundTintList((View)this.mView);
        if (colorStateList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = colorStateList;
        }
        if ((colorStateList = ViewCompat.getBackgroundTintMode((View)this.mView)) != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = colorStateList;
        }
        if (!tintInfo.mHasTintList) {
            if (!tintInfo.mHasTintMode) return false;
        }
        AppCompatDrawableManager.tintDrawable((Drawable)drawable, (TintInfo)tintInfo, (int[])this.mView.getDrawableState());
        return true;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        if (n <= 21) {
            if (n != 21) return false;
            return true;
        }
        if (this.mInternalBackgroundTint != null) return bl;
        bl = false;
        return bl;
    }

    void applySupportBackgroundTint() {
        Drawable drawable = this.mView.getBackground();
        if (drawable == null) return;
        if (this.shouldApplyFrameworkTintUsingColorFilter() && this.applyFrameworkTintUsingColorFilter(drawable)) {
            return;
        }
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            AppCompatDrawableManager.tintDrawable((Drawable)drawable, (TintInfo)tintInfo, (int[])this.mView.getDrawableState());
        } else {
            tintInfo = this.mInternalBackgroundTint;
            if (tintInfo == null) return;
            AppCompatDrawableManager.tintDrawable((Drawable)drawable, (TintInfo)tintInfo, (int[])this.mView.getDrawableState());
        }
    }

    ColorStateList getSupportBackgroundTintList() {
        Object object = this.mBackgroundTint;
        object = object != null ? object.mTintList : null;
        return object;
    }

    PorterDuff.Mode getSupportBackgroundTintMode() {
        Object object = this.mBackgroundTint;
        object = object != null ? object.mTintMode : null;
        return object;
    }

    void loadFromAttributes(AttributeSet attributeSet, int n) {
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)this.mView.getContext(), (AttributeSet)attributeSet, (int[])R.styleable.ViewBackgroundHelper, (int)n, (int)0);
        View view = this.mView;
        ViewCompat.saveAttributeDataForStyleable((View)view, (Context)view.getContext(), (int[])R.styleable.ViewBackgroundHelper, (AttributeSet)attributeSet, (TypedArray)tintTypedArray.getWrappedTypeArray(), (int)n, (int)0);
        try {
            if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
                this.mBackgroundResId = tintTypedArray.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
                attributeSet = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
                if (attributeSet != null) {
                    this.setInternalBackgroundTint((ColorStateList)attributeSet);
                }
            }
            if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList((View)this.mView, (ColorStateList)tintTypedArray.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (!tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) return;
            ViewCompat.setBackgroundTintMode((View)this.mView, (PorterDuff.Mode)DrawableUtils.parseTintMode((int)tintTypedArray.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            return;
        }
        finally {
            tintTypedArray.recycle();
        }
    }

    void onSetBackgroundDrawable(Drawable drawable) {
        this.mBackgroundResId = -1;
        this.setInternalBackgroundTint(null);
        this.applySupportBackgroundTint();
    }

    void onSetBackgroundResource(int n) {
        this.mBackgroundResId = n;
        Object object = this.mDrawableManager;
        object = object != null ? object.getTintList(this.mView.getContext(), n) : null;
        this.setInternalBackgroundTint((ColorStateList)object);
        this.applySupportBackgroundTint();
    }

    void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalBackgroundTint == null) {
                this.mInternalBackgroundTint = new TintInfo();
            }
            this.mInternalBackgroundTint.mTintList = colorStateList;
            this.mInternalBackgroundTint.mHasTintList = true;
        } else {
            this.mInternalBackgroundTint = null;
        }
        this.applySupportBackgroundTint();
    }

    void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        this.mBackgroundTint.mTintList = colorStateList;
        this.mBackgroundTint.mHasTintList = true;
        this.applySupportBackgroundTint();
    }

    void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        this.mBackgroundTint.mTintMode = mode;
        this.mBackgroundTint.mHasTintMode = true;
        this.applySupportBackgroundTint();
    }
}
