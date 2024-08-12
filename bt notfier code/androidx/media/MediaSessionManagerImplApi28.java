/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.session.MediaSessionManager
 *  androidx.media.MediaSessionManager$RemoteUserInfoImpl
 *  androidx.media.MediaSessionManagerImplApi21
 *  androidx.media.MediaSessionManagerImplApi28$RemoteUserInfoImplApi28
 */
package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.media.MediaSessionManager;
import androidx.media.MediaSessionManagerImplApi21;
import androidx.media.MediaSessionManagerImplApi28;

class MediaSessionManagerImplApi28
extends MediaSessionManagerImplApi21 {
    MediaSessionManager mObject;

    MediaSessionManagerImplApi28(Context context) {
        super(context);
        this.mObject = (MediaSessionManager)context.getSystemService("media_session");
    }

    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        if (!(remoteUserInfoImpl instanceof RemoteUserInfoImplApi28)) return false;
        return this.mObject.isTrustedForMediaControl(((RemoteUserInfoImplApi28)remoteUserInfoImpl).mObject);
    }
}
