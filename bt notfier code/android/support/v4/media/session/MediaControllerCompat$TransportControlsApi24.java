/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.media.session.MediaControllerCompat$TransportControlsApi23
 *  android.support.v4.media.session.MediaControllerCompatApi24$TransportControls
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompatApi24;

static class MediaControllerCompat.TransportControlsApi24
extends MediaControllerCompat.TransportControlsApi23 {
    public MediaControllerCompat.TransportControlsApi24(Object object) {
        super(object);
    }

    public void prepare() {
        MediaControllerCompatApi24.TransportControls.prepare((Object)this.mControlsObj);
    }

    public void prepareFromMediaId(String string, Bundle bundle) {
        MediaControllerCompatApi24.TransportControls.prepareFromMediaId((Object)this.mControlsObj, (String)string, (Bundle)bundle);
    }

    public void prepareFromSearch(String string, Bundle bundle) {
        MediaControllerCompatApi24.TransportControls.prepareFromSearch((Object)this.mControlsObj, (String)string, (Bundle)bundle);
    }

    public void prepareFromUri(Uri uri, Bundle bundle) {
        MediaControllerCompatApi24.TransportControls.prepareFromUri((Object)this.mControlsObj, (Uri)uri, (Bundle)bundle);
    }
}
