/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$MediaItem
 *  android.media.browse.MediaBrowser$SubscriptionCallback
 *  android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.support.v4.media.MediaBrowserCompatApi21;
import java.util.List;

static class MediaBrowserCompatApi21.SubscriptionCallbackProxy<T extends MediaBrowserCompatApi21.SubscriptionCallback>
extends MediaBrowser.SubscriptionCallback {
    protected final T mSubscriptionCallback;

    public MediaBrowserCompatApi21.SubscriptionCallbackProxy(T t) {
        this.mSubscriptionCallback = t;
    }

    public void onChildrenLoaded(String string, List<MediaBrowser.MediaItem> list) {
        this.mSubscriptionCallback.onChildrenLoaded(string, list);
    }

    public void onError(String string) {
        this.mSubscriptionCallback.onError(string);
    }
}
