/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21
 *  android.support.v4.media.MediaBrowserCompat$SearchCallback
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

class MediaBrowserCompat.MediaBrowserImplApi21.4
implements Runnable {
    final MediaBrowserCompat.MediaBrowserImplApi21 this$0;
    final MediaBrowserCompat.SearchCallback val$callback;
    final Bundle val$extras;
    final String val$query;

    MediaBrowserCompat.MediaBrowserImplApi21.4(MediaBrowserCompat.MediaBrowserImplApi21 mediaBrowserImplApi21, MediaBrowserCompat.SearchCallback searchCallback, String string, Bundle bundle) {
        this.this$0 = mediaBrowserImplApi21;
        this.val$callback = searchCallback;
        this.val$query = string;
        this.val$extras = bundle;
    }

    @Override
    public void run() {
        this.val$callback.onError(this.val$query, this.val$extras);
    }
}
