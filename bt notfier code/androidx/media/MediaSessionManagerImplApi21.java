/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.media.MediaSessionManager$RemoteUserInfoImpl
 *  androidx.media.MediaSessionManagerImplBase
 */
package androidx.media;

import android.content.Context;
import androidx.media.MediaSessionManager;
import androidx.media.MediaSessionManagerImplBase;

class MediaSessionManagerImplApi21
extends MediaSessionManagerImplBase {
    MediaSessionManagerImplApi21(Context context) {
        super(context);
        this.mContext = context;
    }

    private boolean hasMediaControlPermission(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        boolean bl = this.getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
        return bl;
    }

    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        boolean bl = this.hasMediaControlPermission(remoteUserInfoImpl) || super.isTrustedForMediaControl(remoteUserInfoImpl);
        return bl;
    }
}
