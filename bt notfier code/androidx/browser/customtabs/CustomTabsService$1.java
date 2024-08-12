/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder$DeathRecipient
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.ICustomTabsService$Stub
 *  androidx.browser.customtabs.CustomTabsService
 *  androidx.browser.customtabs.CustomTabsService$1$1
 *  androidx.browser.customtabs.CustomTabsSessionToken
 */
package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsSessionToken;
import java.util.List;
import java.util.Map;

class CustomTabsService.1
extends ICustomTabsService.Stub {
    final CustomTabsService this$0;

    CustomTabsService.1(CustomTabsService customTabsService) {
        this.this$0 = customTabsService;
    }

    public Bundle extraCommand(String string, Bundle bundle) {
        return this.this$0.extraCommand(string, bundle);
    }

    public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
        return this.this$0.mayLaunchUrl(new CustomTabsSessionToken(iCustomTabsCallback), uri, bundle, list);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
        1 var4_4;
        CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(iCustomTabsCallback);
        try {
            var4_4 = new /* Unavailable Anonymous Inner Class!! */;
            Map map = this.this$0.mDeathRecipientMap;
            synchronized (map) {
            }
        }
        catch (RemoteException remoteException) {
            return false;
        }
        {
            iCustomTabsCallback.asBinder().linkToDeath((IBinder.DeathRecipient)var4_4, 0);
            this.this$0.mDeathRecipientMap.put(iCustomTabsCallback.asBinder(), var4_4);
            return this.this$0.newSession(customTabsSessionToken);
        }
    }

    public int postMessage(ICustomTabsCallback iCustomTabsCallback, String string, Bundle bundle) {
        return this.this$0.postMessage(new CustomTabsSessionToken(iCustomTabsCallback), string, bundle);
    }

    public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
        return this.this$0.requestPostMessageChannel(new CustomTabsSessionToken(iCustomTabsCallback), uri);
    }

    public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
        return this.this$0.updateVisuals(new CustomTabsSessionToken(iCustomTabsCallback), bundle);
    }

    public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int n, Uri uri, Bundle bundle) {
        return this.this$0.validateRelationship(new CustomTabsSessionToken(iCustomTabsCallback), n, uri, bundle);
    }

    public boolean warmup(long l) {
        return this.this$0.warmup(l);
    }
}
