/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompatApi21$CallbackProxy
 *  android.support.v4.media.session.MediaSessionCompatApi23$Callback
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.MediaSessionCompatApi23;

static class MediaSessionCompatApi23.CallbackProxy<T extends MediaSessionCompatApi23.Callback>
extends MediaSessionCompatApi21.CallbackProxy<T> {
    public MediaSessionCompatApi23.CallbackProxy(T t) {
        super(t);
    }

    public void onPlayFromUri(Uri uri, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        ((MediaSessionCompatApi23.Callback)this.mCallback).onPlayFromUri(uri, bundle);
    }
}
