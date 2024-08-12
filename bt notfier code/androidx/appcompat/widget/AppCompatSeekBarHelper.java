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
 *  android.graphics.drawable.Drawable$Callback
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.SeekBar
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.widget.AppCompatProgressBarHelper
 *  androidx.appcompat.widget.DrawableUtils
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatProgressBarHelper;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

class AppCompatSeekBarHelper
extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint = false;
    private boolean mHasTickMarkTintMode = false;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList = null;
    private PorterDuff.Mode mTickMarkTintMode = null;
    private final SeekBar mView;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super((ProgressBar)seekBar);
        this.mView = seekBar;
    }

    private void applyTickMarkTint() {
        Drawable drawable;
        if (this.mTickMark == null) return;
        if (!this.mHasTickMarkTint) {
            if (!this.mHasTickMarkTintMode) return;
        }
        this.mTickMark = drawable = DrawableCompat.wrap((Drawable)this.mTickMark.mutate());
        if (this.mHasTickMarkTint) {
            DrawableCompat.setTintList((Drawable)drawable, (ColorStateList)this.mTickMarkTintList);
        }
        if (this.mHasTickMarkTintMode) {
            DrawableCompat.setTintMode((Drawable)this.mTickMark, (PorterDuff.Mode)this.mTickMarkTintMode);
        }
        if (!this.mTickMark.isStateful()) return;
        this.mTickMark.setState(this.mView.getDrawableState());
    }

    void drawTickMarks(Canvas canvas) {
        if (this.mTickMark == null) return;
        int n = this.mView.getMax();
        int n2 = 1;
        if (n <= 1) return;
        int n3 = this.mTickMark.getIntrinsicWidth();
        int n4 = this.mTickMark.getIntrinsicHeight();
        n3 = n3 >= 0 ? (n3 /= 2) : 1;
        if (n4 >= 0) {
            n2 = n4 / 2;
        }
        this.mTickMark.setBounds(-n3, -n2, n3, n2);
        float f = (float)(this.mView.getWidth() - this.mView.getPaddingLeft() - this.mView.getPaddingRight()) / (float)n;
        n2 = canvas.save();
        canvas.translate((float)this.mView.getPaddingLeft(), (float)(this.mView.getHeight() / 2));
        n3 = 0;
        while (true) {
            if (n3 > n) {
                canvas.restoreToCount(n2);
                return;
            }
            this.mTickMark.draw(canvas);
            canvas.translate(f, 0.0f);
            ++n3;
        }
    }

    void drawableStateChanged() {
        Drawable drawable = this.mTickMark;
        if (drawable == null) return;
        if (!drawable.isStateful()) return;
        if (!drawable.setState(this.mView.getDrawableState())) return;
        this.mView.invalidateDrawable(drawable);
    }

    Drawable getTickMark() {
        return this.mTickMark;
    }

    ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    void jumpDrawablesToCurrentState() {
        Drawable drawable = this.mTickMark;
        if (drawable == null) return;
        drawable.jumpToCurrentState();
    }

    void loadFromAttributes(AttributeSet attributeSet, int n) {
        super.loadFromAttributes(attributeSet, n);
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)this.mView.getContext(), (AttributeSet)attributeSet, (int[])R.styleable.AppCompatSeekBar, (int)n, (int)0);
        SeekBar seekBar = this.mView;
        ViewCompat.saveAttributeDataForStyleable((View)seekBar, (Context)seekBar.getContext(), (int[])R.styleable.AppCompatSeekBar, (AttributeSet)attributeSet, (TypedArray)tintTypedArray.getWrappedTypeArray(), (int)n, (int)0);
        attributeSet = tintTypedArray.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (attributeSet != null) {
            this.mView.setThumb((Drawable)attributeSet);
        }
        this.setTickMark(tintTypedArray.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        if (tintTypedArray.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode((int)tintTypedArray.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), (PorterDuff.Mode)this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        if (tintTypedArray.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.mTickMarkTintList = tintTypedArray.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.mHasTickMarkTint = true;
        }
        tintTypedArray.recycle();
        this.applyTickMarkTint();
    }

    void setTickMark(Drawable drawable) {
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this.mView);
            DrawableCompat.setLayoutDirection((Drawable)drawable, (int)ViewCompat.getLayoutDirection((View)this.mView));
            if (drawable.isStateful()) {
                drawable.setState(this.mView.getDrawableState());
            }
            this.applyTickMarkTint();
        }
        this.mView.invalidate();
    }

    void setTickMarkTintList(ColorStateList colorStateList) {
        this.mTickMarkTintList = colorStateList;
        this.mHasTickMarkTint = true;
        this.applyTickMarkTint();
    }

    void setTickMarkTintMode(PorterDuff.Mode mode) {
        this.mTickMarkTintMode = mode;
        this.mHasTickMarkTintMode = true;
        this.applyTickMarkTint();
    }
}
