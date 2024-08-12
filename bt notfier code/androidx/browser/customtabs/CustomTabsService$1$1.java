/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder$DeathRecipient
 *  androidx.browser.customtabs.CustomTabsService$1
 *  androidx.browser.customtabs.CustomTabsSessionToken
 */
package androidx.browser.customtabs;

import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsSessionToken;

class CustomTabsService.1
implements IBinder.DeathRecipient {
    final CustomTabsService.1 this$1;
    final CustomTabsSessionToken val$sessionToken;

    CustomTabsService.1(CustomTabsService.1 var1_1, CustomTabsSessionToken customTabsSessionToken) {
        this.this$1 = var1_1;
        this.val$sessionToken = customTabsSessionToken;
    }

    public void binderDied() {
        this.this$1.this$0.cleanUpSession(this.val$sessionToken);
    }
}
