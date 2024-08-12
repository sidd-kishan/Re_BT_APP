/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.ResultReceiver
 *  android.support.v4.media.session.IMediaSession$Stub
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21
 *  androidx.core.app.BundleCompat
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompat;
import androidx.core.app.BundleCompat;
import java.lang.ref.WeakReference;

private static class MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver
extends ResultReceiver {
    private WeakReference<MediaControllerCompat.MediaControllerImplApi21> mMediaControllerImpl;

    MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 mediaControllerImplApi21) {
        super(null);
        this.mMediaControllerImpl = new WeakReference<MediaControllerCompat.MediaControllerImplApi21>(mediaControllerImplApi21);
    }

    protected void onReceiveResult(int n, Bundle bundle) {
        MediaControllerCompat.MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerCompat.MediaControllerImplApi21)this.mMediaControllerImpl.get();
        if (mediaControllerImplApi21 == null) return;
        if (bundle == null) {
            return;
        }
        Object object = mediaControllerImplApi21.mLock;
        synchronized (object) {
            mediaControllerImplApi21.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface((IBinder)BundleCompat.getBinder((Bundle)bundle, (String)"android.support.v4.media.session.EXTRA_BINDER")));
            mediaControllerImplApi21.mSessionToken.setSessionToken2Bundle(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
            mediaControllerImplApi21.processPendingCallbacksLocked();
            return;
        }
    }
}
