/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.IMediaControllerCallback
 *  android.support.v4.media.session.IMediaSession$Stub
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.view.KeyEvent
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 *  androidx.media.VolumeProviderCompat
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class MediaSessionCompat.MediaSessionImplBase.MediaSessionStub
extends IMediaSession.Stub {
    final MediaSessionCompat.MediaSessionImplBase this$0;

    MediaSessionCompat.MediaSessionImplBase.MediaSessionStub(MediaSessionCompat.MediaSessionImplBase mediaSessionImplBase) {
        this.this$0 = mediaSessionImplBase;
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.postToHandler(25, mediaDescriptionCompat);
    }

    public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int n) {
        this.postToHandler(26, (Object)mediaDescriptionCompat, n);
    }

    public void adjustVolume(int n, int n2, String string) {
        this.this$0.adjustVolume(n, n2);
    }

    public void fastForward() throws RemoteException {
        this.postToHandler(16);
    }

    public Bundle getExtras() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            Bundle bundle = this.this$0.mExtras;
            return bundle;
        }
    }

    public long getFlags() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            long l = this.this$0.mFlags;
            return l;
        }
    }

    public PendingIntent getLaunchPendingIntent() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            PendingIntent pendingIntent = this.this$0.mSessionActivity;
            return pendingIntent;
        }
    }

    public MediaMetadataCompat getMetadata() {
        return this.this$0.mMetadata;
    }

    public String getPackageName() {
        return this.this$0.mPackageName;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public PlaybackStateCompat getPlaybackState() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            PlaybackStateCompat playbackStateCompat = this.this$0.mState;
            MediaMetadataCompat mediaMetadataCompat = this.this$0.mMetadata;
            return MediaSessionCompat.getStateWithUpdatedPosition((PlaybackStateCompat)playbackStateCompat, (MediaMetadataCompat)mediaMetadataCompat);
        }
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            List list = this.this$0.mQueue;
            return list;
        }
    }

    public CharSequence getQueueTitle() {
        return this.this$0.mQueueTitle;
    }

    public int getRatingType() {
        return this.this$0.mRatingType;
    }

    public int getRepeatMode() {
        return this.this$0.mRepeatMode;
    }

    public int getShuffleMode() {
        return this.this$0.mShuffleMode;
    }

    public String getTag() {
        return this.this$0.mTag;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public ParcelableVolumeInfo getVolumeAttributes() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            int n;
            int n2;
            int n3;
            int n4 = this.this$0.mVolumeType;
            int n5 = this.this$0.mLocalStream;
            VolumeProviderCompat volumeProviderCompat = this.this$0.mVolumeProvider;
            if (n4 == 2) {
                n3 = volumeProviderCompat.getVolumeControl();
                n2 = volumeProviderCompat.getMaxVolume();
                n = volumeProviderCompat.getCurrentVolume();
            } else {
                n2 = this.this$0.mAudioManager.getStreamMaxVolume(n5);
                n = this.this$0.mAudioManager.getStreamVolume(n5);
                n3 = 2;
            }
            return new ParcelableVolumeInfo(n4, n5, n3, n2, n);
        }
    }

    public boolean isCaptioningEnabled() {
        return this.this$0.mCaptioningEnabled;
    }

    public boolean isShuffleModeEnabledRemoved() {
        return false;
    }

    public boolean isTransportControlEnabled() {
        boolean bl = (this.this$0.mFlags & 2) != 0;
        return bl;
    }

    public void next() throws RemoteException {
        this.postToHandler(14);
    }

    public void pause() throws RemoteException {
        this.postToHandler(12);
    }

    public void play() throws RemoteException {
        this.postToHandler(7);
    }

    public void playFromMediaId(String string, Bundle bundle) throws RemoteException {
        this.postToHandler(8, (Object)string, bundle);
    }

    public void playFromSearch(String string, Bundle bundle) throws RemoteException {
        this.postToHandler(9, (Object)string, bundle);
    }

    public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
        this.postToHandler(10, (Object)uri, bundle);
    }

    void postToHandler(int n) {
        this.this$0.postToHandler(n, 0, 0, null, null);
    }

    void postToHandler(int n, int n2) {
        this.this$0.postToHandler(n, n2, 0, null, null);
    }

    void postToHandler(int n, Object object) {
        this.this$0.postToHandler(n, 0, 0, object, null);
    }

    void postToHandler(int n, Object object, int n2) {
        this.this$0.postToHandler(n, n2, 0, object, null);
    }

    void postToHandler(int n, Object object, Bundle bundle) {
        this.this$0.postToHandler(n, 0, 0, object, bundle);
    }

    public void prepare() throws RemoteException {
        this.postToHandler(3);
    }

    public void prepareFromMediaId(String string, Bundle bundle) throws RemoteException {
        this.postToHandler(4, (Object)string, bundle);
    }

    public void prepareFromSearch(String string, Bundle bundle) throws RemoteException {
        this.postToHandler(5, (Object)string, bundle);
    }

    public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
        this.postToHandler(6, (Object)uri, bundle);
    }

    public void previous() throws RemoteException {
        this.postToHandler(15);
    }

    public void rate(RatingCompat ratingCompat) throws RemoteException {
        this.postToHandler(19, ratingCompat);
    }

    public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
        this.postToHandler(31, (Object)ratingCompat, bundle);
    }

    /*
     * Enabled force condition propagation
     */
    public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        if (!this.this$0.mDestroyed) {
            MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo("android.media.session.MediaController", MediaSessionCompat.MediaSessionImplBase.MediaSessionStub.getCallingPid(), MediaSessionCompat.MediaSessionImplBase.MediaSessionStub.getCallingUid());
            this.this$0.mControllerCallbacks.register((IInterface)iMediaControllerCallback, (Object)remoteUserInfo);
            return;
        }
        try {
            iMediaControllerCallback.onSessionDestroyed();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.postToHandler(27, mediaDescriptionCompat);
    }

    public void removeQueueItemAt(int n) {
        this.postToHandler(28, n);
    }

    public void rewind() throws RemoteException {
        this.postToHandler(17);
    }

    public void seekTo(long l) throws RemoteException {
        this.postToHandler(18, l);
    }

    public void sendCommand(String string, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
        this.postToHandler(1, new MediaSessionCompat.MediaSessionImplBase.Command(string, bundle, resultReceiverWrapper.mResultReceiver));
    }

    public void sendCustomAction(String string, Bundle bundle) throws RemoteException {
        this.postToHandler(20, (Object)string, bundle);
    }

    public boolean sendMediaButton(KeyEvent keyEvent) {
        int n = this.this$0.mFlags;
        boolean bl = true;
        if ((n & 1) == 0) {
            bl = false;
        }
        if (!bl) return bl;
        this.postToHandler(21, keyEvent);
        return bl;
    }

    public void setCaptioningEnabled(boolean bl) throws RemoteException {
        this.postToHandler(29, bl);
    }

    public void setRepeatMode(int n) throws RemoteException {
        this.postToHandler(23, n);
    }

    public void setShuffleMode(int n) throws RemoteException {
        this.postToHandler(30, n);
    }

    public void setShuffleModeEnabledRemoved(boolean bl) throws RemoteException {
    }

    public void setVolumeTo(int n, int n2, String string) {
        this.this$0.setVolumeTo(n, n2);
    }

    public void skipToQueueItem(long l) {
        this.postToHandler(11, l);
    }

    public void stop() throws RemoteException {
        this.postToHandler(13);
    }

    public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        this.this$0.mControllerCallbacks.unregister((IInterface)iMediaControllerCallback);
    }
}
