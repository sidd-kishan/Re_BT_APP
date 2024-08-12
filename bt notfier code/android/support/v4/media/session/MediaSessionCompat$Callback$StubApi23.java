/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.support.v4.media.session.MediaSessionCompat$Callback$StubApi21
 *  android.support.v4.media.session.MediaSessionCompatApi23$Callback
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompatApi23;

private class MediaSessionCompat.Callback.StubApi23
extends MediaSessionCompat.Callback.StubApi21
implements MediaSessionCompatApi23.Callback {
    final MediaSessionCompat.Callback this$0;

    MediaSessionCompat.Callback.StubApi23(MediaSessionCompat.Callback callback) {
        this.this$0 = callback;
        super(callback);
    }

    public void onPlayFromUri(Uri uri, Bundle bundle) {
        this.this$0.onPlayFromUri(uri, bundle);
    }
}
