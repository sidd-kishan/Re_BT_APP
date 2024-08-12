/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser
 *  android.media.browse.MediaBrowser$SubscriptionCallback
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompatApi26$SubscriptionCallback
 *  android.support.v4.media.MediaBrowserCompatApi26$SubscriptionCallbackProxy
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompatApi26;

class MediaBrowserCompatApi26 {
    private MediaBrowserCompatApi26() {
    }

    static Object createSubscriptionCallback(SubscriptionCallback subscriptionCallback) {
        return new SubscriptionCallbackProxy(subscriptionCallback);
    }

    public static void subscribe(Object object, String string, Bundle bundle, Object object2) {
        ((MediaBrowser)object).subscribe(string, bundle, (MediaBrowser.SubscriptionCallback)object2);
    }

    public static void unsubscribe(Object object, String string, Object object2) {
        ((MediaBrowser)object).unsubscribe(string, (MediaBrowser.SubscriptionCallback)object2);
    }
}
