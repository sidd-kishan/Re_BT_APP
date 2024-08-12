/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$color
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.alpha.QMUIAlphaImageButton
 *  com.qmuiteam.qmui.util.QMUIDrawableHelper
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.QMUITopBar
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton;
import com.qmuiteam.qmui.util.QMUIDrawableHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

public class QMUITopBarLayout
extends FrameLayout {
    private QMUITopBar mTopBar;
    private int mTopBarBgColor;
    private Drawable mTopBarBgWithSeparatorDrawableCache;
    private int mTopBarSeparatorColor;
    private int mTopBarSeparatorHeight;

    public QMUITopBarLayout(Context context) {
        this(context, null);
    }

    public QMUITopBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUITopBarStyle);
    }

    public QMUITopBarLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        QMUITopBar qMUITopBar;
        attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUITopBar, R.attr.QMUITopBarStyle, 0);
        this.mTopBarSeparatorColor = attributeSet.getColor(R.styleable.QMUITopBar_qmui_topbar_separator_color, ContextCompat.getColor((Context)context, (int)R.color.qmui_config_color_separator));
        this.mTopBarSeparatorHeight = attributeSet.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_separator_height, 1);
        this.mTopBarBgColor = attributeSet.getColor(R.styleable.QMUITopBar_qmui_topbar_bg_color, -1);
        boolean bl = attributeSet.getBoolean(R.styleable.QMUITopBar_qmui_topbar_need_separator, true);
        this.mTopBar = qMUITopBar = new QMUITopBar(context, true);
        qMUITopBar.getCommonFieldFormTypedArray(context, (TypedArray)attributeSet);
        context = new FrameLayout.LayoutParams(-1, QMUIResHelper.getAttrDimen((Context)context, (int)R.attr.qmui_topbar_height));
        this.addView((View)this.mTopBar, (ViewGroup.LayoutParams)context);
        attributeSet.recycle();
        this.setBackgroundDividerEnabled(bl);
    }

    public QMUIAlphaImageButton addLeftBackImageButton() {
        return this.mTopBar.addLeftBackImageButton();
    }

    public QMUIAlphaImageButton addLeftImageButton(int n, int n2) {
        return this.mTopBar.addLeftImageButton(n, n2);
    }

    public Button addLeftTextButton(int n, int n2) {
        return this.mTopBar.addLeftTextButton(n, n2);
    }

    public Button addLeftTextButton(String string, int n) {
        return this.mTopBar.addLeftTextButton(string, n);
    }

    public void addLeftView(View view, int n) {
        this.mTopBar.addLeftView(view, n);
    }

    public void addLeftView(View view, int n, RelativeLayout.LayoutParams layoutParams) {
        this.mTopBar.addLeftView(view, n, layoutParams);
    }

    public QMUIAlphaImageButton addRightImageButton(int n, int n2) {
        return this.mTopBar.addRightImageButton(n, n2);
    }

    public Button addRightTextButton(int n, int n2) {
        return this.mTopBar.addRightTextButton(n, n2);
    }

    public Button addRightTextButton(String string, int n) {
        return this.mTopBar.addRightTextButton(string, n);
    }

    public void addRightView(View view, int n) {
        this.mTopBar.addRightView(view, n);
    }

    public void addRightView(View view, int n, RelativeLayout.LayoutParams layoutParams) {
        this.mTopBar.addRightView(view, n, layoutParams);
    }

    public int computeAndSetBackgroundAlpha(int n, int n2, int n3) {
        n = (int)(Math.max(0.0, Math.min((double)((float)(n - n2) / (float)(n3 - n2)), 1.0)) * 255.0);
        this.setBackgroundAlpha(n);
        return n;
    }

    public void removeAllLeftViews() {
        this.mTopBar.removeAllLeftViews();
    }

    public void removeAllRightViews() {
        this.mTopBar.removeAllRightViews();
    }

    public void removeCenterViewAndTitleView() {
        this.mTopBar.removeCenterViewAndTitleView();
    }

    public void setBackgroundAlpha(int n) {
        this.getBackground().setAlpha(n);
    }

    public void setBackgroundDividerEnabled(boolean bl) {
        if (bl) {
            if (this.mTopBarBgWithSeparatorDrawableCache == null) {
                this.mTopBarBgWithSeparatorDrawableCache = QMUIDrawableHelper.createItemSeparatorBg((int)this.mTopBarSeparatorColor, (int)this.mTopBarBgColor, (int)this.mTopBarSeparatorHeight, (boolean)false);
            }
            QMUIViewHelper.setBackgroundKeepingPadding((View)this, (Drawable)this.mTopBarBgWithSeparatorDrawableCache);
        } else {
            QMUIViewHelper.setBackgroundColorKeepPadding((View)this, (int)this.mTopBarBgColor);
        }
    }

    public void setCenterView(View view) {
        this.mTopBar.setCenterView(view);
    }

    public TextView setEmojiTitle(String string) {
        return this.mTopBar.setEmojiTitle(string);
    }

    public void setSubTitle(int n) {
        this.mTopBar.setSubTitle(n);
    }

    public void setSubTitle(String string) {
        this.mTopBar.setSubTitle(string);
    }

    public TextView setTitle(int n) {
        return this.mTopBar.setTitle(n);
    }

    public TextView setTitle(String string) {
        return this.mTopBar.setTitle(string);
    }

    public void setTitleGravity(int n) {
        this.mTopBar.setTitleGravity(n);
    }

    public void showTitlteView(boolean bl) {
        this.mTopBar.showTitleView(bl);
    }
}
