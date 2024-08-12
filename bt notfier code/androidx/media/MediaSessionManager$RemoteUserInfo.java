/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaSessionManager$RemoteUserInfo
 *  android.os.Build$VERSION
 *  androidx.media.MediaSessionManager$RemoteUserInfoImpl
 *  androidx.media.MediaSessionManagerImplApi28$RemoteUserInfoImplApi28
 *  androidx.media.MediaSessionManagerImplBase$RemoteUserInfoImplBase
 */
package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;
import androidx.media.MediaSessionManager;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

public static final class MediaSessionManager.RemoteUserInfo {
    public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
    MediaSessionManager.RemoteUserInfoImpl mImpl;

    public MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
    }

    public MediaSessionManager.RemoteUserInfo(String string, int n, int n2) {
        this.mImpl = Build.VERSION.SDK_INT >= 28 ? new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(string, n, n2) : new MediaSessionManagerImplBase.RemoteUserInfoImplBase(string, n, n2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof MediaSessionManager.RemoteUserInfo) return this.mImpl.equals(((MediaSessionManager.RemoteUserInfo)object).mImpl);
        return false;
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public int getPid() {
        return this.mImpl.getPid();
    }

    public int getUid() {
        return this.mImpl.getUid();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }
}
