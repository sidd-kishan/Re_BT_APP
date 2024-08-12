/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.media.browse.MediaBrowser
 *  android.media.browse.MediaBrowser$ConnectionCallback
 *  android.media.browse.MediaBrowser$SubscriptionCallback
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback
 *  android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallbackProxy
 *  android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback
 *  android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallbackProxy
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompatApi21;

class MediaBrowserCompatApi21 {
    static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    private MediaBrowserCompatApi21() {
    }

    public static void connect(Object object) {
        ((MediaBrowser)object).connect();
    }

    public static Object createBrowser(Context context, ComponentName componentName, Object object, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback)object, bundle);
    }

    public static Object createConnectionCallback(ConnectionCallback connectionCallback) {
        return new ConnectionCallbackProxy(connectionCallback);
    }

    public static Object createSubscriptionCallback(SubscriptionCallback subscriptionCallback) {
        return new SubscriptionCallbackProxy(subscriptionCallback);
    }

    public static void disconnect(Object object) {
        ((MediaBrowser)object).disconnect();
    }

    public static Bundle getExtras(Object object) {
        return ((MediaBrowser)object).getExtras();
    }

    public static String getRoot(Object object) {
        return ((MediaBrowser)object).getRoot();
    }

    public static ComponentName getServiceComponent(Object object) {
        return ((MediaBrowser)object).getServiceComponent();
    }

    public static Object getSessionToken(Object object) {
        return ((MediaBrowser)object).getSessionToken();
    }

    public static boolean isConnected(Object object) {
        return ((MediaBrowser)object).isConnected();
    }

    public static void subscribe(Object object, String string, Object object2) {
        ((MediaBrowser)object).subscribe(string, (MediaBrowser.SubscriptionCallback)object2);
    }

    public static void unsubscribe(Object object, String string) {
        ((MediaBrowser)object).unsubscribe(string);
    }
}
