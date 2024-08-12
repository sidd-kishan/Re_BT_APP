/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.ICustomTabsCallback$Stub
 *  androidx.browser.customtabs.CustomTabsCallback
 *  androidx.browser.customtabs.CustomTabsSession
 *  androidx.browser.customtabs.CustomTabsSessionToken$MockCallback
 *  androidx.core.app.BundleCompat
 */
package androidx.browser.customtabs;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.CustomTabsSessionToken;
import androidx.core.app.BundleCompat;

public class CustomTabsSessionToken {
    private static final String TAG = "CustomTabsSessionToken";
    private final CustomTabsCallback mCallback;
    final ICustomTabsCallback mCallbackBinder;

    CustomTabsSessionToken(ICustomTabsCallback iCustomTabsCallback) {
        this.mCallbackBinder = iCustomTabsCallback;
        this.mCallback = new /* Unavailable Anonymous Inner Class!! */;
    }

    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken((ICustomTabsCallback)new MockCallback());
    }

    public static CustomTabsSessionToken getSessionTokenFromIntent(Intent intent) {
        if ((intent = BundleCompat.getBinder((Bundle)intent.getExtras(), (String)"android.support.customtabs.extra.SESSION")) != null) return new CustomTabsSessionToken(ICustomTabsCallback.Stub.asInterface((IBinder)intent));
        return null;
    }

    public boolean equals(Object object) {
        if (object instanceof CustomTabsSessionToken) return ((CustomTabsSessionToken)object).getCallbackBinder().equals(this.mCallbackBinder.asBinder());
        return false;
    }

    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    IBinder getCallbackBinder() {
        return this.mCallbackBinder.asBinder();
    }

    public int hashCode() {
        return this.getCallbackBinder().hashCode();
    }

    public boolean isAssociatedWith(CustomTabsSession customTabsSession) {
        return customTabsSession.getBinder().equals(this.mCallbackBinder);
    }
}
