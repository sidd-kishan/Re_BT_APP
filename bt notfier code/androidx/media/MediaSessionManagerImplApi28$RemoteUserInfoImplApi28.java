/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaSessionManager$RemoteUserInfo
 *  androidx.core.util.ObjectsCompat
 *  androidx.media.MediaSessionManager$RemoteUserInfoImpl
 */
package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

static final class MediaSessionManagerImplApi28.RemoteUserInfoImplApi28
implements MediaSessionManager.RemoteUserInfoImpl {
    final MediaSessionManager.RemoteUserInfo mObject;

    MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.mObject = remoteUserInfo;
    }

    MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(String string, int n, int n2) {
        this.mObject = new MediaSessionManager.RemoteUserInfo(string, n, n2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MediaSessionManagerImplApi28.RemoteUserInfoImplApi28)) {
            return false;
        }
        object = (MediaSessionManagerImplApi28.RemoteUserInfoImplApi28)object;
        return this.mObject.equals((Object)((MediaSessionManagerImplApi28.RemoteUserInfoImplApi28)object).mObject);
    }

    public String getPackageName() {
        return this.mObject.getPackageName();
    }

    public int getPid() {
        return this.mObject.getPid();
    }

    public int getUid() {
        return this.mObject.getUid();
    }

    public int hashCode() {
        return ObjectsCompat.hash((Object[])new Object[]{this.mObject});
    }
}
