/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.RemoteCallbackList
 *  android.os.RemoteException
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.IMediaControllerCallback
 *  android.support.v4.media.session.IMediaSession
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21$ExtraSession
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.media.session.MediaSessionCompatApi21
 *  android.support.v4.media.session.MediaSessionCompatApi22
 *  android.support.v4.media.session.MediaSessionCompatApi24
 *  android.support.v4.media.session.PlaybackStateCompat
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 *  androidx.media.VolumeProviderCompat
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.MediaSessionCompatApi22;
import android.support.v4.media.session.MediaSessionCompatApi24;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

static class MediaSessionCompat.MediaSessionImplApi21
implements MediaSessionCompat.MediaSessionImpl {
    boolean mCaptioningEnabled;
    boolean mDestroyed = false;
    final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks = new RemoteCallbackList();
    MediaMetadataCompat mMetadata;
    PlaybackStateCompat mPlaybackState;
    List<MediaSessionCompat.QueueItem> mQueue;
    int mRatingType;
    int mRepeatMode;
    final Object mSessionObj;
    int mShuffleMode;
    final MediaSessionCompat.Token mToken;

    MediaSessionCompat.MediaSessionImplApi21(Context context, String string, Bundle bundle) {
        this.mSessionObj = MediaSessionCompatApi21.createSession((Context)context, (String)string);
        this.mToken = new MediaSessionCompat.Token((Object)MediaSessionCompatApi21.getSessionToken((Object)this.mSessionObj), (IMediaSession)new ExtraSession(this), bundle);
    }

    MediaSessionCompat.MediaSessionImplApi21(Object object) {
        this.mSessionObj = MediaSessionCompatApi21.verifySession((Object)object);
        this.mToken = new MediaSessionCompat.Token((Object)MediaSessionCompatApi21.getSessionToken((Object)this.mSessionObj), (IMediaSession)new ExtraSession(this));
    }

    public String getCallingPackage() {
        if (Build.VERSION.SDK_INT >= 24) return MediaSessionCompatApi24.getCallingPackage((Object)this.mSessionObj);
        return null;
    }

    public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return null;
    }

    public Object getMediaSession() {
        return this.mSessionObj;
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mPlaybackState;
    }

    public Object getRemoteControlClient() {
        return null;
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    public boolean isActive() {
        return MediaSessionCompatApi21.isActive((Object)this.mSessionObj);
    }

    public void release() {
        this.mDestroyed = true;
        MediaSessionCompatApi21.release((Object)this.mSessionObj);
    }

    /*
     * Unable to fully structure code
     */
    public void sendSessionEvent(String var1_1, Bundle var2_2) {
        if (Build.VERSION.SDK_INT < 23) {
            block2: for (var3_3 = this.mExtraControllerCallbacks.beginBroadcast() - 1; var3_3 >= 0; --var3_3) {
                var4_4 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(var3_3);
                try {
                    var4_4.onEvent(var1_1, var2_2);
lbl6:
                    // 2 sources

                    continue block2;
                }
                catch (RemoteException var4_5) {
                    ** continue;
                }
            }
            this.mExtraControllerCallbacks.finishBroadcast();
        }
        MediaSessionCompatApi21.sendSessionEvent((Object)this.mSessionObj, (String)var1_1, (Bundle)var2_2);
    }

    public void setActive(boolean bl) {
        MediaSessionCompatApi21.setActive((Object)this.mSessionObj, (boolean)bl);
    }

    public void setCallback(MediaSessionCompat.Callback callback, Handler handler) {
        Object object = this.mSessionObj;
        Object object2 = callback == null ? null : callback.mCallbackObj;
        MediaSessionCompatApi21.setCallback((Object)object, (Object)object2, (Handler)handler);
        if (callback == null) return;
        callback.setSessionImpl((MediaSessionCompat.MediaSessionImpl)this, handler);
    }

    /*
     * Unable to fully structure code
     */
    public void setCaptioningEnabled(boolean var1_1) {
        if (this.mCaptioningEnabled == var1_1) return;
        this.mCaptioningEnabled = var1_1;
        var2_2 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mExtraControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onCaptioningEnabledChanged(var1_1);
lbl11:
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

    public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
    }

    public void setExtras(Bundle bundle) {
        MediaSessionCompatApi21.setExtras((Object)this.mSessionObj, (Bundle)bundle);
    }

    public void setFlags(int n) {
        MediaSessionCompatApi21.setFlags((Object)this.mSessionObj, (int)n);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        MediaSessionCompatApi21.setMediaButtonReceiver((Object)this.mSessionObj, (PendingIntent)pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat object) {
        this.mMetadata = object;
        Object object2 = this.mSessionObj;
        object = object == null ? null : object.getMediaMetadata();
        MediaSessionCompatApi21.setMetadata((Object)object2, (Object)object);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void setPlaybackState(PlaybackStateCompat var1_1) {
        this.mPlaybackState = var1_1 /* !! */ ;
        block2: for (var2_2 = this.mExtraControllerCallbacks.beginBroadcast() - 1; var2_2 >= 0; --var2_2) {
            var3_3 /* !! */  = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3 /* !! */ .onPlaybackStateChanged(var1_1 /* !! */ );
lbl6:
                // 2 sources

                continue block2;
            }
            catch (RemoteException var3_4) {
                ** continue;
            }
        }
        this.mExtraControllerCallbacks.finishBroadcast();
        var3_3 /* !! */  = this.mSessionObj;
        var1_1 /* !! */  = var1_1 /* !! */  == null ? null : var1_1 /* !! */ .getPlaybackState();
        MediaSessionCompatApi21.setPlaybackState((Object)var3_3 /* !! */ , (Object)var1_1 /* !! */ );
    }

    public void setPlaybackToLocal(int n) {
        MediaSessionCompatApi21.setPlaybackToLocal((Object)this.mSessionObj, (int)n);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        MediaSessionCompatApi21.setPlaybackToRemote((Object)this.mSessionObj, (Object)volumeProviderCompat.getVolumeProvider());
    }

    public void setQueue(List<MediaSessionCompat.QueueItem> list) {
        this.mQueue = list;
        if (list != null) {
            ArrayList<MediaSessionCompat.QueueItem> arrayList = new ArrayList<MediaSessionCompat.QueueItem>();
            Iterator<MediaSessionCompat.QueueItem> iterator = list.iterator();
            while (true) {
                list = arrayList;
                if (iterator.hasNext()) {
                    arrayList.add((MediaSessionCompat.QueueItem)iterator.next().getQueueItem());
                    continue;
                }
                break;
            }
        } else {
            list = null;
        }
        MediaSessionCompatApi21.setQueue((Object)this.mSessionObj, list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        MediaSessionCompatApi21.setQueueTitle((Object)this.mSessionObj, (CharSequence)charSequence);
    }

    public void setRatingType(int n) {
        if (Build.VERSION.SDK_INT < 22) {
            this.mRatingType = n;
        } else {
            MediaSessionCompatApi22.setRatingType((Object)this.mSessionObj, (int)n);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void setRepeatMode(int var1_1) {
        if (this.mRepeatMode == var1_1) return;
        this.mRepeatMode = var1_1;
        var2_2 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mExtraControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onRepeatModeChanged(var1_1);
lbl11:
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

    public void setSessionActivity(PendingIntent pendingIntent) {
        MediaSessionCompatApi21.setSessionActivity((Object)this.mSessionObj, (PendingIntent)pendingIntent);
    }

    /*
     * Unable to fully structure code
     */
    public void setShuffleMode(int var1_1) {
        if (this.mShuffleMode == var1_1) return;
        this.mShuffleMode = var1_1;
        var2_2 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        block2: while (true) {
            if (var2_2 < 0) {
                this.mExtraControllerCallbacks.finishBroadcast();
                return;
            }
            var3_3 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(var2_2);
            try {
                var3_3.onShuffleModeChanged(var1_1);
lbl11:
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
}
