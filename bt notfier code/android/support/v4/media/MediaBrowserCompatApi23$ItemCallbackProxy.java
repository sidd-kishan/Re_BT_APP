/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$ItemCallback
 *  android.media.browse.MediaBrowser$MediaItem
 *  android.os.Parcel
 *  android.support.v4.media.MediaBrowserCompatApi23$ItemCallback
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompatApi23;

static class MediaBrowserCompatApi23.ItemCallbackProxy<T extends MediaBrowserCompatApi23.ItemCallback>
extends MediaBrowser.ItemCallback {
    protected final T mItemCallback;

    public MediaBrowserCompatApi23.ItemCallbackProxy(T t) {
        this.mItemCallback = t;
    }

    public void onError(String string) {
        this.mItemCallback.onError(string);
    }

    public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
        if (mediaItem == null) {
            this.mItemCallback.onItemLoaded(null);
        } else {
            Parcel parcel = Parcel.obtain();
            mediaItem.writeToParcel(parcel, 0);
            this.mItemCallback.onItemLoaded(parcel);
        }
    }
}
