/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.support.v4.media.session.MediaSessionCompat$Callback$StubApi23
 *  android.support.v4.media.session.MediaSessionCompatApi24$Callback
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompatApi24;

private class MediaSessionCompat.Callback.StubApi24
extends MediaSessionCompat.Callback.StubApi23
implements MediaSessionCompatApi24.Callback {
    final MediaSessionCompat.Callback this$0;

    MediaSessionCompat.Callback.StubApi24(MediaSessionCompat.Callback callback) {
        this.this$0 = callback;
        super(callback);
    }

    public void onPrepare() {
        this.this$0.onPrepare();
    }

    public void onPrepareFromMediaId(String string, Bundle bundle) {
        this.this$0.onPrepareFromMediaId(string, bundle);
    }

    public void onPrepareFromSearch(String string, Bundle bundle) {
        this.this$0.onPrepareFromSearch(string, bundle);
    }

    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        this.this$0.onPrepareFromUri(uri, bundle);
    }
}
