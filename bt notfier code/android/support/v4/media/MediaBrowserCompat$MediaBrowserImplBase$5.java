/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase
 *  android.support.v4.media.MediaBrowserCompat$SearchCallback
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

class MediaBrowserCompat.MediaBrowserImplBase.5
implements Runnable {
    final MediaBrowserCompat.MediaBrowserImplBase this$0;
    final MediaBrowserCompat.SearchCallback val$callback;
    final Bundle val$extras;
    final String val$query;

    MediaBrowserCompat.MediaBrowserImplBase.5(MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase, MediaBrowserCompat.SearchCallback searchCallback, String string, Bundle bundle) {
        this.this$0 = mediaBrowserImplBase;
        this.val$callback = searchCallback;
        this.val$query = string;
        this.val$extras = bundle;
    }

    @Override
    public void run() {
        this.val$callback.onError(this.val$query, this.val$extras);
    }
}
