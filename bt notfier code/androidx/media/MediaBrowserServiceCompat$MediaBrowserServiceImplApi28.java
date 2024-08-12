/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.service.media.MediaBrowserService
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package androidx.media;

import android.service.media.MediaBrowserService;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;

class MediaBrowserServiceCompat.MediaBrowserServiceImplApi28
extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi26 {
    final MediaBrowserServiceCompat this$0;

    MediaBrowserServiceCompat.MediaBrowserServiceImplApi28(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
        super(mediaBrowserServiceCompat);
    }

    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        if (this.this$0.mCurConnection == null) return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService)this.mServiceObj).getCurrentBrowserInfo());
        return this.this$0.mCurConnection.browserInfo;
    }
}
