/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompatApi23$CallbackProxy
 *  android.support.v4.media.session.MediaSessionCompatApi24$Callback
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompatApi23;
import android.support.v4.media.session.MediaSessionCompatApi24;

static class MediaSessionCompatApi24.CallbackProxy<T extends MediaSessionCompatApi24.Callback>
extends MediaSessionCompatApi23.CallbackProxy<T> {
    public MediaSessionCompatApi24.CallbackProxy(T t) {
        super(t);
    }

    public void onPrepare() {
        ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepare();
    }

    public void onPrepareFromMediaId(String string, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepareFromMediaId(string, bundle);
    }

    public void onPrepareFromSearch(String string, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepareFromSearch(string, bundle);
    }

    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        ((MediaSessionCompatApi24.Callback)this.mCallback).onPrepareFromUri(uri, bundle);
    }
}
