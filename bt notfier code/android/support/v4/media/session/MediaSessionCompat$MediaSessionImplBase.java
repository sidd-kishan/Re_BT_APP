/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.media.AudioManager
 *  android.media.RemoteControlClient
 *  android.media.RemoteControlClient$MetadataEditor
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.RemoteCallbackList
 *  android.os.RemoteException
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.MediaMetadataCompat$Builder
 *  android.support.v4.media.session.IMediaControllerCallback
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MediaSessionStub
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  android.support.v4.media.session.PlaybackStateCompat
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 *  androidx.media.VolumeProviderCompat
 *  androidx.media.VolumeProviderCompat$Callback
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import java.util.List;

static class MediaSessionCompat.MediaSessionImplBase
implements MediaSessionCompat.MediaSessionImpl {
    static final int RCC_PLAYSTATE_NONE = 0;
    final AudioManager mAudioManager;
    volatile MediaSessionCompat.Callback mCallback;
    boolean mCaptioningEnabled;
    private final Context mContext;
    final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks;
    boolean mDestroyed = false;
    Bundle mExtras;
    int mFlags;
    private MessageHandler mHandler;
    boolean mIsActive = false;
    private boolean mIsMbrRegistered = false;
    private boolean mIsRccRegistered = false;
    int mLocalStream;
    final Object mLock = new Object();
    private final ComponentName mMediaButtonReceiverComponentName;
    private final PendingIntent mMediaButtonReceiverIntent;
    MediaMetadataCompat mMetadata;
    final String mPackageName;
    List<MediaSessionCompat.QueueItem> mQueue;
    CharSequence mQueueTitle;
    int mRatingType;
    final RemoteControlClient mRcc;
    private MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
    int mRepeatMode;
    PendingIntent mSessionActivity;
    int mShuffleMode;
    PlaybackStateCompat mState;
    private final MediaSessionStub mStub;
    final String mTag;
    private final MediaSessionCompat.Token mToken;
    private VolumeProviderCompat.Callback mVolumeCallback;
    VolumeProviderCompat mVolumeProvider;
    int mVolumeType;

    public MediaSessionCompat.MediaSessionImplBase(Context context, String string, ComponentName componentName, PendingIntent pendingIntent) {
        this.mControllerCallbacks = new RemoteCallbackList();
        this.mVolumeCallback = new /* Unavailable Anonymous Inner Class!! */;
        if (componentName == null) throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        this.mContext = context;
        this.mPackageName = context.getPackageName();
        this.mAudioManager = (AudioManager)context.getSystemService("audio");
        this.mTag = string;
        this.mMediaButtonReceiverComponentName = componentName;
        this.mMediaButtonReceiverIntent = pendingIntent;
        this.mStub = new MediaSessionStub(this);
        this.mToken = new MediaSessionCompat.Token((Object)this.mStub);
        this.mRatingType = 0;
        this.mVolumeType = 1;
        this.mLocalStream = 3;
        this.mRcc = new RemoteControlClient(pendingIntent);
    }

    /*
     * Unable to fully structure code
     */
    private void sendCaptioningEnabled(boolean var1_1) {
        var2_2 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onCaptioningEnabledChanged(var1_1);
lbl9:
                // 2 sources

                while (true) {
                    --var2_2;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var3_4) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void sendEvent(String var1_1, Bundle var2_2) {
        var3_3 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var3_3 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            var4_4 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var3_3);
            try {
                var4_4.onEvent(var1_1, var2_2);
lbl9:
                // 2 sources

                while (true) {
                    --var3_3;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var4_5) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void sendExtras(Bundle var1_1) {
        var2_2 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onExtrasChanged(var1_1);
lbl9:
                // 2 sources

                while (true) {
                    --var2_2;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var3_4) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void sendMetadata(MediaMetadataCompat var1_1) {
        var2_2 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onMetadataChanged(var1_1);
lbl9:
                // 2 sources

                while (true) {
                    --var2_2;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var3_4) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void sendQueue(List<MediaSessionCompat.QueueItem> var1_1) {
        var2_2 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onQueueChanged(var1_1);
lbl9:
                // 2 sources

                while (true) {
                    --var2_2;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var3_4) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void sendQueueTitle(CharSequence var1_1) {
        var2_2 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onQueueTitleChanged(var1_1);
lbl9:
                // 2 sources

                while (true) {
                    --var2_2;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var3_4) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void sendRepeatMode(int var1_1) {
        var2_2 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onRepeatModeChanged(var1_1);
lbl9:
                // 2 sources

                while (true) {
                    --var2_2;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var3_4) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void sendSessionDestroyed() {
        var1_1 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var1_1 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                this.mControllerCallbacks.kill();
                return;
            }
            var2_2 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var1_1);
            try {
                var2_2.onSessionDestroyed();
lbl10:
                // 2 sources

                while (true) {
                    --var1_1;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var2_3) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void sendShuffleMode(int var1_1) {
        var2_2 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onShuffleModeChanged(var1_1);
lbl9:
                // 2 sources

                while (true) {
                    --var2_2;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var3_4) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void sendState(PlaybackStateCompat var1_1) {
        var2_2 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onPlaybackStateChanged(var1_1);
lbl9:
                // 2 sources

                while (true) {
                    --var2_2;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var3_4) {
                ** continue;
            }
        }
    }

    void adjustVolume(int n, int n2) {
        if (this.mVolumeType == 2) {
            VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
            if (volumeProviderCompat == null) return;
            volumeProviderCompat.onAdjustVolume(n);
        } else {
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, n, n2);
        }
    }

    RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
        RemoteControlClient.MetadataEditor metadataEditor = this.mRcc.editMetadata(true);
        if (bundle == null) {
            return metadataEditor;
        }
        if (bundle.containsKey("android.media.metadata.ART")) {
            Bitmap bitmap;
            Bitmap bitmap2 = bitmap = (Bitmap)bundle.getParcelable("android.media.metadata.ART");
            if (bitmap != null) {
                bitmap2 = bitmap.copy(bitmap.getConfig(), false);
            }
            metadataEditor.putBitmap(100, bitmap2);
        } else if (bundle.containsKey("android.media.metadata.ALBUM_ART")) {
            Bitmap bitmap;
            Bitmap bitmap3 = bitmap = (Bitmap)bundle.getParcelable("android.media.metadata.ALBUM_ART");
            if (bitmap != null) {
                bitmap3 = bitmap.copy(bitmap.getConfig(), false);
            }
            metadataEditor.putBitmap(100, bitmap3);
        }
        if (bundle.containsKey("android.media.metadata.ALBUM")) {
            metadataEditor.putString(1, bundle.getString("android.media.metadata.ALBUM"));
        }
        if (bundle.containsKey("android.media.metadata.ALBUM_ARTIST")) {
            metadataEditor.putString(13, bundle.getString("android.media.metadata.ALBUM_ARTIST"));
        }
        if (bundle.containsKey("android.media.metadata.ARTIST")) {
            metadataEditor.putString(2, bundle.getString("android.media.metadata.ARTIST"));
        }
        if (bundle.containsKey("android.media.metadata.AUTHOR")) {
            metadataEditor.putString(3, bundle.getString("android.media.metadata.AUTHOR"));
        }
        if (bundle.containsKey("android.media.metadata.COMPILATION")) {
            metadataEditor.putString(15, bundle.getString("android.media.metadata.COMPILATION"));
        }
        if (bundle.containsKey("android.media.metadata.COMPOSER")) {
            metadataEditor.putString(4, bundle.getString("android.media.metadata.COMPOSER"));
        }
        if (bundle.containsKey("android.media.metadata.DATE")) {
            metadataEditor.putString(5, bundle.getString("android.media.metadata.DATE"));
        }
        if (bundle.containsKey("android.media.metadata.DISC_NUMBER")) {
            metadataEditor.putLong(14, bundle.getLong("android.media.metadata.DISC_NUMBER"));
        }
        if (bundle.containsKey("android.media.metadata.DURATION")) {
            metadataEditor.putLong(9, bundle.getLong("android.media.metadata.DURATION"));
        }
        if (bundle.containsKey("android.media.metadata.GENRE")) {
            metadataEditor.putString(6, bundle.getString("android.media.metadata.GENRE"));
        }
        if (bundle.containsKey("android.media.metadata.TITLE")) {
            metadataEditor.putString(7, bundle.getString("android.media.metadata.TITLE"));
        }
        if (bundle.containsKey("android.media.metadata.TRACK_NUMBER")) {
            metadataEditor.putLong(0, bundle.getLong("android.media.metadata.TRACK_NUMBER"));
        }
        if (!bundle.containsKey("android.media.metadata.WRITER")) return metadataEditor;
        metadataEditor.putString(11, bundle.getString("android.media.metadata.WRITER"));
        return metadataEditor;
    }

    public String getCallingPackage() {
        return null;
    }

    public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        Object object = this.mLock;
        synchronized (object) {
            MediaSessionManager.RemoteUserInfo remoteUserInfo = this.mRemoteUserInfo;
            return remoteUserInfo;
        }
    }

    public Object getMediaSession() {
        return null;
    }

    public PlaybackStateCompat getPlaybackState() {
        Object object = this.mLock;
        synchronized (object) {
            PlaybackStateCompat playbackStateCompat = this.mState;
            return playbackStateCompat;
        }
    }

    int getRccStateFromState(int n) {
        switch (n) {
            default: {
                return -1;
            }
            case 10: 
            case 11: {
                return 6;
            }
            case 9: {
                return 7;
            }
            case 7: {
                return 9;
            }
            case 6: 
            case 8: {
                return 8;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 0: 
        }
        return 0;
    }

    int getRccTransportControlFlagsFromActions(long l) {
        int n = (1L & l) != 0L ? 32 : 0;
        int n2 = n;
        if ((2L & l) != 0L) {
            n2 = n | 0x10;
        }
        n = n2;
        if ((4L & l) != 0L) {
            n = n2 | 4;
        }
        n2 = n;
        if ((8L & l) != 0L) {
            n2 = n | 2;
        }
        n = n2;
        if ((0x10L & l) != 0L) {
            n = n2 | 1;
        }
        n2 = n;
        if ((0x20L & l) != 0L) {
            n2 = n | 0x80;
        }
        n = n2;
        if ((0x40L & l) != 0L) {
            n = n2 | 0x40;
        }
        n2 = n;
        if ((l & 0x200L) == 0L) return n2;
        n2 = n | 8;
        return n2;
    }

    public Object getRemoteControlClient() {
        return null;
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    void postToHandler(int n, int n2, int n3, Object object, Bundle bundle) {
        Object object2 = this.mLock;
        synchronized (object2) {
            if (this.mHandler == null) return;
            object = this.mHandler.obtainMessage(n, n2, n3, object);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_calling_pkg", "android.media.session.MediaController");
            bundle2.putInt("data_calling_pid", Binder.getCallingPid());
            bundle2.putInt("data_calling_uid", Binder.getCallingUid());
            if (bundle != null) {
                bundle2.putBundle("data_extras", bundle);
            }
            object.setData(bundle2);
            object.sendToTarget();
            return;
        }
    }

    void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
        this.mAudioManager.registerMediaButtonEventReceiver(componentName);
    }

    public void release() {
        this.mIsActive = false;
        this.mDestroyed = true;
        this.update();
        this.sendSessionDestroyed();
    }

    public void sendSessionEvent(String string, Bundle bundle) {
        this.sendEvent(string, bundle);
    }

    /*
     * Unable to fully structure code
     */
    void sendVolumeInfoChanged(ParcelableVolumeInfo var1_1) {
        var2_2 = this.mControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onVolumeInfoChanged(var1_1);
lbl9:
                // 2 sources

                while (true) {
                    --var2_2;
                    continue block2;
                    break;
                }
            }
            catch (RemoteException var3_4) {
                ** continue;
            }
        }
    }

    public void setActive(boolean bl) {
        if (bl == this.mIsActive) {
            return;
        }
        this.mIsActive = bl;
        if (!this.update()) return;
        this.setMetadata(this.mMetadata);
        this.setPlaybackState(this.mState);
    }

    public void setCallback(MediaSessionCompat.Callback callback, Handler object) {
        this.mCallback = callback;
        if (callback == null) return;
        callback = object;
        if (object == null) {
            callback = new Handler();
        }
        object = this.mLock;
        synchronized (object) {
            MessageHandler messageHandler;
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
            }
            this.mHandler = messageHandler = new MessageHandler(this, callback.getLooper());
            this.mCallback.setSessionImpl((MediaSessionCompat.MediaSessionImpl)this, (Handler)callback);
        }
    }

    public void setCaptioningEnabled(boolean bl) {
        if (this.mCaptioningEnabled == bl) return;
        this.mCaptioningEnabled = bl;
        this.sendCaptioningEnabled(bl);
    }

    public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        Object object = this.mLock;
        synchronized (object) {
            this.mRemoteUserInfo = remoteUserInfo;
            return;
        }
    }

    public void setExtras(Bundle bundle) {
        this.mExtras = bundle;
        this.sendExtras(bundle);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void setFlags(int n) {
        Object object = this.mLock;
        synchronized (object) {
            this.mFlags = n;
        }
        this.update();
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void setMetadata(MediaMetadataCompat object) {
        MediaMetadataCompat mediaMetadataCompat = object;
        if (object != null) {
            mediaMetadataCompat = new MediaMetadataCompat.Builder(object, MediaSessionCompat.sMaxBitmapSize).build();
        }
        object = this.mLock;
        synchronized (object) {
            this.mMetadata = mediaMetadataCompat;
        }
        this.sendMetadata(mediaMetadataCompat);
        if (!this.mIsActive) {
            return;
        }
        object = mediaMetadataCompat == null ? null : mediaMetadataCompat.getBundle();
        this.buildRccMetadata((Bundle)object).apply();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        Object object = this.mLock;
        synchronized (object) {
            this.mState = playbackStateCompat;
        }
        this.sendState(playbackStateCompat);
        if (!this.mIsActive) {
            return;
        }
        if (playbackStateCompat == null) {
            this.mRcc.setPlaybackState(0);
            this.mRcc.setTransportControlFlags(0);
            return;
        }
        this.setRccState(playbackStateCompat);
        this.mRcc.setTransportControlFlags(this.getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
    }

    public void setPlaybackToLocal(int n) {
        VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
        if (volumeProviderCompat != null) {
            volumeProviderCompat.setCallback(null);
        }
        this.mLocalStream = n;
        int n2 = this.mVolumeType = 1;
        n = this.mLocalStream;
        this.sendVolumeInfoChanged(new ParcelableVolumeInfo(n2, n, 2, this.mAudioManager.getStreamMaxVolume(n), this.mAudioManager.getStreamVolume(this.mLocalStream)));
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat == null) throw new IllegalArgumentException("volumeProvider may not be null");
        VolumeProviderCompat volumeProviderCompat2 = this.mVolumeProvider;
        if (volumeProviderCompat2 != null) {
            volumeProviderCompat2.setCallback(null);
        }
        this.mVolumeType = 2;
        this.mVolumeProvider = volumeProviderCompat;
        this.sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
        volumeProviderCompat.setCallback(this.mVolumeCallback);
    }

    public void setQueue(List<MediaSessionCompat.QueueItem> list) {
        this.mQueue = list;
        this.sendQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mQueueTitle = charSequence;
        this.sendQueueTitle(charSequence);
    }

    public void setRatingType(int n) {
        this.mRatingType = n;
    }

    void setRccState(PlaybackStateCompat playbackStateCompat) {
        this.mRcc.setPlaybackState(this.getRccStateFromState(playbackStateCompat.getState()));
    }

    public void setRepeatMode(int n) {
        if (this.mRepeatMode == n) return;
        this.mRepeatMode = n;
        this.sendRepeatMode(n);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        Object object = this.mLock;
        synchronized (object) {
            this.mSessionActivity = pendingIntent;
            return;
        }
    }

    public void setShuffleMode(int n) {
        if (this.mShuffleMode == n) return;
        this.mShuffleMode = n;
        this.sendShuffleMode(n);
    }

    void setVolumeTo(int n, int n2) {
        if (this.mVolumeType == 2) {
            VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
            if (volumeProviderCompat == null) return;
            volumeProviderCompat.onSetVolumeTo(n);
        } else {
            this.mAudioManager.setStreamVolume(this.mLocalStream, n, n2);
        }
    }

    void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
        this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
    }

    boolean update() {
        boolean bl;
        block8: {
            block9: {
                block6: {
                    block7: {
                        boolean bl2 = this.mIsActive;
                        bl = true;
                        if (!bl2) break block6;
                        if (!this.mIsMbrRegistered && (this.mFlags & 1) != 0) {
                            this.registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                            this.mIsMbrRegistered = true;
                        } else if (this.mIsMbrRegistered && (this.mFlags & 1) == 0) {
                            this.unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                            this.mIsMbrRegistered = false;
                        }
                        if (this.mIsRccRegistered || (this.mFlags & 2) == 0) break block7;
                        this.mAudioManager.registerRemoteControlClient(this.mRcc);
                        this.mIsRccRegistered = true;
                        break block8;
                    }
                    if (this.mIsRccRegistered && (this.mFlags & 2) == 0) {
                        this.mRcc.setPlaybackState(0);
                        this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                        this.mIsRccRegistered = false;
                    }
                    break block9;
                }
                if (this.mIsMbrRegistered) {
                    this.unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = false;
                }
                if (this.mIsRccRegistered) {
                    this.mRcc.setPlaybackState(0);
                    this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                    this.mIsRccRegistered = false;
                }
            }
            bl = false;
        }
        return bl;
    }
}
