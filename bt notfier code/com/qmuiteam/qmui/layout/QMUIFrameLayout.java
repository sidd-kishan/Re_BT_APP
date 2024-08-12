/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.view.View
 *  com.qmuiteam.qmui.alpha.QMUIAlphaFrameLayout
 *  com.qmuiteam.qmui.layout.IQMUILayout
 *  com.qmuiteam.qmui.layout.QMUILayoutHelper
 */
package com.qmuiteam.qmui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.qmuiteam.qmui.alpha.QMUIAlphaFrameLayout;
import com.qmuiteam.qmui.layout.IQMUILayout;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;

public class QMUIFrameLayout
extends QMUIAlphaFrameLayout
implements IQMUILayout {
    private QMUILayoutHelper mLayoutHelper;

    public QMUIFrameLayout(Context context) {
        super(context);
        this.init(context, null, 0);
    }

    public QMUIFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context, attributeSet, 0);
    }

    public QMUIFrameLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n);
    }

    private void init(Context context, AttributeSet attributeSet, int n) {
        this.mLayoutHelper = new QMUILayoutHelper(context, attributeSet, 0, (View)this);
        this.setChangeAlphaWhenDisable(false);
        this.setChangeAlphaWhenPress(false);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mLayoutHelper.drawDividers(canvas, this.getWidth(), this.getHeight());
        this.mLayoutHelper.dispatchRoundBorderDraw(canvas);
    }

    public int getHideRadiusSide() {
        return this.mLayoutHelper.getHideRadiusSide();
    }

    public int getRadius() {
        return this.mLayoutHelper.getRadius();
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

    protected void onMeasure(int n, int n2) {
        n = this.mLayoutHelper.getMeasuredWidthSpec(n);
        n2 = this.mLayoutHelper.getMeasuredHeightSpec(n2);
        super.onMeasure(n, n2);
        int n3 = this.mLayoutHelper.handleMiniWidth(n, this.getMeasuredWidth());
        int n4 = this.mLayoutHelper.handleMiniHeight(n2, this.getMeasuredHeight());
        if (n == n3) {
            if (n2 == n4) return;
        }
        super.onMeasure(n3, n4);
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
        this.mLayoutHelper.setBorderColor(n);
        this.invalidate();
    }

    public void setBorderWidth(int n) {
        this.mLayoutHelper.setBorderWidth(n);
        this.invalidate();
    }

    public void setBottomDividerAlpha(int n) {
        this.mLayoutHelper.setBottomDividerAlpha(n);
        this.invalidate();
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
