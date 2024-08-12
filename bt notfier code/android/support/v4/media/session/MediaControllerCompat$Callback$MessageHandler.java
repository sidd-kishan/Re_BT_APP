/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.MediaControllerCompat$Callback
 *  android.support.v4.media.session.MediaControllerCompat$PlaybackInfo
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.PlaybackStateCompat
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

private class MediaControllerCompat.Callback.MessageHandler
extends Handler {
    private static final int MSG_DESTROYED = 8;
    private static final int MSG_EVENT = 1;
    private static final int MSG_SESSION_READY = 13;
    private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
    private static final int MSG_UPDATE_EXTRAS = 7;
    private static final int MSG_UPDATE_METADATA = 3;
    private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
    private static final int MSG_UPDATE_QUEUE = 5;
    private static final int MSG_UPDATE_QUEUE_TITLE = 6;
    private static final int MSG_UPDATE_REPEAT_MODE = 9;
    private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
    private static final int MSG_UPDATE_VOLUME = 4;
    boolean mRegistered;
    final MediaControllerCompat.Callback this$0;

    MediaControllerCompat.Callback.MessageHandler(MediaControllerCompat.Callback callback, Looper looper) {
        this.this$0 = callback;
        super(looper);
        this.mRegistered = false;
    }

    public void handleMessage(Message message) {
        if (!this.mRegistered) {
            return;
        }
        switch (message.what) {
            default: {
                break;
            }
            case 13: {
                this.this$0.onSessionReady();
                break;
            }
            case 12: {
                this.this$0.onShuffleModeChanged(((Integer)message.obj).intValue());
                break;
            }
            case 11: {
                this.this$0.onCaptioningEnabledChanged(((Boolean)message.obj).booleanValue());
                break;
            }
            case 9: {
                this.this$0.onRepeatModeChanged(((Integer)message.obj).intValue());
                break;
            }
            case 8: {
                this.this$0.onSessionDestroyed();
                break;
            }
            case 7: {
                message = (Bundle)message.obj;
                MediaSessionCompat.ensureClassLoader((Bundle)message);
                this.this$0.onExtrasChanged((Bundle)message);
                break;
            }
            case 6: {
                this.this$0.onQueueTitleChanged((CharSequence)message.obj);
                break;
            }
            case 5: {
                this.this$0.onQueueChanged((List)message.obj);
                break;
            }
            case 4: {
                this.this$0.onAudioInfoChanged((MediaControllerCompat.PlaybackInfo)message.obj);
                break;
            }
            case 3: {
                this.this$0.onMetadataChanged((MediaMetadataCompat)message.obj);
                break;
            }
            case 2: {
                this.this$0.onPlaybackStateChanged((PlaybackStateCompat)message.obj);
                break;
            }
            case 1: {
                Bundle bundle = message.getData();
                MediaSessionCompat.ensureClassLoader((Bundle)bundle);
                this.this$0.onSessionEvent((String)message.obj, bundle);
            }
        }
    }
}
