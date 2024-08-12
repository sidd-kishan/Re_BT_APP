/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.MediaControllerCompat
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi28
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
 *  android.support.v4.media.session.MediaSessionCompat$OnActiveChangeListener
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.media.session.MediaSessionCompatApi21
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.support.v4.media.session.PlaybackStateCompat$Builder
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 *  androidx.media.VolumeProviderCompat
 *  androidx.media.session.MediaButtonReceiver
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList<OnActiveChangeListener> mActiveListeners = new ArrayList();
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    private MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        this.mImpl = mediaSessionImpl;
        if (Build.VERSION.SDK_INT >= 21 && !MediaSessionCompatApi21.hasCallback((Object)mediaSessionImpl.getMediaSession())) {
            this.setCallback((Callback)new /* Unavailable Anonymous Inner Class!! */);
        }
        this.mController = new MediaControllerCompat(context, this);
    }

    public MediaSessionCompat(Context context, String string) {
        this(context, string, null, null);
    }

    public MediaSessionCompat(Context context, String string, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, string, componentName, pendingIntent, null);
    }

    private MediaSessionCompat(Context context, String string, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        if (context == null) throw new IllegalArgumentException("context must not be null");
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("tag must not be null or empty");
        ComponentName componentName2 = componentName;
        if (componentName == null) {
            componentName2 = componentName = MediaButtonReceiver.getMediaButtonReceiverComponent((Context)context);
            if (componentName == null) {
                Log.w((String)TAG, (String)"Couldn't find a unique registered media button receiver in the given context.");
                componentName2 = componentName;
            }
        }
        componentName = pendingIntent;
        if (componentName2 != null) {
            componentName = pendingIntent;
            if (pendingIntent == null) {
                componentName = new Intent("android.intent.action.MEDIA_BUTTON");
                componentName.setComponent(componentName2);
                componentName = PendingIntent.getBroadcast((Context)context, (int)0, (Intent)componentName, (int)0);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaSessionImplApi28(context, string, bundle);
            this.setCallback((Callback)new /* Unavailable Anonymous Inner Class!! */);
            this.mImpl.setMediaButtonReceiver((PendingIntent)componentName);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaSessionImplApi21(context, string, bundle);
            this.setCallback((Callback)new /* Unavailable Anonymous Inner Class!! */);
            this.mImpl.setMediaButtonReceiver((PendingIntent)componentName);
        } else {
            this.mImpl = Build.VERSION.SDK_INT >= 19 ? new MediaSessionImplApi19(context, string, componentName2, (PendingIntent)componentName) : (Build.VERSION.SDK_INT >= 18 ? new MediaSessionImplApi18(context, string, componentName2, (PendingIntent)componentName) : new MediaSessionImplBase(context, string, componentName2, (PendingIntent)componentName));
        }
        this.mController = new MediaControllerCompat(context, this);
        if (sMaxBitmapSize != 0) return;
        sMaxBitmapSize = (int)(TypedValue.applyDimension((int)1, (float)320.0f, (DisplayMetrics)context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public MediaSessionCompat(Context context, String string, Bundle bundle) {
        this(context, string, null, null, bundle);
    }

    public static void ensureClassLoader(Bundle bundle) {
        if (bundle == null) return;
        bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object object) {
        if (context == null) return null;
        if (object == null) return null;
        if (Build.VERSION.SDK_INT < 21) return null;
        return new MediaSessionCompat(context, (MediaSessionImpl)new MediaSessionImplApi21(object));
    }

    static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
        if (playbackStateCompat == null) return playbackStateCompat2;
        long l = playbackStateCompat.getPosition();
        long l2 = -1L;
        if (l == -1L) {
            playbackStateCompat2 = playbackStateCompat;
        } else {
            if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4) {
                playbackStateCompat2 = playbackStateCompat;
                if (playbackStateCompat.getState() != 5) return playbackStateCompat2;
            }
            l = playbackStateCompat.getLastPositionUpdateTime();
            playbackStateCompat2 = playbackStateCompat;
            if (l <= 0L) return playbackStateCompat2;
            long l3 = SystemClock.elapsedRealtime();
            long l4 = (long)(playbackStateCompat.getPlaybackSpeed() * (float)(l3 - l)) + playbackStateCompat.getPosition();
            l = l2;
            if (mediaMetadataCompat != null) {
                l = l2;
                if (mediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
                    l = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
                }
            }
            if (l < 0L || l4 <= l) {
                l = l4 < 0L ? 0L : l4;
            }
            playbackStateCompat2 = new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), l, playbackStateCompat.getPlaybackSpeed(), l3).build();
        }
        return playbackStateCompat2;
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) throw new IllegalArgumentException("Listener may not be null");
        this.mActiveListeners.add(onActiveChangeListener);
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) throw new IllegalArgumentException("Listener may not be null");
        this.mActiveListeners.remove(onActiveChangeListener);
    }

    public void sendSessionEvent(String string, Bundle bundle) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("event cannot be null or empty");
        this.mImpl.sendSessionEvent(string, bundle);
    }

    public void setActive(boolean bl) {
        this.mImpl.setActive(bl);
        Iterator<OnActiveChangeListener> iterator = this.mActiveListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        this.setCallback(callback, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        if (callback == null) {
            this.mImpl.setCallback(null, null);
        } else {
            MediaSessionImpl mediaSessionImpl = this.mImpl;
            if (handler == null) {
                handler = new Handler();
            }
            mediaSessionImpl.setCallback(callback, handler);
        }
    }

    public void setCaptioningEnabled(boolean bl) {
        this.mImpl.setCaptioningEnabled(bl);
    }

    public void setExtras(Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public void setFlags(int n) {
        this.mImpl.setFlags(n);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setPlaybackToLocal(int n) {
        this.mImpl.setPlaybackToLocal(n);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat == null) throw new IllegalArgumentException("volumeProvider may not be null!");
        this.mImpl.setPlaybackToRemote(volumeProviderCompat);
    }

    public void setQueue(List<QueueItem> list) {
        this.mImpl.setQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int n) {
        this.mImpl.setRatingType(n);
    }

    public void setRepeatMode(int n) {
        this.mImpl.setRepeatMode(n);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }

    public void setShuffleMode(int n) {
        this.mImpl.setShuffleMode(n);
    }
}
