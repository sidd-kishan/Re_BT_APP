/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.support.v4.media.MediaBrowserCompat$ItemCallback
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase
 */
package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat;

class MediaBrowserCompat.MediaBrowserImplBase.3
implements Runnable {
    final MediaBrowserCompat.MediaBrowserImplBase this$0;
    final MediaBrowserCompat.ItemCallback val$cb;
    final String val$mediaId;

    MediaBrowserCompat.MediaBrowserImplBase.3(MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase, MediaBrowserCompat.ItemCallback itemCallback, String string) {
        this.this$0 = mediaBrowserImplBase;
        this.val$cb = itemCallback;
        this.val$mediaId = string;
    }

    @Override
    public void run() {
        this.val$cb.onError(this.val$mediaId);
    }
}
