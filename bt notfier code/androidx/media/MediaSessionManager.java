/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.media.MediaSessionManager$MediaSessionManagerImpl
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 *  androidx.media.MediaSessionManagerImplApi21
 *  androidx.media.MediaSessionManagerImplApi28
 *  androidx.media.MediaSessionManagerImplBase
 */
package androidx.media;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.media.MediaSessionManager;
import androidx.media.MediaSessionManagerImplApi21;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

public final class MediaSessionManager {
    static final boolean DEBUG = Log.isLoggable((String)"MediaSessionManager", (int)3);
    static final String TAG = "MediaSessionManager";
    private static final Object sLock = new Object();
    private static volatile MediaSessionManager sSessionManager;
    MediaSessionManagerImpl mImpl;

    private MediaSessionManager(Context context) {
        this.mImpl = Build.VERSION.SDK_INT >= 28 ? new MediaSessionManagerImplApi28(context) : (Build.VERSION.SDK_INT >= 21 ? new MediaSessionManagerImplApi21(context) : new MediaSessionManagerImplBase(context));
    }

    public static MediaSessionManager getSessionManager(Context context) {
        MediaSessionManager mediaSessionManager;
        MediaSessionManager mediaSessionManager2 = mediaSessionManager = sSessionManager;
        if (mediaSessionManager != null) return mediaSessionManager2;
        Object object = sLock;
        synchronized (object) {
            mediaSessionManager2 = mediaSessionManager = sSessionManager;
            if (mediaSessionManager != null) return mediaSessionManager2;
            mediaSessionManager2 = sSessionManager = (mediaSessionManager2 = new MediaSessionManager(context.getApplicationContext()));
        }
        return mediaSessionManager2;
    }

    Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo == null) throw new IllegalArgumentException("userInfo should not be null");
        return this.mImpl.isTrustedForMediaControl(remoteUserInfo.mImpl);
    }
}
