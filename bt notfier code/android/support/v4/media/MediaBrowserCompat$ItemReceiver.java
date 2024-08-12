/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.support.v4.media.MediaBrowserCompat$ItemCallback
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.os.ResultReceiver
 */
package android.support.v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;

private static class MediaBrowserCompat.ItemReceiver
extends ResultReceiver {
    private final MediaBrowserCompat.ItemCallback mCallback;
    private final String mMediaId;

    MediaBrowserCompat.ItemReceiver(String string, MediaBrowserCompat.ItemCallback itemCallback, Handler handler) {
        super(handler);
        this.mMediaId = string;
        this.mCallback = itemCallback;
    }

    protected void onReceiveResult(int n, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        if (n == 0 && bundle != null && bundle.containsKey("media_item")) {
            if ((bundle = bundle.getParcelable("media_item")) != null && !(bundle instanceof MediaBrowserCompat.MediaItem)) {
                this.mCallback.onError(this.mMediaId);
            } else {
                this.mCallback.onItemLoaded((MediaBrowserCompat.MediaItem)bundle);
            }
            return;
        }
        this.mCallback.onError(this.mMediaId);
    }
}
