/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  androidx.browser.customtabs.CustomTabsClient
 *  androidx.browser.customtabs.CustomTabsServiceConnection
 */
package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;

static final class CustomTabsClient.1
extends CustomTabsServiceConnection {
    final Context val$applicationContext;

    CustomTabsClient.1(Context context) {
        this.val$applicationContext = context;
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        customTabsClient.warmup(0L);
        this.val$applicationContext.unbindService((ServiceConnection)this);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
