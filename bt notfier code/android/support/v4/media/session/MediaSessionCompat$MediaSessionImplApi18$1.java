/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.RemoteControlClient$OnPlaybackPositionUpdateListener
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18
 */
package android.support.v4.media.session;

import android.media.RemoteControlClient;
import android.support.v4.media.session.MediaSessionCompat;

class MediaSessionCompat.MediaSessionImplApi18.1
implements RemoteControlClient.OnPlaybackPositionUpdateListener {
    final MediaSessionCompat.MediaSessionImplApi18 this$0;

    MediaSessionCompat.MediaSessionImplApi18.1(MediaSessionCompat.MediaSessionImplApi18 mediaSessionImplApi18) {
        this.this$0 = mediaSessionImplApi18;
    }

    public void onPlaybackPositionUpdate(long l) {
        this.this$0.postToHandler(18, -1, -1, (Object)l, null);
    }
}
