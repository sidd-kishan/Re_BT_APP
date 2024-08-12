/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.ImageView$ScaleType
 *  androidx.appcompat.widget.AppCompatImageView
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.alpha.QMUIAlphaViewHelper
 *  com.qmuiteam.qmui.layout.IQMUILayout
 *  com.qmuiteam.qmui.layout.QMUILayoutHelper
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaViewHelper;
import com.qmuiteam.qmui.layout.IQMUILayout;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;

public class QMUIRadiusImageView2
extends AppCompatImageView
implements IQMUILayout {
    private static final int DEFAULT_BORDER_COLOR = -7829368;
    private QMUIAlphaViewHelper mAlphaViewHelper;
    private int mBorderColor;
    private int mBorderWidth;
    private ColorFilter mColorFilter;
    private boolean mIsCircle = false;
    private boolean mIsSelected = false;
    private boolean mIsTouchSelectModeEnabled = true;
    private QMUILayoutHelper mLayoutHelper;
    private int mSelectedBorderColor;
    private int mSelectedBorderWidth;
    private ColorFilter mSelectedColorFilter;
    private int mSelectedMaskColor;

    public QMUIRadiusImageView2(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public QMUIRadiusImageView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public QMUIRadiusImageView2(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private QMUIAlphaViewHelper getAlphaViewHelper() {
        if (this.mAlphaViewHelper != null) return this.mAlphaViewHelper;
        this.mAlphaViewHelper = new QMUIAlphaViewHelper((View)this);
        return this.mAlphaViewHelper;
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        boolean bl;
        this.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mLayoutHelper = new QMUILayoutHelper(context, attributeSet, n, (View)this);
        this.setChangeAlphaWhenPress(false);
        this.setChangeAlphaWhenDisable(false);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIRadiusImageView2, n, 0);
        this.mBorderWidth = context.getDimensionPixelSize(R.styleable.QMUIRadiusImageView2_qmui_border_width, 0);
        this.mBorderColor = context.getColor(R.styleable.QMUIRadiusImageView2_qmui_border_color, -7829368);
        this.mSelectedBorderWidth = context.getDimensionPixelSize(R.styleable.QMUIRadiusImageView2_qmui_selected_border_width, this.mBorderWidth);
        this.mSelectedBorderColor = context.getColor(R.styleable.QMUIRadiusImageView2_qmui_selected_border_color, this.mBorderColor);
        this.mSelectedMaskColor = n = context.getColor(R.styleable.QMUIRadiusImageView2_qmui_selected_mask_color, 0);
        if (n != 0) {
            this.mSelectedColorFilter = new PorterDuffColorFilter(this.mSelectedMaskColor, PorterDuff.Mode.DARKEN);
        }
        this.mIsTouchSelectModeEnabled = context.getBoolean(R.styleable.QMUIRadiusImageView2_qmui_is_touch_select_mode_enabled, true);
        this.mIsCircle = bl = context.getBoolean(R.styleable.QMUIRadiusImageView2_qmui_is_circle, false);
        if (!bl) {
            this.setRadius(context.getDimensionPixelSize(R.styleable.QMUIRadiusImageView2_qmui_corner_radius, 0));
        }
        context.recycle();
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mLayoutHelper.drawDividers(canvas, this.getWidth(), this.getHeight());
        this.mLayoutHelper.dispatchRoundBorderDraw(canvas);
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getCornerRadius() {
        return this.getRadius();
    }

    public int getHideRadiusSide() {
        return this.mLayoutHelper.getHideRadiusSide();
    }

    public int getRadius() {
        return this.mLayoutHelper.getRadius();
    }

    public int getSelectedBorderColor() {
        return this.mSelectedBorderColor;
    }

    public int getSelectedBorderWidth() {
        return this.mSelectedBorderWidth;
    }

    public int getSelectedMaskColor() {
        return this.mSelectedMaskColor;
    }

    public float getShadowAlpha() {
        return this.mLayoutHelper.getShadowAlpha();
    }

    public int getShadowColor() {
        return this.mLayoutHelper.getShadowColor();
    }

    public int getShadowElevation() {
        return this.mLayoutHelper.getShadowElevation();
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public boolean isTouchSelectModeEnabled() {
        return this.mIsTouchSelectModeEnabled;
    }

    protected void onMeasure(int n, int n2) {
        n = this.mLayoutHelper.getMeasuredWidthSpec(n);
        n2 = this.mLayoutHelper.getMeasuredHeightSpec(n2);
        super.onMeasure(n, n2);
        int n3 = this.mLayoutHelper.handleMiniWidth(n, this.getMeasuredWidth());
        int n4 = this.mLayoutHelper.handleMiniHeight(n2, this.getMeasuredHeight());
        if (n != n3 || n2 != n4) {
            super.onMeasure(n3, n4);
        }
        if (!this.mIsCircle) return;
        n2 = this.getMeasuredHeight();
        n4 = this.getMeasuredWidth();
        n = n4 / 2;
        if (n2 != n4) {
            n2 = Math.min(n2, n4);
            n = n2 / 2;
            n2 = View.MeasureSpec.makeMeasureSpec((int)n2, (int)0x40000000);
            super.onMeasure(n2, n2);
        }
        this.setRadius(n);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isClickable()) {
            this.setSelected(false);
            return super.onTouchEvent(motionEvent);
        }
        if (!this.mIsTouchSelectModeEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        int n = motionEvent.getAction();
        if (n != 0) {
            if (n != 1 && n != 3 && n != 4 && n != 8) return super.onTouchEvent(motionEvent);
            this.setSelected(false);
        } else {
            this.setSelected(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onlyShowBottomDivider(int n, int n2, int n3, int n4) {
        this.mLayoutHelper.onlyShowBottomDivider(n, n2, n3, n4);
        this.invalidate();
    }

    public void onlyShowLeftDivider(int n, int n2, int n3, int n4) {
        this.mLayoutHelper.onlyShowLeftDivider(n, n2, n3, n4);
        this.invalidate();
    }

    public void onlyShowRightDivider(int n, int n2, int n3, int n4) {
        this.mLayoutHelper.onlyShowRightDivider(n, n2, n3, n4);
        this.invalidate();
    }

    public void onlyShowTopDivider(int n, int n2, int n3, int n4) {
        this.mLayoutHelper.onlyShowTopDivider(n, n2, n3, n4);
        this.invalidate();
    }

    public void setBorderColor(int n) {
        if (this.mBorderColor == n) return;
        this.mBorderColor = n;
        if (this.mIsSelected) return;
        this.mLayoutHelper.setBorderColor(n);
        this.invalidate();
    }

    public void setBorderWidth(int n) {
        if (this.mBorderWidth == n) return;
        this.mBorderWidth = n;
        if (this.mIsSelected) return;
        this.mLayoutHelper.setBorderWidth(n);
        this.invalidate();
    }

    public void setBottomDividerAlpha(int n) {
        this.mLayoutHelper.setBottomDividerAlpha(n);
        this.invalidate();
    }

    public void setChangeAlphaWhenDisable(boolean bl) {
        this.getAlphaViewHelper().setChangeAlphaWhenDisable(bl);
    }

    public void setChangeAlphaWhenPress(boolean bl) {
        this.getAlphaViewHelper().setChangeAlphaWhenPress(bl);
    }

    public void setCircle(boolean bl) {
        if (this.mIsCircle == bl) return;
        this.mIsCircle = bl;
        this.requestLayout();
        this.invalidate();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mColorFilter == colorFilter) {
            return;
        }
        this.mColorFilter = colorFilter;
        if (this.mIsSelected) return;
        super.setColorFilter(colorFilter);
    }

    public void setCornerRadius(int n) {
        this.setRadius(n);
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        this.getAlphaViewHelper().onEnabledChanged((View)this, bl);
    }

    protected boolean setFrame(int n, int n2, int n3, int n4) {
        return super.setFrame(n, n2, n3, n4);
    }

    public boolean setHeightLimit(int n) {
        if (!this.mLayoutHelper.setHeightLimit(n)) return true;
        this.requestLayout();
        this.invalidate();
        return true;
    }

    public void setHideRadiusSide(int n) {
        this.mLayoutHelper.setHideRadiusSide(n);
    }

    public void setLeftDividerAlpha(int n) {
        this.mLayoutHelper.setLeftDividerAlpha(n);
        this.invalidate();
    }

    public void setOuterNormalColor(int n) {
        this.mLayoutHelper.setOuterNormalColor(n);
    }

    public void setOutlineExcludePadding(boolean bl) {
        this.mLayoutHelper.setOutlineExcludePadding(bl);
    }

    public void setOutlineInset(int n, int n2, int n3, int n4) {
        this.mLayoutHelper.setOutlineInset(n, n2, n3, n4);
    }

    public void setPressed(boolean bl) {
        super.setPressed(bl);
        this.getAlphaViewHelper().onPressedChanged((View)this, bl);
    }

    public void setRadius(int n) {
        this.mLayoutHelper.setRadius(n);
    }

    public void setRadius(int n, int n2) {
        this.mLayoutHelper.setRadius(n, n2);
    }

    public void setRadiusAndShadow(int n, int n2, float f) {
        this.mLayoutHelper.setRadiusAndShadow(n, n2, f);
    }

    public void setRadiusAndShadow(int n, int n2, int n3, float f) {
        this.mLayoutHelper.setRadiusAndShadow(n, n2, n3, f);
    }

    public void setRadiusAndShadow(int n, int n2, int n3, int n4, float f) {
        this.mLayoutHelper.setRadiusAndShadow(n, n2, n3, n4, f);
    }

    public void setRightDividerAlpha(int n) {
        this.mLayoutHelper.setRightDividerAlpha(n);
        this.invalidate();
    }

    public void setSelected(boolean bl) {
        super.setSelected(bl);
        if (this.mIsSelected == bl) return;
        this.mIsSelected = bl;
        if (bl) {
            super.setColorFilter(this.mSelectedColorFilter);
        } else {
            super.setColorFilter(this.mColorFilter);
        }
        int n = this.mIsSelected ? this.mSelectedBorderWidth : this.mBorderWidth;
        int n2 = this.mIsSelected ? this.mSelectedBorderColor : this.mBorderColor;
        this.mLayoutHelper.setBorderWidth(n);
        this.mLayoutHelper.setBorderColor(n2);
        this.invalidate();
    }

    public void setSelectedBorderColor(int n) {
        if (this.mSelectedBorderColor == n) return;
        this.mSelectedBorderColor = n;
        if (!this.mIsSelected) return;
        this.mLayoutHelper.setBorderColor(n);
        this.invalidate();
    }

    public void setSelectedBorderWidth(int n) {
        if (this.mSelectedBorderWidth == n) return;
        this.mSelectedBorderWidth = n;
        if (!this.mIsSelected) return;
        this.mLayoutHelper.setBorderWidth(n);
        this.invalidate();
    }

    public void setSelectedColorFilter(ColorFilter colorFilter) {
        if (this.mSelectedColorFilter == colorFilter) {
            return;
        }
        this.mSelectedColorFilter = colorFilter;
        if (!this.mIsSelected) return;
        super.setColorFilter(colorFilter);
    }

    public void setSelectedMaskColor(int n) {
        if (this.mSelectedMaskColor != n) {
            this.mSelectedMaskColor = n;
            this.mSelectedColorFilter = n != 0 ? new PorterDuffColorFilter(this.mSelectedMaskColor, PorterDuff.Mode.DARKEN) : null;
            if (this.mIsSelected) {
                this.invalidate();
            }
        }
        this.mSelectedMaskColor = n;
    }

    public void setShadowAlpha(float f) {
        this.mLayoutHelper.setShadowAlpha(f);
    }

    public void setShadowColor(int n) {
        this.mLayoutHelper.setShadowColor(n);
    }

    public void setShadowElevation(int n) {
        this.mLayoutHelper.setShadowElevation(n);
    }

    public void setShowBorderOnlyBeforeL(boolean bl) {
        this.mLayoutHelper.setShowBorderOnlyBeforeL(bl);
        this.invalidate();
    }

    public void setTopDividerAlpha(int n) {
        this.mLayoutHelper.setTopDividerAlpha(n);
        this.invalidate();
    }

    public void setTouchSelectModeEnabled(boolean bl) {
        this.mIsTouchSelectModeEnabled = bl;
    }

    public void setUseThemeGeneralShadowElevation() {
        this.mLayoutHelper.setUseThemeGeneralShadowElevation();
    }

    public boolean setWidthLimit(int n) {
        if (!this.mLayoutHelper.setWidthLimit(n)) return true;
        this.requestLayout();
        this.invalidate();
        return true;
    }

    public void updateBottomDivider(int n, int n2, int n3, int n4) {
        this.mLayoutHelper.updateBottomDivider(n, n2, n3, n4);
        this.invalidate();
    }

    public void updateLeftDivider(int n, int n2, int n3, int n4) {
        this.mLayoutHelper.updateLeftDivider(n, n2, n3, n4);
        this.invalidate();
    }

    public void updateRightDivider(int n, int n2, int n3, int n4) {
        this.mLayoutHelper.updateRightDivider(n, n2, n3, n4);
        this.invalidate();
    }

    public void updateTopDivider(int n, int n2, int n3, int n4) {
        this.mLayoutHelper.updateTopDivider(n, n2, n3, n4);
        this.invalidate();
    }
}
