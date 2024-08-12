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

class CustomTabsClient.1
implements Runnable {
    final CustomTabsClient.2 this$1;
    final Bundle val$extras;
    final int val$navigationEvent;

    CustomTabsClient.1(CustomTabsClient.2 var1_1, int n, Bundle bundle) {
        this.this$1 = var1_1;
        this.val$navigationEvent = n;
        this.val$extras = bundle;
    }

    @Override
    public void run() {
        this.this$1.val$callback.onNavigationEvent(this.val$navigationEvent, this.val$extras);
    }
}
