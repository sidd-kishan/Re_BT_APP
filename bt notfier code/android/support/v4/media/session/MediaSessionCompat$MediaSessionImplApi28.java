/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.session.MediaSession
 *  android.os.Bundle
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaSessionManager;

static class MediaSessionCompat.MediaSessionImplApi28
extends MediaSessionCompat.MediaSessionImplApi21 {
    MediaSessionCompat.MediaSessionImplApi28(Context context, String string, Bundle bundle) {
        super(context, string, bundle);
    }

    MediaSessionCompat.MediaSessionImplApi28(Object object) {
        super(object);
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return new MediaSessionManager.RemoteUserInfo(((MediaSession)this.mSessionObj).getCurrentControllerInfo());
    }

    public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
    }
}
