/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  androidx.browser.customtabs.CustomTabsClient$2
 */
package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsClient;

class CustomTabsClient.5
implements Runnable {
    final CustomTabsClient.2 this$1;
    final Bundle val$extras;
    final int val$relation;
    final Uri val$requestedOrigin;
    final boolean val$result;

    CustomTabsClient.5(CustomTabsClient.2 var1_1, int n, Uri uri, boolean bl, Bundle bundle) {
        this.this$1 = var1_1;
        this.val$relation = n;
        this.val$requestedOrigin = uri;
        this.val$result = bl;
        this.val$extras = bundle;
    }

    @Override
    public void run() {
        this.this$1.val$callback.onRelationshipValidationResult(this.val$relation, this.val$requestedOrigin, this.val$result, this.val$extras);
    }
}
