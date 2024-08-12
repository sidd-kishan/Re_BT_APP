/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.ImageView
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.AppCompatDrawableManager
 *  androidx.appcompat.widget.DrawableUtils
 *  androidx.appcompat.widget.TintInfo
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.ImageViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private TintInfo mTmpInfo;
    private final ImageView mView;

    public AppCompatImageHelper(ImageView imageView) {
        this.mView = imageView;
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new TintInfo();
        }
        TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        ColorStateList colorStateList = ImageViewCompat.getImageTintList((ImageView)this.mView);
        if (colorStateList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = colorStateList;
        }
        if ((colorStateList = ImageViewCompat.getImageTintMode((ImageView)this.mView)) != null) {
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
        if (this.mInternalImageTint != null) return bl;
        bl = false;
        return bl;
    }

    void applySupportImageTint() {
        Drawable drawable = this.mView.getDrawable();
        if (drawable != null) {
            DrawableUtils.fixDrawable((Drawable)drawable);
        }
        if (drawable == null) return;
        if (this.shouldApplyFrameworkTintUsingColorFilter() && this.applyFrameworkTintUsingColorFilter(drawable)) {
            return;
        }
        TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            AppCompatDrawableManager.tintDrawable((Drawable)drawable, (TintInfo)tintInfo, (int[])this.mView.getDrawableState());
        } else {
            tintInfo = this.mInternalImageTint;
            if (tintInfo == null) return;
            AppCompatDrawableManager.tintDrawable((Drawable)drawable, (TintInfo)tintInfo, (int[])this.mView.getDrawableState());
        }
    }

    ColorStateList getSupportImageTintList() {
        Object object = this.mImageTint;
        object = object != null ? object.mTintList : null;
        return object;
    }

    PorterDuff.Mode getSupportImageTintMode() {
        Object object = this.mImageTint;
        object = object != null ? object.mTintMode : null;
        return object;
    }

    boolean hasOverlappingRendering() {
        Drawable drawable = this.mView.getBackground();
        if (Build.VERSION.SDK_INT < 21) return true;
        if (!(drawable instanceof RippleDrawable)) return true;
        return false;
    }

    public void loadFromAttributes(AttributeSet attributeSet, int n) {
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)this.mView.getContext(), (AttributeSet)attributeSet, (int[])R.styleable.AppCompatImageView, (int)n, (int)0);
        ImageView imageView = this.mView;
        ViewCompat.saveAttributeDataForStyleable((View)imageView, (Context)imageView.getContext(), (int[])R.styleable.AppCompatImageView, (AttributeSet)attributeSet, (TypedArray)tintTypedArray.getWrappedTypeArray(), (int)n, (int)0);
        try {
            imageView = this.mView.getDrawable();
            attributeSet = imageView;
            if (imageView == null) {
                n = tintTypedArray.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
                attributeSet = imageView;
                if (n != -1) {
                    imageView = AppCompatResources.getDrawable((Context)this.mView.getContext(), (int)n);
                    attributeSet = imageView;
                    if (imageView != null) {
                        this.mView.setImageDrawable((Drawable)imageView);
                        attributeSet = imageView;
                    }
                }
            }
            if (attributeSet != null) {
                DrawableUtils.fixDrawable((Drawable)attributeSet);
            }
            if (tintTypedArray.hasValue(R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.setImageTintList((ImageView)this.mView, (ColorStateList)tintTypedArray.getColorStateList(R.styleable.AppCompatImageView_tint));
            }
            if (!tintTypedArray.hasValue(R.styleable.AppCompatImageView_tintMode)) return;
            ImageViewCompat.setImageTintMode((ImageView)this.mView, (PorterDuff.Mode)DrawableUtils.parseTintMode((int)tintTypedArray.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
            return;
        }
        finally {
            tintTypedArray.recycle();
        }
    }

    public void setImageResource(int n) {
        if (n != 0) {
            Drawable drawable = AppCompatResources.getDrawable((Context)this.mView.getContext(), (int)n);
            if (drawable != null) {
                DrawableUtils.fixDrawable((Drawable)drawable);
            }
            this.mView.setImageDrawable(drawable);
        } else {
            this.mView.setImageDrawable(null);
        }
        this.applySupportImageTint();
    }

    void setInternalImageTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalImageTint == null) {
                this.mInternalImageTint = new TintInfo();
            }
            this.mInternalImageTint.mTintList = colorStateList;
            this.mInternalImageTint.mHasTintList = true;
        } else {
            this.mInternalImageTint = null;
        }
        this.applySupportImageTint();
    }

    void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        this.mImageTint.mTintList = colorStateList;
        this.mImageTint.mHasTintList = true;
        this.applySupportImageTint();
    }

    void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        this.mImageTint.mTintMode = mode;
        this.mImageTint.mHasTintMode = true;
        this.applySupportImageTint();
    }
}
