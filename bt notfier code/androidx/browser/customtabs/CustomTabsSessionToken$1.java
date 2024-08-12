/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.util.Log
 *  androidx.browser.customtabs.CustomTabsCallback
 *  androidx.browser.customtabs.CustomTabsSessionToken
 */
package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsSessionToken;

class CustomTabsSessionToken.1
extends CustomTabsCallback {
    final CustomTabsSessionToken this$0;

    CustomTabsSessionToken.1(CustomTabsSessionToken customTabsSessionToken) {
        this.this$0 = customTabsSessionToken;
    }

    public void extraCallback(String string, Bundle bundle) {
        try {
            this.this$0.mCallbackBinder.extraCallback(string, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"CustomTabsSessionToken", (String)"RemoteException during ICustomTabsCallback transaction");
        }
    }

    public void onMessageChannelReady(Bundle bundle) {
        try {
            this.this$0.mCallbackBinder.onMessageChannelReady(bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"CustomTabsSessionToken", (String)"RemoteException during ICustomTabsCallback transaction");
        }
    }

    public void onNavigationEvent(int n, Bundle bundle) {
        try {
            this.this$0.mCallbackBinder.onNavigationEvent(n, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"CustomTabsSessionToken", (String)"RemoteException during ICustomTabsCallback transaction");
        }
    }

    public void onPostMessage(String string, Bundle bundle) {
        try {
            this.this$0.mCallbackBinder.onPostMessage(string, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"CustomTabsSessionToken", (String)"RemoteException during ICustomTabsCallback transaction");
        }
    }

    public void onRelationshipValidationResult(int n, Uri uri, boolean bl, Bundle bundle) {
        try {
            this.this$0.mCallbackBinder.onRelationshipValidationResult(n, uri, bl, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"CustomTabsSessionToken", (String)"RemoteException during ICustomTabsCallback transaction");
        }
    }
}
