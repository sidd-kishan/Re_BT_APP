/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.Rating
 *  android.media.RemoteControlClient$OnMetadataUpdateListener
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19
 */
package android.support.v4.media.session;

import android.media.Rating;
import android.media.RemoteControlClient;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;

class MediaSessionCompat.MediaSessionImplApi19.1
implements RemoteControlClient.OnMetadataUpdateListener {
    final MediaSessionCompat.MediaSessionImplApi19 this$0;

    MediaSessionCompat.MediaSessionImplApi19.1(MediaSessionCompat.MediaSessionImplApi19 mediaSessionImplApi19) {
        this.this$0 = mediaSessionImplApi19;
    }

    public void onMetadataUpdate(int n, Object object) {
        if (n != 0x10000001) return;
        if (!(object instanceof Rating)) return;
        this.this$0.postToHandler(19, -1, -1, (Object)RatingCompat.fromRating((Object)object), null);
    }
}
