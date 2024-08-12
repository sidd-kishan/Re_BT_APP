/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.ResultReceiver
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.MediaSessionCompat$Callback$CallbackHandler
 *  android.support.v4.media.session.MediaSessionCompat$Callback$StubApi21
 *  android.support.v4.media.session.MediaSessionCompat$Callback$StubApi23
 *  android.support.v4.media.session.MediaSessionCompat$Callback$StubApi24
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
 *  android.support.v4.media.session.MediaSessionCompatApi21
 *  android.support.v4.media.session.MediaSessionCompatApi21$Callback
 *  android.support.v4.media.session.MediaSessionCompatApi23
 *  android.support.v4.media.session.MediaSessionCompatApi23$Callback
 *  android.support.v4.media.session.MediaSessionCompatApi24
 *  android.support.v4.media.session.MediaSessionCompatApi24$Callback
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.view.KeyEvent
 *  android.view.ViewConfiguration
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.MediaSessionCompatApi23;
import android.support.v4.media.session.MediaSessionCompatApi24;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.media.MediaSessionManager;
import java.lang.ref.WeakReference;

public static abstract class MediaSessionCompat.Callback {
    private CallbackHandler mCallbackHandler = null;
    final Object mCallbackObj = Build.VERSION.SDK_INT >= 24 ? MediaSessionCompatApi24.createCallback((MediaSessionCompatApi24.Callback)new StubApi24(this)) : (Build.VERSION.SDK_INT >= 23 ? MediaSessionCompatApi23.createCallback((MediaSessionCompatApi23.Callback)new StubApi23(this)) : (Build.VERSION.SDK_INT >= 21 ? MediaSessionCompatApi21.createCallback((MediaSessionCompatApi21.Callback)new StubApi21(this)) : null));
    private boolean mMediaPlayPauseKeyPending;
    WeakReference<MediaSessionCompat.MediaSessionImpl> mSessionImpl;

    void handleMediaPlayPauseKeySingleTapIfPending(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        if (!this.mMediaPlayPauseKeyPending) {
            return;
        }
        boolean bl = false;
        this.mMediaPlayPauseKeyPending = false;
        this.mCallbackHandler.removeMessages(1);
        MediaSessionCompat.MediaSessionImpl mediaSessionImpl = (MediaSessionCompat.MediaSessionImpl)this.mSessionImpl.get();
        if (mediaSessionImpl == null) {
            return;
        }
        PlaybackStateCompat playbackStateCompat = mediaSessionImpl.getPlaybackState();
        long l = playbackStateCompat == null ? 0L : playbackStateCompat.getActions();
        boolean bl2 = playbackStateCompat != null && playbackStateCompat.getState() == 3;
        boolean bl3 = (0x204L & l) != 0L;
        if ((l & 0x202L) != 0L) {
            bl = true;
        }
        mediaSessionImpl.setCurrentControllerInfo(remoteUserInfo);
        if (bl2 && bl) {
            this.onPause();
        } else if (!bl2 && bl3) {
            this.onPlay();
        }
        mediaSessionImpl.setCurrentControllerInfo(null);
    }

    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int n) {
    }

    public void onCommand(String string, Bundle bundle, ResultReceiver resultReceiver) {
    }

    public void onCustomAction(String string, Bundle bundle) {
    }

    public void onFastForward() {
    }

    public boolean onMediaButtonEvent(Intent intent) {
        if (Build.VERSION.SDK_INT >= 27) {
            return false;
        }
        MediaSessionCompat.MediaSessionImpl mediaSessionImpl = (MediaSessionCompat.MediaSessionImpl)this.mSessionImpl.get();
        if (mediaSessionImpl == null) return false;
        if (this.mCallbackHandler == null) return false;
        KeyEvent keyEvent = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) return false;
        if (keyEvent.getAction() != 0) return false;
        intent = mediaSessionImpl.getCurrentControllerInfo();
        int n = keyEvent.getKeyCode();
        if (n != 79 && n != 85) {
            this.handleMediaPlayPauseKeySingleTapIfPending((MediaSessionManager.RemoteUserInfo)intent);
            return false;
        }
        if (keyEvent.getRepeatCount() > 0) {
            this.handleMediaPlayPauseKeySingleTapIfPending((MediaSessionManager.RemoteUserInfo)intent);
        } else if (this.mMediaPlayPauseKeyPending) {
            this.mCallbackHandler.removeMessages(1);
            this.mMediaPlayPauseKeyPending = false;
            intent = mediaSessionImpl.getPlaybackState();
            long l = intent == null ? 0L : intent.getActions();
            if ((l & 0x20L) == 0L) return true;
            this.onSkipToNext();
        } else {
            this.mMediaPlayPauseKeyPending = true;
            mediaSessionImpl = this.mCallbackHandler;
            mediaSessionImpl.sendMessageDelayed(mediaSessionImpl.obtainMessage(1, (Object)intent), (long)ViewConfiguration.getDoubleTapTimeout());
        }
        return true;
    }

    public void onPause() {
    }

    public void onPlay() {
    }

    public void onPlayFromMediaId(String string, Bundle bundle) {
    }

    public void onPlayFromSearch(String string, Bundle bundle) {
    }

    public void onPlayFromUri(Uri uri, Bundle bundle) {
    }

    public void onPrepare() {
    }

    public void onPrepareFromMediaId(String string, Bundle bundle) {
    }

    public void onPrepareFromSearch(String string, Bundle bundle) {
    }

    public void onPrepareFromUri(Uri uri, Bundle bundle) {
    }

    public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    @Deprecated
    public void onRemoveQueueItemAt(int n) {
    }

    public void onRewind() {
    }

    public void onSeekTo(long l) {
    }

    public void onSetCaptioningEnabled(boolean bl) {
    }

    public void onSetRating(RatingCompat ratingCompat) {
    }

    public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
    }

    public void onSetRepeatMode(int n) {
    }

    public void onSetShuffleMode(int n) {
    }

    public void onSkipToNext() {
    }

    public void onSkipToPrevious() {
    }

    public void onSkipToQueueItem(long l) {
    }

    public void onStop() {
    }

    void setSessionImpl(MediaSessionCompat.MediaSessionImpl mediaSessionImpl, Handler handler) {
        this.mSessionImpl = new WeakReference<MediaSessionCompat.MediaSessionImpl>(mediaSessionImpl);
        mediaSessionImpl = this.mCallbackHandler;
        if (mediaSessionImpl != null) {
            mediaSessionImpl.removeCallbacksAndMessages(null);
        }
        this.mCallbackHandler = new CallbackHandler(this, handler.getLooper());
    }
}
