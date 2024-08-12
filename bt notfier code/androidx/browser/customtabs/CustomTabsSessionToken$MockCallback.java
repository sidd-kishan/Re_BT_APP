/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.support.customtabs.ICustomTabsCallback$Stub
 */
package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;

static class CustomTabsSessionToken.MockCallback
extends ICustomTabsCallback.Stub {
    CustomTabsSessionToken.MockCallback() {
    }

    public IBinder asBinder() {
        return this;
    }

    public void extraCallback(String string, Bundle bundle) {
    }

    public void onMessageChannelReady(Bundle bundle) {
    }

    public void onNavigationEvent(int n, Bundle bundle) {
    }

    public void onPostMessage(String string, Bundle bundle) {
    }

    public void onRelationshipValidationResult(int n, Uri uri, boolean bl, Bundle bundle) {
    }
}
