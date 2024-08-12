/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21
 *  android.support.v4.media.session.MediaControllerCompat$TransportControls
 *  android.support.v4.media.session.MediaControllerCompat$TransportControlsApi23
 *  android.support.v4.media.session.MediaControllerCompatApi21
 *  android.support.v4.media.session.MediaSessionCompat$Token
 */
package android.support.v4.media.session;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;

static class MediaControllerCompat.MediaControllerImplApi23
extends MediaControllerCompat.MediaControllerImplApi21 {
    public MediaControllerCompat.MediaControllerImplApi23(Context context, MediaSessionCompat.Token token) throws RemoteException {
        super(context, token);
    }

    public MediaControllerCompat.TransportControls getTransportControls() {
        Object object = MediaControllerCompatApi21.getTransportControls((Object)this.mControllerObj);
        object = object != null ? new MediaControllerCompat.TransportControlsApi23(object) : null;
        return object;
    }
}
