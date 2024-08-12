/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.media.MediaBrowserCompat$CustomActionCallback
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

class MediaBrowserCompat.MediaBrowserImplApi21.6
implements Runnable {
    final MediaBrowserCompat.MediaBrowserImplApi21 this$0;
    final String val$action;
    final MediaBrowserCompat.CustomActionCallback val$callback;
    final Bundle val$extras;

    MediaBrowserCompat.MediaBrowserImplApi21.6(MediaBrowserCompat.MediaBrowserImplApi21 mediaBrowserImplApi21, MediaBrowserCompat.CustomActionCallback customActionCallback, String string, Bundle bundle) {
        this.this$0 = mediaBrowserImplApi21;
        this.val$callback = customActionCallback;
        this.val$action = string;
        this.val$extras = bundle;
    }

    @Override
    public void run() {
        this.val$callback.onError(this.val$action, this.val$extras, null);
    }
}
