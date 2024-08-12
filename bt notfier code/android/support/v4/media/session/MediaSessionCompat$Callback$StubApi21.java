/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.BadParcelableException
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.ResultReceiver
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.media.session.MediaSessionCompatApi21$Callback
 *  android.util.Log
 *  androidx.core.app.BundleCompat
 */
package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.util.Log;
import androidx.core.app.BundleCompat;

/*
 * Exception performing whole class analysis ignored.
 */
private class MediaSessionCompat.Callback.StubApi21
implements MediaSessionCompatApi21.Callback {
    final MediaSessionCompat.Callback this$0;

    MediaSessionCompat.Callback.StubApi21(MediaSessionCompat.Callback callback) {
        this.this$0 = callback;
    }

    public void onCommand(String string, Bundle bundle, ResultReceiver resultReceiver) {
        try {
            boolean bl = string.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER");
            MediaSessionCompat.Token token = null;
            Object var6_7 = null;
            if (bl) {
                string = (MediaSessionCompat.MediaSessionImplApi21)this.this$0.mSessionImpl.get();
                if (string == null) return;
                bundle = new Bundle();
                token = string.getSessionToken();
                string = (string = token.getExtraBinder()) == null ? var6_7 : string.asBinder();
                BundleCompat.putBinder((Bundle)bundle, (String)"android.support.v4.media.session.EXTRA_BINDER", (IBinder)string);
                bundle.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", token.getSessionToken2Bundle());
                resultReceiver.send(0, bundle);
            } else {
                bl = string.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM");
                if (bl) {
                    this.this$0.onAddQueueItem((MediaDescriptionCompat)bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                } else {
                    bl = string.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT");
                    if (bl) {
                        this.this$0.onAddQueueItem((MediaDescriptionCompat)bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                    } else if (string.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        this.this$0.onRemoveQueueItem((MediaDescriptionCompat)bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (string.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        resultReceiver = (MediaSessionCompat.MediaSessionImplApi21)this.this$0.mSessionImpl.get();
                        if (resultReceiver == null) return;
                        if (resultReceiver.mQueue == null) return;
                        int n = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                        string = token;
                        if (n >= 0) {
                            string = token;
                            if (n < resultReceiver.mQueue.size()) {
                                string = (MediaSessionCompat.QueueItem)resultReceiver.mQueue.get(n);
                            }
                        }
                        if (string == null) return;
                        this.this$0.onRemoveQueueItem(string.getDescription());
                    } else {
                        this.this$0.onCommand(string, bundle, resultReceiver);
                    }
                }
            }
        }
        catch (BadParcelableException badParcelableException) {
            Log.e((String)"MediaSessionCompat", (String)"Could not unparcel the extra data.");
        }
    }

    public void onCustomAction(String string, Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
        MediaSessionCompat.ensureClassLoader((Bundle)bundle2);
        if (string.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
            string = (Uri)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
            this.this$0.onPlayFromUri((Uri)string, bundle2);
        } else if (string.equals("android.support.v4.media.session.action.PREPARE")) {
            this.this$0.onPrepare();
        } else if (string.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
            string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
            this.this$0.onPrepareFromMediaId(string, bundle2);
        } else if (string.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
            string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
            this.this$0.onPrepareFromSearch(string, bundle2);
        } else if (string.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
            string = (Uri)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
            this.this$0.onPrepareFromUri((Uri)string, bundle2);
        } else if (string.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
            boolean bl = bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
            this.this$0.onSetCaptioningEnabled(bl);
        } else if (string.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
            int n = bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE");
            this.this$0.onSetRepeatMode(n);
        } else if (string.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
            int n = bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE");
            this.this$0.onSetShuffleMode(n);
        } else if (string.equals("android.support.v4.media.session.action.SET_RATING")) {
            string = (RatingCompat)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
            this.this$0.onSetRating((RatingCompat)string, bundle2);
        } else {
            this.this$0.onCustomAction(string, bundle);
        }
    }

    public void onFastForward() {
        this.this$0.onFastForward();
    }

    public boolean onMediaButtonEvent(Intent intent) {
        return this.this$0.onMediaButtonEvent(intent);
    }

    public void onPause() {
        this.this$0.onPause();
    }

    public void onPlay() {
        this.this$0.onPlay();
    }

    public void onPlayFromMediaId(String string, Bundle bundle) {
        this.this$0.onPlayFromMediaId(string, bundle);
    }

    public void onPlayFromSearch(String string, Bundle bundle) {
        this.this$0.onPlayFromSearch(string, bundle);
    }

    public void onRewind() {
        this.this$0.onRewind();
    }

    public void onSeekTo(long l) {
        this.this$0.onSeekTo(l);
    }

    public void onSetRating(Object object) {
        this.this$0.onSetRating(RatingCompat.fromRating((Object)object));
    }

    public void onSetRating(Object object, Bundle bundle) {
    }

    public void onSkipToNext() {
        this.this$0.onSkipToNext();
    }

    public void onSkipToPrevious() {
        this.this$0.onSkipToPrevious();
    }

    public void onSkipToQueueItem(long l) {
        this.this$0.onSkipToQueueItem(l);
    }

    public void onStop() {
        this.this$0.onStop();
    }
}
