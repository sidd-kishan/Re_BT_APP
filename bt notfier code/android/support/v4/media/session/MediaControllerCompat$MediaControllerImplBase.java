/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 *  android.os.RemoteException
 *  android.os.ResultReceiver
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.IMediaControllerCallback
 *  android.support.v4.media.session.IMediaSession
 *  android.support.v4.media.session.IMediaSession$Stub
 *  android.support.v4.media.session.MediaControllerCompat$Callback
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
 *  android.support.v4.media.session.MediaControllerCompat$PlaybackInfo
 *  android.support.v4.media.session.MediaControllerCompat$TransportControls
 *  android.support.v4.media.session.MediaControllerCompat$TransportControlsBase
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.util.Log
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

static class MediaControllerCompat.MediaControllerImplBase
implements MediaControllerCompat.MediaControllerImpl {
    private IMediaSession mBinder;
    private MediaControllerCompat.TransportControls mTransportControls;

    public MediaControllerCompat.MediaControllerImplBase(MediaSessionCompat.Token token) {
        this.mBinder = IMediaSession.Stub.asInterface((IBinder)((IBinder)token.getToken()));
    }

    public void addQueueItem(MediaDescriptionCompat object) {
        try {
            if ((this.mBinder.getFlags() & 4L) == 0L) {
                object = new UnsupportedOperationException("This session doesn't support queue management operations");
                throw object;
            }
            this.mBinder.addQueueItem(object);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in addQueueItem.", (Throwable)remoteException);
        }
    }

    public void addQueueItem(MediaDescriptionCompat object, int n) {
        try {
            if ((this.mBinder.getFlags() & 4L) == 0L) {
                object = new UnsupportedOperationException("This session doesn't support queue management operations");
                throw object;
            }
            this.mBinder.addQueueItemAt(object, n);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in addQueueItemAt.", (Throwable)remoteException);
        }
    }

    public void adjustVolume(int n, int n2) {
        try {
            this.mBinder.adjustVolume(n, n2, null);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in adjustVolume.", (Throwable)remoteException);
        }
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent == null) throw new IllegalArgumentException("event may not be null.");
        try {
            this.mBinder.sendMediaButton(keyEvent);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in dispatchMediaButtonEvent.", (Throwable)remoteException);
        }
        return false;
    }

    public Bundle getExtras() {
        try {
            Bundle bundle = this.mBinder.getExtras();
            return bundle;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getExtras.", (Throwable)remoteException);
            return null;
        }
    }

    public long getFlags() {
        try {
            long l = this.mBinder.getFlags();
            return l;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getFlags.", (Throwable)remoteException);
            return 0L;
        }
    }

    public Object getMediaController() {
        return null;
    }

    public MediaMetadataCompat getMetadata() {
        try {
            MediaMetadataCompat mediaMetadataCompat = this.mBinder.getMetadata();
            return mediaMetadataCompat;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getMetadata.", (Throwable)remoteException);
            return null;
        }
    }

    public String getPackageName() {
        try {
            String string = this.mBinder.getPackageName();
            return string;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getPackageName.", (Throwable)remoteException);
            return null;
        }
    }

    public MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
        try {
            ParcelableVolumeInfo parcelableVolumeInfo = this.mBinder.getVolumeAttributes();
            parcelableVolumeInfo = new MediaControllerCompat.PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume);
            return parcelableVolumeInfo;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getPlaybackInfo.", (Throwable)remoteException);
            return null;
        }
    }

    public PlaybackStateCompat getPlaybackState() {
        try {
            PlaybackStateCompat playbackStateCompat = this.mBinder.getPlaybackState();
            return playbackStateCompat;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getPlaybackState.", (Throwable)remoteException);
            return null;
        }
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        try {
            List list = this.mBinder.getQueue();
            return list;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getQueue.", (Throwable)remoteException);
            return null;
        }
    }

    public CharSequence getQueueTitle() {
        try {
            CharSequence charSequence = this.mBinder.getQueueTitle();
            return charSequence;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getQueueTitle.", (Throwable)remoteException);
            return null;
        }
    }

    public int getRatingType() {
        try {
            int n = this.mBinder.getRatingType();
            return n;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getRatingType.", (Throwable)remoteException);
            return 0;
        }
    }

    public int getRepeatMode() {
        try {
            int n = this.mBinder.getRepeatMode();
            return n;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getRepeatMode.", (Throwable)remoteException);
            return -1;
        }
    }

    public PendingIntent getSessionActivity() {
        try {
            PendingIntent pendingIntent = this.mBinder.getLaunchPendingIntent();
            return pendingIntent;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getSessionActivity.", (Throwable)remoteException);
            return null;
        }
    }

    public int getShuffleMode() {
        try {
            int n = this.mBinder.getShuffleMode();
            return n;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getShuffleMode.", (Throwable)remoteException);
            return -1;
        }
    }

    public MediaControllerCompat.TransportControls getTransportControls() {
        if (this.mTransportControls != null) return this.mTransportControls;
        this.mTransportControls = new MediaControllerCompat.TransportControlsBase(this.mBinder);
        return this.mTransportControls;
    }

    public boolean isCaptioningEnabled() {
        try {
            boolean bl = this.mBinder.isCaptioningEnabled();
            return bl;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in isCaptioningEnabled.", (Throwable)remoteException);
            return false;
        }
    }

    public boolean isSessionReady() {
        return true;
    }

    public void registerCallback(MediaControllerCompat.Callback callback, Handler handler) {
        if (callback == null) throw new IllegalArgumentException("callback may not be null.");
        try {
            this.mBinder.asBinder().linkToDeath((IBinder.DeathRecipient)callback, 0);
            this.mBinder.registerCallbackListener((IMediaControllerCallback)callback.mCallbackObj);
            callback.postToHandler(13, null, null);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in registerCallback.", (Throwable)remoteException);
            callback.postToHandler(8, null, null);
        }
    }

    public void removeQueueItem(MediaDescriptionCompat object) {
        try {
            if ((this.mBinder.getFlags() & 4L) == 0L) {
                object = new UnsupportedOperationException("This session doesn't support queue management operations");
                throw object;
            }
            this.mBinder.removeQueueItem(object);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in removeQueueItem.", (Throwable)remoteException);
        }
    }

    public void sendCommand(String string, Bundle bundle, ResultReceiver resultReceiver) {
        try {
            IMediaSession iMediaSession = this.mBinder;
            MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper = new MediaSessionCompat.ResultReceiverWrapper(resultReceiver);
            iMediaSession.sendCommand(string, bundle, resultReceiverWrapper);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in sendCommand.", (Throwable)remoteException);
        }
    }

    public void setVolumeTo(int n, int n2) {
        try {
            this.mBinder.setVolumeTo(n, n2, null);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in setVolumeTo.", (Throwable)remoteException);
        }
    }

    public void unregisterCallback(MediaControllerCompat.Callback callback) {
        if (callback == null) throw new IllegalArgumentException("callback may not be null.");
        try {
            this.mBinder.unregisterCallbackListener((IMediaControllerCallback)callback.mCallbackObj);
            this.mBinder.asBinder().unlinkToDeath((IBinder.DeathRecipient)callback, 0);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in unregisterCallback.", (Throwable)remoteException);
        }
    }
}
