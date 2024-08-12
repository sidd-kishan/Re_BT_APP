/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder$DeathRecipient
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.IMediaControllerCallback
 *  android.support.v4.media.session.MediaControllerCompat$Callback$MessageHandler
 *  android.support.v4.media.session.MediaControllerCompat$Callback$StubApi21
 *  android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat
 *  android.support.v4.media.session.MediaControllerCompat$PlaybackInfo
 *  android.support.v4.media.session.MediaControllerCompatApi21
 *  android.support.v4.media.session.MediaControllerCompatApi21$Callback
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.PlaybackStateCompat
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

public static abstract class MediaControllerCompat.Callback
implements IBinder.DeathRecipient {
    final Object mCallbackObj;
    MessageHandler mHandler;
    IMediaControllerCallback mIControllerCallback;

    public MediaControllerCompat.Callback() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.mCallbackObj = MediaControllerCompatApi21.createCallback((MediaControllerCompatApi21.Callback)new StubApi21(this));
        } else {
            StubCompat stubCompat = new StubCompat(this);
            this.mIControllerCallback = stubCompat;
            this.mCallbackObj = stubCompat;
        }
    }

    public void binderDied() {
        this.postToHandler(8, null, null);
    }

    public IMediaControllerCallback getIControllerCallback() {
        return this.mIControllerCallback;
    }

    public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo playbackInfo) {
    }

    public void onCaptioningEnabledChanged(boolean bl) {
    }

    public void onExtrasChanged(Bundle bundle) {
    }

    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
    }

    public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
    }

    public void onRepeatModeChanged(int n) {
    }

    public void onSessionDestroyed() {
    }

    public void onSessionEvent(String string, Bundle bundle) {
    }

    public void onSessionReady() {
    }

    public void onShuffleModeChanged(int n) {
    }

    void postToHandler(int n, Object object, Bundle bundle) {
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler == null) return;
        object = messageHandler.obtainMessage(n, object);
        object.setData(bundle);
        object.sendToTarget();
    }

    void setHandler(Handler handler) {
        if (handler == null) {
            handler = this.mHandler;
            if (handler == null) return;
            handler.mRegistered = false;
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        } else {
            handler = new MessageHandler(this, handler.getLooper());
            this.mHandler = handler;
            handler.mRegistered = true;
        }
    }
}
