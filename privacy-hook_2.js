Java.perform(function(){
Java.choose("com.lianhezhuli.btnotification.function.WebViewActivity", { 
"onMatch":function(instance){
console.log("[*] Instance found, result: ", instance);
//instance.webView.loadUrl("https://bt.lianhezhuli.com/static/notification/privacy_policy_gp.html");
const secret = Java.cast(instance, Java.use('com.lianhezhuli.btnotification.function.WebViewActivity'));

secret.webView.loadUrl("https://bt.lianhezhuli.com/static/notification/privacy_policy_gp.html");
        

},
"onComplete":function() {
console.log("[*] Finished heap search")
}
});
});
