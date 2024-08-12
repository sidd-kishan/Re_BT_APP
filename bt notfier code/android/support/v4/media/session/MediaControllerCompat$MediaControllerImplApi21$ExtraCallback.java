/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.MediaControllerCompat$Callback
 *  android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.ParcelableVolumeInfo
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import java.util.List;

private static class MediaControllerCompat.MediaControllerImplApi21.ExtraCallback
extends MediaControllerCompat.Callback.StubCompat {
    MediaControllerCompat.MediaControllerImplApi21.ExtraCallback(MediaControllerCompat.Callback callback) {
        super(callback);
    }

    public void onExtrasChanged(Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
        throw new AssertionError();
    }

    public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
        throw new AssertionError();
    }

    public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
        throw new AssertionError();
    }

    public void onSessionDestroyed() throws RemoteException {
        throw new AssertionError();
    }

    public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
        throw new AssertionError();
    }
}
