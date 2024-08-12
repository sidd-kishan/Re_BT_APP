/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.widget.webview.QMUIWebView
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;

public class QMUIContinuousNestedTopWebView
extends QMUIWebView
implements IQMUIContinuousNestedTopView {
    public static final String KEY_SCROLL_INFO = "@qmui_scroll_info_top_webview";
    private IQMUIContinuousNestedScrollCommon.OnScrollNotifier mScrollNotifier;

    public QMUIContinuousNestedTopWebView(Context context) {
        super(context);
        this.init();
    }

    public QMUIContinuousNestedTopWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init();
    }

    public QMUIContinuousNestedTopWebView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    private void exec(String string) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.evaluateJavascript(string, null);
        } else {
            this.loadUrl(string);
        }
    }

    private void init() {
        this.setVerticalScrollBarEnabled(false);
    }

    public int consumeScroll(int n) {
        int n2 = this.getScrollY();
        int n3 = this.getScrollOffsetRange();
        n2 = Math.max(0, Math.min(n2, n3));
        n3 = n < 0 ? Math.max(n, -n2) : (n > 0 ? Math.min(n, n3 - n2) : 0);
        this.scrollBy(0, n3);
        return n - n3;
    }

    public int getCurrentScroll() {
        return Math.max(0, Math.min(this.getScrollY(), this.getScrollOffsetRange()));
    }

    public int getScrollOffsetRange() {
        return this.computeVerticalScrollRange() - this.getHeight();
    }

    public void injectScrollNotifier(IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mScrollNotifier = onScrollNotifier;
    }

    protected void onScrollChanged(int n, int n2, int n3, int n4) {
        super.onScrollChanged(n, n2, n3, n4);
        IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mScrollNotifier;
        if (onScrollNotifier == null) return;
        onScrollNotifier.notify(this.getCurrentScroll(), this.getScrollOffsetRange());
    }

    public void restoreScrollInfo(Bundle object) {
        int n = QMUIDisplayHelper.px2dp((Context)this.getContext(), (int)object.getInt(KEY_SCROLL_INFO, 0));
        object = new StringBuilder();
        ((StringBuilder)object).append("javascript:scrollTo(0, ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(")");
        this.exec(((StringBuilder)object).toString());
    }

    public void saveScrollInfo(Bundle bundle) {
        bundle.putInt(KEY_SCROLL_INFO, this.getScrollY());
    }
}
