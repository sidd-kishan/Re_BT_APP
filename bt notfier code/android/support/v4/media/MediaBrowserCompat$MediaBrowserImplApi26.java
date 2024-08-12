/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi23
 *  android.support.v4.media.MediaBrowserCompat$SubscriptionCallback
 *  android.support.v4.media.MediaBrowserCompatApi21
 *  android.support.v4.media.MediaBrowserCompatApi26
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaBrowserCompatApi26;

static class MediaBrowserCompat.MediaBrowserImplApi26
extends MediaBrowserCompat.MediaBrowserImplApi23 {
    MediaBrowserCompat.MediaBrowserImplApi26(Context context, ComponentName componentName, MediaBrowserCompat.ConnectionCallback connectionCallback, Bundle bundle) {
        super(context, componentName, connectionCallback, bundle);
    }

    public void subscribe(String string, Bundle bundle, MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
            super.subscribe(string, bundle, subscriptionCallback);
        } else if (bundle == null) {
            MediaBrowserCompatApi21.subscribe((Object)this.mBrowserObj, (String)string, (Object)subscriptionCallback.mSubscriptionCallbackObj);
        } else {
            MediaBrowserCompatApi26.subscribe((Object)this.mBrowserObj, (String)string, (Bundle)bundle, (Object)subscriptionCallback.mSubscriptionCallbackObj);
        }
    }

    public void unsubscribe(String string, MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
            super.unsubscribe(string, subscriptionCallback);
        } else if (subscriptionCallback == null) {
            MediaBrowserCompatApi21.unsubscribe((Object)this.mBrowserObj, (String)string);
        } else {
            MediaBrowserCompatApi26.unsubscribe((Object)this.mBrowserObj, (String)string, (Object)subscriptionCallback.mSubscriptionCallbackObj);
        }
    }
}
