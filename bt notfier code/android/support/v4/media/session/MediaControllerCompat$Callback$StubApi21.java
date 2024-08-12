/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.MediaControllerCompat$Callback
 *  android.support.v4.media.session.MediaControllerCompat$PlaybackInfo
 *  android.support.v4.media.session.MediaControllerCompatApi21$Callback
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.PlaybackStateCompat
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import java.lang.ref.WeakReference;
import java.util.List;

private static class MediaControllerCompat.Callback.StubApi21
implements MediaControllerCompatApi21.Callback {
    private final WeakReference<MediaControllerCompat.Callback> mCallback;

    MediaControllerCompat.Callback.StubApi21(MediaControllerCompat.Callback callback) {
        this.mCallback = new WeakReference<MediaControllerCompat.Callback>(callback);
    }

    public void onAudioInfoChanged(int n, int n2, int n3, int n4, int n5) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.onAudioInfoChanged(new MediaControllerCompat.PlaybackInfo(n, n2, n3, n4, n5));
    }

    public void onExtrasChanged(Bundle bundle) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.onExtrasChanged(bundle);
    }

    public void onMetadataChanged(Object object) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata((Object)object));
    }

    public void onPlaybackStateChanged(Object object) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        if (callback.mIControllerCallback != null) return;
        callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState((Object)object));
    }

    public void onQueueChanged(List<?> list) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.onQueueTitleChanged(charSequence);
    }

    public void onSessionDestroyed() {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        callback.onSessionDestroyed();
    }

    public void onSessionEvent(String string, Bundle bundle) {
        MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (callback == null) return;
        if (callback.mIControllerCallback != null && Build.VERSION.SDK_INT < 23) return;
        callback.onSessionEvent(string, bundle);
    }
}
