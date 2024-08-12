/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.support.v4.media.MediaBrowserCompat$Subscription
 *  android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$StubApi21
 *  android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$StubApi26
 *  android.support.v4.media.MediaBrowserCompatApi21
 *  android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback
 *  android.support.v4.media.MediaBrowserCompatApi26
 *  android.support.v4.media.MediaBrowserCompatApi26$SubscriptionCallback
 */
package android.support.v4.media;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaBrowserCompatApi26;
import java.lang.ref.WeakReference;
import java.util.List;

public static abstract class MediaBrowserCompat.SubscriptionCallback {
    final Object mSubscriptionCallbackObj;
    WeakReference<MediaBrowserCompat.Subscription> mSubscriptionRef;
    final IBinder mToken = new Binder();

    public MediaBrowserCompat.SubscriptionCallback() {
        this.mSubscriptionCallbackObj = Build.VERSION.SDK_INT >= 26 ? MediaBrowserCompatApi26.createSubscriptionCallback((MediaBrowserCompatApi26.SubscriptionCallback)new StubApi26(this)) : (Build.VERSION.SDK_INT >= 21 ? MediaBrowserCompatApi21.createSubscriptionCallback((MediaBrowserCompatApi21.SubscriptionCallback)new StubApi21(this)) : null);
    }

    public void onChildrenLoaded(String string, List<MediaBrowserCompat.MediaItem> list) {
    }

    public void onChildrenLoaded(String string, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
    }

    public void onError(String string) {
    }

    public void onError(String string, Bundle bundle) {
    }

    void setSubscription(MediaBrowserCompat.Subscription subscription) {
        this.mSubscriptionRef = new WeakReference<MediaBrowserCompat.Subscription>(subscription);
    }
}
