/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.support.v4.media.MediaBrowserCompat$ItemCallback
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21
 */
package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat;

class MediaBrowserCompat.MediaBrowserImplApi21.1
implements Runnable {
    final MediaBrowserCompat.MediaBrowserImplApi21 this$0;
    final MediaBrowserCompat.ItemCallback val$cb;
    final String val$mediaId;

    MediaBrowserCompat.MediaBrowserImplApi21.1(MediaBrowserCompat.MediaBrowserImplApi21 mediaBrowserImplApi21, MediaBrowserCompat.ItemCallback itemCallback, String string) {
        this.this$0 = mediaBrowserImplApi21;
        this.val$cb = itemCallback;
        this.val$mediaId = string;
    }

    @Override
    public void run() {
        this.val$cb.onError(this.val$mediaId);
    }
}
