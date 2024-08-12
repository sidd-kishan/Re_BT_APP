/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.support.customtabs.ICustomTabsService
 *  androidx.browser.customtabs.CustomTabsClient
 *  androidx.browser.customtabs.CustomTabsServiceConnection
 */
package androidx.browser.customtabs;

import android.content.ComponentName;
import android.support.customtabs.ICustomTabsService;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;

class CustomTabsServiceConnection.1
extends CustomTabsClient {
    final CustomTabsServiceConnection this$0;

    CustomTabsServiceConnection.1(CustomTabsServiceConnection customTabsServiceConnection, ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.this$0 = customTabsServiceConnection;
        super(iCustomTabsService, componentName);
    }
}
