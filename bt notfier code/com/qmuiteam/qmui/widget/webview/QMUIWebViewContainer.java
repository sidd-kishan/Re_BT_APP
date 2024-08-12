/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowInsets
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.core.view.WindowInsetsCompat
 *  com.qmuiteam.qmui.util.QMUINotchHelper
 *  com.qmuiteam.qmui.widget.QMUIWindowInsetLayout
 *  com.qmuiteam.qmui.widget.webview.QMUIWebView
 *  com.qmuiteam.qmui.widget.webview.QMUIWebView$OnScrollChangeListener
 */
package com.qmuiteam.qmui.widget.webview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.util.QMUINotchHelper;
import com.qmuiteam.qmui.widget.QMUIWindowInsetLayout;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;

public class QMUIWebViewContainer
extends QMUIWindowInsetLayout {
    private QMUIWebView.OnScrollChangeListener mOnScrollChangeListener;
    private QMUIWebView mWebView;

    public QMUIWebViewContainer(Context context) {
        super(context);
    }

    public QMUIWebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ QMUIWebView.OnScrollChangeListener access$000(QMUIWebViewContainer qMUIWebViewContainer) {
        return qMUIWebViewContainer.mOnScrollChangeListener;
    }

    public void addWebView(QMUIWebView qMUIWebView, boolean bl) {
        this.mWebView = qMUIWebView;
        qMUIWebView.setNeedDispatchSafeAreaInset(bl);
        this.mWebView.addCustomOnScrollChangeListener((QMUIWebView.OnScrollChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        this.addView((View)this.mWebView, (ViewGroup.LayoutParams)this.getWebViewLayoutParams());
    }

    public boolean applySystemWindowInsets19(Rect rect) {
        if (!this.getFitsSystemWindows()) return super.applySystemWindowInsets19(rect);
        rect = new Rect(rect);
        this.mQMUIWindowInsetHelper.computeInsetsWithGravity((View)this, rect);
        this.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        return true;
    }

    public boolean applySystemWindowInsets21(Object object) {
        int n;
        int n2;
        int n3;
        if (!this.getFitsSystemWindows()) return super.applySystemWindowInsets21(object);
        boolean bl = object instanceof WindowInsetsCompat;
        int n4 = 0;
        if (bl) {
            object = (WindowInsetsCompat)object;
            n4 = object.getSystemWindowInsetLeft();
            n3 = object.getSystemWindowInsetRight();
            n2 = object.getSystemWindowInsetTop();
            n = object.getSystemWindowInsetBottom();
        } else if (object instanceof WindowInsets) {
            object = (WindowInsets)object;
            n4 = object.getSystemWindowInsetLeft();
            n3 = object.getSystemWindowInsetRight();
            n2 = object.getSystemWindowInsetTop();
            n = object.getSystemWindowInsetBottom();
        } else {
            n = 0;
            n3 = 0;
            n2 = 0;
        }
        int n5 = n3;
        int n6 = n4;
        if (QMUINotchHelper.needFixLandscapeNotchAreaFitSystemWindow((View)this)) {
            n5 = n3;
            n6 = n4;
            if (this.getResources().getConfiguration().orientation == 2) {
                n6 = Math.max(n4, QMUINotchHelper.getSafeInsetLeft((View)this));
                n5 = Math.max(n3, QMUINotchHelper.getSafeInsetRight((View)this));
            }
        }
        object = new Rect(n6, n2, n5, n);
        this.mQMUIWindowInsetHelper.computeInsetsWithGravity((View)this, (Rect)object);
        this.setPadding(((Rect)object).left, ((Rect)object).top, ((Rect)object).right, ((Rect)object).bottom);
        return true;
    }

    public void destroy() {
        this.removeView((View)this.mWebView);
        this.removeAllViews();
        this.mWebView.setWebChromeClient(null);
        this.mWebView.setWebViewClient(null);
        this.mWebView.destroy();
    }

    protected FrameLayout.LayoutParams getWebViewLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public void setCustomOnScrollChangeListener(QMUIWebView.OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public void setNeedDispatchSafeAreaInset(boolean bl) {
        QMUIWebView qMUIWebView = this.mWebView;
        if (qMUIWebView == null) return;
        qMUIWebView.setNeedDispatchSafeAreaInset(bl);
    }
}
