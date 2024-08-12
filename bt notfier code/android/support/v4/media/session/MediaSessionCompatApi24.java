/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaSession
 *  android.support.v4.media.session.MediaSessionCompatApi24$Callback
 *  android.support.v4.media.session.MediaSessionCompatApi24$CallbackProxy
 *  android.util.Log
 */
package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.support.v4.media.session.MediaSessionCompatApi24;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

class MediaSessionCompatApi24 {
    private static final String TAG = "MediaSessionCompatApi24";

    private MediaSessionCompatApi24() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    /*
     * WARNING - void declaration
     */
    public static String getCallingPackage(Object object) {
        void var0_4;
        object = (MediaSession)object;
        try {
            object = (String)object.getClass().getMethod("getCallingPackage", new Class[0]).invoke(object, new Object[0]);
            return object;
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (NoSuchMethodException noSuchMethodException) {
            // empty catch block
        }
        Log.e((String)TAG, (String)"Cannot execute MediaSession.getCallingPackage()", (Throwable)var0_4);
        return null;
    }
}
