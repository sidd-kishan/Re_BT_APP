/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$MediaItem
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallbackProxy
 *  android.support.v4.media.MediaBrowserCompatApi26$SubscriptionCallback
 *  android.support.v4.media.session.MediaSessionCompat
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaBrowserCompatApi26;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

static class MediaBrowserCompatApi26.SubscriptionCallbackProxy<T extends MediaBrowserCompatApi26.SubscriptionCallback>
extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
    MediaBrowserCompatApi26.SubscriptionCallbackProxy(T t) {
        super(t);
    }

    public void onChildrenLoaded(String string, List<MediaBrowser.MediaItem> list, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        ((MediaBrowserCompatApi26.SubscriptionCallback)this.mSubscriptionCallback).onChildrenLoaded(string, list, bundle);
    }

    public void onError(String string, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        ((MediaBrowserCompatApi26.SubscriptionCallback)this.mSubscriptionCallback).onError(string, bundle);
    }
}
