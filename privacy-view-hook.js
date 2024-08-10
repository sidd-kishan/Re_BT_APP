Java.perform(function(){

/*
var type=Java.use("com.lianhezhuli.btnotification.function.WebViewActivity");
type.WebViewActivity('android.view.View').implementation = function (view){
console.log(view.value)
}
*/

var type=Java.use("com.lianhezhuli.btnotification.function.WebViewActivity");

type.initView.implementation = function () {

//const webview = Java.use('android.webkit.WebView');
const webview = Java.cast(this.findViewById(2131296919),Java.use('android.webkit.WebView'));
this.webview = webview;
var context = Java.use('android.app.ActivityThread').currentApplication().getApplicationContext();
const webviewinstance = webview.$new(context);
webviewinstance.getSettings().setJavaScriptEnabled(true);
webviewinstance.loadUrl("https://bt.lianhezhuli.com/static/notification/privacy_policy_gp.html");

const webchromeclnt = Java.use('android.webkit.WebChromeClient');

const WebViewClient = Java.use("android.webkit.WebViewClient");
const webViewClient = WebViewClient.$new();
/*
webViewClient.shouldOverrideUrlLoading('android.webkit.WebView', 'java.lang.String').implementation = function(view, url) {
    view.loadUrl(url);
    return true;
}
*/
var shouldOverrideUrlLoading = webViewClient.shouldOverrideUrlLoading.overload('android.webkit.WebView', 'java.lang.String');
shouldOverrideUrlLoading.implementation = function(view, url) {
    console.log(redColor + "[WebView URL]: " + url + resetColor);
    view.loadUrl(url);
    return true;
};
webviewinstance.setWebViewClient(webViewClient);
/*
('android.webkit.WebView','java.lang.String')
this.webView.setWebViewClient(new WebViewClient(this){
            final WebViewActivity this$0;
            {
                this.this$0 = webViewActivity;
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String string) {
                webView.loadUrl(string);
                return true;
            }
        });
*/
//webviewinstance.setWebChromeClient(webchromeclnt.$new());
//this.webView = webview;
//const view = webview.$new().getSettings();
//view.value = ;

//console.log(JSON.stringify(ptr(this.webView._p[3])));
return;
}


/*
var type=Java.use("com.lianhezhuli.btnotification.function.WebViewActivity_ViewBinding");

type.$init.overload('com.lianhezhuli.btnotification.function.WebViewActivity' , 'android.view.View').implementation = function(webViewActivity, view) {
this.target.value = webViewActivity;

const QMUIT = Java.use("com.qmuiteam.qmui.widget.QMUITopBarLayout");

const util = Java.use("butterknife.internal.Utils");
const util_obj=util.findRequiredViewAsType(view, 2131296920, "field 'mTopBar'", QMUIT.class);

}
*/

/*
type.$init.overload().implementation = function() {
    console.log(`before $init: ${this}`)
    this.$init()
    console.log(`after $init: ${this}`)     // <-- same value before $init()
    this.webView.loadUrl("https://bt.lianhezhuli.com/static/notification/privacy_policy_gp.html");
    this.initView()


    // also you should not return any value here
}
*/

});
