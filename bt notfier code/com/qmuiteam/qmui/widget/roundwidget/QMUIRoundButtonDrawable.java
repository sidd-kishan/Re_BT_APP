/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Rect
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Build$VERSION
 *  com.qmuiteam.qmui.R$styleable
 */
package com.qmuiteam.qmui.widget.roundwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.qmuiteam.qmui.R;

public class QMUIRoundButtonDrawable
extends GradientDrawable {
    private ColorStateList mFillColors;
    private boolean mRadiusAdjustBounds = true;
    private ColorStateList mStrokeColors;
    private int mStrokeWidth = 0;

    public static QMUIRoundButtonDrawable fromAttributeSet(Context context, AttributeSet attributeSet, int n) {
        Object object = R.styleable.QMUIRoundButton;
        boolean bl = false;
        object = context.obtainStyledAttributes(attributeSet, (int[])object, n, 0);
        context = object.getColorStateList(R.styleable.QMUIRoundButton_qmui_backgroundColor);
        attributeSet = object.getColorStateList(R.styleable.QMUIRoundButton_qmui_borderColor);
        int n2 = object.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_borderWidth, 0);
        boolean bl2 = object.getBoolean(R.styleable.QMUIRoundButton_qmui_isRadiusAdjustBounds, false);
        n = object.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radius, 0);
        int n3 = object.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusTopLeft, 0);
        int n4 = object.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusTopRight, 0);
        int n5 = object.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusBottomLeft, 0);
        int n6 = object.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusBottomRight, 0);
        object.recycle();
        object = (Object)new QMUIRoundButtonDrawable();
        ((QMUIRoundButtonDrawable)((Object)object)).setBgData((ColorStateList)context);
        ((QMUIRoundButtonDrawable)((Object)object)).setStrokeData(n2, (ColorStateList)attributeSet);
        if (n3 <= 0 && n4 <= 0 && n5 <= 0 && n6 <= 0) {
            object.setCornerRadius((float)n);
            if (n <= 0) {
                bl = bl2;
            }
        } else {
            float f = n3;
            float f2 = n4;
            float f3 = n6;
            float f4 = n5;
            object.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
        }
        ((QMUIRoundButtonDrawable)((Object)object)).setIsRadiusAdjustBounds(bl);
        return object;
    }

    private boolean hasNativeStateListAPI() {
        boolean bl = Build.VERSION.SDK_INT >= 21;
        return bl;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.mFillColors;
        boolean bl = colorStateList != null && colorStateList.isStateful() || (colorStateList = this.mStrokeColors) != null && colorStateList.isStateful() || super.isStateful();
        return bl;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (!this.mRadiusAdjustBounds) return;
        this.setCornerRadius(Math.min(rect.width(), rect.height()) / 2);
    }

    protected boolean onStateChange(int[] nArray) {
        boolean bl = super.onStateChange(nArray);
        ColorStateList colorStateList = this.mFillColors;
        boolean bl2 = true;
        if (colorStateList != null) {
            this.setColor(colorStateList.getColorForState(nArray, 0));
            bl = true;
        }
        if ((colorStateList = this.mStrokeColors) == null) return bl;
        int n = colorStateList.getColorForState(nArray, 0);
        this.setStroke(this.mStrokeWidth, n);
        bl = bl2;
        return bl;
    }

    public void setBgData(ColorStateList colorStateList) {
        if (this.hasNativeStateListAPI()) {
            super.setColor(colorStateList);
        } else {
            this.mFillColors = colorStateList;
            int n = 0;
            if (colorStateList != null) {
                n = colorStateList.getColorForState(this.getState(), 0);
            }
            this.setColor(n);
        }
    }

    public void setIsRadiusAdjustBounds(boolean bl) {
        this.mRadiusAdjustBounds = bl;
    }

    public void setStrokeData(int n, ColorStateList colorStateList) {
        if (this.hasNativeStateListAPI()) {
            super.setStroke(n, colorStateList);
        } else {
            this.mStrokeWidth = n;
            this.mStrokeColors = colorStateList;
            int n2 = 0;
            if (colorStateList != null) {
                n2 = colorStateList.getColorForState(this.getState(), 0);
            }
            this.setStroke(n, n2);
        }
    }
}
