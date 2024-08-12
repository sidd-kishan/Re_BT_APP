/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback$Stub
 *  androidx.browser.customtabs.CustomTabsCallback
 *  androidx.browser.customtabs.CustomTabsClient
 */
package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;

class CustomTabsClient.2
extends ICustomTabsCallback.Stub {
    private Handler mHandler;
    final CustomTabsClient this$0;
    final CustomTabsCallback val$callback;

    CustomTabsClient.2(CustomTabsClient customTabsClient, CustomTabsCallback customTabsCallback) {
        this.this$0 = customTabsClient;
        this.val$callback = customTabsCallback;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public void extraCallback(String string, Bundle bundle) throws RemoteException {
        if (this.val$callback == null) {
            return;
        }
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onMessageChannelReady(Bundle bundle) throws RemoteException {
        if (this.val$callback == null) {
            return;
        }
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onNavigationEvent(int n, Bundle bundle) {
        if (this.val$callback == null) {
            return;
        }
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onPostMessage(String string, Bundle bundle) throws RemoteException {
        if (this.val$callback == null) {
            return;
        }
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onRelationshipValidationResult(int n, Uri uri, boolean bl, Bundle bundle) throws RemoteException {
        if (this.val$callback == null) {
            return;
        }
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
