/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.IMediaControllerCallback$Stub
 *  android.support.v4.media.session.MediaControllerCompat$Callback
 *  android.support.v4.media.session.MediaControllerCompat$PlaybackInfo
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  android.support.v4.media.session.PlaybackStateCompat
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.lang.ref.WeakReference;
import java.util.List;

private static class MediaControllerCompat.Callback.StubCompat
extends IMediaControllerCallback.Stub {
    private final WeakReference<MediaControllerCompat.Callback> mCallback;

    MediaControllerCompat.Callback.StubCompat(MediaControllerCompat.Callback callback) {
        this.mCallback = new WeakReference<MediaControllerCompat.Callback>(callback);
    }

    public void onCaptioningEnabledChanged(boolean bl) throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(11, (Object)bl, null);
    }

    public void onEvent(String string, Bundle bundle) throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(1, (Object)string, bundle);
    }

    public void onExtrasChanged(Bundle bundle) throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(7, (Object)bundle, null);
    }

    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(3, (Object)mediaMetadataCompat, null);
    }

    public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(2, (Object)playbackStateCompat, null);
    }

    public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(5, list, null);
    }

    public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(6, (Object)charSequence, null);
    }

    public void onRepeatModeChanged(int n) throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(9, (Object)n, null);
    }

    public void onSessionDestroyed() throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(8, null, null);
    }

    public void onSessionReady() throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(13, null, null);
    }

    public void onShuffleModeChanged(int n) throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.postToHandler(12, (Object)n, null);
    }

    public void onShuffleModeChangedRemoved(boolean bl) throws RemoteException {
    }

    public void onVolumeInfoChanged(ParcelableVolumeInfo object) throws RemoteException {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        object = object != null ? new MediaControllerCompat.PlaybackInfo(object.volumeType, object.audioStream, object.controlType, object.maxVolume, object.currentVolume) : null;
        callback.postToHandler(4, object, null);
    }
}
