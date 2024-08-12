/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.support.v4.media.MediaBrowserCompat$ItemCallback
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.support.v4.media.MediaBrowserCompatApi23$ItemCallback
 */
package android.support.v4.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi23;

private class MediaBrowserCompat.ItemCallback.StubApi23
implements MediaBrowserCompatApi23.ItemCallback {
    final MediaBrowserCompat.ItemCallback this$0;

    MediaBrowserCompat.ItemCallback.StubApi23(MediaBrowserCompat.ItemCallback itemCallback) {
        this.this$0 = itemCallback;
    }

    public void onError(String string) {
        this.this$0.onError(string);
    }

    public void onItemLoaded(Parcel parcel) {
        if (parcel == null) {
            this.this$0.onItemLoaded(null);
        } else {
            parcel.setDataPosition(0);
            MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem)MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(parcel);
            parcel.recycle();
            this.this$0.onItemLoaded(mediaItem);
        }
    }
}
