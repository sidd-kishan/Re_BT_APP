/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Parcelable
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.util.Log
 *  android.view.KeyEvent
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.MediaSessionManager;

/*
 * Exception performing whole class analysis ignored.
 */
class MediaSessionCompat.MediaSessionImplBase.MessageHandler
extends Handler {
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    private static final int MSG_ADD_QUEUE_ITEM = 25;
    private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
    private static final int MSG_ADJUST_VOLUME = 2;
    private static final int MSG_COMMAND = 1;
    private static final int MSG_CUSTOM_ACTION = 20;
    private static final int MSG_FAST_FORWARD = 16;
    private static final int MSG_MEDIA_BUTTON = 21;
    private static final int MSG_NEXT = 14;
    private static final int MSG_PAUSE = 12;
    private static final int MSG_PLAY = 7;
    private static final int MSG_PLAY_MEDIA_ID = 8;
    private static final int MSG_PLAY_SEARCH = 9;
    private static final int MSG_PLAY_URI = 10;
    private static final int MSG_PREPARE = 3;
    private static final int MSG_PREPARE_MEDIA_ID = 4;
    private static final int MSG_PREPARE_SEARCH = 5;
    private static final int MSG_PREPARE_URI = 6;
    private static final int MSG_PREVIOUS = 15;
    private static final int MSG_RATE = 19;
    private static final int MSG_RATE_EXTRA = 31;
    private static final int MSG_REMOVE_QUEUE_ITEM = 27;
    private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
    private static final int MSG_REWIND = 17;
    private static final int MSG_SEEK_TO = 18;
    private static final int MSG_SET_CAPTIONING_ENABLED = 29;
    private static final int MSG_SET_REPEAT_MODE = 23;
    private static final int MSG_SET_SHUFFLE_MODE = 30;
    private static final int MSG_SET_VOLUME = 22;
    private static final int MSG_SKIP_TO_ITEM = 11;
    private static final int MSG_STOP = 13;
    final MediaSessionCompat.MediaSessionImplBase this$0;

    public MediaSessionCompat.MediaSessionImplBase.MessageHandler(MediaSessionCompat.MediaSessionImplBase mediaSessionImplBase, Looper looper) {
        this.this$0 = mediaSessionImplBase;
        super(looper);
    }

    /*
     * Unable to fully structure code
     */
    private void onMediaButtonEvent(KeyEvent var1_1, MediaSessionCompat.Callback var2_2) {
        if (var1_1 == null) return;
        if (var1_1.getAction() != 0) return;
        var4_3 = this.this$0.mState == null ? 0L : this.this$0.mState.getActions();
        var3_4 = var1_1.getKeyCode();
        if (var3_4 == 79) ** GOTO lbl-1000
        if (var3_4 == 126) ** GOTO lbl34
        if (var3_4 == 127) ** GOTO lbl31
        switch (var3_4) {
            default: {
                break;
            }
            case 90: {
                if ((var4_3 & 64L) == 0L) return;
                var2_2.onFastForward();
                break;
            }
            case 89: {
                if ((var4_3 & 8L) == 0L) return;
                var2_2.onRewind();
                break;
            }
            case 88: {
                if ((var4_3 & 16L) == 0L) return;
                var2_2.onSkipToPrevious();
                break;
            }
            case 87: {
                if ((var4_3 & 32L) == 0L) return;
                var2_2.onSkipToNext();
                break;
            }
            case 86: {
                if ((var4_3 & 1L) == 0L) return;
                var2_2.onStop();
                break;
            }
lbl31:
            // 1 sources

            if ((var4_3 & 2L) == 0L) return;
            var2_2.onPause();
            break;
lbl34:
            // 1 sources

            if ((var4_3 & 4L) == 0L) return;
            var2_2.onPlay();
            break;
            case 85: lbl-1000:
            // 2 sources

            {
                Log.w((String)"MediaSessionCompat", (String)"KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
            }
        }
    }

    /*
     * Enabled force condition propagation
     */
    public void handleMessage(Message object) {
        MediaSessionCompat.Callback callback = this.this$0.mCallback;
        if (callback == null) {
            return;
        }
        Bundle bundle = object.getData();
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        this.this$0.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(bundle.getString("data_calling_pkg"), bundle.getInt("data_calling_pid"), bundle.getInt("data_calling_uid")));
        bundle = bundle.getBundle("data_extras");
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        try {
            switch (object.what) {
                default: {
                    return;
                }
                case 31: {
                    callback.onSetRating((RatingCompat)object.obj, bundle);
                    return;
                }
                case 30: {
                    callback.onSetShuffleMode(object.arg1);
                    return;
                }
                case 29: {
                    callback.onSetCaptioningEnabled(((Boolean)object.obj).booleanValue());
                    return;
                }
                case 28: {
                    if (this.this$0.mQueue == null) return;
                    object = object.arg1 >= 0 && object.arg1 < this.this$0.mQueue.size() ? (MediaSessionCompat.QueueItem)this.this$0.mQueue.get(object.arg1) : null;
                    if (object == null) return;
                    callback.onRemoveQueueItem(object.getDescription());
                    return;
                }
                case 27: {
                    callback.onRemoveQueueItem((MediaDescriptionCompat)object.obj);
                    return;
                }
                case 26: {
                    callback.onAddQueueItem((MediaDescriptionCompat)object.obj, object.arg1);
                    return;
                }
                case 25: {
                    callback.onAddQueueItem((MediaDescriptionCompat)object.obj);
                    return;
                }
                case 23: {
                    callback.onSetRepeatMode(object.arg1);
                    return;
                }
                case 22: {
                    this.this$0.setVolumeTo(object.arg1, 0);
                    return;
                }
                case 21: {
                    bundle = (KeyEvent)object.obj;
                    object = new Intent("android.intent.action.MEDIA_BUTTON");
                    object.putExtra("android.intent.extra.KEY_EVENT", (Parcelable)bundle);
                    if (callback.onMediaButtonEvent((Intent)object)) return;
                    this.onMediaButtonEvent((KeyEvent)bundle, callback);
                    return;
                }
                case 20: {
                    callback.onCustomAction((String)object.obj, bundle);
                    return;
                }
                case 19: {
                    callback.onSetRating((RatingCompat)object.obj);
                    return;
                }
                case 18: {
                    callback.onSeekTo(((Long)object.obj).longValue());
                    return;
                }
                case 17: {
                    callback.onRewind();
                    return;
                }
                case 16: {
                    callback.onFastForward();
                    return;
                }
                case 15: {
                    callback.onSkipToPrevious();
                    return;
                }
                case 14: {
                    callback.onSkipToNext();
                    return;
                }
                case 13: {
                    callback.onStop();
                    return;
                }
                case 12: {
                    callback.onPause();
                    return;
                }
                case 11: {
                    callback.onSkipToQueueItem(((Long)object.obj).longValue());
                    return;
                }
                case 10: {
                    callback.onPlayFromUri((Uri)object.obj, bundle);
                    return;
                }
                case 9: {
                    callback.onPlayFromSearch((String)object.obj, bundle);
                    return;
                }
                case 8: {
                    callback.onPlayFromMediaId((String)object.obj, bundle);
                    return;
                }
                case 7: {
                    callback.onPlay();
                    return;
                }
                case 6: {
                    callback.onPrepareFromUri((Uri)object.obj, bundle);
                    return;
                }
                case 5: {
                    callback.onPrepareFromSearch((String)object.obj, bundle);
                    return;
                }
                case 4: {
                    callback.onPrepareFromMediaId((String)object.obj, bundle);
                    return;
                }
                case 3: {
                    callback.onPrepare();
                    return;
                }
                case 2: {
                    this.this$0.adjustVolume(object.arg1, 0);
                    return;
                }
                case 1: 
            }
            object = (MediaSessionCompat.MediaSessionImplBase.Command)object.obj;
            callback.onCommand(object.command, object.extras, object.stub);
            return;
        }
        finally {
            this.this$0.setCurrentControllerInfo(null);
        }
    }
}
