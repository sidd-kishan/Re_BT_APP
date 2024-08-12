/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback
 *  android.support.v4.media.MediaBrowserCompat$ItemCallback
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21
 *  android.support.v4.media.MediaBrowserCompatApi23
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi23;

static class MediaBrowserCompat.MediaBrowserImplApi23
extends MediaBrowserCompat.MediaBrowserImplApi21 {
    MediaBrowserCompat.MediaBrowserImplApi23(Context context, ComponentName componentName, MediaBrowserCompat.ConnectionCallback connectionCallback, Bundle bundle) {
        super(context, componentName, connectionCallback, bundle);
    }

    public void getItem(String string, MediaBrowserCompat.ItemCallback itemCallback) {
        if (this.mServiceBinderWrapper == null) {
            MediaBrowserCompatApi23.getItem((Object)this.mBrowserObj, (String)string, (Object)itemCallback.mItemCallbackObj);
        } else {
            super.getItem(string, itemCallback);
        }
    }
}
