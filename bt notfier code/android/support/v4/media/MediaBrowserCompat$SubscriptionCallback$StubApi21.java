/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.support.v4.media.MediaBrowserCompat$Subscription
 *  android.support.v4.media.MediaBrowserCompat$SubscriptionCallback
 *  android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi21;
import java.util.Collections;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
private class MediaBrowserCompat.SubscriptionCallback.StubApi21
implements MediaBrowserCompatApi21.SubscriptionCallback {
    final MediaBrowserCompat.SubscriptionCallback this$0;

    MediaBrowserCompat.SubscriptionCallback.StubApi21(MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        this.this$0 = subscriptionCallback;
    }

    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int n = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int n2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (n == -1 && n2 == -1) {
            return list;
        }
        int n3 = n2 * n;
        int n4 = n3 + n2;
        if (n < 0) return Collections.emptyList();
        if (n2 < 1) return Collections.emptyList();
        if (n3 >= list.size()) {
            return Collections.emptyList();
        }
        n = n4;
        if (n4 <= list.size()) return list.subList(n3, n);
        n = list.size();
        return list.subList(n3, n);
    }

    public void onChildrenLoaded(String string, List<?> list) {
        Object object = this.this$0.mSubscriptionRef == null ? null : (MediaBrowserCompat.Subscription)this.this$0.mSubscriptionRef.get();
        if (object == null) {
            this.this$0.onChildrenLoaded(string, MediaBrowserCompat.MediaItem.fromMediaItemList((List)list));
            return;
        }
        list = MediaBrowserCompat.MediaItem.fromMediaItemList(list);
        List list2 = object.getCallbacks();
        object = object.getOptionsList();
        int n = 0;
        while (n < list2.size()) {
            Bundle bundle = (Bundle)object.get(n);
            if (bundle == null) {
                this.this$0.onChildrenLoaded(string, list);
            } else {
                this.this$0.onChildrenLoaded(string, this.applyOptions(list, bundle), bundle);
            }
            ++n;
        }
    }

    public void onError(String string) {
        this.this$0.onError(string);
    }
}
