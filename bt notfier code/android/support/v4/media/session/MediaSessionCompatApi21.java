/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.media.AudioAttributes$Builder
 *  android.media.MediaMetadata
 *  android.media.VolumeProvider
 *  android.media.session.MediaSession
 *  android.media.session.MediaSession$Callback
 *  android.media.session.MediaSession$QueueItem
 *  android.media.session.MediaSession$Token
 *  android.media.session.PlaybackState
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.support.v4.media.session.MediaSessionCompatApi21$Callback
 *  android.support.v4.media.session.MediaSessionCompatApi21$CallbackProxy
 *  android.util.Log
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class MediaSessionCompatApi21 {
    static final String TAG = "MediaSessionCompatApi21";

    private MediaSessionCompatApi21() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static Object createSession(Context context, String string) {
        return new MediaSession(context, string);
    }

    public static Parcelable getSessionToken(Object object) {
        return ((MediaSession)object).getSessionToken();
    }

    public static boolean hasCallback(Object object) {
        boolean bl = false;
        try {
            Field field = object.getClass().getDeclaredField("mCallback");
            if (field == null) return false;
            field.setAccessible(true);
            object = field.get(object);
            if (object == null) return bl;
            bl = true;
            return bl;
        }
        catch (IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
            Log.w((String)TAG, (String)"Failed to get mCallback object.");
        }
        return false;
    }

    public static boolean isActive(Object object) {
        return ((MediaSession)object).isActive();
    }

    public static void release(Object object) {
        ((MediaSession)object).release();
    }

    public static void sendSessionEvent(Object object, String string, Bundle bundle) {
        ((MediaSession)object).sendSessionEvent(string, bundle);
    }

    public static void setActive(Object object, boolean bl) {
        ((MediaSession)object).setActive(bl);
    }

    public static void setCallback(Object object, Object object2, Handler handler) {
        ((MediaSession)object).setCallback((MediaSession.Callback)object2, handler);
    }

    public static void setExtras(Object object, Bundle bundle) {
        ((MediaSession)object).setExtras(bundle);
    }

    public static void setFlags(Object object, int n) {
        ((MediaSession)object).setFlags(n);
    }

    public static void setMediaButtonReceiver(Object object, PendingIntent pendingIntent) {
        ((MediaSession)object).setMediaButtonReceiver(pendingIntent);
    }

    public static void setMetadata(Object object, Object object2) {
        ((MediaSession)object).setMetadata((MediaMetadata)object2);
    }

    public static void setPlaybackState(Object object, Object object2) {
        ((MediaSession)object).setPlaybackState((PlaybackState)object2);
    }

    public static void setPlaybackToLocal(Object object, int n) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(n);
        ((MediaSession)object).setPlaybackToLocal(builder.build());
    }

    public static void setPlaybackToRemote(Object object, Object object2) {
        ((MediaSession)object).setPlaybackToRemote((VolumeProvider)object2);
    }

    public static void setQueue(Object object, List<Object> object2) {
        if (object2 == null) {
            ((MediaSession)object).setQueue(null);
            return;
        }
        ArrayList<MediaSession.QueueItem> arrayList = new ArrayList<MediaSession.QueueItem>();
        object2 = object2.iterator();
        while (true) {
            if (!object2.hasNext()) {
                ((MediaSession)object).setQueue(arrayList);
                return;
            }
            arrayList.add((MediaSession.QueueItem)object2.next());
        }
    }

    public static void setQueueTitle(Object object, CharSequence charSequence) {
        ((MediaSession)object).setQueueTitle(charSequence);
    }

    public static void setSessionActivity(Object object, PendingIntent pendingIntent) {
        ((MediaSession)object).setSessionActivity(pendingIntent);
    }

    public static Object verifySession(Object object) {
        if (!(object instanceof MediaSession)) throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        return object;
    }

    public static Object verifyToken(Object object) {
        if (!(object instanceof MediaSession.Token)) throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        return object;
    }
}
