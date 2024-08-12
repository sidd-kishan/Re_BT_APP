/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.os.ResultReceiver
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.IMediaControllerCallback
 *  android.support.v4.media.session.IMediaSession
 *  android.support.v4.media.session.MediaControllerCompat$Callback
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraCallback
 *  android.support.v4.media.session.MediaControllerCompat$PlaybackInfo
 *  android.support.v4.media.session.MediaControllerCompat$TransportControls
 *  android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21
 *  android.support.v4.media.session.MediaControllerCompatApi21
 *  android.support.v4.media.session.MediaControllerCompatApi21$PlaybackInfo
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.util.Log
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

static class MediaControllerCompat.MediaControllerImplApi21
implements MediaControllerCompat.MediaControllerImpl {
    private HashMap<MediaControllerCompat.Callback, ExtraCallback> mCallbackMap;
    protected final Object mControllerObj;
    final Object mLock = new Object();
    private final List<MediaControllerCompat.Callback> mPendingCallbacks = new ArrayList<MediaControllerCompat.Callback>();
    final MediaSessionCompat.Token mSessionToken;

    public MediaControllerCompat.MediaControllerImplApi21(Context object, MediaSessionCompat.Token token) throws RemoteException {
        this.mCallbackMap = new HashMap();
        this.mSessionToken = token;
        object = MediaControllerCompatApi21.fromToken((Context)object, (Object)token.getToken());
        this.mControllerObj = object;
        if (object == null) throw new RemoteException();
        if (this.mSessionToken.getExtraBinder() != null) return;
        this.requestExtraBinder();
    }

    private void requestExtraBinder() {
        this.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, (ResultReceiver)new ExtraBinderRequestResultReceiver(this));
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        if ((this.getFlags() & 4L) == 0L) throw new UnsupportedOperationException("This session doesn't support queue management operations");
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)mediaDescriptionCompat);
        this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", bundle, null);
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int n) {
        if ((this.getFlags() & 4L) == 0L) throw new UnsupportedOperationException("This session doesn't support queue management operations");
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)mediaDescriptionCompat);
        bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", n);
        this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, null);
    }

    public void adjustVolume(int n, int n2) {
        MediaControllerCompatApi21.adjustVolume((Object)this.mControllerObj, (int)n, (int)n2);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        return MediaControllerCompatApi21.dispatchMediaButtonEvent((Object)this.mControllerObj, (KeyEvent)keyEvent);
    }

    public Bundle getExtras() {
        return MediaControllerCompatApi21.getExtras((Object)this.mControllerObj);
    }

    public long getFlags() {
        return MediaControllerCompatApi21.getFlags((Object)this.mControllerObj);
    }

    public Object getMediaController() {
        return this.mControllerObj;
    }

    public MediaMetadataCompat getMetadata() {
        Object object = MediaControllerCompatApi21.getMetadata((Object)this.mControllerObj);
        object = object != null ? MediaMetadataCompat.fromMediaMetadata((Object)object) : null;
        return object;
    }

    public String getPackageName() {
        return MediaControllerCompatApi21.getPackageName((Object)this.mControllerObj);
    }

    public MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
        Object object = MediaControllerCompatApi21.getPlaybackInfo((Object)this.mControllerObj);
        object = object != null ? new MediaControllerCompat.PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType((Object)object), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream((Object)object), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl((Object)object), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume((Object)object), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume((Object)object)) : null;
        return object;
    }

    public PlaybackStateCompat getPlaybackState() {
        Object object;
        if (this.mSessionToken.getExtraBinder() != null) {
            try {
                PlaybackStateCompat playbackStateCompat = this.mSessionToken.getExtraBinder().getPlaybackState();
                return playbackStateCompat;
            }
            catch (RemoteException remoteException) {
                Log.e((String)"MediaControllerCompat", (String)"Dead object in getPlaybackState.", (Throwable)remoteException);
            }
        }
        object = (object = MediaControllerCompatApi21.getPlaybackState((Object)this.mControllerObj)) != null ? PlaybackStateCompat.fromPlaybackState((Object)object) : null;
        return object;
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        List list = MediaControllerCompatApi21.getQueue((Object)this.mControllerObj);
        list = list != null ? MediaSessionCompat.QueueItem.fromQueueItemList((List)list) : null;
        return list;
    }

    public CharSequence getQueueTitle() {
        return MediaControllerCompatApi21.getQueueTitle((Object)this.mControllerObj);
    }

    public int getRatingType() {
        if (Build.VERSION.SDK_INT >= 22) return MediaControllerCompatApi21.getRatingType((Object)this.mControllerObj);
        if (this.mSessionToken.getExtraBinder() == null) return MediaControllerCompatApi21.getRatingType((Object)this.mControllerObj);
        try {
            int n = this.mSessionToken.getExtraBinder().getRatingType();
            return n;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getRatingType.", (Throwable)remoteException);
        }
        return MediaControllerCompatApi21.getRatingType((Object)this.mControllerObj);
    }

    public int getRepeatMode() {
        if (this.mSessionToken.getExtraBinder() == null) return -1;
        try {
            int n = this.mSessionToken.getExtraBinder().getRepeatMode();
            return n;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getRepeatMode.", (Throwable)remoteException);
        }
        return -1;
    }

    public PendingIntent getSessionActivity() {
        return MediaControllerCompatApi21.getSessionActivity((Object)this.mControllerObj);
    }

    public int getShuffleMode() {
        if (this.mSessionToken.getExtraBinder() == null) return -1;
        try {
            int n = this.mSessionToken.getExtraBinder().getShuffleMode();
            return n;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in getShuffleMode.", (Throwable)remoteException);
        }
        return -1;
    }

    public MediaControllerCompat.TransportControls getTransportControls() {
        Object object = MediaControllerCompatApi21.getTransportControls((Object)this.mControllerObj);
        object = object != null ? new MediaControllerCompat.TransportControlsApi21(object) : null;
        return object;
    }

    public boolean isCaptioningEnabled() {
        if (this.mSessionToken.getExtraBinder() == null) return false;
        try {
            boolean bl = this.mSessionToken.getExtraBinder().isCaptioningEnabled();
            return bl;
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in isCaptioningEnabled.", (Throwable)remoteException);
        }
        return false;
    }

    public boolean isSessionReady() {
        boolean bl = this.mSessionToken.getExtraBinder() != null;
        return bl;
    }

    void processPendingCallbacksLocked() {
        if (this.mSessionToken.getExtraBinder() == null) {
            return;
        }
        for (MediaControllerCompat.Callback callback : this.mPendingCallbacks) {
            ExtraCallback extraCallback = new ExtraCallback(callback);
            this.mCallbackMap.put(callback, extraCallback);
            callback.mIControllerCallback = extraCallback;
            try {
                this.mSessionToken.getExtraBinder().registerCallbackListener((IMediaControllerCallback)extraCallback);
            }
            catch (RemoteException remoteException) {
                Log.e((String)"MediaControllerCompat", (String)"Dead object in registerCallback.", (Throwable)remoteException);
                break;
            }
            callback.postToHandler(13, null, null);
        }
        this.mPendingCallbacks.clear();
    }

    public final void registerCallback(MediaControllerCompat.Callback callback, Handler object) {
        MediaControllerCompatApi21.registerCallback((Object)this.mControllerObj, (Object)callback.mCallbackObj, (Handler)object);
        object = this.mLock;
        synchronized (object) {
            if (this.mSessionToken.getExtraBinder() != null) {
                ExtraCallback extraCallback = new ExtraCallback(callback);
                this.mCallbackMap.put(callback, extraCallback);
                callback.mIControllerCallback = extraCallback;
                try {
                    this.mSessionToken.getExtraBinder().registerCallbackListener((IMediaControllerCallback)extraCallback);
                    callback.postToHandler(13, null, null);
                }
                catch (RemoteException remoteException) {
                    Log.e((String)"MediaControllerCompat", (String)"Dead object in registerCallback.", (Throwable)remoteException);
                }
            } else {
                callback.mIControllerCallback = null;
                this.mPendingCallbacks.add(callback);
            }
            return;
        }
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        if ((this.getFlags() & 4L) == 0L) throw new UnsupportedOperationException("This session doesn't support queue management operations");
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)mediaDescriptionCompat);
        this.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, null);
    }

    public void sendCommand(String string, Bundle bundle, ResultReceiver resultReceiver) {
        MediaControllerCompatApi21.sendCommand((Object)this.mControllerObj, (String)string, (Bundle)bundle, (ResultReceiver)resultReceiver);
    }

    public void setVolumeTo(int n, int n2) {
        MediaControllerCompatApi21.setVolumeTo((Object)this.mControllerObj, (int)n, (int)n2);
    }

    public final void unregisterCallback(MediaControllerCompat.Callback callback) {
        MediaControllerCompatApi21.unregisterCallback((Object)this.mControllerObj, (Object)callback.mCallbackObj);
        Object object = this.mLock;
        synchronized (object) {
            IMediaSession iMediaSession = this.mSessionToken.getExtraBinder();
            if (iMediaSession != null) {
                try {
                    iMediaSession = this.mCallbackMap.remove(callback);
                    if (iMediaSession == null) return;
                    callback.mIControllerCallback = null;
                    this.mSessionToken.getExtraBinder().unregisterCallbackListener((IMediaControllerCallback)iMediaSession);
                }
                catch (RemoteException remoteException) {
                    Log.e((String)"MediaControllerCompat", (String)"Dead object in unregisterCallback.", (Throwable)remoteException);
                }
            } else {
                this.mPendingCallbacks.remove(callback);
            }
            return;
        }
    }
}
