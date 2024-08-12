/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.support.v4.media.MediaBrowserCompat$SubscriptionCallback
 *  android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$StubApi21
 *  android.support.v4.media.MediaBrowserCompatApi26$SubscriptionCallback
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi26;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
private class MediaBrowserCompat.SubscriptionCallback.StubApi26
extends MediaBrowserCompat.SubscriptionCallback.StubApi21
implements MediaBrowserCompatApi26.SubscriptionCallback {
    final MediaBrowserCompat.SubscriptionCallback this$0;

    MediaBrowserCompat.SubscriptionCallback.StubApi26(MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        this.this$0 = subscriptionCallback;
        super(subscriptionCallback);
    }

    public void onChildrenLoaded(String string, List<?> list, Bundle bundle) {
        this.this$0.onChildrenLoaded(string, MediaBrowserCompat.MediaItem.fromMediaItemList(list), bundle);
    }

    public void onError(String string, Bundle bundle) {
        this.this$0.onError(string, bundle);
    }
}
