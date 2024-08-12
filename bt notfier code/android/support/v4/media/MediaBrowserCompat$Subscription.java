/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat$SubscriptionCallback
 *  androidx.media.MediaBrowserCompatUtils
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserCompatUtils;
import java.util.ArrayList;
import java.util.List;

private static class MediaBrowserCompat.Subscription {
    private final List<MediaBrowserCompat.SubscriptionCallback> mCallbacks = new ArrayList<MediaBrowserCompat.SubscriptionCallback>();
    private final List<Bundle> mOptionsList = new ArrayList<Bundle>();

    public MediaBrowserCompat.SubscriptionCallback getCallback(Bundle bundle) {
        int n = 0;
        while (n < this.mOptionsList.size()) {
            if (MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(n), (Bundle)bundle)) {
                return this.mCallbacks.get(n);
            }
            ++n;
        }
        return null;
    }

    public List<MediaBrowserCompat.SubscriptionCallback> getCallbacks() {
        return this.mCallbacks;
    }

    public List<Bundle> getOptionsList() {
        return this.mOptionsList;
    }

    public boolean isEmpty() {
        return this.mCallbacks.isEmpty();
    }

    public void putCallback(Bundle bundle, MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        int n = 0;
        while (true) {
            if (n >= this.mOptionsList.size()) {
                this.mCallbacks.add(subscriptionCallback);
                this.mOptionsList.add(bundle);
                return;
            }
            if (MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(n), (Bundle)bundle)) {
                this.mCallbacks.set(n, subscriptionCallback);
                return;
            }
            ++n;
        }
    }
}
