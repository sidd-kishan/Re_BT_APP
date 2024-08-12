/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.media.session.MediaController
 *  android.media.session.MediaController$Callback
 *  android.media.session.MediaSession$Token
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.ResultReceiver
 *  android.support.v4.media.session.MediaControllerCompatApi21$Callback
 *  android.support.v4.media.session.MediaControllerCompatApi21$CallbackProxy
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class MediaControllerCompatApi21 {
    private MediaControllerCompatApi21() {
    }

    public static void adjustVolume(Object object, int n, int n2) {
        ((MediaController)object).adjustVolume(n, n2);
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static boolean dispatchMediaButtonEvent(Object object, KeyEvent keyEvent) {
        return ((MediaController)object).dispatchMediaButtonEvent(keyEvent);
    }

    public static Object fromToken(Context context, Object object) {
        return new MediaController(context, (MediaSession.Token)object);
    }

    public static Bundle getExtras(Object object) {
        return ((MediaController)object).getExtras();
    }

    public static long getFlags(Object object) {
        return ((MediaController)object).getFlags();
    }

    public static Object getMediaController(Activity activity) {
        return activity.getMediaController();
    }

    public static Object getMetadata(Object object) {
        return ((MediaController)object).getMetadata();
    }

    public static String getPackageName(Object object) {
        return ((MediaController)object).getPackageName();
    }

    public static Object getPlaybackInfo(Object object) {
        return ((MediaController)object).getPlaybackInfo();
    }

    public static Object getPlaybackState(Object object) {
        return ((MediaController)object).getPlaybackState();
    }

    public static List<Object> getQueue(Object object) {
        if ((object = ((MediaController)object).getQueue()) != null) return new ArrayList<Object>((Collection<Object>)object);
        return null;
    }

    public static CharSequence getQueueTitle(Object object) {
        return ((MediaController)object).getQueueTitle();
    }

    public static int getRatingType(Object object) {
        return ((MediaController)object).getRatingType();
    }

    public static PendingIntent getSessionActivity(Object object) {
        return ((MediaController)object).getSessionActivity();
    }

    public static Object getSessionToken(Object object) {
        return ((MediaController)object).getSessionToken();
    }

    public static Object getTransportControls(Object object) {
        return ((MediaController)object).getTransportControls();
    }

    public static void registerCallback(Object object, Object object2, Handler handler) {
        ((MediaController)object).registerCallback((MediaController.Callback)object2, handler);
    }

    public static void sendCommand(Object object, String string, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController)object).sendCommand(string, bundle, resultReceiver);
    }

    public static void setMediaController(Activity activity, Object object) {
        activity.setMediaController((MediaController)object);
    }

    public static void setVolumeTo(Object object, int n, int n2) {
        ((MediaController)object).setVolumeTo(n, n2);
    }

    public static void unregisterCallback(Object object, Object object2) {
        ((MediaController)object).unregisterCallback((MediaController.Callback)object2);
    }
}
