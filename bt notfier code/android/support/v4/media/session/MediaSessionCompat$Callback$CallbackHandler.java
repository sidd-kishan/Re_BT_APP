/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package android.support.v4.media.session;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaSessionManager;

private class MediaSessionCompat.Callback.CallbackHandler
extends Handler {
    private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;
    final MediaSessionCompat.Callback this$0;

    MediaSessionCompat.Callback.CallbackHandler(MediaSessionCompat.Callback callback, Looper looper) {
        this.this$0 = callback;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what != 1) return;
        this.this$0.handleMediaPlayPauseKeySingleTapIfPending((MediaSessionManager.RemoteUserInfo)message.obj);
    }
}
