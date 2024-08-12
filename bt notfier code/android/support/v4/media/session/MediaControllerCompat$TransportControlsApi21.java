/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.MediaControllerCompat
 *  android.support.v4.media.session.MediaControllerCompat$TransportControls
 *  android.support.v4.media.session.MediaControllerCompatApi21$TransportControls
 *  android.support.v4.media.session.PlaybackStateCompat$CustomAction
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.PlaybackStateCompat;

/*
 * Exception performing whole class analysis ignored.
 */
static class MediaControllerCompat.TransportControlsApi21
extends MediaControllerCompat.TransportControls {
    protected final Object mControlsObj;

    public MediaControllerCompat.TransportControlsApi21(Object object) {
        this.mControlsObj = object;
    }

    public void fastForward() {
        MediaControllerCompatApi21.TransportControls.fastForward((Object)this.mControlsObj);
    }

    public void pause() {
        MediaControllerCompatApi21.TransportControls.pause((Object)this.mControlsObj);
    }

    public void play() {
        MediaControllerCompatApi21.TransportControls.play((Object)this.mControlsObj);
    }

    public void playFromMediaId(String string, Bundle bundle) {
        MediaControllerCompatApi21.TransportControls.playFromMediaId((Object)this.mControlsObj, (String)string, (Bundle)bundle);
    }

    public void playFromSearch(String string, Bundle bundle) {
        MediaControllerCompatApi21.TransportControls.playFromSearch((Object)this.mControlsObj, (String)string, (Bundle)bundle);
    }

    public void playFromUri(Uri uri, Bundle bundle) {
        if (uri == null) throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        if (Uri.EMPTY.equals((Object)uri)) throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", (Parcelable)uri);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", bundle2);
    }

    public void prepare() {
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
    }

    public void prepareFromMediaId(String string, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", string);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", bundle2);
    }

    public void prepareFromSearch(String string, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", string);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", bundle2);
    }

    public void prepareFromUri(Uri uri, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", (Parcelable)uri);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", bundle2);
    }

    public void rewind() {
        MediaControllerCompatApi21.TransportControls.rewind((Object)this.mControlsObj);
    }

    public void seekTo(long l) {
        MediaControllerCompatApi21.TransportControls.seekTo((Object)this.mControlsObj, (long)l);
    }

    public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
        MediaControllerCompat.validateCustomAction((String)customAction.getAction(), (Bundle)bundle);
        MediaControllerCompatApi21.TransportControls.sendCustomAction((Object)this.mControlsObj, (String)customAction.getAction(), (Bundle)bundle);
    }

    public void sendCustomAction(String string, Bundle bundle) {
        MediaControllerCompat.validateCustomAction((String)string, (Bundle)bundle);
        MediaControllerCompatApi21.TransportControls.sendCustomAction((Object)this.mControlsObj, (String)string, (Bundle)bundle);
    }

    public void setCaptioningEnabled(boolean bl) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", bl);
        this.sendCustomAction("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", bundle);
    }

    public void setRating(RatingCompat object) {
        Object object2 = this.mControlsObj;
        object = object != null ? object.getRating() : null;
        MediaControllerCompatApi21.TransportControls.setRating((Object)object2, (Object)object);
    }

    public void setRating(RatingCompat ratingCompat, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_RATING", (Parcelable)ratingCompat);
        bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
        this.sendCustomAction("android.support.v4.media.session.action.SET_RATING", bundle2);
    }

    public void setRepeatMode(int n) {
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", n);
        this.sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
    }

    public void setShuffleMode(int n) {
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", n);
        this.sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle);
    }

    public void skipToNext() {
        MediaControllerCompatApi21.TransportControls.skipToNext((Object)this.mControlsObj);
    }

    public void skipToPrevious() {
        MediaControllerCompatApi21.TransportControls.skipToPrevious((Object)this.mControlsObj);
    }

    public void skipToQueueItem(long l) {
        MediaControllerCompatApi21.TransportControls.skipToQueueItem((Object)this.mControlsObj, (long)l);
    }

    public void stop() {
        MediaControllerCompatApi21.TransportControls.stop((Object)this.mControlsObj);
    }
}
