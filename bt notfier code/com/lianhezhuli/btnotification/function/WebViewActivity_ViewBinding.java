/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.webkit.WebView
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.WebViewActivity
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function;

import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.WebViewActivity;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class WebViewActivity_ViewBinding
implements Unbinder {
    private WebViewActivity target;

    public WebViewActivity_ViewBinding(WebViewActivity webViewActivity) {
        this(webViewActivity, webViewActivity.getWindow().getDecorView());
    }

    public WebViewActivity_ViewBinding(WebViewActivity webViewActivity, View view) {
        this.target = webViewActivity;
        webViewActivity.mTopBar = (QMUITopBarLayout)Utils.findRequiredViewAsType((View)view, (int)2131296920, (String)"field 'mTopBar'", QMUITopBarLayout.class);
        webViewActivity.webView = (WebView)Utils.findRequiredViewAsType((View)view, (int)2131296919, (String)"field 'webView'", WebView.class);
    }

    public void unbind() {
        WebViewActivity webViewActivity = this.target;
        if (webViewActivity == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        webViewActivity.mTopBar = null;
        webViewActivity.webView = null;
    }
}
