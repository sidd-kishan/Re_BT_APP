/*
Java.perform(function(){

var type=Java.use("com.lianhezhuli.btnotification.function.WebViewActivity");
type.initView.implementation = function () {
  //webView.getSettings().setJavaScriptEnabled(true);
  //webView.loadUrl("https://bt.lianhezhuli.com/static/notification/privacy_policy_gp.html");
 return;
}

});
*/
Java.perform(function(){
		
		
		var WebView = Java.use("android.webkit.WebView");
		console.log(WebView);
		console.log(WebView.setWebContentsDebuggingEnabled);
		
		WebView.loadUrl.overload('java.lang.String').implementation=function(p0){
            console.log("WebView.loadUrl p0:" + p0);
            var r0 = this.loadUrl(p0);
			this.setWebContentsDebuggingEnabled(true);
			console.log("WebView.loadUrl r0:" + r0);
			return r0;
        }
		WebView.loadUrl.overload('java.lang.String', 'java.util.Map').implementation=function(p0,p1){
            console.log("WebView.loadUrl p0:" + p0 + "\n                p1:"+p1);
            var r0 = this.loadUrl(p0);
			this.setWebContentsDebuggingEnabled(true);
			console.log("WebView.loadUrl r0:" + r0);
			return r0;
        }
 	
    });
