/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.browser.customtabs.CustomTabsClient$2
 */
package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsClient;

class CustomTabsClient.2
implements Runnable {
    final CustomTabsClient.2 this$1;
    final Bundle val$args;
    final String val$callbackName;

    CustomTabsClient.2(CustomTabsClient.2 var1_1, String string, Bundle bundle) {
        this.this$1 = var1_1;
        this.val$callbackName = string;
        this.val$args = bundle;
    }

    @Override
    public void run() {
        this.this$1.val$callback.extraCallback(this.val$callbackName, this.val$args);
    }
}
