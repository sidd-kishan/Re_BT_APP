/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.IMediaSession
 *  android.support.v4.media.session.MediaControllerCompat
 *  android.support.v4.media.session.MediaControllerCompat$TransportControls
 *  android.support.v4.media.session.PlaybackStateCompat$CustomAction
 *  android.util.Log
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;

/*
 * Exception performing whole class analysis ignored.
 */
static class MediaControllerCompat.TransportControlsBase
extends MediaControllerCompat.TransportControls {
    private IMediaSession mBinder;

    public MediaControllerCompat.TransportControlsBase(IMediaSession iMediaSession) {
        this.mBinder = iMediaSession;
    }

    public void fastForward() {
        try {
            this.mBinder.fastForward();
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in fastForward.", (Throwable)remoteException);
        }
    }

    public void pause() {
        try {
            this.mBinder.pause();
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in pause.", (Throwable)remoteException);
        }
    }

    public void play() {
        try {
            this.mBinder.play();
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in play.", (Throwable)remoteException);
        }
    }

    public void playFromMediaId(String string, Bundle bundle) {
        try {
            this.mBinder.playFromMediaId(string, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in playFromMediaId.", (Throwable)remoteException);
        }
    }

    public void playFromSearch(String string, Bundle bundle) {
        try {
            this.mBinder.playFromSearch(string, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in playFromSearch.", (Throwable)remoteException);
        }
    }

    public void playFromUri(Uri uri, Bundle bundle) {
        try {
            this.mBinder.playFromUri(uri, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in playFromUri.", (Throwable)remoteException);
        }
    }

    public void prepare() {
        try {
            this.mBinder.prepare();
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in prepare.", (Throwable)remoteException);
        }
    }

    public void prepareFromMediaId(String string, Bundle bundle) {
        try {
            this.mBinder.prepareFromMediaId(string, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in prepareFromMediaId.", (Throwable)remoteException);
        }
    }

    public void prepareFromSearch(String string, Bundle bundle) {
        try {
            this.mBinder.prepareFromSearch(string, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in prepareFromSearch.", (Throwable)remoteException);
        }
    }

    public void prepareFromUri(Uri uri, Bundle bundle) {
        try {
            this.mBinder.prepareFromUri(uri, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in prepareFromUri.", (Throwable)remoteException);
        }
    }

    public void rewind() {
        try {
            this.mBinder.rewind();
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in rewind.", (Throwable)remoteException);
        }
    }

    public void seekTo(long l) {
        try {
            this.mBinder.seekTo(l);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in seekTo.", (Throwable)remoteException);
        }
    }

    public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
        this.sendCustomAction(customAction.getAction(), bundle);
    }

    public void sendCustomAction(String string, Bundle bundle) {
        MediaControllerCompat.validateCustomAction((String)string, (Bundle)bundle);
        try {
            this.mBinder.sendCustomAction(string, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in sendCustomAction.", (Throwable)remoteException);
        }
    }

    public void setCaptioningEnabled(boolean bl) {
        try {
            this.mBinder.setCaptioningEnabled(bl);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in setCaptioningEnabled.", (Throwable)remoteException);
        }
    }

    public void setRating(RatingCompat ratingCompat) {
        try {
            this.mBinder.rate(ratingCompat);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in setRating.", (Throwable)remoteException);
        }
    }

    public void setRating(RatingCompat ratingCompat, Bundle bundle) {
        try {
            this.mBinder.rateWithExtras(ratingCompat, bundle);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in setRating.", (Throwable)remoteException);
        }
    }

    public void setRepeatMode(int n) {
        try {
            this.mBinder.setRepeatMode(n);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in setRepeatMode.", (Throwable)remoteException);
        }
    }

    public void setShuffleMode(int n) {
        try {
            this.mBinder.setShuffleMode(n);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in setShuffleMode.", (Throwable)remoteException);
        }
    }

    public void skipToNext() {
        try {
            this.mBinder.next();
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in skipToNext.", (Throwable)remoteException);
        }
    }

    public void skipToPrevious() {
        try {
            this.mBinder.previous();
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in skipToPrevious.", (Throwable)remoteException);
        }
    }

    public void skipToQueueItem(long l) {
        try {
            this.mBinder.skipToQueueItem(l);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in skipToQueueItem.", (Throwable)remoteException);
        }
    }

    public void stop() {
        try {
            this.mBinder.stop();
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaControllerCompat", (String)"Dead object in stop.", (Throwable)remoteException);
        }
    }
}
