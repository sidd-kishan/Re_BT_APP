/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.media.Rating
 *  android.media.session.MediaSession$Callback
 *  android.os.Bundle
 *  android.os.ResultReceiver
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompatApi21$Callback
 */
package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompatApi21;

static class MediaSessionCompatApi21.CallbackProxy<T extends MediaSessionCompatApi21.Callback>
extends MediaSession.Callback {
    protected final T mCallback;

    public MediaSessionCompatApi21.CallbackProxy(T t) {
        this.mCallback = t;
    }

    public void onCommand(String string, Bundle bundle, ResultReceiver resultReceiver) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        this.mCallback.onCommand(string, bundle, resultReceiver);
    }

    public void onCustomAction(String string, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        this.mCallback.onCustomAction(string, bundle);
    }

    public void onFastForward() {
        this.mCallback.onFastForward();
    }

    public boolean onMediaButtonEvent(Intent intent) {
        boolean bl = this.mCallback.onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent);
        return bl;
    }

    public void onPause() {
        this.mCallback.onPause();
    }

    public void onPlay() {
        this.mCallback.onPlay();
    }

    public void onPlayFromMediaId(String string, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        this.mCallback.onPlayFromMediaId(string, bundle);
    }

    public void onPlayFromSearch(String string, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        this.mCallback.onPlayFromSearch(string, bundle);
    }

    public void onRewind() {
        this.mCallback.onRewind();
    }

    public void onSeekTo(long l) {
        this.mCallback.onSeekTo(l);
    }

    public void onSetRating(Rating rating) {
        this.mCallback.onSetRating((Object)rating);
    }

    public void onSkipToNext() {
        this.mCallback.onSkipToNext();
    }

    public void onSkipToPrevious() {
        this.mCallback.onSkipToPrevious();
    }

    public void onSkipToQueueItem(long l) {
        this.mCallback.onSkipToQueueItem(l);
    }

    public void onStop() {
        this.mCallback.onStop();
    }
}
