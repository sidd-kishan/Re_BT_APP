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
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.view.KeyEvent
 *  androidx.media.MediaSessionManager$RemoteUserInfo
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
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class MediaSessionCompat.MediaSessionImplApi21.ExtraSession
extends IMediaSession.Stub {
    final MediaSessionCompat.MediaSessionImplApi21 this$0;

    MediaSessionCompat.MediaSessionImplApi21.ExtraSession(MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21) {
        this.this$0 = mediaSessionImplApi21;
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        throw new AssertionError();
    }

    public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int n) {
        throw new AssertionError();
    }

    public void adjustVolume(int n, int n2, String string) {
        throw new AssertionError();
    }

    public void fastForward() throws RemoteException {
        throw new AssertionError();
    }

    public Bundle getExtras() {
        throw new AssertionError();
    }

    public long getFlags() {
        throw new AssertionError();
    }

    public PendingIntent getLaunchPendingIntent() {
        throw new AssertionError();
    }

    public MediaMetadataCompat getMetadata() {
        throw new AssertionError();
    }

    public String getPackageName() {
        throw new AssertionError();
    }

    public PlaybackStateCompat getPlaybackState() {
        return MediaSessionCompat.getStateWithUpdatedPosition((PlaybackStateCompat)this.this$0.mPlaybackState, (MediaMetadataCompat)this.this$0.mMetadata);
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return null;
    }

    public CharSequence getQueueTitle() {
        throw new AssertionError();
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
        throw new AssertionError();
    }

    public ParcelableVolumeInfo getVolumeAttributes() {
        throw new AssertionError();
    }

    public boolean isCaptioningEnabled() {
        return this.this$0.mCaptioningEnabled;
    }

    public boolean isShuffleModeEnabledRemoved() {
        return false;
    }

    public boolean isTransportControlEnabled() {
        throw new AssertionError();
    }

    public void next() throws RemoteException {
        throw new AssertionError();
    }

    public void pause() throws RemoteException {
        throw new AssertionError();
    }

    public void play() throws RemoteException {
        throw new AssertionError();
    }

    public void playFromMediaId(String string, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    public void playFromSearch(String string, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    public void prepare() throws RemoteException {
        throw new AssertionError();
    }

    public void prepareFromMediaId(String string, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    public void prepareFromSearch(String string, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    public void previous() throws RemoteException {
        throw new AssertionError();
    }

    public void rate(RatingCompat ratingCompat) throws RemoteException {
        throw new AssertionError();
    }

    public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        String string;
        if (this.this$0.mDestroyed) return;
        String string2 = string = this.this$0.getCallingPackage();
        if (string == null) {
            string2 = "android.media.session.MediaController";
        }
        string2 = new MediaSessionManager.RemoteUserInfo(string2, MediaSessionCompat.MediaSessionImplApi21.ExtraSession.getCallingPid(), MediaSessionCompat.MediaSessionImplApi21.ExtraSession.getCallingUid());
        this.this$0.mExtraControllerCallbacks.register((IInterface)iMediaControllerCallback, (Object)string2);
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        throw new AssertionError();
    }

    public void removeQueueItemAt(int n) {
        throw new AssertionError();
    }

    public void rewind() throws RemoteException {
        throw new AssertionError();
    }

    public void seekTo(long l) throws RemoteException {
        throw new AssertionError();
    }

    public void sendCommand(String string, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
        throw new AssertionError();
    }

    public void sendCustomAction(String string, Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    public boolean sendMediaButton(KeyEvent keyEvent) {
        throw new AssertionError();
    }

    public void setCaptioningEnabled(boolean bl) throws RemoteException {
        throw new AssertionError();
    }

    public void setRepeatMode(int n) throws RemoteException {
        throw new AssertionError();
    }

    public void setShuffleMode(int n) throws RemoteException {
        throw new AssertionError();
    }

    public void setShuffleModeEnabledRemoved(boolean bl) throws RemoteException {
    }

    public void setVolumeTo(int n, int n2, String string) {
        throw new AssertionError();
    }

    public void skipToQueueItem(long l) {
        throw new AssertionError();
    }

    public void stop() throws RemoteException {
        throw new AssertionError();
    }

    public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        this.this$0.mExtraControllerCallbacks.unregister((IInterface)iMediaControllerCallback);
    }
}
