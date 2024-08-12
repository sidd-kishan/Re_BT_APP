/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  butterknife.BindView
 *  com.lianhezhuli.btnotification.base.BaseActivity
 *  com.lianhezhuli.btnotification.function._$$Lambda$WebViewActivity$_8tSgNxI_yjDE59T2gc6Usg0g1w
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import com.lianhezhuli.btnotification.base.BaseActivity;
import com.lianhezhuli.btnotification.function._$;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class WebViewActivity
extends BaseActivity {
    @BindView(value=2131296920)
    QMUITopBarLayout mTopBar;
    @BindView(value=2131296919)
    WebView webView;

    protected void initView() {
        this.mTopBar.setTitle(2131755299);
        this.mTopBar.addLeftBackImageButton().setOnClickListener((View.OnClickListener)new _$.Lambda.WebViewActivity._8tSgNxI_yjDE59T2gc6Usg0g1w(this));
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl("https://bt.lianhezhuli.com/static/notification/privacy_policy_gp.html");
        this.webView.setWebViewClient((WebViewClient)new /* Unavailable Anonymous Inner Class!! */);
        this.webView.setWebChromeClient(new WebChromeClient());
    }

    public /* synthetic */ void lambda$initView$0$WebViewActivity(View view) {
        this.finish();
    }

    protected int setLayoutId() {
        return 2131492901;
    }
}
