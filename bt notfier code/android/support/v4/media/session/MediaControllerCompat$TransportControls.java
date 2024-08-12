/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.PlaybackStateCompat$CustomAction
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.PlaybackStateCompat;

public static abstract class MediaControllerCompat.TransportControls {
    public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

    MediaControllerCompat.TransportControls() {
    }

    public abstract void fastForward();

    public abstract void pause();

    public abstract void play();

    public abstract void playFromMediaId(String var1, Bundle var2);

    public abstract void playFromSearch(String var1, Bundle var2);

    public abstract void playFromUri(Uri var1, Bundle var2);

    public abstract void prepare();

    public abstract void prepareFromMediaId(String var1, Bundle var2);

    public abstract void prepareFromSearch(String var1, Bundle var2);

    public abstract void prepareFromUri(Uri var1, Bundle var2);

    public abstract void rewind();

    public abstract void seekTo(long var1);

    public abstract void sendCustomAction(PlaybackStateCompat.CustomAction var1, Bundle var2);

    public abstract void sendCustomAction(String var1, Bundle var2);

    public abstract void setCaptioningEnabled(boolean var1);

    public abstract void setRating(RatingCompat var1);

    public abstract void setRating(RatingCompat var1, Bundle var2);

    public abstract void setRepeatMode(int var1);

    public abstract void setShuffleMode(int var1);

    public abstract void skipToNext();

    public abstract void skipToPrevious();

    public abstract void skipToQueueItem(long var1);

    public abstract void stop();
}
