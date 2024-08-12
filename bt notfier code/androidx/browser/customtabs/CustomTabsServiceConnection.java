/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  androidx.browser.customtabs.CustomTabsClient
 */
package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsClient;

public abstract class CustomTabsServiceConnection
implements ServiceConnection {
    public abstract void onCustomTabsServiceConnected(ComponentName var1, CustomTabsClient var2);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.onCustomTabsServiceConnected(componentName, (CustomTabsClient)new /* Unavailable Anonymous Inner Class!! */);
    }
}
