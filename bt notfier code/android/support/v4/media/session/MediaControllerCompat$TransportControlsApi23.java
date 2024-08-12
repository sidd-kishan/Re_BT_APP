/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21
 *  android.support.v4.media.session.MediaControllerCompatApi23$TransportControls
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompatApi23;

static class MediaControllerCompat.TransportControlsApi23
extends MediaControllerCompat.TransportControlsApi21 {
    public MediaControllerCompat.TransportControlsApi23(Object object) {
        super(object);
    }

    public void playFromUri(Uri uri, Bundle bundle) {
        MediaControllerCompatApi23.TransportControls.playFromUri((Object)this.mControlsObj, (Uri)uri, (Bundle)bundle);
    }
}
