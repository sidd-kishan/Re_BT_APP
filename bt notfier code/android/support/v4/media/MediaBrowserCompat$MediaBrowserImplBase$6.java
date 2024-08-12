/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat$CustomActionCallback
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

class MediaBrowserCompat.MediaBrowserImplBase.6
implements Runnable {
    final MediaBrowserCompat.MediaBrowserImplBase this$0;
    final String val$action;
    final MediaBrowserCompat.CustomActionCallback val$callback;
    final Bundle val$extras;

    MediaBrowserCompat.MediaBrowserImplBase.6(MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase, MediaBrowserCompat.CustomActionCallback customActionCallback, String string, Bundle bundle) {
        this.this$0 = mediaBrowserImplBase;
        this.val$callback = customActionCallback;
        this.val$action = string;
        this.val$extras = bundle;
    }

    @Override
    public void run() {
        this.val$callback.onError(this.val$action, this.val$extras, null);
    }
}
