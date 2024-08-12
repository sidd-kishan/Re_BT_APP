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

class CustomTabsClient.3
implements Runnable {
    final CustomTabsClient.2 this$1;
    final Bundle val$extras;

    CustomTabsClient.3(CustomTabsClient.2 var1_1, Bundle bundle) {
        this.this$1 = var1_1;
        this.val$extras = bundle;
    }

    @Override
    public void run() {
        this.this$1.val$callback.onMessageChannelReady(this.val$extras);
    }
}
