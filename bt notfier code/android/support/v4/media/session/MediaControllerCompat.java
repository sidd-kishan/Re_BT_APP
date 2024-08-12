/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.RemoteException
 *  android.os.ResultReceiver
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.MediaControllerCompat$Callback
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerExtraData
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi23
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi24
 *  android.support.v4.media.session.MediaControllerCompat$MediaControllerImplBase
 *  android.support.v4.media.session.MediaControllerCompat$PlaybackInfo
 *  android.support.v4.media.session.MediaControllerCompat$TransportControls
 *  android.support.v4.media.session.MediaControllerCompatApi21
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.KeyEvent
 *  androidx.core.app.ComponentActivity
 *  androidx.core.app.ComponentActivity$ExtraData
 */
package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.app.ComponentActivity;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final HashSet<Callback> mRegisteredCallbacks = new HashSet();
    private final MediaSessionCompat.Token mToken;

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) throws RemoteException {
        if (token == null) throw new IllegalArgumentException("sessionToken must not be null");
        this.mToken = token;
        this.mImpl = Build.VERSION.SDK_INT >= 24 ? new MediaControllerImplApi24(context, token) : (Build.VERSION.SDK_INT >= 23 ? new MediaControllerImplApi23(context, token) : (Build.VERSION.SDK_INT >= 21 ? new MediaControllerImplApi21(context, token) : new MediaControllerImplBase(token)));
    }

    public MediaControllerCompat(Context object, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            object = new IllegalArgumentException("session must not be null");
            throw object;
        }
        this.mToken = mediaSessionCompat.getSessionToken();
        mediaSessionCompat = null;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                MediaControllerImplApi24 mediaControllerImplApi24 = new MediaControllerImplApi24(object, this.mToken);
                object = mediaControllerImplApi24;
            } else {
                object = Build.VERSION.SDK_INT >= 23 ? new MediaControllerImplApi23(object, this.mToken) : (Build.VERSION.SDK_INT >= 21 ? new MediaControllerImplApi21(object, this.mToken) : new MediaControllerImplBase(this.mToken));
            }
        }
        catch (RemoteException remoteException) {
            Log.w((String)TAG, (String)"Failed to create MediaControllerImpl.", (Throwable)remoteException);
            object = mediaSessionCompat;
        }
        this.mImpl = object;
    }

    public static MediaControllerCompat getMediaController(Activity object) {
        boolean bl = object instanceof ComponentActivity;
        Object object2 = null;
        if (bl) {
            MediaControllerExtraData mediaControllerExtraData = (MediaControllerExtraData)((ComponentActivity)object).getExtraData(MediaControllerExtraData.class);
            object = object2;
            if (mediaControllerExtraData == null) return object;
            object = mediaControllerExtraData.getMediaController();
            return object;
        }
        if (Build.VERSION.SDK_INT < 21) return null;
        object2 = MediaControllerCompatApi21.getMediaController((Activity)object);
        if (object2 == null) {
            return null;
        }
        object2 = MediaControllerCompatApi21.getSessionToken((Object)object2);
        try {
            object = new MediaControllerCompat((Context)object, MediaSessionCompat.Token.fromToken((Object)object2));
            return object;
        }
        catch (RemoteException remoteException) {
            Log.e((String)TAG, (String)"Dead object in getMediaController.", (Throwable)remoteException);
        }
        return null;
    }

    public static void setMediaController(Activity activity, MediaControllerCompat mediaControllerCompat) {
        if (activity instanceof ComponentActivity) {
            ((ComponentActivity)activity).putExtraData((ComponentActivity.ExtraData)new MediaControllerExtraData(mediaControllerCompat));
        }
        if (Build.VERSION.SDK_INT < 21) return;
        Object object = null;
        if (mediaControllerCompat != null) {
            object = MediaControllerCompatApi21.fromToken((Context)activity, (Object)mediaControllerCompat.getSessionToken().getToken());
        }
        MediaControllerCompatApi21.setMediaController((Activity)activity, object);
    }

    static void validateCustomAction(String string, Bundle object) {
        if (string == null) {
            return;
        }
        int n = -1;
        int n2 = string.hashCode();
        if (n2 != -1348483723) {
            if (n2 == 503011406 && string.equals("android.support.v4.media.session.action.UNFOLLOW")) {
                n = 1;
            }
        } else if (string.equals("android.support.v4.media.session.action.FOLLOW")) {
            n = 0;
        }
        if (n != 0 && n != 1 || object != null && object.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(".");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.addQueueItem(mediaDescriptionCompat);
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int n) {
        this.mImpl.addQueueItem(mediaDescriptionCompat, n);
    }

    public void adjustVolume(int n, int n2) {
        this.mImpl.adjustVolume(n, n2);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent == null) throw new IllegalArgumentException("KeyEvent may not be null");
        return this.mImpl.dispatchMediaButtonEvent(keyEvent);
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    public Bundle getSessionToken2Bundle() {
        return this.mToken.getSessionToken2Bundle();
    }

    public int getShuffleMode() {
        return this.mImpl.getShuffleMode();
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }

    public boolean isSessionReady() {
        return this.mImpl.isSessionReady();
    }

    public void registerCallback(Callback callback) {
        this.registerCallback(callback, null);
    }

    public void registerCallback(Callback callback, Handler handler) {
        if (callback == null) throw new IllegalArgumentException("callback must not be null");
        Handler handler2 = handler;
        if (handler == null) {
            handler2 = new Handler();
        }
        callback.setHandler(handler2);
        this.mImpl.registerCallback(callback, handler2);
        this.mRegisteredCallbacks.add(callback);
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.removeQueueItem(mediaDescriptionCompat);
    }

    @Deprecated
    public void removeQueueItemAt(int n) {
        MediaSessionCompat.QueueItem queueItem = this.getQueue();
        if (queueItem == null) return;
        if (n < 0) return;
        if (n >= queueItem.size()) return;
        if ((queueItem = queueItem.get(n)) == null) return;
        this.removeQueueItem(queueItem.getDescription());
    }

    public void sendCommand(String string, Bundle bundle, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("command must neither be null nor empty");
        this.mImpl.sendCommand(string, bundle, resultReceiver);
    }

    public void setVolumeTo(int n, int n2) {
        this.mImpl.setVolumeTo(n, n2);
    }

    public void unregisterCallback(Callback callback) {
        if (callback == null) throw new IllegalArgumentException("callback must not be null");
        try {
            this.mRegisteredCallbacks.remove(callback);
            this.mImpl.unregisterCallback(callback);
            return;
        }
        finally {
            callback.setHandler(null);
        }
    }
}
